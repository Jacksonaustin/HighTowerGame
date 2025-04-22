package main;

import java.awt.Color;

import java.awt.Graphics;

import javax.swing.JPanel;

public class GameScreen extends JPanel {
	
	public GameScreen() {
		
	}
	
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		
		for(int r = 0; r < 10; r ++) {
			
				g.drawRect(50 * r, 50,  64, 64);

				
			
		}
		
	}
	
	public Color randColor() {
		
		
		return null;
		
	}

}
