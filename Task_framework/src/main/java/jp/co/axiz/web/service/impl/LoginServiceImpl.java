package jp.co.axiz.web.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.dao.AdminDao;
import jp.co.axiz.web.entity.Admin;
import jp.co.axiz.web.entity.LoginForm;
import jp.co.axiz.web.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private AdminDao admindao;

	@Autowired
	HttpSession session;

	@Override
	public String CallDao(LoginForm form, Model model) {
		// 変数宣言
		String inputId = "";
		String inputPass = "";
		String retStr = "";
		Admin getAdmin = null;

		inputId = form.getIdVal();
		inputPass = form.getPassVal();
		getAdmin = admindao.findByIdAndPassword(inputId, inputPass);
		// 入力されたIDが存在するか確認
		if(getAdmin == null) {
			// nullだった(adminIDが存在しない)場合
			// エラーメッセージを設定
			model.addAttribute("errmsg", "IDまたはPASSが間違っています");
			// login.jspに遷移
			retStr = "login";
		}else {
			// nullではない(adminIDが存在している)場合
			// adminユーザーを記憶
			session.setAttribute("user", getAdmin);
			// menu.jspに遷移
			retStr = "menu";
		}

		return retStr;
	}
}
