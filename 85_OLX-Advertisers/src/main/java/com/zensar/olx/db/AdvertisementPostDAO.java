package com.zensar.olx.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.olx.bean.AdvertisementPost;

@Repository
public interface AdvertisementPostDAO extends JpaRepository<AdvertisementPost, Integer> {
	
	/* public List<AdvertisementPost> findAllByUserName( String userName); */

}
