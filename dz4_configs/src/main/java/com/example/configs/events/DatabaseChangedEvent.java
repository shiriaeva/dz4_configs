package com.example.configs.events;

import com.example.configs.objects.User;
import org.springframework.context.ApplicationEvent;

public class DatabaseChangedEvent extends ApplicationEvent {
	private final User user;

	public DatabaseChangedEvent(Object source, User user) {
		super(source);
		this.user = user;
		System.out.println("Database change created! (" + user.getName() + " " + user.getPhone() + ")");
	}

	public User getUser() {
		return user;
	}
}