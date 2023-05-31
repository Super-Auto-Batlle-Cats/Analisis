package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class Admin extends Empleado {
	
	public Admin(String login, String password, String area) {
		super(login, password, area);
	}
	
	public void añadirUsuario(String login, String password, String area, int tipo) {
		hotel.añadirUsuario(login, password, area, tipo);
	}

// INICIO TARIFAS ---------------------------------------------
	
	public boolean tarifasCompletas() {
		return TarifasFaltantes().size() == 0;
	}

	public ArrayList<Tarifa> TarifasFaltantes() {
		return hotel.TarifasFaltantes();
	}
	
	public ArrayList<Tarifa> crearTarifa(Date fechaI, Date fechaF, TipoHabitacion tipo, double valor, boolean[] diasValores) {
		return hotel.crearTarifasRango(fechaI, fechaF, tipo, valor, diasValores);
	}
	
// FIN TARIFAS ----------------------------------------------


	public void crearServicioHotel(String nombre, double precio) {
		hotel.crearServicioHotel(nombre, precio);
	}
	
//FIN SERVICIOS HOTEL -----------------------------------------------------------

//INICIO HABITACIONES -----------------------------------------------------------

	public void crearCama(int id, int capacidadCama, boolean aptoParaNiño) {
		hotel.crearCama(id, capacidadCama, aptoParaNiño);
	}
	
	public void crearHabitacion(TipoHabitacion tipo,int id, int capacidad, boolean apto) {
		hotel.crearHabitacion(tipo, id, capacidad, apto);
	}
	
	public void setCaracteristicasHabitacion(String habitacion, int id) {
		hotel.setCaracteristicas(habitacion, id);
	}
	
	public void añadirServicioHabitacion(int id, String nombre, double precio) {
		hotel.añadirServicioHabitacion(id, nombre, precio);
	}
	
//FIN HABITACIONES -----------------------------------------------------------

//INICIO PRODUCTO MENU -----------------------------------------------------------

	public void crearProductoMenu(Date horaI, Date horaF, boolean llevable,String nombre, double precio) {
		hotel.crearProductoMenu(horaI, horaF, llevable, nombre, precio);
	}
	
//FIN PRODUCTO MENU -----------------------------------------------------------
	
//INICIO DAR DATOS ------------------------------------------------------------
	
	public String[] darUsuarios() {
		String[] lista = hotel.darUsuarios();
		return lista;
	}
	
	public String getTipo(String login) {
		return hotel.getTipo(login);
	}
	
	public String getArea(String login) {
		return hotel.getArea(login);
	}
	
	public void quitarUsuario(String nombre) {
		hotel.quitarUsuario(nombre);
	}
//FIN DAR DATOS ---------------------------------------------------------------
}