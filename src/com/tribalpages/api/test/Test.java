package com.tribalpages.api.test;

import java.util.Scanner;

import com.tribalpages.api.site.Person;
import com.tribalpages.api.site.Site;
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
		Site site;
		if (sites != null) {
			site = session.getSiteByID(sites[0].getID());
			System.out.println(session.wasSuccessful() + " "
					+ session.getMessage());
			if (session.wasSuccessful())
				System.out.println(site.getID());
			Person[] name = site.getNames(session);
			if (session.wasSuccessful()) {
				System.out.println(name.length);
				Person p = name[1];
				String firstname = p.getFirstName(session);
				String lastname = p.getLastName(session);
				String birthplace = p.getBirthPlace(session);
				if (session.wasSuccessful()) {
					System.out.println(firstname + " " + lastname + " "
							+ birthplace);
				} else
					System.out.println(session.getMessage());
			}
		}

	}
}
