/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL LATITUDE 5401
 */
import java.util.Scanner;


public class Teclado {
    private Scanner entrada;
    
public Teclado()  
{
    entrada = new Scanner (System. in);
}
    public int obtenerEntrada()
    {
       return entrada.nextInt();
    }
}
