package com.example.paymentTest.controller;

import com.example.paymentTest.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class PaymentController {
    private final ProductService productService;
    @GetMapping("paymentPage")
    public String paymentPage(@RequestParam("product") String product,
                              @RequestParam("name") String name,
                              @RequestParam("price") Integer price,
                              Model mo){
        mo.addAttribute("product", product);
        mo.addAttribute("name", name);
        mo.addAttribute("price", price);
        return "paymentPage";
    }

    @PostMapping("/payment")
    public String paymentSuccess(){
        return "success";
    }

    @GetMapping("/add")
    public String addProduct(){
        productService.addProduct();
        return "redirect:/";
    }
}
