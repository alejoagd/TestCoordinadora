import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

import java.io.IOException;
import java.util.Map;

import org.junit.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



public class exampleGet {

    Playwright playwright;
    APIRequest request ;
    APIRequestContext requestContext ;

    @BeforeTest
    public void  setup(){
        playwright  = Playwright.create();
        request = playwright.request();
        requestContext = request.newContext();
    }
    


    /*@Test
    public void getSpecificUserApiTest() throws IOException{


        APIResponse apiResponse = apiRequestContext.get("https://gorest.co.in/public/v2/users",RequestOptions.create()
                                .setQueryParam("gender", "male")
                                .setQueryParam("status", "active"));
        
        int statusCode = apiResponse.status();
        System.out.println("response status code :"+statusCode);
        Assert.assertEquals(statusCode,200);
        Assert.assertEquals(true, apiResponse.ok());

        String statusResText = apiResponse.statusText();
        System.out.println(statusResText);


        System.out.println("-----Body Response -------");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonResponse = objectMapper.readTree(apiResponse.body());
        String jsonPrettyResponse = jsonResponse.toPrettyString();
        System.out.println(jsonPrettyResponse);
                                

        


    }*/
    
    @Test
    public void getUsersApiTest() throws IOException{

        APIResponse apiResponse = requestContext.get("https://gorest.co.in/public/v2/users");

        int statusCode = apiResponse.status();
        System.out.println("response status code :"+statusCode);
        Assert.assertEquals(statusCode,200);
        Assert.assertEquals(true, apiResponse.ok());
        

        String statusResText = apiResponse.statusText();
        System.out.println(statusResText);


        System.out.println("-----Body Response -------");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonResponse = objectMapper.readTree(apiResponse.body());
        String jsonPrettyResponse = jsonResponse.toPrettyString();
        System.out.println(jsonPrettyResponse);

        System.out.println("-----Url request -------");
        System.out.println(apiResponse.url());

        System.out.println("-----Headers -------");
        Map<String,String> headersMap = apiResponse.headers();
        System.out.println(headersMap);


    }
    
    
    @AfterTest
    public void tearDown(){
        playwright.close();
    }
    
}
