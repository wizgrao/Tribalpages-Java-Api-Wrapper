package com.tribalpages.api.site;
import com.tribalpages.api.user.TPManager;
public class Person {
	int id;

	public Person(int id) {
		this.id = id;
	}
	public int getID() {
		return id;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

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
		return true;
	}

}
