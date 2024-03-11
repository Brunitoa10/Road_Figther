package GestorTeclado;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class GestorTeclado implements KeyListener,ActualizacionTeclado{
    private Set<Integer> teclasPresionadas = new HashSet<>();
    private TeclaObservador observador;

    public GestorTeclado(TeclaObservador observador) {
        this.observador = observador;
    }

    public void agregarObservador(TeclaObservador observador) {
        this.observador = observador;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        teclasPresionadas.add(e.getKeyCode());
        observador.teclaPresionada(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        teclasPresionadas.remove(e.getKeyCode());
        observador.teclaLiberada(e.getKeyCode());
    }


    public Set<Integer> getTeclasPresionadas() {
        return teclasPresionadas;
    }

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void update() {
		// Actualiza el estado del teclado
        for (Integer keyCode : teclasPresionadas) {
            observador.teclaPresionada(keyCode);
        }
	}

}
