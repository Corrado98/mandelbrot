package ch.parisi.mandelbrot.ui;

import java.util.List;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 * The Mandelbrot Set is the
 * visual representation of an
 * iterated function on th
 * complex plane.
 * 
 * f(x) = x^2 + c, where c is first input e.g.
 * 
 * f(2) = 2^2 + 2 = 6
 * f(6) = 6^2 + 2 = 36
 * etc. etc.
 * 
 * M-SET is the Set of all numbers that
 * DO NOT grow exponentially in the function
 * x^2 + c. All these numbers are within r = 2.
 * 
 * If you perform one iteration of the function
 * for every number within the circle, (r = 2)
 * each number, whose first output escapes the circle,
 * will be colored red.
 * 
 * iterate the function again for every number within
 * the black region.
 * Each number whose output escapes the circle after the 
 * second iteration will be colored green.
 * etc. etc. 
 * 
 */
public class MandelbrotSetGuiApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Mandelbrot Set");
        Group root = new Group();
        Canvas canvas = new Canvas(800, 600);
		// GraphicsContext gc = canvas.getGraphicsContext2D();

        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root)); 
        primaryStage.show();
        
	 
		
	}
	

	
	

	public static void main(String[] args) {
		launch(args);
	}

}
