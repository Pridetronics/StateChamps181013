// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc3853.Pridetronics2018.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc3853.Pridetronics2018.Robot;
import org.usfirst.frc3853.Pridetronics2018.RobotMap;

/**
 *
 */
public class TurnDegrees extends Command {
  private boolean _left;
  private double _angle;
  // public static double RotateRate;
  private double _heading;
  // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

  // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

  // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
  public TurnDegrees(boolean left, double angle) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    requires(Robot.drive);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    this._left = left;
    this._angle = angle;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
    //Robot.ahrs.reset();
    //RobotMap.ahrs.zeroYaw();
    // RotateRate = .6;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
   // _heading = RobotMap.ahrs.getYaw();
    
    SmartDashboard.putNumber("Current Heading", _heading);
    SmartDashboard.putNumber("Current angle", _angle);
    SmartDashboard.putBoolean("Current left", _left);
    
    System.out.println("Execute!");
    
    if (_left) {
      RobotMap.driverobotDrive.arcadeDrive(.6, -.6);
    } else {
      RobotMap.driverobotDrive.arcadeDrive(.6, .6);
    }
    // SmartDashboard.putNumber("CompassHeading", heading1);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() 
  {
   // _heading = RobotMap.ahrs.getYaw();

  
    if (Math.abs(_heading) >= _angle) {
      
      return true;
    }
    
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    RobotMap.driverobotDrive.stopMotor();
    //Robot.ahrs.reset();
    end();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}