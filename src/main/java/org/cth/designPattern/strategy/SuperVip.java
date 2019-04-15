package org.cth.designPattern.strategy;

public class SuperVip implements CalPrice {//ConcreteStrategy
    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice * 0.8;
    }
}
