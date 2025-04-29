package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;

import main.tiles.Tile;

public class Render {
	
	private Game game; 
	private Tile[][] ObjectMap;
	
	public Render(Game game) {
		this.game = game; 

	}
	
	public void render(Graphics g) throws IOException {
		
		switch(GameStates.gameState) {
		
		case MENU:
			game.getMenu().render(g); 
		
			break;
			
		case PLAYING: 
			
			game.getPlaying().render(g);
			
			break;
		case SETTINGS:
			
			game.getSettings().render(g);

			
			break;
		}
		
	}
	
	public static Tile[][] makeRandObjMap() throws IOException {
		
		Tile[][] TheMap = new Tile[25][25]; 
		
		BufferedImage roadTile = importing("/dirt_32x32.png");
		BufferedImage waterTile = importing("/water_32x32.png");
		BufferedImage grassTile = importing("/downscaled_32x32.png");
		
		Tile grass = new Tile(grassTile, false, "Grass"); 
		Tile water = new Tile(waterTile, false, "Water"); 
		Tile road = new Tile(roadTile, false, "Road"); 


		
		Random rand = new Random(); 
		int choice; 
		
		for(int i = 0; i < 25; i++) {
			
			for(int p = 0; p < 25; p++) {
				
				choice = rand.nextInt(1,4);
				if(choice == 1) {
					TheMap[i][p] = grass; 
				}
				else if(choice == 2) {
					TheMap[i][p] = water;
				}
				else if(choice == 3) {
					TheMap[i][p] = road;
				}

			}
		}
		return TheMap;
	}
	
	private static BufferedImage importing(String file) {
       
		
    	BufferedImage img = null; 
		InputStream is = Render.class.getResourceAsStream(file);

		
		if(is == null) {
			System.out.println(file + " wasn't loaded");
			return null; 
		}
		
		try {
			img = ImageIO.read(is); 
		} catch (IOException e) {
			e.printStackTrace();
		
		}
		
		
		return img; 

	}
	
	public void initMap() throws IOException
	{
		this.ObjectMap = makeRandObjMap(); 
	}


		
	

}
