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
public class Turn extends Command {
	private boolean _left;
	private double angle;
	public static double RotateRate;
	private double heading1;
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	public Turn(boolean left, double angle) {

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
		this._left = left;
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
		requires(Robot.drive);

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
		this.angle = angle;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		//RobotMap.ahrs.zeroYaw();
		RotateRate = .6;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if (_left) {
			RobotMap.driverobotDrive.tankDrive(-.6, .6);
		} else {
			RobotMap.driverobotDrive.tankDrive(.6, -.6);
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {

		//heading1 = RobotMap.ahrs.getYaw();
		SmartDashboard.putNumber("CompassHeading", heading1);

		if (Math.abs(heading1) >= angle) {
			SmartDashboard.putNumber("Turn", heading1);

			return true;
		}

		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		RobotMap.driverobotDrive.stopMotor();
		//RobotMap.ahrs.zeroYaw();

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}