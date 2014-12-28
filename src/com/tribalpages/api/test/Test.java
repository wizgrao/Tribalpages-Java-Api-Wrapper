package com.tribalpages.api.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONObject;

import com.tribalpages.api.request.LoginRequestBuilder;

public class Test {
	public static void main(String[] args) throws Exception {
		URL url = new URL(
				"http://www.tribalpages.com/tribe/ajaxss?servicename=MobileJSON&action=5&mid=649949&key=1906&userid=uuuutpu");
		BufferedReader b = new BufferedReader(new InputStreamReader(
				new LoginRequestBuilder("wizgrao@gmail.com", "tribalpages")
						.getURL().openStream()));
		String in;
		String tot = "";
		while ((in = b.readLine()) != null) {
			System.out.println(in);
			tot += in;
		}

		JSONObject j = new JSONObject(tot);
		System.out.println(j.getInt("statuscode"));

	}
}
