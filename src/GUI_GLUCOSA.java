import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class GUI_GLUCOSA extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textVALOR;
	private JTextField textNOMBRE;
	private JList list;
	private JComboBox comboBox_DIA;
    private JComboBox comboBox_MES;
    private JComboBox comboBox_AÑO;
    LocalDate hoy = LocalDate.now();
	
	
    private DefaultListModel modelo = new DefaultListModel();
	private MANEJO_PERSONA manejo = new MANEJO_PERSONA();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_GLUCOSA frame = new GUI_GLUCOSA();
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
	public GUI_GLUCOSA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_titulo = new JLabel("REGISTRAR GLUCOSA");
		lbl_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_titulo.setBounds(20, 75, 232, 12);
		contentPane.add(lbl_titulo);
		
		JLabel lbl_nombre = new JLabel("NOMBRE");
		lbl_nombre.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_nombre.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_nombre.setBounds(10, 110, 77, 12);
		contentPane.add(lbl_nombre);
		
		JLabel lbl_valor = new JLabel("TOMA VALOR");
		lbl_valor.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_valor.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_valor.setBounds(10, 141, 77, 12);
		contentPane.add(lbl_valor);
		
		textVALOR = new JTextField();
		textVALOR.setColumns(10);
		textVALOR.setBounds(102, 138, 150, 18);
		contentPane.add(textVALOR);
		
		textNOMBRE = new JTextField();
		textNOMBRE.setColumns(10);
		textNOMBRE.setBounds(102, 107, 150, 18);
		contentPane.add(textNOMBRE);
		
		JLabel lbl_fecha = new JLabel("FECHA");
		lbl_fecha.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fecha.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_fecha.setBounds(10, 177, 242, 12);
		contentPane.add(lbl_fecha);
		
		comboBox_DIA = new JComboBox();
		comboBox_DIA.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_DIA.setSelectedIndex(hoy.getDayOfMonth() - 1);
		comboBox_DIA.setBounds(10, 201, 242, 20);
		contentPane.add(comboBox_DIA);
		
		comboBox_MES = new JComboBox();
		comboBox_MES.setModel(new DefaultComboBoxModel(new String[] {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"}));
		comboBox_MES.setSelectedIndex(hoy.getMonthValue() - 1);
		comboBox_MES.setBounds(10, 231, 242, 20);
		contentPane.add(comboBox_MES);
		
		comboBox_AÑO = new JComboBox();
		comboBox_AÑO.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035"}));
		comboBox_AÑO.setSelectedItem(String.valueOf(hoy.getYear()));
		comboBox_AÑO.setBounds(10, 261, 242, 20);
		contentPane.add(comboBox_AÑO);
		
		
		
		JButton btn_agregar = new JButton("AGREGAR");
		btn_agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            String nombre = textNOMBRE.getText();
		            int valor = Integer.parseInt(textVALOR.getText());

		            int dia = comboBox_DIA.getSelectedIndex() + 1;
		            int mes = comboBox_MES.getSelectedIndex() + 1;
		            int año = Integer.parseInt(comboBox_AÑO.getSelectedItem().toString());

		            if (!manejo.insertarOrdenado(nombre, valor, dia, mes, año)) {
		                JOptionPane.showMessageDialog(null, "PERSONA YA EXISTE");
		            }else {
		            	JOptionPane.showMessageDialog(null, "REGISTRO GUARDADO");	
		            }

		            textNOMBRE.setText("");
		            textVALOR.setText("");

		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "ERROR EN DATOS");
		        }
			}
		});
		btn_agregar.setBounds(10, 291, 242, 20);
		contentPane.add(btn_agregar);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(new Color(192, 192, 192));
		toolBar.setForeground(new Color(128, 128, 192));
		toolBar.setBounds(5, 10, 130, 21);
		contentPane.add(toolBar);
		
		JButton btn_historial = new JButton("VER HISTORIAL");
		btn_historial.setFont(new Font("Tahoma", Font.BOLD, 10));
		btn_historial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manejo.estaVacia()) {
		            JOptionPane.showMessageDialog(null, "AUN NO HAY REGISTROS");
		        } else {
		            manejo.recorrerLista(modelo);
		        }
			}
		});
		toolBar.add(btn_historial);
		
		JLabel lbl_historial = new JLabel("HISTORIAL");
		lbl_historial.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_historial.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_historial.setBounds(266, 75, 312, 12);
		contentPane.add(lbl_historial);
		
		list = new JList(modelo);
		list.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		list.setForeground(new Color(0, 0, 0));
		list.setBounds(266, 107, 312, 174);
		contentPane.add(list);

	}
}

