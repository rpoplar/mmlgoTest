package com.mmlgo.www;

import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
    public String Echo(String msg) {
        return "Server Received Your Message : " + msg;
    }
}
