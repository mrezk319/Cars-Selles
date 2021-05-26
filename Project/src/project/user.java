
package project;

import java.util.Scanner;

public class user extends Admin{
    Scanner inp = new Scanner (System.in);
    String model_car_buy;
    String y_n_car;    
    int total_price = 0,counter=0,enter;
    
    public user(){
        begin();
    }
    
    public void begin(){
        while(true)
        {
            System.out.println("Enter 1 if you want to buy a car");
            System.out.println("Enter 2 if you want to show all cars");
            System.out.println("Enter 3 if you want to search for a car");
            System.out.println("Enter 4 if you want to Logout");
            System.out.println("Enter 5 if you want to Exit");
            
            enter = inp.nextInt();            
            
            if(enter == 1){
                buy();
            }
            else if(enter == 2)
            {
               showCar();
            }
            else if(enter == 3){
                search();
            }
            else if(enter == 4){
                Login log  = new Login();
                break;
            }
            else if(enter == 5)
            {
                System.exit(0);
            }
        }
    }   
    
    public void buy(){
        while(true)
        {
        System.out.println("Enter a car model you want to buy : ");
        model_car_buy = inp.next();
        counter = 0;
        for(Car car : Admin.carList)
            {
                if(model_car_buy.toLowerCase().equals(car.model.toLowerCase()))
                {
                    total_price += car.price;
                    System.out.printf("Total price : %d\n",total_price);
                }
                else{
                    counter++;
                }
            }
        if (counter >carList.size()-1)
        {
            System.out.println("The car is not exist");
        }
            System.out.println("Do you want to buy other car enter (yes/no)");
            y_n_car = inp.next();
            
            if(y_n_car.toLowerCase().equals("yes")){
                continue;
            }
            else{
                System.out.println("Thanks to your confidence");
                break;
            }            
        }
    }
    
    @Override
    public void showCar(){
      
      for(Car c : Admin.carList)
        {
            System.out.println(c);
            System.out.println("---------------------------------");
            System.out.println();
        }
        System.out.println("These are the available cars");
    }
}