package katomakhin.app.shop.facade;

import katomakhin.app.shop.entity.Shop;
import katomakhin.app.shop.entity.equipment.SportEquipment;
import katomakhin.app.shop.entity.user.User;

import java.util.List;

public interface ShopManagerInterface {
    Shop rentEquipment(String title,Shop shop,User user);
    List<SportEquipment> freeEquipment();
    List<SportEquipment> rentEquipment();
    Shop initShop();
    void printFreeEquipment();
    void printRentEquipment();
}
