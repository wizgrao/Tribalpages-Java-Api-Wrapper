package com.tribalpages.api.request;

import java.net.MalformedURLException;
import java.net.URL;

import com.tribalpages.api.user.TPManager;

public class SitesRequestBuilder {
	private String url;
	TPManager session;
	public SitesRequestBuilder(TPManager session) {
		this.session = session;
		url = "http://www.tribalpages.com/tribe/ajaxss?servicename=MobileJSON&action=5&mid="
				+ session.getMemberid()
				+ "&key="
				+ session.getKey()
				+ "&userid=uuuutpu";

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
