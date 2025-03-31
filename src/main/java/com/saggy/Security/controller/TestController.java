package com.saggy.Security.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/")
    public String test(){
        return "hello";
    }
    @GetMapping("/getBal")
    public String getBalance(){
        return "Your Balance is : 50000";
    }
    @GetMapping("/contactUs")
    public String contactUS(){
        return "Hi Sagnik you can contact us at :81236263";
    }
    @GetMapping("/aboutUs")
    public String aboutUs(){
        return "Hi we are the best bank in the town";
    }
    @GetMapping("/transfer")
    public String transfer(){
        return "your transaction is done ";
    }

}
