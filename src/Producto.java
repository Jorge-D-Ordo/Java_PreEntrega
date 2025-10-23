public class Producto {

  private int id;
  private String codigo;
  private String nombre;
  private String tamanio;
  private double precio;
  private int stock;

  //metodo constructor
  public Producto(int idProd, String codProd, String nombreProd, String tamanioProd,
      double precioProd,
      int stockProd) {
    this.id = idProd;
    this.codigo = codProd;
    this.nombre = nombreProd;
    this.tamanio = tamanioProd;
    this.precio = precioProd;
    this.stock = stockProd;
  }

  // Getters y Setters
  public int getId() {
    return id;
  }

  public void setId(int Id) {
    this.id = Id;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getTamanio() {
    return tamanio;
  }

  public void setTamanio(String tamanio) {
    this.tamanio = tamanio;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    if (precio >= 0) {
      this.precio = precio;
    }
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    if (stock >= 0) {
      this.stock = stock;
    }
  }
}


