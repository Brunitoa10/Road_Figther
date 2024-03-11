package GUI;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import GeneradorEntidades.GameState;
import GestorTeclado.GestorTeclado;
import GestorTeclado.TeclaObservador;
import Reloj.Reloj;

public class Ventana extends JFrame implements Runnable, VentanaJuego,VentanaNotificable,TeclaObservador {

	protected Canvas canvas;
	protected Thread thread;
	protected boolean running;
	protected BufferStrategy bs;
	protected Graphics g;
	protected final static int FPS = 60;
	protected double TARGETTIME = 1000000000/FPS;
	protected double delta = 0;
	protected int AVERAGEFPS = FPS;
	protected GameState game_state;
	protected GestorTeclado gestor_teclado;
	protected Reloj reloj;

	public Ventana() {
		setResizable(false);
		inicializarVentana();	
		inicializarCanvas();
	}

	private void inicializarVentana() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana.class.getResource("/Imagenes/Icono/icono_carreras.png")));
		setTitle("Road Fighter 2D");
		setSize(DefaultVentanaJuego.WIDTH,DefaultVentanaJuego.HEIGTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		running = false;
		reloj = new Reloj();
	}

	private void inicializarCanvas() {
		canvas = new Canvas();
		canvas.setBackground(new Color(0, 0, 0));
		canvas.setPreferredSize(new Dimension(DefaultVentanaJuego.WIDTH,DefaultVentanaJuego.HEIGTH));
		canvas.setMaximumSize(new Dimension(DefaultVentanaJuego.WIDTH,DefaultVentanaJuego.HEIGTH));
		canvas.setMinimumSize(new Dimension(DefaultVentanaJuego.WIDTH,DefaultVentanaJuego.HEIGTH));
		canvas.setFocusable(true);

		gestor_teclado = new GestorTeclado(this); // Pasa la instancia de la Ventana como observador
		canvas.addKeyListener(gestor_teclado);

		getContentPane().add(canvas);
	}


	public void start() {
		thread = new Thread(this);
		running = true;
		thread.start();
	}

	public void stop() {
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void init() {
		game_state = new GameState();
	}

	public void run() {
		init();
		while (running) {
			reloj.calcularDelta();

			if (reloj.Actualizar()) {
				update();
				draw();
				reloj.resetear();
			}

			reloj.actualizarPromedioFPS();
		}
		stop();
	}
	
	private void update() {
		gestor_teclado.update();
		game_state.update();
	}

	private void draw() {
		bs = canvas.getBufferStrategy();
		if(bs == null) {
			canvas.createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//--inicio dibujo--
		// Limpia el fondo con un color sólido (por ejemplo, negro)
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, DefaultVentanaJuego.WIDTH, DefaultVentanaJuego.HEIGTH);

		game_state.draw(g);
		//--fin dibujo--
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		VentanaManager.getInstance().start();
	}

	@Override
	public void teclaPresionada(int keyCode) {
		game_state.teclaPresionada(keyCode);
	}

	@Override
	public void teclaLiberada(int keyCode) {
		game_state.teclaLiberada(keyCode);
	}



}
