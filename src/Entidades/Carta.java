package Entidades;
import JuegoNormal.Funciones.FuncionesInicio;

public class Carta {
    public enum Palo{
        Corazon("src/resources/sprites/cartasDefault/CartaCorazon.png"), Diamante("src/resources/sprites/cartasDefault/CartaDiamante.png"), Trebol("src/resources/sprites/cartasDefault/CartaTrebol.png"), Pica("src/resources/sprites/cartasDefault/CartaPica.png");
        public final String imagenDefault;
        public final String imagenDefaultSeleccionada;
        Palo(String imagen){
            imagenDefault = imagen;
            imagenDefaultSeleccionada = imagen;
        }
        public String getImagen(){
            return imagenDefault;
        }
        public String getImagenSeleccionada(){
            return imagenDefaultSeleccionada;
        }
    }
    public enum Valor{
        As(14), Rey(13), Reina(12), Sota(11), Diez(10), Nueve(9), Ocho(8), Siete(7), Seis(6), Cinco(5), Cuatro(4), Tres(3), Dos(2);
        public final int valor;
         Valor(int valor){
            this.valor = valor;
         }
    }
    private final Palo paloCarta;
    private final Valor valorCarta;
    private final String nombreCarta;
    public final String imagenCarta;
    public final String imagenCartaSeleccionada;

    public Carta(Palo palo, Valor valor){
        this.paloCarta = palo;
        this.valorCarta = valor;
        this.imagenCarta = FuncionesInicio.cargarImagenes(this);
        this.imagenCartaSeleccionada = FuncionesInicio.cargarImagenesSeleccion(this);
        this.nombreCarta = valor.toString()+palo.toString();
    }
    public Carta(Carta carta){
        this.paloCarta = carta.getPaloCarta();
        this.valorCarta = carta.getValorCarta();
        this.nombreCarta = carta.getNombreCarta();
        this.imagenCarta = carta.getImagenCarta();
        this.imagenCartaSeleccionada = carta.getImagenCartaSeleccionada();
    }
    public Palo getPaloCarta() {
        return paloCarta;
    }
    public Valor getValorCarta() {
        return valorCarta;
    }
    public String getNombreCarta() {
        return nombreCarta;
    }
    public String getImagenCarta() {return imagenCarta;}
    public String getImagenCartaSeleccionada() {return imagenCartaSeleccionada;}
}
