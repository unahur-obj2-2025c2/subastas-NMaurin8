package ar.edu.unahur.obj2.observer;

public class Oferta {
    private Subastador subastador;
    private Double valor;
    public Oferta(Subastador subastador, Double valor) {
        this.subastador = subastador;
        this.valor = valor;
    }
    public Subastador getSubastador() {
        return subastador;
    }
    public Double getValor() {
        return valor;
    }
    
}
