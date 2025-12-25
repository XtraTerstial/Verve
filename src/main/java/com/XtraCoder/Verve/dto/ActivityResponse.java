package com.XtraCoder.Verve.dto;

import com.XtraCoder.Verve.entity.enums.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityResponse {

    private String id;
    public String userId;
    private Integer duration;
    private Integer caloriesBurned;
    private ActivityType type;
    private Map<String, Object> additionalMetrics;
    private LocalDateTime startTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
