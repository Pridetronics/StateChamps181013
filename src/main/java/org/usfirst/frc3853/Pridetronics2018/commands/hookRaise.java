
package org.usfirst.frc3853.Pridetronics2018.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc3853.Pridetronics2018.Robot;
import org.usfirst.frc3853.Pridetronics2018.RobotMap;

/**
 *
 */
public class hookRaise extends Command {

  public final DigitalInput limitSwitchLift = RobotMap.limitSwitchLift;

  public hookRaise() {

    requires(Robot.climb);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    SmartDashboard.putBoolean("climbInitialize", true);

    // setTimeout(1);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.climb.up();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    /*
     * if (limitSwitchLift.get() == true) { return true; }else { return false; }
     */
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {

    Robot.climb.stop();
    SmartDashboard.putBoolean("climbInitialize", false);

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {

    end();

  }
}
