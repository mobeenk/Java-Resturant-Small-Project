
package resturant;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Resturant {
    private static ArrayList<Meal> activities = new ArrayList();
    private static ArrayList<Customer> customers = new ArrayList();
    private static ArrayList<Worker> workers = new ArrayList();
    private static int serialSequence = 100;
    
  
    public static void main(String[] args) {
        
        activityList();
        
            Scanner i = new Scanner(System.in);
            menu();
            System.out.println("Enter your choice: ");
            int option  = i.nextInt();
            int index = 0;
            String name = "";
            
            while(option != 7){
              
                   switch(option){
                       case 1:
                           Customer c = addCustomer();
                           customers.add(c);
                           System.out.println("New customer added...");
                           break;
                       case 2:
                           System.out.println("Enter customer name to add reservation for : ");
                            name = i.next();
                            index = getCustomerIndex(name);

                           if(index >=0){
                                Reservation newReserve =  addReservationDetail();
                                customers.get(index).reserve(newReserve);
                                System.out.println("Reservation was made with serial no: "+newReserve.getSerialNo());
                           }
                           else{
                                System.out.println("Not found!");
                           }
                           break;
                         
                       case 3:
                           System.out.println("Enter customer name to add reservation for : ");
                           name = i.next();
                           index = getCustomerIndex(name);
                      
                           if(index >=0){
                               
                                System.out.println("Enter Reservation serial to pay : ");
                                 int serialNo = i.nextInt();
                                 int resIndex = getCustomerReservationIndex(customers.get(index), serialNo);
                                 
                                    if(resIndex >= 0){
                                       int serialToPay = customers.get(index).getReservations().get(resIndex).getSerialNo();
                                       customers.get(index).payReservation( serialToPay);
                                       System.out.println("Customer new balance after payment: "+ customers.get(index).getBalance());
                                    }
                                    else{
                                         System.out.println("Reservation serial was Not found!");
                                    }
                           }
                           else{
                                System.out.println("Not found!");
                           }

                           break;
                       case 4:
                           printCustomers();
                           break;
                       case 5:
                           Worker w = addWorker();
                           workers.add(w);
                           System.out.println("New Worker added..."+w.getFullname());
                           break;
                       case 6:
                           printWorkers();
                           break;
                       case 8:
                          menu();
                           break;
                       default:
                            System.out.println("Invalid Choice !");
                           break;
                           
                   }
                
//                  menu();
                 
                  if( option != 7){
                          System.out.println("Enter your choice: ");
                        option  = i.nextInt();
                  }
                 
                   
            }
              System.out.println("System has shut down...");
    }
      public static void activityList(){
        activities.add (new Meal (MealType.Rosebeef, 150));
        activities.add( new Meal (MealType.barbque_meat, 100));
        activities.add( new Meal (MealType.salad, 250));
    }
    public static Date randomDate(){
        Random r = new Random();
        int year = r.nextInt(2021 - 2000 + 1) + 2000;
        int month = r.nextInt(12 - 1 + 1) + 1;
        int day = r.nextInt(30 - 1 + 1) + 1;
        Date d = new Date(year,month,day);
        return d;
    }
    public static Customer addCustomer(){
        Random r = new Random();
        Scanner i = new Scanner(System.in);
        int random = r.nextInt(4 - 0 + 1) + 0;
        int randomBalance = r.nextInt(25000 - 5000 + 1) + 5000;
        String[] addresses = {"Jeddah-23214","Riyad-23312","Tabuk-23155","Dammam-23143","Rabig-23666"};
        System.out.println("Enter fullname: ");
        String fullname = i.next();
//        System.out.println("Enter salary");
//        double salary = i.nextDouble();
        Customer c = new Customer(fullname, randomDate(), addresses[random], randomBalance);
        return c;
    }
    public static void printCustomers(){
        if(customers.isEmpty()){
            System.out.println("No customers found!");
//                     System.out.println("Enter your choice: ");
        }
        else{
                customers.forEach((c) -> {
            System.out.println(c.toString());
        });
        }
    
    }

     public static void test(){
        System.out.println(activities.get(0).toString());
    }
     public static int getCustomerReservationIndex(Customer c, int serialPassed){
         int index=0;

         for(Reservation reserve :  c.getReservations()){
             if(reserve.getSerialNo() == serialPassed){
                 return index;
             }
            index++;
         }
         
         return -1;
     }
    public static Reservation addReservationDetail(){
        
        Reservation r = new Reservation(++serialSequence, randomDate(), Status.paid);
         Scanner i = new Scanner(System.in);
        System.out.println("choose amount: ");
         int amount = i.nextInt();
        System.out.println("choose service type: \n"+
                "1. Rosebeef"+
                "2. Barbque meat"+
                "3. Salad\n"
        );
       
        int choice = i.nextInt();
        ReservationDetail rd ;

        switch(choice){
            case 1:
                rd = new ReservationDetail(activities.get(0), amount);
                r.addDetail(rd);
                break;
            case 2:
                rd = new ReservationDetail(activities.get(1), amount);
                r.addDetail(rd);
                break;
                
            case 3:
                rd = new ReservationDetail(activities.get(2), amount);
                r.addDetail(rd);
                break;
                
        }
        return r;
    }
    public static int getCustomerIndex(String name){

        int index = 0;
        boolean found = false;
        for(Customer customer: customers){
            if( customer.getFullname().toLowerCase().equals(name.toLowerCase())){
                found  = true;
                if( found)
                    return index;
            }
            index++;
        }  
       return -1;
    }
    public static Worker addWorker(){
        Random r = new Random();
        Scanner i = new Scanner(System.in);
        int random = r.nextInt(4 - 0 + 1) + 0;
        int randomSalary =  r.nextInt(8000 - 2500 + 1) + 2500;
        String[] addresses = {"Jeddah-23214","Riyad-23312","Tabuk-23155","Dammam-23143","Rabig-23666"};
        String[] randomWorkerName = {"Ahamd","Faisal","Sahar","Luna","Joli"};
        Worker c = new Worker(randomSalary, randomWorkerName[random], randomDate(), addresses[random]);
        return c;
    }
    public static void printWorkers(){
          if(workers.isEmpty()){
            System.out.println("No employees found!");
//                     System.out.println("Enter your choice: ");
        }
        else{
          workers.forEach((c) -> {
            System.out.println(c.toString());
        });
        }
        
    }
        public static void menu (){
            System.out.println(
                            "***** Welcome to Resturant *****\n" +
                            "1. Add An Customer\n" +
                            "2. Add a Reservation for a customer\n" +
                            "3. Pay for a Reservation \n" +
                            "4. Print Customers \n" +
                            "5. Add an Employee \n" +
                            "6. print Employees \n" +
                            "7. For Exit \n" +
                            "8. For Help \n" 
        );
    }


}
