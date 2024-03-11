package GeneradorEntidades;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import Math.Vector2D;

public abstract class EntidadMovible extends Entidad {
	
	protected Vector2D velocidad;
	protected AffineTransform at; // ayuda a rotar objetos movibles
	protected double angle;
	
	public EntidadMovible(Vector2D p,Vector2D v ,BufferedImage t) {
		super(p, t);
		velocidad = v;
		angle = 0;
	}
}
