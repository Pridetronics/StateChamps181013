
package org.usfirst.frc3853.Pridetronics2018.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3853.Pridetronics2018.Robot;

/**
 *
 */
public class DriveForward1Second extends Command {

  final private double DRIVE_SPEED = 1;

  public DriveForward1Second() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);

    requires(Robot.drive);

    this.setTimeout(0.6);
    this.setInterruptible(true);
    this.setRunWhenDisabled(false);
  }

  // Called just before this Command runs the first time
  protected void initialize() {

    Robot.pneumatics.pneuOpen();
  }

  // Called repeatedly when this Command is scheduled to run
  protected void execute() {

    Robot.drive.driveForward(DRIVE_SPEED);
  }

  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  protected void end() {
    Robot.drive.stop();

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
    end();
  }
}
