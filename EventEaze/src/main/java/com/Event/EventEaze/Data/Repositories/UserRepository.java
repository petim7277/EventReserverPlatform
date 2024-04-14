package com.Event.EventEaze.Data.Repositories;

import com.Event.EventEaze.Data.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByName(String name);

}
