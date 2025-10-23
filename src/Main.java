import java.util.ArrayList;
import java.util.Scanner;

publ1ic class Main {

  // Scanner para todo el programa
  private static Scanner entrada = new Scanner(System.in);

  public static void main(String[] args) {

    int opcionUsuario;
    // Inicializar catalogo de productos
    ArrayList<Producto> productosDB = CatalogoProductos.inicializarProductos();

    System.out.println("""
        *********************************************************************
        *   Bienvenido - Fragancias Argentinas - Venta perfumes Millanel    *
        *********************************************************************
        """);
    label:
    while (true) {
      System.out.println("""
          *********************************************************************
          *            Ingrese el número equivalente a la opción:             *
          *                   1 - Listar Productos                            *
          *                   2 - Agregar Producto                            *
          *                   3 - Buscar por código                           *
          *                   4 - Buscar por nombre                           *
          *                   5 - Editar producto                             *
          *                   6 - Borrar producto                             *
          *                   0 - SALIR                                       *
          *********************************************************************""");
      System.out.print("         Opción:");
      opcionUsuario = entrada.nextInt();

      // Limpiar el buffer después de nextInt
      entrada.nextLine();  // Importante para evitar problemas en las siguientes lecturas

      switch (opcionUsuario) {
        // Listar el catálogo de productos
        case 1 -> CatalogoProductos.listarCatalogo(productosDB, entrada);
        // Agregar  producto al catálogo
        case 2 -> {
          CatalogoProductos.agregarProducto(productosDB, entrada);
          System.out.println("Agregar ...");
          System.out.println("Funcionalidad en progreso...");
        }
        // Buscar por código
        case 3 -> System.out.println("Buscar por código..... Funcionalidad en progreso...");
        // Buscar por nombre
        case 4 -> System.out.println("Buscar por nombre..... Funcionalidad en progreso...");
        // Editar producto
        case 5 -> System.out.println("Editar producto....... Funcionalidad en progreso...");
        // Borrar producto
        case 6 -> System.out.println("Borrar producto....... Funcionalidad en progreso...");
        // Salir
        case 0 -> {
          System.out.println("Gracias por su visita");
          break label; // corta el bucle donde se ejecuta
        }
        // Opción incorrecta
        default -> System.out.println("Opción incorrecta, intente de nuevo");
      }
    }

    limpiarConsola();
  }

  public static void limpiarConsola() {
    // limpia pantalla de la consola
    System.out.println("Pulse ENTER para continuar...:");
    entrada.nextLine();  // Limpiar buffer antes de continuar
    for (int i = 0; i < 20; ++i) {
      System.out.println();
    }
  }

  public static void pausa() {
    System.out.println("Pulse ENTER para continuar...");
    entrada.nextLine();  // Limpiar buffer antes de continuar
    System.out.println();
    System.out.println();
  }
}
