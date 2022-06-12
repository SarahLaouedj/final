package com.example.jwtauth.service;

import com.example.jwtauth.dao.RoleDao;
import com.example.jwtauth.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(@RequestBody Role role){
        return roleDao.save(role);
    }


}
