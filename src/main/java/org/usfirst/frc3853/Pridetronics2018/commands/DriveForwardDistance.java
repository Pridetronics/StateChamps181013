
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
public class DriveForwardDistance extends Command {

	private double m_speed;
	private double m_distance;
	double leftDistance;
	double rightDistance;

	public DriveForwardDistance(double speed, double distance) {

		m_speed = speed;
		m_distance = distance;

		requires(Robot.drive);

		// Encoder leftDriveEncoder = RobotMap.driveleftDriveEncoder;
		// Encoder rightDriveEncoder = RobotMap.driverightDriveEncoder;
		// SmartDashboard.putString( "leftencoder", leftDriveEncoder);

	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {

		Robot.drive.getRightEncoder().reset();
		Robot.drive.getLeftEncoder().reset();
		// RobotMap.ahrs.zeroYaw();
		pleaseStop = false;
	}

	private boolean pleaseStop;

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.drive.tankDrive(m_speed, m_speed);
		/*
		 * leftDistance = Math.abs(RobotMap.driveleftDriveEncoder.getDistance());
		 * rightDistance = Math.abs(RobotMap.driverightDriveEncoder.getDistance()); //
		 * if(leftDistance - rightDistance >= ) { double delta = leftDistance -
		 * rightDistance; double distanceDiff = 0;
		 * 
		 * if (Math.abs(delta) >= 18.0) { pleaseStop = true;
		 * System.out.println("The pleasestop is triggered"); }
		 * 
		 * else if (Math.abs(delta) >= 3.0) { distanceDiff = Math.abs(delta) /
		 * 18.849555; distanceDiff = distanceDiff * java.lang.Math.signum(delta);
		 * 
		 * if (distanceDiff > 0) { SmartDashboard.putNumber("distanceDiff",
		 * distanceDiff); Robot.drive.tankDrive(m_speed + (distanceDiff * .1), m_speed);
		 * } else { SmartDashboard.putNumber("distanceDiff", distanceDiff);
		 * Robot.drive.tankDrive(m_speed, m_speed + (distanceDiff * .1)); } } else {
		 * SmartDashboard.putNumber("straight", m_speed); Robot.drive.tankDrive(m_speed,
		 * m_speed); }
		 */
		// }
		/*
		 * double speedCorrect = 0.0; double check = RobotMap.ahrs.getYaw();
		 * SmartDashboard.putNumber("Check", check); if (Math.abs(check) >= 2.0) {
		 * speedCorrect = Math.abs(check) / 180; speedCorrect = speedCorrect * 0.15;
		 * speedCorrect = speedCorrect * java.lang.Math.signum(check); if (speedCorrect
		 * > 0) { SmartDashboard.putNumber("correct left", speedCorrect);
		 * Robot.drive.tankDrive(m_speed + speedCorrect, m_speed); } else {
		 * SmartDashboard.putNumber("correct right", speedCorrect);
		 * Robot.drive.tankDrive(m_speed, m_speed + speedCorrect); } } else {
		 * SmartDashboard.putNumber("straight", m_speed); Robot.drive.tankDrive(m_speed,
		 * m_speed); }
		 */

	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {

		double leftDistance = Robot.drive.getLeftEncoder().getDistance();
		double rightDistance = Robot.drive.getRightEncoder().getDistance();

		SmartDashboard.putNumber("LeftEncoder", leftDistance);

		SmartDashboard.putNumber("RightEncoder", rightDistance);

		double averageDistance = (Math.abs(leftDistance) + Math.abs(rightDistance)) / 2;

		if (averageDistance >= m_distance || pleaseStop) {
			return true;
		}

		return false;

	}

	// Called once after isFinished returns true
	@Override
	protected void end() {

		Robot.drive.driveForward(0);

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		System.out.println("DriveForwardDistance is being interrupted");
		end();
	}
}
