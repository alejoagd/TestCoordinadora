package pages;


import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ApiServiceTest {

    Playwright playwright;
    APIRequest request;
    APIRequestContext requestContext;
    
    @Before
    public void setup(){
        playwright =Playwright.create();
        request = playwright.request();
        requestContext = request.newContext();
    }

        
    @After
    public void tearDown(){
        playwright.close();
    }
    
}
