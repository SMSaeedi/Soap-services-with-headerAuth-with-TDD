package com.example.demo.newCustomer.webService;

import com.example.demo.newCustomer.model.Customer;
import com.example.demo.newCustomer.model.NewCustomerInput;
import com.example.demo.newCustomer.model.NewCustomerOutput;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://impl.webService.newCustomer.demo.example.com/")
public interface NewCustomer {

    @WebMethod(operationName = "createNewCustomer_Vx0")
    public NewCustomerOutput createNewCustomer_Vx0(@WebParam(name = "cust") NewCustomerInput cust);

    @WebMethod(operationName = "createNewCustomer_VxA")
    public Customer createNewCustomer_VxA(@WebParam(name = "cust") Customer cust);

    @WebMethod(operationName = "createNewCustomer_Vx078")
    public Customer createNewCustomer_Vx078(@WebParam(name = "cust") Customer cust);

    @WebMethod(operationName = "createNewCustomer_Vx103")
    public Customer createNewCustomer_Vx103(@WebParam(name = "cust") Customer cust);

    @WebMethod(operationName = "createNewCustomer_Vx113")
    public Customer createNewCustomer_Vx113(@WebParam(name = "cust") Customer cust);

    @WebMethod(operationName = "createNewCustomer_Vx132")
    public Customer createNewCustomer_Vx132(@WebParam(name = "cust") Customer cust);

}