// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc3853.Pridetronics2018;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

//import com.kauailabs.navx.frc.AHRS;
//import com.kauailabs.navx.frc.AHRS.SerialDataType;


import edu.wpi.first.wpilibj.Compressor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
  public static SpeedController driveleftDriveMotor;
  public static SpeedController driverightDriveMotor;
  public static DifferentialDrive driverobotDrive;
  public static Encoder driveleftDriveEncoder;
  public static Encoder driverightDriveEncoder;
  public static SpeedController clawintakeMotor;
  public static SpeedController liftliftMotor;

  // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
  // public static Compressor pneuCompressor;

  public static SpeedController climbMotor;
  public static DoubleSolenoid pneumaticsDoubleSolenoid1;
  public static DoubleSolenoid pneumaticsDoubleSolenoid2;

  public static DigitalInput limitSwitchLift;
  //public static AHRS ahrs;
  public static PowerDistributionPanel mPdp;

  public static void init() {
    mPdp = new PowerDistributionPanel();

    //ahrs = new AHRS(SerialPort.Port.kMXP, SerialDataType.kProcessedData, (byte) 200);
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    driveleftDriveMotor = new Spark(1);
    LiveWindow.addActuator("Drive", "leftDriveMotor", (Spark) driveleftDriveMotor);
    driveleftDriveMotor.setInverted(false);
    
    
    driverightDriveMotor = new Spark(0);
    LiveWindow.addActuator("Drive", "rightDriveMotor", (Spark) driverightDriveMotor);
    driverightDriveMotor.setInverted(false);
    
    
    driverobotDrive = new DifferentialDrive(driveleftDriveMotor, driverightDriveMotor);
    LiveWindow.addActuator("Drive", "robotDrive", driverobotDrive);
    driverobotDrive.setSafetyEnabled(true);
    
    
    driverobotDrive.setExpiration(0.1);
    driverobotDrive.setMaxOutput(1.0);

    driveleftDriveEncoder = new Encoder(7, 6, false, EncodingType.k1X);
    LiveWindow.addSensor("Drive", "leftDriveEncoder", driveleftDriveEncoder);
    driveleftDriveEncoder.setDistancePerPulse((6 * Math.PI) / 360);
    driveleftDriveEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
    driveleftDriveEncoder.setReverseDirection(true);
    
    
    driverightDriveEncoder = new Encoder(9, 8, false, EncodingType.k1X);
    LiveWindow.addSensor("Drive", "rightDriveEncoder", driverightDriveEncoder);
    driverightDriveEncoder.setDistancePerPulse((6 * Math.PI) / 360);
    driverightDriveEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
    driverightDriveEncoder.setReverseDirection(false);

    clawintakeMotor = new Spark(3);
    LiveWindow.addActuator("Claw", "intakeMotor", (Spark) clawintakeMotor);
    clawintakeMotor.setInverted(false);

    liftliftMotor = new Spark(2);
    LiveWindow.addActuator("Lift", "liftMotor", (Spark) liftliftMotor);
    liftliftMotor.setInverted(false);

    climbMotor = new Spark(5);
    LiveWindow.addActuator("Climb", "climbMotor", (Spark) climbMotor);
    liftliftMotor.setInverted(false);

    pneumaticsDoubleSolenoid1 = new DoubleSolenoid(1, 0);
    LiveWindow.addActuator("Pneumatics", "Climb Brake Solenoid 1", pneumaticsDoubleSolenoid1);

    pneumaticsDoubleSolenoid2 = new DoubleSolenoid(2, 3);
    LiveWindow.addActuator("Pneumatics", "Claw Solenoid 2", pneumaticsDoubleSolenoid2);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    limitSwitchLift = new DigitalInput(5);

    // pneuCompressor = new Compressor(0);
    // LiveWindow.addActuator("Pneu", "Compressor", pneuCompressor);

    // pneumaticsDoubleSolenoid1 = new DoubleSolenoid(0, 1);
    // LiveWindow.addActuator("Pneu", "ClawSolenoid", pneumaticsDoubleSolenoid1);

  }
}