package vistaAdmin;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import controlador.WindowManager;
import modelo.ProductoMenu;
import modelo.Servicio;
import vistaEmpleado.EmpleadoRestauranteFrame;

public class AdminRestauranteFrame extends EmpleadoRestauranteFrame implements MouseListener,ActionListener{

	private DefaultTableModel modeloTabla;
	private JTable tablaMenu;
	private JTextField cajaHorarioI;
	private JTextField cajaHorarioF;
	private JTextField cajaPrecioOrden;
	private JTextField cajaNombreOrden;
	private JTextField cajaHorarioIOrden;
	private JTextField cajaHorarioFOrden;
	private JTextField cajaLlevableOrden;
	private JTextField cajaNombre;
	private JTextField cajaPrecio;
	private JButton agregarServicio;
	private JTextField cajaNumeroHabitacion;
	private JButton cargarAHabitacion;
	private JTextField cajaCantidadPersonas;

	public AdminRestauranteFrame(WindowManager windowManager) {
		super(windowManager);
		cargarDatos();
	}

	@Override
	protected void setPanelInfo() {
		//Edita el aspecto del panel	
		GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        panelDerecho.setLayout(gridbag);
		panelDerecho.setBackground(Color.decode("#b2bba4"));
		panelDerecho.setBorder(BorderFactory.createEmptyBorder(5, 31, 5, 1));
		
		//Creacion de la tabla menu
		String[] columnasMenu = {"Menú"}; //Nombre de las columnas
        modeloTabla = new DefaultTableModel(columnasMenu, 0);
        
        //Filas de la tabla
	    
	    //Diseño de la tabla
        tablaMenu = new JTable(modeloTabla);
        tablaMenu.addMouseListener(this);
        tablaMenu.setDefaultEditor(Object.class, null);
        tablaMenu.getTableHeader().setBackground(Color.decode("#204473"));
        tablaMenu.getTableHeader().setForeground(Color.white);
        tablaMenu.getTableHeader().setFont(new Font("Times New Roman", 1, 30));
        tablaMenu.setFont(new Font("Times New Roman", 1, 20));
        tablaMenu.setRowHeight(60);
        tablaMenu.setEnabled(true);

        DefaultTableCellRenderer modelocentrarMenu = new DefaultTableCellRenderer();
        modelocentrarMenu.setHorizontalAlignment(SwingConstants.CENTER);


        tablaMenu.getColumnModel().getColumn(0).setCellRenderer(modelocentrarMenu);

        JScrollPane scrollPanelMenu = new JScrollPane(tablaMenu);

        //Tamaño y ubicacion de la tabla en el panel
        constraints.gridx = 0;
        constraints.ipady = 650;
        constraints.ipadx = 400;
        constraints.gridheight = 4;
        constraints.gridwidth = 1;
        constraints.weighty = 1;
        constraints.weightx = 1;

        panelDerecho.add(scrollPanelMenu, constraints);
		
      //Creacion del recuadro para añadir producto menu a la habitacion
  		JPanel panelAgregarOrden = new JPanel(new GridLayout(5,0, 0, 10));
  		panelAgregarOrden.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
  		panelAgregarOrden.setBackground(Color.decode("#204473"));
  		
  		//Crea el panel nombre
		JPanel panelNombreOrden = new JPanel();
		panelNombreOrden.setBackground(Color.decode("#204473"));	
		panelNombreOrden.setLayout(new GridLayout(2, 1));
		
		//Nombre y su caja de texto		
		JLabel nombreOrden = new JLabel("Nombre");
		nombreOrden.setForeground(Color.white);
		nombreOrden.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		
		cajaNombreOrden = new JTextField();
		cajaNombreOrden.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		
		panelNombreOrden.add(nombreOrden);
		panelNombreOrden.add(cajaNombreOrden);
		
		//Crea el panel precio
		JPanel panelPrecioOrden = new JPanel();
		panelPrecioOrden.setBackground(Color.decode("#204473"));	
		panelPrecioOrden.setLayout(new GridLayout(2, 1));
		
		//Precio y su caja de texto
		JLabel precioOrden = new JLabel("Precio");
		precioOrden.setForeground(Color.white);
		precioOrden.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		
		cajaPrecioOrden = new JTextField();
		cajaPrecioOrden.setFont(new Font("Times New Roman", Font.PLAIN, 30));

		panelPrecioOrden.add(precioOrden);
		panelPrecioOrden.add(cajaPrecioOrden);
		
		//Crea el panel horario
		JPanel panelHorarioIOrden = new JPanel();
		panelHorarioIOrden.setBackground(Color.decode("#204473"));	
		panelHorarioIOrden.setLayout(new GridLayout(2, 1));
		
		//Precio y su caja de texto
		JLabel horarioIOrden = new JLabel("Hora Inicial");
		horarioIOrden.setForeground(Color.white);
		horarioIOrden.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		
		cajaHorarioIOrden = new JTextField();
		cajaHorarioIOrden.setFont(new Font("Times New Roman", Font.PLAIN, 30));

		panelHorarioIOrden.add(horarioIOrden);
		panelHorarioIOrden.add(cajaHorarioIOrden);
		
		//Crea el panel horario
		JPanel panelHorarioFOrden = new JPanel();
		panelHorarioFOrden.setBackground(Color.decode("#204473"));	
		panelHorarioFOrden.setLayout(new GridLayout(2, 1));
		
		//Precio y su caja de texto
		JLabel horarioFOrden = new JLabel("Hora final");
		horarioFOrden.setForeground(Color.white);
		horarioFOrden.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		
		cajaHorarioFOrden = new JTextField();
		cajaHorarioFOrden.setFont(new Font("Times New Roman", Font.PLAIN, 30));

		panelHorarioFOrden.add(horarioFOrden);
		panelHorarioFOrden.add(cajaHorarioFOrden);
		
		//Crea el panel llevable
		JPanel panelLlevableOrden = new JPanel();
		panelLlevableOrden.setBackground(Color.decode("#204473"));	
		panelLlevableOrden.setLayout(new GridLayout(2, 1));
		
		//Precio y su caja de texto
		JLabel llevableOrden = new JLabel("Llevable");
		llevableOrden.setForeground(Color.white);
		llevableOrden.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		
		cajaLlevableOrden = new JTextField();
		cajaLlevableOrden.setFont(new Font("Times New Roman", Font.PLAIN, 30));

		panelLlevableOrden.add(llevableOrden);
		panelLlevableOrden.add(cajaLlevableOrden);
		
		panelAgregarOrden.add(panelNombreOrden);
		panelAgregarOrden.add(panelPrecioOrden);
		panelAgregarOrden.add(panelHorarioIOrden);
		panelAgregarOrden.add(panelHorarioFOrden);
		panelAgregarOrden.add(panelLlevableOrden);
  		
  		//Tamaño y ubicacion en el panel
  		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.ipady = 50;
        constraints.ipadx = 131;
        constraints.gridheight = 2;
        constraints.gridwidth = 2;
        constraints.weighty = 2;
        constraints.weightx = 2;
  		
  		
  		panelDerecho.add(panelAgregarOrden, constraints);
        
        //Creacion del recuadro para añadir producto menu a la habitacion
  		JPanel panelHabitacion = new JPanel(new GridLayout(3,0, 0, 10));
  		panelHabitacion.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
  		panelHabitacion.setBackground(Color.decode("#accaf2"));
  		
  		JPanel panelNumeroHabitacion = new JPanel(new GridLayout(2,0));
  		panelNumeroHabitacion.setBackground(Color.decode("#accaf2"));
  		
  		JLabel numHabitacion = new JLabel("#Habitación");
  		numHabitacion.setFont(new Font("Times New Roman", Font.PLAIN, 30));
  		
  		cajaNumeroHabitacion = new JTextField();
  		cajaNumeroHabitacion.setFont(new Font("Times New Roman", Font.PLAIN, 30));
  		
  		panelNumeroHabitacion.add(numHabitacion);
  		panelNumeroHabitacion.add(cajaNumeroHabitacion);
  		
  		JPanel panelCantidad = new JPanel(new GridLayout(2,0));
  		panelCantidad.setBackground(Color.decode("#accaf2"));
  		
  		JLabel cantidadPersonas = new JLabel("#Personas");
  		cantidadPersonas.setFont(new Font("Times New Roman", Font.PLAIN, 30));
  		
  		cajaCantidadPersonas = new JTextField();
  		cajaCantidadPersonas.setFont(new Font("Times New Roman", Font.PLAIN, 30));
  		
  		panelCantidad.add(cantidadPersonas);
  		panelCantidad.add(cajaCantidadPersonas);
  		
  		JPanel botonesHabitacion = new JPanel(new GridLayout(1,0, 0 ,5));
  		botonesHabitacion.setBackground(Color.decode("#accaf2"));
  		
  		cargarAHabitacion = new JButton("Cargar a la habitación​");
  		cargarAHabitacion.setBackground(Color.decode("#204473"));
  		cargarAHabitacion.setForeground(Color.white);
  		cargarAHabitacion.setFont(new Font("arial", 1, 20));
  		cargarAHabitacion.addActionListener(this);
  		
  		botonesHabitacion.add(cargarAHabitacion);
  		
  		panelHabitacion.add(panelNumeroHabitacion);
  		panelHabitacion.add(panelCantidad);
  		panelHabitacion.add(botonesHabitacion);
  		
  		//Tamaño y ubicacion en el panel
  		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.ipadx = 100;
  		
  		panelDerecho.add(panelHabitacion, constraints);

	}

	@Override
	protected void setPanelCrear() {
		//Edita el aspecto del panel	
		panelCrear.setLayout(new GridLayout(5, 1, 10, 10));
		panelCrear.setBackground(Color.decode("#204473"));
		panelCrear.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
		
		//Crea el panel nombre
		JPanel panelNombre = new JPanel();
		panelNombre.setBackground(Color.decode("#204473"));	
		panelNombre.setLayout(new GridLayout(2, 1));
		
		//Nombre y su caja de texto		
		JLabel nombre = new JLabel("Nombre");
		nombre.setForeground(Color.white);
		nombre.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		
		cajaNombre = new JTextField();
		cajaNombre.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		
		panelNombre.add(nombre);
		panelNombre.add(cajaNombre);
		
		//Crea el panel precio
		JPanel panelPrecio = new JPanel();
		panelPrecio.setBackground(Color.decode("#204473"));	
		panelPrecio.setLayout(new GridLayout(2, 1));
		
		//Precio y su caja de texto
		JLabel precio = new JLabel("Precio");
		precio.setForeground(Color.white);
		precio.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		
		cajaPrecio = new JTextField();
		cajaPrecio.setFont(new Font("Times New Roman", Font.PLAIN, 30));

		panelPrecio.add(precio);
		panelPrecio.add(cajaPrecio);
		
		//Crea el panel horario
		JPanel panelHorarioI = new JPanel();
		panelHorarioI.setBackground(Color.decode("#204473"));	
		panelHorarioI.setLayout(new GridLayout(2, 1));
		
		//Precio y su caja de texto
		JLabel horarioI = new JLabel("Hora Inicial");
		horarioI.setForeground(Color.white);
		horarioI.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		
		cajaHorarioI = new JTextField();
		cajaHorarioI.setFont(new Font("Times New Roman", Font.PLAIN, 30));

		panelHorarioI.add(horarioI);
		panelHorarioI.add(cajaHorarioI);
		
		//Crea el panel horario
		JPanel panelHorarioF = new JPanel();
		panelHorarioF.setBackground(Color.decode("#204473"));	
		panelHorarioF.setLayout(new GridLayout(2, 1));
		
		//Precio y su caja de texto
		JLabel horarioF = new JLabel("Hora final");
		horarioF.setForeground(Color.white);
		horarioF.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		
		cajaHorarioF = new JTextField();
		cajaHorarioF.setFont(new Font("Times New Roman", Font.PLAIN, 30));

		panelHorarioF.add(horarioF);
		panelHorarioF.add(cajaHorarioF);
		
		//Crea el panel agregar servicio
		JPanel panelAgregarServicio = new JPanel();
		panelAgregarServicio.setBackground(Color.decode("#204473"));
		
		//Boton par agregar un servicio
		agregarServicio = new JButton("Agregar al menú");
		agregarServicio.setBackground(Color.decode("#accaf2"));
		agregarServicio.setFont(new Font("arial", 1, 20));
		agregarServicio.addActionListener(this);
		
		panelAgregarServicio.add(agregarServicio);
		
		//Se añaden los componentes al panel
		panelCrear.add(panelNombre);
		panelCrear.add(panelPrecio);
		panelCrear.add(panelHorarioI);
		panelCrear.add(panelHorarioF);
		panelCrear.add(panelAgregarServicio);
				
		
	}
	
	private void agregarAlMenu() {
		java.util.Date horaI = windowManager.getHora(cajaHorarioI.getText());
		java.util.Date horaF = windowManager.getHora(cajaHorarioF.getText());
		String nombre = cajaNombre.getText();
		Double precio = Double.parseDouble(cajaPrecio.getText());
		boolean pagarEnSitio = false;
		int option = JOptionPane.showConfirmDialog(null, "¿Es llevable?", "Llevable", JOptionPane.YES_NO_OPTION);
		if (option==JOptionPane.YES_OPTION) {
			pagarEnSitio=true;
		}
		windowManager.crearProductoMenu(horaI, horaF, pagarEnSitio, nombre, precio);
		cargarDatos();
		cajaNombre.setText("");
		cajaPrecio.setText("");
		cajaHorarioF.setText("");
		cajaHorarioI.setText("");
	}
	
	public void cargarDatos() {
		modeloTabla.getDataVector().removeAllElements();
		modeloTabla.fireTableDataChanged(); 
		Collection<ProductoMenu> listaProductosMenu = windowManager.getMenu().values();
		for (ProductoMenu productoMenu : listaProductosMenu) {
			String nombre = productoMenu.getNombre();
	        modeloTabla.addRow(new Object[]{nombre, "ICON", "ICON"});
		}
	}
	
	private String getPrecio(String nombre) {
		Collection<ProductoMenu> menu = windowManager.getMenu().values();
		String nombreServicio = null;
		for(ProductoMenu servicio : menu)
			if (servicio.getNombre().equals(nombre)) {
				nombreServicio = String.valueOf(servicio.getPrecio());
			}
		return nombreServicio;
		}
	
	private double getId(String nombre) {
		Collection<ProductoMenu> listaServicios = windowManager.getMenu().values();
		double precioServicio = 0;
		for(ProductoMenu servicio : listaServicios)
			if (servicio.getNombre().equals(nombre)) {
				precioServicio = servicio.getPrecio();
			}
		return precioServicio;
		}
	
	private Date getHoraI(String nombre) {
		Collection<ProductoMenu> menu = windowManager.getMenu().values();
		Date precioServicio = null;
		for(ProductoMenu servicio : menu)
			if (servicio.getNombre().equals(nombre)) {
				precioServicio = servicio.getHorarioI();
			}
		return precioServicio;
		}
	
	private Date getHoraF(String nombre) {
		Collection<ProductoMenu> menu = windowManager.getMenu().values();
		Date precioServicio = null;
		for(ProductoMenu servicio : menu)
			if (servicio.getNombre().equals(nombre)) {
				precioServicio = servicio.getHorarioF();
			}
		return precioServicio;
		}
	
	private boolean getLlevable(String nombre) {
		Collection<ProductoMenu> menu = windowManager.getMenu().values();
		boolean precioServicio = false;
		for(ProductoMenu servicio : menu)
			if (servicio.getNombre().equals(nombre)) {
				precioServicio = servicio.getLlevable();
			}
		return precioServicio;
		}
	
	private void añadirProductoMenu() {
		int idServicio = (int)getId(cajaNombreOrden.getText());
		int idHabitacion = Integer.parseInt(cajaNumeroHabitacion.getText());
		int cantidad = Integer.parseInt(cajaCantidadPersonas.getText());
		boolean pagarEnSitio = false;
		int option = JOptionPane.showConfirmDialog(null, "¿Desea pagar ahora?", "Pagar", JOptionPane.YES_NO_OPTION);
		cajaNombreOrden.setText("");
		cajaPrecioOrden.setText("");
		cajaHorarioIOrden.setText("");
		cajaHorarioFOrden.setText("");
		cajaLlevableOrden.setText("");
		cajaNumeroHabitacion.setText("");
		cajaCantidadPersonas.setText("");
		if (option==JOptionPane.YES_OPTION) {
			pagarEnSitio=true;
		}
		windowManager.añadirProductoMenuHabitacion(idHabitacion, idServicio, cantidad, pagarEnSitio);
	}
	
	public String formatoHora(Date hora) {
		SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
	    String fechaString = sdf.format(hora);
		return fechaString;
	}

	@Override
	public void actionPerformedFrame(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Agregar al menú":
			agregarAlMenu();
			break;
		case "Cargar a la habitación":
			añadirProductoMenu();
			break;

		default:
			break;
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 1) {
			int row = tablaMenu.getSelectedRow();
			int column = tablaMenu.getSelectedColumn();
			String nombre = tablaMenu.getValueAt(row, column).toString();
			String precio = getPrecio(nombre);
			Date horaI = getHoraI(nombre);
			Date horaF = getHoraF(nombre);
			String llevable = "No";
			if (getLlevable(nombre)) {
				llevable="Si";
			}
			cajaNombreOrden.setText(nombre);
			cajaPrecioOrden.setText(precio);
			cajaHorarioIOrden.setText(formatoHora(horaI));
			cajaHorarioFOrden.setText(formatoHora(horaF));
			cajaLlevableOrden.setText(llevable);
		 }
		
	}
}