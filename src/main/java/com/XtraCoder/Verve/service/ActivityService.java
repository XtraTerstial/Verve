package com.XtraCoder.Verve.service;

import com.XtraCoder.Verve.dto.ActivityDto;
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
    
    private final ActivityRepository actitvityRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public ActivityDto trackActivity(String userId, ActivityDto activityTracker) {
        User user = userRepository
                .findById(userId)
                .orElseThrow(()-> new ResourceNotFoundExceptions("User not found with id " + userId));

        Activity activity = modelMapper.map(activityTracker, Activity.class);
        activity.setUser(user);
        activity =  actitvityRepository.save(activity);
        return modelMapper.map(activity, ActivityDto.class);
    }

    public List<ActivityDto> getAllUserActivities(String userId){
        //Check if user Exists or Not
        User user = userRepository
                .findById(userId)
                .orElseThrow(()-> new ResourceNotFoundExceptions("User not found with id " + userId));
        //If exists then return his activities
        return actitvityRepository.findByUserId(userId)
                .stream()
                .map(activity -> modelMapper.map(activity, ActivityDto.class))
                .collect(Collectors.toList());
    }
}
