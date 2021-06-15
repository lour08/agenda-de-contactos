package agenda;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AgendaContactos extends JFrame{
    JPanel panel;
    JMenuBar mainMenu;
    JMenu menu;
    JMenuItem contactos;
    JMenuItem salir;
    JButton addContact;
    File contactData;
    JTextField contactName,contactEmail,contactPhone;

    public AgendaContactos(String title){
        super(title);
        this.setSize(600,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
        menuBar();
        initComponents();
        events();

    }
    private void menuBar(){
        mainMenu= new JMenuBar();
        menu= new JMenu("Menú");
        mainMenu.add(menu);
        contactos= new JMenuItem("Mostrar Contactos");
        menu.add(contactos);
        ActionListener showContactos= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarContactos mostrarContactos= new MostrarContactos("Contactos guardados");
            }
        };
        contactos.addActionListener(showContactos);
        salir= new JMenuItem("Salir");
        menu.add(salir);
        this.setJMenuBar(mainMenu);
    }
    private void initComponents(){
        panel= new JPanel();
        panel.setBackground(new Color(7, 16, 19));
        panel.setLayout(null);
        this.setContentPane(panel);
        JLabel title= new JLabel("Agenda de contactos");
        title.setFont(new Font("Candy Beans",1,40));
        title.setForeground(Color.WHITE);
        title.setBounds(70,15,500,40);
        panel.add(title);

        Font font= new Font("Candy Beans",1,24);
        JLabel name= new JLabel("Nombre: ");
        name.setForeground(Color.WHITE);
        name.setFont(font);
        name.setBounds(10,120,200,28);
        panel.add(name);

         contactName= new JTextField();
        contactName.setBounds(170,120,400,28);
        panel.add(contactName);

        JLabel email= new JLabel("Email: ");
        email.setFont(font);
        email.setForeground(Color.WHITE);
        email.setBounds(10,200,200,28);
        panel.add(email);

          contactEmail= new JTextField();
        contactEmail.setBounds(170,200,400,28);
        panel.add(contactEmail);

        JLabel celular= new JLabel("Celular: ");
        celular.setForeground(Color.WHITE);
        celular.setFont(font);
        celular.setBounds(10,280,200,28);
        panel.add(celular);

         contactPhone= new JTextField();
        contactPhone.setBounds(170,280,400,28);
        panel.add(contactPhone);

        addContact= new JButton("Agregar Contacto");
        addContact.setBounds(130,360,400,35);
        addContact.setFont(font);

        panel.add(addContact);
    }
    private void events(){
        ActionListener onAdd= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
                contactName.setText("");
                contactEmail.setText("");
                contactPhone.setText("");
            }
        };
        addContact.addActionListener(onAdd);
    }

    private void saveData(){
        contactData= new File("src/agenda/contactData.txt");
        try {
            contactData.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fileWriter= new FileWriter("src/agenda/contactData.txt",true);
            String name= contactName.getText();
            String email= contactEmail.getText();
            String phone= contactPhone.getText();
            fileWriter.write("\r\n"+name);
            fileWriter.write("\r\n"+email);
            fileWriter.write("\r\n"+phone);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public static void main(String[] args) {
        JFrame agendaDeContactos= new AgendaContactos("Agenda de Contactos");
    }


}
