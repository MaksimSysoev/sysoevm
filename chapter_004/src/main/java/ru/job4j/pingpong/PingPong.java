package ru.job4j.pingpong;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PingPong extends Application {

    private static final String JOB4J = "Пинг-понг www.job4j.ru";

    @Override
    public void start(Stage stage) throws InterruptedException {
        int limitX = 300;
        int limitY = 300;
        Group group = new Group();
        Rectangle rect1 = new Rectangle(50, 100, 10, 10);
        Rectangle rect2 = new Rectangle(250, 100, 20, 20);
        group.getChildren().add(rect1);

        Thread t1 = new Thread(new RectangleMove(rect1, 1));
        Thread t2 = new Thread(new RectangleMove(rect2, -1));

        t1.start();
        t1.join();
        if (!t1.isAlive()) {
            group.getChildren().add(rect2);
            t2.start();
        }


        stage.setScene(new Scene(group, limitX, limitY));
        stage.setTitle(JOB4J);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
