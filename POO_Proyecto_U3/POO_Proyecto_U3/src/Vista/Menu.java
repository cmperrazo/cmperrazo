
package Vista;


import Control.Conexion;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.HEIGHT;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class Menu extends JFrame{
    Conexion cc=new Conexion();
    Connection con = cc.conexion();
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private JButton botonatras;
     public JPanel panel;
     private JLabel txt1;
     public Menu(){
         
        this.setSize(1300,710);
        setTitle("MENU PRINCIPAL");
        //Para que cierre el sistema
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        //Centrar la ventana
        //setBounds(500,200,500,500);
        setLocationRelativeTo(null);
        iniciarComponentes();
    }
     private void iniciarComponentes(){
         colocarPanel(); 
        crearBotones();
         creacionTexto();  
        
        
}
     private void colocarPanel(){
        panel = new JPanel();
        //Damos color al panel
        panel.setBackground(Color.WHITE);
        //poner el panel sobre la ventana registro
        this.getContentPane().add(panel);       
    }
     
     private void creacionTexto(){
        
        JLabel labelimagen = new JLabel();
        ImageIcon imagen = new ImageIcon("hyundai.png");
        labelimagen.setBounds(370,50,500,70);
        panel.add(labelimagen);
        labelimagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(labelimagen.getWidth(), labelimagen.getHeight(), Image.SCALE_SMOOTH)));
                
  JLabel labelimagen2 = new JLabel();
        ImageIcon imagen2 = new ImageIcon("menu1.jpg");
        labelimagen2.setBounds(0,150,1300,165);
        panel.add(labelimagen2);
        labelimagen2.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(labelimagen2.getWidth(), labelimagen2.getHeight(), Image.SCALE_SMOOTH)));
 
        
  
    }

    private void crearBotones() {
        panel.setLayout(null);
 //BOTON ATRAS
        botonatras = new JButton();
        ImageIcon imagenatras = new ImageIcon("atras.png");
        botonatras.setBounds(15,15,32,30);
        panel.add(botonatras);
        botonatras.setEnabled(true);
        botonatras.setMnemonic('A');
        botonatras.setIcon(new ImageIcon(imagenatras.getImage().getScaledInstance(botonatras.getWidth(), botonatras.getHeight(), Image.SCALE_SMOOTH)));
        botonatras.addActionListener((ActionEvent e) -> {
            // Cerrar la ventana y terminar el programa
            dispose(); // Cierra la ventana actual
            Login in = new Login();
            in.setVisible(true);
        });  
        boton1 = new JButton("AUTOS");
        boton1.setBounds(0, 550, 433, 50);
        panel.add(boton1);
        boton1.setEnabled(true);
        boton1.setMnemonic('E');
        boton1.setForeground(Color.white);
        boton1.setBackground(Color.BLACK);
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Autos auto = new  Autos ();
              auto.setVisible(true);            
            JOptionPane.showMessageDialog(null,"Bienvenido a la personalización de Autos");   
            dispose();
               
            }
        });
        JLabel labelimagen2 = new JLabel();
        ImageIcon imagen2 = new ImageIcon("auto.png");
        labelimagen2.setBounds(50,345,390,230);
        panel.add(labelimagen2);
        labelimagen2.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(labelimagen2.getWidth(), labelimagen2.getHeight(), Image.SCALE_SMOOTH)));
  

        
        boton2 = new JButton("SUVS");
        boton2.setBounds(433, 550, 433, 50);
        panel.add(boton2);
        boton2.setEnabled(true);
        boton2.setMnemonic('P');
        boton2.setForeground(Color.white);
        boton2.setBackground(Color.black);
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Suvs suv = new  Suvs ();
              suv.setVisible(true);  
              JOptionPane.showMessageDialog(null,"Bienvenido a la personalización de Suvs");   
               dispose();
             ;
            }
        });
        JLabel labelimagen3 = new JLabel();
        ImageIcon imagen3 = new ImageIcon("suvs.png");
        labelimagen3.setBounds(443,345,390,230);
        panel.add(labelimagen3);
        labelimagen3.setIcon(new ImageIcon(imagen3.getImage().getScaledInstance(labelimagen3.getWidth(), labelimagen3.getHeight(), Image.SCALE_SMOOTH)));
        
        boton3 = new JButton("VANS");
        boton3.setBounds(866, 550, 433, 50);
        panel.add(boton3);
        boton3.setEnabled(true);
        boton3.setMnemonic('H');
        boton3.setForeground(Color.white);
        boton3.setBackground(Color.black);
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Vans van = new Vans ();
              van.setVisible(true);  
              JOptionPane.showMessageDialog(null,"Bienvenido a la personalización de VANS");
               dispose();
              
            }
        });
        JLabel labelimagen4 = new JLabel();
        ImageIcon imagen4 = new ImageIcon("vans.png");
        labelimagen4.setBounds(886,345,390,230);
        panel.add(labelimagen4);
        labelimagen4.setIcon(new ImageIcon(imagen4.getImage().getScaledInstance(labelimagen4.getWidth(), labelimagen4.getHeight(), Image.SCALE_SMOOTH)));
        
    }
}
