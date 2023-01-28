package org.firstinspires.ftc.teamcode.competition;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.customutils.hardware;

@TeleOp(name= "Amia's Competition Teleop")
public class TeleopAmia extends LinearOpMode {


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
            robot.Slider.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


            if(gamepad1.a){
                robot.Slider.setPower(-0.7);
            }else if(gamepad1.x){
                robot.Slider.setPower(0.9);
            }else{
                robot.Slider.setPower(0.1);
            }

            //Josephs God Damn Omnidirectional dpad controls
            while (gamepad1.dpad_up && gamepad1.dpad_left) {
                robot.Right_Top.setPower(-.5);
                robot.Left_Bottom.setPower(-.5);
            }

            while (gamepad1.dpad_up && gamepad1.dpad_right) {
                robot.Right_Bottom.setPower(-.5);
                robot.Left_Top.setPower(-.5);
            }

            while (gamepad1.dpad_down && gamepad1.dpad_left) {
                robot.Right_Bottom.setPower(.5);
                robot.Left_Top.setPower(.5);
            }

            while (gamepad1.dpad_down && gamepad1.dpad_right) {
                robot.Right_Top.setPower(.5);
                robot.Left_Bottom.setPower(.5);
            }

            while (gamepad1.dpad_right) {
                gamepad1.rumble(100);
                robot.Right_Top.setPower(.6);
                robot.Right_Bottom.setPower(-.6);
                robot.Left_Bottom.setPower(.6);
                robot.Left_Top.setPower(-.6);
            }


            while (gamepad1.dpad_left) {
                gamepad1.rumble(100);
                robot.Right_Top.setPower(-.6);
                robot.Right_Bottom.setPower(.6);
                robot.Left_Bottom.setPower(-.6);
                robot.Left_Top.setPower(.6);
            }

            while (gamepad1.right_stick_x == 1) {
                gamepad1.rumble(100);
                robot.Right_Top.setPower(.6);
                robot.Right_Bottom.setPower(-.6);
                robot.Left_Bottom.setPower(.6);
                robot.Left_Top.setPower(-.6);
            }


            while (gamepad1.left_stick_x == 1) {
                gamepad1.rumble(100);
                robot.Right_Top.setPower(-.6);
                robot.Right_Bottom.setPower(.6);
                robot.Left_Bottom.setPower(-.6);
                robot.Left_Top.setPower(.6);
            }

            while (gamepad1.dpad_down) {
                robot.Right_Top.setPower(.5);
                robot.Right_Bottom.setPower(.5);
                robot.Left_Bottom.setPower(.5);
                robot.Left_Top.setPower(.5);
            }

            while (gamepad1.dpad_up) {
                robot.Right_Top.setPower(-.5);
                robot.Right_Bottom.setPower(-.5);
                robot.Left_Bottom.setPower(-.5);
                robot.Left_Top.setPower(-.5);
            }


            if(gamepad1.left_bumper){
                robot.Intake1.setPower(-0.8);
                robot.Intake2.setPower(0.8);
            }else if(gamepad1.right_bumper){
                robot.Intake1.setPower(0.8);
                robot.Intake2.setPower(-0.8);
            }else{
                robot.Intake1.setPower(0);
                robot.Intake2.setPower(0);
            }

        }
    }
}
