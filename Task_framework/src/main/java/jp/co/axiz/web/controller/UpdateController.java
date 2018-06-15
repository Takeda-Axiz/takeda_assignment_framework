package jp.co.axiz.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.UpdateForm;
import jp.co.axiz.web.service.UpdateConfirmService;
import jp.co.axiz.web.service.UpdateInputService;
import jp.co.axiz.web.service.UpdateService;

@Controller
public class UpdateController {

	@Autowired
	HttpSession session;

	@Autowired
	private UpdateService service;

	@Autowired
	private UpdateInputService inputService;

	@Autowired
	private UpdateConfirmService confirmService;

	// menu or updateInput -> update
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String getUpdate(@ModelAttribute("UpdateForm") UpdateForm form, Model model) {
		return "update";
	}

	// update -> update or updateInput
	@RequestMapping(value="/updateInput", method=RequestMethod.POST)
	public String postUpdateInput(@ModelAttribute("UpdateForm") UpdateForm form, Model model) {
		String retJspVal = service.CallDao(form, model);

		return retJspVal;
	}

	// updateInput -> updateInput or updateConfirm
	@RequestMapping(value="/updateConfirm", method=RequestMethod.POST)
	public String updateConfirm(@ModelAttribute("UpdateForm") UpdateForm form, Model model) {
		String retJspVal = inputService.InputDao(form, model);

		return retJspVal;
	}

	// updateConfirm -> updateInput
	@RequestMapping(value="/updateInput", method=RequestMethod.GET)
	public String getUpdateInput(@ModelAttribute("UpdateForm") UpdateForm form, Model model) {
		return "updateInput";
	}

	// updateConfirm -> updateResult
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String postUpdate(@ModelAttribute("UpdateForm") UpdateForm form, Model model) {
		String retJspVal = confirmService.UpdateDao(form, model);

		return retJspVal;
	}
}
