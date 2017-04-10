package katomakhin.app.shop.dao.json;

import katomakhin.app.shop.dao.RentInterface;
import katomakhin.app.shop.entity.rented.Rent;
import katomakhin.app.shop.entity.rented.array.ArrayRentEquipments;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ${Alexey} on ${09.08.2016}.
 */
public class JSONRent implements RentInterface {

    @Override
    public void update(Rent rent) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayRentEquipments arrayRentEquipments;
        try {
            arrayRentEquipments = mapper.readValue(new File("D:\\ProizPractic\\Shop\\src\\main\\resources\\json\\rent.json"), ArrayRentEquipments.class);
            arrayRentEquipments.add(rent);
            mapper.writeValue(new File("D:\\ProizPractic\\Shop\\src\\main\\resources\\json\\rent.json"), arrayRentEquipments);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Rent> getAllRentEquipment() {
        ObjectMapper mapper = new ObjectMapper();
        ArrayRentEquipments arrayRentEquipments = new ArrayRentEquipments();
        try {
            arrayRentEquipments = mapper.readValue(new File("D:\\ProizPractic\\Shop\\src\\main\\resources\\json\\rent.json"), ArrayRentEquipments.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayRentEquipments.getRentArray();
    }
}
