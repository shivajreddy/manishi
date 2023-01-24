package com.shiva.manishi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {

	@GetMapping("/demo")
	public String demo() {
		return "test ok ✅";
	}

	@PostMapping("/demo")
	public String postDemo() {
		return "post test ok ✅";
	}

}

