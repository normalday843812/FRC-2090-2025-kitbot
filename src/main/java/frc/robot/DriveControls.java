package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class DriveControls {
    private final Joystick leftStick = new Joystick(0);
    private final Joystick rightStick = new Joystick(1);
    
    public final JoystickButton zeroGyro = new JoystickButton(leftStick, 1);
    
    public double getLeftDrive() { return -leftStick.getY(); }
    public double getRightDrive() { return -rightStick.getY(); }
}