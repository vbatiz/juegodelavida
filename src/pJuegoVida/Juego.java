package pJuegoVida;

import java.util.Scanner;

/**
 * @author Víctor Bátiz y Rafael Zavala
 *
 */

public class Juego {

	/*
	 *El siguiente método permite validar la entrada de un entero en base a los límites indicados
	 * @param
	 * texto - Texto a desplegar al usuario
	 * limInferior - Límite inferior permitido
	 * limSuperior - Límite superior permitido
	 */
	private static int obtenNumero(String texto, int limInferior, int limSuperior) {
		Scanner scanner = new Scanner(System.in);
		int number;
		boolean numErroneo=false;
		do {
			System.out.println(texto);
			while (!scanner.hasNextInt()) {
				String input = scanner.next();
				System.out.printf("\"%s\" No es un número válido.\n", input);
			}
			number = scanner.nextInt();
			if ((number < limInferior) || (number > limSuperior)) {
			    numErroneo = true;
                System.out.printf("\"%s\" está fuera de los límites.\n", number);
			}
			else {
			    numErroneo = false;
            }

		} while (numErroneo); //(number < limInferior) || (number >limSuperior)

		return number;
	}


	public static void main(String[] args) {
		int numFilas;
		int numColumnas;
		int numGen;
		int numOrganismos;
		int col;
		int reng;

		System.out.println("Bienvenido al Juego de la Vida");

		//Solicitar el número de filas  (de 2 a 20)
		numFilas = obtenNumero("Número de filas (2 a 20): ", 2,20);

		//Solicitar el número de columnas (de 2 a 20)
		numColumnas = obtenNumero("Número de columnas (2 a 20): ", 2,20);

		//Solicitar el número de generaciones ( de 1 a 50)
		numGen = obtenNumero("Número de generaciones (1 a 50): ", 1,50);

		//fijaFilas(numFilas);
		//fijaColumnas(numColumnas);
		//fijaNumGeneraciones(numGen);

		//Solicitar el número de organismos. Calcular tope (50% de la capacidad del tablero)
		int topeOrganismos = (int)((numFilas * numColumnas) / 2);
		numOrganismos =obtenNumero("Número de organismos (0 a " + topeOrganismos +"):", 0,topeOrganismos);

		//Crear tablero temporal para solicitar el estado inicial
		Organismo[][] organismos = new Organismo[numFilas][numColumnas];

		//Inicializamos todas las celdas del tablero con la enumeración MUERTO
		for (int i=0; i < numFilas; i++) {
			for (int j = 0; j < numColumnas; j++ ) {
				organismos[i][j] = Organismo.MUERTO;
			}
		}

	        /*
	        for (Organismo[] fila: organismos) {
	        	Arrays.fill(fila, Organismo.MUERTO);
	        }
	       */

		//Leemos las posiciones de los organismos vivos iniciales y los asignamos
		for(int i = 0; i < numOrganismos; i++) {
			//Se guarda el número de fila
			reng = obtenNumero("Posición de la fila del organismo " + (i+1) + " :", 1, numFilas);
			//Se guarda el número de columna
			col = obtenNumero("Posición de la columna del organismo " + (i+1) + " :", 1, numColumnas);
			organismos[reng-1][col-1] = Organismo.VIVO; //Se indica que la celda está viva
		}

		//Creamos el objeto tablero en base a los parámetros leidos
		Tablero tablero = new Tablero(numFilas,numColumnas,numGen,numOrganismos,organismos);
		//Empezamos el juego de la vida
		tablero.iniciar();	
	}

}
