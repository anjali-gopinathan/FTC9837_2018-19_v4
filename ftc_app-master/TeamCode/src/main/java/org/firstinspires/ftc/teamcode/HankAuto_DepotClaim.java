package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Anjali on 12/9/2018.
 */
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Auto: Tank Depot Claim", group="Pushbot")
public class HankAuto_DepotClaim extends LinearOpMode{
    HardwareConfigTankTreads tank = new HardwareConfigTankTreads();
    public void runOpMode(){
        long turn135deg_ms = 1350;
        long turn45deg_ms = 435;
        double distance_const = 10.15;
        long a1_cm = 269;
        tank.init(hardwareMap);

        waitForStart();

        //Go forward
        tank.leftDrive.setPower(1.0);
        tank.rightDrive.setPower(1.0);
        sleep(2900);

        tank.leftDrive.setPower(0.0);
        tank.rightDrive.setPower(0.0);
        sleep(500);
        //Drop off marker
//        tank.markerPusher.setPosition(tank.markerPusher.getPosition() - .5);
        //turn right
        tank.leftDrive.setPower(-1.0);
        tank.rightDrive.setPower(1.0);
        sleep(turn45deg_ms);

        //pause
        tank.leftDrive.setPower(0.0);
        tank.rightDrive.setPower(0.0);
        sleep(500);
        //go backward for a1 cm
        tank.leftDrive.setPower(-1.0);
        tank.rightDrive.setPower(-1.0);
        sleep(6400);
        //stop
        tank.leftDrive.setPower(0.0);
        tank.rightDrive.setPower(0.0);

    }
}
