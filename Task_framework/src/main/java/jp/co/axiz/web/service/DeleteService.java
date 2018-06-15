package jp.co.axiz.web.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.entity.DeleteForm;

@Service
public interface DeleteService {

	String CallDao(DeleteForm form, Model model);
}
