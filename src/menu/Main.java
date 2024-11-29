package menu;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Libro;
import modelo.Usuario;
import servicio.GestorUsuarios;

import java.time.LocalDate;

public class Main {

    static Scanner entrada = new Scanner(System.in);
    static GestorUsuarios arrayUsuarios = new GestorUsuarios();

    static Libro libro1 = new Libro(1, "Cien años de soledad", "Gabriel Garcia Marquez", "Editorial Sudamericana", "1967-05-30");
    static Libro libro2 = new Libro(2, "1984", "George Orwell", "Secker & Warcurg", "1949-06-08");
    static Libro libro3 = new Libro(3, "El principito", "Antoine de Saint-Exupery", "Reynal & Hitchcock", "1943-04-06");
    static Libro libro4 = new Libro(4, "Orgullo y prejuicio", "Jane Austen", "T. Egerton", "1813-01-28");
    static Libro libro5 = new Libro(5, "Don Quijote de la Mancha", "Miguel de Cervantes", "Francisco de Robles", "1605-01-16");
    public static void main(String[] args){
        
        System.out.println("\nBIENVENIDO AL SISTEMA DE GESTION DE LA BIBLIOTECA");
        int opcion;
        int idUsuario = 1;

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
                registrarUsuario(idUsuario);
                idUsuario++;
                entrada.nextLine();
                System.out.print("Desea la lista de los usuarios resgistrados(s/n): ");
                char band = entrada.nextLine().charAt(0);
                if(band == 's' || band == 'S'){
                    arrayUsuarios.mostrarUsuarios();
                }
                break;



                case 2:
                if(!buscarLibro()){
                    System.out.println("NO SE ENCONTRO EL LIBRO");
                }
                entrada.nextLine();
                break;



                case 3:
                prestarLibro();
                break;

                case 4:
                break;

                case 5:
                break;

            }
        }while(opcion != 5);





        entrada.close();
        
    }

    public static void registrarUsuario(int idUsuario){
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
        Usuario usuario = new Usuario(idUsuario, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, genero, direccion, telefono, correoElectronico);
        arrayUsuarios.addUsuario(usuario);
    }

    public static boolean buscarLibro(){
        System.out.print("\nIngrese el título libro a buscar: ");
        entrada.nextLine();
        String busqueda = entrada.nextLine();

        Libro[] libros = {libro1, libro2, libro3, libro4, libro5};


        for (int i = 0; i < libros.length; i++) {
            if (busqueda.equals(libros[i].getTitulo())) {
                System.out.println(libros[i].toString());
                return true;
            }
        }

        return false;
    }

    public static void prestarLibro(){
        System.out.print("Digite el ID del usuario: ");
        int identificador = entrada.nextInt();
        if(arrayUsuarios.buscarUsuario(identificador)){
            System.out.println("\nENTRO");
        }else{
            System.out.println("NO SE ENCONTRO AL USUARIO");
        }
    }
}
