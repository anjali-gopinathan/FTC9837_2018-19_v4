package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.util.List;

/**
 * Created by Anjali on 12/9/2018.
 */
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Auto DEPOT side", group="Pushbot")
public class Auto_DepotSide extends LinearOpMode{
    Hardware9837_gobbler gobbler = new Hardware9837_gobbler();
    public void runOpMode(){
        double distance_const = 10.15;
        long x1_cm = 45;
        long x2_cm = 130;
        long x3_cm = 186;

        long turn90deg_ms = 900;
        long turn135deg_ms = 1350;
        gobbler.init(hardwareMap);

        waitForStart();


        //Go forward x1 cm
        gobbler.leftDrive.setPower(-1.0);
        gobbler.rightDrive.setPower(-1.0);
        sleep((long)(distance_const * x1_cm));


        //pause for some time
        gobbler.leftDrive.setPower(0.0);
        gobbler.rightDrive.setPower(0.0);
        sleep(1000);


        //90 degree turn (to the left):
        gobbler.leftDrive.setPower(0.0);
        gobbler.rightDrive.setPower(-1.0);
        sleep(turn90deg_ms);

        //pause for some time
        gobbler.leftDrive.setPower(0.0);
        gobbler.rightDrive.setPower(0.0);
        sleep(1000);

        //go forward x2 cm
        gobbler.leftDrive.setPower(-1.0);
        gobbler.rightDrive.setPower(-1.0);
        sleep((long)(distance_const * x2_cm));

        //pause for some time
        gobbler.leftDrive.setPower(0.0);
        gobbler.rightDrive.setPower(0.0);
        sleep(1000);

        //135 degree turn:
        gobbler.leftDrive.setPower(-1.0);
        gobbler.rightDrive.setPower(0.0);
        sleep(turn90deg_ms/2);

        //pause for some time
        gobbler.leftDrive.setPower(0.0);
        gobbler.rightDrive.setPower(0.0);
        sleep(1000);

        //go forward for x3 cm
        gobbler.leftDrive.setPower(-1.0);
        gobbler.rightDrive.setPower(-1.0);
        sleep((long)(distance_const * x3_cm));

        //stop
        gobbler.leftDrive.setPower(0.0);
        gobbler.rightDrive.setPower(0.0);
        //push off marker in depot
        gobbler.markerPusher.setPosition(0.2);//with orig position at 0.75, setting pos to 0.2 should push off the marker

        gobbler.leftDrive.setPower(0.0);
        gobbler.rightDrive.setPower(0.0);

    }
}
