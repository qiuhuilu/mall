package com.taotao.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面Controller
 * Created by qiuhl on 2017/6/28.
 */
@Controller
public class PageController {
    /**
     * 首页
     * @return
     */
    @RequestMapping("/")
    public String getHomePage(){
        return "index";
    }

    /**
     * 其他页面url
     * @return
     */
    @RequestMapping("/{pagename}")
    public String getPage(@PathVariable String pagename){
        return pagename;
    }
}
