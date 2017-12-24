package com.spring.henallux.transAirPort.controller;

import com.spring.henallux.transAirPort.dataAccess.dao.CategoryInfoDAO;
import com.spring.henallux.transAirPort.model.CategoryInfo;
import com.spring.henallux.transAirPort.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

@ControllerAdvice
@SessionAttributes({ToolKit.BASKET})
public class TemplateController {
    private CategoryInfoDAO categoryInfoDAO;

    @Autowired
    public TemplateController(CategoryInfoDAO categoryInfoDAO){
        this.categoryInfoDAO = categoryInfoDAO;
    }

    @ModelAttribute
    public void loadCategories(Model model, Locale locale, @ModelAttribute(value = ToolKit.BASKET) HashMap<Integer,OrderLine> hashMap){
        ArrayList<CategoryInfo> categories = categoryInfoDAO.findModelListByCodeCategoryParentIsNull(locale.getLanguage());
        model.addAttribute("categories",categories);
        model.addAttribute("nbItemInBasket",hashMap.values().size());
    }
}
