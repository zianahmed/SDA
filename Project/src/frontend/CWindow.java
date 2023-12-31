package frontend;

import Modules.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CWindow extends JFrame {
	private JLabel welcomeLabel;
	private Customer c;
	private JPanel centerPanel;
    private JButton ub;
	private static final long serialVersionUID = 1L;

    
    
    public CWindow(Customer customer) {
    	c=customer;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 800, 600);

        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(40, 150, 191));
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        welcomeLabel = new JLabel("F  I  X  I  T");
        welcomeLabel.setFont(new Font("Arial Black", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.WHITE);
        topPanel.add(welcomeLabel);

        getContentPane().add(topPanel, BorderLayout.NORTH);

        // Left Panel for Buttons
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(40, 150, 191));
        leftPanel.setLayout(new GridLayout(4, 1, 10, 10));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton bSearch = createButton("Search");
        JButton bAppointment = createButton("Appointment");
        JButton bHome = createButton("Home");
        JButton bExit = createButton("Exit");

        leftPanel.add(bHome);
        leftPanel.add(bSearch);
        leftPanel.add(bAppointment);
        leftPanel.add(bExit);

        getContentPane().add(leftPanel, BorderLayout.WEST);

        centerPanel = new JPanel();
        centerPanel.setLayout(null);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        centerPanel.setBackground(Color.white);
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        
        JLabel nl = new JLabel("Name: ");
        nl.setFont(new Font("Arial Black", Font.BOLD, 14));
        nl.setBounds(82, 79, 218, 45);
        centerPanel.add(nl);
        
        JLabel pl = new JLabel("Phone No: ");
        pl.setFont(new Font("Arial Black", Font.BOLD, 14));
        pl.setBounds(382, 79, 218, 45);
        centerPanel.add(pl);
        
        JLabel gl = new JLabel("Gender: ");
        gl.setFont(new Font("Arial Black", Font.BOLD, 14));
        gl.setBounds(82, 135, 218, 45);
        centerPanel.add(gl);
        
        JLabel dl = new JLabel("DOB:  ");
        dl.setFont(new Font("Arial Black", Font.BOLD, 14));
        dl.setBounds(382, 135, 218, 45);
        centerPanel.add(dl);
        
        JLabel cl = new JLabel("City: ");
        cl.setFont(new Font("Arial Black", Font.BOLD, 14));
        cl.setBounds(82, 185, 218, 45);
        centerPanel.add(cl);
        
        ub = new JButton("UPDATE");
        ub.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	CInfo cv=new CInfo(c);
        	cv.setVisible(true);
        	HomeButton(c);
        	}
        });
        
        ub.setForeground(new Color(255, 255, 255));
        ub.setBackground(new Color(40, 150, 192));
        ub.setFont(new Font("Arial Black", Font.BOLD, 14));
        ub.setBounds(260, 323, 161, 37);
        centerPanel.add(ub);

        if(c!=null) {
        	nl.setText("Name: " + c.getName());
        	pl.setText("Phone No: " + c.getPhone());
        	gl.setText("Gender: " + c.getGender());
        	cl.setText("City: " + c.getCity());
        	dl.setText("DOB: " + c.getDob());
        }
        
        
        setVisible(true);
    }

    private void HomeButton(Customer customer) {
    	
    	getContentPane().remove(centerPanel); 
    	centerPanel = new JPanel();
        centerPanel.setLayout(null);
        centerPanel.setBackground(Color.white);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        
        JLabel nl = new JLabel("Name: ");
        nl.setFont(new Font("Arial Black", Font.BOLD, 14));
        nl.setBounds(82, 79, 218, 45);
        centerPanel.add(nl);
        
        JLabel pl = new JLabel("Phone No: ");
        pl.setFont(new Font("Arial Black", Font.BOLD, 14));
        pl.setBounds(382, 79, 218, 45);
        centerPanel.add(pl);
        
        JLabel gl = new JLabel("Gender: ");
        gl.setFont(new Font("Arial Black", Font.BOLD, 14));
        gl.setBounds(82, 135, 218, 45);
        centerPanel.add(gl);
        
        JLabel dl = new JLabel("DOB:  ");
        dl.setFont(new Font("Arial Black", Font.BOLD, 14));
        dl.setBounds(382, 135, 218, 45);
        centerPanel.add(dl);
        
        JLabel cl = new JLabel("City: ");
        cl.setFont(new Font("Arial Black", Font.BOLD, 14));
        cl.setBounds(82, 185, 218, 45);
        centerPanel.add(cl);
        
        centerPanel.add(ub);

        if(c!=null) {
        	nl.setText("Name: " + c.getName());
        	pl.setText("Phone No: " + c.getPhone());
        	gl.setText("Gender: " + c.getGender());
        	cl.setText("City: " + c.getCity());
        	dl.setText("DOB: " + c.getDob());
        }
        
        getContentPane().add(centerPanel, BorderLayout.CENTER);
	    
	    getContentPane().revalidate();
	    getContentPane().repaint();
	    
    }
    
    private JButton createButton(String buttonText) {
        JButton button = new JButton(buttonText);
        button.setFont(new Font("Arial Black", Font.BOLD, 12));
        button.setBackground(new Color(0, 128, 192));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (buttonText=="Exit") {
                	Login lg=new Login();
                	lg.setVisible(true);
                	dispose();
                }
                if (buttonText.equals("Search")) {
                	   	welcomeLabel.setText("S  E  A  R  C  H");
                		getContentPane().remove(centerPanel); 
                	    
                	    centerPanel = new CSearch(c);
                	    centerPanel.setVisible(true);
                	    
                	    getContentPane().add(centerPanel, BorderLayout.CENTER);
                	    
                	    getContentPane().revalidate();
                	    getContentPane().repaint();
                }
                if (buttonText.equals("Home")) {
                   	welcomeLabel.setText("F  I  X  I  T");
                	HomeButton(c);
                }
                if (buttonText.equals("Appointment")) {
                   	welcomeLabel.setText("A P P O I N T M E N T");
                	getContentPane().remove(centerPanel); 
            	    
            	    centerPanel = new CAppointment(c);
            	 
            	    centerPanel.setVisible(true);
            	    getContentPane().add(centerPanel, BorderLayout.CENTER);
            	    
            	    getContentPane().revalidate();
            	    getContentPane().repaint();
            }
            }
        });
        return button;
    }

    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Customer customer = new Customer();
            customer.setName("");
            customer.setPhone("");
            customer.setCity("");
            customer.setGender("");
            customer.setDob("");

            CWindow cWindow = new CWindow(customer);
        });
    }
}
