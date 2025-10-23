import java.util.ArrayList;
import java.util.Scanner;

public class CatalogoProductos {

  private static int nuevoId = 1;  // ID del catalogo

  public static ArrayList<Producto> inicializarProductos() {
    ArrayList<Producto> productosDB = new ArrayList<>();

    productoAgregar(productosDB, "01536038", "Eau de parfum pour femme Zahira Candy",
        "100 ml", 39999.99, 5);
    productoAgregar(productosDB, "01536034", "Eau de parfum pour femme Zahira",
        "100 ml", 39999.99, 1);
    productoAgregar(productosDB, "18036030", "Eau de parfum F Magnética by Florencia Peña",
        "100 ml", 26999.99, 3);
    productoAgregar(productosDB, "01557004", "Eau de parfum Love Me",
        "80 ml", 19999.99, 7);
    productoAgregar(productosDB, "01542002", "Eau de parfum Bella Noir",
        "70 ml", 16999.99, 5);
    productoAgregar(productosDB, "01536000", "Eau de parfum Aventura pour femme",
        "50 ml", 16999.99, 4);
    return productosDB;
  }

  // Método para obtener los datos del producto para luego agregarlo a la lista
  public static void agregarProducto(ArrayList<Producto> listaProd, Scanner entrada) {

    // Solicitar datos al usuario
    System.out.print("Ingrese el código del producto: ");
    String codigoProd = entrada.nextLine();

    System.out.print("Ingrese el nombre del producto: ");
    String nombreProd = entrada.nextLine();

    System.out.print("Ingrese el tamaño del producto (ej. 100 ml): ");
    String tamanioProd = entrada.nextLine();

    // Validación para el precio
    double precioProd = 0;
    boolean precioValido = false;
    while (!precioValido) {
      System.out.print("Ingrese el precio del producto: ");
      try {
        precioProd = entrada.nextDouble();
        if (precioProd >= 0) {
          precioValido = true;  // Si el precio es válido y positivo, salimos del bucle
        } else {
          System.out.println("¡Error! El precio debe ser un número positivo.");
        }
      } catch (java.util.InputMismatchException e) {
        System.out.println("¡Error! Ingrese un valor numérico válido para el precio.");
        entrada.nextLine();  // Limpiar el buffer del scanner
      }
    }

    // Validación para el stock
    int stockProd = 0;
    boolean stockValido = false;
    while (!stockValido) {
      System.out.print("Ingrese el stock del producto: ");
      try {
        stockProd = entrada.nextInt();
        if (stockProd > 0) {
          stockValido = true;  // Si el stock es válido y positivo, salimos del bucle
        } else {
          System.out.println("¡Error! El stock debe ser un número positivo.");
        }
      } catch (java.util.InputMismatchException e) {
        System.out.println("¡Error! Ingrese un valor numérico válido para el stock.");
        entrada.nextLine();  // Limpiar el buffer del scanner
      }
    }
    entrada.nextLine();  // Limpiar buffer de la entrada

    // Agregar el nuevo producto a la lista
    productoAgregar(listaProd, codigoProd, nombreProd, tamanioProd, precioProd, stockProd);
    System.out.println("Producto agregado exitosamente.");
  }

  // Método para agregar un producto a la lista de productos y calcula el ID automáticamente
  public static void productoAgregar(ArrayList<Producto> listaProd, String codigoProd,
      String nombreProd, String tamanioProd, double precioProd, int stockProd) {

    Producto nuevoProducto = new Producto(nuevoId, codigoProd, nombreProd, tamanioProd, precioProd,
        stockProd);
    nuevoId = nuevoId + 1;
    listaProd.add(nuevoProducto);
  }

  // Método para eliminar un producto por ID con confirmación
  public static void eliminarProductoPorId(ArrayList<Producto> listaProd, int id, Scanner entrada) {
    Producto productoAEliminar = null;
    String confirmacionEliminar = "";
    boolean respuestaValida = false;

    // Buscar el producto por ID
    for (Producto producto : listaProd) {
      if (producto.getId() == id) {
        productoAEliminar = producto;
        break;
      }
    }

    // Si no se encuentra el producto, mostrar mensaje y salir
    if (productoAEliminar == null) {
      System.out.println("No se encontró un producto con el ID: " + id);
      return;
    }

    // Mostrar mensaje de confirmación
    System.out.println("¿Está seguro de que desea eliminar el producto?");
    System.out.printf("Código: " + productoAEliminar.getCodigo() + " Producto: " +
        productoAEliminar.getNombre());

    while (!respuestaValida) {
      System.out.println("Escriba 'si' para confirmar o 'no' para cancelar.");
      confirmacionEliminar = entrada.nextLine().toLowerCase();

      // Si el usuario confirma, eliminar el producto
      if (confirmacionEliminar.equals("si")) {
        listaProd.remove(productoAEliminar);
        System.out.println(
            "Producto con Código " + productoAEliminar.getCodigo() + " ha sido eliminado.");
        respuestaValida = true;
      } else if (confirmacionEliminar.equals("no")) {
        System.out.println("La eliminación del producto ha sido cancelada.");
        respuestaValida = true;
      } else {
        System.out.println("Opción no válida. Intente nuevamente.");
      }
    }
  }

  // Método para listar el catálogo de productos
  public static void listarCatalogo(ArrayList<Producto> lista, Scanner entrada) {
    if (lista.isEmpty()) {
      System.out.println("El catálogo está vacío.");
      return;
    }
    System.out.printf("%-5s %-12s %-50s %-10s %-15s %-10s\n", "ID", "Código", "Nombre", "Tamaño",
        "Precio", "Stock");
    System.out.println(
        "------------------------------------------------------------------------------------------------------");
    for (Producto producto : lista) {
      System.out.printf("%-5d %-12s %-50s %-10s %-15.2f %-10d\n",
          producto.getId(),
          producto.getCodigo(),
          producto.getNombre(),
          producto.getTamanio(),
          producto.getPrecio(),
          producto.getStock());
    }
    System.out.println(
        "------------------------------------------------------------------------------------------------------");
    // Pausa para que el usuario vea la salida
    pausa(entrada);
  }

  public static void pausa(Scanner entrada) {
    System.out.println("Pulse ENTER para continuar...");
    entrada.nextLine();
    System.out.println();
    System.out.println();
  }
}
