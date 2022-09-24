package org.firstinspires.ftc.teamcode.testprograms;

import android.hardware.HardwareBuffer;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware;

public class TestTeleop extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException {
        hardware robot = new hardware();

        robot.init(hardwareMap);

        waitForStart();
        while (opModeIsActive()){
            robot.Left_Bottom.setPower(gamepad1.left_stick_y);
            robot.Right_Bottom.setPower(gamepad1.right_stick_y);
            robot.Left_Top.setPower(gamepad1.left_stick_y);
            robot.Right_Top.setPower(gamepad1.right_stick_y);
        }


    }
}
