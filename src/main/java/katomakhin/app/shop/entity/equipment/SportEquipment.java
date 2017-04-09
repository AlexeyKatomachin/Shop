package katomakhin.app.shop.entity.equipment;

public class SportEquipment {
    private String category;
    private String title;
    private int price;
    private int amount;

    public void setCategory(String category){
        this.category = category;
    }

    public String getCategory(){
        return category;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }

    @Override
    public String toString(){
        return "equipment[ category: " + category + ", title: " + title + ", price : " + price + "]";
    }
}
