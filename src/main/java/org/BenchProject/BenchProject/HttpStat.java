package org.BenchProject.BenchProject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpStat {

	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public HttpStatus NotFound() {
		return HttpStatus.NOT_FOUND;
	}

	@RequestMapping(value = "/200", method = RequestMethod.GET)
	public HttpStatus Ok() {
		return HttpStatus.OK;
	}

	@RequestMapping(value = "/500", method = RequestMethod.GET)
	public HttpStatus InternalError() {
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}
}
