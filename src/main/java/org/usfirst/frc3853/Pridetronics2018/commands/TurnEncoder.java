package org.usfirst.frc3853.Pridetronics2018.commands;

import org.usfirst.frc3853.Pridetronics2018.Robot;
import org.usfirst.frc3853.Pridetronics2018.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurnEncoder extends Command {
  private boolean left;

  private double leftDistance;
  private double rightDistance;
  private double leftdist;
  private double rightdist;

  public TurnEncoder(boolean left, double dist) {

    this.left = left;
    this.leftdist = dist;
    this.rightdist = dist;

    requires(Robot.drive);

  }

  protected void initialize() {
    RobotMap.driveleftDriveEncoder.reset();
    RobotMap.driverightDriveEncoder.reset();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (left) {
      RobotMap.driverobotDrive.tankDrive(-.5, .5);
    } else {
      RobotMap.driverobotDrive.tankDrive(.5, -.5);
    }
    System.out.println(RobotMap.driveleftDriveMotor.get());

  }

  // Make this return true when this Command no longer needs to run execute(7)
  @Override
  protected boolean isFinished() {
    // true is left and false is right
    leftDistance = RobotMap.driverightDriveEncoder.getDistance();
    rightDistance = RobotMap.driveleftDriveEncoder.getDistance();
    SmartDashboard.putNumber("leftDistance", leftDistance);
    SmartDashboard.putNumber("rightDistance", rightDistance);
    if (Math.abs(leftDistance) >= leftdist && Math.abs(rightDistance) >= rightdist) {

      return true;
    }

    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    RobotMap.driverobotDrive.stopMotor();

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
