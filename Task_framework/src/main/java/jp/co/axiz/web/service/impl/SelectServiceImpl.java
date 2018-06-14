package jp.co.axiz.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.dao.UserInfoDao;
import jp.co.axiz.web.entity.SelectForm;
import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.service.SelectService;

@Service
public class SelectServiceImpl implements SelectService {

	@Autowired
	private UserInfoDao uidao;

	@Override
	public String CallDao(SelectForm form, Model model) {
		// 変数宣言
		String inputId = "";
		String inputName = "";
		String inputTel = "";
		String retStr = "";
		UserInfo cond = new UserInfo();

		inputId = form.getIdVal();
		inputName = form.getNameVal();
		inputTel = form.getTelVal();

		try {
			cond.setId(Integer.parseInt(inputId));
		} catch (NumberFormatException e) {
			// do nothing
		}

		cond.setName(inputName);
		cond.setTelephone(inputTel);

		List<UserInfo> list = uidao.find(cond);

		if (list.isEmpty()) {
			model.addAttribute("errmsg", "入力されたデータはありませんでした");
			// select.jspに遷移
			retStr = "select";
		} else {
			model.addAttribute("userlist", list);
			// selectResult.jspに遷移
			retStr = "selectResult";
		}

		return retStr;
	}
}
