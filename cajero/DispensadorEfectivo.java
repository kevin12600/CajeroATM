/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL LATITUDE 5401
 */
public class DispensadorEfectivo {
    private final static int CUENTA_INICIAL = 500;
    private int cuenta;
    
    public DispensadorEfectivo()
    {
        cuenta = CUENTA_INICIAL;
    }
    public void dispensadorEfectivo(int monto)
    {
        int billetesRequeridos = monto / 20;
        cuenta -= billetesRequeridos;
    }
    public boolean haySuficienteEfectivoDisponible (int monto)
    {
        int billetesRequeridos = monto/20;
        if (cuenta >= billetesRequeridos)
            return true;
        else 
            return false;
    }

    void dispensarEfectivo(int monto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

