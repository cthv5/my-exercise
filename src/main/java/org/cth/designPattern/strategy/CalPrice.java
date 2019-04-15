package org.cth.designPattern.strategy;

public interface CalPrice {//Strategy
    //根据原价返回一个最终的价格
    Double calPrice(Double orgnicPrice);
}
