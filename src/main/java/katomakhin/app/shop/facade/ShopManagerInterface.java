package katomakhin.app.shop.facade;

import katomakhin.app.shop.entity.Shop;
import katomakhin.app.shop.entity.equipment.SportEquipment;

import java.util.ArrayList;

/**
 * Created by ${Alexey} on ${09.08.2016}.
 */
public interface ShopManagerInterface {
    void rentEquipment(String title);
    ArrayList<SportEquipment> getFreeEquipment();
    Shop initShop();

}
