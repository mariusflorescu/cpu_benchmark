package main.java.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import main.java.bench.IBenchmark;
import main.java.bench.cpu.CPUDigitsOfPIBench;
import main.java.logging.ConsoleLogger;
import main.java.logging.ILog;
import main.java.timing.TimeUnit;
import main.java.timing.Timer;
import timing.ITimer;

public class Controller {

    @FXML
    public TextField nrOfDigits;

    @FXML
    public Text warmup;

    @FXML
    public Text time;

    @FXML
    public Label stringErrorLabel;

    @FXML
    public Label piLabel;

    public void warmup() throws InterruptedException {
        for (int i = 1; i <= 10000; i++) {
            for (int j = 1; j <= 10000; j++) {
                CPUDigitsOfPIBench test = new CPUDigitsOfPIBench();
                ConsoleLogger test2 = new ConsoleLogger();
                Timer test3 = new Timer();
            }

        }

        warmup.setText("Warm-Up done! Let's GO!");


    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }


    @FXML
    public void getDigitsOfPi() throws InterruptedException {

//        ILog log = new ConsoleLogger();
//        IBenchmark bench = new CPUDigitsOfPIBench();
//        ITimer timer = new Timer();
//        TimeUnit timeUnit = TimeUnit.NANO;
//
//        bench.warmUp();
//
//        bench.initialize(10000);
//        for(int i=0;i<1;++i){
//            timer.start();
//            bench.run();
//            System.out.println("Elapsed time: " + timer.stop());
//        }




    }
}
