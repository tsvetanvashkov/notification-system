package com.company.notification_system.repository;

import com.company.notification_system.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NotificationRepository  extends JpaRepository<Notification, UUID> {

}
