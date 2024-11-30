package menu;

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

    static Libro[] libros = {libro1, libro2, libro3, libro4, libro5};
    public static void main(String[] args){
        
        System.out.println("\nBIENVENIDO AL SISTEMA DE GESTION DE LA BIBLIOTECA");
        int opcion;
        int idUsuario = 1;

        do{
            System.out.println("\n1. Registrar usuario");
            System.out.println("2. Mostrar los usuarios registrados");
            System.out.println("3. Mostrar los libros");
            System.out.println("4. Prestar libro");
            System.out.println("5. Devolver libro");
            System.out.println("6. Salir");
            System.out.print("\nOpcion: ");
            opcion = entrada.nextInt();

            switch (opcion) {

                case 1:
                registrarUsuario(idUsuario);
                idUsuario++;
                entrada.nextLine();
                break;

                case 2:
                arrayUsuarios.mostrarUsuarios();
                entrada.nextLine();
                entrada.nextLine();
                break;

                case 3:
                mostrarLibros();
                entrada.nextLine();
                break;

                case 4:
                prestarLibro();
                break;

                case 5:
                devolverLibro();
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

    public static void mostrarLibros(){
        System.out.println("\nLIBROS: ");
        for(int i = 0; i < libros.length; i++){
            System.out.println(libros[i].toString());
        }
        entrada.nextLine();
    }

    public static boolean buscarLibro(){
        System.out.print("\nIngrese el título del libro a buscar: ");
        entrada.nextLine();
        String busqueda = entrada.nextLine();

        for (int i = 0; i < libros.length; i++) {
            if (busqueda.equals(libros[i].getTitulo())) {
                System.out.println(libros[i].toString());
                return true;
            }
        }

        return false;
    }

    public static int buscarLibroPrestar(){
        System.out.print("\nIngrese el título del libro: ");
        entrada.nextLine();
        String busqueda = entrada.nextLine();

        for (int i = 0; i < libros.length; i++) {
            if (busqueda.equals(libros[i].getTitulo())) {
                int identificadorLibro = libros[i].getId();
                return identificadorLibro;
            }
        }
        return 0;
    }

    public static void prestarLibro(){
        System.out.print("Digite el ID del usuario que requiere el prestamo: ");
        int identificadorUsuario = entrada.nextInt();
        if(arrayUsuarios.buscarUsuario(identificadorUsuario)){
            int identificadorLibro = buscarLibroPrestar();
            if(!(identificadorLibro == 0) && (libros[identificadorLibro].reservaUsuario == null)){
                libros[identificadorLibro].setReservaUsuario(arrayUsuarios.getUsuario(identificadorUsuario));
                System.out.println("\nPRESTAMO EXITOSO");
            }else{
                if(!(libros[identificadorLibro].reservaUsuario == null)){
                    System.out.println("EL LIBRO YA ESTA APARTADO");
                }else{
                    System.out.println("NO SE ENCONTRO EL LIBRO");
                }
            }

        }else{
            System.out.println("NO SE ENCONTRO AL USUARIO");
            return;
        }
    }

    public static void devolverLibro(){
        System.out.print("Digite el ID del usuario que requiere delvolver el libro: ");
        int identificadorUsuario = entrada.nextInt();
        if(arrayUsuarios.buscarUsuario(identificadorUsuario)){
            int identificadorLibro = buscarLibroPrestar();
                if(!(libros[identificadorLibro].reservaUsuario == null) && (identificadorLibro != 0)){
                    libros[identificadorLibro].reservaUsuario = null;
                    System.out.println("SE DEVOLVIO EL LIBRO CORRECTAMENTE");
                }else{
                    System.out.println("EL LIBRO NO EXISTE");
                }

        }else{
            System.out.println("NO SE ENCONTRO AL USUARIO");
            return;
        }
    }
}
