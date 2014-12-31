package com.tribalpages.api.site;

import static com.tribalpages.api.utils.JSONManager.getJSON;

import org.json.JSONArray;
import org.json.JSONObject;

import com.tribalpages.api.request.NamesRequestBuilder;
import com.tribalpages.api.user.TPManager;

public class Site {
	private String id;

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Site other = (Site) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Site(String id) {
		this.id = id;

	}

	public String getID() {
		return id;
	}

	public Person[] getNames(TPManager session) {
		JSONObject response = getJSON(new NamesRequestBuilder(id, session)
				.getURL());
		int status = response.getInt("statuscode");
		if (status != 1) {
			session.setMessage(response.getString("message"));
			session.setSucess(false);
			return null;
		}
		JSONObject result = response.getJSONObject("result");
		JSONArray namesArray = result.getJSONArray("names");
		int num = namesArray.length();
		Person[] names = new Person[num];
		for (int i = 0; i < num; i++) {
			names[i] = new Person(namesArray.getJSONObject(i).getInt("id"),
					this);
		}
		session.setSucess(true);
		session.setMessage("Getting name was succesful");
		return names;

	}
	int getSize(TPManager session) {
		return -1;
	}
	int getGroupId(TPManager session) {
		return -1;
	}
	String getDate(TPManager session) {
		return null;
	}
	int getMemberModel(TPManager sesion) {
		return -1;
	}
	int getRole(TPManager session) {
		return -1;
	}
	int getNumberPhotos(TPManager session) {
		return -1;
	}
	int getVersion(TPManager session) {
		return -1;
	}
	Person getPersonById(TPManager session, int id) {
		JSONObject reponse = getJSON(NameInfoRequestBuilder)
		return null;
	}
}
