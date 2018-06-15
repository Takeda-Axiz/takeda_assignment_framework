package jp.co.axiz.web.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.dao.UserInfoDao;
import jp.co.axiz.web.entity.InsertForm;
import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.service.InsertConfirmService;

@Service
public class InsertConfirmServiceImpl implements InsertConfirmService {

	@Autowired
	HttpSession session;

	@Autowired
	private UserInfoDao uidao;

	@Override
	public String CompareDao(InsertForm form, Model model) {
		// 変数宣言
		String inputPass = "";
		String retStr = "";
		Boolean isMatchPass = false;
		UserInfo ui;

		inputPass = form.getRePassVal();

		ui = (UserInfo) session.getAttribute("registerUser");

		isMatchPass = inputPass.equals(ui.getPassword());

		// パスワードが一致していることを確認
		if (isMatchPass) {
			// 一致している場合
			uidao.register(ui);

			session.setAttribute("registerUserId", ui.getUserId());
			session.removeAttribute("registerUser");
			// insertResult.jspに遷移
			retStr = "insertResult";
		} else {
			// 一致しない場合
			// エラーメッセージをセット
			model.addAttribute("errmsg", "入力されたデータはありませんでした");
			// insertConfirm.jspに遷移
			retStr = "insertConfirm";
		}

		return retStr;
	}
}
