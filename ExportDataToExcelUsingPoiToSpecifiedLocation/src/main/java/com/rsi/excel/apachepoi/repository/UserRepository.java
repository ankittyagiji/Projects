package com.rsi.excel.apachepoi.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rsi.excel.apachepoi.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

	User getById(Integer id);

}
