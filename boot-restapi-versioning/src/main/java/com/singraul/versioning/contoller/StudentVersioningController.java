package com.singraul.versioning.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singraul.versioning.model.Name;
import com.singraul.versioning.model.StudentV1;
import com.singraul.versioning.model.StudentV2;

@RestController
public class StudentVersioningController {

	// URI based versioning
	@GetMapping("/v1/student")
	public StudentV1 getStudentV1() {

		return new StudentV1("Devendra");
	}

	@GetMapping("/v2/student")
	public StudentV2 getStudentV2() {
		return new StudentV2(new Name("Devendra", "Kumar"));
	}

	// Request Parameter based versioning
	@GetMapping(value = "/student/param", params = "version=1")
	public StudentV1 getStudentV1_param() {

		return new StudentV1("Devendra");
	}

	@GetMapping(value = "/student/param", params = "version=2")
	public StudentV2 getStudentV2_param() {
		return new StudentV2(new Name("Devendra", "Kumar"));
	}

	// (Custom) Header based versioning
	@GetMapping(value = "/student/header", headers = "X-API-VERSION=1")
	public StudentV1 getStudentV1_header() {

		return new StudentV1("Devendra");
	}

	@GetMapping(value = "/student/header", headers = "X-API-VERSION=2")
	public StudentV2 getStudentV2_header() {
		return new StudentV2(new Name("Devendra", "Kumar"));
	}

	// Media Type based versioning
	@GetMapping(value = "/student/produce", produces = "application/vnd.company.app-v1+json")
	public StudentV1 getStudentV1_media() {

		return new StudentV1("Devendra");
	}

	@GetMapping(value = "/student/produce", produces = "application/vnd.company.app-v2+json")
	public StudentV2 getStudentV2_media() {
		return new StudentV2(new Name("Devendra", "Kumar"));
	}
}
