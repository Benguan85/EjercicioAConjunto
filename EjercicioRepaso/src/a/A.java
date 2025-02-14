package a;

import java.util.Scanner;

class Palabra {

	String termino;
	String definicion;

	public Palabra(String termino, String definicion) {
		super();
		this.termino = termino;
		this.definicion = definicion;
	}

	public String getTermino() {
		return termino;
	}

	public void setTermino(String termino) {
		this.termino = termino;
	}

	public String getDefinicion() {
		return definicion;
	}

	public void setDefinicion(String definicion) {
		this.definicion = definicion;
	}
}

public class A {

	static void mostrarMenu() {
		System.out.println("Seleccione opción:");
		System.out.println("1. Introducir un término y su definición en el diccionario");
		System.out.println("2. Mostrar todos los términos (sin definiciones)");
		System.out.println("3. Obtener la definición de un término que el usuario introduzca");
		System.out.println("4. Eliminar un término y su definición");
		System.out.println("0. Salir");
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		Palabra[] diccionario = new Palabra[100];
		int opcion;
		int contador = 0;
		do {
			System.out.println("----------");
			mostrarMenu();
			opcion = s.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Introduce el término: ");
				String termino = s.next();

				System.out.println("Introduce la definición: ");
				String definicion = s.next();

				diccionario[contador++] = new Palabra(termino, definicion);

				break;
			case 2:
				for (int i = 0; i < contador; i++) {
					System.out.println(diccionario[i].getTermino());
				}
				break;

			case 3:
				System.out.println("Introduce el término a buscar: ");
				String terminoBuscado = s.next();
				for (Palabra palabra : diccionario) {
					if (palabra != null && palabra.getTermino().equals(terminoBuscado)) {
						System.out.println("Definición: " + palabra.getDefinicion());
						break;
					}
				}
				break;
			case 4:
			    System.out.println("Introduce el término a eliminar: ");
			    String terminoEliminar = s.next();

			   
			    for (int i = 0; i < contador; i++) {
			        if (diccionario[i].getTermino().compareTo(terminoEliminar) == 0) {
			        	
			            // Eliminar término
			            for (int j = i; j < contador - 1; j++) {
			                diccionario[j] = diccionario[j + 1];  // Desplazar los elementos
			            }
			            diccionario[contador - 1] = null;  // Quitamos hueco al array diccionario
			            contador--;  //Le restamos un hueco al array
			            System.out.println("Término eliminado con éxito.");
			            break;  // Salimos al eliminar la palabra(término
			        }
			    }
			    
			    break;

			case 0:
				System.out.println("Fin del programa");
				break;

			default:
				System.out.println("Opción no válida");
			}
		} while (opcion != 0);
	}
}
