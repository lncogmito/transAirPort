package com.spring.henallux.transAirPort.controller;

import com.spring.henallux.transAirPort.dataAccess.dao.CategoryDAO;
import com.spring.henallux.transAirPort.dataAccess.dao.CategoryInfoDAO;
import com.spring.henallux.transAirPort.model.Category;
import com.spring.henallux.transAirPort.model.CategoryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Locale;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
    private final MessageSource messageSource;
    private CategoryInfoDAO categoryInfoDAO;
    private CategoryDAO categoryDAO;

    @Autowired
    public CategoryController(MessageSource messageSource,CategoryDAO categoryDAO,CategoryInfoDAO categoryInfoDAO){
        this.messageSource = messageSource;
        this.categoryInfoDAO = categoryInfoDAO;
        this.categoryDAO = categoryDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String category(Model model, Locale locale, @RequestParam(value = "type") long type){
        model.addAttribute("title", messageSource.getMessage("titleCategory",null,locale));

        ArrayList<CategoryInfo> childCategories = categoryInfoDAO.findModelChildListByCategoryCodeAndLanguageName(type,locale.getLanguage());
        if(childCategories.isEmpty())
            return "redirect:/categoryItems?type=" + type;
        else{
            CategoryInfo currentCategory = categoryInfoDAO.findModelByCategoryCodeAndLanguageName(type,locale.getLanguage());
            model.addAttribute("childCategories", childCategories);
            model.addAttribute("currentCategory", currentCategory);

            /*ArrayList<String> path = new ArrayList<>();
            do{
                path.add(currentCategory.getName());
                //A terminer (boucle recherche path)

            }while(currentCategory.getCategory().getCategory() != null);*/
            return "integrated:category";
        }
    }
}
