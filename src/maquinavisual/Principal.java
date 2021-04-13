package maquinavisual;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.border.LineBorder;

public class Principal {

	private JFrame frame;
	private JTextField tfUser;
	private JTextField tfSaldoUser;
	private ArrayList<Usuarios> user=new ArrayList<Usuarios>();
	private JComboBox<String> comboUsers;
	private JLabel lblSaldoUser;
	private JLabel lblNewUser;
	private JPanel panelBebidas;
	private JPanel panel_2;
	private JPanel panelUser;
	private JButton btnEnergyDrink;
	private JButton btnCoke;
	private JButton btnCoffee;
	private JButton btnChocoMilk;
	private JButton btnOrangeJuice;
	private JButton btnMilk;
	private JButton btnStraMilk;
	private JButton btnWater;
	private JButton btnInfusion;
	private JLabel lblPrecio;
	private JTextField tfPrecio;
	File registro = new File("Usuarios.txt");
	Conexion dbUsuarios=new Conexion();
	
	Scanner src= null;
	private ImageIcon icoCoke= new ImageIcon("resources/011-cola.png");
	private ImageIcon icoEnergyDrink= new ImageIcon("resources/009-energy_drink.png");
	private ImageIcon icoWater= new ImageIcon("resources/047-water.png");
	private ImageIcon icoOrange= new ImageIcon("resources/050-orange_juice.png");
	private ImageIcon icoCoffee= new ImageIcon("resources/022-coffee.png");
	private ImageIcon icoInfusion= new ImageIcon("resources/026-infusion.png");
	private ImageIcon icoMilk= new ImageIcon("resources/002-milk_box.png");
	private ImageIcon icoChocoMilk= new ImageIcon("resources/014-chocolate_milk.png");
	private ImageIcon icoStraMilk= new ImageIcon("resources/033-strawberry_milk.png");
	private JComboBox comboEuros;
	private JComboBox comboCentimos;
	private JLabel lblCents;
	private JLabel lblEuros;
	private JButton btnRetirar;
	boolean primerclick = true;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public Principal() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		consultar();
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 51));
		frame.setBounds(100, 100, 650, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panelBebidas = new JPanel();
		panelBebidas.setBounds(10, 11, 470, 625);
		frame.getContentPane().add(panelBebidas);
		panelBebidas.setLayout(new GridLayout(0, 3, 0, 0));
		
		btnCoke = new JButton(resizeIcon(icoCoke,145,197));
		btnCoke.setBorderPainted(false);
		btnCoke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				tfPrecio.setText("1.00");
				if(primerclick) {					
					primerclick=false;					
				}else{				
					comprar();
					tfPrecio.setText(null);
					primerclick=true;
				}
			}
		});
		
		panelBebidas.add(btnCoke);
		
		btnEnergyDrink = new JButton(resizeIcon(icoEnergyDrink,145,197));
		btnEnergyDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfPrecio.setText("1.50");
				if(primerclick) {					
					primerclick=false;					
				}else{				
					comprar();
					tfPrecio.setText(null);
					primerclick=true;
				}
			}
		});
		btnEnergyDrink.setBorderPainted(false);
		panelBebidas.add(btnEnergyDrink);
		
		btnWater = new JButton(resizeIcon(icoWater,145,197));
		btnWater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfPrecio.setText("0.30");
				if(primerclick) {					
					primerclick=false;					
				}else{				
					comprar();
					tfPrecio.setText(null);
					primerclick=true;
				}
			}
		});
		btnWater.setBorderPainted(false);
		panelBebidas.add(btnWater);
		
		btnOrangeJuice = new JButton(resizeIcon(icoOrange,145,197));
		btnOrangeJuice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfPrecio.setText("1.20");
				if(primerclick) {					
					primerclick=false;					
				}else{				
					comprar();
					tfPrecio.setText(null);
					primerclick=true;
				}
			}
		});
		btnOrangeJuice.setBorderPainted(false);
		panelBebidas.add(btnOrangeJuice);
		
		btnCoffee = new JButton(resizeIcon(icoCoffee,145,197));
		btnCoffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfPrecio.setText("0.40");
				if(primerclick) {					
					primerclick=false;					
				}else{				
					comprar();
					tfPrecio.setText(null);
					primerclick=true;
				}
			}
		});
		btnCoffee.setBorderPainted(false);
		panelBebidas.add(btnCoffee);
		
		btnInfusion = new JButton(resizeIcon(icoInfusion,145,197));
		btnInfusion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfPrecio.setText("0.35");
				if(primerclick) {					
					primerclick=false;					
				}else{				
					comprar();
					tfPrecio.setText(null);
					primerclick=true;
				}
			}
		});
		btnInfusion.setBorderPainted(false);
		panelBebidas.add(btnInfusion);
		
		btnChocoMilk = new JButton(resizeIcon(icoChocoMilk,145,197));
		btnChocoMilk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfPrecio.setText("0.80");
				if(primerclick) {					
					primerclick=false;					
				}else{				
					comprar();
					tfPrecio.setText(null);
					primerclick=true;
				}
			}
		});
		btnChocoMilk.setBorderPainted(false);
		panelBebidas.add(btnChocoMilk);
		
		btnMilk = new JButton(resizeIcon(icoMilk,145,197));
		btnMilk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfPrecio.setText("0.75");
				if(primerclick) {					
					primerclick=false;					
				}else{				
					comprar();
					tfPrecio.setText(null);
					primerclick=true;
				}
			}
		});
		btnMilk.setBorderPainted(false);
		panelBebidas.add(btnMilk);
		
		btnStraMilk = new JButton(resizeIcon(icoStraMilk,145,197));
		btnStraMilk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfPrecio.setText("0.80");
				if(primerclick) {					
					primerclick=false;					
				}else{				
					comprar();
					tfPrecio.setText(null);
					primerclick=true;
				}
			}
		});
		btnStraMilk.setBorderPainted(false);
		panelBebidas.add(btnStraMilk);
		
		panelUser = new JPanel();
		panelUser.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panelUser.setBounds(491, 11, 133, 114);
		frame.getContentPane().add(panelUser);
		panelUser.setLayout(null);
		
		tfUser = new JTextField();
		tfUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {							
				dbUsuarios.insertarDatos((String) tfUser.getText(),"Usuarios");
				consultar();
				Usuarios e=new Usuarios(); 				
					e=user.get(user.size()-1);				
					comboUsers.addItem(e.getNombre());}				
			}
		);
		tfUser.setBounds(10, 81, 113, 22);
		panelUser.add(tfUser);
		tfUser.setColumns(10);
		
		comboUsers = new JComboBox<String>();
		comboUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verSaldo();
			}
		});
		comboUsers.setBounds(10, 11, 113, 28);
		panelUser.add(comboUsers);
		
		tfSaldoUser = new JTextField();
		tfSaldoUser.setEditable(false);
		tfSaldoUser.setBounds(47, 50, 76, 20);
		panelUser.add(tfSaldoUser);
		tfSaldoUser.setColumns(10);
		
		lblSaldoUser = new JLabel("Saldo");
		lblSaldoUser.setBounds(10, 50, 46, 20);
		panelUser.add(lblSaldoUser);
		
		lblNewUser = new JLabel("Nuevo Usuario:");
		lblNewUser.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewUser.setBounds(10, 70, 53, 14);
		panelUser.add(lblNewUser);
		
		panel_2 = new JPanel();
		panel_2.setBounds(491, 136, 133, 500);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 11, 46, 14);
		panel_2.add(lblPrecio);
		
		tfPrecio = new JTextField();
		tfPrecio.setBounds(10, 36, 113, 29);
		panel_2.add(tfPrecio);
		tfPrecio.setColumns(10);
		
		comboEuros = new JComboBox();
		comboEuros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				float i=0f;
				
				try {
				i=(float)((int)comboEuros.getSelectedItem());
				i=i+Float.parseFloat(tfSaldoUser.getText());
				dbUsuarios.cambiarSaldo((String)comboUsers.getSelectedItem(), "Usuarios" , i);
				}catch(Exception e) {					
				}
				updateSaldoLocal(i);
				verSaldo();
				
			}
		});
		comboEuros.setBounds(35, 96, 88, 22);
		panel_2.add(comboEuros);
		for(int i=0;i<6;i++) {						
			comboEuros.addItem(i);
		}
		
		lblEuros = new JLabel("Euros");
		lblEuros.setBounds(10, 76, 46, 14);
		panel_2.add(lblEuros);
		
		comboCentimos = new JComboBox();
		comboCentimos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				float i=0f;
				try {
				i=Float.parseFloat((String) comboCentimos.getSelectedItem());
				i=i+Float.parseFloat(tfSaldoUser.getText());
				dbUsuarios.cambiarSaldo((String)comboUsers.getSelectedItem(), "Usuarios" , i);
				}catch(Exception e) {
					e.printStackTrace();
				}
				updateSaldoLocal(i);
				verSaldo();
				
			}
		});
		comboCentimos.setBounds(35, 156, 88, 22);
		panel_2.add(comboCentimos);
		for(float i=0f;i<1f;i=i+0.05f) {
			comboCentimos.addItem(String.format(Locale.US,"%.2f", i));
		}
		
		lblCents = new JLabel("Centimos");
		lblCents.setBounds(10, 131, 46, 14);
		panel_2.add(lblCents);
		
		btnRetirar = new JButton("\u20AC");
		btnRetirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dbUsuarios.cambiarSaldo((String)comboUsers.getSelectedItem(), "Usuarios" , 0.0f);
				updateSaldoLocal(0f);
				verSaldo();
			}
		});
		btnRetirar.setBounds(77, 212, 46, 23);
		panel_2.add(btnRetirar);
		
		JLabel lblRetirar = new JLabel("Retirar");
		lblRetirar.setBounds(10, 200, 46, 14);
		panel_2.add(lblRetirar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(20, 647, 444, 76);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		/*conexionDB();
		try {
			crearTablaDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		colocarUsuarios();		
	}
	
	private void colocarUsuarios() {
		
		Usuarios e=new Usuarios(); 
		Iterator<Usuarios> it= user.iterator();
		while(it.hasNext()) {
			e=it.next();
			comboUsers.addItem(e.getNombre());
		}	
	}
	
	private void consultar() {
		try {
			user=dbUsuarios.consultaDatos("Usuarios");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void verSaldo() {		
		Usuarios e=new Usuarios(); 
		Iterator<Usuarios> it = user.iterator();
		while(it.hasNext()) {			
			e=it.next();
			if(e.getNombre().equals((String)comboUsers.getSelectedItem())) {
				tfSaldoUser.setText(String.format(Locale.US,"%.2f", e.getSaldo()));
			}
		}		
	}
	public void updateSaldoLocal(Float cambio) {
		Usuarios e=new Usuarios(); 
		Iterator<Usuarios> it = user.iterator();
		while(it.hasNext()) {			
			e=it.next();
			if(e.getNombre().equals((String)comboUsers.getSelectedItem())) {
				user.get(e.getRowid()-1).setSaldo(cambio);;
			}
		}		
	}
	
	public void comprar(){
		float precioArticulo=0f;
		float saldocomprobar=0f;
		float i=0f;
		
		
		saldocomprobar=Float.parseFloat(tfSaldoUser.getText());
		precioArticulo=Float.parseFloat(tfPrecio.getText());
		
		if(saldocomprobar>precioArticulo) {
		try {
			frame.setTitle("Extrayendo");
			i=saldocomprobar-precioArticulo;
		dbUsuarios.cambiarSaldo((String)comboUsers.getSelectedItem(), "Usuarios" , i);
		updateSaldoLocal(i);
		}catch(Exception e) {
			e.printStackTrace();
		}		
		verSaldo();}else {
			frame.setTitle("Saldo insuficiente");
		}
	}
	
	void conexionDB() {
		dbUsuarios.conectar();
	}
	void crearTablaDB() throws SQLException {
		dbUsuarios.crearTabla("Usuarios");
	}	
	
	private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
	    Image img = icon.getImage();  
	    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	    return new ImageIcon(resizedImage);
	}
}
