package main.tiles;

import java.awt.image.BufferedImage;

public class Tile {
	
	public BufferedImage img;
	public int id;
	
	public Tile(BufferedImage img, int id) {
		
		this.img = img; 
		this.id = id;
				
		
	}
	
	public int returnId() {
		return this.id;
	}
	
	
	public BufferedImage getImage() {
		return img; 
	}

}
