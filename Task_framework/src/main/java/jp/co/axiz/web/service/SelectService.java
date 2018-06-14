package jp.co.axiz.web.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.entity.SelectForm;

@Service
public interface SelectService {

	String CallDao(SelectForm form, Model model);
}
