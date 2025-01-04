package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class DriveControls {
    private final Joystick joystick0 = new Joystick(0);
    private final Joystick joystick1 = new Joystick(1);
    private final Joystick joystick2 = new Joystick(2);

    //TODO: To tune later (driver preference)

    public final JoystickButton fastMode = new JoystickButton(joystick0, 2);
    public final JoystickButton slowMode = new JoystickButton(joystick0, 3);
    public final JoystickButton roboCentric = new JoystickButton(joystick0, 1);
    public final JoystickButton zeroGyro = new JoystickButton(joystick0, 4);

    //Intake binds
    public final JoystickButton intakeDown = new JoystickButton(joystick1, 2);

    public double getTranslation() { return joystick0.getY(); }
    public double getStrafe() { return joystick0.getX(); }
    public double getRotation() { return joystick1.getX(); }
}
