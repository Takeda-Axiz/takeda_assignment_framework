package jp.co.axiz.web.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.entity.InsertForm;

@Service
public interface InsertService {

	String CallDao(InsertForm form, Model model);
}
