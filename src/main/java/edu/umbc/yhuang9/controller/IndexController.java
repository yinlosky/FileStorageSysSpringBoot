package edu.umbc.yhuang9.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by yhuang9 on 5/8/17.
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

}
