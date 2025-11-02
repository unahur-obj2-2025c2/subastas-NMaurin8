package ar.edu.unahur.obj2.observer;

import java.util.ArrayList;
import java.util.List;

public class Producto {
    List<Oferta>ofertasRecibidas = new ArrayList<>();
    List<Subastador>subastadores = new ArrayList<>();

    public void agregarSubastador(Subastador subastador){
        subastadores.add(subastador);
    }

    public void agregarOferta(Oferta nuevaOferta, Subastador subastador) {
        this.estaEnSubastadores(subastador);
        if(subastador.getUltimaOfertaRecibida() == null || nuevaOferta.getValor() == subastador.getUltimaOfertaRecibida().getValor() +10){
            ofertasRecibidas.add(nuevaOferta);
            this.notificar();
        }
    }

    private void estaEnSubastadores(Subastador subastador){
        if(!subastadores.contains(subastador)){
            throw new ExcepcionParticipa("El subastador no participa en la subasta de este producto");
        }
    }
    

    public Oferta ultimaOferta() {
        return ofertasRecibidas.isEmpty() ? null : ofertasRecibidas.get(ofertasRecibidas.size() - 1);
    }
    
    public void notificar(){
        subastadores.forEach(subastador -> subastador.notificar(this));
    }

    public void reiniciar(){
        subastadores.clear();
        ofertasRecibidas.clear();
    }

    public List<Oferta> getOfertasRecibidas() {
        return ofertasRecibidas;
    }

    public List<Subastador> getSubastadores() {
        return subastadores;
    }

    




}
