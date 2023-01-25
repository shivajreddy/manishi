package com.shiva.manishi.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


@RestController
public class DemoController {

	@GetMapping("/demo")
	public String demo() {
		return "test ok ✅";
	}

	@PostMapping("/demo")
	public String postDemo(HttpServletRequest request) throws IOException {
		System.out.println("## POST: /demo" + request);
		System.out.println(request);

		String result = new String(StreamUtils.copyToByteArray(request.getInputStream()), StandardCharsets.UTF_8);
		System.out.println("@@"+ result);

		return "post test ok ✅";
	}

}

