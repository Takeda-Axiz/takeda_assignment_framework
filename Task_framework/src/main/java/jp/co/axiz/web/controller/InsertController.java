package jp.co.axiz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.InsertForm;
import jp.co.axiz.web.service.InsertConfirmService;
import jp.co.axiz.web.service.InsertService;

@Controller
public class InsertController {

	@Autowired
	private InsertService service;

	@Autowired
	private InsertConfirmService confService;

	// menu -> insert
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String getInsert(@ModelAttribute("InsertForm") InsertForm form, Model model) {
		return "insert";
	}

	// insert -> insertConfirm
	@RequestMapping(value="/insertConfirm", method=RequestMethod.POST)
	public String postInsert(@ModelAttribute("InsertForm") InsertForm form, Model model) {
		String retJspVal = service.CallDao(form, model);

		return retJspVal;
	}

	// select -> selectResult
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertConfirm(@ModelAttribute("InsertForm") InsertForm form, Model model) {
		String retJspVal = confService.CompareDao(form, model);

		return retJspVal;
	}
}
