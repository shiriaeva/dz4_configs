package com.example.configs.listeners;

import com.example.configs.events.UserCreatedEvent;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnBean(UserCreationListener.class)
public class AsyncUserCreationListener {
	@Async
	@EventListener
	public void timeout(UserCreatedEvent event) throws InterruptedException {
		Thread.sleep(10000);
		System.out.println("User " + event.getUser().getName() + " " + event.getUser().getPhone() + " exist 10 seconds.");
	}
}
