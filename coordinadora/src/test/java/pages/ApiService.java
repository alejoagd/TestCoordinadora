package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

import io.cucumber.java.it.Date;
import io.cucumber.java.it.Date;
import io.cucumber.java.it.Date;
import io.cucumber.messages.types.Exception;

import io.cucumber.messages.types.Exception;

public class ApiService extends RuntimeException{


    public void createPickup(String fecha,String direccion) throws IOException{

        //Lista [] con un objeto {} de medidas aproximadas dentro del body 
        List<Map<String, Object>> medidasAproximadas = new ArrayList<>();
        Map<String,Object> medida= new LinkedHashMap<>();
        medida.put("id",2);
        medida.put("tipoPaq","Par de zapatos");
        medida.put("nombrePaq","Par de za...");
        medida.put("cantidad",1);
        medidasAproximadas.add(medida);

        // Convierte la lista a JSON
        ObjectMapper objectMapper1 = new ObjectMapper();
        try {
            String medidasAproximadasJson = objectMapper1.writeValueAsString(medidasAproximadas);
            System.out.println("----------MedidasAproximadas----");
            System.out.println(medidasAproximadasJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //Objeto {} con detalles de ciudades dentro del body 
        Map<String,Object> detalle= new LinkedHashMap<>();
        detalle.put("nombre_terminal_operativa","Medellin");
        detalle.put("tipo_servicio","A");
        detalle.put("dane_ciudad","05266");
        detalle.put("dane_actual","05266000");
        detalle.put("ciudad_tarifa","05266000");
        detalle.put("sms",true);
        detalle.put("cubre_mqp",true);
        detalle.put("codigo_postal","055428");
        detalle.put("terminal_operativa",2);
        detalle.put("cubre_me",true);
        detalle.put("area_telefono",4);
        detalle.put("observaciones2","FCE - RD - FD - RCE");
        detalle.put("codigo","05266000");
        detalle.put("tipo_poblacion","D");
        detalle.put("activo",true);
        detalle.put("codigo_terminal",2);
        detalle.put("codigo_interno",204);
        detalle.put("mensajeria",true);
        detalle.put("cubre_mm",false);
        detalle.put("departamento","05");
        detalle.put("cubre_cm",false);
        detalle.put("nombre","Envigado (Ant)");
        detalle.put("abreviado","ENVIGADO");
        detalle.put("nombre_terminal","Medellin");
        detalle.put("observaciones","ejemplo");

        // Convierte la lista a JSON
        ObjectMapper objectMapper2 = new ObjectMapper();
        try {
            String detalleJson = objectMapper2.writeValueAsString(detalle);
            System.out.println("----------CiudadDetalle----");
            System.out.println(detalleJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        


        //Creando el body de la solicitud
        Map<String,Object> data= new LinkedHashMap<>();
        data.put("tipoEnvio","1");
        data.put("tipoProducto","4");
        data.put("indicativo","57");
        data.put("tipoDocumento","13");
        data.put("email","ana@gmail.com");
        data.put("personaEntrega","1");
        data.put("indicativoEntrega","57");
        data.put("medidasAproximadas",medidasAproximadas);
        data.put("ciudad","Envigado (Ant)");
        data.put("via","ppal");
        data.put("numero","1");
        data.put("detalle","PARQUE SAN JOSE BOD 14");
        data.put("tipoVia",16);
        data.put("nombres","prueba");
        data.put("apellidos","prueba1");
        data.put("documento","1036149000");
        data.put("celular","3005777777");
        data.put("ciudadDetalle",detalle);
        data.put("direccion",direccion);
        data.put("fechaRecogida",fecha);
        data.put("nombreEntrega","prueba");
        data.put("apellidosEntrega","prueba1");
        data.put("celularEntrega","3045677778");
        data.put("emailUsuario","anar.723@gmail.com");
        data.put("descripcionTipoVia","Kilómetro");
        data.put("aplicativo","envios");

        // Convierte la lista a JSON
        ObjectMapper objectMapper3 = new ObjectMapper();
        try {
            String dataJson = objectMapper3.writeValueAsString(data);
            System.out.println("----------Data----");
            System.out.println(dataJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        //POST call 

        Playwright playwright = Playwright.create();
        APIRequest request = playwright.request();

       
        try{
            APIRequestContext requestContext = request.newContext();

            APIResponse apiPostResponse = requestContext.post("https://apiv2-test.coordinadora.com/recogidas/cm-solicitud-recogidas-ms/solicitud-recogida",
            RequestOptions.create()
                .setHeader("Postman-Token","4824152f-601a-4d1f-8153-43969ec40701")
                .setHeader("Content-Type", "application/json")
                .setHeader("Cache-Control","no-cache")
                .setHeader("Accept-Encoding", "gzip, deflate, br")
                .setHeader("User-Agent","PostmanRuntime/7.38.0")
                .setHeader("Accept", "*/*")
                //.setHeader("Authorization", "Bearer 874a55150ed7467421676388095d602845472c097a980167005b7f367b76283b")
                .setData(data));

        System.out.println("----------TextResponse----");
        
        System.out.println(apiPostResponse.text());
        System.out.println("----------ToString----");

        

        System.out.println("----------Status-----");
        System.out.println(apiPostResponse.status());

         //Parseando la respueta del error
         String responseBody = apiPostResponse.text();
         ObjectMapper objectMapper4 = new ObjectMapper();
         JsonNode jsonResponse = objectMapper4.readTree(responseBody);
 
         //Extrayendo el mensaje del error
         
         String errorMessage = jsonResponse.path("data").path("message").asText();
         String idRecogidaAnterior = jsonResponse.path("data").path("idRecogidaAnterior").asText();
         String recogida_anterior = jsonResponse.path("data").path("recogida_anterior").asText();
 
         //imprimiendo el mensaje de error
         System.out.println("----------Error Message----");
         System.out.println("Error:"+ errorMessage);    
         System.out.println("idRecogidaAnterior:"+ idRecogidaAnterior);    
         System.out.println("recogida_anterior:"+ recogida_anterior);    

        Assert.assertEquals(200, apiPostResponse.status());
        
        Assert.assertEquals("OK", apiPostResponse.statusText());
        Assert.assertEquals("", errorMessage);

        

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode postJsonResponse = objectMapper.readTree(apiPostResponse.body());
        System.out.println("----------Body----");
        System.out.println(postJsonResponse.toPrettyString());


        }catch(ApiService e ){
            System.out.println("Error al realizar la solicitud  POST : "+ e.getMessage());
            e.printStackTrace(); 

        }
        

    }
    
}
