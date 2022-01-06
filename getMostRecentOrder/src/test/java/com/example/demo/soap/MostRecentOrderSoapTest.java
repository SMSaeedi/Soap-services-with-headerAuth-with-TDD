package com.example.demo.soap;

import com.example.demo.getMostRecentOrder.webService.MostRecentOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MostRecentOrderSoapTest {

    @Test
    public void testSoap() {

        try {
            URL url = null;
            try {
                url = new URL("http://localhost:8889/ws/MostRecentOrder?wsdl");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            QName qname = new QName("http://impl.webService.getMostRecentOrder.demo.example.com/", "MostRecentOrder");
            Service service = Service.create(url, qname);
            MostRecentOrder servicePort = service.getPort(MostRecentOrder.class);

            servicePort.getMostRecentOrder_Vx0Test("Book");
        } catch (Exception e) {
            System.out.println("fail");
            e.printStackTrace();
        }
    }
}