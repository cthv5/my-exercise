package org.cth.structure.controller;

import org.cth.other.TestLocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
    @Autowired
    TestLocalDate testLocalDate;
}
