package org.cth.designPattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class BuildingFactory {
    private static final Map<String, Gym> gyms = new HashMap<>();
    public static Gym getGym(String sport){
        Gym gym = gyms.get(sport);
        if (gym == null){
            gym = new Gym(sport);
            gyms.put(sport, gym);
        }
        return gym;
    }
    public static int getSize(){
        return gyms.size();
    }
}
