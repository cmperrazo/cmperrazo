
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
public class Sonata extends JFrame{
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
     public Sonata(){
         
       // this.setSize(900,400);
        setTitle("ALL NEW SONATA  ");
        setBounds(200,440,960,250);
    //    setLocationRelativeTo(null);
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
        ImageIcon imagen = new ImageIcon("sonata.png");
        labelimagen.setBounds(10,10,275,140);
        panel.add(labelimagen);
        labelimagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(labelimagen.getWidth(), labelimagen.getHeight(), Image.SCALE_SMOOTH)));
        JLabel labelinfo = new JLabel();
        ImageIcon imginfo = new ImageIcon("infosonata.jpg");
        labelinfo.setBounds(295,1,650,210);
        panel.add(labelinfo);
        labelinfo.setIcon(new ImageIcon(imginfo.getImage().getScaledInstance(labelinfo.getWidth(), labelinfo.getHeight(), Image.SCALE_SMOOTH)));
 
    }
      private void crearBotones() {
        panel.setLayout(null);
 //BOTON COTIZAR

        boton1 = new JButton("");
        boton1.setBackground(Color.white);
        boton1.setBorderPainted(false);
        ImageIcon coti = new ImageIcon("cotiza.png");
        boton1.setBounds(60, 150, 190, 70);
        panel.add(boton1);
        boton1.setEnabled(true);
        boton1.setMnemonic('E');
        boton1.setIcon(new ImageIcon(coti.getImage().getScaledInstance(boton1.getWidth(), boton1.getHeight(), Image.SCALE_SMOOTH)));
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              CotiAuto coti = new CotiAuto();
              coti.setVisible(true);
                  
              dispose();
               
            }
        });
}
}

