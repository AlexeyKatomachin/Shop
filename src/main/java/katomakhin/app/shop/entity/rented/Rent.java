package katomakhin.app.shop.entity.rented;

import katomakhin.app.shop.entity.equipment.SportEquipment;

/**
 * Created by ${Alexey} on ${09.08.2016}.
 */
public class Rent {
    private SportEquipment sportEquipment;
    private String userID;

    public void setSportEquipment(SportEquipment sportEquipment) {
        this.sportEquipment = sportEquipment;
    }

    public SportEquipment getSportEquipment() {
        return sportEquipment;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }
}
