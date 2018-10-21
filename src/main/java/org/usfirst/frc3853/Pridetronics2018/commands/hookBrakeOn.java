
package org.usfirst.frc3853.Pridetronics2018.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc3853.Pridetronics2018.Robot;

/**
 *
 */
public class hookBrakeOn extends Command {

  public hookBrakeOn() {

    requires(Robot.pneumatics);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // SmartDashboard.putBoolean("pneuInitialize", true);
    // Robot.pneumatics.pneuClose();
    // setTimeout(1);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    SmartDashboard.putBoolean("brakeInitialize", true);
    Robot.pneumatics.brakeOn();
    setTimeout(1);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.pneumatics.brakeIdle();
    SmartDashboard.putBoolean("brakeInitialize", false);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
