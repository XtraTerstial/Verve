package com.XtraCoder.Verve.service;

import com.XtraCoder.Verve.entity.Recommendation;
import com.XtraCoder.Verve.repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;

    public Recommendation generateRecommendation() {

    }
}
