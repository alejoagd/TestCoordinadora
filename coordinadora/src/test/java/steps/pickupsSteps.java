package steps;

import io.cucumber.java.en.*;

import java.io.IOException;
import java.util.*;

//import org.junit.Assert;
//import org.testng.asserts.SoftAssert;


import io.cucumber.java.en.Given;
import pages.ApiService;

public class pickupsSteps {

    ApiService apiService = new ApiService();


    @Given("que el usuario accede al formulario de solicitud de recogida")
    public void fillRequest() throws IOException{
        System.out.println("Diligenciando el formulario completo");
    }

    @When("el usuario ingresa una fecha de recogida fuera del formato yyyy-mm-dd")
    public void formatofecha() throws IOException{
        System.out.println("----------TextResponse----");
        apiService.createPickup("04-05-2024","Cl 120 # 20 30");
    }

    @Then("se muestra un mensaje de error indicando que el formato de fecha es incorrecto")
    public void responseMessage(){
        System.out.println("----------TextResponse----");

    
    }

    @When("el usuario ingresa una fecha de recogida que es una fecha pasada")
    public void datoFecha() throws IOException{
        apiService.createPickup("2024-06-10","Cl 120 # 20 30");
    }

    @Then("se muestra un mensaje de error indicando que la fecha de recogida debe ser una fecha pasado los 5 dias habiles siguientes")
    public void responseMessage2(){
        System.out.println("----------TextResponse----");
    }

    @When("el usuario intenta crear una nueva solicitud con la misma dirección y fecha ya creadas")
    public void direccionyFecha() throws IOException{
        apiService.createPickup("2024-05-10","Cl 40 # 20 30");
    }

    @Then("se muestra un mensaje de error indicando que ya existe una solicitud de recogida para esa dirección y fecha")
    public void responseMessage3(){
        System.out.println("----------TextResponse----");
    }


    



}
