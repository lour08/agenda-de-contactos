package agenda;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;

public class MostrarContactos extends JDialog {
    JPanel panel;
    File contactData;
    DefaultTableModel defaultTableModel;
    public MostrarContactos(String title){
       this.setTitle(title);
       this.setSize(600,400);
       this.setLocationRelativeTo(null);
       this.setVisible(true);
       initComponents();
       putInfo();
    }
    private void initComponents(){
        panel= new JPanel();
        panel.setBackground(new Color(7, 16, 19));
        panel.setLayout(null);
        this.setContentPane(panel);

        JLabel title= new JLabel("Contactos Agregados");
        title.setFont(new Font("Candy Beans",1,40));
        title.setForeground(Color.WHITE);
        title.setBounds(70,40,500,40);
        panel.add(title);

         defaultTableModel= new DefaultTableModel();
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("Email");
        defaultTableModel.addColumn("Phone");

        contactData= new File("src/agenda/contactData.txt");


        JTable tablaContactos= new JTable(defaultTableModel);
        tablaContactos.setBounds(30,100,400,300);
        JScrollPane scrollBar= new JScrollPane(tablaContactos,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(tablaContactos);
        panel.add(scrollBar);

    }
    private void putInfo(){
        try {
            FileReader fileReader= new FileReader("src/agenda/contactData.txt");
            BufferedReader bufferedReader= new BufferedReader(fileReader);
            String cadena=bufferedReader.readLine();
            String contactInfo[]= new String[3];
            int i=0;
            while (cadena!=null){
                contactInfo[i]=cadena;
                cadena= bufferedReader.readLine();
                if (i==2){
                    defaultTableModel.addRow(contactInfo);
                    i=-1;
                }
                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
