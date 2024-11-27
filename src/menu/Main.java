package menu;

import java.util.Scanner;

import modelo.Libro;
import modelo.Usuario;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        System.out.println("\nBIENVENIDO AL SISTEMA DE GESTION DE LA BIBLIOTECA");
        int opcion;
        Scanner entrada = new Scanner(System.in);
        int idUsuario = 0;

        Libro libro1 = new Libro(1, "Cien años de soledad", "Gabriel Garcia Marquez", "Editorial Sudamericana", "1967-05-30");
        Libro libro2 = new Libro(2, "1984", "George Orwell", "Secker & Warcurg", "1949-06-08");
        Libro libro3 = new Libro(3, "El principito", "Antoine de Saint-Exupery", "Reynal & Hitchcock", "1943-04-06");
        Libro libro4 = new Libro(4, "Orgullo y prejuicio", "Jane Austen", "T. Egerton", "1813-01-28");
        Libro libro5 = new Libro(5, "Don Quijote de la Mancha", "Miguel de Cervantes", "Francisco de Robles", "1605-01-16");


        do{
            System.out.println("\n1. Registrar usuario");
            System.out.println("2. Buscar libro");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Salir");
            System.out.print("\nOpcion: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                String nombre, apellidoPaterno, apellidoMaterno, genero, direccion, telefono, correoElectronico;
                LocalDate fechaNacimiento;
                entrada.nextLine();
                System.out.print("\nNombre: ");
                nombre = entrada.nextLine();
                System.out.print("Apellido Paterno: ");
                apellidoPaterno = entrada.nextLine();
                System.out.print("Apellido Materno: ");
                apellidoMaterno = entrada.nextLine();
                System.out.print("Fecha de nacimiento(yyyy-mm-dd): ");
                String input = entrada.nextLine();
                fechaNacimiento = LocalDate.parse(input);
                System.out.print("Genero: ");
                genero = entrada.nextLine();
                System.out.print("Direccion: ");
                direccion = entrada.nextLine();
                System.out.print("Telefono: ");
                telefono = entrada.nextLine();
                System.out.print("Correo electronico: ");
                correoElectronico = entrada.nextLine();
                idUsuario++;
                Usuario usuario = new Usuario(idUsuario, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, genero, direccion, telefono, correoElectronico);
                System.out.println("\n EL USUARIO FUE CREADO EXITOSAMENTE");
                entrada.nextLine();
                break;

                case 2:
                System.out.print("\nIngrese el título o autor del libro a buscar: ");
                entrada.nextLine();
                String busqueda = entrada.nextLine();
                boolean encontrado = false;

                Libro[] libros = {libro1, libro2, libro3, libro4, libro5};


                for (int i = 0; i < libros.length; i++) {
                    if (busqueda.equals(libros[i].getTitulo())) {
                    System.out.println(libros[i].toString());
                    break;
                    }
                }

                entrada.nextLine();

            }
        }while(opcion != 5);





        entrada.close();
        
    }
}
