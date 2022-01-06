package com.example.demo.soap;

import com.example.demo.createNewCustomer.model.Customer;
import com.example.demo.createNewCustomer.webService.CreateNewCustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateNewCustomerSoapTest {

    String WS_URL = "http://localhost:8889/ws/CreateNewCustomer?wsdl";

    @Test
    public void testSoap() {
        Customer outParams;
        Customer cust = new Customer();

        try {
            URL url = new URL(WS_URL);

            QName qname = new QName("http://impl.webService.createNewCustomer.demo.example.com/", "CreateNewCustomer");
            Service service = Service.create(url, qname);
            CreateNewCustomerService factory = service.getPort(CreateNewCustomerService.class);

            // ******************Authentication*****************************
            Map<String, Object> req_ctx = ((BindingProvider) factory).getRequestContext();
            req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);

            Map<String, List<String>> headers = new HashMap<String, List<String>>();
            headers.put("Username", Collections.singletonList("msaeedi"));
            headers.put("Password", Collections.singletonList("30ms1370"));
            req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

            cust.c_id = 1;
            cust.c_fname = "Mahsa";
            cust.c_lname= "Saeedi";
            cust.c_email= "mahsa.saeedi@google.com";
            cust.c_phone= "09399008001";

            outParams = factory.createNewCustomer_Vx0(cust);
            System.out.println("output " + outParams);
        } catch (Exception e) {
            System.out.println("fail");
            e.printStackTrace();
        }
    }
}