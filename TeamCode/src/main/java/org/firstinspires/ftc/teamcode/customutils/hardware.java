package org.firstinspires.ftc.teamcode.customutils;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

public class hardware {

    //motors
    public DcMotor Right_Bottom;
    public DcMotor Right_Top;
    public DcMotor Left_Bottom;
    public DcMotor Left_Top;
    public DcMotor Slider;
    public CRServo Intake1;
    public CRServo Intake2;
    public IMU Gyro;

    HardwareMap hwMap = null;

    public void init(HardwareMap ahwMap){

        hwMap = ahwMap;
        Right_Bottom = hwMap.get(DcMotor.class, "Right Back");
        Right_Top = hwMap.get(DcMotor.class, "Right Front");
        Left_Bottom = hwMap.get(DcMotor.class, "Left Back");
        Left_Top = hwMap.get(DcMotor.class, "Left Front");
        Slider = hwMap.get(DcMotor.class,"Slider");
        Intake1 = hwMap.get(CRServo.class,"Intake1");
        Intake2 = hwMap.get(CRServo.class,"Intake2");
        Right_Top.setDirection(DcMotor.Direction.REVERSE);
        Right_Bottom.setDirection(DcMotor.Direction.REVERSE);
        Slider.setDirection(DcMotorSimple.Direction.REVERSE);
        Gyro = hwMap.get(IMU.class, "imu");

    }


    public void intakeOut(int time){
        Intake1.setPower(-0.8);
        Intake2.setPower(0.8);
        try{
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {}

        Intake1.setPower(0);
        Intake2.setPower(0);
    };
    
    public void intakeIn(int time){
        Intake1.setPower(0.8);
        Intake2.setPower(-0.8);
        try{
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {}

        Intake1.setPower(0);
        Intake2.setPower(0);
    };
}

