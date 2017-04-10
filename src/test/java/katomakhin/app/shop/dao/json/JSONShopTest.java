package katomakhin.app.shop.dao.json;

import katomakhin.app.shop.entity.equipment.SportEquipment;
import katomakhin.app.shop.facade.ShopManager;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;


public class JSONShopTest {

    @Test
    public void getAllEquipmentTest() throws IOException {
        for (SportEquipment sport: new JSONShop().getAllEquipment().getSportEquipments()) {
            System.out.println(sport.toString());
            assertNotNull(sport.toString());
        }
    }

    @Test
    public void  getEquipmentsByCategoryTest(){
        for (SportEquipment sport: new JSONShop().getEquipmentsByCategory("watch")) {
            System.out.println(sport.toString());
            assertNotNull(sport.toString());
        }
    }

    @Test
    public void reserveTest(){
        int flag = new ShopManager().initShop().getGoods().get(new JSONShop().getEquipment("luch"));
        new JSONShop().reserve("luch");
        assertNotEquals((long) flag, (long)new ShopManager().initShop().getGoods().get(new JSONShop().getEquipment("luch")));
    }

    @Test
    public void getEquipmentTest(){
        assertNotNull(new JSONShop().getEquipment("luch").toString());
    }
}
