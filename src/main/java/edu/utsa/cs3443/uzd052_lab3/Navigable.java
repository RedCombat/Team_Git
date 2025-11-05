package edu.utsa.cs3443.uzd052_lab3;

// interface for things that can navigate
public interface Navigable {
    void navigateTo(String location);
    void setCurrentSpeed(double speed);
    double getCurrentSpeed();
}
