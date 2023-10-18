/*
 *	  Copyright (C) 2016  John H. Gaby
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, version 3 of the License.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *    
 *    Contact: robotics@gabysoft.com
 */

package robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import robot.subsystems.ShooterSubsystem;
import robotCore.Logger;

/**
 *
 */
public class CmdShooter extends CommandBase {
    private final ShooterSubsystem m_subsystem;
    int m_target = 1200;
    private double power;

    public CmdShooter(ShooterSubsystem subsystem, double power) {
        this.power = power;
        m_subsystem = subsystem;

        // Use requires() here to declare subsystem dependencies
        addRequirements(m_subsystem);
    }

    // Called just before this Command runs the first time
    @Override
    public void initialize() {

        m_subsystem.setPower(power);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute() {

        int speed = m_subsystem.m_encoder.getSpeed();

        Logger.log("TestShooterCommand", 1, String.format("Speed = %d", speed));
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    public boolean isFinished() {

        return (false);
    }

    // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {

        m_subsystem.setPower(0);
    }
}
