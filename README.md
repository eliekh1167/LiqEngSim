# LiqEngSim
LiqEngSim is a Java-based simulation program that models the burn of a liquid rocket engine using a time-step approach. The program allows users to select different propellant combinations and visualizes the engine's performance over time.

#Features:
Interactive menu to select propellant types:
-LOX/Kerosene
-Liquid Hydrogen/LOX
-Nitrogen Tetroxide/UDMH

Simulates engine burn dynamics step by step

Calculates key performance parameters including:
-Mass flow rates
-Thrust
-Propellant consumption

Adjustable time steps to observe how engine behavior evolves

Console-based display for simplicity and clarity

#Installation

Make sure you have Java JDK 8 or higher installed.

Download the LiqEngSim.java file.

Open a terminal/command prompt in the directory containing the file.

Compile the program:

javac LiqEngSim.java


Run the program:

java LiqEngSim

#Usage

1-Launch the program
2-Select a propellant type from the menu
3-Input the simulation parameters as prompted (e.g., total burn time, time step)
4-Observe the simulation output for each time step:
Remaining fuel/oxidizer
Thrust produced
Engine performance metrics
5-Repeat with different propellants or time steps for comparison.

#Sample Output:
Select propellant:
1. LOX/Kerosene
2. Liquid Hydrogen/LOX
3. Nitrogen Tetroxide/UDMH
Enter choice: 1

Time: 0 s | Thrust: 500 kN | Fuel left: 810 kg | Oxidizer left: 1141 kg
Time: 10 s | Thrust: 498 kN | Fuel left: 790 kg | Oxidizer left: 1115 kg
...

#Constants and Inputs:
-Propellant Densities (kg/m³)
-Oxidizer/Fuel Ratios
-Burn time and time-step (user input)
-Thrust and engine efficiency (calculated per step)

This project can be extended to include:

-More propellant options
-Graphical visualization of thrust and mass over time
-Integration with machine learning for predictive engine optimization

Contributions are welcome! Fork the repository and submit pull requests.
