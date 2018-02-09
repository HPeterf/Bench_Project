package org.BenchProject.BenchProject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Endpoint {

	@RequestMapping(value = "/name", method = RequestMethod.GET)
	public String index() {
		return "Horváth Péter";

	}
}
