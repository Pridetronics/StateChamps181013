// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc3853.Pridetronics2018.subsystems;

import org.usfirst.frc3853.Pridetronics2018.RobotMap;
import org.usfirst.frc3853.Pridetronics2018.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class Lift extends Subsystem {

  // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

  // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

  // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
  private final SpeedController liftMotor = RobotMap.liftliftMotor;

  // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  private final DigitalInput limitSwitchLift = RobotMap.limitSwitchLift;
  
  @Override
  public void initDefaultCommand() {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  public void periodic() {
    // Put code here to be run every loop

  }

  public void up() {
    ((SpeedController) liftMotor).set(1);
  }
  public void upSpeed(double speed) {
	    ((SpeedController) liftMotor).set(speed);
	  }
  public void stallAtTop() {
    ((SpeedController) liftMotor).set(0.2);
  }

  public void down() {
    ((SpeedController) liftMotor).set(-.55);
  }

  public void stop() {
    ((SpeedController) liftMotor).set(0);
  }

  public boolean limitSwitchOpen() {
    return !limitSwitchLift.get();
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

}