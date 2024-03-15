package frc.team2412.robot;

import static frc.team2412.robot.Subsystems.SubsystemConstants.*;

import frc.team2412.robot.sensors.AprilTagsProcessor;
import frc.team2412.robot.subsystems.DrivebaseSubsystem;
import frc.team2412.robot.subsystems.IntakeSubsystem;
import frc.team2412.robot.subsystems.LEDSubsystem;
import frc.team2412.robot.subsystems.LauncherSubsystem;
import frc.team2412.robot.util.DrivebaseWrapper;

public class Subsystems {
	public static class SubsystemConstants {

		private static final boolean IS_COMP = Robot.getInstance().isCompetition();

		public static final boolean APRILTAGS_ENABLED = false;
		public static final boolean LIMELIGHT_ENABLED = false;
		public static final boolean CLIMB_ENABLED = false;
		public static final boolean LAUNCHER_ENABLED = true;
		public static final boolean INTAKE_ENABLED = true;
		public static final boolean DRIVEBASE_ENABLED = true;
		public static final boolean LED_ENABLED = false;
	}

	public final DrivebaseWrapper drivebaseWrapper;
	public final DrivebaseSubsystem drivebaseSubsystem;
	public final LauncherSubsystem launcherSubsystem;
	public final IntakeSubsystem intakeSubsystem;
	public final LEDSubsystem ledSubsystem;
	public final AprilTagsProcessor apriltagsProcessor;

	public Subsystems() {
		// initialize subsystems here (wow thats wild)
		if (DRIVEBASE_ENABLED) {
			drivebaseSubsystem = new DrivebaseSubsystem();
			drivebaseWrapper = new DrivebaseWrapper(drivebaseSubsystem.getSwerveDrive());
		} else {
			drivebaseSubsystem = null;
			drivebaseWrapper = new DrivebaseWrapper();
		}
		if (APRILTAGS_ENABLED) {
			apriltagsProcessor = new AprilTagsProcessor(drivebaseWrapper);
		} else {
			apriltagsProcessor = null;
		}
		if (LAUNCHER_ENABLED) {
			launcherSubsystem = new LauncherSubsystem();
		} else {
			launcherSubsystem = null;
		}
		if (INTAKE_ENABLED) {
			intakeSubsystem = new IntakeSubsystem();
		} else {
			intakeSubsystem = null;
		}
		if (LED_ENABLED) {
			ledSubsystem = new LEDSubsystem();
		} else {
			ledSubsystem = null;
		}
	}
}
