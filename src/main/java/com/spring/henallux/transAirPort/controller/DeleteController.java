package com.spring.henallux.transAirPort.controller;

import com.spring.henallux.transAirPort.model.OrderLine;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping(value = "/delete")
@SessionAttributes({ToolKit.BASKET})
public class DeleteController {
    @RequestMapping(method = RequestMethod.GET)
    public String home(@ModelAttribute(value = ToolKit.BASKET) HashMap<Integer,OrderLine> hashMap, @RequestParam(value = "productId") long code){
        Set<Map.Entry<Integer,OrderLine>> setHashMap = hashMap.entrySet();
        Iterator<Map.Entry<Integer,OrderLine>> it = setHashMap.iterator();
        Map.Entry<Integer,OrderLine> entry = it.next();
        while(it.hasNext() && entry.getValue().getProduct().getId() != code){
            entry = it.next();
        }
        it.remove();

        return "redirect:/basket";
    }
}
