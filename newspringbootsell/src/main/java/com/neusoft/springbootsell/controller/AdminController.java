package com.neusoft.springbootsell.controller;

import com.neusoft.springbootsell.dataobject.Admin;
import com.neusoft.springbootsell.exception.AdminException;
import com.neusoft.springbootsell.form.AdminForm;
import com.neusoft.springbootsell.services.AdminService;
import com.neusoft.springbootsell.services.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/seller/admin")
public class AdminController {
@Autowired
    private AdminService adminService;
@GetMapping("/login")
    public ModelAndView index(Map<String, Object> map) {

    return new ModelAndView("admin/login");
    }
    @PostMapping("/register")
    public ModelAndView res(@Valid AdminForm form,
                            BindingResult bindingResult,
                            Map<String, Object> map){
        if (bindingResult.hasErrors()){
            // 返回错误页面
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/seller/admin/register");
            return new ModelAndView("common/error", map);
        }
        if (!form.getUsername().equals(form.getPassword())){
            map.put("msg","两次密码不一致");
            map.put("url","/seller/admin/register");
            return new ModelAndView("common/error", map);
        }
        Admin admin = new Admin();
        try{
            admin.setUsername(form.getUsername());
            admin.setPassword(form.getPassword());
            adminService.res(admin);
        }catch (AdminException e){
            map.put("msg",e.getMessage());
            map.put("url","/seller/admin/register");
            return new ModelAndView("common/error", map);
        }
        map.put("url","/seller/admin/register");
        return new ModelAndView("common/success", map);
    }

    @PostMapping("/login")
    public ModelAndView login(@Valid AdminForm form,
                              BindingResult bindingResult,
                              Map<String, Object> map){
        if (bindingResult.hasErrors()){
            // 返回错误页面
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/seller/Admin/login");
            return new ModelAndView("common/error", map);
        }
        try{
            adminService.login(form.getUsername(),form.getPassword());
        }catch (AdminException e){
            map.put("msg",e.getMessage());
            map.put("url","/seller/admin/login");
            return new ModelAndView("common/error", map);
        }
        map.put("url","/seller/product/list");
        return new ModelAndView("common/success", map);
    }

}
