package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import java.io.InterruptedIOException;

/**
 * Created by Anjali on 1/9/2019.
 */
@Disabled
//@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Auto color sensor test", group="Pushbot")
public class TestingColorSensorValues extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException{



        Hardware9837_gobbler gobbler = new Hardware9837_gobbler();

        gobbler.init(hardwareMap);
//        if(gobbler.colorSensorLeft.red()== null) {
//            telemetry.addData("left red = null", 0);
//        }

        telemetry.addData("left RGB: ("+gobbler.colorSensorLeft.red()+", "+gobbler.colorSensorLeft.green()+", "+gobbler.colorSensorLeft.blue()+")",0);
        telemetry.addData("right RGB: ("+gobbler.colorSensorRight.red()+", "+gobbler.colorSensorRight.green()+", "+gobbler.colorSensorRight.blue()+")",0);
        telemetry.update();
        sleep(30000);
        //ON GRAY MAT:
        //left  color sensor rgb: (252,307,255), (252,308,255)
        //right color sensor rgb: (252,307,255), (252,308,255)
        //ON BLUE Tape:
        //left  color sensor rgb: (123,289,456), (126,296,468)
        //right color sensor rgb: (123,289,457), (126,296,468)

    }
}
