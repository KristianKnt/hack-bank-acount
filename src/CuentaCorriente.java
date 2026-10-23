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
    /**
     * Verificar que el monto no supere saldo + limiteSobregiro.
     * 2. Si el monto es valido, restarlo del saldo.
     * 3. Si el saldo queda en negativo, calcular el monto sobregirado (el valor negativo
     * del saldo) y la comision correspondiente.
     */
    if (monto < 0){
      System.out.println(
          "Error: el monto debe ser mayor que cero."
      );
      return;
    }

    if (monto > getSaldo() + limiteSobregiro) {
      System.out.println(
          "Error: se supera el limite de sobregiro."
      );
      return;
    }

    // Descontar el retiro
    double nuevoSaldo = getSaldo() - monto;
    actualizarSaldo(nuevoSaldo);

    System.out.println("Retiro exitoso.");

    // Calcular comision si hay sobregiro
    if (getSaldo() < 0) {
      double sobregiro = Math.abs(getSaldo());  //   |-50| = 50

      double comision = sobregiro * porcentajeComisionSobregiro / 100.0;

      actualizarSaldo(getSaldo() - comision);

      System.out.println(
          "Comision por sobregiro: $"
              + String.format("%.2f", comision)
      );
    }

    System.out.println(
        "Nuevo saldo: $" + String.format("%.2f", getSaldo())
    );


  }

  @Override
  public void mostrarInfo() {
    super.mostrarInfo();

    System.out.println(
        "Limite de sobregiro: $"
            + String.format("%.2f", limiteSobregiro)
    );

    System.out.println(
        "Comision por sobregiro: "
            + porcentajeComisionSobregiro + "%"
    );
  }

  public double getLimiteSobregiro() {
    return limiteSobregiro;
  }

  public double getPorcentajeComisionSobregiro() {
    return porcentajeComisionSobregiro;
  }
}

