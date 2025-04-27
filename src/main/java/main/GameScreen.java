package main;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JPanel;

public class GameScreen extends JPanel {
	
	private BufferedImage img; 
	
	public GameScreen(BufferedImage img) {
		
		this.img = img; 
		
		
	}
	
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		
		g.drawImage(img,0, 0, null);
		
		int x = 0;
		int y = 0;
		
		
	for(int r = 0; r < 32; r ++) {

			for(int c = 0; c < 32; c ++) {

					g.drawImage(img, x , y , null);
					
				x += 32;
				
			}
			
			y += 32; 
			x = 0;
						
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
