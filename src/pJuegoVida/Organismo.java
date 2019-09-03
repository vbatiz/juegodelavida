package pJuegoVida;

/**
 * @author Víctor Bátiz y Rafael Zavala
 *
 */

/*
 * El siguiente enumerado permite determinar el estado de cada celda del tablero
 * Los valores asignados a cada elemento nos permititán armar la representación en
 * texto del tablero
 */
public enum Organismo {
	VIVO("X"),
	MUERTO("0");
	
	private String letra;
	
	private Organismo(String s) {
		letra = s;
	}

	@Override
	public String toString() {
		return letra;
	}
}
