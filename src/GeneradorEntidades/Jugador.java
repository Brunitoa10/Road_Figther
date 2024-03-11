package GeneradorEntidades;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import Math.Vector2D;

public class Jugador extends Entidad{
	protected int limiteVelocidad = 500;

	public Jugador(Vector2D p, BufferedImage t) {
		super(p,t);
	}

	@Override
	public void update() {

	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(texture, (int) position.getX(), (int)position.getY(), null);
	}

	@Override
	public void teclaPresionada(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_RIGHT:
			position.setX(position.getX()+1);
			break;
		case KeyEvent.VK_LEFT:
			position.setX(position.getX()-1);
			break;
		case KeyEvent.VK_UP:
			position.setY(position.getY()-1);
			break;
		case KeyEvent.VK_DOWN:
			position.setY(position.getY()+1);
			break;	
		}
	}

	@Override
	public void teclaLiberada(int keyCode) {
		
	}


}
