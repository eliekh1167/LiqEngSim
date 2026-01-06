#LiqEngSim – Liquid Rocket Engine Simulator (Java)

LiqEngSim is a console-based Java program that simulates the burn and basic flight dynamics of a liquid rocket engine using a time-step numerical approach.
Users can select different LOX-based propellant combinations, input propellant volumes, and observe thrust, velocity, and altitude evolution during engine burn.

#Key Features
Multiple propellant combinations

-LOX / Kerosene (RP‑1)
-LOX / Methane
-LOX / Liquid Hydrogen

Physics-based thrust calculation using specific impulse (Isp)

Mass flow rate split using oxidizer-to-fuel (O/F) ratio

Time-step simulation with configurable resolution

Basic 1D vertical flight model
-Gravity
-Acceleration
-Velocity
-Altitude

Automatic engine cutoff detection

Final burn summary including total impulse and max altitude

#Propellant Models
Propellant	Fuel Density (kg/m³)	O/F Ratio	Isp (s)
LOX / Kerosene	810	2.56	300
LOX / Methane	422	3.4	320
LOX / Hydrogen	71	6.0	450

Oxidizer density (LOX) is assumed constant at 1141 kg/m³.

#Physics Model Overview
Thrust= m x ISP x g
Where: m = total mass flow rate (20 kg/s)
ISP = specific impulse (depends on propellant)
g= 9.81

Acceleration:
𝑎 =𝑇−𝑚𝑔/𝑚
Vehicle mass decreases dynamically as propellant is consumed.

Time Integration:
-Fixed time step: 0.5 s
-Euler integration for velocity and altitude

#Inputs

At runtime, the user provides:
-Propellant combination
-Fuel volume (liters)
-Oxidizer volume (liters)

#Outputs

During the simulation, the program prints a time-step table:

Time (s) | Thrust (N) | Fuel (L) | Ox (L) | Vel (m/s) | Alt (m)

At the end, a burn summary is displayed:
-Total burn time
-Total impulse
-Engine cutoff reason
-Maximum altitude reached

#How to Run
Requirements:

Java JDK 8 or higher
Compile:
javac LiqEngSim.java

Run:
java LiqEngSim

#Example Use Cases

-Educational demonstrations of rocket propulsion
-Introductory aerospace simulations
-Physics-based programming projects
-STEM outreach or competitions
-Foundation for more advanced rocket modeling

#Possible Future Extensions

-Atmospheric drag
-Variable mass flow rate
-Multi-stage rockets
-Export data to CSV for plotting
-JavaFX or GUI visualization
-Real engine datasets (Merlin, Raptor, Vulcain, etc.)


#This project is open-source and intended for educational and non-commercial use.
