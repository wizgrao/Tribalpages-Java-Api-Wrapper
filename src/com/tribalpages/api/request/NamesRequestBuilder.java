package com.tribalpages.api.request;

import java.net.MalformedURLException;
import java.net.URL;

import com.tribalpages.api.user.TPManager;

public class NamesRequestBuilder {
	private final String format = "http://www.tribalpages.com/tribe/ajaxss?servicename=MobileJSON&mid=%d&key=%d&userid=%s&action=24";
	private String finalURL;
	public NamesRequestBuilder(String siteID, TPManager manager) {
		finalURL = String.format(format, manager.getMemberid(),
				manager.getKey(), siteID);
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
