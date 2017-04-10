package katomakhin.app.shop.entity;

import katomakhin.app.shop.entity.equipment.SportEquipment;

import java.util.HashMap;
import java.util.Map;

public class Shop {
    private Map<SportEquipment, Integer> goods = new HashMap<>();

    public void setGoods(Map<SportEquipment,Integer> goods){
        this.goods = goods;
    }

    public void add(SportEquipment unit){
        goods.put(unit,unit.getAmount());
    }

    public Map<SportEquipment,Integer> getGoods(){
        return goods;
    }
}
