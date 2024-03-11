package Datos;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Datos {
	public void guardarDatos(String input) throws FileNotFoundException,IOException;
	public String recuperarDatos() throws FileNotFoundException,IOException,ClassNotFoundException;
}
