package com.example.demo.getUserName.webService.impl;

import com.example.demo.getUserName.model.Authentication;
import com.example.demo.getUserName.model.GetUsername_Vx0;
import com.example.demo.getUserName.model.GetUsername_VxA;
import com.example.demo.getUserName.webService.GetUserName;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

@WebService(serviceName = "UserName")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class GetUserNameImpl implements GetUserName {

    public static String userName = new String();

    @Resource
    WebServiceContext wsContext;

    @Override
    public String getUserName_Vx0Test(String C_ID) {
        Authentication outValues = new Authentication();
        String serviceOut = null;

        try {
            outValues = getHttpHeaders(wsContext);
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }

        if (outValues.getErrorCode() == 0)
            serviceOut = new GetUsername_Vx0().getUserNameTest(C_ID);
        else {
            System.out.println("failed to call GetUsername_Vx0().getUserNameTest ");
        }

        return serviceOut;
    }

    @Override
    public String getUserName_VxA(int C_ID) {
        Authentication authOut;
        authOut = getHttpHeaders(wsContext);
        if (authOut.getErrorMsg() == "")
            return new GetUsername_VxA().getUserName(C_ID);
        else
            return null;
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