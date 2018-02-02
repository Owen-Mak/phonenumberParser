package com.test.restservice;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import junit.framework.TestCase;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import com.google.i18n.phonenumbers.PhoneNumberMatch;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

public class MyResourceTest extends TestCase{
	
    public static interface MyResourceService{
        MyResource getMyResource();
    }
    
    @Mock
    private MyResource myResourceMock;
    
	@Before
	protected void setUp() throws Exception {
	    	MockitoAnnotations.initMocks(this);
	}
	@Test
    protected void testDoGet() throws Exception{
		
		MyResource get = new MyResource();
		System.out.println("Expected Result: [\"(416) 222-4444\"]\nActual Result:   " + get.doGet("4162224444"));
		assertEquals("[\"(416) 222-4444\"]", get.doGet("4162224444"));	
	}

	@Test
	protected void testGetPost() {
       /* Response response = server.newRequest("/file").request().buildPost(Entity.text("test.txt")).invoke();
        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());	*/
	}
	
	@Test
	public void test() throws Exception {
		testDoGet();
	}

}
