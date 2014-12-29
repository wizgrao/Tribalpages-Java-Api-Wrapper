package com.tribalpages.api.test;

import com.tribalpages.api.user.TPSession;
import com.tribalpages.api.user.User;

public class Test {
	public static void main(String[] args) throws Exception {
		User gaurav = new User("email@email.com", "password");
		TPSession session = gaurav.login();
		System.out.println(session.getMessage());
		System.out.println(session.getKey());
		System.out.println(session.getMemberid());

	}
}
