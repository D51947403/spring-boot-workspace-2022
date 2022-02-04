package com.singraul.cloud.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.singraul.cloud.dto.UserResponse;

@FeignClient(url = "https://jsonplaceholder.typicode.com", name = "USER-CLIENT")
public interface UserClientService {

	@GetMapping("/users")
	List<UserResponse> findAllUser();

	@GetMapping("/comments")
	List<UserResponse> findComments();

}
