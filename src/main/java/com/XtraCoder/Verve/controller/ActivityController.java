package com.XtraCoder.Verve.controller;

import com.XtraCoder.Verve.dto.ActivityRequest;
import com.XtraCoder.Verve.dto.ActivityResponse;
import com.XtraCoder.Verve.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest activityRequest){

        ActivityResponse savedActivity = activityService.trackActivity(activityRequest);
        return new ResponseEntity<>(savedActivity, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ActivityResponse>> getUserActivities(@PathVariable String userId) {
        List<ActivityResponse> activities = activityService.getUserActivities(userId);
        return ResponseEntity.ok(activities);
    }
}
