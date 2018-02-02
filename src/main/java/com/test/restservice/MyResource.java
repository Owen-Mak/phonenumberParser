package com.test.restservice;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.i18n.phonenumbers.*;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

import java.text.ParseException;

/**
 * Root resource (exposed at "myresource" path)
 */

@Path("/phonenumbers/parse/text")
public class MyResource {

	public MyResource(){}
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     * @return 
     *
     * @return String that will be returned as a text/plain response.
     * @throws IOException 
     * @throws NumberParseException 
     * @throws JSONException 
     * @throws ParseException 
     * @throws UnsupportedEncodingException 
     */
	getJson get = new getJson();
	   public void doFilter(ServletRequest request, ServletResponse response,
		       FilterChain filterChain) throws IOException, ServletException
		   {
		       HttpServletRequest httpRequest = (HttpServletRequest) request;        
		       if(httpRequest.getMethod().equalsIgnoreCase("POST")){

		       }
		       filterChain.doFilter(request, response);
		   }
	//Returns empty list if nothing is passed
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response init(){

		 return Response.ok().entity("[]").build();
	}
	
	@GET
    @Path("/{param}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response doGet(@PathParam("param") String num)throws NumberParseException, ParseException, UnsupportedEncodingException{    
	        
    		PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
	        PhoneNumber phoneNumber = phoneUtil.parse(num, "CA");
	       	String formatted = phoneUtil.format(phoneNumber, PhoneNumberFormat.RFC3966).substring(1);
		    String [] phoneSplit = formatted.split("-"); 
		    get = new getJson(phoneSplit[1],phoneSplit[2],phoneSplit[3]);
		    System.out.println(get.getPhoneNumber());
		   
	        return Response.ok().entity("["+get.getPhoneNumber()+"]").build(); 
	     	 
    	}
	@POST
    @Path("/file")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)

    public Response doPost() throws NumberParseException{
    	
    	File file = new File("test.txt");
    	
		int i = 0;
		String[] numberList = new String[100];
		ArrayList<String> list = new ArrayList<>();
		
		if(file.exists())
    	{
			try {
				Scanner fileScanner = new Scanner(file);
			
			while(fileScanner.hasNext()){
				String number = fileScanner.next();
			    number = number.replaceAll("\\s", "").trim();
				PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
		        PhoneNumber phonenumber = phoneUtil.parse(number, "CA");
		        String formatted = phoneUtil.format(phonenumber, PhoneNumberFormat.RFC3966);
		        String [] phoneSplit = formatted.split("[- ]"); 
		        get = new getJson(phoneSplit[1],phoneSplit[2],phoneSplit[3]);
		        
		        list.add(get.getPhoneNumber());
		        numberList[i] = get.toString();
		      
	            
			}
			removeDuplicate(list);
	        System.out.println(list);
	        } catch (FileNotFoundException e) {
				e.printStackTrace();
			  }
		 }else{return Response.ok(40).entity("File not found").build();}
		
		return Response.ok(201).entity("["+list+"]").build(); 
    }

    public static void removeDuplicate(ArrayList<String> list) {

        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
        	//if temp does not contain list[i]
            if (!temp.contains(list.get(i))) {
                temp.add(list.get(i));
            }
        }
        //clear list and add distinct integer back to list
        list.clear();
        list.addAll(temp);
    }
   }


