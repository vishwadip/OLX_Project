package com.zensar.olx.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.olx.bean.LoginUser;
import com.zensar.olx.bean.OLXUser;
import com.zensar.olx.service.OLXUserService;

public interface OLXUserDAO extends JpaRepository<OLXUser, Integer >{

	OLXUser findByUserName(String username);
}
