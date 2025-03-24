package com.company.notification_system.service;

import com.company.notification_system.model.Notification;
import com.company.notification_system.model.NotificationStatus;
import com.company.notification_system.repository.NotificationRepository;
import com.company.notification_system.web.dto.NotificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final MailSender mailSender;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository, MailSender mailSender) {
        this.notificationRepository = notificationRepository;
        this.mailSender = mailSender;
    }

    public Notification sendNotification(NotificationRequest notificationRequest) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(notificationRequest.getContactInfo());
        message.setSubject(notificationRequest.getSubject());
        message.setText(notificationRequest.getBody());

        Notification notification = Notification.builder()
                .contactInfo(notificationRequest.getContactInfo())
                .subject(notificationRequest.getSubject())
                .body(notificationRequest.getBody())
                .createdOn(LocalDateTime.now())
                .deleted(false)
                .build();

        try {
            mailSender.send(message);
            notification.setStatus(NotificationStatus.SUCCEEDED);
        } catch (Exception e) {
            notification.setStatus(NotificationStatus.FAILED);
            log.warn("There was an issue sending an email to %s due to %s.".formatted(notificationRequest.getContactInfo(), e.getMessage()));
        }

        return notificationRepository.save(notification);
    }
}
