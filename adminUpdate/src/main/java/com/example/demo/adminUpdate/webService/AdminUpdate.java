package com.example.demo.adminUpdate.webService;

import com.example.demo.adminUpdate.model.AdminUpdateInParams;
import com.example.demo.adminUpdate.model.AdminUpdateOutParams;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://impl.webService.adminUpdate.demo.example.com/")
public interface AdminUpdate {

    @WebMethod(operationName = "adminUpdate_Vx0")
    public void adminUpdate_Vx0(@WebParam(name = "i_id") int i_id,
                                @WebParam(name = "cost") double cost,
                                @WebParam(name = "image") String image,
                                @WebParam(name = "thumbnail") String thumbnail);

    @WebMethod(operationName = "adminUpdate_Vx0111")
    AdminUpdateOutParams adminUpdate_Vx0111(@WebParam(name = "input") AdminUpdateInParams input);

    @WebMethod(operationName = "adminUpdate_VxA")
    public void adminUpdate_VxA(@WebParam(name = "i_id") int i_id,
                                @WebParam(name = "cost") double cost,
                                @WebParam(name = "image") String image,
                                @WebParam(name = "thumbnail") String thumbnail);

}