package com.qlzw.smartwc.service;

import com.qlzw.smartwc.mapper.Admin_userMapper;
import com.qlzw.smartwc.mapper.RoleMapper;
import com.qlzw.smartwc.model.Admin_user;
import com.qlzw.smartwc.model.Role;
import com.qlzw.smartwc.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private Admin_userMapper admin_userMapper;

    @Autowired
    private RoleRepository roleRepository;

    public boolean isAdminRole(String token) {

        Admin_user admin_user = admin_userMapper.getUserWithToken(token);

        if (admin_user != null) {

            Long role_id = Long.valueOf(admin_user.getRole_id());

            System.out.println(role_id);

            Role role = roleMapper.show(role_id);

            System.out.println(role);

            if (role.getId() == 1) {

                return true;
            }
        }

        return false;
    }
}
