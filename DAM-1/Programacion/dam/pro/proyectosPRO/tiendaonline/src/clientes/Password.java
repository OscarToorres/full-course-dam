package clientes;

import java.security.SecureRandom;

public class Password {

	private String password;

	public Password() {
		super();
		SecureRandom secureRandom = new SecureRandom();
		int pwd = Math.abs(secureRandom.nextInt());
		this.password = String.valueOf(pwd);

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
