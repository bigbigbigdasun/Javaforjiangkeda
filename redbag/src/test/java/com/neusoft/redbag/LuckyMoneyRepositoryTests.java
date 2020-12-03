package com.neusoft.redbag;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LuckyMoneyRepositoryTests {
    @Autowired
    private LuckyMoneyRepository repository;
@Test
    public void listAll(){
    List<LuckyMoney> list =repository.findAll();
    for(LuckyMoney luckyMoney:list){
        System.out.println(luckyMoney);
    }
}
@Test
    public void save(){
    LuckyMoney luckyMoney=new LuckyMoney();
    luckyMoney.setConsumer("李四");
    luckyMoney.setMoney(new BigDecimal(11));
    luckyMoney.setProducer("张三");
    repository.save(luckyMoney);
    repository.saveAndFlush(luckyMoney);
    }
    @Test
    public void delete(){
    repository.deleteById(2);
    }
    @Test
    public void update(){
        LuckyMoney luckyMoney=new LuckyMoney();
        luckyMoney.setConsumer("da张");
        luckyMoney.setMoney(new BigDecimal(110));
        luckyMoney.setProducer("小张");
        luckyMoney.setId(3);
        repository.save(luckyMoney);
    }
}
