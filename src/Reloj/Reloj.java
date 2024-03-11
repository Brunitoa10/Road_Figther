package Reloj;

public class Reloj{
	
	protected static final int FPS = 60;
	protected static final double TARGET_TIME = 1000000000.0 / FPS;

	protected long lastTime;
	protected double delta;
	protected int averageFPS;
	protected int frames;

	public Reloj() {
		lastTime = System.nanoTime();
		delta = 0;
		frames = 0;
		averageFPS = FPS;
	}

	public void calcularDelta() {
		long now = System.nanoTime();
		delta += (now - lastTime) / TARGET_TIME;
		lastTime = now;
	}

	public boolean Actualizar() {
		return delta >= 1;
	}

	public void actualizarPromedioFPS() {
		frames++;
		if (delta >= 1) {
			averageFPS = frames;
			frames = 0;
		}
	}

	public void resetear() {
		delta = 0;
	}

	public int obtenerPromedioFPS() {
		return averageFPS;
	}
}
