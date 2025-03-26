# Rezenzo Airlines 

## Description
The Rezenzo Airlines window application is developed using Java Swing components. It provides graphical user interface (GUI) for adding, searching
and displaying passenger information. Also includes implementation of object-oriented programming principles through classes, inheritance and exception handling.
<br>
## Overview
![image alt](https://github.com/Amri174/Airlines-GUI/blob/main/assets/Overview.PNG?raw=true)
<br><br>
## Functionalities
+  Add Passenger to recieve details such as name, ID, boarding location and destination. Validates input and stores values in ArrayList for dynamic management.
+  Search Passenger allows user to search for a specific passenger detail using their passenger ID. Dsplays message whether the passenger is found or not.
+  Display Passengers shows all stored passenger records in a sorted order(by name).
+  Exception Handling using Custom exception (PassengerNotFoundException) for  handling during invalid search operations.
+  User-Friendly GUI Interactive Buttons, Text fields, Labels and Text area. Dynamic visibility by toggling components based on user actions.

## Class Structure
+  Airlines Class: Represents individual passengers with attributes passenger_name, passenger_id, source and destination
+  PassengerNameComparator Class: Defines sorting logic based on the passenger's name.
+  PassengerNotFoundException Class: Handles errors when searching for non-existent passengers.
+  AirlinesManagement Class: Manages all operations such as adding, searching, and displaying passengers.
+  AirlinesGUI Class: Implements the GUI using Java Swing components like Buttons (JButton), Labels (JLabel), Text fields (JTextField) and Text area (JTextArea)

### 
![image alt](https://github.com/Amri174/Airlines-GUI/blob/main/assets/Screenshot1.PNG?raw=true)
### 
<img height="300" width="300" src="https://github.com/Amri174/Airlines-GUI/blob/main/assets/addp.PNG" /> <img height="300" width="300" src="https://github.com/Amri174/Airlines-GUI/blob/main/assets/search.PNG" /> <img height="300" width="300" src="https://github.com/Amri174/Airlines-GUI/blob/main/assets/display.PNG" />


