package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Anjali on 12/9/2018.
 */
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="C Tank Auto: Depot Claim, Crater park", group="Pushbot")
public class HankAuto_DepotClaim_CraterSide extends LinearOpMode{
    HardwareConfigTankTreads tank = new HardwareConfigTankTreads();
    public void runOpMode(){
        long turn135deg_ms = 1350;
        long turn45deg_ms = 435;
        double distance_const = 10.15;
        long a1_cm = 269;
        tank.init(hardwareMap);

        waitForStart();

        //lower
//        tank.liftUpMotor.setPower(-1.0);
//        sleep() //lower: 9 sec
        //raise: 8.5
        //Go forward
        tank.leftDrive.setPower(1.0);
        tank.rightDrive.setPower(1.0);
        sleep(700);

        //pause
        tank.leftDrive.setPower(0.0);
        tank.rightDrive.setPower(0.0);
        sleep(500);

        //turn left
        tank.leftDrive.setPower(-1.0);
        tank.rightDrive.setPower(1.0);
        sleep(900);

        //pause
        tank.leftDrive.setPower(0.0);
        tank.rightDrive.setPower(0.0);
        sleep(500);

        //go forward
        tank.leftDrive.setPower(1.0);
        tank.rightDrive.setPower(1.0);
        sleep(900);

        //pause
        tank.leftDrive.setPower(0.0);
        tank.rightDrive.setPower(0.0);
        sleep(500);

        //turn left 45 deg
        tank.leftDrive.setPower(-1.0);
        tank.rightDrive.setPower(1.0);
        sleep(500);

        //go forward
        tank.leftDrive.setPower(1.0);
        tank.rightDrive.setPower(1.0);
        sleep(4000);

        //pause
        tank.leftDrive.setPower(0.0);
        tank.rightDrive.setPower(0.0);
        sleep(500);

        //Drop off marker
        tank.markerPusher.setPosition(1.0);
        //turn right
        sleep(500);

        //go backward all the way into the crater
        tank.leftDrive.setPower(-1.0);
        tank.rightDrive.setPower(-1.0);
        sleep(6400);

        tank.leftDrive.setPower(0.0);
        tank.rightDrive.setPower(0.0);

    }
}
