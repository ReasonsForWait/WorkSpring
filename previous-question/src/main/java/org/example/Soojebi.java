package org.example;
abstract class Vehicle{
    private String name;
    abstract public String getName(String val);
    public String getName(){
        return "Vehicle name : " + name;
    }
    public void setName(String val){
        name = val;
    }
}
class Car extends Vehicle{
    public Car(String val){
        System.out.println("setName 실행");
        setName(val);
    }
    public String getName(String val){
        return "Car name : " + val;
    }
}
public class Soojebi{
    public static void main(String[] args) {
        Car obj = new Car("abc");
        System.out.println(obj.getName());
    }
}
