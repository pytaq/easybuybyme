package cn.gwj.controller;
/*
    Created by IntelliJ IDEA.
    Package:cn.gwj.controller
    User:1093499975@qq.com
    Date:2019/7/18 0018
    Time:15:10
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class HomeController {

    @RequestMapping("index.html")
    public String index(){
        return "pre/index";
    }

}
