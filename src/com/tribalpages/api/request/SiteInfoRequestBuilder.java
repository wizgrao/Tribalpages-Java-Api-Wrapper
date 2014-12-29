package com.tribalpages.api.request;

import java.net.MalformedURLException;
import java.net.URL;

import com.tribalpages.api.user.TPManager;

public class SiteInfoRequestBuilder {
	private final String format = "http://www.tribalpages.com/tribe/ajaxss?servicename=MobileJSON&mid=%i&key=$i&userid=%s&action=6";
	private String finalURL;
	public SiteInfoRequestBuilder(String userID, TPManager manager) {
		finalURL = String.format(format, manager.getMemberid(),
				manager.getKey(), userID);
	}
	public URL getURL() {
		try {
			return new URL(finalURL);
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		return null;
	}

}
