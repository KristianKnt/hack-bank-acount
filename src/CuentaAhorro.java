
public class CuentaAhorro extends CuentaBancaria {

    private String fechaApertura;

    public CuentaAhorro(String numeroCuenta, String titular,
                        double saldoInicial, String fechaApertura) {

        super(numeroCuenta, titular, saldoInicial, 2.5);

        if (saldoInicial < 10000) {
            throw new IllegalArgumentException(
                    "El saldo inicial debe ser minimo de $10.000"
            );
        }

        this.fechaApertura = fechaApertura;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void retirar(double monto) {

        if (monto <= 0) {
            System.out.println("El monto debe ser mayor que cero");

        } else if (monto > getSaldo()) {
            System.out.println("Error: saldo insuficiente");

        } else {
            double nuevoSaldo = getSaldo() - monto;

            actualizarSaldo(nuevoSaldo);

            System.out.println("Retiro realizado correctamente");
            System.out.println("Nuevo saldo: " + getSaldo());
        }
    }

    public void mostrarInfo() {

        super.mostrarInfo();

        System.out.println("Fecha de apertura: " + fechaApertura);
    }
}

