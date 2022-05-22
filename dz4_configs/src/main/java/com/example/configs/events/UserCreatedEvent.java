package com.example.configs.events;

import com.example.configs.objects.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class UserCreatedEvent extends ApplicationEvent {
	@Getter
	private final User user;

	public UserCreatedEvent(Object source, User user) {
		super(source);
		this.user = user;
		System.out.println("Event created! (" + user.getName() + " " + user.getPhone() + ")");
	}
}
