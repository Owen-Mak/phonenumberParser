package com.test.restservice;

import static org.junit.Assert.*;

import org.junit.Test;

import com.test.restservice.getJson;

public class getJsonTest {
	@Test
	public void testGetJson(){
		System.out.println("Testing getJson");
		System.out.println("--------------------------");
		getJson get = new getJson();
		
		System.out.println("Setting phone number: 4162224444");
		get.setAreaCode("416");
		get.setprefix("222");
		get.setlineNum("4444");
		
		System.out.println("Expected: [\"(416) 222-4444\"]\n" +  "Actual: " + get.getPhoneNumber());
		assertEquals("[\"(416) 222-4444\"]",get.getPhoneNumber());	
	}
}
