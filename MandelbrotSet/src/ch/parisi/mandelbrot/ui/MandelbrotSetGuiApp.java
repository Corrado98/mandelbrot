package ch.parisi.mandelbrot.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ch.parisi.mandelbrot.function.ComplexNumber;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 
 * The Mandelbrot Set is the visual representation of an iterated function on
 * the complex plane.
 * 
 * f(x) = x^2 + c, where c is first input e.g.
 * 
 * f(2) = 2^2 + 2 = 6 f(6) = 6^2 + 2 = 36 etc. etc.
 * 
 * starting point: 
 * f(0) = 0^2 + c^2
 * f(0) = c^2
 * 
 * f(1) = (c^2)^2 + c
 * 
 * c = a + bi
 * f(x) = x^2 + (a + bi)
 * f(0) = a + bi
 * f(1) = (a + bi)^2 + (a + bi)
 * f(1) = (a + bi) * (a + bi) + (a + bi)
 * f(1) = a^2 + 2abi - b + (a + bi)
 * 
 * M-SET is the Set of all numbers that DO NOT grow exponentially in the
 * function x^2 + c. All these numbers are within r = 2.
 * 
 * If you perform one iteration of the function for every number within the
 * circle, (r = 2) each number, whose first output escapes the circle, will be
 * colored red.
 * 
 * iterate the function again for every number within the black region. Each
 * number whose output escapes the circle after the second iteration will be
 * colored green. etc. etc.
 * 
 */
public class MandelbrotSetGuiApp extends Application {

	List<ComplexNumber> allPointsWithinCircle = new ArrayList<>();

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Mandelbrot Set");
		Group root = new Group();
		Canvas canvas = new Canvas(1000, 1000);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.fillOval(0, 0, 1000, 1000);
		
		gc.setFill(Color.RED);
		gc.fillRect(500, 500, 1, 1);
		
		for (int y = 0; y < 1000; y++) {
			for (int i = 0; i < 1000; i++) {
				ComplexNumber complexNumber = new ComplexNumber(i, y);
				if (isPointInCircle(complexNumber, canvas)) {
					allPointsWithinCircle.add(complexNumber);
				}
			}
		}

		for (Iterator iterator = allPointsWithinCircle.iterator(); iterator.hasNext();) {
			ComplexNumber complexNumber = (ComplexNumber) iterator.next();
			System.out.println(complexNumber.toString());

		}

		root.getChildren().add(canvas);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();

	}

	private boolean isPointInCircle(ComplexNumber complexNumber, Canvas canvas) {
		if (Math.pow((complexNumber.getX() - (canvas.getWidth() / 2)), 2)
				+ Math.pow((complexNumber.getY() - (canvas.getHeight() / 2)), 2) < Math.pow((canvas.getWidth() / 2), 2)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
