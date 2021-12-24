package nachogom.candidato;


import nachogom.etiqueta.Etiqueta;

import java.util.ArrayList;

public class Candidato {
    private int candidatoId;
    private String nombre;
    private String ciudad;
    private String pais;
    private String telefono;
    private String email;
    private boolean movilidad;
    private Presencialidad presencialidad;
    private int userId;
    public ArrayList<Etiqueta> etiquetas;

    public int getCandidatoId() {
        return candidatoId;
    }

    public void setCandidatoId(int candidatoId) {
        this.candidatoId = candidatoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isMovilidad() {
        return movilidad;
    }

    public void setMovilidad(boolean movilidad) {
        this.movilidad = movilidad;
    }

    public Presencialidad getPresencialidad() {
        return presencialidad;
    }

    public void setPresencialidad(Presencialidad presencialidad) {
        this.presencialidad = presencialidad;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ArrayList<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(ArrayList<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Candidato(int candidatoId, String nombre, String ciudad, String pais, String telefono, String email, boolean remoto, Presencialidad presencialidad, int userId, ArrayList<Etiqueta> etiquetas) {
        this.candidatoId = candidatoId;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.telefono = telefono;
        this.email = email;
        this.movilidad = remoto;
        this.presencialidad = presencialidad;
        this.userId = userId;
        this.etiquetas = etiquetas;
    }
}
