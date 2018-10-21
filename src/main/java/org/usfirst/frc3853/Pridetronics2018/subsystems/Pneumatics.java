
package org.usfirst.frc3853.Pridetronics2018.subsystems;

import org.usfirst.frc3853.Pridetronics2018.Robot;
import org.usfirst.frc3853.Pridetronics2018.RobotMap;
import org.usfirst.frc3853.Pridetronics2018.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 *
 */
public class Pneumatics extends Subsystem {

  private final DoubleSolenoid doubleSolenoid1 = RobotMap.pneumaticsDoubleSolenoid1;
  private final DoubleSolenoid doubleSolenoid2 = RobotMap.pneumaticsDoubleSolenoid2;

  public Pneumatics() {

    // default state is off
    RobotMap.pneumaticsDoubleSolenoid1.set(Value.kOff);
    RobotMap.pneumaticsDoubleSolenoid2.set(Value.kOff);
  }

  @Override
  public void initDefaultCommand() {

    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  public void periodic() {
    // Put code here to be run every loop

  }

  public void brakeOn() {
    doubleSolenoid1.set(Value.kForward);
  }

  public void brakeOff() {
    doubleSolenoid1.set(Value.kReverse);
  }

  public void brakeIdle() {
    doubleSolenoid1.set(Value.kOff);
  }

  public void pneuOpen() {
    doubleSolenoid2.set(Value.kForward);

  }

  public void pneuClose() {
    doubleSolenoid2.set(Value.kReverse);
  }

  public void pneuIdle() {
    doubleSolenoid2.set(Value.kOff);
  }
  /*
   * public boolean isGrabbing() { boolean isGrabbing = doubleSolenoid1.get() ==
   * Value.kForward; return doubleSolenoid1; }
   */

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

}
