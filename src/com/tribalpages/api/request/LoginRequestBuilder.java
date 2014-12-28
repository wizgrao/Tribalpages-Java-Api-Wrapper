package com.tribalpages.api.request;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Builds a Url to login to tribalpages given the email and password of the site
 * 
 * @author Gaurav Rao
 *
 */
public class LoginRequestBuilder {

	private String url;
	public LoginRequestBuilder(String email, String password) {

		url = "http://www.tribalpages.com/tribe/ajaxss?servicename=MobileJSON&action=4&email="
				+ email + "&password=" + password + "&userid=uuuutpu";
	}
	public URL getURL() {
		try {
			return new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
