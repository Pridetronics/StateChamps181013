
package org.usfirst.frc3853.Pridetronics2018.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc3853.Pridetronics2018.Robot;

/**
 *
 */
public class pistonOpen extends Command {

  public pistonOpen() {
    System.out.println("Pistons");

    requires(Robot.pneumatics);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // SmartDashboard.putBoolean("pneuInitialize", true);
    // Robot.pneumatics.pneuOpen();
    setTimeout(1);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    SmartDashboard.putBoolean("pneuInitialize", true);
    Robot.pneumatics.pneuOpen();
    // setTimeout(1);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    // Robot.pneumatics.pneuIdle();
    SmartDashboard.putBoolean("pneuInitialize", false);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
