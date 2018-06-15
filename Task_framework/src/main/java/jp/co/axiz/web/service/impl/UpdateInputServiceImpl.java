package jp.co.axiz.web.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.entity.UpdateForm;
import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.service.UpdateInputService;

@Service
public class UpdateInputServiceImpl implements UpdateInputService {

	@Autowired
	HttpSession session;

	@Override
	public String InputDao(UpdateForm form, Model model) {
		// 変数宣言
		String newName = form.getNameVal();
		String newTel = form.getTelVal();
		String newPass = form.getPassVal();
		String retStr = "";

		UserInfo afterUser = (UserInfo) session.getAttribute("afterUser");

		String errmsg = null;

		if (newPass == null || newPass.isEmpty()) {
			errmsg = "PASSは必須です";
		} else {
			afterUser.setPassword(newPass);
		}

		if (newTel == null || newTel.isEmpty()) {
			errmsg = "TELは必須です";
		} else {
			afterUser.setTelephone(newTel);
		}

		if (newName == null || newName.isEmpty()) {
			errmsg = "名前は必須です";
		} else {
			afterUser.setUserName(newName);
		}

		if (errmsg != null) {
			model.addAttribute("errmsg", errmsg);
			// updateInput.jspに遷移
			retStr = "updateInput";
		}else {
			UserInfo beforeUser = (UserInfo) session.getAttribute("beforeUser");
			if (beforeUser.equals(afterUser)) {
				model.addAttribute("errmsg", "１項目以上変更してください");
				// updateInput.jspに遷移
				retStr = "updateInput";
			}else {
				if (beforeUser.getPassword().equals(afterUser.getPassword())) {
					model.addAttribute("rePass", afterUser.getPassword());
				}

				// updateConfirm.jspに遷移
				retStr = "updateConfirm";
			}
		}
		return retStr;
	}
}
