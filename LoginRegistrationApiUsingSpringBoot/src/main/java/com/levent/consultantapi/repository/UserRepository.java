package com.levent.consultantapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.levent.consultantapi.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN 'true' ELSE 'false' END FROM User u WHERE u.email = :email")
	public Boolean existsByEmail(@Param("email") String email);

	public User findByUuid(String uuid);

	User getById(Integer id);

	/*
	 * @Modifying
	 * 
	 * @Query("UPDATE User u SET u.email=:#{#user.email}") User
	 * updateById(@Param("id")Long id, @Param("user")User user);
	 */

}