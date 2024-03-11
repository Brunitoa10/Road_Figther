package CargaSprite;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Loader {
	public static BufferedImage ImageLoader(String path)
	{
		try {
			return ImageIO.read(Loader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*public static Font loadFont(String path, int size) {
			try {
				return Font.createFont(Font.TRUETYPE_FONT, Loader.class.getResourceAsStream(path)).deriveFont(Font.PLAIN, size);
			} catch (FontFormatException | IOException e) {
				e.printStackTrace();
				return null;
			}
	}
	
	public static Clip loadSound(String path) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Loader.class.getResource(path)));
			return clip;
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
		return null;
	}*/
}
