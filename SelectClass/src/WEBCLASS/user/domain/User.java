package WEBCLASS.user.domain;

public class User {
	//这儿应该是user表的各个属性，name，password，Email，等
	//数据库表单
	private int uid;
	private String userName;
	private String userPassword;
	private int userIdent;
	private String Email;
	//
	private String reloginpass;
	private String verifyCode;
	public String getReloginpass() {
		return reloginpass;
	}
	public void setReloginpass(String reloginpass) {
		this.reloginpass = reloginpass;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserIdent() {
		return userIdent;
	}
	public void setUserIdent(int userIdent) {
		this.userIdent = userIdent;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", userName=" + userName
				+ ", userPassword=" + userPassword + ", userIdent=" + userIdent
				+ ", Email=" + Email + ", reloginpass=" + reloginpass
				+ ", verifyCode=" + verifyCode + "]";
	}
}
