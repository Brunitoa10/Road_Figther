package GeneradorEntidades;


import java.awt.image.BufferedImage;

import GestorTeclado.TeclaObservador;
import Math.Vector2D;

public abstract class Entidad implements EntidadLogica,ActualizarEntidad,TeclaObservador{
	protected BufferedImage texture;
	protected Vector2D position;
	
	public Entidad(Vector2D p, BufferedImage  t) {
		position = p;
		texture = t;
	}
	
	public Vector2D getPosition() {
		return position;
	}

	public void setPosition(Vector2D position) {
		this.position = position;
	}
}
