package com.tribalpages.api.test;

import com.tribalpages.api.user.Session;
import com.tribalpages.api.user.User;

public class Test {
	public static void main(String[] args) throws Exception {
		User gaurav = new User("wizgro@gmail.com", "trialpages");
		Session session = gaurav.login();
		System.out.println(session.getMessage());

	}
}
