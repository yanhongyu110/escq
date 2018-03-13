package com.jero.esc.controller.wap.pubinfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/wap/agreement")
public class Agreement {


    @RequestMapping("/view")
    public ModelAndView view(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("wap/pubinfo/agreement");
        return modelAndView;
    }


}
