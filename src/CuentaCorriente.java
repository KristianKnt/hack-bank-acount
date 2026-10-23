public class CuentaCorriente extends CuentaBancaria{
  private  double limiteSobregiro;
  private  double porcentajeComisionSobregiro;

  public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial, double limiteSobregiro, double porcentajeComisionSobregiro) {
    super(numeroCuenta, titular, saldoInicial, 0.0);
    this.limiteSobregiro = limiteSobregiro;
    this.porcentajeComisionSobregiro = porcentajeComisionSobregiro;
  }

  public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial){
    this(numeroCuenta, titular, saldoInicial, 50000, 5.0);
  }


  @Override
  public void retirar(double monto) {
    // aca vamos
  }
}
