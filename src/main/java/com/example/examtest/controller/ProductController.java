package com.example.examtest.controller;

import com.example.examtest.model.Product;
import com.example.examtest.service.IProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.jvm.hotspot.debugger.win32.coff.DebugVC50SrcModFileDesc;

import java.awt.event.MouseEvent;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @GetMapping
    public ModelAndView listProduct(){
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("listProuct",iProductService.findAll());
        return modelAndView;
    }
    @GetMapping("/{id}/info")
    public ModelAndView info(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/info");
        modelAndView.addObject("info", iProductService.findById(id));
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("newProduct", new Product());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView create(Product product){
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        iProductService.save(product);
        return modelAndView;
    }
    @GetMapping("/{id}/edit")
    public ModelAndView editForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/edit");
        Product product = iProductService.findById(id).get();
        modelAndView.addObject("product", product);
        return modelAndView;
    }
    @PostMapping ("/edit")
    public ModelAndView update(Product product){
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        iProductService.save(product);
        return modelAndView;
    }
    @GetMapping("/{id}/delete")
    public ModelAndView deleteForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/delete");
         Product product = iProductService.findById(id).get();
        modelAndView.addObject("productDelete",product);
        return modelAndView;
    }
    @PostMapping("/remove")
    public ModelAndView delete(Product product) {
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        iProductService.remove(product.getId());
        return modelAndView;
    }
}
