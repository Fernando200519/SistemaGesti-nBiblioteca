package servicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Usuario;

public class GestorUsuarios {

    static Scanner entrada = new Scanner(System.in);

    private ArrayList<Usuario> usuarios;

    public GestorUsuarios(){
        usuarios = new ArrayList<>();
    }

    public void registrarUsuario(int idUsuario){
        String nombre, apellidoPaterno, apellidoMaterno,direccion, correoElectronico;
        LocalDate fechaNacimiento;
        System.out.print("\nNombre: ");
        nombre = entrada.nextLine();
        System.out.print("Apellido Paterno: ");
        apellidoPaterno = entrada.nextLine();
        System.out.print("Apellido Materno: ");
        apellidoMaterno = entrada.nextLine();
        System.out.print("Fecha de nacimiento(yyyy-mm-dd): ");
        String input = entrada.nextLine();
        fechaNacimiento = LocalDate.parse(input);
        System.out.print("Direccion: ");
        direccion = entrada.nextLine();
        System.out.print("Correo electronico: ");
        correoElectronico = entrada.nextLine();
        Usuario usuario = new Usuario(idUsuario, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, direccion, correoElectronico);
        addUsuario(usuario);
    }

    public void addUsuario(Usuario usu){
        usuarios.add(usu);
        System.out.println("\nUSUARIO REGISTRADO CON EXITO");
        System.out.println();
        entrada.nextLine();
    }

    public void mostrarUsuarios(){
        if(!(usuarios.isEmpty())){
            for(int i = 0; i < usuarios.size(); i++){
                System.out.println(usuarios.get(i).toString());
            }
        }else{
            System.out.println("\nNO HAY USUARIOS REGISTRADOS");
        }
        System.out.println();
        entrada.nextLine();
    }

    public boolean buscarUsuario(int id){
        for(int i = 0; i < usuarios.size(); i++){
            if(id == usuarios.get(i).getId()){
                return true;
            }
        }
        return false;
    }

    public Usuario getUsuario(int id){
        for(int i = 0; i < usuarios.size(); i++){
            if(id == usuarios.get(i).getId()){
                return usuarios.get(i);
            }
        }
        return null;
    }
}
