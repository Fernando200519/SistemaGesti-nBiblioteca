package servicio;

import java.util.ArrayList;

import modelo.Usuario;

public class GestorUsuarios {
    private ArrayList<Usuario> usuarios;

    public GestorUsuarios(){
        usuarios = new ArrayList<>();
    }

    public void addUsuario(Usuario usu){
        usuarios.add(usu);
        System.out.println("\nUSUARIO REGISTRADO CON EXITO");
    }

    public void mostrarUsuarios(){
        for(int i = 0; i < usuarios.size(); i++){
            System.out.println(usuarios.get(i).toString());
        }
    }

    public boolean buscarUsuario(int id){
        for(int i = 0; i < usuarios.size(); i++){
            if(id == usuarios.get(i).getId()){
                System.out.println(usuarios.get(i).toString());
                return true;
            }
        }
        return false;
    }
}
