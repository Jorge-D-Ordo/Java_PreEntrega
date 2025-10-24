import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  // Scanner para todo el programa
  private static Scanner entrada = new Scanner(System.in);

  public static void main(String[] args) {

    int opcionUsuario;
    // Inicializar catalogo de productos
    ArrayList<Producto> productosDB = CatalogoProductos.inicializarProductos();

    System.out.println("""
        **************************************************************************
        *   Bienvenido  -  Fragancias Argentinas  -  Venta perfumes Millanel     *
        **************************************************************************
        """);
    label:
    while (true) {
      System.out.println("""
          **************************************************************************
          *              Ingrese el número equivalente a la opción:                *
          *           1 - Listar Productos           6 - Listar Pedidos            *
          *           2 - Agregar Producto           7 - Crear  Pedido             *
          *           3 - Buscar Producto            8 - Buscar Pedido             *
          *           4 - Editar producto            9 - Modificar Pedido          *
          *           5 - Borrar producto por id    10 - Eliminar  Pedido          *
          *                              0 - SALIR                                 *
          **************************************************************************
                  NOTA: para Borrar busque el id del producto o pedido
                         con las opciones 1 o 3 previamente 
          """);
      System.out.print("         Opción:");
      opcionUsuario = entrada.nextInt();
      entrada.nextLine();  //   Limpiar el buffer Importante para evitar problemas en las siguientes lecturas

      switch (opcionUsuario) {
        // Listar el catálogo de productos
        case 1 -> CatalogoProductos.listarCatalogo(productosDB, entrada);
        // Agregar  producto al catálogo
        case 2 -> CatalogoProductos.agregarProducto(productosDB, entrada);
        // Buscar producto
        case 3 -> CatalogoProductos.buscarProducto(productosDB, entrada);
        // Editar producto
        case 4 -> {
          System.out.println("Editar producto....... Funcionalidad en progreso...");
          pausa();
        }
        // Borrar producto
        case 5 -> CatalogoProductos.eliminarProductoPorId(productosDB, entrada);
        // Listar pedidos
        case 6 -> {
          System.out.println("Listar pedidos....... Funcionalidad en progreso...");
          pausa();
        }
        // Crear un pedido
        case 7 -> {
          System.out.println("Crear pedido....... Funcionalidad en progreso...");
          pausa();
        }
        // Buscar un pedido
        case 8 -> {
          System.out.println("Buscar pedido....... Funcionalidad en progreso...");
          pausa();
        }
        // Modificar un pedido
        case 9 -> {
          System.out.println("Modificar pedido....... Funcionalidad en progreso...");
          pausa();
        }
        // Eliminar un pedido
        case 10 -> {
          System.out.println("Eliminar pedido....... Funcionalidad en progreso...");
          pausa();
        }
        // Salir
        case 0 -> {
          System.out.println("Gracias por su visita");
          break label; // Salir del bucle principal
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
