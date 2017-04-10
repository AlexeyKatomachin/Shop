package katomakhin.app.shop.entity.rented;

import katomakhin.app.shop.entity.equipment.SportEquipment;

public class RentUnit {
    private SportEquipment[] units = new SportEquipment[2];

    public void setUnits(SportEquipment unit) {
        if (units.length == 0) {
            units[0] = unit;
        } else {
            units[units.length + 1] = unit;
        }
    }

    public SportEquipment[] getUnits() {
        return units;
    }
}
