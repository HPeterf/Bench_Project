package org.BenchProject.BenchProject;

import org.BenchProject.Service.NamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/lista")
public class ListController {

	private NamesService namesService;

	@Autowired(required = true)
	@Qualifier(value = "NamesService")
	public void setNamesService(NamesService namesService) {
		this.namesService = namesService;
	}

	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("lista");
		model.addObject("list", namesService.listAllNames());
		return model;
	}
}
