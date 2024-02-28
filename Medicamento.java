/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


/**
 *
 * @author andre
 */
public class Medicamento {
    Scanner datos = new Scanner(System.in);
    
    private String codigo_medicamento;
    private String nombre_medicamento;
    private int costo_medicamento;
    private int precio_medicamento;
    private int unidades_vendidas;
    private int unidades_disponibles;
    private int fecha_caducidad;
    private int numero_lote;
    private int vigencia;

    public Medicamento() {
        this.codigo_medicamento = "ABC";
        this.nombre_medicamento = "Minoxidil";
        this.costo_medicamento = 10;
        this.precio_medicamento = 20;
        this.unidades_vendidas = 2;
        this.unidades_disponibles = 5;
        this.fecha_caducidad = 012002;
        this.numero_lote = 5;
        this.vigencia = 1;
    }

    public Medicamento(String codigo_medicamento, String nombre_medicamento, int costo_medicamento, int precio_medicamento, int unidades_vendidas, int unidades_disponibles, int fecha_caducidad, int numero_lote, int vigencia) {
        this.codigo_medicamento = codigo_medicamento;
        this.nombre_medicamento = nombre_medicamento;
        this.costo_medicamento = costo_medicamento;
        this.precio_medicamento = precio_medicamento;
        this.unidades_vendidas = unidades_vendidas;
        this.unidades_disponibles = unidades_disponibles;
        this.fecha_caducidad = fecha_caducidad;
        this.numero_lote = numero_lote;
        this.vigencia = vigencia;
    }

    //// GETTERS & SETTERS /////
    public String getCodigo_medicamento() {
        return codigo_medicamento;
    }

    public void setCodigo_medicamento(String codigo_medicamento) {
        this.codigo_medicamento = codigo_medicamento;
    }

    public String getNombre_medicamento() {
        return nombre_medicamento;
    }

    public void setNombre_medicamento(String nombre_medicamento) {
        this.nombre_medicamento = nombre_medicamento;
    }

    public int getCosto_medicamento() {
        return costo_medicamento;
    }

    public void setCosto_medicamento(int costo_medicamento) {
        this.costo_medicamento = costo_medicamento;
    }

    public int getPrecio_medicamento() {
        return precio_medicamento;
    }

    public void setPrecio_medicamento(int precio_medicamento) {
        this.precio_medicamento = precio_medicamento;
    }

    public int getUnidades_vendidas() {
        return unidades_vendidas;
    }

    public void setUnidades_vendidas(int unidades_vendidas) {
        this.unidades_vendidas = unidades_vendidas;
    }

    public int getUnidades_disponibles() {
        return unidades_disponibles;
    }

    public void setUnidades_disponibles(int unidades_disponibles) {
        this.unidades_disponibles = unidades_disponibles;
    }

    public int getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(int fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    public int getNumero_lote() {
        return numero_lote;
    }

    public void setNumero_lote(int numero_lote) {
        this.numero_lote = numero_lote;
    }

    public int getVigencia() {
        return vigencia;
    }

    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }
    
    
    //FALTA AGREGAR LOS SETTERS Y GETTERS PARA ASIGNAR LOS DATOS
    public void leerDatos(){
        int op = 0;
        while(op != 1){ 
            System.out.println("Introduce el nombre del medicamento");
            String nombre = datos.nextLine();
            if(validarNombre(nombre)){
                setNombre_medicamento(nombre);
                op = 1;
            } else {
                System.out.println("El nombre del medicamento no es valido");
            }
       }
        
       limpiarPantalla();
       op = 0;
       
       while(op != 1){
           System.out.println("Introduce el codigo del medicamento");
           String codigo_medicamento = datos.nextLine();
           if(validarCodigo(codigo_medicamento)) {
           setCodigo_medicamento(codigo_medicamento);
           op = 1;    
           } else {
               System.out.println("El codigo del medicamento no es valido");
           }
       }
       
       limpiarPantalla();
       op = 0;
       
       //// ABAJO FALTA VALIDADOR DE COSTO EN ENTEROS
       while(op != 1){
           System.out.println("Introduce el costo del medicamento");
           int costo_medicamento = datos.nextInt();
           String cadena = String.valueOf(costo_medicamento);
           if (validarCosto(cadena)){
               op = 1;
           } else {
               System.out.println("El costo es invalido");
           }
       }
       
       limpiarPantalla();
       op = 0;
       
       while(op != 1){
           System.out.println("Introduce el precio del medicamento");
           int precio_medicamento = datos.nextInt();
           if(validadorPrecio(precio_medicamento, costo_medicamento)){
               op = 1;
           } else {
               System.out.println("Introduce un precio valido");
           }
       }
       
       limpiarPantalla();
       op = 0;
       
    while(op != 1){
        System.out.println("Introduce la cantidad de unidades vendidas");
        int cantidad_vendida = datos.nextInt();
}
    
    System.out.println("Introduce la cantidad de unidades en existencia");
    int unidades_existencia = datos.nextInt();
    
    
       }
    
        
       
    /////////// VALIDADORES ///////////
    
    /// VALIDADOR DEL NOMBRE ///
    public static boolean validarNombre(String texto) {
        String patron = "^[a-zA-Z ]*$";
    return texto.matches(patron);
    }
    
    /// VALIDADOR DEL PRECIO ///
    public boolean validadorPrecio(double precio, double costo){
        double dato = precio - costo;
        double porcentaje = 20 * costo / 100;
        if(porcentaje >= dato){
            return false;
        } else {
            return true;
        }
    }
    
    /// VALIDADOR DEL CODIGO ///
        public static boolean validarCodigo(String codigo) {
        String patron = "^[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(codigo);
        return matcher.matches();
    }
    
    
    
    /// VALIDADOR DEL COSTO ///  
    public static boolean validarCosto(String cadena) {
        // Utilizando una expresión regular para extraer solo el número
        String patron = "[0-9]+";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(cadena);

        if (matcher.find()) {
            // Extraer el número encontrado en la cadena
            String numeroEncontrado = matcher.group();
            
            // El número es válido si se puede convertir a entero
            try {
                Integer.parseInt(numeroEncontrado);
                return true;
            } catch (NumberFormatException e) {
                // Manejar la excepción en caso de que no se pueda convertir a entero
                System.out.println("No se puede convertir a entero: " + e.getMessage());
            }
        }

        // Retornar false si no se encuentra un número o no es válido
        return false;
    }
    
    
   
    public void limpiarPantalla(){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
    
    
    /// PRIMER MENÚ
    public int Menu1(){
    int op = 0;
    
    do {
        System.out.println("1. Usar valores predeterminados");
        System.out.println("2. Introducir valores."); 
        System.out.println("Escoge alguna de las opciones anteriores.");
        op = datos.nextInt();
    } while(op != 1 && op != 2);
    return op;
    }
    
    public void Menu2(){
       int op = 0;
       int mood = Menu1();
       System.out.println("**********************************");
       System.out.println("1. Cambiar valores del medicamento");
       System.out.println("2. Consultar precios a pagar");
       System.out.println("3. Determinar si el medicamento esta vencido");
       System.out.println("4. Retirar Lote");
       System.out.println("5. Productos con descuento de 30%");
       System.out.println("6. Reponer Inventario");
       System.out.println("7. Mostrar caracteristicas del medicamento");
       System.out.println("8. Salir");
       op = datos.nextInt();
       
       switch(op) {   
           case 1: leerDatos();
           case 6: reponerInventario(); break;
           case 7: mostrarInformacion(); break;
       }
    }
    
    public void mostrarInformacion()
    {
        System.out.println("DATOS DEL MEDICAMENTO");
        System.out.println("Codigo "+ getCodigo_medicamento());
        System.out.println("Nombre "+getNombre_medicamento());
        System.out.println("Costo "+getCosto_medicamento());
        System.out.println("Precio "+getPrecio_medicamento());
        System.out.println("Unidades vendidades "+getUnidades_vendidas());
        System.out.println("Unidades disponibles "+getUnidades_disponibles());
        System.out.println("Fecha de caducidad "+getFecha_caducidad());
        System.out.println("Vigencia "+getVigencia());
    }
    
    public void precioAPagar(int porcentaje){
        int op = 0, monto;
        int costo;
        while(op != 1){
            System.out.println("Que porcentaje quieres ganarle al producto?");
            System.out.println("Este porcentaje debe ser un numero del 20 al 100");
            porcentaje = datos.nextInt();
            if (porcentaje >= 20 && porcentaje <= 100) {
                System.out.println("El número " + porcentaje + " está dentro del rango especificado.");
                op = 1;
            } else {
                System.out.println("El número " + porcentaje + " está fuera del rango especificado.");
            }
        }   
        costo = getCosto_medicamento();
        monto = costo * porcentaje / 100;
        monto = costo + monto; 
        setPrecio_medicamento(monto);
        System.out.println("El costo del medicamento es "+ getCosto_medicamento());
        System.out.println("el precio de venta publico es  "+ getPrecio_medicamento());
    }
    
    public void reponerInventario(){
        if (unidades_disponibles < 5){
            JOptionPane.showMessageDialog(null, "La cantidad de unidades disponibles es inferior a 5");
        } else {
            JOptionPane.showMessageDialog(null, "La cantidad de unidades disponibles es superior a 5");
        }
    }
    
    
   
    
        public static void colocarOferta(String fecha) {
        int mes = Integer.parseInt(fecha.substring(0, 2));
        int año = Integer.parseInt(fecha.substring(2));
        
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaVencimiento = LocalDate.of(año, mes, 1);
        
        System.out.println("Fecha de vencimiento: " + fechaVencimiento);
        System.out.println("Fecha actual: " + fechaActual);

        LocalDate fechaLimite = fechaActual.plusMonths(3);

        if (fechaVencimiento.isBefore(fechaActual)) {
            System.out.println("El producto está vencido.");
        } else if (fechaVencimiento.isBefore(fechaLimite)) {
            System.out.println("El producto está próximo a vencer dentro de 3 meses o menos.");
            System.out.println("Sugerencia: Aplicar un descuento al producto.");
        } else {
            System.out.println("El producto no está próximo a vencer.");
        }
    }
    
  
      public void retirarLote(){
          int op = 0;
          int vigenciax = getVigencia();
          System.out.println(vigenciax);
          
          System.out.println("La vigencia del producto indica que ya fue retirado");
          System.out.println("Deseas retirar los productos del lote?");
          op = datos.nextInt();
      }      
    
     public static boolean determinarVencido(String fecha) {
           // Verificar que la cadena tenga exactamente 6 dígitos
        if (fecha.length() != 6) {
            return false;
        }

        try {
            // Obtener el mes y el año como enteros
            int mes = Integer.parseInt(fecha.substring(0, 2));
            int año = Integer.parseInt(fecha.substring(2));

            // Verificar que el mes esté en el rango de 1 a 12 y el año esté entre 2000 y 2100
            if (mes >= 1 && mes <= 12 && año >= 2000 && año <= 2100) {
                // Obtener la fecha actual
                LocalDate fechaActual = LocalDate.now();

                // Crear una fecha de vencimiento
                LocalDate fechaVencimiento = LocalDate.of(año, mes, 1);

                // Comparar la fecha de vencimiento con la fecha actual
                if (fechaVencimiento.isBefore(fechaActual)) {
                    System.out.println("El producto está vencido.");
                } else {
                    System.out.println("El producto no está vencido.");
                }

                return true;
            } else {
                System.out.println("Fecha de vencimiento no válida.");
                return false;
            }
        } catch (NumberFormatException e) {
            // Manejar la excepción en caso de que no se puedan convertir los dígitos a enteros
            System.out.println("Error al convertir la fecha: " + e.getMessage());
            return false;
        }

     }
}