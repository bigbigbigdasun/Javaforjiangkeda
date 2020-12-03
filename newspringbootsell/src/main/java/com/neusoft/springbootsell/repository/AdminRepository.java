package com.neusoft.springbootsell.repository;

import com.neusoft.springbootsell.dataobject.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,String> {
    Admin findByUsernameAndPassword(String username,String password);
    Admin findByUsername(String username);
}
