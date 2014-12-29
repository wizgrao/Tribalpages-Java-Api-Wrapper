package com.tribalpages.api.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONObject;

import com.tribalpages.api.request.LoginRequestBuilder;

public class User {
	private String email;
	private String password;
	public User(String userName, String password) {
		this.email = userName;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String passWord) {
		this.password = passWord;
	}

	public TPManager login() {
		TPManager s = null;;
		try {
			BufferedReader b = new BufferedReader(new InputStreamReader(
					new LoginRequestBuilder(email, password).getURL()
							.openStream()));
			String buf = "";
			String tot = "";
			while ((buf = b.readLine()) != null) {
				tot += buf;
			}
			JSONObject response = new JSONObject(tot);
			if (response.getInt("statuscode") == 1) {
				JSONObject result = response.getJSONObject("result");
				if (result.getInt("result") == 1) {
					s = new TPManager(result.getInt("key"),
							result.getInt("memberid"));
				} else {
					s = new TPManager(result.getString("reasonText"));
				}
			} else {
				s = new TPManager("Server error");
			}

		} catch (IOException e) {
			s = new TPManager("Bad url");
		}
		return s;
	}
}
