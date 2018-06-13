package jp.co.axiz.web.service;

import org.springframework.ui.Model;

import jp.co.axiz.web.entity.LoginForm;

public interface LoginService {

	String CallDao(LoginForm form, Model model);

}
