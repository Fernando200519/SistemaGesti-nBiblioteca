package menu;

import java.util.Scanner;

import modelo.Libro;
import servicio.GestorLibros;
import servicio.GestorUsuarios;

public class Main {
    static GestorUsuarios arrayUsuarios = new GestorUsuarios();

    static Libro libro1 = new Libro(1, "Cien años de soledad", "Gabriel Garcia Marquez", "Editorial Sudamericana", "1967-05-30");
    static Libro libro2 = new Libro(2, "1984", "George Orwell", "Secker & Warcurg", "1949-06-08");
    static Libro libro3 = new Libro(3, "El principito", "Antoine de Saint-Exupery", "Reynal & Hitchcock", "1943-04-06");
    static Libro libro4 = new Libro(4, "Orgullo y prejuicio", "Jane Austen", "T. Egerton", "1813-01-28");
    static Libro libro5 = new Libro(5, "Don Quijote de la Mancha", "Miguel de Cervantes", "Francisco de Robles", "1605-01-16");

    static Libro[] libros = {libro1, libro2, libro3, libro4, libro5};
    static GestorLibros arrayLibros = new GestorLibros(libros);
    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);
        
        System.out.println("\nBIENVENIDO AL SISTEMA DE GESTION DE LA BIBLIOTECA");
        int opcion;
        int idUsuario = 1;

        do{
            System.out.println("\n1. Registrar usuario");
            System.out.println("2. Mostrar usuarios registrados");
            System.out.println("3. Mostrar libros");
            System.out.println("4. Prestar libro");
            System.out.println("5. Devolver libro");
            System.out.println("6. Salir");
            System.out.print("\nOpcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {

                case 1:
                arrayUsuarios.registrarUsuario(idUsuario);
                idUsuario++;
                break;

                case 2:
                arrayUsuarios.mostrarUsuarios();
                break;

                case 3:
                arrayLibros.mostrarLibros();
                break;

                case 4:
                arrayLibros.prestarLibro(arrayUsuarios, libros);
                break;

                case 5:
                arrayLibros.devolverLibro(arrayUsuarios, libros);
                break;

            }

        }while(opcion != 6);

        entrada.close();
        
    }
}