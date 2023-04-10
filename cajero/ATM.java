





public class ATM {

  
  private boolean usuarioAutenticado; 
  private int numeroCuentaActual; 
  private Pantalla pantalla; 
  private Teclado teclado; 
 private DispensadorEfectivo dispensadorEfectivo; 
 private RanuraDeposito ranuraDeposito; 
 private BaseDatosBanco baseDatosBanco;

private static final int SOLICITUD_SALDO = 1;
 private static final int RETIRO = 2;
 private static final int DEPOSITO = 3;
 private static final int SALIR = 4;
 
public ATM()
{      
      
   usuarioAutenticado = false; 
 numeroCuentaActual = 0;
 pantalla = new Pantalla();
teclado = new Teclado();
 dispensadorEfectivo = new DispensadorEfectivo(); 
 ranuraDeposito = new RanuraDeposito(); 
       baseDatosBanco = new BaseDatosBanco(); 
}

public void run()
{
    while (true)
    {
        while (!usuarioAutenticado)
        {     
            pantalla.mostrarLineaMensaje( "\nBienvenido!" );
        autenticarUsuario(); 
        } 
       realizarTransacciones();
       usuarioAutenticado =  false;
       
       numeroCuentaActual = 0;
       pantalla.mostrarLineaMensaje ("\nGracias! Adios!");
    }
}
private void autenticarUsuario()
{
   pantalla.mostrarMensaje( "\nEscriba su numero de cuenta:" );
int numeroCuenta = teclado.obtenerEntrada();

pantalla.mostrarMensaje("\n Escriba su NIP");
int nip= teclado.obtenerEntrada();

 usuarioAutenticado = 
          baseDatosBanco.autenticarUsuario(numeroCuenta, nip);
    if (usuarioAutenticado)
    { 
        numeroCuentaActual= numeroCuenta;
    }
     else
        pantalla.mostrarLineaMensaje("Numero de cuenta o NIP invalido. Intente de nuevo.");
}
private void realizarTransacciones(){
    
Transaccion transaccionActual = null;
boolean usuarioSalio = false;
while(!usuarioSalio)
{

int seleccionMenuPrincipal = mostrarMenuPrincipal();

switch (seleccionMenuPrincipal)
{

case SOLICITUD_SALDO:
case RETIRO:
case DEPOSITO:

transaccionActual =
 crearTransaccion( seleccionMenuPrincipal );

transaccionActual.ejecutar();
break;
case SALIR:
pantalla.mostrarLineaMensaje("\nCerrando el sistema...");
usuarioSalio = true;
break;
}
}
}

private int mostrarMenuPrincipal()
 {
 pantalla.mostrarLineaMensaje("\nMenu principal:" );
pantalla.mostrarLineaMensaje( "1 - Ver mi saldo" );
 pantalla.mostrarLineaMensaje( "2 - Retirar efectivo" );
 pantalla.mostrarLineaMensaje( "3 - Depositar fondos" );
pantalla.mostrarLineaMensaje( "4 - Salir\n" );
 pantalla.mostrarMensaje( "Escriba una opcion:"  );
 return teclado.obtenerEntrada();
}
 
private Transaccion crearTransaccion (int tipo)
{
Transaccion temp = null;

switch (tipo)
{ 
case SOLICITUD_SALDO:
temp= new SolicitudSaldo( numeroCuentaActual, pantalla, baseDatosBanco);
break;
case RETIRO:
temp = new Retiro (numeroCuentaActual, pantalla, baseDatosBanco, teclado,dispensadorEfectivo);
break;
case DEPOSITO:
temp = new Deposito (numeroCuentaActual, pantalla, baseDatosBanco, teclado, ranuraDeposito);
break;
}
return temp;
}
}






    
    
