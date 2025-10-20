package module4._02graphics;

import java.awt.Color;
import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class E05MovingBall {

	/*
	 * Exercise: Read and run the code below and make sure you
	 * understand how it works before proceeding.
	 */
	public static void main(String[] args) {
		double ballX = Math.random();
		double ballXVelocity = Math.random() * 0.05;
		double ballY = Math.random();
		double ballYVelocity = Math.random() * 0.05;

		double playerX = 0.5;
		double playerY = 0.5;
		double playerSpeed = 0.05;

		int score = 0;

		long lastPointGiven = System.currentTimeMillis();//long = same as an int but bigger

		StdDraw.setPenColor(Color.BLUE);
		StdDraw.setPenRadius(0.05);
		
		//infinite animation loop
		while (true) {
			
			//step 1 - clear the canvas
			StdDraw.clear();
			
			//step 2 - updates posiiton of ALL moving addresses
			ballX = ballX + ballXVelocity;
			ballY = ballY + ballYVelocity;
			if(ballX > 0.975 || ballX < 0) { //too far right
				ballX =- ballXVelocity; //bounce
			}
			if(ballY > 0.975 || ballY < 0) { //too far right
				ballY =- ballYVelocity; //bounce
			}

			if(StdDraw.isKeyPressed(KeyEvent.VK_W)){//need to go up
				playerY += playerSpeed;
			}

			long now = System.currentTimeMillis();
			if(now - lastPointGiven > 1000){//one second elapsed
				score++;
				lastPointGiven = now;
			}
			
			//step 3 - draw on canvas and pause
			StdDraw.setPenColor(Color.RED);
			StdDraw.point(ballX, ballY);
			StdDraw.setPenColor(Color.BLACK);
			StdDraw.point(playerX, playerY);
			StdDraw.text(0.5, 0.1, "Score: " + score);
			
			//pause to make the animation smooth
			StdDraw.show();
			StdDraw.pause(10);

			double distance = Math.sqrt(Math.pow(playerX - ballX, 2) + Math.pow(playerY - ballY, 2));
			
			if(distance < 0.1){ //collision!
				playerX = 0.5;
				playerY = 0.5;
				score = 0;
			}
			
		}
	}
}
