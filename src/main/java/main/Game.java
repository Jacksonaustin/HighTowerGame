package main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import inputs.KeyBoardListener;
import inputs.MyMouseListener;
import scenes.Menu;
import scenes.Playing;
import scenes.Settings;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Game extends JFrame implements Runnable {

	private GameScreen gameScreen;
	private BufferedImage img;
	private int updates;
	private long lastTimeUPS;

	private Thread gameThread;

	private final double FPS_SET = 120.0;
	private final double UPS_SET = 60.0;
	
	private MyMouseListener myMouseListener; 
	private KeyBoardListener keyboardListener; 
	
	private Render render; 
	private Menu menu;
	private Playing playing; 
	private Settings settings; 
	

	
	public Game() throws IOException {


		setSize(800, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false); 
		
		initClasses(); 
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

	public static void main(String[] args) throws IOException {

		System.out.println("Tower Defense");
		String filepath = "music/music.wav";
		Game game = new Game();
		game.initInput();
		game.start();
		LoopMusic(filepath);

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
	
	public void initClasses() throws IOException {
		
		render = new Render(this); 
		gameScreen = new GameScreen(this);
		menu = new Menu(this); 
		playing = new Playing(this); 
		settings = new Settings(this); 
		
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
	
	private void initInput() {
		
		myMouseListener = new MyMouseListener();
		keyboardListener = new KeyBoardListener(); 
		
		addMouseListener(myMouseListener);
		addMouseMotionListener(myMouseListener); 
		addKeyListener(keyboardListener);
		
		requestFocus(); 
		
		
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
	
	//get and set
	
	public Render getRender() {
		return render; 
	}

	public Menu getMenu() {
		return menu;
	}



	public Playing getPlaying() {
		return playing;
	}



	public Settings getSettings() {
		return settings;
	}
	
	public static void LoopMusic(String location) {
	    try {
	        File musicPath = new File(location);

	        if (musicPath.exists()) {
	            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
	            Clip clip = AudioSystem.getClip();
	            clip.open(audioInput); 
	            clip.loop(Clip.LOOP_CONTINUOUSLY); 
	            clip.start(); 
	        } else {
	            System.out.println("Can't find file: " + location);
	        }

	    } catch (Exception e) {
	        System.out.println("Error playing music: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
}


	


