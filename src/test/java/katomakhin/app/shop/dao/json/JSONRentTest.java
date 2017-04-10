package katomakhin.app.shop.dao.json;

import katomakhin.app.shop.entity.equipment.SportEquipment;
import katomakhin.app.shop.entity.rented.Rent;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JSONRentTest {
    @Test
    public void updateTest(){
        SportEquipment equipment = new JSONShop().getEquipment("luch");
        for (Rent rent: new JSONRent().getAllRentEquipment()) {
            if(equipment.toString().equals(rent.getSportEquipment().toString())){
                assertEquals(equipment.toString(),rent.getSportEquipment().toString());
            }
        }
    }

    @Test
    public void getAllRentEquipment(){
        for (Rent rent: new JSONRent().getAllRentEquipment()) {
            assertNotNull(rent.getSportEquipment().toString());
        }
    }
}
