package com.rsi.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rsi.kafka.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

}
