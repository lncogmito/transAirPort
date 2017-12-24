/*package com.spring.henallux.transAirPort.controller;

import com.spring.henallux.transAirPort.dataAccess.dao.CategoryInfoDAO;
import com.spring.henallux.transAirPort.model.Category;
import com.spring.henallux.transAirPort.model.CategoryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Locale;

@Controller
@RequestMapping(value="/addCategory")
public class AddCategoryController {

    private CategoryInfoDAO categoryInfoDAO;

    @Autowired
    public AddCategoryController(CategoryInfoDAO categoryInfoDAO){
        this.categoryInfoDAO = categoryInfoDAO;
    }

    @RequestMapping(value="/step1",method = RequestMethod.GET)
    public String step1(Model model, Locale locale){
        model.addAttribute("step", 1);
        model.addAttribute("category", new Category());

        ArrayList<CategoryInfo> categoryInfoList =  categoryInfoDAO.findModelMotherList(locale.getLanguage());

        return "integrated:addCategory";
        //Simulation des boucles pour sortir la liste des catégories ordonnées:
        long saveCurrentParentCategoryCode;
        for(CategoryInfo categoryInfo:categoryInfoList){
            //Si on a bien une catégorie parente "suprème"
            if(categoryInfo.getCategory().getCategory() == null){
                saveCurrentParentCategoryCode = categoryInfo.getCategory().getCode();
                //SORTIR PARENT
                for(CategoryInfo childSearch:categoryInfoList){
                    
                }

            }
        }
    }
    @RequestMapping(value="/step2",method = RequestMethod.POST)
    public String step2(Model model, @ModelAttribute(value = "category")Category category){
        model.addAttribute("step", 2);
        model.addAttribute("categoryFrenchName",new CategoryInfo());
        return "integrated:addCategory";
    }
    @RequestMapping(value="/step3",method = RequestMethod.POST)
    public String step3(Model model, @ModelAttribute(value = "categoryFrenchName")CategoryInfo categoryInfo){
        model.addAttribute("step", 3);
        model.addAttribute("categoryEnglishName", new CategoryInfo());
        return "integrated:addCategory";
    }
    @RequestMapping(value="/step4",method = RequestMethod.POST)
    public String validate(Model model, @ModelAttribute(value = "categoryEnglishName")CategoryInfo categoryInfo){
        model.addAttribute("step", 4);

        return "integrated:addCategory";
    }
}
*/