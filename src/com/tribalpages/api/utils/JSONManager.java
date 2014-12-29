package com.tribalpages.api.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONObject;

public class JSONManager {
	public static JSONObject getJSON(URL url) {
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
