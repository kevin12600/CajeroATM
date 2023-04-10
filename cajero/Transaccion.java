/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL LATITUDE 5401
 */
public abstract class Transaccion {
    private int numeroCuenta;
    private Pantalla pantalla;
    private BaseDatosBanco baseDatosBanco;
    
    public Transaccion (int numeroCuentaUsuario, Pantalla pantallaATM, BaseDatosBanco baseDatosBancoATM)
    {
      numeroCuenta = numeroCuentaUsuario;
 pantalla = pantallaATM;
 baseDatosBanco = baseDatosBancoATM;  
    }
   public int obtenerNumeroCuenta() 
   {
       return numeroCuenta;
   }
   public Pantalla obtenerPantalla() 
   {
       return pantalla;
   }
   public BaseDatosBanco obtenerBaseDatosBanco()
   {
       return baseDatosBanco;
   }
   abstract public void ejecutar();
}
