package com.XtraCoder.Verve.controller;

import com.XtraCoder.Verve.dto.RecommendationRequest;
import com.XtraCoder.Verve.entity.Recommendation;
import com.XtraCoder.Verve.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recommendation")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping
    public ResponseEntity<Recommendation> generateRecommendation(@RequestBody RecommendationRequest request){
        Recommendation recommendation = recommendationService.generateRecommendation();
        return ResponseEntity.ok(recommendation);
    }
}
