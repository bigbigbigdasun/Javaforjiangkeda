package com.neusoft.dao;

import com.neusoft.domain.admin;

public interface AdminDao {
    public admin getAdminByNameAndPassword(String adminName, String password);

}