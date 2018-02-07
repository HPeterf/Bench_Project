package org.BenchProject.BenchProject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Endpoint {

	@RequestMapping("/name")
	public String index() {
		return "Horváth Péter";
	}
}
