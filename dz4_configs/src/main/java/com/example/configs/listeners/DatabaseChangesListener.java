package com.example.configs.listeners;

import com.example.configs.events.DatabaseChangedEvent;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@ConditionalOnExpression("'${listeners.createDatabaseListener:default}'!='default'")
public class DatabaseChangesListener {

	public DatabaseChangesListener() {
		System.out.println("im here");
	}

	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
	public void newUserAdded(DatabaseChangedEvent event) {
		System.out.println("User " + event.getUser().getName() + " " + event.getUser().getPhone() + " in database!");
	}

	@TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
	public void rollback(DatabaseChangedEvent event) {
		System.out.println("User " + event.getUser().getName() + " " + event.getUser().getPhone() + " was rolled back!");
	}
}
