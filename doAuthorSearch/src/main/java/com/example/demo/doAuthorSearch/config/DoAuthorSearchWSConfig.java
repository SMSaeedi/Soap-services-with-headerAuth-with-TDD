package com.example.demo.doAuthorSearch.config;

import com.example.demo.doAuthorSearch.webService.DoAuthorSearch;
import com.example.demo.doAuthorSearch.webService.impl.DoAuthorSearchImpl;
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
public class DoAuthorSearchWSConfig {

    @Autowired
    private SpringBus bus;

    @Value("${cxf.path}")
    protected String ws;

    @GetMapping("/")
    public RedirectView hello(HttpServletRequest request) {
        return new RedirectView(request.getContextPath() + ws);
    }

    @Bean
    public DoAuthorSearch doAuthorSearchService() {
        return new DoAuthorSearchImpl();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, doAuthorSearchService());
        endpoint.publish("/DoAuthorSearch");
        return endpoint;
    }

}