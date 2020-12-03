package com.neusoft.springbootsell.controller;


import com.neusoft.springbootsell.dataobject.ProductCategory;
import com.neusoft.springbootsell.form.CategoryForm;
import com.neusoft.springbootsell.form.ProductForm;
import com.neusoft.springbootsell.services.CategoryService;
import com.neusoft.springbootsell.services.ProductService;
import com.neusoft.springbootsell.services.ProductService;
import com.neusoft.springbootsell.utils.KeyUtil;
import org.junit.experimental.categories.Category;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Key;
import java.util.List;
import java.util.Map;
//类目商品
@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    ProductService productService;
    @GetMapping("/list")
    public ModelAndView list(Map<String,Object> map){
        List<ProductCategory> list = categoryService.findAll();
        //将list添加到map中
        map.put("categoryList",list);
        return new ModelAndView("category/list",map);

    }


    @GetMapping("/index")
    public ModelAndView index(Map<String,Object>map){
        List<ProductCategory> categoryList =categoryService.findAll();
        map.put("categoryList",categoryList);
        return new ModelAndView("category/index");
    }



    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form,
                             BindingResult bindingResult,
                             Map<String,Object> map){

        if (bindingResult.hasErrors()){
//            返回错误页面
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/seller/category/index");
            return  new ModelAndView("common/error",map);
        }
        ProductCategory productCategory = new ProductCategory();
        try{
//           form.setCategoryId(Integer.valueOf(KeyUtil.genUniqueKey()));
            BeanUtils.copyProperties(form,productCategory);
            categoryService.save(productCategory);
        }catch (SecurityException exception){
            map.put("msg",exception.getMessage());
            map.put("url","/seller/category/index");
            return  new ModelAndView("common/error",map);
        }
        map.put("url","/seller/category/list");
        return new ModelAndView("common/success",map);
    }
}