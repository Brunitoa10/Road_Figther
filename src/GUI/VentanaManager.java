package GUI;

public class VentanaManager implements VentanaJuego{
	protected static VentanaManager instance;
    protected Ventana ventana;

    private VentanaManager() {
        ventana = new Ventana();
    }

    public static VentanaManager getInstance() {
        if (instance == null) {
            instance = new VentanaManager();
        }
        return instance;
    }

	public void start() {
		ventana.start();
	}

	public void stop() {
		ventana.stop();
	}

   
}
