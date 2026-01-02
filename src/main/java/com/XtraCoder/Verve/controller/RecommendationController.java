package com.XtraCoder.Verve.controller;

import com.XtraCoder.Verve.dto.RecommendationRequest;
import com.XtraCoder.Verve.entity.Recommendation;
import com.XtraCoder.Verve.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendation")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping
    public ResponseEntity<Recommendation> generateRecommendation(@RequestBody RecommendationRequest request){
        Recommendation recommendation = recommendationService.generateRecommendation(request);
        return ResponseEntity.ok(recommendation);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Recommendation>> getUserRecommendations(@PathVariable String userId){
        List<Recommendation> userRecommendationList = recommendationService.getUserRecommendations(userId);
        return ResponseEntity.ok(userRecommendationList);
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<Recommendation>> getActivityRecommendations(@PathVariable String activityId){
        List<Recommendation> activityRecommendations = recommendationService.getActivityRecommendations(activityId);
        return ResponseEntity.ok(activityRecommendations);
    }
}
