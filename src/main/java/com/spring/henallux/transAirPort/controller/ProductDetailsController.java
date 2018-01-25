package com.spring.henallux.transAirPort.controller;

import com.spring.henallux.transAirPort.dataAccess.dao.ProductInfoDAO;
import com.spring.henallux.transAirPort.model.FormQuantity;
import com.spring.henallux.transAirPort.model.OrderLine;
import com.spring.henallux.transAirPort.model.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping(value="/productDetails")
@SessionAttributes({ToolKit.BASKET})
public class ProductDetailsController {
    private final MessageSource messageSource;
    private ProductInfoDAO productInfoDAO;

    @Autowired
    public ProductDetailsController(MessageSource messageSource, ProductInfoDAO productInfoDAO){
        this.messageSource = messageSource;
        this.productInfoDAO = productInfoDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, Locale locale, @RequestParam(value = "product") long code){
        model.addAttribute("title", messageSource.getMessage("titleProductDetails",null,locale));

        //Récupération des infos sur le produit courrant
        model.addAttribute("productItem", productInfoDAO.findModelByProductIdAndLanguageName(code,locale.getLanguage()));
        //Création du modèle de formQuantity pour la création de l'orderLine
        model.addAttribute("formQuantity", new FormQuantity());

        return "integrated:productDetails";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String getFormProductItem(Model model, Locale locale,
                                     @ModelAttribute(value="formQuantity") FormQuantity formQuantity,
                                     @ModelAttribute(value = ToolKit.BASKET) HashMap<Integer,OrderLine> hashMap,
                                     @RequestParam(value = "product") long code){
        if(formQuantity.getQuantity() > 0) {
            if (!hashMap.isEmpty()) {
                Set<Map.Entry<Integer, OrderLine>> setHashMap = hashMap.entrySet();
                Iterator<Map.Entry<Integer, OrderLine>> it = setHashMap.iterator();
                Map.Entry<Integer, OrderLine> entry = it.next();
                while (it.hasNext() && entry.getValue().getProduct().getId() != code) {
                    entry = it.next();
                }
                if (entry.getValue().getProduct().getId() == code) {
                    entry.getValue().setQuantity(entry.getValue().getQuantity() + formQuantity.getQuantity());
                    return "redirect:/productDetails?product=" + code;
                }
            }
            OrderLine orderLine = new OrderLine();
            ProductInfo productInfo = productInfoDAO.findModelByProductIdAndLanguageName(code, locale.getLanguage());
            double price = productInfo.getProduct().getPrice() * (1 + productInfo.getProduct().getVat() / 100);
            orderLine.setQuantity(formQuantity.getQuantity());
            orderLine.setProduct(productInfo.getProduct());
            orderLine.setPrice(price);
            orderLine.setLineNumber(ToolKit.nbLines);

            hashMap.put(ToolKit.nbLines, orderLine);

            ToolKit.nbLines++;

            //model.addAttribute("msg", formQuantity.getQuantity() + " " + productInfo.getName() + " ajouté au panier");
        }

        return "redirect:/productDetails?product="+code;
    }
}
