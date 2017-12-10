package com.spring.henallux.transAirPort.controller;

import com.spring.henallux.transAirPort.dataAccess.dao.CategoryDAO;
import com.spring.henallux.transAirPort.dataAccess.dao.CategoryInfoDAO;
import com.spring.henallux.transAirPort.model.Category;
import com.spring.henallux.transAirPort.model.CategoryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Locale;

@ControllerAdvice
public class TemplateController {
    private CategoryInfoDAO categoryInfoDAO;

    @Autowired
    public TemplateController(CategoryInfoDAO categoryInfoDAO){
        this.categoryInfoDAO = categoryInfoDAO;
    }

    @ModelAttribute
    public void loadCategories(Model model, Locale locale){
        ArrayList<CategoryInfo> categories = categoryInfoDAO.findModelListByCodeCategoryParentIsNull(locale.getLanguage());
        model.addAttribute("categories",categories);

    }
}
