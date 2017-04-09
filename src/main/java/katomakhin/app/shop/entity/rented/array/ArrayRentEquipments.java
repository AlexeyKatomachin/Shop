package katomakhin.app.shop.entity.rented.array;

import katomakhin.app.shop.entity.rented.Rent;

import java.util.ArrayList;

/**
 * Created by ${Alexey} on ${09.08.2016}.
 */
public class ArrayRentEquipments {
    private ArrayList<Rent> rentArray = new ArrayList<Rent>();

    public void setRentArray (Rent rent){
        rentArray.add(rent);
    }

    public ArrayList<Rent> getRentArray(){
        return rentArray;
    }
}
