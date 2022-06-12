package com.example.jwtauth.service;

import com.example.jwtauth.dao.RoleDao;
import com.example.jwtauth.dao.UserDao;
import com.example.jwtauth.entity.Role;
import com.example.jwtauth.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(User user){
        return userDao.save(user);
    }
    public void initRolesAndUser() {
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role chirurgienRole = new Role();
        chirurgienRole.setRoleName("Chirurgien");
        chirurgienRole.setRoleDescription("Chirurgien role");
        roleDao.save(chirurgienRole);

        Role infirmierRole = new Role();
        infirmierRole.setRoleName("Infirmier");
        infirmierRole.setRoleDescription("Infirmier role");
        roleDao.save(infirmierRole);

        Role anesthesisteRole = new Role();
        anesthesisteRole.setRoleName("Anesthesiste");
        anesthesisteRole.setRoleDescription("Anesthesiste role");
        roleDao.save(anesthesisteRole);

        Role residentRole = new Role();
        residentRole.setRoleName("Resident");
        residentRole.setRoleDescription("Resident role");
        roleDao.save(residentRole);

        Role instrumentisteRole = new Role();
        instrumentisteRole.setRoleName("Instrumentiste");
        instrumentisteRole.setRoleDescription("Instrumentiste role");
        roleDao.save(instrumentisteRole);

        Role coordinateurRole = new Role();
        coordinateurRole.setRoleName("Coordinateur");
        coordinateurRole.setRoleDescription("Coordinateur role");
        roleDao.save(coordinateurRole);

        User adminUser = new User();
        adminUser.setUserFirstName("Sarah");
        adminUser.setUserLastName("Laouedj");
        adminUser.setUserName("sarah");
        adminUser.setUserPassword(getEncodedPassword("sarah123"));
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        User chirurgien = new User();
        chirurgien.setUserFirstName("Djazia");
        chirurgien.setUserLastName("Chir");
        chirurgien.setUserName("djazia");
        chirurgien.setUserPassword(getEncodedPassword("djazia123"));
        Set<Role> chirurgienRoles = new HashSet<>();
        chirurgienRoles.add(chirurgienRole);
        chirurgien.setRole(chirurgienRoles);
        userDao.save(chirurgien);
    }

    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }
}

