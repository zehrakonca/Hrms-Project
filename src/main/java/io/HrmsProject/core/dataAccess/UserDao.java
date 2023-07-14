package io.HrmsProject.core.dataAccess;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.HrmsProject.core.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	User findById(User user);

	Optional<User> findByEmailAndPassword(String email, String password);
	Optional<User> findByEmail(String email);

}
