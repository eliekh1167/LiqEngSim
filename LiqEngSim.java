/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.liqengsim;

/**
 *
 * @author hp
 */
import java.util.Scanner;

public class LiqEngSim {

    public static void main(String[] args) {
        Scanner sc;
        sc= new Scanner(System.in);

        // Constants
        final double g = 9.81;      // m/s^2
        final double dt = 0.5;       // s
        final double totalMDot = 20; // kg/s

        double fuelDensity= 0;
        double oxDensity= 1141; 
        double ofRatio= 0;
        double isp= 0;

        
        System.out.println(" ***Liquid Rocket Engine Simulator***");
        System.out.println("Select Propellant Combination:");
        System.out.println("1. LOX / Kerosene");
        System.out.println("2. LOX / Methane");
        System.out.println("3. LOX / Hydrogen");
        System.out.print("Enter choice: ");

        int choice;
        choice = sc.nextInt();

        do{ switch (choice) {
            case 1 -> {
                fuelDensity = 810;
                ofRatio = 2.56;
                isp = 300;
            }
            case 2 -> {
                fuelDensity = 422;
                ofRatio = 3.4;
                isp = 320;
            }
            case 3 -> {
                fuelDensity = 71;
                ofRatio = 6.0;
                isp = 450;
            }
            default -> {
                System.out.println("Invalid choice.");
             
            }
        }} while(choice!= 1 && choice!= 2 && choice!=3);

        System.out.print("Enter Fuel Volume (Liters): ");
        double fuelVol = sc.nextDouble();

        System.out.print("Enter Oxidizer Volume (Liters): ");
        double oxVol = sc.nextDouble();

        double fuelMass = fuelVol * fuelDensity / 1000.0;
        double oxMass = oxVol * oxDensity / 1000.0;

        double initialFuelMass = fuelMass;
        double initialOxMass = oxMass;

        double dryMass = 500.0; // kg (structure + payload)
        double vehicleMass;
        double velocity = 0.0;  // m/s
        double altitude = 0.0;  // m
        double acceleration;   // m^2/s
        double mDotFuel = totalMDot / (1.0 + ofRatio);
        double mDotOx = totalMDot - mDotFuel;

        System.out.println("\n Initial Propellant Mass:");
        System.out.printf("-Fuel Mass: %.2f kg", initialFuelMass);
        System.out.println();
        System.out.printf("-Ox Mass: %.2f kg", initialOxMass);
        System.out.println();

        System.out.println(" Time (s) | Thrust (N) | Fuel (L) | Ox (L) | Vel (m/s) | Alt (m)");
        System.out.println("-----------------------------------------------------------------");

        double time = 0.0;
        double totalImpulse = 0.0;
        String cutoffReason;
        double maxAltitude = 0.0;

        // Time-step loop
        while (fuelMass > 0 && oxMass > 0) {
            double thrust = totalMDot * isp * g;
            totalImpulse += (thrust * dt);
            vehicleMass = dryMass + fuelMass + oxMass;

            acceleration = (thrust - (vehicleMass * g)) / vehicleMass;
            velocity += (acceleration * dt);
            altitude += (velocity * dt);

            if (altitude < 0) {
                altitude = 0;
                velocity = 0;
            }
            if (altitude > maxAltitude) {
             maxAltitude = altitude;
            }

            fuelMass -= (mDotFuel * dt);
            oxMass -= (mDotOx * dt);

            if (fuelMass < 0) fuelMass = 0;
            if (oxMass < 0) oxMass = 0;

            fuelVol = fuelMass * 1000.0 / fuelDensity;
            oxVol = oxMass * 1000.0 / oxDensity;

            System.out.printf( "%7.2f s | %10.2f N | %8.2f L | %6.2f L | %8.2f | %8.2f",
            time, thrust, fuelVol, oxVol, velocity, altitude);
            System.out.println();
            time += dt;
        }

        if (fuelMass <= 0 && oxMass <= 0) {
            cutoffReason = "Both propellants depleted";
        } else if (fuelMass <= 0) {
            cutoffReason = "Fuel depleted";
        } else {
            cutoffReason = "Oxidizer depleted";
        }

        // Final summary
        System.out.println();
        System.out.println("Burn Summary:");
        System.out.printf("Total Burn Time: %.2f s", time);
        System.out.println();
        System.out.printf("Total Impulse:   %.2f N.s", totalImpulse);
        System.out.println();
        System.out.println("Reason for Cutoff: " + cutoffReason);
        System.out.printf("Max Altitude Reached: %.2f m", maxAltitude);
    }
}