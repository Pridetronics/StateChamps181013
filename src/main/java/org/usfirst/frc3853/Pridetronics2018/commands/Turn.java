
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

	public Turn(boolean left, double angle) {

		this._left = left;

		requires(Robot.drive);

		this.angle = angle;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		// RobotMap.ahrs.zeroYaw();
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

		// heading1 = RobotMap.ahrs.getYaw();
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
		// RobotMap.ahrs.zeroYaw();

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}