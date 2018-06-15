package jp.co.axiz.web.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.dao.UserInfoDao;
import jp.co.axiz.web.entity.UpdateForm;
import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.service.UpdateService;

@Service
public class UpdateServiceImpl implements UpdateService {

	@Autowired
	HttpSession session;

	@Autowired
	private UserInfoDao uidao;

	@Override
	public String CallDao(UpdateForm form, Model model) {
		// 変数宣言
		String inputId = "";
		String retStr = "";

		inputId = form.getIdVal();

		if (inputId == null || inputId.isEmpty()) {
			model.addAttribute("errmsg", "必須項目を入力してください");
			// update.jspに遷移
			retStr = "update";
		}else {

			UserInfo userInfo = uidao.findById(Integer.parseInt(inputId));

			if (userInfo == null) {
				model.addAttribute("errmsg", "入力されたデータは存在しません");
				// update.jspに遷移
				retStr = "update";
			}else {
				UserInfo afterUser = new UserInfo();
				afterUser.setUserId(userInfo.getUserId());
				afterUser.setUserName(userInfo.getUserName());
				afterUser.setTelephone(userInfo.getTelephone());
				afterUser.setPassword(userInfo.getPassword());

				session.setAttribute("beforeUser", userInfo);
				session.setAttribute("afterUser", afterUser);
				retStr = "updateInput";
			}
		}


		return retStr;
	}
}
