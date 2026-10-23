public class CuentaEmpresarial extends CuentaBancaria {
    private String nombreEmpresa;
    private String RUT;
    private double comisionRetiro = 2000.0;

    public CuentaEmpresarial(String numeroCuenta, String titular, double saldoInicial, String nombreEmpresa,
            String RUT) {
        super(numeroCuenta, titular, saldoInicial, 1.5);

        if (saldoInicial < 100000.0) {
            throw new IllegalArgumentException("El saldo inicial minimo debe ser de $100.000");
        }

        this.nombreEmpresa = nombreEmpresa;
        this.RUT = RUT;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getRUT() {
        return RUT;
    }

    public double getComisionRetiro() {
        return comisionRetiro;
    }

    @Override
    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("El monto a retirar debe ser mayor a 0");
            return;
        }

        double total = monto + comisionRetiro;

        if (total <= getSaldo()) {
            double nuevoSaldo = getSaldo() - total;
            actualizarSaldo(nuevoSaldo);
            System.out.println("Retiro exitoso: $" + monto);
            System.out.println("Comision de retiro: $" + comisionRetiro);
            System.out.println("Nuevo saldo: $" + getSaldo());
        } else {
            System.out.println("Saldo insuficiente para cubrir el retiro y la comision");
        }
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Nombre Empresa: " + nombreEmpresa);
        System.out.println("RUT: " + RUT);
        System.out.println("Comision por retiro: $" + comisionRetiro);
    }
}
