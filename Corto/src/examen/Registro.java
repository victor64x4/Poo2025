package examen;
import java.util.Stack;
import java.util.Scanner;

public class Registro {
	   
    	private static Scanner scanner = new Scanner(System.in);
    	private static Stack<Libro> pila = new Stack<>();
        
        public static void main(String[] args) {
	        while (true) {
	            System.out.println("Menú:");
	            System.out.println("1. Ingreso De Libros");
	            System.out.println("2. Salir");
	            System.out.print("Elija una opción: ");
	            int opcion = scanner.nextInt();
	            scanner.nextLine(); // Limpiar el buffer del scanner

	            switch (opcion) {
	                case 1:
	                    agregar_libro();
	                    break;
	                case 2:
	                    System.out.println("Saliendo del programa...");
	                    return;
	                default:
	                    System.out.println("Opción inválida. Intente nuevamente.\n");
	            }
	        }
    }
        private static void agregar_libro() {
            System.out.print("Cantidad de libros a ingresar: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer para que no haya errores

            for (int i = 0; i < cantidad; i++) {
                System.out.println("Ingrese el nombre del libro:");
                String nombre = scanner.nextLine();
                
                System.out.println("Ingrese el autor del libro:");
                String autor = scanner.nextLine();
                
                // Creamos el libro y lo agregamos a la pila 
                Libro libro = new Libro(nombre, autor);
                pila.push(libro);
            }

            // Mostrarmos los libros ingresados
            System.out.println("Libros ingresados:");
            for (Libro libro : pila) {
                System.out.println("Nombre: " + libro.getTitulo() + ", Autor: " + libro.getAutor());
            }
        }

}
