package com.neusoft.dao;

import com.neusoft.domain.business;

import java.util.List;

public interface BusinessDao {
    // 所有商家列表
    public List<business> listBusiness(String businessName,String businessaddress);
    // 保存商家 返回值是 保存商家时自动生成的那个主键id
//    public void saveBusiness(Business business);
    public int saveBusiness(String businessName);
    // 删除商家
    public int removeBusiness(int businessId);
    // 修改商家
    public int updateBusiness(business business);    // 通过id查询
    public business getBusinessById(Integer businessId);
    //通过id和password进行查询返回business对象
    public  business getBusinessByIdAndPassword(Integer businessId,String password);
    //更新密码
    public int updateBusinessPassword(Integer businessId,String password);
    public List<business> NewlistBusiness(Integer businessId);

}