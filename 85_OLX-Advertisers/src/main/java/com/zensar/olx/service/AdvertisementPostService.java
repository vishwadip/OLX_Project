package com.zensar.olx.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.zensar.olx.bean.AdvertisementPost;
import com.zensar.olx.db.AdvertisementPostDAO;

@Service
public class AdvertisementPostService {
	
	@Autowired
	AdvertisementPostDAO dao;
	
	@PostMapping
	public AdvertisementPost addAdvertisementPost(AdvertisementPost advertisementPost) {
		return this.dao.save(advertisementPost);
	}
	
	public AdvertisementPost updateAdvertisementPost(AdvertisementPost advertisementPost) {
		return this.dao.save(advertisementPost);
	}
	
	public List<AdvertisementPost> getAllAdvertisementPost(){
		return this.dao.findAll();
	}
	
	public boolean deleteAdvertisementPost(AdvertisementPost advertisementPost) {
		boolean result=true;
		try {
			this.dao.delete(advertisementPost);
			result=true;
		}catch(Exception e)
		{
			e.printStackTrace();
			result=false;
		}
		return result;
	}
				
		public AdvertisementPost getAdvertisementById(int id)
		{
			Optional<AdvertisementPost> optional;
			optional=dao.findById(id);
			if(optional.isPresent())
			{
				return optional.get();
			}
			else
				return null;
		}
		
		/*
		 * public List<AdvertisementPost> getAdvertisementByUserName(String userName) {
		 * return this.dao.findAllByUserName(userName);
		 * 
		 * }
		 */
		
		
}
