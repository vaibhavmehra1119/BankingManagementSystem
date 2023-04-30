public class Customer {
    String name,dob,address,password;
    int user_id;

    public Customer(String name, String dob, int user_id,String address,String passsword) {
        this.name = name;
        this.dob = dob;
        this.user_id = user_id;
        this.address=address;
        this.password=passsword;
    }

    public Customer(String name,String dob,String address){
        this.name=name;
        this.dob=dob;
        this.address=address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
