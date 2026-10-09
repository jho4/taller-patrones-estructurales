package adaptador;

public class AdaptadorPago implements ProcesadorPago {
    private ServicioPagoExterno servicioPagoExterno;

    public AdaptadorPago(ServicioPagoExterno servicioPagoExterno) {
        this.servicioPagoExterno = servicioPagoExterno;
    }

    @Override
    public void procesarPago(double monto) {
        System.out.println("[Adaptador] Traduciendo procesarPago() a realizarTransaccion()...");
        servicioPagoExterno.realizarTransaccion(monto);
    }
}