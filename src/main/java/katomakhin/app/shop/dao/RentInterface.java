package katomakhin.app.shop.dao;

import katomakhin.app.shop.entity.rented.Rent;

import java.util.ArrayList;


public interface RentInterface {
    void update(Rent rent);
    ArrayList<Rent> getAllRentEquipment();
}
