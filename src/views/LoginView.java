package views;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JComponent {

//  Group members
//	   CUBAKA MUSHAMALIRWA CHRISTOPHE 18/973/BIT-S
//	   JOSUE PAUL LUSAKULIRA 17/443/BSCS-S
//	   LETEKIDAN TESFAY BELAY 17/697/BSCS-S
//	   TINAH KAJ MBANGU 18/896/BSCS-S
//	   YOGESH LAKHANI 18/038/BSCS-M

    public LoginView() {
        Form();
        window.getContentPane().setBackground(Color.LIGHT_GRAY);
    }


    JFrame window = new JFrame();
    JLabel title=new JLabel("SIGN IN");


    JLabel Label1 =new JLabel("USERNAME :");
    JLabel Label2 =new JLabel("PASSWORD :");

    JTextField TextBox1 =new JTextField(); //refers to the box next to username
    JPasswordField TextBox2 =new JPasswordField();//refers to the box next to password

    JButton Button2=new JButton("Cancel");
    JButton Button1=new JButton("Login");


    public void Form() {
        window.setTitle("screen");
        window.setBounds(100, 100, 600, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setVisible(true);

        //TITLE
        title.setBounds(280,40,100,200);
        title.setVisible(true);
        window.getContentPane().add(title);

        //LABLES
        Label1.setBounds(150, 180, 100, 20);//this is the USERNAME
        window.getContentPane().add(Label1);
        Label2.setBounds(150, 280, 100, 20);//this is the password
        window.getContentPane().add(Label2);


        //TEXTFIELDS FOR USERNAME AND PASSWORD
        TextBox1.setBounds(300, 180, 150, 20);// textfield area for username
        window.getContentPane().add(TextBox1);
        TextBox2.setBounds(300, 280, 150, 20);// textfield area for password
        window.getContentPane().add(TextBox2);

        //BUTTONS
        Button1.setBounds(150, 400, 100, 20); //LOGIN BUUTIN
        window.getContentPane().add(Button1);
        Button2.setBounds(300, 400, 100, 20);// CANCEL BUTTON
        window.getContentPane().add(Button2);



        Button1.addActionListener( new ActionListener() {

            //IF STATEMENT FOR LOGIN WHERE USERNAME IS ADMIN AND PASSWORD IS ADMIN
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                String User= TextBox1.getText();
                String password= TextBox2.getText();

                if(User.equals("admin") && password.equals("admin")) {   //USERNAME AND PASSWORD
                    JOptionPane.showMessageDialog(window, "USER LOGGED IN SUCCESSFULLY");
                }
                else {
                    JOptionPane.showMessageDialog(window, "USERNAME AND PASSWORD DOES NOT MATCH WHAT IS EXPECTED");
                }

            }
        });
    }
}
