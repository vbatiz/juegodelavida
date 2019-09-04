# juegodelavida
Tarea 1<br>
Materia: Tecnologías de Programación de la MCC del ITC
<br>
### Tutor: Dra. María Lucía Barrón Estrada ##

#### Autores: Víctor Bátiz y Rafael Zavala

#### Lista de entregables:
1. El código fuente se encuentra en la carpeta: src\pJuegoVida (https://github.com/vbatiz/juegodelavida/tree/master/src/pJuegoVida)
2. El Diagrama UML final: diagramauml.png 
![alt text](https://github.com/vbatiz/juegodelavida/blob/master/diagramauml.png)

#### Descripción
El presente proyecto es una implementación en Java de El juego de la vida que fue diseñado por el matemático británico John Horton Conway en 1970. Esta desarrollado utilizando la consola como interfaz y utilizando el IDE IntelliJ IDEA Ultimate 2019.2.
<br><br>
En esta implementación se siguieron las siguientes indicaciones:
##### Requisitos:
1. Debes usar métodos para realizar los diferentes procesos
2. Debes definir una clase para el tablero y sus reglas
3. El programa debe estar documentado con comentarios.
4. Los datos de entrada se darán por teclado y deberás leerlos para iniciar el tablero.
5. Cada generación debe mostrarse en pantalla en un formato uniforme.
6. Los datos de entrada se leerán en el siguiente orden:
    1. Numero de filas del tablero (int) de 2 a 20
    2. Numero de columnas del tablero (int) de 2 a 20
    3. Numero de generaciones del juego (int) de 1 a 50
    4. Numero de organismos iniciales (n) de 0 a 50% de la capacidad del tablero
    5. Posición fila y columna de organismo 1 (int int) de 0 a maxFila y 0 a maxColumna
    6. Posición fila y columna de organismo 2 (int int) de 0 a maxFila y 0 a maxColumna
    7. …
    8. Posición fila y columna de organismo n (int int) de 0 a maxFila y 0 a maxColumna
7. Detener el programa después de mostrar cada generación y continuar la ejecución al darle enter
8. Detener el programa cuando todos los organismos estén muertos
<br>
El juego de la vida se desarrolla en un tablero de dos dimensiones donde cada posición del tablero representa un Organismo, los organismos de las celdas pueden morir o nacer de una generación a otra, de acuerdo a un conjunto de reglas.
La generación inicial se forma colocando organismos vivos en algunas celdas del tablero.
<br>
##### Las reglas que determinan los cambios en el tablero se dan a continuación:
<br>
1. Cada celda del tablero puede tener 3, 5 u 8 vecinos.<br>
2. Los vecinos de una celda son aquellas celdas que se encuentran adyacentes a ella.<br>
3. Un organismo vivo, permanece así en la siguiente generación si tiene de vecinos a dos o tres organismos vivos.<br>
4. Los organismos con menos de dos vecinos mueren de aislamiento.<br>
5. Los organismos con más de tres vecinos mueren de hacinamiento.<br>
6. Las celdas vacías que tienen exactamente tres organismos vecinos nacen en la siguiente generación.<br>
<br>
La salida del programa iniciara desplegando el tablero con la primera generación de organismos ubicados en sus respectivas celdas y un mensaje desplegando el numero de la generación actual. Calcular la siguiente generación y esperar por una tecla antes de desplegarla.<br>
<br>
La salida puede desplegar el tablero en forma textual.
