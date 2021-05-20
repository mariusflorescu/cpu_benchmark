package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.bench.IBenchmark;
import main.java.bench.cpu.CPUDigitsOfPIBench;
import main.java.bench.cpu.Digits3;
import main.java.bench.cpu.Digits4;
import main.java.bench.cpu.Digits5;
import main.java.logging.ConsoleLogger;
import main.java.logging.ILog;
import main.java.timing.TimeUnit;
import main.java.timing.Timer;
import timing.ITimer;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../resources/sample.fxml"));
        primaryStage.setTitle("CPU Benchmark");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
//        launch(args);

        ILog log = new ConsoleLogger();
//        IBenchmark bench = new Digits3();
//        IBenchmark bench = new CPUDigitsOfPIBench();
        IBenchmark bench = new Digits4(); // Nilakantha method
//        IBenchmark bench = new Digits5(); //Arithmetic-geometric mean algorithm  Method
        ITimer timer = new Timer();
        TimeUnit timeUnit = TimeUnit.NANO;

        bench.warmUp();

        bench.initialize(1024);
        for(int i=0;i<1;++i){
            timer.start();
            bench.run();
            System.out.println("Elapsed time: " + timer.stop());
        }

    }
}


