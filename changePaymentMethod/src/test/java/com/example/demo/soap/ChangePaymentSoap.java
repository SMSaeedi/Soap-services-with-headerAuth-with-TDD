package com.example.demo.soap;

import com.example.demo.changePaymentMethod.model.ChangePaymentMethodInput;
import com.example.demo.changePaymentMethod.model.ChangePaymentMethodOutput;
import com.example.demo.changePaymentMethod.webService.ChangePayment;
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
public class ChangePaymentSoap {

    String WS_URL = "http://localhost:8889/ws/ChangePayment?wsdl";

    @Test
    public void testSoap() {
        ChangePaymentMethodOutput outParams;
        ChangePaymentMethodInput input = new ChangePaymentMethodInput();

        try {
            URL url = new URL(WS_URL);

            QName qname = new QName("http://impl.webService.changePaymentMethod.demo.example.com/", "ChangePayment");
            Service service = Service.create(url, qname);
            ChangePayment factory = service.getPort(ChangePayment.class);

            // ******************Authentication*****************************
            Map<String, Object> req_ctx = ((BindingProvider) factory).getRequestContext();
            req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);

            Map<String, List<String>> headers = new HashMap<String, List<String>>();
            headers.put("Username", Collections.singletonList("msaeedi"));
            headers.put("Password", Collections.singletonList("30ms1370"));
            req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

            input.setCustomerId(11111111L);
            input.setThreadId(21212L);

            outParams = factory.changePaymentMethod_test(input);
            System.out.println("output " + outParams);
        } catch (Exception e) {
            System.out.println("fail");
            e.printStackTrace();
        }
    }
}