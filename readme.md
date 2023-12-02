# 2024 Preseason Codebase

This codebase serves as a starting point for developing your own robot code for the the 2024 Preseaon Challenge.

It contains enough code that with some minor configuration you should be able to get a robot driving out of the box.

Teams will expand upon this base by adding subystems, commands, and buttons.

Teams can modify this code however they like. However, the following constants should not be changed to ensure compatibility with provided hardware:
  - CANIDs - provided constants will be used by the chassis
  - RoboRIO ports - provided ports will be only ones with connections available
  - Controller ports - if driver stations are provided, those ports will be used

# Project Structure

The code has the following structure:

```
src
└── main                                - Robot code folder
    ├── deploy                          - Anything in this folder is deployed to RIO memory
    │   └── example.txt        
    └── java/frc/robot
        ├── commands                    - Folder for commands
        │   ├── instant                 - Folder for commands which run one
        │   │   └── ExampleButtonCommand.java
        │   └── DriveCommand.java
        ├── subsystems                  - Folder for subsystems
        │   └── Drivetrain.java
        ├── Main.java
        ├── OI.java                     - Controller mappings
        ├── Robot.java
        ├── RobotContainer.java         - Subsytem and command initialisation
        └── RobotMap.java               - Hardware mappings
```

# Setup

There are a few things teams will need to get the codebase set up for their use.

## 1. Set team number
As this reposity is designed for general use, the project team number is set to a placeholder. Teams should change this to the number matching their chassis using the `WPILib: Set Team Number` command.

## 2. Select drive input
`OI.java` contains options for both dual joystick and controller driving styles. Teams should uncomment the lines in the `DoubleSupplier` functions corresponding to their preferred input type.

The codebase has been designed so that this can be changed at any time. Teams just need to change which lines are uncommented and move any bound buttons (all in `OI.java`).

## 3. Select sensor choices
Teams can use a variety of sensor configurations by enabling code in `RobotMap.java`. Code is provided for switches or an encoder, and a potentiometer. If teams are unsure which sensor(s) they need, this can be done at any time.

Other sensors can be used, but they are limited to the 2 Ditigal I/O and 1 Analog Input provided.
