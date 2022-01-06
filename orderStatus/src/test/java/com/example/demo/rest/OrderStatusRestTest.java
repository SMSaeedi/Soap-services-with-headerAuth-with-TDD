package com.example.demo.rest;

import com.example.demo.orderStatus.webService.OrderStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderStatusRestTest {

    private static final ObjectMapper om = new ObjectMapper();

    int randomServerPort;

    int timeout = 10_000;

    @Autowired
    private OrderStatus orderStatus;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private HttpComponentsClientHttpRequestFactory getClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();

        //Connect timeout
      /*  clientHttpRequestFactory.setConnectTimeout(timeout);

        //Read timeout
        clientHttpRequestFactory.setReadTimeout(timeout);*/
        return clientHttpRequestFactory;
    }

    @Before
    public void setUp() {
//        restTemplate = new RestTemplate(getClientHttpRequestFactory());
    }

    @Test
    public void testProductDetail_Vx0_success() {
        RestTemplate restTemplate = new RestTemplate();
    }

    private static void printJSON(Object object) {
        String result;
        try {
            result = om.writerWithDefaultPrettyPrinter().writeValueAsString(object);
            System.out.println(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}