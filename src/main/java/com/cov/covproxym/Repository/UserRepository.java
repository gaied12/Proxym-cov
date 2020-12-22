package com.cov.covproxym.Repository;

import com.cov.covproxym.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
   Optional <User> findByUserName(String username);

}
