package helpers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LoadSave {
	
	public static BufferedImage[] spriteArray = new BufferedImage[4]; 
	
	
	
	public static BufferedImage[] getImageArray() {
		init_sprites();
		if (spriteArray[3] == null) {
		    System.out.println("spriteArray[3] is null!");
		}
 		return spriteArray;
	}
	public static void init_sprites() {
		
		try {
			spriteArray[0] = imports("/dirt_32x32.png");
			spriteArray[1] = imports("/downscaled_32x32.png");
			spriteArray[2] = imports("/water_32x32.png");
			spriteArray[3] = imports("/first_frame.png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static BufferedImage imports(String file) {
	    
		
		BufferedImage img = null; 
		InputStream is = LoadSave.class.getResourceAsStream(file);

		
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
	
	public static BufferedImage[] getSpriteArray() {
		return spriteArray; 
	}


}
