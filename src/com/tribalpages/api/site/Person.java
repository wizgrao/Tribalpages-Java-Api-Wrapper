package com.tribalpages.api.site;
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
	public String getName(TPManager manager) {
		return null;
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
