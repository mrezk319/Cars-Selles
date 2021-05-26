package project;

public class Car {

   String model,company;
   protected int productionYear;
   protected int numberOfSeats;
   protected int maxSpeed;
   protected float price;

    public Car(String model, String company, int productionYear, int numberOfSeats, int maxSpeed,int price) {
        this.model = model;
        this.company = company;
        this.productionYear = productionYear;
        this.numberOfSeats = numberOfSeats;
        this.maxSpeed = maxSpeed;
        this.price = price;
    }
    

    @Override
    public String toString() {
        return "Car {" + "model = " + model + ", company = " + company + ", productionYear = " + productionYear + ", numberOfSeats = " + numberOfSeats + ", maxSpeed = " + maxSpeed + ", price = " + price +"}";
    }



   
    
    
}
