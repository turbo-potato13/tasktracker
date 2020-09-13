package com.vtb.geekbrains.team.tasktracker.service;

import com.vtb.geekbrains.team.tasktracker.entity.Subscription;
import com.vtb.geekbrains.team.tasktracker.entity.User;
import com.vtb.geekbrains.team.tasktracker.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Subscription> findAllSubscriptionsByUserId(long userId){
        return subscriptionRepository.findAllByUserId(userId);
    }
    public List<Subscription> findAllSubscriptionsByUser(User user){
        return subscriptionRepository.findAllByUser(user);
    }
}
