package com.tribalpages.api.test;

import java.util.Scanner;

import site.Site;

import com.tribalpages.api.user.TPManager;
import com.tribalpages.api.user.User;

public class Test {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter email: ");
		String email = s.next();
		System.out.print("Enter password: ");
		String password = s.next();
		s.close();
		User user = new User(email, password);
		TPManager session = user.login();
		System.out.println(session.getMessage());
		System.out.println(session.getKey());
		System.out.println(session.getMemberid());
		Site[] sites = session.getSites();
		if (session.wasSuccessful())
			for (Site site : sites) {
				System.out.println(site.getID());
			}
	}
}
