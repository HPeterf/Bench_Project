package org.BenchProject.BenchProject;

import org.BenchProject.Model.Names;
import org.BenchProject.Service.NamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/add")
public class InputController {

	// private static final String ROUTING_ADD = "/add";
	// private static final String ROUTING_ADD_RESULT = "/bevitel";
	// private static final String ROUTING_FULL_LIST = "/lista";
	//
	// private static final String JSP_ADD = "add";
	// private static final String JSP_ADD_RESULT = "bevitel";
	// private static final String JSP_FULL_LIST = "lista";

	private NamesService namesService;

	@Autowired(required = true)
	@Qualifier(value = "NamesService")
	public void setNamesService(NamesService namesService) {
		this.namesService = namesService;
	}

	// @RequestMapping(value = "/lista", method = RequestMethod.GET)
	// public ModelAndView list() {
	// ModelAndView model = new ModelAndView("lista");
	// model.addObject("list", namesService.listAllNames());
	// return model;
	// }

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addName(@ModelAttribute("names") Names names) {
		ModelAndView model = new ModelAndView("add");
		if (names != null) {
			namesService.addNames(names);
			model.addObject("warning", "Name Registration Success");

		} else {
			model.addObject("danger", "Something Going Bad");

		}
		return new ModelAndView("redirect:/add");
	}

	// public static String GetRoutingAdd() {
	// return ROUTING_ADD;
	// }
	//
	// public static String GetRoutingAddResult() {
	// return ROUTING_ADD_RESULT;
	// }
	//
	// public static String GetRoutingFullList() {
	// return ROUTING_FULL_LIST;
	// }
	//
	// @RequestMapping(ROUTING_ADD)
	// public String add() {
	// return JSP_ADD;
	// }
	//
	// @RequestMapping(ROUTING_ADD_RESULT)
	// public String addResult() {
	// return JSP_ADD_RESULT;
	// }
	//
	// @RequestMapping(ROUTING_FULL_LIST)
	// public String fullList() {
	// return JSP_FULL_LIST;
	// }
}
