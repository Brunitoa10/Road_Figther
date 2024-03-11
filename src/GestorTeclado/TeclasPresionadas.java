package GestorTeclado;

import java.util.HashMap;
import java.util.Map;

public class TeclasPresionadas {
	protected Map<Integer, Boolean> teclasMap;

    public TeclasPresionadas() {
        teclasMap = new HashMap<>();
    }

    public boolean isTeclaPresionada(int keyCode) {
        return teclasMap.getOrDefault(keyCode, false);
    }

    public void setTeclaPresionada(int keyCode, boolean presionada) {
        teclasMap.put(keyCode, presionada);
    }
}
