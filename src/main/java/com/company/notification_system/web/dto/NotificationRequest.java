package com.company.notification_system.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationRequest {

    @NotBlank
    private String contactInfo;

    @NotBlank
    private String subject;

    @NotBlank
    private String body;
}
