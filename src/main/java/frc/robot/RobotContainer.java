package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.commands.TeleopTankDrive;
import frc.robot.subsystems.TankDrive;

public class RobotContainer {
    private final DriveControls driveControls = new DriveControls();
    
    private final TankDrive drive = new TankDrive();
    
    public RobotContainer() {
        drive.setDefaultCommand(
            new TeleopTankDrive(
                drive,
                () -> driveControls.getLeftDrive(),
                () -> driveControls.getRightDrive()
            )
        );
        
        configureButtonBindings();
    }
    
    private void configureButtonBindings() {
        driveControls.zeroGyro.onTrue(new InstantCommand(() -> drive.zeroHeading()));
    }
    
    public Command getAutonomousCommand() {
        return null;
    }
}