package com.rsi.excel.apachepoi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rsi.excel.apachepoi.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

}
