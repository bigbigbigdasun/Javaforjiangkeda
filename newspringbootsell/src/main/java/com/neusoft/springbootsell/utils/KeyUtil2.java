package com.neusoft.springbootsell.utils;

import java.util.Random;

public class KeyUtil2 {
    public static synchronized Integer genUniqueKey(){
        Random random=new Random();
        Integer number= random.nextInt(900000)+100000;
        return Integer.valueOf(System.currentTimeMillis() + String.valueOf(number));
    }
}
