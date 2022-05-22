package com.example.configs.listeners;

import com.example.configs.events.UserCreatedEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class UserCreationListener {
	@EventListener
	public void createUser(UserCreatedEvent event) {
		System.out.println("User " + event.getUser().getName() + " " + event.getUser().getPhone() + " created!");
	}
}
