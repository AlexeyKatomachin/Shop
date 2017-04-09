package katomakhin.app.shop.dao.json;

import katomakhin.app.shop.entity.equipment.SportEquipment;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by ${Alexey} on ${09.08.2016}.
 */
public class JSONShopTest {

    @Test
    public void getAllEquipmentTest() throws IOException {
        for (SportEquipment sport: new JSONShop().getAllEquipment().getSportEquipments()) {
            System.out.println(sport.toString());
        }
    }
}
