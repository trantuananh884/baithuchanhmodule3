package Model;

public class Product {
    int id;
    String name;
    int price;
    int quant;
    String color;
    String desc;
    String category;

    public Product(int id, String name, int price, int quant, String color, String desc, String category) {.
        this.id = id;
        this.name = name;
        this.price = price;
        this.quant = quant;
        this.color = color;
        this.desc = desc;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
