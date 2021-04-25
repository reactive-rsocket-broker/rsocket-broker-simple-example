package com.alibaba.spring.boot.rsocket.demo;

import com.alibaba.rsocket.RSocketService;
import com.alibaba.user.User;
import com.alibaba.user.UserService;
import com.github.javafaker.Faker;
import io.cloudevents.CloudEvent;
import io.cloudevents.core.builder.CloudEventBuilder;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.UUID;

@Service
@RSocketService(serviceInterface = UserService.class)
public class UserServiceImpl implements UserService {
    private final Faker faker = new Faker();

    @Override
    public Mono<User> findById(Integer id) {
        return Mono.just(randomUser(id));
    }

    public Mono<CloudEvent> processLoginEvent(CloudEvent loginEvent) {
        CloudEvent event = CloudEventBuilder.v1()
                .withId(UUID.randomUUID().toString())
                .withSource(URI.create("https://example.com/users"))
                .withType("com.alibaba.user.User")
                .withData("text/plain", "Hello".getBytes(StandardCharsets.UTF_8)) //
                .build();
        return Mono.just(event);
    }

    private User randomUser(@Nullable Integer id) {
        User user = new User();
        user.setId(id == null ? new Random().nextInt() : id);
        user.setNick(faker.name().name());
        user.setPhone(faker.phoneNumber().cellPhone());
        user.setEmail(faker.internet().emailAddress());
        return user;
    }

}
