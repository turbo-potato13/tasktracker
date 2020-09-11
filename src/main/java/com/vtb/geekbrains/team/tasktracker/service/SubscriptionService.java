package com.vtb.geekbrains.team.tasktracker.service;

import com.vtb.geekbrains.team.tasktracker.entity.Subscription;
import com.vtb.geekbrains.team.tasktracker.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    public void subscribe(Subscription subscription) {
        subscriptionRepository.save(subscription);
    }

    public void unSubscribe(Subscription subscription){
        subscriptionRepository.delete(subscription);
    }
}
