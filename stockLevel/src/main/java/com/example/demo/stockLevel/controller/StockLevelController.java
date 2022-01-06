package com.example.demo.stockLevel.controller;

import com.example.demo.stockLevel.model.PaymentResult;
import com.example.demo.stockLevel.webService.StockLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockLevelController {

    @Autowired
    private StockLevel stockLevel;

    @RequestMapping("stockLevelTransaction_Vx0")
    public long stockLevelTransaction_Vx0(@RequestBody PaymentResult input,@RequestParam("threshold") long threshold) throws Exception {
        input.setW_id("123");
        input.setD_id("1234");
        threshold = 12345678L;
        return stockLevel.stockLevelTransaction_Vx0(input, threshold);
    }

    @RequestMapping("stockLevelTransaction_Vx033")
    public long stockLevelTransaction_Vx033(@RequestBody PaymentResult input,@RequestParam("threshold") long threshold) throws Exception {
        return stockLevel.stockLevelTransaction_Vx033(input, threshold);
    }

    @RequestMapping("stockLevelTransaction_Vx057")
    public long stockLevelTransaction_Vx057(@RequestBody PaymentResult input,@RequestParam("threshold") long threshold) throws Exception {
        return stockLevel.stockLevelTransaction_Vx057(input, threshold);
    }

    @RequestMapping("stockLevelTransaction_VxA")
    public long stockLevelTransaction_VxA(@RequestBody PaymentResult input,@RequestParam("threshold") long threshold) throws Exception {
        return stockLevel.stockLevelTransaction_VxA(input, threshold);
    }
}