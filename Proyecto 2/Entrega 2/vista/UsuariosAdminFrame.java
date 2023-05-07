package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class UsuariosAdminFrame extends FrameBaseInfo {
	
	private JTable tablaUsuarios;
    private DefaultTableModel modeloTabla;
	
	public UsuariosAdminFrame(JFrame anterior) {
		super(anterior);
	}

	@Override
	protected void setPanelInfo() {
		// TODO Auto-generated method stub
		panelDerecho.setBackground(Color.decode("#B2BBA4"));
		panelDerecho.setBorder(BorderFactory.createEmptyBorder(30, 50, 50, 50));
		GridBagLayout gridbag = new GridBagLayout();
	    GridBagConstraints constraints = new GridBagConstraints();
	    panelDerecho.setLayout(gridbag);
	    
	    JPanel panelBuscar = new JPanel();	    
	    // añadir al panel
	    GridBagLayout gba = new GridBagLayout();
	    GridBagConstraints c = new GridBagConstraints();
	    
	    Font fontLabel = new Font("Arial", Font.BOLD, 16);
	    
	    panelBuscar.setLayout(gba);
	    
	  //Creacion de la tabla servicios
	  		String[] columnas = {"Usuarios"}; //Nombre de las columnas
	          modeloTabla = new DefaultTableModel(columnas, 0);
	          
	          //Filas de la tabla
	          String[] fila1 = {"Spa"};
	          String[] fila2 = {"LOL"};
	          modeloTabla.addRow(fila1);
	  	    modeloTabla.addRow(fila2);
	  	    
	  	    //Diseño de la tabla
	          tablaUsuarios = new JTable(modeloTabla);
	          tablaUsuarios.getTableHeader().setBackground(Color.decode("#204473"));
	          tablaUsuarios.getTableHeader().setForeground(Color.white);
	          tablaUsuarios.getTableHeader().setFont(new Font("Times New Roman", 1, 30));
	          tablaUsuarios.setFont(new Font("Times New Roman", 1, 20));
	          tablaUsuarios.setRowHeight(70);
	          tablaUsuarios.setEnabled(false);

	          DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
	          modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);


	          tablaUsuarios.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);

	          JScrollPane scrollPanel = new JScrollPane(tablaUsuarios);
	          scrollPanel.setPreferredSize(new Dimension(400, 650));
	          //Tamaño y ubicacion de la tabla en el panel
	          constraints.gridx = 0;
	          constraints.gridy = 0;
	          //constraints.ipady = 650;
	          //constraints.ipadx = 400;
	          constraints.gridheight = 10;
	          constraints.gridwidth = 2;
	          constraints.weightx = 1;
	          //constraints.weighty = 0.1;

	          panelDerecho.add(scrollPanel, constraints);
	          
	        //Creacion del recuadro para consultar la información de un usuario
	  		JPanel Pusuario = new JPanel(new GridLayout(6,1, 0, 5));
	  		Pusuario.setBorder(BorderFactory.createEmptyBorder(20, 50, 50, 50));
	  		Pusuario.setBackground(Color.decode("#accaf2"));
	  		
	  		//Nombre de usuario y su caja de texto
	  		JLabel labelNombre = new JLabel("Nombre");
	  		labelNombre.setForeground(Color.BLACK);
	  		labelNombre.setFont(new Font("Times New Roman", Font.PLAIN, 30));
	  		
	  		JTextField cajaNombre = new JTextField();
	  		cajaNombre.setEnabled(false);
	  		
	  		//Area de usuario y su caja de texto
	  		JLabel labelArea = new JLabel("Area");
	  		labelArea.setForeground(Color.BLACK);
	  		labelArea.setFont(new Font("Times New Roman", Font.PLAIN, 30));
	  		
	  		JTextField cajaArea = new JTextField();
	  		cajaArea.setEnabled(false);
	  		
	  		//Tipo de usuario y su caja de texto
	  		JLabel labelTipo = new JLabel("Tipo");
	  		labelTipo.setForeground(Color.BLACK);
	  		labelTipo.setFont(new Font("Times New Roman", Font.PLAIN, 30));
	  		
	  		JTextField cajaTipo = new JTextField();
	  		cajaTipo.setEnabled(false);
	  		
	  		//Boton para añadir un servicio
	  		JButton quitarUsuario = new BotonRedondeado("Quitar usuario", 200, 50, 30, Color.white);
	  		quitarUsuario.setBackground(Color.decode("#204473"));
	  		quitarUsuario.setForeground(Color.white);
	  		quitarUsuario.setFont(new Font("arial", 1, 20));
	  		
	  		Pusuario.add(labelNombre);
	  		Pusuario.add(cajaNombre);
	  		Pusuario.add(labelArea);
	  		Pusuario.add(cajaArea);
	  		Pusuario.add(labelTipo);
	  		Pusuario.add(cajaTipo);
	  		
	  		Pusuario.setPreferredSize(new Dimension(250, 300));
	  		
	  		//Tamaño y ubicacion en el panel
	  		constraints.gridx = 2;
	  		constraints.insets = new Insets(100, 0, 1, 0);
	  		constraints.gridy = 2;
	  		//constraints.ipady = 1;
	        //constraints.ipadx = 100;
	        constraints.gridheight = 5;
	        constraints.gridwidth = 1;
	        //constraints.weighty = 0.1;
	        
	        quitarUsuario.setPreferredSize(new Dimension(175, 50));
	        
	  		panelDerecho.add(Pusuario, constraints);
	  		constraints.insets = new Insets(50, 0, 1, 0);
	  		constraints.gridx = 2;
	  		constraints.gridy = 7;
	  		//constraints.ipady = 50;
	        //constraints.ipadx = 100;
	        constraints.gridheight = 2;
	        constraints.gridwidth = 1;
	        //constraints.weighty = 0.1;
	  		panelDerecho.add(quitarUsuario, constraints);
	}

	@Override
	protected void setPanelCrear() {
		GridBagLayout gridbag = new GridBagLayout();
	    GridBagConstraints constraints = new GridBagConstraints();
	    
	    panelCrear.setLayout(gridbag);

		panelCrear.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
		panelCrear.setBackground(Color.decode("#204473"));
		
		datos = new JTextField[4];
		String[] titulos = {"Nombre", "Contraseña", "Área", "Tipo"};
		
		Font fontLabel = new Font("Arial", Font.BOLD, 20);

		
		for( int i = 0; i < 4; i++) {
			JTextField campo = new JTextField();
			campo.setPreferredSize(new Dimension(200, 30));
			
			JLabel titulo = new JLabel(titulos[i]);
			titulo.setFont(fontLabel);
			titulo.setForeground(Color.WHITE);
			
			datos[i] = campo;
			
			constraints.gridx = 0;
			constraints.gridy = (i*2);
			constraints.fill = GridBagConstraints.HORIZONTAL;
			constraints.weighty=10;
			panelCrear.add(titulo, constraints);
			
			constraints.gridy = (i*2)+1 ;
			constraints.weighty=10;
			constraints.fill = GridBagConstraints.HORIZONTAL;
			panelCrear.add(campo, constraints);
		}
	    
		panelCrear.add(new JLabel());
		
		Font fontBoton = new Font("Arial", Font.BOLD, 20);
		addDatos =  new BotonRedondeado("Agregar usuario", 200, 75, 30, Color.decode("#ACCAF2"));
		addDatos.setFont(fontBoton);
		
		constraints.gridy = 9 ;
		constraints.gridy = GridBagConstraints.PAGE_END;
		panelCrear.add(addDatos,constraints);
		
	}

	@Override
	protected void actionPerformedFrame(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}