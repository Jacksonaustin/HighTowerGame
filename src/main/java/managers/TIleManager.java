package managers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import helpers.LevelBuilder;
import helpers.LoadSave;
import main.Render;
import main.tiles.Tile;

public class TIleManager {
	
	public static Tile GRASS;
	public static Tile WATER;
	public static Tile ROAD;
	public static  BufferedImage[] spriteArray = new BufferedImage[4]; 
	public ArrayList<Tile> tiles = new ArrayList<Tile>(); 
	
	
	public TIleManager() throws IOException {
		
		init_sprites();
		createTiles();
		
	}



private static BufferedImage importing(String file) {
    
	
	BufferedImage img = null; 
	InputStream is = TIleManager.class.getResourceAsStream(file);

	
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
	

public void createTiles() {
	
	tiles.add(GRASS = new Tile(spriteArray[0], 1));
	tiles.add(WATER = new Tile(spriteArray[1], 2));
	tiles.add(ROAD = new Tile(spriteArray[2], 3));

	
	
}


public static void init_sprites() {
	spriteArray = LoadSave.getSpriteArray(); 
	
}

public BufferedImage getSprite(int id) {
	System.out.println(tiles.get(id).returnId());
	return tiles.get(id).getImage();
}




}


