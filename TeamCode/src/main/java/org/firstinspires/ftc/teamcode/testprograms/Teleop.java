package org.firstinspires.ftc.teamcode.testprograms;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


import org.firstinspires.ftc.teamcode.utils.hardware;

@TeleOp(name= "Competion teleop")
public class Teleop extends LinearOpMode {

    Integer sliderRotations = 0;
    final double countsPerRotationSlide = 537.7;
    @Override
    public void runOpMode() throws InterruptedException {
        hardware robot = new hardware();

        robot.init(hardwareMap);
//        robot.Slider.setPower(0.5);
//        sleep(650);
//        robot.Slider.setPower(0.1);

        waitForStart();

        while (opModeIsActive()) {
            robot.Left_Bottom.setPower(gamepad1.left_stick_y*0.7);
            robot.Right_Bottom.setPower(gamepad1.right_stick_y*0.7);
            robot.Left_Top.setPower(gamepad1.left_stick_y*0.7);
            robot.Right_Top.setPower(gamepad1.right_stick_y*0.7);

            telemetry.addData("Slider Rotations %d", sliderRotations);
            telemetry.update();

            if(gamepad1.a){
                robot.Slider.setPower(-0.7);
            }else if(gamepad1.x){
                robot.Slider.setPower(0.9);
            }else{
                robot.Slider.setPower(0.1);
            }

            //This is the Strafe
            while (gamepad1.right_stick_x == 1) {

                robot.Right_Top.setPower(.6);
                robot.Right_Bottom.setPower(-.6);
                robot.Left_Bottom.setPower(.6);
                robot.Left_Top.setPower(-.6);
            }

            //This is the Strafe
            while (gamepad1.left_stick_x == -1) {
                robot.Right_Top.setPower(-.6);
                robot.Right_Bottom.setPower(.6);
                robot.Left_Bottom.setPower(-.6);
                robot.Left_Top.setPower(.6);
            }


            if(gamepad1.right_bumper){
                robot.Intake1.setPower(-0.8);
                robot.Intake2.setPower(0.8);
            }else if(gamepad1.left_bumper){
                robot.Intake1.setPower(0.8);
                robot.Intake2.setPower(-0.8);
            }else{
                robot.Intake1.setPower(0);
                robot.Intake2.setPower(0);
            }

        }
    }
}
