package org.firstinspires.ftc.teamcode.testprograms;

import android.hardware.HardwareBuffer;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware;

@TeleOp
public class TestTeleop extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException {
        hardware robot = new hardware();

        robot.init(hardwareMap);

        waitForStart();
        while (opModeIsActive()) {
            robot.Left_Bottom.setPower(gamepad1.left_stick_y);
            robot.Right_Bottom.setPower(gamepad1.right_stick_y);
            robot.Left_Top.setPower(gamepad1.left_stick_y);
            robot.Right_Top.setPower(gamepad1.right_stick_y);

            if (gamepad1.x) {
                robot.Spinner.setPower(0.5);
            } else if (gamepad1.a) {
                robot.Spinner.setPower(-0.5);
            } else {
                robot.Spinner.setPower(0);
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


        }
    }
}
