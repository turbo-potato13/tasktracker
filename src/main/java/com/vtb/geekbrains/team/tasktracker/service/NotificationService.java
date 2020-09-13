package com.vtb.geekbrains.team.tasktracker.service;

import com.vtb.geekbrains.team.tasktracker.entity.Event;
import com.vtb.geekbrains.team.tasktracker.entity.Subscription;
import com.vtb.geekbrains.team.tasktracker.entity.User;
import com.vtb.geekbrains.team.tasktracker.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final SubscriptionService subscriptionService;
    private final EventRepository eventRepository;

    public Set<Event> findAllNotificationsByUser(User user) {
        List<Subscription> subscriptionList = subscriptionService.findAllSubscriptionsByUser(user);
        Set<Event> events =
                subscriptionList.stream()
                        .map(sub -> eventRepository
                                .findAllByProjectAndTypeAndTask(sub.getProject(),sub.getEventType(),sub.getTask())
                        ).flatMap(Collection::stream)
                .collect(Collectors.toSet());
        return events;
    }

}
