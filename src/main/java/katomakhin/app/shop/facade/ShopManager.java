package katomakhin.app.shop.facade;

import katomakhin.app.shop.dao.json.JSONRent;
import katomakhin.app.shop.dao.json.JSONShop;
import katomakhin.app.shop.entity.Shop;
import katomakhin.app.shop.entity.equipment.SportEquipment;
import katomakhin.app.shop.entity.rented.Rent;
import katomakhin.app.shop.entity.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ShopManager implements ShopManagerInterface {
    @Override
    public Shop rentEquipment(String title, Shop shop, User user) {
        ArrayList<Rent> rents = new JSONRent().getAllRentEquipment();
        SportEquipment sportEquipment = new JSONShop().getEquipment(title);
        int rangeRent = 0;
        for (Rent rent : rents) {
            if (rent.getUserID().equals(user.getUserID())) {
                rangeRent++;
            }
            if (rangeRent > 2) {
                return shop;
            }
        }
        if (shop.getGoods().get(sportEquipment) == 0) {
            return shop;
        } else {
            rangeRent = shop.getGoods().get(sportEquipment);
            Map<SportEquipment, Integer> map = shop.getGoods();
            map.remove(sportEquipment);
            map.put(sportEquipment, rangeRent--);
            shop.setGoods(map);
        }
        Rent rent = new Rent();
        rent.setSportEquipment(sportEquipment);
        rent.setUserID(user.getUserID());
        new JSONRent().update(rent);
        return shop;
    }

    @Override
    public List<SportEquipment> freeEquipment() {
        List<SportEquipment> freeEquipments = new JSONShop().getAllEquipment().getSportEquipments();
        for (SportEquipment sportEquipment : new JSONShop().getAllEquipment().getSportEquipments()) {
            for (Rent rent : new JSONRent().getAllRentEquipment()) {
                if (sportEquipment.equals(rent.getSportEquipment())) {
                    freeEquipments.remove(sportEquipment);
                }
            }
        }
        return freeEquipments;
    }

    @Override
    public List<SportEquipment> rentEquipment() {
        List<SportEquipment> equipments = new ArrayList<>();
        for (Rent rent : new JSONRent().getAllRentEquipment()) {
            equipments.add(rent.getSportEquipment());
        }
        return equipments;
    }

    @Override
    public Shop initShop() {
        Shop shop = new Shop();
        for (SportEquipment sportEquipment : new JSONShop().getAllEquipment().getSportEquipments()) {
            shop.add(sportEquipment);
        }
        return shop;
    }

    @Override
    public void printFreeEquipment() {
        List<SportEquipment> freeEquipment = freeEquipment();
        for (SportEquipment equipment : freeEquipment) {
            System.out.println(equipment.toString());
        }
    }

    @Override
    public void printRentEquipment() {
        List<SportEquipment> rentEquipment = rentEquipment();
        for (SportEquipment equipment : rentEquipment) {
            System.out.println(equipment.toString());
        }
    }


}
