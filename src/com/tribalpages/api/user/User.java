package com.tribalpages.api.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONObject;

import com.tribalpages.api.request.LoginRequestBuilder;

public class User {
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String passWord) {
		this.password = passWord;
	}

	public Session login() {
		Session s = null;;
		try {
			BufferedReader b = new BufferedReader(new InputStreamReader(
					new LoginRequestBuilder(userName, password).getURL()
							.openStream()));
			String buf = "";
			String tot = "";
			while ((buf = b.readLine()) != null) {
				tot += buf;
			}
			JSONObject response = new JSONObject(tot);
			if (response.getInt("statuscode") == 1) {

			} else {
				s = new Session("Server error");
			}

		} catch (IOException e) {
			s = new Session("Bad url");
		}
		return s;
	}
}
