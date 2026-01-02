package com.XtraCoder.Verve.service;

import com.XtraCoder.Verve.dto.RecommendationRequest;
import com.XtraCoder.Verve.entity.Activity;
import com.XtraCoder.Verve.entity.Recommendation;
import com.XtraCoder.Verve.entity.User;
import com.XtraCoder.Verve.exceptions.ResourceNotFoundExceptions;
import com.XtraCoder.Verve.repository.ActivityRepository;
import com.XtraCoder.Verve.repository.RecommendationRepository;
import com.XtraCoder.Verve.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;
    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final ModelMapper modelMapper;

    public Recommendation generateRecommendation(RecommendationRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(()-> new ResourceNotFoundExceptions("User not found with id " + request.getUserId()));
        Activity activity = activityRepository.findById(request.getActivityId())
                .orElseThrow(()-> new ResourceNotFoundExceptions("Activity not found with id " + request.getActivityId()));

        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .activity(activity)
                .improvements(request.getImprovements())
                .suggestions(request.getSuggestions())
                .safety(request.getSafety())
                .build();

        return recommendationRepository.save(recommendation);

    }

    public List<Recommendation> getUserRecommendations(String userId) {
        if(!userRepository.existsById(userId)){
            throw new ResourceNotFoundExceptions("User not found with id " + userId);
        }

        return recommendationRepository.findByUserId(userId)
                .stream()
                .map(recommendation -> modelMapper.map(recommendation, Recommendation.class))
                .collect(Collectors.toList());
    }

    public List<Recommendation> getActivityRecommendations(String activityId) {
        if(!activityRepository.existsById(activityId)){
            throw new ResourceNotFoundExceptions("Activity not found with id " + activityId);
        }

        return recommendationRepository.findByActivityId(activityId)
                .stream()
                .map(recommendation -> modelMapper.map(recommendation, Recommendation.class))
                .collect(Collectors.toList());
    }
}
