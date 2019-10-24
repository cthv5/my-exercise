package org.cth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class WebController {
    @RequestMapping("hello")
    public String test() {
        return "hello world";
    }
}
