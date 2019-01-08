package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Anjali on 11/9/2018.
 */
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Auto color sensor test BLUE", group="Pushbot")
public class Auto_TestingColorSensorTape_BLUE extends LinearOpMode{
    Hardware9837_gobbler gobbler = new Hardware9837_gobbler();


    public void runOpMode() {
        int moveTime=100;    //miliseconds

        gobbler.init(hardwareMap);

        waitForStart();
        //Lower

        gobbler.liftUpMotor.setPower(-1.0);
        sleep(1000);
        // turn 80 degrees
        gobbler.leftMotor.setPower(1.0);
        gobbler.rightMotor.setPower(-1.0);
        sleep(600);
        // while loop



        telemetry.addData("left RGB: (" + gobbler.colorSensorLeft.red() + ", " + gobbler.colorSensorLeft.green() + ", " + gobbler.colorSensorLeft.blue() + ")", 0);
        telemetry.addData("right RGB: (" + gobbler.colorSensorRight.red() + ", " + gobbler.colorSensorRight.green() + ", " + gobbler.colorSensorRight.blue() + ")", 0);

        gobbler.leftMotor.setPower(1.0);
        gobbler.rightMotor.setPower(1.0);

        //While left blue is small, keep moving forward.
        boolean leftOnBlue = (gobbler.colorSensorLeft.blue() > 150) && (gobbler.colorSensorLeft.blue()>gobbler.colorSensorLeft.red() && gobbler.colorSensorLeft.blue() > gobbler.colorSensorLeft.green());
        boolean rightOnBlue = (gobbler.colorSensorRight.blue() > 150) && (gobbler.colorSensorRight.blue()>gobbler.colorSensorRight.red() && gobbler.colorSensorRight.blue() > gobbler.colorSensorRight.green());
        while (     !leftOnBlue && !rightOnBlue){   //while both color sensors do not measure blue
            moveTime+=100;
        }
        sleep(moveTime);



        gobbler.leftMotor.setPower(0.0);
        gobbler.rightMotor.setPower(0.0);
        sleep(1000);
    }


}
