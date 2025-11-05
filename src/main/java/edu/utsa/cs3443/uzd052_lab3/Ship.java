package edu.utsa.cs3443.uzd052_lab3;

// base ship class
public abstract class Ship implements Navigable {

    protected String name;
    protected String registrationNumber;
    protected double tonnage;
    protected int crewSize;
    protected double currentSpeed;
    protected String currentPort;

    public Ship(String name, String registrationNumber, double tonnage, int crewSize, String currentPort){
        this.name=name;
        this.registrationNumber=registrationNumber;
        this.tonnage=tonnage;
        this.crewSize=crewSize;
        this.currentPort=currentPort;
        this.currentSpeed=0.0;
    }

    public void dock(String port){
        this.currentPort = port;
        this.currentSpeed = 0.0;
    }

    @Override
    public void navigateTo(String location) {
        System.out.println(name + " is navigating to " + location + ".");
        setCurrentSpeed(20.0);
    }

    @Override
    public void setCurrentSpeed(double speed){
        this.currentSpeed= speed;
    }

    @Override
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    @Override
    public String toString(){
        return getClass().getSimpleName() + " [name=" + name + ", registrationNumber=" + registrationNumber +
                ", tonnage=" + tonnage + ", crewSize=" + crewSize + ",currentSpeed=" +
                currentSpeed + ", currentPort=" + currentPort + "]";
    }


    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name =name;
    }
    public String getRegistrationNumber(){
        return registrationNumber;
    }
    public void setRegistrationNumber(String registrationNumber){
        this.registrationNumber = registrationNumber;
    }
    public double getTonnage(){
        return tonnage;
    }
    public void setTonnage(double tonnage){
        this.tonnage = tonnage;
    }
    public int getCrewSize() {
        return crewSize;
    }
    public void setCrewSize(int crewSize){
        this.crewSize = crewSize;
    }
    public String getCurrentPort(){
        return currentPort;
    }
    public void setCurrentPort(String currentPort){
        this.currentPort = currentPort;
    }
}
