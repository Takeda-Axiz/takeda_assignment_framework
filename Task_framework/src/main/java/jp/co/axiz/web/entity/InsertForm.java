package jp.co.axiz.web.entity;

public class InsertForm {
	/*---  Field  ---*/
	private String nameVal;		//変数名概要
	private String telVal;		//変数名概要
	private String passVal;		//変数名概要
	private String rePassVal;		//変数名概要

	/*---  Field End  ---*/

	/*---  Constructor  ---*/
	/*---  Constructor End  ---*/

	/*---  Method  ---*/
	//  処理概要
	public String getNameVal() {
		return nameVal;
	}

	public void setNameVal(String nameVal) {
		this.nameVal = nameVal;
	}

	public String getTelVal() {
		return telVal;
	}

	public void setTelVal(String telVal) {
		this.telVal = telVal;
	}

	public String getPassVal() {
		return passVal;
	}

	public void setPassVal(String passVal) {
		this.passVal = passVal;
	}

	public String getRePassVal() {
		return rePassVal;
	}

	public void setRePassVal(String rePassVal) {
		this.rePassVal = rePassVal;
	}

	/*---  Method End  ---*/
}
