/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturant;

public class Worker extends Person{
    private double salary;

    public Worker(double salary) {
        this.salary = salary;
    }

    public Worker(double salary, String fullname, Date dob, String address) {
        super(fullname, dob, address);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  super.toString()+" salary=" + salary;
    }
    
}
