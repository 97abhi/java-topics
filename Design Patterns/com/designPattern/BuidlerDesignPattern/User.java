package BuidlerDesignPattern;

public class User {

    private int userId;
    private String name;
    private String email;
    private String address;

    public User(Builder builder){
        this.name = builder.name;
        this.email = builder.email;
        this.address = builder.address;
        this.userId = builder.userId;
    }

    //static nested builder class
    static class Builder{
        private int userId;
    private String name;
    private String email;
    private String address;

    public Builder setUserId(int userId){
        this.userId = userId;
        return this;
    }

    public Builder setName(String name){
        this.name = name;
        return this;
    }

    public Builder setEmail(String email){
        this.email = email;
        return this;
    }

    public Builder setAddress(String address){
        this.address = address;
        return this;
    }

    public User build(){
        return new User(this);
    }
}
public String toString(){
    return name +  " ," + email + " ," + address + " , " + userId; 
}
}
