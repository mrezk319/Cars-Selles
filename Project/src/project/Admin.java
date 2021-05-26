package project;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin{
    int menuNum;   
    static ArrayList<Car> carList = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    String model,company;
    int productionYear;
    int numberOfSeats;
    int maxSpeed;
    int price;
    boolean excution = true;
    
    public void mainAdmin()
    {
        while(excution)
        {
            System.out.println("To add a new car press 1");
            System.out.println("To delete a car press 2");
            System.out.println("To edit a car press 3"); 
            System.out.println("To show the cars press 4");
            System.out.println("To search for a car press 5");
            System.out.println("To logout press 6");
            System.out.println("To exit press 7");            

            menuNum = input.nextInt();
            if(menuNum == 1)
            {
                addCar();
            }else if (menuNum == 2)
            {
                deleteCar();
            }else if(menuNum == 3)
            {
                editCar();
            }else if(menuNum == 4)
            {
                showCar();
            }
            else if(menuNum == 5)
            {
                search();
            }
            else if(menuNum == 6)
            {
                Login log = new Login();
                break;
            }
            
            else if(menuNum == 7)
            {
                System.exit(0);
            }
            
        }
    }
    
    public void addCar()
    {
      System.out.println("Enter car model : ");
      this.model = input.next();
      this.model = this.model.toLowerCase();
      System.out.println("Enter car company : ");
      this.company = input.next();
      this.company = this.company.toLowerCase();
      System.out.println("Enter car production year : ");
      this.productionYear = input.nextInt();
      System.out.println("Enter car number of seats : ");
      this.numberOfSeats = input.nextInt();
      System.out.println("Enter car max speed : ");
      this.maxSpeed = input.nextInt();
      System.out.println("Enter car price : ");
      this.price = input.nextInt();
      Car car = new Car(this.model,this.company,this.productionYear,this.numberOfSeats,this.maxSpeed,this.price);
      carList.add(car);  
     
    }
    public void deleteCar()
    {
        int num;
        System.out.println("Enter the number of the car you want to delete");
        num = input.nextInt();
        carList.remove(num-1);
        
    }
    public void showCar()
    {
        for(Car c : carList)
        {
            System.out.println(c);
            System.out.println("---------------------------------");
            System.out.println();
        }
    }
    
    public void editCar()
    {
        int num,newDataInt;
        boolean excute = true;
        String dataName,newDataString;
        char answer;
        System.out.println("Enter the number of the car you want to edit");
        num = input.nextInt();
        System.out.println(carList.get(num-1));
        System.out.println("Enter the dataName you want to change");
        
        while(excute)
        {
            dataName = input.next();
            dataName = dataName.toLowerCase();
       
            if(dataName.equals("company"))
            {
                System.out.println("Enter the data");
                newDataString = input.next();
                newDataString =  newDataString.toLowerCase();
                carList.get(num-1).company = newDataString;
            }else if(dataName.equals("model")) 
            {
                System.out.println("Enter the data");
                newDataString = input.next();
                newDataString = newDataString.toLowerCase();
                carList.get(num-1).model = newDataString;
            }else if(dataName.equals("productionyear"))
            {
                System.out.println("Enter the data");
                newDataInt = input.nextInt();
                carList.get(num-1).productionYear = newDataInt;
            }else if(dataName.equals("numberofseats"))
            {
                System.out.println("Enter the data");
                newDataInt = input.nextInt();
                carList.get(num-1).numberOfSeats = newDataInt;

            }else if(dataName.equals("maxSpeed"))
            {
                System.out.println("Enter the data");
                newDataInt = input.nextInt();
                carList.get(num-1).maxSpeed = newDataInt;
            }else if(dataName.equals("price"))
            {
                System.out.println("Enter the data");
                newDataInt = input.nextInt();
                carList.get(num-1).price = newDataInt;
            }else
            {
                System.out.println("Enter a valide data");
                continue;
            }       

            System.out.println("Data changed successfully!!");
            System.out.println("Do you want to change another data? Y/N?");
            answer = input.next().charAt(0);
            if(answer == 'Y' || answer =='y')
            {
                excute = true;
            }else if(answer == 'N' || answer =='n')
            {
                excute = false;
            }else{
                while(true)
                {
                    System.out.println("Enter a Valide data");
                    answer = input.next().charAt(0);
                    if(answer == 'Y' || answer =='y')
                    {
                        excute = true;
                        break;
                    }else if(answer == 'N' || answer =='n')
                    {
                        excute = false;
                        break;
                     }
                }
            } 
        }
    
    }
    

    public void search()
    {
        
        
        System.out.print("Enter the company name or the production year : ");
        String searVal;
        
        searVal=input.next();
        
        try {
            int number = Integer.parseInt(searVal); 

            display(Admin.carList,number);

          } catch (NumberFormatException nfe) {
            display(Admin.carList,searVal);
          }
        
    }
    
    public void display(ArrayList<Car> cars, int proYear)
    {
        for(int i = 0 ; i < cars.size() ; i++)
        {       boolean found = false;
            if(cars.get(i).productionYear == proYear)
            {
                found = true;
                System.out.println("Car "+(i+1)+" => {" + "model = " + cars.get(i).model + ", company = " + cars.get(i).company + ", productionYear = " + cars.get(i).productionYear + ", numberOfSeats = " + cars.get(i).numberOfSeats + ", maxSpeed = " + cars.get(i).maxSpeed + ", price = " + cars.get(i).price +"}");
                
                System.out.println("---------------------------------");
            }
            if(!found)
            {
                System.out.println("No data found");
            }
        }
    }
     
      public void display(ArrayList<Car> cars,String comp)
      {
          
          for(int i=0;i<cars.size();i++){
                boolean found = false;
                if(cars.get(i).company.equals(comp))
                {

                    found = true;
                    System.out.println("Car "+(i+1)+" => {" + "model = " + cars.get(i).model + ", company = " + cars.get(i).company + ", productionYear = " + cars.get(i).productionYear + ", numberOfSeats = " + cars.get(i).numberOfSeats + ", maxSpeed = " + cars.get(i).maxSpeed + ", price = " + cars.get(i).price +"}");

                    System.out.println("---------------------------------");
                }
                    if(!found)
                    {
                        System.out.println("No data found");
                    }
              } 
          }
}

    

