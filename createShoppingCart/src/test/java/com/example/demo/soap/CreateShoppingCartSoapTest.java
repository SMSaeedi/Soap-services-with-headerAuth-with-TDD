package com.example.demo.soap;

import com.example.demo.createShoppingCart.webService.CreateShoppingCart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateShoppingCartSoapTest {

    @Test
    public void testSoap() {
        WebServiceTemplate wsTemplate = new WebServiceTemplate();
        List<String> ids = new ArrayList<>();
        List<String> quantities = new ArrayList<>();

        ids.add("1");
        ids.add("2");
        ids.add("3");
        ids.add("4");
        ids.add("5");

        quantities.add("9");
        quantities.add("8");
        quantities.add("7");
        quantities.add("6");
        quantities.add("5");

        try {
            URL url = null;
            try {
                url = new URL("http://localhost:8889/ws/CreateShoppingCart?wsdl");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            QName qname = new QName("http://impl.webService.createShoppingCart.demo.example.com/", "MostRecentOrder");
            Service service = Service.create(url, qname);
            CreateShoppingCart factory = service.getPort(CreateShoppingCart.class);

            // ******************Authentication*****************************
            Map<String, Object> req_ctx = ((BindingProvider) factory).getRequestContext();
            req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);

            Map<String, List<String>> headers = new HashMap<String, List<String>>();
            headers.put("Username", Collections.singletonList("msaeedi"));
            headers.put("Password", Collections.singletonList("30ms1370"));
            req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

            factory.createShoppingCart_Vx0(1, ids, quantities, 2);
        } catch (Exception e) {
            System.out.println("fail");
            e.printStackTrace();
        }
    }
}