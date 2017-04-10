package katomakhin.app.shop.dao;

import katomakhin.app.shop.entity.equipment.SportEquipment;
import katomakhin.app.shop.entity.equipment.array.ArrayEquipments;

import java.io.IOException;

/**
 * Created by ${Alexey} on ${09.08.2016}.
 */
public interface ShopInterface {
    ArrayEquipments getAllEquipment();

    SportEquipment[] getEquipmentsByCategory(String category);

    void reserve(String title);

    SportEquipment getEquipment(String title) throws IOException;

}
