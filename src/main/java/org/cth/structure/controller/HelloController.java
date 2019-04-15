package org.cth.structure.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class HelloController extends BaseController {

    private Logger log = LoggerFactory.getLogger(HelloController.class);
    @GetMapping("hello")
    public String hello(){
        log.info(">>>>>>>>1111111111111111");
        testLocalDate.test();
        return "hello Mr chen";
    }
}
