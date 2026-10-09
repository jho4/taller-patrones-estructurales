package principal;

import fachada.FachadaCompra;

public class Principal {
    public static void main(String[] args) {
        // Instanciamos la fachada indicando que el usuario tiene permisos (true)
        FachadaCompra fachada = new FachadaCompra(true);

        // Ejecutamos la compra completa desde la interfaz simplificada
        fachada.realizarCompra("Balón de Fútbol Profesional", 85.0);
    }
}