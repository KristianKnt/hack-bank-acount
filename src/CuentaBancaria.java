public abstract class CuentaBancaria {
  private String numeroCuenta;
  private String titular;
  private double saldo;
  private double tasaInteres;

  public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial, double tasaInteres){
    if(saldoInicial<0){
      throw new IllegalArgumentException(
          "El saldo inicial no puede ser negativo"
      );
    }
    if(tasaInteres <0){
      throw new IllegalArgumentException(
          "El interes no puede ser negativo");
    }

    this.numeroCuenta = numeroCuenta;
    this.titular= titular;
    this.saldo = saldoInicial;
    this.tasaInteres = tasaInteres;
  }

  public String getNumeroCuenta() {
    return numeroCuenta;
  }

  public String getTitular() {
    return titular;
  }

  public double getSaldo() {
    return saldo;
  }

  public double getTasaInteres() {
    return tasaInteres;
  }

  public double depositar(double monto){
    if(monto <= 0){
      throw new IllegalArgumentException(
          "El monto no puede ser negativo");
    }
    this.saldo = this.saldo + monto;
    System.out.println("Monto depositado :"+ monto);
    System.out.println("Nuevo Salo :"+ this.saldo);

    return this.saldo;
  }

  public abstract void retirar(double monto);

  public double aplicarInteres(){
    double interes = this.saldo * (this.tasaInteres / 100);
    System.out.println("El interes generado es : "+ interes);
    this.saldo = this.saldo + interes;
    return interes;
  }

  public void mostrarInfo(){
    System.out.println("Su numero de cuenta :"+numeroCuenta);
    System.out.println("Titular : "+titular);
    System.out.println("Saldo actual :"+ saldo);
    System.out.println("Interes actual :"+ tasaInteres);
  }

}
