package katomakhin.app.shop.entity.equipment.array;

import katomakhin.app.shop.entity.equipment.SportEquipment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${Alexey} on ${09.08.2016}.
 */
public class ArrayEquipments {
    private ArrayList<SportEquipment> sportEquipments = new ArrayList<>();

    public void setSportEquipments(ArrayList<SportEquipment> sportEquipments) {
        this.sportEquipments = sportEquipments;
    }

    public void add(SportEquipment sportEquipments) {
        this.sportEquipments.add(sportEquipments);
    }

    public List<SportEquipment> getSportEquipments() {
        return sportEquipments;
    }
}
