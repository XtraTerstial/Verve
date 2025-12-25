package com.XtraCoder.Verve.service;

import com.XtraCoder.Verve.dto.ActivityRequest;
import com.XtraCoder.Verve.dto.ActivityResponse;
import com.XtraCoder.Verve.entity.Activity;
import com.XtraCoder.Verve.entity.User;
import com.XtraCoder.Verve.exceptions.ResourceNotFoundExceptions;
import com.XtraCoder.Verve.repository.ActivityRepository;
import com.XtraCoder.Verve.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {
    
    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


//    public ActivityResponse trackActivity(String userId, ActivityRequest activityRequest) {
//        User user = userRepository
//                .findById(userId)
//                .orElseThrow(()-> new ResourceNotFoundExceptions("User not found with id " + userId));
//
//        Activity activity = modelMapper.map(activityRequest, Activity.class);
//        activity.setUser(user);
//        activity =  activityRepository.save(activity);
//        return modelMapper.map(activity, ActivityResponse.class);
//    }

    public ActivityResponse trackActivity(ActivityRequest activityRequest) {
        User user = userRepository.findById(activityRequest.getUserId())
                .orElseThrow(()-> new ResourceNotFoundExceptions("User not found with id " + activityRequest.getUserId()));
        Activity activity = Activity.builder()
                .user(user)
                .type(activityRequest.getType())
                .duration(activityRequest.getDuration())
                .caloriesBurned(activityRequest.getCaloriesBurned())
                .startTime(activityRequest.getStartTime())
                .additionalMetrics(activityRequest.getAdditionalMetrics())
                .build();

        Activity savedActivity = activityRepository.save(activity);
        return modelMapper.map(savedActivity, ActivityResponse.class);
    }

    public List<ActivityResponse> getUserActivities(String userId){
        //Check if user Exists or Not
        User user = userRepository
                .findById(userId)
                .orElseThrow(()-> new ResourceNotFoundExceptions("User not found with id " + userId));
        //If exists then return his activities
        return activityRepository.findByUserId(userId)
                .stream()
                .map(activity -> modelMapper.map(activity, ActivityResponse.class))
                .collect(Collectors.toList());
    }
}
