 package main;

import java.awt.Color;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import main.tiles.Tile;
import scenes.Menu;
import scenes.Playing;
import scenes.Settings;

public class GameScreen extends JPanel implements ActionListener{
	

	
	private Game game; 
	private Render render; 
	private Menu menu;
	private Playing playing; 
	private Settings settings; 
	
	public GameScreen(Game game) {
		this.game = game; 
		
		
	
		
		
	}
	
	public void paintComponent(Graphics g) {
		
	
		
		super.paintComponent(g);
		
		try {
			game.getRender().render(g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
			
	}


	
	public static Color randColor() {
		
		Random rand = new Random();
		
		int x = rand.nextInt(0,256); 
		int y = rand.nextInt(0,256); 
		int z = rand.nextInt(0,256); 
		
		
		return new Color(x, y, z);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
	
