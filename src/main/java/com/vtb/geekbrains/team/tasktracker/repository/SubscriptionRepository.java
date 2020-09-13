package com.vtb.geekbrains.team.tasktracker.repository;

import com.vtb.geekbrains.team.tasktracker.entity.Subscription;
import com.vtb.geekbrains.team.tasktracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {

    List<Subscription> findAllByUser(User user);
    List<Subscription> findAllByUserId(Long user_id);
}
