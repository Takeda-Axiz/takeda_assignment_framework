package jp.co.axiz.web.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.entity.InsertForm;
import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.service.InsertService;

@Service
public class InsertServiceImpl implements InsertService {

	@Autowired
	HttpSession session;

	@Override
	public String CallDao(InsertForm form, Model model) {
		// 変数宣言
		String inputName = "";
		String inputTel = "";
		String inputPass = "";
		String retStr = "insertConfirm";
		UserInfo ui = new UserInfo();

		inputName = form.getNameVal();
		inputTel = form.getTelVal();
		inputPass = form.getPassVal();

		ui.setName(inputName);
		ui.setTelephone(inputTel);
		ui.setPassword(inputPass);

		session.setAttribute("registerUser", ui);

		if (inputName == null || inputName.isEmpty()) {
			model.addAttribute("errmsg", "名前は必須です");
			// insert.jspに遷移
			retStr = "insert";
		}

		if (inputTel == null || inputTel.isEmpty()) {
			model.addAttribute("errmsg", "TELは必須です");
			// insert.jspに遷移
			retStr = "insert";
		}

		if (inputPass == null || inputPass.isEmpty()) {
			model.addAttribute("errmsg", "PASSは必須です");
			// insert.jspに遷移
			retStr = "insert";
		}

		return retStr;
	}
}
