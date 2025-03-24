package com.company.notification_system.web.mapper;

import com.company.notification_system.model.Notification;
import com.company.notification_system.web.dto.NotificationResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DtoMapper {

    public static NotificationResponse fromNotification(Notification entity) {

        return NotificationResponse.builder()
                .contactInfo(entity.getContactInfo())
                .subject(entity.getSubject())
                .status(entity.getStatus())
                .createdOn(entity.getCreatedOn())
                .build();
    }
}
