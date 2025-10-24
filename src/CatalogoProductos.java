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
    double precioProd = 0.0;
    boolean precioValido = false;
    while (!precioValido) {
      System.out.print("Ingrese el precio del producto: ");
      try {
        precioProd = entrada.nextDouble();
        if (precioProd >= 0.0) {
          precioValido = true;  // Si el precio es válido y positivo, salimos del bucle
        } else {
          System.out.println("¡Error! El precio debe ser un número positivo.");
        }
      } catch (java.util.InputMismatchException e) {
        System.out.println("¡Error! Ingrese un valor numérico válido para el precio.");
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

  // Método preparar los parametros de buscueda consulta usuerio
  public static void buscarProducto(ArrayList<Producto> listaProd, Scanner entrada) {
    //ArrayList<Producto> productosFiltrados = new ArrayList<>();
    //Se inicializan las variables con valores falsos
    int idProd = 0;
    String codigoProd = "";
    String nombreProd = "";
    String tamanioProd = "";
    double precioProd = -1.0;
    int stockProd = -1;
    int opcionUsuario;
    label1:
    while (true) {
      System.out.println("""
          **************************************************************************
          *             ¿Como desea buscar? (puede combinar uno o mas):            *
          *                        1 - ID                                          *
          *                        2 - Código                                      *
          *                        3 - Nombre                                      *
          *                        4 - Tamaño                                      *
          *                        5 - Precio                                      *
          *                        6 - Stock                                       *
          *                        0 - No agregar mas y continuar                  *
          **************************************************************************""");
      System.out.print("         Opción:");
      opcionUsuario = entrada.nextInt();
      entrada.nextLine();  // Limpiar el buffer del scanner
      switch (opcionUsuario) {
        // Filtrar por ID
        case 1 -> {
          label2:
          while (true) {
            System.out.print("Ingrese el ID del producto: ");
            idProd = entrada.nextInt();
            entrada.nextLine();   // Limpiar el buffer
            if (idProd >= 0) {
              break label2;
            } else {
              System.out.println("Por favor ingrese un valor numérico válido para el ID.");
            }
          }
        }
        // Filtrar por Código
        case 2 -> {
          System.out.print("Ingrese el Código del producto: ");
          codigoProd = entrada.nextLine();
        }
        // Filtrar por Nombre
        case 3 -> {
          System.out.print("Ingrese el Nombre del producto: ");
          nombreProd = entrada.nextLine();
        }
        // Filtrar por Tamaño
        case 4 -> {
          System.out.print("Ingrese el Tamaño del producto: ");
          tamanioProd = entrada.nextLine();
        }
        // Filtrar por Precio
        case 5 -> {
          label3:
          while (true) {
            System.out.print("Ingrese el Precio del producto: ");
            try {
              precioProd = entrada.nextDouble();
              entrada.nextLine();  // Limpiar el buffer del scanner
              if (precioProd >= 0.0) {
                // entrada.nextLine();  // Limpiar el buffer del scanner
                break label3;
              } else {
                System.out.println("¡Error! El precio debe ser un número positivo.");
              }
            } catch (java.util.InputMismatchException e) {
              System.out.println("¡Error! Ingrese un valor numérico válido para el precio.");
              entrada.nextLine();  // Limpiar el buffer del scanner
            }
          }
        }
        // Filtrar por Stock
        case 6 -> {
          label4:
          while (true) {
            System.out.print("Ingrese el Stock del producto: ");
            stockProd = entrada.nextInt();
            entrada.nextLine();   // Limpiar el buffer
            if (stockProd >= 0) {
              break label4;
            } else {
              System.out.println("Por favor ingrese un valor numérico válido para el Stock.");
            }
          }
        }
        // Salir
        case 0 -> {
          System.out.println("Listado cumpliendo los parametros solicitados");
          break label1; // corta el bucle donde se ejecuta
        }
        // Opción incorrecta
        default -> System.out.println("Opción incorrecta, intente de nuevo");
      }
    }
    System.out.println("*****************************");
    // Mostrar muevo listado con filtos
    CatalogoProductos.productoBuscar(listaProd, idProd, codigoProd, nombreProd, tamanioProd,
        precioProd, stockProd, entrada);
  }

  // Método de busqueda  y filtros y listar
  public static void productoBuscar(ArrayList<Producto> listaProd, int idProd, String
          codigoProd,
      String nombreProd, String tamanioProd, double precioProd, int stockProd, Scanner entrada) {
    ArrayList<Producto> productosFiltrados = new ArrayList<>();
    for (Producto producto : listaProd) {
      boolean coincide = true;
      // Filtrar por id (si se proporciona)
      if (idProd > 0 && producto.getId() != idProd) {
        coincide = false;
      }
      // Filtrar por código (si se proporciona)
      if (!codigoProd.isEmpty() && !producto.getCodigo().toLowerCase()
          .contains(codigoProd.toLowerCase())) {
        coincide = false;
      }
      // Filtrar por nombre (si se proporciona)
      if (!nombreProd.isEmpty() && !producto.getNombre().toLowerCase()
          .contains(nombreProd.toLowerCase())) {
        coincide = false;
      }
      // Filtrar por tamaño (si se proporciona)
      if (!tamanioProd.isEmpty() && !producto.getTamanio().toLowerCase()
          .contains(tamanioProd.toLowerCase())) {
        coincide = false;
      }
      // Filtrar por precio (si se proporciona)
      if (precioProd > 0 && producto.getPrecio() != precioProd) {
        coincide = false;
      }
      // Filtrar por stock (si se proporciona)
      if (stockProd > 0 && producto.getStock() != stockProd) {
        coincide = false;
      }

      // Si el producto cumple con todos los filtros, añadirlo a la lista de productos filtrados
      if (coincide) {
        productosFiltrados.add(producto);
      }
    }
    // Si hay productos que coinciden, mostrar el catálogo filtrado
    if (productosFiltrados.isEmpty()) {
      System.out.println("No se encontraron productos que coincidan con los filtros.");
      pausa(entrada);
    } else {
      CatalogoProductos.listarCatalogo(productosFiltrados, entrada);
    }
  }

  // Método para eliminar un producto por ID con confirmación
  public static void eliminarProductoPorId(ArrayList<Producto> listaProd, Scanner
      entrada) {
    int idProd;
    Producto productoAEliminar = null;
    String confirmacionEliminar = "";
    boolean respuestaValida = false;
    label5:
    while (true) {
      System.out.print("Ingrese el ID del producto: ");
      idProd = entrada.nextInt();
      entrada.nextLine();   // Limpiar el buffer
      if (idProd > 0) {
        break label5;
      } else {
        System.out.println("Por favor ingrese un valor numérico válido para el ID.");
      }
    }

    // Buscar el producto por ID
    for (Producto producto : listaProd) {
      if (producto.getId() == idProd) {
        productoAEliminar = producto;
        break;
      }
    }

    // Si no se encuentra el producto, mostrar mensaje y salir
    if (productoAEliminar == null) {
      System.out.println("No se encontró un producto con el ID: " + idProd);
      return;
    }

    // Mostrar mensaje de confirmación
    System.out.println("¿Está seguro de que desea eliminar el producto?"); //TODO ver esto**********
    System.out.printf("%-5s %-12s %-50s %-10s %-15s %-10s\n", "ID", "Código", "Nombre",
        "Tamaño",
        "Precio", "Stock");
    System.out.println(
        "------------------------------------------------------------------------------------------------------");
    System.out.printf("%-5d %-12s %-50s %-10s %-15.2f %-10d\n",
        productoAEliminar.getId(),
        productoAEliminar.getCodigo(),
        productoAEliminar.getNombre(),
        productoAEliminar.getTamanio(),
        productoAEliminar.getPrecio(),
        productoAEliminar.getStock());
    System.out.println(
        "------------------------------------------------------------------------------------------------------");

    // *******************************************
    // System.out.printf("Código: " + productoAEliminar.getCodigo() + " Producto: " +
    //   productoAEliminar.getNombre());

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
    pausa(entrada);
  }

  // Método para listar el catálogo de productos
  public static void listarCatalogo(ArrayList<Producto> lista, Scanner entrada) {
    if (lista.isEmpty()) {
      System.out.println("El catálogo está vacío.");
      return;
    }
    System.out.printf("%-5s %-12s %-50s %-10s %-15s %-10s\n", "ID", "Código", "Nombre",
        "Tamaño",
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
