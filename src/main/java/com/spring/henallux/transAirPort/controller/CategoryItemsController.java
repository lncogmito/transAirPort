package com.spring.henallux.transAirPort.controller;

import com.spring.henallux.transAirPort.dataAccess.dao.CategoryInfoDAO;
import com.spring.henallux.transAirPort.dataAccess.dao.ProductInfoDAO;
import com.spring.henallux.transAirPort.model.Order;
import com.spring.henallux.transAirPort.model.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Locale;

@Controller
@RequestMapping(value = "/categoryItems")
@SessionAttributes({Constants.BASKET})
public class CategoryItemsController {

    private CategoryInfoDAO categoryInfoDAO;
    private ProductInfoDAO productInfoDAO;

    @Autowired
    public CategoryItemsController(CategoryInfoDAO categoryInfoDAO,ProductInfoDAO productInfoDAO){
        this.categoryInfoDAO = categoryInfoDAO;
        this.productInfoDAO = productInfoDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String category(Model model, Locale locale, @RequestParam(value = "type") long type, @ModelAttribute(value = Constants.BASKET)Order currentOrder, @ModelAttribute(value = "orderL")){
        //Récupération des infos de la catégorie courrante pour le titre
        model.addAttribute("currentCategory", categoryInfoDAO.findModelByCategoryCodeAndLanguageName(type,locale.getLanguage()));
        //Récupération de l'ArrayList des infos sur les produits de la catégorie courrante
        model.addAttribute("productList", productInfoDAO.findModelListByCategoryAndLanguage(type,locale.getLanguage()));

        return "integrated:categoryItems";
    }


}
