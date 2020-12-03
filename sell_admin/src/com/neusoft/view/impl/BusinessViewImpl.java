package com.neusoft.view.impl;

import com.neusoft.dao.BusinessDao;
import com.neusoft.dao.impl.BusinessDaoImpl;
import com.neusoft.domain.business;
import com.neusoft.view.BusinessView;

import java.util.List;
import java.util.Scanner;

public class BusinessViewImpl implements BusinessView {

    private Scanner input = new Scanner(System.in);

    @Override
    public void listAllBusinesses() {
        BusinessDao dao = new BusinessDaoImpl();
        List<business> list = dao.listBusiness(null, null);
        System.out.println("商家编号" + "\t" + "商家名称" + "\t" + "商家地址" + "\t" + "商家备注" + "\t" + "商家配送费" + "\t" + "商家起送费");
        for (business b : list) {
            System.out.println(b.getBusinessId() + "\t" + b.getBusinessName() + "\t" + b.getBusinessAddress() + "\t" + b.getBusinessExplain() + "\t" + b.getDeliveryPrice() + "\t" + b.getStarPrice());
        }
    }

    @Override
    public void selectBusinesses() {
        String businessName = "";
        String inputStr = "";
        String businessAddress = "";
        System.out.println("请输入是否输入商家名称关键词(y/n):");
        inputStr = input.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入商家名称关键词");
            businessName = input.next();
        }

        System.out.println("请输入是否输入商家地址关键词(y/n):");
        inputStr = input.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入商家地址关键词");
            businessAddress = input.next();
        }
        BusinessDaoImpl dao = new BusinessDaoImpl();
        List<business> list = dao.listBusiness(businessName, businessAddress);
        System.out.println("商家编号" + "\t" + "商家名称" + "\t" + "商家地址" + "\t" + "商家备注" + "\t" + "商家配送费" + "\t" + "商家起送费");
        for (business b : list) {
            System.out.println(b.getBusinessId() + "\t" + b.getBusinessName() + "\t" + b.getBusinessAddress() + "\t" + b.getBusinessExplain() + "\t" + b.getDeliveryPrice() + "\t" + b.getStarPrice());
        }

    }

    @Override
    public void saveBusiness() {
        System.out.println("请输入新商家的名称：");
        String businessName = input.next();
        BusinessDao dao = new BusinessDaoImpl();
        int businessId = dao.saveBusiness(businessName);
        //根据id进行查询，然后进行回退
        if (businessId > 0) {
            System.out.println("保存成功");
            business business = dao.getBusinessById(businessId);
            System.out.println(business);
        } else {
            System.out.println("新建商家失败");
        }
    }

    @Override
    public void removeBusiness() {
        System.out.println("请输入删除的商家Id");
        int id = input.nextInt();
        BusinessDao dao = new BusinessDaoImpl();
        System.out.println("确认需要删除吗(y/n)");
        if (input.next().equals("y")) {
            int i = dao.removeBusiness(id);
            if (i == 1) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        }

    }

    @Override
    public business login() {
        System.out.println("请输入商家编号");
        Integer businessId = input.nextInt();

        System.out.println("请输入密码");
        String password = input.next();

        BusinessDaoImpl dao = new BusinessDaoImpl();

        return dao.getBusinessByIdAndPassword(businessId, password);
    }



    @Override
    public void updatePassword(Integer businessId) {
        BusinessDao dao = new BusinessDaoImpl();
        business business = dao.getBusinessById(businessId);

        System.out.println("请输入旧密码");
        String oldPass = input.next();
        System.out.println("请输入新密码");
        String newPass = input.next();
        System.out.println("请再次输入新密码");
        String beginNewPass = input.next();
        // 进行密码校验
        if (!business.getPassword().equals(oldPass)){
            System.out.println("你的密码蒙错了，请重新输入");
        }else if (!newPass.equals(beginNewPass)){
            System.out.println("两次密码不一致请重新输入");
        }else {
            int res = dao.updateBusinessPassword(businessId, newPass);
            if (res>0){
                System.out.println("修改密码成功！");
            }else {
                System.out.println("修改密码失败！");
            }
        }

    }

    @Override
    public void lookBusinessId(Integer businessId) {
            System.out.println("请输入需要查询的商家Id");
            businessId = input.nextInt();
            BusinessDao dao = new BusinessDaoImpl();
            business business = dao.getBusinessById(businessId);
            List<business> list = dao.NewlistBusiness(businessId);
            System.out.println("商家编号" + "\t" + "商家名称" + "\t" + "商家地址" + "\t" + "商家备注" + "\t" + "商家配送费" + "\t" + "商家起送费");
            for (business b : list) {
            System.out.println(b.getBusinessId() + "\t" + b.getBusinessName() + "\t" + b.getBusinessAddress() + "\t" + b.getBusinessExplain() + "\t" + b.getDeliveryPrice() + "\t" + b.getStarPrice());
        }
    }

    @Override
    public void updateBusiness(Integer businessId) {
        int menu = 0;
        int res=0;
        BusinessDao dao = new BusinessDaoImpl();
        business business = dao.getBusinessById(businessId);
        while (menu != 6){
            System.out.println(">>>   1. 修改商家名称  2. 修改商家地址    3. 修改商家备注    4.修改商家起送费      5. 修改商家配送费       6.返回上级菜单");
            System.out.println("请输入你要选择的序号");
            menu = input.nextInt();
            switch (menu){
                case 1:
                    System.out.println("请输入修改内容");
                    String newbusinessName = input.next();
                    System.out.println("确认需要修改吗(y/n)");
                    if (input.next().equals("y")) {
                        business.setBusinessName(newbusinessName);
                        res = dao.updateBusiness(business);
                        if (res>0) {
                            System.out.println("修改成功");
                        } else {
                            System.out.println("修改失败");
                        }
                    }
                    break;
                case 2:
                    System.out.println("请输入修改内容");
                    String newbusinessAddress = input.next();
                    System.out.println("确认需要修改吗(y/n)");
                    if (input.next().equals("y")) {
                        business.setBusinessAddress(newbusinessAddress);
                        res = dao.updateBusiness(business);
                        if (res>0) {
                            System.out.println("修改成功");
                        } else {
                            System.out.println("修改失败");
                        }
                    }
                    break;
                case 3:
                    System.out.println("请输入修改内容");
                    String newbusinessExplain = input.next();
                    System.out.println("确认需要修改吗(y/n)");
                    if (input.next().equals("y")) {
                        business.setBusinessExplain(newbusinessExplain);
                        res = dao.updateBusiness(business);
                        if (res>0) {
                            System.out.println("修改成功");
                        } else {
                            System.out.println("修改失败");
                        }
                    }
                    break;
                case 4:
                    System.out.println("请输入修改内容");
                    Double newStarPrice = input.nextDouble();
                    System.out.println("确认需要修改吗(y/n)");
                    if (input.next().equals("y")) {
                        business.setStarPrice(newStarPrice);
                        res = dao.updateBusiness(business);
                        if (res>0) {
                            System.out.println("修改成功");
                        } else {
                            System.out.println("修改失败");
                        }
                    }
                    break;
                case 5:
                    System.out.println("请输入修改内容");
                    String newdeliverPrice = input.next();
                    System.out.println("确认需要修改吗(y/n)");
                    if (input.next().equals("y")) {
                        business.setBusinessExplain(newdeliverPrice);
                        res = dao.updateBusiness(business);
                        if (res>0) {
                            System.out.println("修改成功");
                        } else {
                            System.out.println("修改失败");
                        }
                    }
                    break;
                case 6:
                    break;
                default:
                    System.out.println("没有这个选项");
                    break;

            }
        }
        }

    }



