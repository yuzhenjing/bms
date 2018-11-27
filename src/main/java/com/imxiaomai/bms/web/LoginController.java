package com.imxiaomai.bms.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hyy on 2018/1/3.
 */
@Slf4j
@Controller
@RequestMapping("")
public class LoginController {


    /**
     * 跳转到首页
     *
     * @param model
     * @return
     */
    @RequestMapping("")
    public String index1(Model model) {
        return "index";
    }

    /**
     * 跳转到登陆也
     *
     * @return
     */
    @RequestMapping("login")
    public String login() {
        return "login";
    }

    /**
     * 跳转到403错误页面
     *
     * @return
     */
    @RequestMapping("403")
    public String to403() {
        return "403";
    }

}
