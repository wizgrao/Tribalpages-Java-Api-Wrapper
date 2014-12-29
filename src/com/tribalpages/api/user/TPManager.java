package com.tribalpages.api.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import site.Site;

import com.tribalpages.api.request.SitesRequestBuilder;

public class TPManager {
	private boolean success;
	private String message;
	private int key;
	private int memberid;
	private int redirect;
	public int getRedirect() {
		return redirect;
	}
	public String getMessage() {
		return message;
	}
	public int getKey() {
		return key;
	}
	public int getMemberid() {
		return memberid;
	}
	TPManager(String message) {
		this.message = message;
		key = -1;
		memberid = -1;
		success = false;
	}
	public boolean wasSuccessful() {
		return success;
	}
	TPManager(int key, int memberid) {
		this.message = "Login ok";
		this.key = key;
		this.memberid = memberid;
		success = true;
	}
	public Site[] getSites() {
		JSONObject response = getJSON(new SitesRequestBuilder(this).getURL());
		if (response.getInt("statuscode") != 1) {
			success = false;
			redirect = response.getInt("redirect");
			message = response.getString("message");
			return null;
		} else {
			JSONObject result = response.getJSONObject("result");
			JSONArray array = result.getJSONArray("userdatas");
			int numSites = array.length();
			Site[] returnSites = new Site[numSites];
			for (int i = 0; i < numSites; i++) {
				returnSites[i] = new Site(array.getJSONObject(i).getString(
						"userid"));
			}
			return returnSites;
		}

	}
	private static JSONObject getJSON(URL url) {
		try {
			BufferedReader b = new BufferedReader(new InputStreamReader(
					url.openStream()));
			String buff;
			String total = "";
			while ((buff = b.readLine()) != null) {
				total += buff;
			}
			return new JSONObject(total);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
