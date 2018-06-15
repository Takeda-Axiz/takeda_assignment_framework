package jp.co.axiz.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.dao.UserInfoDao;
import jp.co.axiz.web.entity.DeleteForm;
import jp.co.axiz.web.service.DeleteConfirmService;

@Service
public class DeleteConfirmServiceImpl implements DeleteConfirmService {

	@Autowired
	private UserInfoDao uidao;

	@Override
	public void DeleteDao(DeleteForm form, Model model) {
		// 変数宣言
		String inputId = "";

		inputId = form.getIdVal();

		uidao.delete(Integer.parseInt(inputId));
	}
}




