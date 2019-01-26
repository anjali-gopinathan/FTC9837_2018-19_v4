package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.util.List;

/**
 * Created by Anjali on 11/9/2018.
 */
@Disabled
//@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Auto BLUE Depot", group="Pushbot")
public class Auto_BLUE_Depot extends LinearOpMode{
    private static final String TFOD_MODEL_ASSET = "RoverRuckus.tflite";
    private static final String LABEL_GOLD_MINERAL = "Gold Mineral";
    private static final String LABEL_SILVER_MINERAL = "Silver Mineral";

    private static final String VUFORIA_KEY = "AcPpQr7/////AAABmRuQqklau0F7hH15ovElLi8g8xxcFH4hzU6JHV7txfq4WXoLctKsuwc8XqSq/SU10A1VnIUj5HXdhG5Ni8/2X8Z+dWSe4pyn1lwj/Bc7nLV5+6j/8I1wKUrZ6wrjclDvcv+lz/W+TQDnrcLXYOLB8b3/voF9/xd/xTZFi5P2oaA/AOokm2IuadPdTJw1iyEujqs6RJM20C1Kjd9v0FSG07oUlImhPuSV18p/JoP/isRgxQLDxKpGluZbvWZm7yITMciaJ9uPvh7O48UiEzfeOupsFbHIUb0C7DgyzmFTEPwjIuQXbNLZik+IB0upOVabS4Lh572YxBj2rv30Icw99tGVaioIMk2LkoVxI9SH6LdH";

    private VuforiaLocalizer vuforia;

    private TFObjectDetector tfod;

    Hardware9837_gobbler gobbler = new Hardware9837_gobbler();


    public void runOpMode() {
        int moveTime=100;    //miliseconds
        int moveTime2 = 100;
        boolean gold_Left = false;
        boolean gold_Right = false;
        boolean gold_Center = false;
        long turn90deg_ms = 900;

        gobbler.init(hardwareMap);

        waitForStart();
        //Lower
//        gobbler.liftUpMotor.setPower(-1.0);
//        sleep(1000);
//        gobbler.liftUpMotor.setPower(0.0);

        // turn 80 degrees
        gobbler.leftDrive.setPower(1.0);
        gobbler.rightDrive.setPower(-1.0);
        sleep(600);


        // print colors recognized by color sensor
        telemetry.addData("left RGB: (" + gobbler.colorSensorLeft.red() + ", " + gobbler.colorSensorLeft.green() + ", " + gobbler.colorSensorLeft.blue() + ")", 0);
        telemetry.addData("right RGB: (" + gobbler.colorSensorRight.red() + ", " + gobbler.colorSensorRight.green() + ", " + gobbler.colorSensorRight.blue() + ")", 0);

        //go forward
        gobbler.leftDrive.setPower(-1.0);
        gobbler.rightDrive.setPower(-1.0);

        //While left blue is small, keep moving forward.
        boolean leftIsBlue = (gobbler.colorSensorLeft.blue() > 150) && (gobbler.colorSensorLeft.blue()>gobbler.colorSensorLeft.red() && gobbler.colorSensorLeft.blue() > gobbler.colorSensorLeft.green());
        boolean rightIsBlue = (gobbler.colorSensorRight.blue() > 150) && (gobbler.colorSensorRight.blue()>gobbler.colorSensorRight.red() && gobbler.colorSensorRight.blue() > gobbler.colorSensorRight.green());

        while (     !(leftIsBlue || rightIsBlue)  ){   //while both color sensors do not measure blue
            moveTime+=100;
        }
        sleep(moveTime);    //specifies the amt of time to go forward


        if (leftIsBlue){    // if left is on blue, move right until it is also on blue
            gobbler.rightDrive.setPower(-1.0);
            while (!rightIsBlue){
                moveTime2 += 50;
            }
            sleep(moveTime2);
        }
        else if (rightIsBlue){  // if right is on blue, move left until it is also on blue
            gobbler.leftDrive.setPower(-1.0);
            while (!leftIsBlue){
                moveTime2 += 50;
            }
            sleep(moveTime2);
        }




        gobbler.leftDrive.setPower(0.0);
        gobbler.rightDrive.setPower(0.0);
        sleep(200);

        //Now sample:
        initVuforia();

        if (ClassFactory.getInstance().canCreateTFObjectDetector()) {
            initTfod();
        } else {
            telemetry.addData("Sorry!", "This device is not compatible with TFOD");
        }

//        /** Wait for the game to begin */
//        telemetry.addData(">", "Press Play to start tracking");
//        telemetry.update();

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
                                    gold_Left = true;
                                    telemetry.addData("Gold Mineral Position", "Left");
                                } else if (goldMineralX > silverMineral1X && goldMineralX > silverMineral2X) {
                                    gold_Right = true;
                                    telemetry.addData("Gold Mineral Position", "Right");
                                } else {
                                    gold_Center = true;
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


        if (gold_Left){//move robot to its right

        }
        else if (gold_Right){//move robot to its left
            //turn backwards left
            gobbler.rightDrive.setPower(-1.0);
            gobbler.leftDrive.setPower(1.0);
            sleep(100);

            //move backwards
            gobbler.rightDrive.setPower(-1.0);
            gobbler.leftDrive.setPower(-1.0);
            sleep(500);

            //turn backwards right
            gobbler.rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT); //allow right drive wheels to spin freely
            gobbler.leftDrive.setPower(-1.0);
            sleep(300);
        }
        else {  // default center

        }





    }
    private void initVuforia() {
        /*
         * Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
         */
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;

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
