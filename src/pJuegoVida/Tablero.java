package pJuegoVida;
/**
 * @author Víctor Bátiz y Rafael Zavala
 * Materia: Técnicas de Programación
 * Titular: Dra. María Lucía Barrón Estrada
 *
 */

import java.util.Arrays;
import java.util.Scanner;


public class Tablero {
	private int filas;
	private int columnas;
	private int numGeneraciones;
	private int generacionActual;
	private Organismo organismos[][];
	private EstadoJuego estadoJuego;

	/*
	* Método Constructor
	*@param
	* f - número de filas
	* c - número de columnas
	* nG - número de generaciones
	* nOrg - número de organismos
	* o - Matriz de organismos iniciales
	*/

	public Tablero(int f, int c, int nG, int nOrg, Organismo o[][]) {

	    if (nOrg > 0) {
            estadoJuego = EstadoJuego.CONTINUARJUEGO; //A jugar
        }
	    else {
            estadoJuego = EstadoJuego.NOQUEDANVIVOS; //Si no se activaron organismos de inicio
        }

	    generacionActual = 0; //Generación base
		filas =f;
		columnas = c;
		numGeneraciones = nG;
		this.organismos = new Organismo[filas][columnas];
		System.arraycopy(o, 0, organismos, 0, o.length);
	}


	/*
	* El siguiente método inicia la operación del tablero
	 */
	public void iniciar() {
		Scanner sc = new Scanner(System.in); //Se crea el lector

		//Despliega el tablero inicial
        	System.out.println(this);
        	
            /*
             * Ciclo de ejecución principal, mientras el estado del juego
             * sea seguir jugando se generará el tablero siguiente y se
             * desplegará.
             */
            while (!finJuego()) {
            	sc.nextLine(); //Pausa
            	//Se genera la siguiente generación
            	siguienteGeneracion();
	        	//Se despliega el nuevo tablero
	        	System.out.println(this);

	        }
            //Se despliega el estado final del juego
	        System.out.println(estadoJuego);
	        
	        //Se libera el objeto scanner
	        sc.close();
	        
	}  
	
	
	/*
	 * El siguiente método permite crear la siguiente generación del tablero
	 */
	private void siguienteGeneracion(){
		boolean seguir = false;
		
		Organismo[][] previo = new Organismo[filas][columnas];
	    System.arraycopy(organismos, 0, previo, 0, organismos.length);
	    Organismo[][] siguiente = new Organismo[filas][columnas];
	    for ( int i = 0; i < filas; i++ ){
	    	for ( int j = 0; j < columnas; j++ ){
	    		siguiente[i][j] = estaVivo(i, j, previo);
	    		if (siguiente[i][j] == Organismo.VIVO) {
	    			seguir = true;
	    		}
	    	}
	    }
	    System.arraycopy(siguiente, 0, organismos, 0, siguiente.length);
	    //Verifica si queda algún organismo con vida
	    if (!seguir) {
	    	estadoJuego = EstadoJuego.NOQUEDANVIVOS;
	    }	
	    //Verifica si el nuevo tablero es igual al anterior
	    if (Arrays.deepEquals(previo, siguiente)) {
	    	estadoJuego = EstadoJuego.VIDAETERNA;
	    }
	    generacionActual++;
	    //fijaGeneracionActual(obtenGeneracionActual()+1);
	    //Verifica si hemos llegado al número de generaciones solicitadas
	    if (generacionActual == numGeneraciones) {
        	//sigueJugando = false;
        	estadoJuego=EstadoJuego.FINGENERACIONES;
        }

	 }
	
	/*
	 * El siguiente método genera la representación en String
	 * del tablero
	 */
	private String generaTablero(){
		String tableroTexto;
		
		tableroTexto = "Generación: " + generacionActual + "\n";
		
		for (int i = 0; i < filas; i++) {
	    	 for (int j = 0; j < columnas; j++) {
	    		 tableroTexto += "  " + organismos[i][j];
	         }
	         tableroTexto += "\n";
	    }
		tableroTexto += "Presiona [Enter] para continuar \n";
		
	    return tableroTexto;
	  }
	
	/*
	 * El siguiente método permite verificar si una celda vive o muere
	 *  
	 * @Param
	 * x - fila de la celda
	 * y - columna de la celda
	 * t - Arreglo bidimensional con la versión vigente del tablero
	 */
	private Organismo estaVivo(int x, int y, Organismo[][] tab){
		int numVecinos = 0; //Contabiliza los vecinos vivos

		for ( int i = x-1; i <= x+1; i++ ){
			for ( int j = y-1; j <= y+1; j++ ){
					try
					{
						if ( tab[i][j] == Organismo.VIVO ){
							numVecinos++;
						}
					}
					// manejando la excepción de posición fuera de límites
					catch(ArrayIndexOutOfBoundsException e)
					{
						//Hacer nada. System.out.println(e); //Para pruebas
					}
	  		}
	  	}

		/*Descuenta un vecino en caso de que el elemento evaluado esté vivo
		 *Así evitamos validar con una condición en el ciclo previo
		 */
		if ( tab[x][y] == Organismo.VIVO) numVecinos--;
		
		//Se revisa si la celda muerta debe nacer
	  	if ( tab[x][y] == Organismo.MUERTO ){
	  		if ( numVecinos == 3 ){//Nace debido a que tiene 3 vecinos exactos
	  			return Organismo.VIVO;
	  		}
	  		return Organismo.MUERTO;//Sigue sin nacer
	  	}else{//Se revisa si la celda viva debe morir o seguir viva
	  		if ( numVecinos < 2 || numVecinos > 3 ){//Muere por aislamiento o hacinamiento.
	  			return Organismo.MUERTO;
	  		}
	  		return Organismo.VIVO;//vive ya que tiene 2 o 3 vecinos
	  	}
	  	
	}

	//Determina si el juego debe finalizar
	private boolean finJuego() {
		return (estadoJuego != EstadoJuego.CONTINUARJUEGO);
	}

	/*
	 * Sobreescribimos el método toString() para regresar la representación
	 * del tablero
	 */
	@Override
	public String toString() {
		return generaTablero();
		
	}
	
}
