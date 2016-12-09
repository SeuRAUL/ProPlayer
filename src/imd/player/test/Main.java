package imd.player.test;

import imd.player.control.User;

public class Main {
	public static void main(String[] args) {
		User user = new User("Hivana", "Senha") {
		};
		System.out.println(user.getId());
		System.out.println(user.toString());
	}
}
