package jp.co.axiz.web.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.axiz.web.entity.InsertForm;

@Service
public interface InsertConfirmService {

	String CompareDao(InsertForm form, Model model);
}
