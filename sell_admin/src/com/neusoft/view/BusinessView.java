package com.neusoft.view;

import com.neusoft.domain.business;

public interface BusinessView {
    public void listAllBusinesses();
    public void selectBusinesses();
    public void saveBusiness();
    public void removeBusiness();
    public business login();
    public void updatePassword(Integer businessId);
    public void lookBusinessId(Integer businessId);
    public void updateBusiness(Integer businessId);
}