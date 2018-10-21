//RobotBuilder Version: 2.0

package org.usfirst.frc3853.Pridetronics2018.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc3853.Pridetronics2018.Robot;
import org.usfirst.frc3853.Pridetronics2018.RobotMap;
import org.usfirst.frc3853.Pridetronics2018.subsystems.*;

/**
 *
 */
public class DoItAll extends CommandGroup {
	// public DriverStation.Alliance getAlliance();

	public DoItAll(String position, int station) {
		SmartDashboard.putString("Position", position);

		// addSequential(new DriveForwardE(0.6, 50));
		if (position.length() >= 3) {

			System.out.println(position);
			System.out.println(station);

			if (position.charAt(0) == 'L' & station == 1) {
				// addSequential(new DriveForwardDistance(-0.6, 12));
				SmartDashboard.putString("Hello", "A");
				addSequential(new Turn(false, 88));
				Timer.delay(.25);
				addSequential(new DriveForwardDistance(-1, 12));
				Timer.delay(.25);
				addSequential(new Turn(true, 88));
				Timer.delay(.25);
				addSequential(new DriveForwardDistance(-1, 12));
			}

			else if (position.charAt(0) == 'L' & station == 2) {
				SmartDashboard.putString("Hello", "Bravo");
				addSequential(new DriveForwardDistance(-1, 12));
				Timer.delay(.25);
				addSequential(new Turn(false, 88));
				Timer.delay(.25);
				addSequential(new DriveForwardDistance(-1, 12));

			} else if (position.charAt(0) == 'L' & station == 3) {
				SmartDashboard.putString("Hello", "C");
				addSequential(new DriveForwardDistance(-1, 12));
				Timer.delay(.25);
				addSequential(new Turn(false, 88));
				Timer.delay(.25);
				addSequential(new DriveForwardDistance(-1, 12));
				Timer.delay(.25);
				addSequential(new Turn(true, 88));
				Timer.delay(.25);
				addSequential(new DriveForwardDistance(-1, 12));
			} else if (position.charAt(0) == 'R' & station == 1) {
				// addSequential(new DriveForwardDistance(-0.6, 12));
				SmartDashboard.putString("Hello", "D");
				addSequential(new Turn(true, 58));
				Timer.delay(.25);
				addSequential(new DriveForwardDistance(-1, 12));
				Timer.delay(.25);
				addSequential(new Turn(false, 88));
				Timer.delay(.25);
				addSequential(new DriveForwardDistance(-1, 12));
			} else if (position.charAt(0) == 'R' & station == 2) {
				SmartDashboard.putString("Hello", "E");
				addSequential(new DriveForwardDistance(-1, 12));
				Timer.delay(.25);
				addSequential(new Turn(true, 88));
				Timer.delay(.25);
				addSequential(new DriveForwardDistance(-1, 12));
			} else if (position.charAt(0) == 'R' & station == 3) {
				SmartDashboard.putString("Hello", "F");
				addSequential(new DriveForwardDistance(-1, 12));
				Timer.delay(.25);
				addSequential(new Turn(true, 88));
				Timer.delay(.25);
				addSequential(new DriveForwardDistance(-1, 12));
				Timer.delay(.25);
				addSequential(new Turn(false, 88));
				Timer.delay(.25);
				addSequential(new DriveForwardDistance(-1, 12));

			} else {
				SmartDashboard.putString("Hello", "NO");
			}
		}
	}
}