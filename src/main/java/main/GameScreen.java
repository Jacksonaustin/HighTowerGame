package main;

import java.awt.Color;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class GameScreen extends JPanel {
	
	public GameScreen() {
		
		
	}
	
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		int p = 0;
		
		
		for(int r = 0; r < 32; r ++) {
			for(int c = 0; c < 32; c ++) {

			
				g.setColor(randColor());
				g.fillRect(32 * c, p,  32, 32);
				
			}
			
			p+=32; 
			
		}
		
	}
	
	public static Color randColor() {
		
		Random rand = new Random();
		
		int x = rand.nextInt(0,256); 
		int y = rand.nextInt(0,256); 
		int z = rand.nextInt(0,256); 
		
		
		return new Color(x, y, z);
		
	}

}
