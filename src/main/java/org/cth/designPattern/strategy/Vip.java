package org.cth.designPattern.strategy;

public class Vip implements CalPrice{//ConcreteStrategy
    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice * 0.9;
    }
}
