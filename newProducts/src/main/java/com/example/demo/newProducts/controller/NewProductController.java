package com.example.demo.newProducts.controller;

import com.example.demo.newProducts.model.NewProductsInput;
import com.example.demo.newProducts.model.NewProductsOutput;
import com.example.demo.newProducts.model.NewProducts_Vx0;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewProductController {

    @RequestMapping("newProducts_Vx0")
    public NewProductsOutput newProducts_Vx0(@RequestBody NewProductsInput input) throws Exception {
        return new NewProducts_Vx0().process(input);
    }

    @RequestMapping("newProducts_VxA")
    public NewProductsOutput newProducts_VxA(@RequestBody NewProductsInput input) throws Exception {
        return new NewProducts_Vx0().process(input);
    }

    //TODO Test data
   /* {"cutOffDuration": 123456789,
            "subjectString": "Hello",
            "itemLimit": 12364597
    }*/
}