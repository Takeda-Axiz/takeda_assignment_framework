package jp.co.axiz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.SelectForm;
import jp.co.axiz.web.service.SelectService;

@Controller
public class SelectController {

	@Autowired
	private SelectService service;

	// menu -> select
	@RequestMapping(value="/select", method=RequestMethod.GET)
	public String select(@ModelAttribute("SelectForm") SelectForm form, Model model) {
		return "select";
	}

	// select -> selectResult
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(@ModelAttribute("SelectForm") SelectForm form, Model model) {
		String retJspVal = service.CallDao(form, model);

		return retJspVal;
	}
}
