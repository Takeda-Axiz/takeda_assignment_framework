package jp.co.axiz.web.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.dao.UserInfoDao;
import jp.co.axiz.web.entity.UpdateForm;
import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.service.UpdateConfirmService;

@Service
public class UpdateConfirmServiceImpl implements UpdateConfirmService {

	@Autowired
	HttpSession session;

	@Autowired
	private UserInfoDao uidao;

	@Override
	public String UpdateDao(UpdateForm form, Model model) {
		// 変数宣言
		String rePass;
		String retStr = "";
		UserInfo afterUser = (UserInfo) session.getAttribute("afterUser");

		rePass = form.getRePassVal();

		if (!afterUser.getPassword().equals(rePass)) {
			model.addAttribute("errmsg", "前画面で入力したパスワードと一致しません");
			// update.jspに遷移
			retStr = "updateConfirm";
		}else {
			uidao.update(afterUser);

			session.removeAttribute("beforeUser");
			session.removeAttribute("afterUser");

			session.setAttribute("updateUserId", afterUser.getUserId());
			retStr = "updateResult";
		}
		return retStr;
	}
}
