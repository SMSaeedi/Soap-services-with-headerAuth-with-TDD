package com.example.demo.productDetail.webService.impl;

import com.example.demo.dataBaseConfig.Logging;
import com.example.demo.productDetail.model.*;
import com.example.demo.productDetail.webService.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

@WebService(serviceName = "ProductDetail")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class ProductDetailImpl implements ProductDetail {

    public static String userName = new String();
    String clientIp = "";

    @Resource
    WebServiceContext wsContext;

    @Autowired
    ProductDetail productDetail;

    @Override
    public ProductDetailOutput productDetail_Vx0(ProductDetailInput input) throws Exception {
        Authentication outValues = null;
        ProductDetailOutput outService = null;
        try {
            MessageContext msgx = wsContext.getMessageContext();
            clientIp = ((HttpServletRequest) msgx.get(MessageContext.SERVLET_REQUEST)).getRemoteAddr();
            outValues = getHttpHeaders(wsContext);
        } catch (Exception e) {
            Logging.error("RESPONSE_CODE_INTERNAL_WS_CLIENT_IP_PROBLEM");
        }
        if (outValues.getErrorCode() == 0) {
            outService = productDetail.productDetail_Vx0_token(input);
        }
        return outService;
    }

    public ProductDetailOutput productDetail_Vx0_token(ProductDetailInput input) throws Exception {
        return new ProductDetail_Vx0().getHardCodeData(input);
    }

    @Override
    public ProductDetailOutput productDetail_VxA(ProductDetailInput input) throws Exception {
        return new ProductDetail_VxA().process(input);
    }

    static Authentication getHttpHeaders(WebServiceContext wsContext) {
        Authentication user = new Authentication();
        MessageContext mctx = wsContext.getMessageContext();
        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);

        List name = (List) http_headers.get("username");
        List Pass = (List) http_headers.get("password");

        if (name == null || name.size() == 0 || Pass == null || Pass.size() == 0) {
            user.setErrorCode(1);
            user.setErrorMsg("Incorrect user or pass");
            user.setNullParams();
            return user;
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