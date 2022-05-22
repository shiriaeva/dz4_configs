package com.example.configs.services;

import com.example.configs.events.DatabaseChangedEvent;
import com.example.configs.repository.UserRepository;
import com.example.configs.objects.User;
import com.example.configs.events.UserCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ApplicationEventPublisher eventPublisher;
    private final UserRepository userRepository;

    @Transactional
    public long create(String name, String phone) {
        var user = new User(name, phone);
        eventPublisher.publishEvent(new UserCreatedEvent(this, user));
        var id = userRepository.save(user).getId();
        eventPublisher.publishEvent(new DatabaseChangedEvent(this, user));
        return id;
    }

    @Transactional
    public long edit(long id, String name, String phone) throws IllegalAccessException {
        var user = new User(id, name, phone);
        eventPublisher.publishEvent(new UserCreatedEvent(this, user));
        var updatedUser = userRepository.findById(id).get();
        FieldUtils.writeField(updatedUser, "name", name, true);
        FieldUtils.writeField(updatedUser, "phone", phone, true);
        user = userRepository.save(updatedUser);
        eventPublisher.publishEvent(new DatabaseChangedEvent(this, user));
        return id;
    }

    @Transactional
    public User getUser(long id){
        return userRepository.findById(id).orElse(null);
    }
}
