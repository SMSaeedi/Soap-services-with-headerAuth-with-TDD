package com.example.demo.adminUpdate.webService.impl;

import com.example.demo.adminUpdate.model.*;
import com.example.demo.adminUpdate.webService.AdminUpdate;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

@WebService(serviceName = "AdminUpdate")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class AdminUpdateImpl implements AdminUpdate {

    @Resource
    WebServiceContext wsContext;

    @Override
    public void adminUpdate_Vx0(int i_id, double cost, String image, String thumbnail) {
        new AdminUpdate_Vx0().adminUpdate(i_id, cost, image, thumbnail);
    }

    @Override
    public AdminUpdateOutParams adminUpdate_Vx0111(AdminUpdateInParams input) {
        Authentication outValues = new Authentication();
        AdminUpdateOutParams serviceOut = new AdminUpdateOutParams();

        try {
            outValues = getHttpHeaders(wsContext);
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }

        if (outValues.getErrorCode() == 0)
            serviceOut = new AdminUpdate_Vx0().hardCodeData(input);
        else {
            System.out.println("failed to call AdminUpdate_Vx0().hardCodeData " + input);
            serviceOut.setErrMsg("Empty or wrong user/pass");
        }

        return serviceOut;
    }

    @Override
    public void adminUpdate_VxA(int i_id, double cost, String image, String thumbnail) {
        new AdminUpdate_VxA().adminUpdate(i_id, cost, image, thumbnail);
    }

    static Authentication getHttpHeaders(WebServiceContext wsContext) {
        Authentication user = new Authentication();
        MessageContext mctx = wsContext.getMessageContext();
        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);

        List name = (List) http_headers.get("username");
        List pass = (List) http_headers.get("password");

        if (name == null || pass == null) {
            user.setNullParams();
            user.setErrorCode(1);
            return user;
        } else {
            String username = (String) name.get(0);
            String password = (String) pass.get(0);

            user.setUser(username);
            user.setPassword(password);
            return user;
        }
    }
}