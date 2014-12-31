package com.tribalpages.api.request;

import java.net.URL;

import com.tribalpages.api.user.TPManager;

public class NameInfoRequestBuilder {
	private final String format = "http://www.tribalpages.com/tribe/ajaxss?servicename=MobileJSON&mid=%d&key=%d&userid=%s&action=2&pid=%d";
	private String url;
	public NameInfoRequestBuilder(String sid, int pid, TPManager t) {
		url = String.format(format, t.getMemberid(), t.getKey(), sid, pid);
	}
	public URL getURL() {
		try {
			return new URL(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
