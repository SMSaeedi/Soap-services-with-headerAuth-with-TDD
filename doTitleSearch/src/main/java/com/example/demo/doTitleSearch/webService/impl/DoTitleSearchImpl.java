package com.example.demo.doTitleSearch.webService.impl;

import com.example.demo.doTitleSearch.model.Authentication;
import com.example.demo.doTitleSearch.model.Book;
import com.example.demo.doTitleSearch.model.DoTitleSearch_Vx0;
import com.example.demo.doTitleSearch.model.DoTitleSearch_VxA;
import com.example.demo.doTitleSearch.webService.DoTitleSearch;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebService(serviceName = "DoTitleSearch")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class DoTitleSearchImpl implements DoTitleSearch {

    public static String userName = new String();

    @Resource
    WebServiceContext wsContext;

    @Override
    public List<Book> doTitleSearch_Vx0(Book search_key) {
        Authentication outValues = new Authentication();
        List<Book> serviceOut = new ArrayList<>();

        try {
            outValues = getHttpHeaders(wsContext);
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }

        if (outValues.getErrorCode() == 0)
            serviceOut = new DoTitleSearch_Vx0().doTitleSearchTest(search_key);
        else {
            System.out.println("failed to call DoTitleSearch_Vx0().doTitleSearchTest ");
        }

        return serviceOut;
    }

    @Override
    public List<Book> doTitleSearch_VxA(String search_key) {
        return new DoTitleSearch_VxA().doTitleSearch(search_key);
    }

    static Authentication getHttpHeaders(WebServiceContext wsContext) {
        Authentication user = new Authentication();
        MessageContext mctx = wsContext.getMessageContext();
        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);

        List name = (List) http_headers.get("username");
        List Pass = (List) http_headers.get("Password");

        if (name == null || name.size() == 0 || Pass == null || Pass.size() == 0) {
            user.setErrorMsg("Incorrect user or pass");
            user.setNullParams();
            return null;
        } else {
            String username = (String) name.get(0);
            String password = (String) Pass.get(0);

            user.setUser(username);
            userName = username;
            user.setPassword(password);
            return user;
        }
    }
}