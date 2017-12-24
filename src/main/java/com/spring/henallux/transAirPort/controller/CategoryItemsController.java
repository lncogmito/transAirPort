package com.spring.henallux.transAirPort.controller;

import com.spring.henallux.transAirPort.dataAccess.dao.CategoryInfoDAO;
import com.spring.henallux.transAirPort.dataAccess.dao.ProductInfoDAO;
import com.spring.henallux.transAirPort.model.FormQuantity;
import com.spring.henallux.transAirPort.model.Order;
import com.spring.henallux.transAirPort.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;

@Controller
@RequestMapping(value = "/categoryItems")
@SessionAttributes({ToolKit.BASKET})
public class CategoryItemsController {

    private CategoryInfoDAO categoryInfoDAO;
    private ProductInfoDAO productInfoDAO;

    @Autowired
    public CategoryItemsController(CategoryInfoDAO categoryInfoDAO,ProductInfoDAO productInfoDAO){
        this.categoryInfoDAO = categoryInfoDAO;
        this.productInfoDAO = productInfoDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String category(Model model, Locale locale, @RequestParam(value = "type") long type){

        //Récupération des infos de la catégorie courrante pour le titre
        model.addAttribute("currentCategory", categoryInfoDAO.findModelByCategoryCodeAndLanguageName(type,locale.getLanguage()));
        //Récupération de l'ArrayList des infos sur les produits de la catégorie courrante
        model.addAttribute("productList", productInfoDAO.findModelListByCategoryAndLanguage(type,locale.getLanguage()));
        //Création du modèle de formQuantity pour la création de l'orderLine
        model.addAttribute("formQuantity", new FormQuantity());

        return "integrated:categoryItems";
    }

    /*@RequestMapping (value= "/addItemToBasket", method = RequestMethod.POST)
    public String getFormData(@ModelAttribute(value="orderLine") OrderLine orderLine,@ModelAttribute(value = ToolKit.BASKET) LinkedHashMap<Integer,OrderLine> currentOrder){
        System.out.println("TEST");
        //Calcul et ajout du prix TVA comprise et du numéro de ligne
        double price = orderLine.getProduct().getPrice()*(1+orderLine.getProduct().getVat());
        orderLine.setPrice(price);
        orderLine.setLineNumber(ToolKit.nbLines);

        currentOrder.put(ToolKit.nbLines,orderLine);

        ToolKit.nbLines++;

        return "integrated:categoryItems";
    }*/


}
