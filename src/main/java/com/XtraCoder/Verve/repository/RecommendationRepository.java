package com.XtraCoder.Verve.repository;

import com.XtraCoder.Verve.entity.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<Recommendation, String> {
}
