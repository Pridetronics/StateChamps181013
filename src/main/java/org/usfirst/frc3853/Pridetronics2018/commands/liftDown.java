
package org.usfirst.frc3853.Pridetronics2018.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3853.Pridetronics2018.Robot;

/**
 *
 */
public class liftDown extends Command {

  public liftDown() {

    requires(Robot.lift);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.lift.down();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.lift.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
