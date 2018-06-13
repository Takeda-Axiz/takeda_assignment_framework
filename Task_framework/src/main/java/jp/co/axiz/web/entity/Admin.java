package jp.co.axiz.web.entity;

import java.io.Serializable;

public class Admin implements Serializable {
	/*---  Field  ---*/
	private String id;
	private String name;
	private String password;	//変数名概要

	/*---  Field End  ---*/

	/*---  Constructor  ---*/
	/*---  Constructor End  ---*/

	/*---  Method  ---*/
	//  処理概要
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*---  Method End  ---*/
}

