
package org.usfirst.frc3853.Pridetronics2018.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc3853.Pridetronics2018.Robot;
import org.usfirst.frc3853.Pridetronics2018.RobotMap;
import org.usfirst.frc3853.Pridetronics2018.subsystems.Drive;

import edu.wpi.first.wpilibj.Encoder;

/**
 *
 */
public class DriveForwardDistanceDelay extends Command {

  private double m_speed;
  private double m_distance;
  private boolean atScale;
  private double startTime;
  private double autoStart;

  private int i;

  public DriveForwardDistanceDelay(double speed, double distance) {
    atScale = false;
    startTime = 0;

    m_speed = speed;
    m_distance = distance;

    requires(Robot.drive);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    autoStart = edu.wpi.first.wpilibj.Timer.getFPGATimestamp();
    Robot.drive.getRightEncoder().reset();
    Robot.drive.getLeftEncoder().reset();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double currentDist = (Robot.drive.getLeftEncoder().getDistance() + Robot.drive.getRightEncoder().getDistance()) / 2;

    if (currentDist < 200) {
      Robot.drive.driveForward(m_speed);
    } else if (currentDist < 245) {
      Robot.drive.driveForward(m_speed / 1.5);
    } else if (!atScale) {
      atScale = true;
      startTime = edu.wpi.first.wpilibj.Timer.getFPGATimestamp();
      Robot.drive.driveForward(0);
    } else if (edu.wpi.first.wpilibj.Timer.getFPGATimestamp() - startTime > 3.25) {
      Robot.claw.release();
      Robot.pneumatics.pneuClose();
    } else if (edu.wpi.first.wpilibj.Timer.getFPGATimestamp() - startTime > 3) {
      Robot.claw.release();
    } else if (edu.wpi.first.wpilibj.Timer.getFPGATimestamp() - startTime > 0.5) {
      Robot.drive.driveForward(0);
      Robot.lift.up();
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {

    /*
     * double leftDistance = Robot.drive.getLeftEncoder().getDistance(); double
     * rightDistance = Robot.drive.getRightEncoder().getDistance();
     * 
     * SmartDashboard.putNumber("LeftEncoder", leftDistance);
     * 
     * SmartDashboard.putNumber("RightEncoder", rightDistance);
     * 
     * double averageDistance = (leftDistance + rightDistance) / 2;
     * 
     * if (averageDistance >= m_distance) { return true; }
     */
    if (edu.wpi.first.wpilibj.Timer.getFPGATimestamp() - autoStart > 14) {
      return true;
    }
    return false;

  }

  // Called once after isFinished returns true
  @Override
  protected void end() {

    Robot.drive.driveForward(0);
    Robot.claw.stop();

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
