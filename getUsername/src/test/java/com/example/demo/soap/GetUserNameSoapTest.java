package com.example.demo.soap;

import com.example.demo.getUserName.webService.GetUserName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
public class GetUserNameSoapTest {

    @Test
    public void testSoap() {

        try {
            URL url = null;
            try {
                url = new URL("http://localhost:8889/ws/UserName?wsdl");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            QName qname = new QName("http://impl.webService.getUserName.demo.example.com/", "MostRecentOrder");
            Service service = Service.create(url, qname);
            GetUserName factory = service.getPort(GetUserName.class);

            // ******************Authentication*****************************
            Map<String, Object> req_ctx = ((BindingProvider) factory).getRequestContext();
            req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);

            Map<String, List<String>> headers = new HashMap<String, List<String>>();
            headers.put("Username", Collections.singletonList("msaeedi"));
            headers.put("Password", Collections.singletonList("30ms1370"));
            req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

            factory.getUserName_Vx0Test("1");
        } catch (Exception e) {
            System.out.println("fail");
            e.printStackTrace();
        }
    }
}