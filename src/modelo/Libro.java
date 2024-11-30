package modelo;

import java.time.LocalDate;

public class Libro{
    private int id;
    private String titulo;
    private String autor;
    private String editorial;
    private LocalDate fechaPublicacion;
    public Usuario reservaUsuario;

    public Libro(int id, String titulo, String autor, String editorial, String fechaPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.fechaPublicacion = LocalDate.parse(fechaPublicacion);
        this.reservaUsuario = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Usuario getReservaUsuario(){
        return reservaUsuario;
    }

    public void setReservaUsuario(Usuario usuario){
        this.reservaUsuario = usuario;
    }

    @Override
    public String toString() {
        return "\nId: " + id + "\nTitulo: " + titulo + "\nAutor: " + autor + "\nEditorial: " + editorial
                + "\nFechaPublicacion: " + fechaPublicacion;
    }
}
