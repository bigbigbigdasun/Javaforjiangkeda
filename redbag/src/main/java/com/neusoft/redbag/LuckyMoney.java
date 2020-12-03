package com.neusoft.redbag;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * LuckyMoney是与数据库表中字段一一对应的实体类
 * JavaBean 格式
 */
@Entity
@Data
@NoArgsConstructor
public class LuckyMoney {
    //@Entity指定该类是实体类、@Id代表主键、@GeneratedValue代表自增长
    @Id
    @GeneratedValue
    private Integer id;
    //红包金额
    private BigDecimal money;
    //发红包的人
    private String producer;
    //收红包的人
    private String consumer;
}