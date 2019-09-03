/**
 * 
 */
package pJuegoVida;

/**
 * @author Víctor Bátiz y Rafael Zavala
 *
 */

/*
 * El siguiente enumerado se utilizará para controlar el estado del juego
 */
public enum EstadoJuego {
	CONTINUARJUEGO(""),
	VIDAETERNA("Llegamos a un estado de vida eterna"),
	NOQUEDANVIVOS("Todos los organismos han muerto"),
	FINGENERACIONES("Se han completado las generaciones solicitadas");
	
	private String texto;
	
	private EstadoJuego(String s) {
		texto = s;
	}
	
	@Override
	public String toString() {
		return texto;
	}
}
