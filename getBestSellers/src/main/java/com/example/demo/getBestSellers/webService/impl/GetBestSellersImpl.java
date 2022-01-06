package com.example.demo.getBestSellers.webService.impl;

import com.example.demo.getBestSellers.model.Authentication;
import com.example.demo.getBestSellers.model.GetBestSellers_Vx0;
import com.example.demo.getBestSellers.model.GetBestSellers_VxA;
import com.example.demo.getBestSellers.model.ShortBook;
import com.example.demo.getBestSellers.webService.GetBestSellers;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebService(serviceName = "GetBestSellers")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class GetBestSellersImpl implements GetBestSellers {

    public static String userName = new String();

    @Resource
    WebServiceContext wsContext;

   @Override
   public List<ShortBook> getBestSellers_Vx0(String subject) {
       return new GetBestSellers_Vx0().getBestSellers(subject);
   }

    @Override
    public List<ShortBook> getBestSellers_VxA(String subject) {
        Authentication outValues = new Authentication();
        List<ShortBook> serviceOut = new ArrayList<>();

        try {
            outValues = getHttpHeaders(wsContext);
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }

        if (outValues.getErrorCode() == 0)
            serviceOut =  new GetBestSellers_VxA().getBestSellers(subject);
        else {
            System.out.println("failed to call GetBestSellers_VxA().getBestSellers ");
        }

        return serviceOut;
    }

    @Override
    public List<ShortBook> getBestSellers_Vx0Test(ShortBook subject) {
        return new GetBestSellers_Vx0().getBestSellersTest(subject);
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