package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Anjali on 1/12/2019.
 */
@Disabled
//@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Auto plow thru Depot side", group="Pushbot")
public class Auto_plowThruSampling extends LinearOpMode {
    Hardware9837_gobbler gobbler = new Hardware9837_gobbler();

    public void runOpMode() {
        double distance_const = 10.15;
        long x1_cm = 45;
        long x2_cm = 130;
        long x3_cm = 186;

        long turn90deg_ms = 900;
        long turn135deg_ms = 1350;
        gobbler.init(hardwareMap);

        waitForStart();


        //Go forward x1 cm
        gobbler.leftDrive.setPower(1.0);
        gobbler.rightDrive.setPower(1.0);
        sleep(6000);


        //pause for some time
        gobbler.leftDrive.setPower(0.0);
        gobbler.rightDrive.setPower(0.0);

        //push off marker in depot
        gobbler.markerPusher.setPosition(0.2);//with orig position at 0.75, setting pos to 0.2 should push off the marker

        gobbler.leftDrive.setPower(0.0);
        gobbler.rightDrive.setPower(0.0);

    }
}