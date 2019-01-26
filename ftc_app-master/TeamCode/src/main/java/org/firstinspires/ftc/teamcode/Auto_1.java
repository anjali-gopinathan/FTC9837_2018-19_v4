package org.firstinspires.ftc.teamcode;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.util.List;

/**
 * Created by Anjali on 11/28/2018.
 */

@Disabled
//@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Auto CRATER side don't use", group="Pushbot")
public class Auto_1 extends LinearOpMode{
    Hardware9837_gobbler gobbler = new Hardware9837_gobbler();
    private static final String TFOD_MODEL_ASSET = "RoverRuckus.tflite";
    private static final String LABEL_GOLD_MINERAL = "Gold Mineral";
    private static final String LABEL_SILVER_MINERAL = "Silver Mineral";

    private static final String VUFORIA_KEY = "AcPpQr7/////AAABmRuQqklau0F7hH15ovElLi8g8xxcFH4hzU6JHV7txfq4WXoLctKsuwc8XqSq/SU10A1VnIUj5HXdhG5Ni8/2X8Z+dWSe4pyn1lwj/Bc7nLV5+6j/8I1wKUrZ6wrjclDvcv+lz/W+TQDnrcLXYOLB8b3/voF9/xd/xTZFi5P2oaA/AOokm2IuadPdTJw1iyEujqs6RJM20C1Kjd9v0FSG07oUlImhPuSV18p/JoP/isRgxQLDxKpGluZbvWZm7yITMciaJ9uPvh7O48UiEzfeOupsFbHIUb0C7DgyzmFTEPwjIuQXbNLZik+IB0upOVabS4Lh572YxBj2rv30Icw99tGVaioIMk2LkoVxI9SH6LdH";
    VuforiaLocalizer.Parameters parameters;



    /**
     * {@link #vuforia} is the variable we will use to store our instance of the Vuforia
     * localization engine.
     */
    private VuforiaLocalizer vuforia;

    /**
     * {@link #tfod} is the variable we will use to store our instance of the Tensor Flow Object
     * Detection engine.
     */
    private TFObjectDetector tfod;

    @Override
    public void runOpMode() {
        long moveTime1=100;    //miliseconds
        double distance_const = 10.15;
        long x1_cm = 45;
        long x2_cm = 100;
        long x3_cm = 186;

        long turn90deg_ms = 900;
        long turn45deg_ms = 450;
        gobbler.init(hardwareMap);

        waitForStart();

        while (opModeIsActive() && gobbler.leftDrive.isBusy())
        {
//            telemetry.addData("left RGB", "("+gobbler.colorSensorLeft.red() + ", " + gobbler.colorSensorLeft.green() + ", " + gobbler.colorSensorLeft.blue() + ")");
//            telemetry.addData("right RGB", "("+gobbler.colorSensorRight.red() + ", " + gobbler.colorSensorRight.green() + ", " + gobbler.colorSensorRight.blue() + ")");

            telemetry.update();
            idle();
        }

        //Go forward
        gobbler.leftDrive.setPower(1.0);
        gobbler.rightDrive.setPower(1.0);

        //While left blue is small, keep moving forward.
//        while (     (gobbler.colorSensorLeft.blue() < 150) &&
//                        (gobbler.colorSensorLeft.blue() < gobbler.colorSensorLeft.red()) &&
//                        (gobbler.colorSensorLeft.blue() > gobbler.colorSensorLeft.green())
//                &&  (gobbler.colorSensorRight.blue() < 150) &&
//                        (gobbler.colorSensorRight.blue() < gobbler.colorSensorRight.red()) &&
//                        (gobbler.colorSensorRight.blue() < gobbler.colorSensorRight.green())
//              ){
//         //If the blue value is low on both sensors
//        moveTime1+=100;
//        }
        sleep(moveTime1);
        gobbler.leftDrive.setPower(0.0);
        gobbler.rightDrive.setPower(0.0);

        while (opModeIsActive() && gobbler.leftDrive.isBusy())
        {
            telemetry.addData("encoder-fwd", gobbler.leftDrive.getCurrentPosition() + "  busy=" + gobbler.leftDrive.isBusy());
            telemetry.update();
            idle();
        }
/*
//Hard coding:
    //using 2 m : 2.03 s, 10.15*x cm = ms
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

        //45 degree turn:
        gobbler.leftDrive.setPower(0.0);
        gobbler.rightDrive.setPower(-1.0);
        sleep(turn45deg_ms);

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
*/


        // The TFObjectDetector uses the camera frames from the VuforiaLocalizer, so we create that
        initVuforia();




        if (ClassFactory.getInstance().canCreateTFObjectDetector()) {
            initTfod();
        } else {
            telemetry.addData("Sorry!", "This device is not compatible with TFOD");
        }

        /** Wait for the game to begin */
        telemetry.addData(">", "Press Play to start tracking");
        telemetry.update();
        waitForStart();

        if (opModeIsActive()) {
            /** Activate Tensor Flow Object Detection. */
            if (tfod != null) {
                tfod.activate();
            }

            while (opModeIsActive()) {
                if (tfod != null) {
                    // getUpdatedRecognitions() will return null if no new information is available since
                    // the last time that call was made.
                    List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
                    if (updatedRecognitions != null) {
                        telemetry.addData("# Object Detected", updatedRecognitions.size());
                        if (updatedRecognitions.size() == 3) {
                            int goldMineralX = -1;
                            int silverMineral1X = -1;
                            int silverMineral2X = -1;
                            for (Recognition recognition : updatedRecognitions) {
                                float x = recognition.getTop();
                                float y = recognition.getImageWidth() - recognition.getRight();
                                float width = recognition.getHeight();
                                float height = recognition.getWidth();
                                telemetry.addData("x", x);
                                telemetry.addData("y", y);
                                telemetry.addData("width", width);
                                telemetry.addData("height", height);

                                if (recognition.getLabel().equals(LABEL_GOLD_MINERAL)) {
                                    goldMineralX = (int) recognition.getLeft();
                                } else if (silverMineral1X == -1) {
                                    silverMineral1X = (int) recognition.getLeft();
                                } else {
                                    silverMineral2X = (int) recognition.getLeft();
                                }
                            }
                            if (goldMineralX != -1 && silverMineral1X != -1 && silverMineral2X != -1) {
                                if (goldMineralX < silverMineral1X && goldMineralX < silverMineral2X) {
                                    telemetry.addData("Gold Mineral Position", "Left");
                                } else if (goldMineralX > silverMineral1X && goldMineralX > silverMineral2X) {
                                    telemetry.addData("Gold Mineral Position", "Right");
                                } else {
                                    telemetry.addData("Gold Mineral Position", "Center");
                                }
                            }
                        }
                        telemetry.update();
                    }
                }
            }
        }

        if (tfod != null) {
            tfod.shutdown();
        }
    }

    /**
     * Initialize the Vuforia localization engine.
     */
    private void initVuforia() {
        /*
         * Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
         */
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.FRONT;
        parameters = new VuforiaLocalizer.Parameters(R.id.cameraMonitorViewId); //Put "R.id.cameraMonitorViewId" in the parameter of the Parameters method if you want camera to display on RC phone


        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        // Loading trackables is not necessary for the Tensor Flow Object Detection engine.
    }
    /**
     * Initialize the Tensor Flow Object Detection engine.
     */
    private void initTfod() {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_GOLD_MINERAL, LABEL_SILVER_MINERAL);
    }

}