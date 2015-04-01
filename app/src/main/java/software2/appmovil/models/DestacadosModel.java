package software2.appmovil.models;

/**
 * Created by Gerson de Leon on 23/03/2015.
 */
public class DestacadosModel {

    private int id;
    private String nombreEvento;
    private int estrellas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }
}
