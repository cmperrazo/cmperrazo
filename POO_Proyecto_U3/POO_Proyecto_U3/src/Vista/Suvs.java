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
import javax.swing.JFrame;

public class Suvs extends JFrame{
    Conexion cc=new Conexion();
    Connection con = cc.conexion();
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private JButton boton4;
    private JButton boton5;
    private JButton boton6;
    
    private JButton botonatras;
     public JPanel panel;
     private JLabel hb;
     public Suvs(){
         
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
         public void cerrar(){
              this.dispose();
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
            Menu main = new Menu();
            main.setVisible(true);
        }); 
        boton1 = new JButton("AUTOS");
        boton1.setBounds(0, 130, 433, 50);
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
        
        
        boton2 = new JButton("SUVS");
        boton2.setBounds(433, 130, 433, 50);
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
       
        boton3 = new JButton("VANS");
        boton3.setBounds(866, 130, 433, 50);
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
        //AUTO HATCHBACK
        boton4 = new JButton(" KONA ELECTRICO ");
        boton4.setBounds(190, 350, 300, 50);
        panel.add(boton4);
        boton4.setEnabled(true);
        boton4.setMnemonic('H');
        boton4.setForeground(Color.BLACK);
        boton4.setBackground(Color.white);
        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              KonaE konae = new KonaE();
              konae.setVisible(true);
              
              
            }
        });
        JLabel hb = new JLabel();
        ImageIcon imghb = new ImageIcon("kona.png");
        hb.setBounds(195,200,300,150);
        panel.add(hb);
        hb.setIcon(new ImageIcon(imghb.getImage().getScaledInstance(hb.getWidth(), hb.getHeight(), Image.SCALE_SMOOTH)));
        
        //AUTO HYBRID
        boton5 = new JButton("ALL NEW TUCSON  ");
        boton5.setBounds(790, 350, 300, 50);
        panel.add(boton5);
        boton5.setEnabled(true);
        boton5.setMnemonic('H');
        boton5.setForeground(Color.BLACK);
        boton5.setBackground(Color.white);
        boton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Tucson tucson = new Tucson();
              tucson.setVisible(true);
              
              
            }
        });
        JLabel hybrid = new JLabel();
        ImageIcon imghybrid = new ImageIcon("tucson.png");
        hybrid.setBounds(785,200,310,160);
        panel.add(hybrid);
        hybrid.setIcon(new ImageIcon(imghybrid.getImage().getScaledInstance(hybrid.getWidth(),hybrid.getHeight(), Image.SCALE_SMOOTH)));        
        
         //AUTO HYBRID
        boton6 = new JButton("KONA HYBRID");
        boton6.setBounds(500, 580, 300, 50);
        panel.add(boton6);
        boton6.setEnabled(true);
        boton6.setMnemonic('H');
        boton6.setForeground(Color.BLACK);
        boton6.setBackground(Color.white);
        boton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              KonaHybrid konahybrid = new KonaHybrid();
              konahybrid.setVisible(true);
               
            }
        });
        JLabel sonata = new JLabel();
        ImageIcon imgsonata = new ImageIcon("konahybrid.png");
        sonata.setBounds(495,425,310,160);
        panel.add(sonata);
        sonata.setIcon(new ImageIcon(imgsonata.getImage().getScaledInstance(sonata.getWidth(),sonata.getHeight(), Image.SCALE_SMOOTH)));        
        
        
        
    }
}
