package frc.robot;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class holds configurations for the Operator Interface (so joysticks/controllers)
 */
public class OI {
    
    /** Driver Station ports controllers are attached to */
    private static class Ports {
        /** Left driving joystick */
        private static final int LEFT_STICK = 0;
        /** Right driving joystick */
        private static final int RIGHT_STICK = 1;
        /** Driving controller */
        private static final int DRIVER_CONTROLLER = 2;
        
        /** Operator controller */
        private static final int OPERATOR_CONTROLLER = 3;
    }

    /** Buttons on the driver sticks/controller */
    private static class DriverButtons {
        
    }

    /** Buttons on the operator controller */
    private static class OperatorButtons {
        /** Button used as example */
        private static final Button EXAMPLE = XboxController.Button.kA;

        private static final int INTAKE_TRIGGER = XboxController.Axis.kRightTrigger.value;
        private static final int OUTTAKE_TRIGGER = XboxController.Axis.kLeftTrigger.value;

    }

    // This contains objects for both joystick and controller driving
    // You will uncomment code below to select the drive type you want

    // The sticks/controllers are kept private so that if we want to switch them later, this is the only place needing changes
    // Use buttons and DoubleSuppliers to expose any inputs you want elsewhere

    /** Joystick used to control left side of drivetrain */
    private static final Joystick leftJoystick = new Joystick(Ports.LEFT_STICK);
    /** Joystick used to control right side of drivetrain */
    private static final Joystick rightJoystick = new Joystick(Ports.RIGHT_STICK);
    /** Controller used to control drivetrain */
    private static final XboxController driverController = new XboxController(Ports.DRIVER_CONTROLLER);

    /** Controller used by operator */
    private static final XboxController operatorController = new XboxController(Ports.OPERATOR_CONTROLLER);

    /** Button used as example */
    public static final JoystickButton exampleButton = new JoystickButton(operatorController, OperatorButtons.EXAMPLE.value);

    // Use 0.2 as a deadzone?
    public static final Trigger intakeTrigger = new Trigger(() -> operatorController.getRawAxis(OperatorButtons.INTAKE_TRIGGER) >= 0.2);
    public static final Trigger outtakeTrigger = new Trigger(() -> operatorController.getRawAxis(OperatorButtons.OUTTAKE_TRIGGER) >= 0.2);

    // Suppliers for drive inputs

    /**
     * Callback function used to supply left side drive input
     * A supplier is used so that changing between joystick and controller only changes this function
     */
    public static DoubleSupplier leftDriveSupplier = () -> {
        double raw = 0;
        // TODO: Uncomment control type you prefer
        raw = leftJoystick.getY();
        // raw = driverController.getLeftY();
        return processDriveInput(raw);
    };

    
    /**
     * Callback function used to supply left side drive input
     * A supplier is used so that changing between joystick and controller only changes this function
     */
    public static DoubleSupplier rightDriveSupplier = () -> {
        double raw = 0;
        // TODO: Uncomment control type you prefer
        raw = rightJoystick.getY();
        // raw = driverController.getRightY();
        return processDriveInput(raw);
    };

    /**
     * Function to compute drive values from raw inputs
     * Can be used to apply deadzone, scaling, nonlinearity, etc.
     * @param raw Raw joystick input
     * @return Input to feed to drivetrain
     */
    private static double processDriveInput(double raw){
        // TODO: Configure input processing to suit your liking
        // if(Math.abs(raw) < [DEADZONE]) raw = 0;
        // raw = Math.pow(raw, [EXPONENT]);
        // raw *= [INPUT_SCALING];
        return raw;
    }


    public static DoubleSupplier intakeTriggerSupplier = () -> {
        return operatorController.getRawAxis(OperatorButtons.INTAKE_TRIGGER);
    };

    public static DoubleSupplier outtakeTriggerSupplier = () -> {
        System.out.println("test");
        return operatorController.getRawAxis(OperatorButtons.OUTTAKE_TRIGGER);
    };
}