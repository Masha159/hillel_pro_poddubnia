package org.lessons.lesson40.controller;

import org.lessons.lesson40.model.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping(value = "/ping")
    public String ping(){
        return "OK";
    }
}
