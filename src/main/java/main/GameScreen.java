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
		
		
	/*	addMouseListener(new MouseAdapter(){
			
			@Override 
            public void mouseClicked(MouseEvent e) {
				tileX = e.getX()/32;
				tileY = e.getY()/32; 
				clicked = true; 
                System.out.println("Clicked at: (" + tileX + ", " + tileY + ")");
                System.out.println(objectMap[tileX][tileY].returnName()); 
                System.out.println(tileMap[tileX][tileY]); 
                
                objectMap[tileX][tileY] = objectMap[1][0]; 

				}
			
		}); 
		
		*/
		
		
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
	
	/*public static Tile[][] makeObjectMap(int[][] tilemap) throws IOException {
		
		Tile[][] TheMap = new Tile[25][25]; 
		
		BufferedImage roadTile = importing("/dirt_32x32.png");
		BufferedImage waterTile = importing("/water_32x32.png");
		BufferedImage grassTile = importing("/downscaled_32x32.png");

		
		for(int i = 0; i < 25; i++) {
			
			for(int p = 0; p < 25; p++) {
				
				if(tilemap[i][p] == 1) {
					
					Tile Grass = new Tile(grassTile, false, "Grass");
				    TheMap[i][p] = Grass; 
					
				}
				else if(tilemap[i][p] == 2) {

					Tile Water = new Tile(waterTile, false, "Water");
			     	TheMap[i][p] = Water; 


					
				}
				else if(tilemap[i][p] == 3) {
					Tile Dirt = new Tile(roadTile, true,"Road");
					TheMap[i][p] = Dirt; 


				//	System.out.println(TheMap[i][p]); 
				}
			}
		}
		return TheMap;
	}
	
	*/
	

}
	
