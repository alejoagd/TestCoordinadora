import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

public class requestPostTest {

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
  
    @Test
    public void createUserText() throws IOException{

        //Lista [] con un objeto {} de medidas aproximadas dentro del body 
        List<Map<String, Object>> medidasAproximadas = new ArrayList<>();
        Map<String,Object> medida= new HashMap<>();
        medida.put("id",2);
        medida.put("TipoPaq","Par de zapatos");
        medida.put("NombrePaq","Par de za...");
        medida.put("Cantidad",1);
        medidasAproximadas.add(medida);

        //Objeto {} con detalles de ciudades dentro del body 
        Map<String,Object> detalle= new HashMap<>();
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
        detalle.put("observaciones2","FCE - RD - FD - RCE");
        detalle.put("codigo","05266000");
        detalle.put("activo",true);
        detalle.put("codigo_terminal",2);
        detalle.put("codigo_interno",204);
        detalle.put("mensajeria",true);
        detalle.put("cubre_mm",false);
        detalle.put("departamento","05");
        detalle.put("cubre_cm","false");
        detalle.put("nombre","Envigado (Ant)");
        detalle.put("abreviado","ENVIGADO");
        detalle.put("nombre_terminal","Medellin");
        detalle.put("observaciones","");
        


        //Creando el body de la solicitud
        Map<String,Object> data= new HashMap<>();
        data.put("tipoEnvio",1);
        data.put("tipoProducto",4);
        data.put("indicativo",57);
        data.put("tipoDocumento",13);
        data.put("email","ana@gmail.com");
        data.put("personaEntrega",1);
        data.put("indicativoEntrega",57);
        data.put("medidasAproximadas",medidasAproximadas);
        data.put("ciudad","Envigado (Ant)");
        data.put("via","km5");
        data.put("numero",2);
        data.put("detalle","PARQUE SAN JOSE BOD 14");
        data.put("tipoVia",16);
        data.put("nombres","prueba");
        data.put("apellidos","prueba1");
        data.put("documento","1036149000");
        data.put("celular","3005777777");
        data.put("ciudadDetalle",detalle);
        data.put("direccion","Cl 10 # 20 30");
        data.put("fechaRecogida","2024-05-05");
        data.put("nombreEntrega","prueba");
        data.put("apellidosEntrega","prueba1");
        data.put("celularEntrega","3045677777");
        data.put("emailUsuario","anar.7@gmail.com");
        data.put("descripcionTipoVia","Kilómetro");
        data.put("aplicativo","envios");

        System.out.println(data);

        //POST call create a user

        APIResponse apiPostResponse = requestContext.post("https://apiv2-test.coordinadora.com/recogidas/cm-solicitud-recogidas-ms/solicitud-recogida",
                        RequestOptions.create()
                            .setHeader("Content-Type", "application/json")
                            //.setHeader("Authorization", "Bearer 874a55150ed7467421676388095d602845472c097a980167005b7f367b76283b")
                            .setData(data));
        
        System.out.println(apiPostResponse.text());
        System.out.println(apiPostResponse.status());
        Assert.assertEquals(201, apiPostResponse.status());
        
        Assert.assertEquals("Created", apiPostResponse.statusText());

        

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode postJsonResponse = objectMapper.readTree(apiPostResponse.body());
        //System.out.println(postJsonResponse.toPrettyString());

        //Parseando la respueta del error
        String responseBody = apiPostResponse.text();
        ObjectMapper objectMapper2 = new ObjectMapper();
        JsonNode jsonResponse = objectMapper2.readTree(responseBody);

        //Extrayendo el mensaje del error
        String errorMessage = jsonResponse.path("data").path("message").asText();
        String idRecogidaAnterior = jsonResponse.path("data").path("idRecogidaAnterior").asText();
        String recogida_anterior = jsonResponse.path("data").path("recogida_anterior").asText();

        //imprimiendo el mensaje de error
        System.out.println("Error"+ errorMessage);    
        System.out.println("idRecogidaAnterior"+ idRecogidaAnterior);    
        System.out.println("recogida_anterior"+ recogida_anterior);    

        
    }
    
}
