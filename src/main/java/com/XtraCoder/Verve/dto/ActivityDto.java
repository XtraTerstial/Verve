package com.XtraCoder.Verve.dto;

import com.XtraCoder.Verve.entity.enums.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDto {

    private String id;
    private Integer duration;
    private Integer caloriesBurned;
    private ActivityType type;
    private Map<String, Object> additionalMetrics;
}
