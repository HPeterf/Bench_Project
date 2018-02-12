package org.BenchProject.BenchProject;

import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JspController {

	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping(value = "/information", method = RequestMethod.GET)
	public String welcome(Map<String, Object> model, Model model2, Locale locale) {
		model.put("message", this.message);
		return "information";
	}

}
