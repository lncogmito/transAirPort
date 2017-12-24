package com.spring.henallux.transAirPort.controller;

import com.spring.henallux.transAirPort.dataAccess.dao.ProductInfoDAO;
import com.spring.henallux.transAirPort.dataAccess.entity.OrderEntity;
import com.spring.henallux.transAirPort.model.FormQuantity;
import com.spring.henallux.transAirPort.model.OrderLine;
import com.spring.henallux.transAirPort.model.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping(value = "/basket")
@SessionAttributes({ToolKit.BASKET})
public class BasketController {
    private final MessageSource messageSource;
    private ProductInfoDAO productInfoDAO;

    @Autowired
    public BasketController(MessageSource messageSource, ProductInfoDAO productInfoDAO){
        this.messageSource = messageSource;
        this.productInfoDAO = productInfoDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, Locale locale, @ModelAttribute(value = ToolKit.BASKET) HashMap<Integer,OrderLine> hashMap){
        model.addAttribute("title", messageSource.getMessage("titleBasket",null,locale));
        double totalCost = 0;

        ArrayList<ProductInfo> productInfoArray = new ArrayList<>();
        for(OrderLine orderLine:hashMap.values()){
            productInfoArray.add(productInfoDAO.findModelByProductIdAndLanguageName(orderLine.getProduct().getId(),locale.getLanguage()));
            totalCost += orderLine.getPrice() * orderLine.getQuantity();
        }
        model.addAttribute("productList", productInfoArray);
        model.addAttribute("orderLines", hashMap.values());
        model.addAttribute("totalCost",totalCost);

        totalCost = costReducItemQuantity(totalCost, hashMap.values().size());
        model.addAttribute("totalCostReduc",totalCost);
        ToolKit.totalCostAllReducInclusive = totalCost;

        return "integrated:basket";
    }

    private double costReducItemQuantity(double totalCost, int sizeBasket){
        if(sizeBasket>=3){
            return (totalCost *= 0.9);
        }
        else
            return totalCost;
    }
}
