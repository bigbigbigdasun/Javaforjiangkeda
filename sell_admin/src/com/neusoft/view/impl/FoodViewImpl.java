package com.neusoft.view.impl;

import com.neusoft.dao.BusinessDao;
import com.neusoft.dao.FoodDao;
import com.neusoft.dao.impl.BusinessDaoImpl;
import com.neusoft.dao.impl.FoodDaoImpl;
import com.neusoft.domain.food;
import com.neusoft.view.FoodView;

import java.util.List;
import java.util.Scanner;

public class FoodViewImpl implements FoodView {
    private Scanner input = new Scanner(System.in);

    @Override
    public List<food> showFoodList(Integer businessId) {
        FoodDao dao = new FoodDaoImpl();
        List<food> list = dao.listFoodByBusinessId(businessId);
        System.out.println("食品编号" + "\t" + "食品名称" + "\t" + "食品备注" + "\t" + "食品价格");
        for (food f : list) {
            System.out.println(f.getFoodId() + "\t" + f.getFoodName() + "\t" + f.getFoodExplain() + "\t" + f.getFoodPrice());
        }
        return list;
    }

    @Override
    public void saveFood(Integer businessId) {
        System.out.println("请输入新食品的名称");
        String foodName = input.next();
        System.out.println("请输入新食品的备注");
        String foodExplain = input.next();
        System.out.println("请输入新食品的价格");
        Integer foodPrice = input.nextInt();
        FoodDao dao = new FoodDaoImpl();
        food food = new food();
        food.setFoodName(foodName);
        food.setFoodExplain(foodExplain);
        food.setFoodPrice(foodPrice);
        food.setBusinessId(businessId);
        int foodId = dao.saveFood(food);
        // 根据id进行查询， 然后进行回显
        if (foodId > 0) {
            System.out.println("保存成功");
            food = dao.getFoodById(foodId);
            System.out.println(food);
        } else {
            System.out.println("新建食品失败");
        }
    }

    @Override
    public void updateFood(Integer businessId) {
        FoodDao dao = new FoodDaoImpl();
        int foodId = 0;
        System.out.println("请输入你要修改的食品编号：");
        foodId = input.nextInt();
        food food = dao.getFoodById(foodId);
        int menu = 0;
        int res = 0;
        while (menu != 4) {
            System.out.println(">>> 二级菜单  1. 修改名称   2. 修改备注    3. 修改价格    4. 返回上一级菜单");
            System.out.println("请输入你要选择的序号：");
            menu = input.nextInt();
            System.out.println("请输入修改后的内容：");
            switch (menu) {
                case 1:
                    System.out.println("请输入修改内容");
                    String newfoodName = input.next();
                    System.out.println("确认需要修改吗(y/n)");
                    if (input.next().equals("y")) {
                        food.setFoodName(newfoodName);
                        res = dao.updateFood(food);
                        if (res > 0) {
                            System.out.println("修改成功");
                        } else {
                            System.out.println("修改失败");
                        }
                    }
                    break;
                case 2:
                    System.out.println("请输入修改内容");
                    String newfoodExplain = input.next();
                    System.out.println("确认需要修改吗(y/n)");
                    if (input.next().equals("y")) {
                        food.setFoodExplain(newfoodExplain);
                        res = dao.updateFood(food);
                        if (res > 0) {
                            System.out.println("修改成功");
                        } else {
                            System.out.println("修改失败");
                        }
                    }
                    break;
                case 3:
                    System.out.println("请输入修改内容");
                    Integer newfoodPrice = input.nextInt();
                    System.out.println("确认需要修改吗(y/n)");
                    if (input.next().equals("y")) {
                        food.setFoodPrice(newfoodPrice);
                        res = dao.updateFood(food);
                        if (res > 0) {
                            System.out.println("修改成功");
                        } else {
                            System.out.println("修改失败");
                        }
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("没有这个选项");
                    break;
            }
        }
    }

    @Override
    public void removeFood(Integer foodId) {
        System.out.println("请输入删除的食品Id");
        int id = input.nextInt();
        FoodDao dao = new FoodDaoImpl();
        System.out.println("确认需要删除吗(y/n)");
        if (input.next().equals("y")) {
            int i = dao.removeFood(id);
            if (i == 1) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        }
    }
}