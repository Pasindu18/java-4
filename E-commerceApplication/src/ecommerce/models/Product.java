package ecommerce.models;

public class Product {

    private int id;
    private String name;
    private double price;
    private int stock;

    //Constructor 

    public Product(int id, String name, double price, double d, int stock){
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock; 
    }
    //Cretae getters and settres

    public Product(int id2, String name2, int price2, double d, int stock2) {
        //TODO Auto-generated constructor stub
    }

    public int getId(){
        return id;
        
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
        this.stock =stock;
    }

    @Override
    public String toString() {
        return "Product{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", price=" + price +
               ", stock=" + stock +
               '}';
    }

}
