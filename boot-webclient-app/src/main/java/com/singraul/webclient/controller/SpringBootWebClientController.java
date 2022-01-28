package com.singraul.webclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.singraul.webclient.model.User;

import reactor.core.publisher.Mono;

// https://www.learninjava.com/spring-webclient-get-post-put-delete-example/
@RestController
@RequestMapping("/microservice/webclient")
public class SpringBootWebClientController {
	@Autowired
	WebClient createWebClient;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/v1/post/{id}")
	public ResponseEntity<Mono<User>> getPost(@PathVariable String id) {

		Mono<User> postMono = createWebClient.get().uri("/posts/" + id).retrieve().bodyToMono(User.class);

		return new ResponseEntity(postMono, HttpStatus.OK);
	}

	@PostMapping(path = "/v1/post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<User> createPost(@RequestBody User post) {

		return createWebClient.post().uri("/posts").header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(BodyInserters.fromValue(post)).retrieve().bodyToMono(User.class);
	}

	@PutMapping(path = "/v1/post", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<User> updatePost(@RequestBody User post) {

		return createWebClient.put().uri("/posts/1").header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(BodyInserters.fromValue(post)).retrieve().bodyToMono(User.class);
	}

	@DeleteMapping(path = "/v1/post/{id}")
	public Mono<User> deletePost(@PathVariable String id) {

		return createWebClient.delete().uri("/posts/" + id).retrieve().bodyToMono(User.class);
	}
}
