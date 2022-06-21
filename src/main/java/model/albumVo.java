package model;


public class albumVo {
    private int idAlbum;
    private String nombreAlbum;
    private String anioPublicacion;
    private Boolean estadoAlbum;

    public albumVo(){

    }

    public albumVo(int idAlbum, String nombreAlbum, String anioPublicacion, Boolean estadoAlbum){
        this.idAlbum = idAlbum;
        this.nombreAlbum = nombreAlbum;
        this.anioPublicacion = anioPublicacion;
        this.estadoAlbum = estadoAlbum;
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public String getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(String anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public Boolean getEstadoAlbum() {
        return estadoAlbum;
    }   

    public void setEstadoAlbum(Boolean estadoAlbum) {
        this.estadoAlbum = estadoAlbum;
    }

  
}
