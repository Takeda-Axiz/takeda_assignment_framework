package jp.co.axiz.web.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.entity.UpdateForm;

@Service
public interface UpdateService {

	String CallDao(UpdateForm form, Model model);
}
