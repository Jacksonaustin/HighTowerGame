package scenes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;

import main.Game;
import main.Render;
import main.tiles.Tile;

public class Menu extends GameScene implements SceneMethods{
	Tile[][] ObjectMap = new Tile[25][25]; 
	
	
	public Menu(Game game) throws IOException {
		super(game);
		ObjectMap = makeRandObjMap();

	}

	@Override
	public void render(Graphics g) {
		

		int x = 0;
		int y = 0;
	
	
		for(int r = 0; r < 25; r ++) {

		for(int p = 0; p < 25; p ++) {
			
			
			if(ObjectMap[r][p].getImage() != null) {
				g.drawImage(ObjectMap[r][p].getImage(), x, y, null); 
			}
			else {
				System.out.println("Help");
			}
			x += 32;	
		}
		y += 32; 
		x = 0;
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
				
				choice = rand.nextInt(0,4);
				if(choice == 1) {
					TheMap[i][p] = grass; 
				}
				else if(choice == 2) {
					TheMap[i][p] = water;
				}
				else if(choice == 3) {
					TheMap[i][p] = road;
				}
				else {
					TheMap[i][p] = grass; 
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

}
