package org.upsam.sypweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mujeres/buscar")
public class MujerController {

	@RequestMapping(method = RequestMethod.GET)
	public String searchForm() {
		return "searchForm";
	}
}
