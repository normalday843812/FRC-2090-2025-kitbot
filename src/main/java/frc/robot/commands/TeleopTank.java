package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.TankDrive;

public class TeleopTankDrive extends Command {
    private final TankDrive drive;
    private final DoubleSupplier leftSupplier;
    private final DoubleSupplier rightSupplier;
    
    public TeleopTankDrive(TankDrive drive, DoubleSupplier leftSupplier, DoubleSupplier rightSupplier) {
        this.drive = drive;
        this.leftSupplier = leftSupplier;
        this.rightSupplier = rightSupplier;
        addRequirements(drive);
    }
    @Override
    public void execute() {
        double leftValue = MathUtil.applyDeadband(leftSupplier.getAsDouble(), Constants.stickDeadband);
        double rightValue = MathUtil.applyDeadband(rightSupplier.getAsDouble(), Constants.stickDeadband);
        drive.drive(leftValue, rightValue);
    }
    
    @Override
    public void end(boolean interrupted) {
        leftLeadMotor.stopMotor();
        rightLeadMotor.stopMotor();
    }
    
    @Override
    public boolean isFinished() {
        return false;
    }
}