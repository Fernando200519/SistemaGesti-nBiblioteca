package servicio;

import modelo.Libro;
import java.util.Scanner;

public class GestorLibros {

    static Scanner entrada = new Scanner(System.in);

    private Libro[] libros;

    public GestorLibros(Libro[] libros) {
        this.libros = libros;
    }

    public void mostrarLibros() {
        System.out.println("\nLIBROS:");
        for (Libro libro : libros) {
            System.out.println(libro.toString());
        }
        System.out.println();
        entrada.nextLine();
    }

    public void prestarLibro(GestorUsuarios arrayUsuarios, Libro[] libros){
        System.out.print("Digite el ID del usuario: ");
        int identificadorUsuario = entrada.nextInt();
        entrada.nextLine();

        if(arrayUsuarios.buscarUsuario(identificadorUsuario)){
            int identificadorLibro = buscarLibro(libros);

            if(identificadorLibro == -1){
                System.out.println("\nNO SE ENCONTRO EL LIBRO");
                entrada.nextLine();
                return;
            }
            
            if(libros[identificadorLibro].reservaUsuario == null){
                libros[identificadorLibro].setReservaUsuario(arrayUsuarios.getUsuario(identificadorUsuario));
                System.out.println("\nPRESTAMO EXITOSO: " + libros[identificadorLibro].getTitulo());
                entrada.nextLine();
            }else{
                if(!(libros[identificadorLibro].reservaUsuario == null)){
                    System.out.println("\nEL LIBRO YA ESTA APARTADO");
                    entrada.nextLine();
                    return;
                }
            }

        }else{
            System.out.println("\nNO SE ENCONTRO AL USUARIO");
            entrada.nextLine();
            return;
        }
    }

    public void devolverLibro(GestorUsuarios arrayUsuarios, Libro[] libros) {
        System.out.print("Digite el ID del usuario: ");
        int identificadorUsuario = entrada.nextInt();
        entrada.nextLine();
        if(arrayUsuarios.buscarUsuario(identificadorUsuario)){
            int identificadorLibro = buscarLibro(libros);

            if(identificadorLibro == -1){
                System.out.println("\nNO SE ENCONTRO EL LIBRO");
                entrada.nextLine();
                return;
            }

            if(!(libros[identificadorLibro].reservaUsuario == null) && (identificadorLibro != -1)){
                libros[identificadorLibro].reservaUsuario = null;
                System.out.println("\nSE DEVOLVIÓ EL LIBRO: " + libros[identificadorLibro].getTitulo());
                entrada.nextLine();
                return;
            }else{
                System.out.println("\nEL LIBRO NO EXISTE");
                entrada.nextLine();
                return;
            }

        }else{
            System.out.println("\nNO SE ENCONTRO AL USUARIO");
            entrada.nextLine();
            return;
        }
    }

    public int buscarLibro(Libro[] libros){
        System.out.print("Ingrese el ID del libro: ");
        int busquedaID = entrada.nextInt();
        entrada.nextLine();

        for (int i = 0; i < libros.length; i++) {
            if (busquedaID == (libros[i].getId())) {
                return i;
            }
        }
        return -1;
    }
}