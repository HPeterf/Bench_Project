package org.BenchProject.BenchProject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {

	@RequestMapping("/information")
	public String welcome() {
		return "information";
	}
}
