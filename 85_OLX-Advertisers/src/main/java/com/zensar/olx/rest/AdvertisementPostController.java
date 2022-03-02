package com.zensar.olx.rest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.olx.bean.AdvertisementPost;
import com.zensar.olx.bean.AdvertisementStatus;
import com.zensar.olx.bean.Category;
import com.zensar.olx.bean.NewAdvertisementPostRequest;
import com.zensar.olx.bean.NewAdvertisementPostResponse;
import com.zensar.olx.bean.OLXUser;
import com.zensar.olx.service.AdvertisementPostService;

@RestController
public class AdvertisementPostController {
	
	@Autowired
	AdvertisementPostService service;
	
	@PostMapping("/advertise/{un}")
	public NewAdvertisementPostResponse add(@RequestBody NewAdvertisementPostRequest request,@PathVariable(name="un") String userName) {
		AdvertisementPost post=new AdvertisementPost();
		post.setTitle(request.getTitle());
		post.setPrice(request.getPrice());
		post.setDescription(request.getDescription());
		
		
		int categoryId=request.getCategoryId();
		
		RestTemplate restTemplate=new RestTemplate();
		Category category;
		String url="http://localhost:9052/advertise/getCategory/"+categoryId;
		category=restTemplate.getForObject(url, Category.class);
		post.setCategory(category);
	//	System.out.println(category);
		
		url="http://localhost:9051/user/find/"+userName;
		OLXUser olxUser=restTemplate.getForObject(url, OLXUser.class);
		post.setOlxUser(olxUser);
		//System.out.println(olxUser);
	
		AdvertisementStatus advertisementStatus=new AdvertisementStatus(1,"OPEN");
		post.setStatus(advertisementStatus);
	//	System.out.println(advertisementStatus);
		
		AdvertisementPost advertisementPost=this.service.addAdvertisementPost(post);
		
		NewAdvertisementPostResponse response=new NewAdvertisementPostResponse();
		response.setId(advertisementPost.getId());
		response.setTitle(advertisementPost.getTitle());
		response.setPrice(advertisementPost.getPrice());
		response.setCategory(advertisementPost.getCategory().getName());
		response.setDescription(advertisementPost.getDescription());
		response.setUserName(advertisementPost.getOlxUser().getUserName());
		response.setCreatedDate(advertisementPost.getCreatedDate());
		response.setModifiedDate(advertisementPost.getModifiedDate());
		response.setStatus(advertisementStatus.getStatus());
		return response;
	}
	
	@PutMapping("/advertise/{aid}/{userName}")
	public NewAdvertisementPostResponse f2(@RequestBody NewAdvertisementPostRequest request,@PathVariable(name="aid")int id,@PathVariable(name="userName") String userName) {
		
		AdvertisementPost post=this.service.getAdvertisementById(id);
		
		post.setTitle(request.getTitle());
		post.setPrice(request.getPrice());
		post.setDescription(request.getDescription());
		
		RestTemplate restTemplate=new RestTemplate();
		
		Category category;
		String url="http://localhost:9052/advertise/getCategory/"+request.getCategoryId();
		category=restTemplate.getForObject(url, Category.class);
		post.setCategory(category);
		
		url="http://localhost:9051/user/find/"+userName;
		OLXUser olxUser=restTemplate.getForObject(url, OLXUser.class);
		post.setOlxUser(olxUser);
		
		AdvertisementStatus advertisementStatus;
		url="http://localhost:9052/advertise/status/"+request.getStatusId();
		advertisementStatus=restTemplate.getForObject(url, AdvertisementStatus.class);
		post.setStatus(advertisementStatus);
		
		AdvertisementPost advertisementPost=this.service.updateAdvertisementPost(post);
		
		NewAdvertisementPostResponse postResponse;
		postResponse=new NewAdvertisementPostResponse();
		
		postResponse.setId(advertisementPost.getId());
		postResponse.setTitle(advertisementPost.getTitle());
		postResponse.setDescription(advertisementPost.getDescription());
		postResponse.setPrice(advertisementPost.getPrice());
		postResponse.setUserName(advertisementPost.getOlxUser().getUserName());
		postResponse.setCategory(advertisementPost.getCategory().getName());
		postResponse.setCreatedDate(advertisementPost.getCreatedDate());
		postResponse.setModifiedDate(advertisementPost.getModifiedDate());
		postResponse.setStatus(advertisementPost.getStatus().getStatus());
		
		return postResponse;
	}
	
	
	/*
	 * @GetMapping("/user/advertise/{userName}") public List<AdvertisementPost>
	 * f3(@PathVariable(name="userName") String userName) {
	 * 
	 * 
	 * return this.service.getAdvertisementByUserName(userName); }
	 */
	 
	
	@GetMapping("/user/advertise/{userName}")
	public List<NewAdvertisementPostResponse> f3(@PathVariable(name = "userName") String userName) 
	{
		List<AdvertisementPost> advPost = this.service.getAllAdvertisementPost();
		RestTemplate restTemplate = new RestTemplate();
		List<AdvertisementPost> filterList = new ArrayList<>();
		String url = "http://localhost:9051/user/find/" + userName;
		OLXUser olxUser = restTemplate.getForObject(url, OLXUser.class);
		
		for (AdvertisementPost post : advPost) {
			Category category;
			url = "http://localhost:9052/advertise/getCategory/" + post.getCategory().getId();
			category = restTemplate.getForObject(url, Category.class);
			post.setCategory(category);
			System.out.println("Category-------" + post);

			url = "http://localhost:9052/advertise/status/" + post.getStatus().getId();
			AdvertisementStatus advertisementStatus;
			advertisementStatus = restTemplate.getForObject(url, AdvertisementStatus.class);
			post.setStatus(advertisementStatus);
			System.out.println("AdvertisementStatus" + post);
			if (olxUser.getOlxUserId() == post.getOlxUser().getOlxUserId()) {
				post.setOlxUser(olxUser);
				filterList.add(post);
			}
		}
		System.out.println("List--------------" + filterList);
		List<NewAdvertisementPostResponse> responseList = new ArrayList<>();
		for (AdvertisementPost advertisementPost : filterList) {
			NewAdvertisementPostResponse postRespone = new NewAdvertisementPostResponse();
			postRespone.setId(advertisementPost.getId());
			postRespone.setTitle(advertisementPost.getTitle());
			postRespone.setDescription(advertisementPost.getDescription());
			postRespone.setPrice(advertisementPost.getPrice());
			postRespone.setUserName(advertisementPost.getOlxUser().getUserName());
			postRespone.setCategory(advertisementPost.getCategory().getName());
			postRespone.setCreatedDate(advertisementPost.getCreatedDate());
			postRespone.setModifiedDate(advertisementPost.getModifiedDate());
			postRespone.setStatus(advertisementPost.getStatus().getStatus());
			responseList.add(postRespone);
		}
		return responseList;
	}
	  
	
	  @GetMapping("/users/advertise/{advertiseId}") 
	  public NewAdvertisementPostResponse f4(@PathVariable(name="advertiseId") int advertiseId) { 
		  
		  AdvertisementPost advertisementPost=service.getAdvertisementById(advertiseId);
		  
		  System.out.println(advertisementPost); 
		    RestTemplate restTemplate=new RestTemplate();
			
			Category category;
			String url="http://localhost:9052/advertise/getCategory/"+advertisementPost.getCategory().getId();
			category=restTemplate.getForObject(url, Category.class);
			
			  System.out.println(category);
			
			  url="http://localhost:9051/user/"+advertisementPost.getOlxUser().getOlxUserId();
			  OLXUser olxUser=restTemplate.getForObject(url, OLXUser.class);
			  System.out.println(olxUser);
			  advertisementPost.setOlxUser(olxUser);
			  url="http://localhost:9052/advertise/status/"+advertisementPost.getStatus().getId();
			  AdvertisementStatus advertisementStatus=restTemplate.getForObject(url,AdvertisementStatus.class);
			  System.out.println(advertisementStatus);		  
			  advertisementPost.setStatus(advertisementStatus);
			  NewAdvertisementPostResponse response=new NewAdvertisementPostResponse();
			  response.setId(advertisementPost.getId());
			  response.setTitle(advertisementPost.getTitle());
			  response.setPrice(advertisementPost.getPrice());
			  response.setCategory(category.getName());
			  response.setUserName(advertisementPost.getOlxUser().getUserName());
			  response.setDescription(advertisementPost.getDescription());
			  response.setCreatedDate(advertisementPost.getCreatedDate());
			  response.setModifiedDate(advertisementPost.getModifiedDate());
			  response.setStatus(advertisementStatus.getStatus());
		  return response;
	  }
	 
	  
	  @DeleteMapping("/users2/advertise/{aID}")
	  public boolean deleteAd(@PathVariable(name="aID")int aID)
	  {
		  AdvertisementPost advertisementPost=this.service.getAdvertisementById(aID);
		  System.out.println(advertisementPost);
		  return this.service.deleteAdvertisementPost(advertisementPost);
	  }
	
}