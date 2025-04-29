package main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Game extends JFrame implements Runnable {

	private GameScreen gameScreen;
	private BufferedImage img;
	private int updates;
	private long lastTimeUPS;

	private Thread gameThread;

	private final double FPS_SET = 120.0;
	private final double UPS_SET = 60.0;
	
	public Game() {


		setSize(800, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		gameScreen = new GameScreen();
		add(gameScreen);
		setVisible(true);

	}

	/*
	 * private void importing() { InputStream is =
	 * getClass().getResourceAsStream("downscaled_32x32.png");
	 * 
	 * try { img = ImageIO.read(is); } catch (IOException e) { e.printStackTrace();
	 * 
	 * }
	 * 
	 */

	public static void main(String[] args) {

		System.out.println("Tower Defense");
		Game game = new Game();
		game.start();

	}

	@Override
	public void run() {

		double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdate = 1000000000.0 / UPS_SET;
		long lastFrame = System.nanoTime();
		int frames = 0;
		long lastTimeCheck = System.currentTimeMillis();
		int updates = 0;
		long lastUpdate = System.nanoTime();

		while (true) {

			if (System.nanoTime() - lastFrame >= timePerFrame) {
				
				repaint();
				lastFrame = System.nanoTime();
				frames++;
			}

			if (System.nanoTime() - lastUpdate >= timePerUpdate) {
				updateGame();
				lastUpdate = System.nanoTime();
				updates++;
			}

			if (System.currentTimeMillis() - lastTimeCheck >= 1000) {
				System.out.println("FPS: " + frames + "| UPS: " + updates);
				frames = 0;
				updates = 0;
				lastTimeCheck = System.currentTimeMillis();
			}

		}
	}

	private void start() {
		gameThread = new Thread(this) {
		};
		gameThread.start();
	}

	private void loopGame() {

		while (true) {

		}
	}

	private void callUPS() {
		if (System.currentTimeMillis() - lastTimeUPS >= 1000) {
			System.out.println("UPS: " + updates);
			updates = 0;
			lastTimeUPS = System.currentTimeMillis();
		}
	}

	private void updateGame() {
		updates++;

	}

}
