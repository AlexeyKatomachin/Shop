package katomakhin.app.shop.entity;

import katomakhin.app.shop.entity.equipment.SportEquipment;

import java.util.Map;

public class Shop {
    private Map<SportEquipment,Integer> goods;

    public void setGoods(SportEquipment unit){
        if (goods.size() == 0){
            goods.put(unit,0);
        }else {
            goods.put(unit,goods.size()+1);
        }
    }

    public Map<SportEquipment,Integer> getGoods(){
        return goods;
    }
}
