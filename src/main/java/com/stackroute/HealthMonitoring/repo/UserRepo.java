package com.stackroute.HealthMonitoring.repo;

import com.stackroute.HealthMonitoring.model.User;
//add required imports
import org.springframework.stereotype.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);
}
