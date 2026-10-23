public class TestBanco{

  public static void main(String[] args) {
    CuentaBancaria ana = new CuentaAhorro(
        "AH001", "Ana Perez", 50000, "2024-01-15"
    );

    CuentaBancaria luis = new CuentaCorriente(
        "CC001", "Luis Gomez", 20000
    );

    CuentaBancaria tech = new CuentaEmpresarial(
        "EM001", "Tech Solutions", 200000,
        "Tech Solutions", "123456789-0"
    );

    CuentaBancaria maria = new CuentaAhorro(
        "AH002", "Maria Lopez", 15000, "2024-02-01"
    );

    luis.retirar(25000);
  }
}
