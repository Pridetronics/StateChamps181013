
package org.usfirst.frc3853.Pridetronics2018.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc3853.Pridetronics2018.Robot;
import org.usfirst.frc3853.Pridetronics2018.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;

/**
 *
 */
public class driveTeleop extends Command {
  private Joystick stick;

  public driveTeleop() {

    requires(Robot.drive);

    this.setInterruptible(true);
    this.setRunWhenDisabled(false);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    stick = Robot.oi.getgamepad1();

    stick.setAxisChannel(AxisType.kX, 0);
    stick.setAxisChannel(AxisType.kY, 1);

    // RobotMap.pneuCompressor.start();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    stick = Robot.oi.getgamepad1();

    Robot.drive.doTeleop(stick);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {

    end();

  }
}
