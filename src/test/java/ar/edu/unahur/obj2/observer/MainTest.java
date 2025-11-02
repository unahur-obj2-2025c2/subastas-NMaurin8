package ar.edu.unahur.obj2.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {
    Producto producto = new Producto();

    Subastador gonzager = new Subastador("gonzager");
    Subastador diazdan = new Subastador("diazdan");
    Subastador martomau = new Subastador("martomau");

    
    
    
    @BeforeEach
    void initialize(){
        producto.reiniciar();

        gonzager.reiniciar();
        diazdan.reiniciar();
        martomau.reiniciar();

        producto.agregarSubastador(gonzager);
        producto.agregarSubastador(martomau);
    }

    void escenario1(){
        martomau.realizarOferta(new Oferta(martomau, 10.0), producto);
        gonzager.realizarOferta(new Oferta(gonzager, 20.0), producto);
        martomau.realizarOferta(new Oferta(martomau, 30.0), producto);
    }

    @Test
    void getNombre_devuelveNombre(){
        assertEquals("gonzager", gonzager.getNombre());
    }

    
    @Test
    void dadoElEscenario1_GonzagerYMartomauRecibenCorrectamenteLaUltimaOferta(){
        this.escenario1();

        assertEquals(30.0, martomau.getUltimaOfertaRecibida().getValor());
        assertEquals(30.0, gonzager.getUltimaOfertaRecibida().getValor());
    }

    @Test
    void dadoElEscenario1_SeVerificaQueLaUltimaOfertaPerteneceAlSubastadorMartomau(){
        this.escenario1();

        assertEquals("martomau", producto.ultimaOferta().getSubastador().getNombre());

    }
    
    @Test
    void dadoElEscenario1_SeVerificaQueElValorDeLaUltimaOfertaSea30(){
        this.escenario1();
        assertEquals(30, producto.ultimaOferta().getValor());
    }

    @Test
    void dadoElEscenario1_SeVerificaQueLaCantidadDeOfertasRecibidasSean3(){
        this.escenario1();
        assertEquals(3, producto.getOfertasRecibidas().size());
    }

    @Test
    void alInternarAgregarUnaOfertaDeDiazdan_SeLanzaLaExepcionCorrespondiente(){
        

        assertThrows(ExcepcionParticipa.class, () -> {
            producto.agregarOferta(new Oferta(diazdan, 30.0), diazdan);
        });
    }
        
}
