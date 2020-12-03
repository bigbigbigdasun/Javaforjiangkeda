package com.neusoft.springbootsell.services.impl;

import com.neusoft.springbootsell.dao.AdminDao;
import com.neusoft.springbootsell.dao.impl.AdminDaoImpl;
import com.neusoft.springbootsell.dataobject.Admin;
import com.neusoft.springbootsell.enums.ResultEnum;
import com.neusoft.springbootsell.exception.AdminException;
import com.neusoft.springbootsell.repository.AdminRepository;
import com.neusoft.springbootsell.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
        @Autowired
        private AdminRepository repository;

    @Override
    public Admin res(Admin admin) {
       String username=admin.getUsername();
       String password=admin.getPassword();
       Admin result=repository.findByUsernameAndPassword(username,password);
        if(result != null){
            throw new AdminException(ResultEnum.ADMIN_EXIST);
        }
        String Username =admin.getUsername();
        admin.setUsername(Username);
        admin.setPassword(password);
        return repository.save(admin);
    }

    @Override
    public Admin login(String Username, String Password) {
        Admin result = repository.findByUsername(Username);
        if(result == null){
            throw new AdminException(ResultEnum.ADMIN_EXIST);
        }
        if(!Password.equals(result.getPassword())){
            throw new AdminException(ResultEnum.ADMIN_PASSWORD_ERROR);
        }
        Admin user = new Admin();
        user.setUsername(Username);
        user.setPassword(Password);
        return user;
    }
}