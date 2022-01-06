package com.example.demo.soap;

import com.example.demo.productDetail.model.ProductDetailInput;
import com.example.demo.productDetail.webService.ProductDetail;
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
public class ProductDetailSoapTest {

    @Test
    public void testSoap() {
        ProductDetailInput input = new ProductDetailInput();

        try {
            URL url = null;
            try {
                url = new URL("http://localhost:8889/ws/ProductDetail?wsdl");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            QName qname = new QName("http://impl.webService.productDetail.demo.example.com/", "ProductDetail");
            Service service = Service.create(url, qname);
            ProductDetail servicePort = service.getPort(ProductDetail.class);

            // ******************UserName & Password *****************************
            Map<String, Object> req_ctx = ((BindingProvider) servicePort).getRequestContext();
            req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);

            Map<String, List<String>> headers = new HashMap<String, List<String>>();
            headers.put("Username", Collections.singletonList("WebUser"));
            headers.put("Password", Collections.singletonList("123"));
            req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

            input.setId(00000001L);
            servicePort.productDetail_Vx0(input);
        } catch (Exception e) {
            System.out.println("fail");
            e.printStackTrace();
        }
    }
}