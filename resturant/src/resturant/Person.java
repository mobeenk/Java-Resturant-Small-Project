
package resturant;


public abstract class Person {
    private String fullname;
    private Date dob;
    private String address;
    public Person(){}
    public Person(String fullname, Date dob, String address) {
        this.fullname = fullname;
        this.dob = dob;
        this.address = address;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "fullname=" + fullname + ", dob=" + dob + ", address=" + address;
    }
    
    
}
