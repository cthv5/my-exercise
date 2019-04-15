package org.cth.designPattern.strategy;

public class GoldVip implements CalPrice {//ConcreteStrategy
    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice * 0.7;
    }
}
