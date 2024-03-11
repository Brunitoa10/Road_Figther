package GeneradorEntidades;

import java.awt.Graphics;

import CargaSprite.Loader;
import GestorTeclado.GestorTeclado;
import GestorTeclado.TeclaObservador;
import Math.Vector2D;

public class GameState implements ActualizarEntidad,TeclaObservador {

	protected Entidad player;
	protected GestorTeclado gestor_teclado;

	public GameState() {
		player = new Jugador(new Vector2D(100,500),Loader.ImageLoader("/Imagenes/Vehiculos/Auto/AutoJugador/1.png"));
		gestor_teclado = new GestorTeclado(this);
	}

	public void update() {
		player.update();
	}

	public void draw(Graphics g) {
		player.draw(g);
	}

	@Override
	public void teclaPresionada(int keyCode) {
		player.teclaPresionada(keyCode);
	}

	@Override
	public void teclaLiberada(int keyCode) {
		player.teclaLiberada(keyCode);
	}
}
