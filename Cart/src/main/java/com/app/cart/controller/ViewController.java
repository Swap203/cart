package com.app.cart.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/views")
public class ViewController {



    @RequestMapping("/aaa")
    public String getDataEntryView(Model model)
    {
        //ModelAndView modelView=new ModelAndView();

        //modelView.setViewName("addproducts");

        return "index";
    }

    @RequestMapping("/")
    public void handleRequest() {
        throw new RuntimeException("test exception");
    }

}
