package com;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.model.User;

public class UserTest extends RestAppApplicationTests {
	@Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	
	   @Test
	   public void getUsersList() throws Exception {
	      String uri = "/users";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	    	 .with(httpBasic("luca", "123"))
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      User[] userList = super.mapFromJson(content, User[].class);
	      assertTrue(userList.length > 0);
	   }
	   
	   
	   @Test
	   public void createProduct() throws Exception {
	      String uri = "/users";
	      User product = new User();
	      product.setId(Long.valueOf(45));
	      product.setName("ProvaPrima");
	      
	      String inputJson = super.mapToJson(product);
	      
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	    		  .with(httpBasic("luca", "123"))
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      System.out.println("CONTENT " + content);
	      assertEquals(content, inputJson);
	   }
	   
	   @Test
	   public void updateUser() throws Exception {
	      String uri = "/users";
	      User user = new User();
	      user.setId(Long.valueOf(45));
	      user.setName("ProvaSeconda");
	      user.setPassword("password");
	      String inputJson = super.mapToJson(user);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
	    		  .with(httpBasic("luca", "123"))
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, inputJson);
	   }
	   
	   
	   @Test
	   public void deleteProduct() throws Exception {
	      String uri = "/users/45";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri).with(httpBasic("luca", "123"))).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "User is deleted successfully");
	   }
	   
}
