package main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Game extends JFrame{
	
	private GameScreen gameScreen; 
	
	private BufferedImage img; 
	
	
	public Game() {
		
		this.importing(); 
		
		setSize(800,800); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setLocationRelativeTo(null); 
		
		gameScreen = new GameScreen(img); 
		add(gameScreen); 
		setVisible(true);

	}
	
	private void importing() {
		InputStream is = getClass().getResourceAsStream("downscaled_32x32.png");
		
		try {
			img = ImageIO.read(is); 
		} catch (IOException e) {
			e.printStackTrace();
		
		}
	
	}
	public static void main(String[] args) {
		
		
		System.out.println("Tower Defense"); 
		Game game = new Game(); 
		
	}

    

}
