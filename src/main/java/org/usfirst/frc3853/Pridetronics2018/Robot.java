
package org.usfirst.frc3853.Pridetronics2018;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;

import org.usfirst.frc3853.Pridetronics2018.subsystems.Pneumatics;

//import com.kauailabs.navx.frc.AHRS.SerialDataType;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc3853.Pridetronics2018.commands.*;
import org.usfirst.frc3853.Pridetronics2018.subsystems.*;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.SendableBase;
import edu.wpi.first.wpilibj.command.Command;
import static java.util.Objects.requireNonNull;

//import com.kauailabs.navx.frc.AHRS;
//import com.kauailabs.navx.frc.AHRS.SerialDataType;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {

	// git sha identifier
	// $Id$

	private int mode; // default mode
	private SendableChooser autoCommand;
	Command autonomousCommand;
	SendableChooser autoChooser;
	// SendableChooser<Command> chooser = new SendableChooser<>();

	public static OI oi;
	public static Pneumatics pneumatics;
	private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;

	private static final int one = 1;
	private static final int two = 2;
	private static final int three = 3;
	private static final int four = 1678;
	private static final int five = 118;

	private VisionThread visionThread;
	private double centerX = 0.0;

	private final Object imgLock = new Object();

	public static Drive drive;
	public static Claw claw;
	public static Lift lift;

	public static Climb climb;

	private int station;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {

		RobotMap.init();
		pneumatics = new Pneumatics();
		CameraServer.getInstance().startAutomaticCapture();

		drive = new Drive();
		claw = new Claw();
		lift = new Lift();
		climb = new Climb();

		// OI must be constructed after subsystems. If the OI creates Commands
		// (which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.
		oi = new OI();

		// VISION AYYAYAYAYYAA

		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(IMG_WIDTH, IMG_HEIGHT);

		/*
		 * visionThread = new VisionThread(camera, new GripPipelineTest(), pipeline -> {
		 * if (!pipeline.filterContoursOutput().isEmpty()) { Rect r =
		 * Imgproc.boundingRect(pipeline.filterContoursOutput().get(0)); synchronized
		 * (imgLock) { centerX = r.x + (r.width / 2); } } });
		 */

		SmartDashboard.putString("RobotID", "StateChamps181013");

		// SmartDashboard.putNumber("FieldPosition", 1);

		// RobotMap.pneuCompressor.start();
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Default (do nothing)", "DO_NOTHING");
		autoChooser.addObject("Position 1 Auto", one);
		autoChooser.addObject("Position 2 Auto", two);
		autoChooser.addObject("Position 3 Auto", three);
		autoChooser.addObject("Position 1678 Auto", four);
		autoChooser.addObject("Position 118 Auto", five);
		SmartDashboard.putData("Autonomous mode chooser", autoChooser);
	}

	/**
	 * This function is called when the disabled button is hit. You can use it to
	 * reset subsystems before shutting down.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {

		// station = (int) autoChooser.getSelected();
		// SmartDashboard.putNumber("Station", station);
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {

		// autonomousCommand = new SwitchScoring;
		// autonomousCommand = new SwitchScoring();

		mode = (int) autoChooser.getSelected();
		station = (int) autoChooser.getSelected();
		if (station == 1) {
			SmartDashboard.putNumber("Station", 1);
			// autonomousCommand = new SwitchScoring();
			autonomousCommand = new ScaleScoring();
		} else if (station == 2) {
			SmartDashboard.putNumber("Station", 2);
			autonomousCommand = new Station2Auto();
			// autonomousCommand = new CenterSwitchScoring();
		} else if (station == 3) {
			SmartDashboard.putNumber("Station", 3);
			autonomousCommand = new SwitchScoringRight();
		} else if (station == 1678) {
			SmartDashboard.putNumber("Station", 1678);
			autonomousCommand = new SwitchScoring118();
		} else if (station == 118) {
			SmartDashboard.putNumber("Station", 118);
			autonomousCommand = new SwitchScoring118();
		}

		// String position = DriverStation.getInstance().getGameSpecificMessage();
		// int station = DriverStation.getInstance().getLocation();
		// if (position.length() > 0) {
		// if (station == 1) {
		/*
		 * autonomousCommand = new Station1Auto(position, station); } else if (station
		 * == 2) { autonomousCommand = new Station2Auto(position, station); } else if
		 * (station == 3) { autonomousCommand = new Station3Auto(position, station); }
		 * else { autonomousCommand = null; }
		 */
		// }
		// autonomousCommand = new DriveForwardDistance(.6 , 200);
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("RightEncoder", RobotMap.driverightDriveEncoder.getDistance());
		SmartDashboard.putNumber("LeftEncoder", RobotMap.driveleftDriveEncoder.getDistance());
		// System.out.println("RightEncoder"+
		// RobotMap.driverightDriveEncoder.getDistance());
		// System.out.println("LeftEncoder"+
		// RobotMap.driveleftDriveEncoder.getDistance());
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {

		// station = (int) autoChooser.getSelected();
		// SmartDashboard.putNumber("Station", station);
		Scheduler.getInstance().run();

		// SmartDashboard.putNumber("Roll", RobotMap.ahrs.getRoll());
		// SmartDashboard.putNumber("Pitch", RobotMap.ahrs.getPitch());
		// SmartDashboard.putBoolean("ismovIng", RobotMap.ahrs.isMoving());
		// SmartDashboard.putBoolean("isrotation", RobotMap.ahrs.isRotating());
		SmartDashboard.putNumber("RightEncoder", RobotMap.driverightDriveEncoder.getDistance());
		SmartDashboard.putNumber("LeftEncoder", RobotMap.driveleftDriveEncoder.getDistance());
	}
}
