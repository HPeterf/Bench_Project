package org.BenchProject.BenchProject;

import org.BenchProject.BenchProject.Model.Names;
import org.BenchProject.BenchProject.Service.NamesService;
import org.BenchProject.BenchProject.Service.Exceptions.NamesException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InputController {

	private static final String ROUTING_ADD = "/add";
	private static final String ROUTING_ADD_RESULT = "/bevitel";
	private static final String ROUTING_FULL_LIST = "/lista";

	private static final String JSP_ADD = "add";
	private static final String JSP_ADD_RESULT = "bevitel";
	private static final String JSP_FULL_LIST = "lista";

	private static final String POST_PARAM_ADD_RESULT = "name";

	private static final Logger logger = LoggerFactory.getLogger(InputController.class);

	@Autowired
	private NamesService namesService;

	@RequestMapping(value = ROUTING_FULL_LIST, method = RequestMethod.GET)
	public ModelAndView listNames() {
		ModelAndView modelAndView = null;
		try {
			modelAndView = new ModelAndView(JSP_FULL_LIST);
			modelAndView.addObject("names", namesService.listAllNames());
		} catch (Exception e) {
			modelAndView = new ModelAndView("/error");
		}
		return modelAndView;
	}

	@RequestMapping(value = ROUTING_ADD, method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView(JSP_ADD);
		return modelAndView;
	}

	@RequestMapping(value = ROUTING_ADD_RESULT, method = RequestMethod.POST)
	public ModelAndView addResult(@RequestParam(value = POST_PARAM_ADD_RESULT) final String name) {
		String resultId = "result";
		String errorId = "error";
		String errorHeader = "Error!";
		ModelAndView modelAndView = new ModelAndView(JSP_ADD_RESULT);
		Names names = new Names(name);
		String result;
		try {
			result = namesService.addNames(names);
		} catch (NamesException e) {
			result = e.getMessage();

			modelAndView.addObject(errorId, errorHeader);
		}
		modelAndView.addObject(resultId, result);
		return modelAndView;
	}

	public static String GetRoutingAdd() {
		return ROUTING_ADD;
	}

	public static String GetRoutingAddResult() {
		return ROUTING_ADD_RESULT;
	}

	public static String GetRoutingFullList() {
		return ROUTING_FULL_LIST;
	}

	public static String GetPostParamAddResult() {
		return POST_PARAM_ADD_RESULT;
	}

	public static String GetViewNameAdd() {
		return JSP_ADD;
	}

	public static String GetViewNameAddResult() {
		return JSP_ADD_RESULT;
	}

	public static String GetViewNameList() {
		return JSP_FULL_LIST;
	}

}
