package org.firstinspires.ftc.teamcode.testprograms;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


import org.firstinspires.ftc.teamcode.utils.hardware;

@TeleOp
public class Teleop extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException {
        hardware robot = new hardware();

        robot.init(hardwareMap);

        waitForStart();
        robot.Slider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (opModeIsActive()) {
            robot.Left_Bottom.setPower(gamepad1.left_stick_y*0.7);
            robot.Right_Bottom.setPower(gamepad1.right_stick_y*0.7);
            robot.Left_Top.setPower(gamepad1.left_stick_y*0.7);
            robot.Right_Top.setPower(gamepad1.right_stick_y*0.7);

            double countsPerRotationSlide = 537.7;
            int sliderRotations = 0;
            if(gamepad1.a){

                if (sliderRotations>0){
                    robot.Slider.setTargetPosition((int) (robot.Slider.getCurrentPosition() - countsPerRotationSlide));
                    sliderRotations--;
                }
            }else if(gamepad1.x){
                if (sliderRotations<9){
                    robot.Slider.setTargetPosition((int) (robot.Slider.getCurrentPosition() + countsPerRotationSlide));
                    sliderRotations++;
                }
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
