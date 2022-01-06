package com.example.demo.soap;

import com.example.demo.doTitleSearch.model.Book;
import com.example.demo.doTitleSearch.webService.DoTitleSearch;
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
public class DoTitleSearchSoapTest {

    @Test
    public void testSoap() {
        Book input = new Book();

        try {
            URL url = null;
            try {
                url = new URL("http://localhost:8889/ws/DoTitleSearch?wsdl");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            QName qname = new QName("http://impl.webService.doTitleSearch.demo.example.com/", "MostRecentOrder");
            Service service = Service.create(url, qname);
            DoTitleSearch factory = service.getPort(DoTitleSearch.class);

            // ******************Authentication*****************************
            Map<String, Object> req_ctx = ((BindingProvider) factory).getRequestContext();
            req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);

            Map<String, List<String>> headers = new HashMap<String, List<String>>();
            headers.put("Username", Collections.singletonList("msaeedi"));
            headers.put("Password", Collections.singletonList("30ms1370"));
            req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

            input.i_title = "Little Dorrit";
            factory.doTitleSearch_Vx0(input);
        } catch (Exception e) {
            System.out.println("fail");
            e.printStackTrace();
        }
    }
}