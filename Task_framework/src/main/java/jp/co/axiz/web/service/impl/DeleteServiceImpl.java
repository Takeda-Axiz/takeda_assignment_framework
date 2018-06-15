package jp.co.axiz.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.dao.UserInfoDao;
import jp.co.axiz.web.entity.DeleteForm;
import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.service.DeleteService;

@Service
public class DeleteServiceImpl implements DeleteService {

	@Autowired
	private UserInfoDao uidao;

	@Override
	public String CallDao(DeleteForm form, Model model) {
		// 変数宣言
		String inputId = "";
		String retStr = "deleteConfirm";
		UserInfo userInfo;

		inputId = form.getIdVal();

		if (inputId == null || inputId.isEmpty()) {
			model.addAttribute("errmsg", "必須項目を入力してください");
			// delete.jspに遷移
			retStr = "delete";
		}else {
			userInfo = uidao.findById(Integer.parseInt(inputId));

			if (userInfo == null) {
				model.addAttribute("errmsg", "入力されたデータは存在しません");
				// delete.jspに遷移
				retStr = "delete";
			}else {
				model.addAttribute("deleteUser", userInfo);
			}
		}

		return retStr;
	}
}
