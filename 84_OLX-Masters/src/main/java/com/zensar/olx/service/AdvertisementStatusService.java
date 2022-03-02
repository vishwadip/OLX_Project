package com.zensar.olx.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.olx.bean.AdvertisementStatus;
import com.zensar.olx.bean.Category;
import com.zensar.olx.db.AdvertisementStatusDAO;
import com.zensar.olx.db.CategoryDAO;

@Service
public class AdvertisementStatusService {

	@Autowired
	AdvertisementStatusDAO advertisementStatusDAO;
	
	public AdvertisementStatus addAdvertisementStatus(AdvertisementStatus advertisementStatus)
	{
		return this.advertisementStatusDAO.save(advertisementStatus);
	}
	
	public List<AdvertisementStatus> getAllAdvertisementStatus()
	{
		return this.advertisementStatusDAO.findAll();
	}
	
	public AdvertisementStatus findAdvertisementStatus(int id) {
		Optional<AdvertisementStatus> optional=this.advertisementStatusDAO.findById(id);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}
	
}
