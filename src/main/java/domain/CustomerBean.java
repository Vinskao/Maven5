package domain;

import java.util.Date;

public class CustomerBean {
	private String custid;
	private byte[] password;
	private String email;
	private java.util.Date birth;

//	public CustomerBean(String custid, byte[] password, String email, Date birth) {
//		this.custid = custid;
//		this.password = password;
//		this.email = email;
//		this.birth = birth;
//	}

	@Override
	public String toString() {
		return "CustomerBean [custid=" + custid + ", email=" + email + ", birth=" + birth + "]";
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public byte[] getPassword() {
		return password;
	}
	public void setPassword(byte[] password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public java.util.Date getBirth() {
		return birth;
	}
	public void setBirth(java.util.Date birth) {
		this.birth = birth;
	}
}
