package site;

import com.tribalpages.api.user.TPManager;

public class Site {
	private String id;

	public Site(String id) {
		this.id = id;

	}

	public String getID() {
		return id;
	}

	Person[] getNames(TPManager session) {
		return null;
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

}
