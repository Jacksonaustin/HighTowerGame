package main.tiles;

import java.awt.image.BufferedImage;

public class Tile {
	
	public BufferedImage img;
	public boolean walkable; 
	public String name;
	
	public Tile(BufferedImage img, Boolean walkable, String name ) {
		
		this.img = img; 
		this.walkable = walkable; 
		this.name = name; 
				
		
	}
	
	public String returnName() {
		return this.name;
	}
	
	public boolean isWalkable() {
			
		return walkable; 
		
	}
	
	public BufferedImage getImage() {
		return img; 
	}

}
