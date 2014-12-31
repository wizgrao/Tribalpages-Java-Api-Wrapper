package com.tribalpages.api.site;
import org.json.JSONObject;

import com.tribalpages.api.user.TPManager;
public class Person {
	int id;
	Site site;

	public Person(int id, Site site) {
		this.site = site;
		this.id = id;
	}
	public int getID() {
		return id;
	}
	public String getFirstName(TPManager manager) {
		JSONObject response = com.tribalpages.api.utils.JSONManager
				.getJSON(new com.tribalpages.api.request.NameInfoRequestBuilder(
						site.getID(), id, manager).getURL());
		if (response.getInt("statuscode") != 1) {
			manager.setSucess(false);
			manager.setMessage(response.getString("message"));
			return null;
		} else {
			manager.setSucess(true);
			manager.setMessage("Found person");
			return response.getJSONObject("result").getString("firstname");
		}

	}
	public String getLastName(TPManager manager) {
		JSONObject response = com.tribalpages.api.utils.JSONManager
				.getJSON(new com.tribalpages.api.request.NameInfoRequestBuilder(
						site.getID(), id, manager).getURL());
		if (response.getInt("statuscode") != 1) {
			manager.setSucess(false);
			manager.setMessage(response.getString("message"));
			return null;
		} else {
			manager.setSucess(true);
			manager.setMessage("Found person");
			return response.getJSONObject("result").getString("lastname");
		}

	}
	public String getMiddleName(TPManager manager) {
		JSONObject response = com.tribalpages.api.utils.JSONManager
				.getJSON(new com.tribalpages.api.request.NameInfoRequestBuilder(
						site.getID(), id, manager).getURL());
		if (response.getInt("statuscode") != 1) {
			manager.setSucess(false);
			manager.setMessage(response.getString("message"));
			return null;
		} else {
			manager.setSucess(true);
			manager.setMessage("Found person");
			return response.getJSONObject("result").getString("middlename");
		}

	}
	public String getBirthPlace(TPManager manager) {
		JSONObject response = com.tribalpages.api.utils.JSONManager
				.getJSON(new com.tribalpages.api.request.NameInfoRequestBuilder(
						site.getID(), id, manager).getURL());
		if (response.getInt("statuscode") != 1) {
			manager.setSucess(false);
			manager.setMessage(response.getString("message"));
			return null;
		} else {
			manager.setSucess(true);
			manager.setMessage("Found person");
			return response.getJSONObject("result").getString("birthplace");
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((site == null) ? 0 : site.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (site == null) {
			if (other.site != null)
				return false;
		} else if (!site.equals(other.site))
			return false;
		return true;
	}

}
