package Datos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializacion implements Datos{
	protected String fileName = "DatosPartida.example"; 
	@Override
	public void guardarDatos(String input) throws FileNotFoundException, IOException {
		FileOutputStream file = new FileOutputStream(fileName);
		ObjectOutputStream out = new ObjectOutputStream(file);
		out.writeObject(input);
		out.close();
		file.close();
	}

	@Override
	public String recuperarDatos() throws FileNotFoundException, IOException, ClassNotFoundException {
		String input = null;
		FileInputStream file = new FileInputStream(fileName);
		ObjectInputStream in = new ObjectInputStream(file);
		input = (String)in.readObject();
		in.close();
		file.close();
		return input;
	}

}
