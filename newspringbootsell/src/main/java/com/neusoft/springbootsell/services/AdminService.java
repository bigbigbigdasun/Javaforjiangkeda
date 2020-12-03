package com.neusoft.springbootsell.services;

import com.neusoft.springbootsell.dataobject.Admin;

public interface AdminService {
    Admin res(Admin admin);

    public Admin login(String username,String password);
}
