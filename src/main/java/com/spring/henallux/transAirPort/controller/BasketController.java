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

import java.util.*;

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


        if(!hashMap.isEmpty()){
            Set<Map.Entry<Integer,OrderLine>> setHashMap = hashMap.entrySet();
            Iterator<Map.Entry<Integer,OrderLine>> it = setHashMap.iterator();
            Map.Entry<Integer,OrderLine> entry = it.next();
            int quantityItem = entry.getValue().getQuantity();
            long categoryCode = entry.getValue().getProduct().getCategory().getCode();
            boolean reducCat = false;
            while(it.hasNext()){
                entry = it.next();
                quantityItem += entry.getValue().getQuantity();
                if(categoryCode != entry.getValue().getProduct().getCategory().getCode())
                    reducCat = true;
            }
            if(reducCat)
                totalCost *= 0.9;
            totalCost = costReducItemQuantity(totalCost, quantityItem);
            totalCost = costReducElemQuantity(totalCost, hashMap.values().size());

            model.addAttribute("totalCostReduc",totalCost);
            ToolKit.totalCostAllReducInclusive = totalCost;
        }

        return "integrated:basket";
    }

    private double costReducElemQuantity(double totalCost, int sizeBasket){
        if(sizeBasket>=3)
            return (totalCost *= 0.9);
        else
            return totalCost;
    }
    private double costReducItemQuantity(double totalCost, int quantityElem){
        if(quantityElem >= 3)
            return (totalCost *= 0.9);
        else
            return totalCost;
    }
}
