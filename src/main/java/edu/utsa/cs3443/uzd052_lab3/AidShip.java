package edu.utsa.cs3443.uzd052_lab3;

// aid ship class
public class AidShip extends Ship implements EmergencySupport {
    private String aidType;
    private int suppliesOnBoard;
    private boolean hasHelipad;

    public AidShip(String name, String registrationNumber, double tonnage, int crewSize, String currentPort, String aidType,
                   int suppliesOnBoard, boolean hasHelipad) {
        super(name, registrationNumber, tonnage, crewSize, currentPort);
        this.aidType = aidType;
        this.suppliesOnBoard = suppliesOnBoard;
        this.hasHelipad = hasHelipad;
    }

    @Override
    public void dock(String port){
        super.dock(port);
        unloadSupplies();
    }

    private void unloadSupplies() {
        this.suppliesOnBoard = 0;
    }

    @Override
    public void deployAid() {
        System.out.println("Aid Ship " + name + " is deploying " + suppliesOnBoard + " units of " + aidType + " aid.");
        unloadSupplies();
    }

    @Override
    public String getEmergencyReadinessReport(){
        return "Aid Ship Emergency Report:\n" +
                "Name: " + name +"\n" +
                "Supplies on Board: " + suppliesOnBoard +"\n" +
                "Helipad: " + (hasHelipad ? "Available" : "Not Available") + "\n" +
                "===============================";
    }

    @Override
    public String toString(){
        return super.toString() + ", aidType= " + aidType + ", suppliesOnBoard= " + suppliesOnBoard +
                ", hasHelipad= " + hasHelipad + "]";
    }
    public String getAidType() {
        return aidType;
    }

    public int getSuppliesOnBoard() {
        return suppliesOnBoard;
    }

    public boolean hasHelipad() {
        return hasHelipad;
    }
}
