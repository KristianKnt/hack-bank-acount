
public class TestBanco {

  public static void main(String[] args) {

    // ========================================
    // PASO 1: CREAR LAS CUENTAS
    // ========================================

    CuentaBancaria ana = new CuentaAhorro(
        "AH001",
        "Ana Perez",
        50000,
        "2024-01-15"
    );

    CuentaBancaria luis = new CuentaCorriente(
        "CC001",
        "Luis Gomez",
        20000
    );

    CuentaBancaria tech = new CuentaEmpresarial(
        "EM001",
        "Tech Solutions",
        200000,
        "Tech Solutions",
        "123456789-0"
    );

    CuentaBancaria maria = new CuentaAhorro(
        "AH002",
        "Maria Lopez",
        15000,
        "2024-02-01"
    );


    // ========================================
    // PASO 2: MOSTRAR INFORMACION INICIAL
    // ========================================

    System.out.println("\n===== INFORMACION INICIAL =====");

    ana.mostrarInfo();
    System.out.println();

    luis.mostrarInfo();
    System.out.println();

    tech.mostrarInfo();
    System.out.println();

    maria.mostrarInfo();
    System.out.println();


    // ========================================
    // PASO 3: REALIZAR OPERACIONES
    // ========================================

    System.out.println("\n===== OPERACIONES BANCARIAS =====");

    System.out.println("\n--- Deposito de Ana ---");
    ana.depositar(10000);

    System.out.println("\n--- Retiro de Luis ---");
    luis.retirar(25000);

    System.out.println("\n--- Retiro de Tech Solutions ---");
    tech.retirar(10000);

    System.out.println("\n--- Retiro de Maria ---");
    maria.retirar(20000);


    // ========================================
    // PASO 4: APLICAR INTERESES
    // ========================================

    System.out.println("\n===== APLICACION DE INTERESES =====");

    System.out.println("\n--- Ana ---");
    ana.aplicarInteres();

    System.out.println("\n--- Luis ---");
    luis.aplicarInteres();

    System.out.println("\n--- Tech Solutions ---");
    tech.aplicarInteres();

    System.out.println("\n--- Maria ---");
    maria.aplicarInteres();


    // ========================================
    // PASO 5: MOSTRAR ESTADO FINAL
    // ========================================

    System.out.println("\n===== ESTADO FINAL =====");

    ana.mostrarInfo();
    System.out.println();

    luis.mostrarInfo();
    System.out.println();

    tech.mostrarInfo();
    System.out.println();

    maria.mostrarInfo();
    System.out.println();


    // ========================================
    // PASO 6: GENERAR RESUMEN
    // ========================================

    System.out.println("\n===== RESUMEN DEL BANCO =====");

    int totalCuentas = 4;

    double saldoTotal =
        ana.getSaldo()
            + luis.getSaldo()
            + tech.getSaldo()
            + maria.getSaldo();

    double promedioSaldo = saldoTotal / totalCuentas;

    System.out.println("Total de cuentas: " + totalCuentas);

    System.out.println(
        "Saldo total: $" + String.format("%.2f", saldoTotal)
    );

    System.out.println(
        "Promedio de saldo: $"
            + String.format("%.2f", promedioSaldo)
    );


    // Identificar la cuenta con mayor saldo

    CuentaBancaria cuentaMayor = ana;

    if (luis.getSaldo() > cuentaMayor.getSaldo()) {
      cuentaMayor = luis;
    }

    if (tech.getSaldo() > cuentaMayor.getSaldo()) {
      cuentaMayor = tech;
    }

    if (maria.getSaldo() > cuentaMayor.getSaldo()) {
      cuentaMayor = maria;
    }

    System.out.println("\nCuenta con mayor saldo:");

    System.out.println(
        "Numero de cuenta: " + cuentaMayor.getNumeroCuenta()
    );

    System.out.println(
        "Titular: " + cuentaMayor.getTitular()
    );

    System.out.println(
        "Saldo: $" + String.format("%.2f", cuentaMayor.getSaldo())
    );
  }
}
