package ungs.edu.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import ungs.edu.gpsfree.Algoritmos;
import ungs.edu.gpsfree.Coordenada;
import ungs.edu.graficar.Graficador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.border.BevelBorder;

public class JfranePrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField c1_x_jtext;
	private JTextField c1_y_jtext;
	private JTextField c2_x_jtext;
	private JTextField c2_y_jtext;
	private JTextField c3_x_jtext;
	private JTextField c3_y_jtext;
	private JTextField c4_x_jtext;
	private JTextField c4_y_jtext;
	private JTextField dc1c2_jtext;
	private JTextField dc1c3_jtext;
	private JTextField dc1c4_jtext;
	private JTextField dc2c4_jtext;
	private JTextField dc2c3_jtext;
	private JTextField dc3c4_jtext;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JfranePrincipal frame = new JfranePrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JfranePrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 222, 102);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblC = new JLabel("C1");
		lblC.setBounds(0, 0, 34, 19);
		panel.add(lblC);
		
		c1_x_jtext = new JTextField();
		c1_x_jtext.setText("0");
		c1_x_jtext.setBounds(52, 0, 61, 19);
		panel.add(c1_x_jtext);
		c1_x_jtext.setColumns(10);
		
		JLabel lblX = new JLabel("X:");
		lblX.setBounds(32, 1, 23, 17);
		panel.add(lblX);
		
		JLabel lblY = new JLabel("Y:");
		lblY.setBounds(128, 1, 23, 17);
		panel.add(lblY);
		
		c1_y_jtext = new JTextField();
		c1_y_jtext.setText("0");
		c1_y_jtext.setColumns(10);
		c1_y_jtext.setBounds(148, 0, 61, 19);
		panel.add(c1_y_jtext);
		
		JLabel lblC_1 = new JLabel("C2");
		lblC_1.setBounds(0, 24, 34, 19);
		panel.add(lblC_1);
		
		JLabel label_1 = new JLabel("X:");
		label_1.setBounds(32, 25, 23, 17);
		panel.add(label_1);
		
		c2_x_jtext = new JTextField();
		c2_x_jtext.setText("0");
		c2_x_jtext.setColumns(10);
		c2_x_jtext.setBounds(52, 24, 61, 19);
		panel.add(c2_x_jtext);
		
		JLabel label_2 = new JLabel("Y:");
		label_2.setBounds(128, 25, 23, 17);
		panel.add(label_2);
		
		c2_y_jtext = new JTextField();
		c2_y_jtext.setText("4");
		c2_y_jtext.setColumns(10);
		c2_y_jtext.setBounds(148, 24, 61, 19);
		panel.add(c2_y_jtext);
		
		JLabel lblC_2 = new JLabel("C3");
		lblC_2.setBounds(0, 52, 34, 19);
		panel.add(lblC_2);
		
		JLabel label_4 = new JLabel("X:");
		label_4.setBounds(32, 53, 23, 17);
		panel.add(label_4);
		
		c3_x_jtext = new JTextField();
		c3_x_jtext.setText("3");
		c3_x_jtext.setColumns(10);
		c3_x_jtext.setBounds(52, 52, 61, 19);
		panel.add(c3_x_jtext);
		
		JLabel label_5 = new JLabel("Y:");
		label_5.setBounds(128, 53, 23, 17);
		panel.add(label_5);
		
		c3_y_jtext = new JTextField();
		c3_y_jtext.setText("4");
		c3_y_jtext.setColumns(10);
		c3_y_jtext.setBounds(148, 52, 61, 19);
		panel.add(c3_y_jtext);
		
		JLabel lblC_3 = new JLabel("C4");
		lblC_3.setBounds(0, 81, 34, 19);
		panel.add(lblC_3);
		
		JLabel label_7 = new JLabel("X:");
		label_7.setBounds(32, 82, 23, 17);
		panel.add(label_7);
		
		c4_x_jtext = new JTextField();
		c4_x_jtext.setText("6");
		c4_x_jtext.setColumns(10);
		c4_x_jtext.setBounds(52, 81, 61, 19);
		panel.add(c4_x_jtext);
		
		JLabel label_8 = new JLabel("Y:");
		label_8.setBounds(128, 82, 23, 17);
		panel.add(label_8);
		
		c4_y_jtext = new JTextField();
		c4_y_jtext.setText("2");
		c4_y_jtext.setColumns(10);
		c4_y_jtext.setBounds(148, 81, 61, 19);
		panel.add(c4_y_jtext);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(246, 12, 424, 64);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDcc = new JLabel("DC1C2:");
		lblDcc.setBounds(0, 1, 61, 18);
		panel_1.add(lblDcc);
		
		dc1c2_jtext = new JTextField();
		dc1c2_jtext.setColumns(10);
		dc1c2_jtext.setBounds(63, 1, 61, 19);
		panel_1.add(dc1c2_jtext);
		
		dc1c3_jtext = new JTextField();
		dc1c3_jtext.setColumns(10);
		dc1c3_jtext.setBounds(195, 1, 61, 19);
		panel_1.add(dc1c3_jtext);
		
		JLabel lblDcc_1 = new JLabel("DC1C3:");
		lblDcc_1.setBounds(132, 1, 61, 18);
		panel_1.add(lblDcc_1);
		
		dc1c4_jtext = new JTextField();
		dc1c4_jtext.setColumns(10);
		dc1c4_jtext.setBounds(331, 0, 61, 19);
		panel_1.add(dc1c4_jtext);
		
		JLabel lblDcc_2 = new JLabel("DC1C4:");
		lblDcc_2.setBounds(268, 0, 61, 18);
		panel_1.add(lblDcc_2);
		
		dc2c4_jtext = new JTextField();
		dc2c4_jtext.setColumns(10);
		dc2c4_jtext.setBounds(195, 32, 61, 19);
		panel_1.add(dc2c4_jtext);
		
		JLabel lblDcc_4 = new JLabel("DC2C4:");
		lblDcc_4.setBounds(132, 32, 61, 18);
		panel_1.add(lblDcc_4);
		
		dc2c3_jtext = new JTextField();
		dc2c3_jtext.setColumns(10);
		dc2c3_jtext.setBounds(63, 32, 61, 19);
		panel_1.add(dc2c3_jtext);
		
		JLabel lblDcc_3 = new JLabel("DC2C3:");
		lblDcc_3.setBounds(0, 32, 61, 18);
		panel_1.add(lblDcc_3);
		
		dc3c4_jtext = new JTextField();
		dc3c4_jtext.setColumns(10);
		dc3c4_jtext.setBounds(331, 31, 61, 19);
		panel_1.add(dc3c4_jtext);
		
		JLabel lblDcc_5 = new JLabel("DC3C4:");
		lblDcc_5.setBounds(268, 31, 61, 18);
		panel_1.add(lblDcc_5);
		
			
		JButton btnDibujarPuntos = new JButton("Dibujar Puntos");
		btnDibujarPuntos.setBounds(59, 126, 139, 25);
	
		btnDibujarPuntos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dibujarCoordenadas();
			}
		});
		contentPane.add(btnDibujarPuntos);
		
		JButton btnCalcularDistancias = new JButton("Calcular Distancias");
		btnCalcularDistancias.setBounds(271, 126, 169, 25);
		btnCalcularDistancias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calcularDistancias();
			}
		});
		contentPane.add(btnCalcularDistancias);
		
		JButton btnGpsFree = new JButton("GPS FREE");
		btnGpsFree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dibujarCoordenadasPorDistancias();
			}
		});
		btnGpsFree.setBounds(480, 126, 117, 25);
		contentPane.add(btnGpsFree);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 163, 320, 241);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(368, 163, 320, 241);
		contentPane.add(panel_3);
		
		
	}

	protected void calcularDistancias() {
	
		Coordenada coordenada1 = new Coordenada(Double.valueOf(c1_x_jtext.getText()), Double.valueOf(c1_y_jtext.getText()));
		Coordenada coordenada2 = new Coordenada(Double.valueOf(c2_x_jtext.getText()), Double.valueOf(c2_y_jtext.getText()));
		Coordenada coordenada3 = new Coordenada(Double.valueOf(c3_x_jtext.getText()), Double.valueOf(c3_y_jtext.getText()));
		Coordenada coordenada4 = new Coordenada(Double.valueOf(c4_x_jtext.getText()), Double.valueOf(c4_y_jtext.getText()));

		Double dc1c3 = Algoritmos
				.distanciaEntrePuntos(coordenada1, coordenada3);
		Double dc2c3 = Algoritmos
				.distanciaEntrePuntos(coordenada2, coordenada3);
		Double dc1c2 = Algoritmos
				.distanciaEntrePuntos(coordenada1, coordenada2);
		Double dc1c4 = Algoritmos
				.distanciaEntrePuntos(coordenada1, coordenada4);
		Double dc2c4 = Algoritmos
				.distanciaEntrePuntos(coordenada2, coordenada4);
		Double dc3c4 = Algoritmos
				.distanciaEntrePuntos(coordenada3, coordenada4);
		
		dc1c3=(double) (Math.round(dc1c3*100))/100.0;
		dc2c3=(double) (Math.round(dc2c3*100))/100.0;
		dc1c2=(double) (Math.round(dc1c2*100))/100.0;
		dc1c4=(double) (Math.round(dc1c4*100))/100.0;
		dc2c4=(double) (Math.round(dc2c4*100))/100.0;
		dc3c4=(double) (Math.round(dc3c4*100))/100.0;
	
		this.dc1c2_jtext.setText(dc1c2.toString());
		this.dc1c3_jtext.setText(dc1c3.toString());
		this.dc1c4_jtext.setText(dc1c4.toString());
		this.dc2c3_jtext.setText(dc2c3.toString());
		this.dc2c4_jtext.setText(dc2c4.toString());
		this.dc3c4_jtext.setText(dc3c4.toString());
		
	}

	protected void dibujarCoordenadas() {
		Graficador graficador = new Graficador();
		Coordenada coordenada0 = new Coordenada(Double.valueOf(c1_x_jtext.getText()), Double.valueOf(c1_y_jtext.getText()));
		Coordenada coordenada1 = new Coordenada(Double.valueOf(c2_x_jtext.getText()), Double.valueOf(c2_y_jtext.getText()));
		Coordenada coordenada2 = new Coordenada(Double.valueOf(c3_x_jtext.getText()), Double.valueOf(c3_y_jtext.getText()));
		Coordenada coordenada3 = new Coordenada(Double.valueOf(c4_x_jtext.getText()), Double.valueOf(c4_y_jtext.getText()));
		graficador.agregarPunto(coordenada0,"C1");
		graficador.agregarPunto(coordenada1,"C2");
		graficador.agregarPunto(coordenada2,"C3");
		graficador.agregarPunto(coordenada3,"C4");
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(23, 166, 350, 350);
		panel_2.add(graficador.dibujar());
		contentPane.add(panel_2);
		this.setVisible(true);
	
	}
	
	protected void dibujarCoordenadasPorDistancias() {
		Graficador graficador = new Graficador();
		
		Coordenada coordenada1 = new Coordenada(Double.valueOf(c1_x_jtext.getText()), Double.valueOf(c1_y_jtext.getText()));
		
		Coordenada coordenada2 = new Coordenada(Double.valueOf(c2_x_jtext.getText()), Double.valueOf(c2_y_jtext.getText()));
		Coordenada c2_calculada = new Coordenada(0.0,	Algoritmos.distanciaEntrePuntos(coordenada1, coordenada2));
		
		Double dc1c2=Double.valueOf(dc1c2_jtext.getText());
		Double dc1c3=Double.valueOf(dc1c3_jtext.getText());
		Double dc1c4=Double.valueOf(dc1c4_jtext.getText());
		Double dc2c3=Double.valueOf(dc2c3_jtext.getText());
		Double dc2c4=Double.valueOf(dc2c4_jtext.getText());
		Double dc3c4=Double.valueOf(dc3c4_jtext.getText());
		Double angulo_ghama = Algoritmos.reglaDelCoceno(dc1c2,dc1c3 ,dc2c3);
		Coordenada c3_calculada = new Coordenada(dc1c3 * Math.cos(angulo_ghama), dc1c3 * Math.sin(angulo_ghama));
			
		
		Double anguloLanda = Algoritmos.reglaDelCoceno(dc1c2, dc1c3, dc2c3);
		Double anguloBetha = Algoritmos.reglaDelCoceno(dc1c3,dc1c4,dc3c4);
	
		Double anguloAlpha = Algoritmos.reglaDelCoceno(dc1c4,dc1c2,dc2c4 );
		
		Coordenada c4_calculada=new Coordenada(0.0, 0.0);
		
		c4_calculada.setX(dc1c4 * Math.cos(anguloAlpha));
		c4_calculada.setY(dc1c4 * Math.sin(anguloAlpha));

		/*
		if (anguloBetha == Math.abs(anguloAlpha - anguloLanda)) {
			c4_calculada.setY(dc1c4 * Math.sin(anguloAlpha));
		} else {
			c4_calculada.setY(-1 * dc1c4 * Math.sin(anguloAlpha));
		}
		*/
		
	

		c2_calculada.setY(Math.round(c2_calculada.getY()*100)/100.0 );
		c3_calculada.setX(Math.round(c3_calculada.getX()*100)/100.0 );
		c3_calculada.setY(Math.round(c3_calculada.getY()*100)/100.0 );
		c4_calculada.setX(Math.round(c4_calculada.getX()*100)/100.0 );
		c4_calculada.setY(Math.round(c4_calculada.getY()*100)/100.0 );
		
		
		
		graficador.agregarPunto(coordenada1,"C1");
		graficador.agregarPunto(c2_calculada,"C2");
		graficador.agregarPunto(c3_calculada,"C3");
		graficador.agregarPunto(c4_calculada,"C4_calculado");
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(368, 166, 350, 350);
		panel_2.add(graficador.dibujar());
		contentPane.add(panel_2);
		this.setVisible(true);
	
	}
}
