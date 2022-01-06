package com.example.demo.soap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ws.client.core.WebServiceTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockLevelSoapTest {

    @Test
    public void testSoap() {
        WebServiceTemplate wsTemplate = new WebServiceTemplate();

        try {
        } catch (Exception e) {
            System.out.println("fail");
            e.printStackTrace();
        }
    }
}