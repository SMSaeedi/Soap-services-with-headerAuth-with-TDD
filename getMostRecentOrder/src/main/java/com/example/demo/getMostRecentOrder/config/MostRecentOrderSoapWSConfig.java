package com.example.demo.getMostRecentOrder.config;

import com.example.demo.getMostRecentOrder.webService.MostRecentOrder;
import com.example.demo.getMostRecentOrder.webService.impl.MostRecentOrderImpl;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Endpoint;

@Configuration
public class MostRecentOrderSoapWSConfig {

    @Autowired
    private SpringBus bus;

    @Value("${cxf.path}")
    protected String ws;

    @GetMapping("/")
    public RedirectView hello(HttpServletRequest request) {
        return new RedirectView(request.getContextPath() + ws);
    }

    @Bean
    public MostRecentOrder mostRecentOrderService() {
        return new MostRecentOrderImpl();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, mostRecentOrderService());
        endpoint.publish("/MostRecentOrder");
        return endpoint;
    }
}