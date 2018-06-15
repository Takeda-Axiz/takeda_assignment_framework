package jp.co.axiz.web.entity;

import java.io.Serializable;

public class Admin implements Serializable {
	/*---  Field  ---*/
	private String adminId;
	private String adminName;
	private String password;	//変数名概要

	/*---  Field End  ---*/

	/*---  Constructor  ---*/
	/*---  Constructor End  ---*/

	/*---  Method  ---*/
	//  処理概要
	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String id) {
		this.adminId = id;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String name) {
		this.adminName = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*---  Method End  ---*/
}

