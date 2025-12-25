package com.XtraCoder.Verve.repository;

import com.XtraCoder.Verve.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, String> {

    List<Activity> findByUserId(String userId);
}
