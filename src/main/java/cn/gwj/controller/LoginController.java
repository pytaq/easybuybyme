package cn.gwj.controller;
/*
    Created by IntelliJ IDEA.
    Package:cn.gwj.controller
    User:1093499975@qq.com
    Date:2019/7/18 0018
    Time:12:33
*/

import cn.gwj.entity.User;
import cn.gwj.service.user.UserService;
import cn.gwj.utils.EmptyUtils;
import cn.gwj.utils.SecurityUtils;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @Resource
    private UserService userService;

    //登录页面
    @RequestMapping("/login.html")
    public String login(){
        return "pre/login";
    }

    //验证登录
    @RequestMapping("/checkLogin.html")
    @ResponseBody
    public Object checkLogin(@RequestParam String loginName,@RequestParam String password, HttpSession session, Map map){
        User user=userService.getUser(null,loginName);
        String msg="";
        boolean status=false;
        if(EmptyUtils.isEmpty(user)){
           msg="用户名不存在";
        }else{
            if(user.getPassword().equals(SecurityUtils.md5Hex(password))){
                //登陆成功
                session.setAttribute("loginUser",user);
                msg="登陆成功";
                status=true;
            }else{
               msg="密码错误";
            }
        }
        map.put("status",status);
        map.put("msg",msg);
        return JSONArray.toJSON(map);
    }

}
