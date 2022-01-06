package com.example.demo.soap;

import com.example.demo.newProducts.model.NewProductsInput;
import com.example.demo.newProducts.model.NewProductsOutput;
import com.example.demo.newProducts.webService.NewProduct;
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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewProductSoapTest {

    @Test
    public void testSoap() {
        NewProductsInput input = new NewProductsInput();

        try {
            URL url = null;
            try {
                url = new URL("http://localhost:8889/ws/NewProduct?wsdl");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            QName qname = new QName("http://impl.webService.newProduct.demo.example.com/", "MostRecentOrder");
            Service service = Service.create(url, qname);
            NewProduct factory = service.getPort(NewProduct.class);

            // ******************Authentication*****************************
            Map<String, Object> req_ctx = ((BindingProvider) factory).getRequestContext();
            req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);

            Map<String, List<String>> headers = new HashMap<String, List<String>>();
            headers.put("Username", Collections.singletonList("msaeedi"));
            headers.put("Password", Collections.singletonList("30ms1370"));
            req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

            input.setSubjectString("Book subject");
            input.setItemLimit(11111L);
            input.setCutOffDuration(222222L);
            factory.newProducts_Vx0(input);
        } catch (Exception e) {
            System.out.println("fail");
            e.printStackTrace();
        }
    }
}