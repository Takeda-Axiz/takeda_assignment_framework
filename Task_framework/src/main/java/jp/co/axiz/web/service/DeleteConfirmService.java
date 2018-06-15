package jp.co.axiz.web.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.entity.DeleteForm;

@Service
public interface DeleteConfirmService {

	void DeleteDao(DeleteForm form, Model model);
}
