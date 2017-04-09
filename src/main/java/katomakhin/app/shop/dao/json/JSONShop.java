package katomakhin.app.shop.dao.json;

import katomakhin.app.shop.dao.ShopInterface;
import katomakhin.app.shop.entity.equipment.SportEquipment;
import katomakhin.app.shop.entity.equipment.array.ArrayEquipments;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;


public class JSONShop implements ShopInterface {
    public ArrayEquipments getAllEquipment() {
        ObjectMapper mapper = new ObjectMapper();
        ArrayEquipments arrayEquipments = new ArrayEquipments();
        try {
            arrayEquipments = mapper.readValue(new File("D:\\ProizPractic\\Shop\\src\\main\\resources\\json\\shop.json"),ArrayEquipments.class);

        }catch (IOException e){
            e.printStackTrace();
        }
        return arrayEquipments;
    }

    public SportEquipment[] getEquipmentsByCategory(String category) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayEquipments arrayEquipments;
        try {
            arrayEquipments = mapper.readValue(new File("D:\\ProizPractic\\Shop\\src\\main\\resources\\json\\shop.json"),ArrayEquipments.class);
            int arrayRange = 0;
            for (SportEquipment sportEquipment : arrayEquipments.getSportEquipments()) {
                if (sportEquipment.getCategory().equals(category)) {
                    arrayRange++;
                }
            }
            SportEquipment [] sportEquipments = new SportEquipment[arrayRange];
            int elementNumber = 0;
            for (SportEquipment sportEquipment : arrayEquipments.getSportEquipments()) {
                if (sportEquipment.getCategory().equals(category)) {
                    sportEquipments[elementNumber] = sportEquipment;
                    elementNumber++;
                }
            }
            return sportEquipments;
        }catch (IOException e){
            e.printStackTrace();
        }
        return new SportEquipment[0];
    }

    public void reserve(String title) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayEquipments arrayEquipments = new ArrayEquipments();
        try {
            JsonNode rootNode = mapper.readTree(new File("D:\\ProizPractic\\Shop\\src\\main\\resources\\json\\shop.json"));
            Iterator<JsonNode> equipmentIterator = rootNode.getElements();
            while(equipmentIterator.hasNext()) {
                if(equipmentIterator.next().get("title").getTextValue().equals(title)){

                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public SportEquipment getEquipment(String title){
        ObjectMapper mapper = new ObjectMapper();
        ArrayEquipments arrayEquipments = new ArrayEquipments();
        try {
            arrayEquipments = mapper.readValue(new File("D:\\ProizPractic\\Shop\\src\\main\\resources\\json\\shop.json"),ArrayEquipments.class);

        }catch (IOException e){
            e.printStackTrace();
        }
    for (SportEquipment sportEquipment : arrayEquipments.getSportEquipments()) {
        if (sportEquipment.getTitle().equals(title)) {
            return sportEquipment;
        }
    }

        return null;
    }
}
