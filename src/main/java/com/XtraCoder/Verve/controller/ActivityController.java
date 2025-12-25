package com.XtraCoder.Verve.controller;

import com.XtraCoder.Verve.dto.ActivityDto;
import com.XtraCoder.Verve.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService actitvityService;

    @PostMapping("/{userId}")
    public ResponseEntity<ActivityDto> trackActivity(@PathVariable String userId,
                                                     @RequestBody ActivityDto activityTracker){

        ActivityDto savedActivity = actitvityService.trackActivity(userId, activityTracker);
        return new ResponseEntity<>(savedActivity, HttpStatus.OK);
    }
}
