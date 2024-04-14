package com.Event.EventEaze.Data.Repositories;

import com.Event.EventEaze.Data.Models.Admin;
import com.Event.EventEaze.Data.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findByEmail(String email);
}
