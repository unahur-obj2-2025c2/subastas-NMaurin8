package ar.edu.unahur.obj2.observer;

public class Subastador {
    private String nombre;
    private Oferta ultimaOfertaRecibida = null;

    

    public Subastador(String nombre) {
        this.nombre = nombre;
    }

    public void realizarOferta(Oferta nuevaOferta, Producto producto){
        producto.agregarOferta(nuevaOferta, this);
    }

    public void notificar(Producto producto){
        ultimaOfertaRecibida = producto.ultimaOferta();
    }

    public String getNombre() {
        return nombre;
    }

    public Oferta getUltimaOfertaRecibida() {
        return ultimaOfertaRecibida;
    }
    

    public void reiniciar(){
        ultimaOfertaRecibida = null;
    }


}
