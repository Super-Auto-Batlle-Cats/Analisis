package Pagos;

public class AmericanExpress extends FormasDePago{

	public AmericanExpress(String nombreDueño, String numeroCelular, String documento, int numeroTarjeta, String fechaVencimiento, int numeroDeSeguridad, int monto, int numeroTransaccion, String pasarela) {
		super(nombreDueño, numeroCelular, documento, numeroTarjeta, fechaVencimiento, numeroDeSeguridad, monto, pasarela);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void registrarPago() {
		// TODO Auto-generated method stub
		
	}

}
