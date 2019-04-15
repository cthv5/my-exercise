package org.cth.designPattern.strategy;

public class Orgnic implements CalPrice{//ConcreteStrategy
    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice;
    }
}
