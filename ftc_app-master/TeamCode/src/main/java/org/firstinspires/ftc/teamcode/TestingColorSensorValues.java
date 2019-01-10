package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Anjali on 1/9/2019.
 */
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Auto color sensor test", group="Pushbot")
public class TestingColorSensorValues extends LinearOpMode {
    public void runOpMode() {


        Hardware9837_gobbler gobbler = new Hardware9837_gobbler();

//        if(gobbler.colorSensorLeft.red().equals(null)) {
//            telemetry.addData("left red = null", 0);
//        }

            telemetry.addData("left RGB: ("+gobbler.colorSensorLeft.red()+", "+gobbler.colorSensorLeft.green()+", "+gobbler.colorSensorLeft.blue()+")",0);
        telemetry.addData("right RGB: ("+gobbler.colorSensorRight.red()+", "+gobbler.colorSensorRight.green()+", "+gobbler.colorSensorRight.blue()+")",0);


        //left color sensor rgb: (,,)
        //right color sensor rgb: (,,)
    }
}
