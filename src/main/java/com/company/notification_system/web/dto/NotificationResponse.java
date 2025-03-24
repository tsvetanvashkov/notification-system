package com.company.notification_system.web.dto;

import com.company.notification_system.model.NotificationStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NotificationResponse {

    private String contactInfo;

    private String subject;

    private LocalDateTime createdOn;

    private NotificationStatus status;
}
