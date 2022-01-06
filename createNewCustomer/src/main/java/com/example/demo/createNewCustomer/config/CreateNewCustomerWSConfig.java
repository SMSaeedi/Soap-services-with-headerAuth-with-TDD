package com.example.demo.createNewCustomer.config;

import com.example.demo.createNewCustomer.webService.CreateNewCustomerService;
import com.example.demo.createNewCustomer.webService.impl.CreateNewCustomerServiceImpl;
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
public class CreateNewCustomerWSConfig {

    @Autowired
    private SpringBus bus;

    @Value("${cxf.path}")
    protected String ws;

    @GetMapping("/")
    public RedirectView hello(HttpServletRequest request) {
        return new RedirectView(request.getContextPath() + ws);
    }

    @Bean
    public CreateNewCustomerService createNewCustomerService() {
        return new CreateNewCustomerServiceImpl();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, createNewCustomerService());
        endpoint.publish("/CreateCustomer");
        return endpoint;
    }

}