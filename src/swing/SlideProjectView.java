package swing;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import swing.SlideProjectController.BackButtonListener;
import swing.SlideProjectController.TimerListener;

/**
 * @author Hugo
 *
 */

public class SlideProjectView extends JFrame{

	JPanel contentPane= new JPanel();
	JButton nextBouton = new JButton("Next");  
	JButton backBouton = new JButton("Preview"); 
	JButton nextBouton2 = new JButton("Next");
	JButton backBouton2 = new JButton("Preview");
	JButton searchBouton = new JButton();
	JLabel filmLabel = new JLabel("Film à l'affiche");
	JLabel cinLabel = new JLabel("Portail CineGO");
	JLabel vcinLabel = new JLabel("Vos Cinémas");
	JLabel imageLabel = new JLabel();
	JLabel imageLabel2 = new JLabel();
	JLabel imageLabel3 = new JLabel();
	JLabel imageLabel4 = new JLabel();

	JLabel[] listLabel = {
			imageLabel,
			imageLabel2,
			imageLabel3,
			imageLabel4,

	};

	JLabel cinemaLabel = new JLabel();
	JTextArea searchArea = new JTextArea("Recherchez...");
	Font police = new Font("Tahoma", Font.BOLD, 24);
	Font police2 = new Font("Tahoma", Font.BOLD, 40);
	Font police3 = new Font("Tahoma", Font.BOLD, 16);
	Timer tm;

	int u = 0;
	int v = 1;
	int w = 2;
	int x = 3;

	String[] choices = { "Accueil",
			"Mon compte",
			"Mes réservations",
			"Deconnection",
	};
	JComboBox<String> menu = new JComboBox<String>(choices);


	/**
	 *  TO DO COMMENTEZ LE ROLE DU CONSTRUCTEUR
	 */
	public SlideProjectView(){
		super("Java SlideShow");
		//Placement des �l�ments.
		contentPane.setLayout(null);	
		contentPane.setBackground(Color.decode("#FCFAE1"));
		menu.setBounds(10,10,140,20);
		menu.setBackground(Color.decode("#E1E6FA"));
		cinLabel.setBounds(370,20,300,100);
		filmLabel.setBounds(435,70,200,150);
		vcinLabel.setBounds(450, 465, 200, 150);
		imageLabel.setBounds(120, 190, 190, 280);
		imageLabel2.setBounds(320, 190, 190, 280);
		imageLabel3.setBounds(520, 190, 190, 280);
		imageLabel4.setBounds(720, 190, 190, 280);
		cinemaLabel.setBounds(460, 560, 130, 130);
		cinemaLabel.setBackground(Color.decode("#FCFAE1"));
		searchArea.setBounds(760, 10, 200, 32);
		searchArea.setBackground(Color.decode("#E1E6FA"));
		searchArea.setBorder(BorderFactory.createLineBorder(Color.black));
		searchArea.setFont(police3);
		backBouton.setBackground(Color.decode("#FCFAE1"));
		backBouton.setBounds(20,300,90,100);
		nextBouton.setBackground(Color.decode("#FCFAE1"));
		nextBouton.setBounds(920,300,90,100);
		backBouton2.setBackground(Color.decode("#FCFAE1"));
		backBouton2.setBounds(380,595,64,64);
		nextBouton2.setBackground(Color.decode("#FCFAE1"));
		nextBouton2.setBounds(610,595,64,64);
		searchBouton.setBackground(Color.decode("#FCFAE1"));
		searchBouton.setToolTipText("Rechercher");
		searchBouton.setBounds(960, 10, 32, 32);
		try {
			Image img = ImageIO.read(new File("SlideShowMovie/loupe.png"));
			searchBouton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		try {
			Image img = ImageIO.read(new File("SlideShowMovie/next.png"));
			nextBouton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		try {
			Image img = ImageIO.read(new File("SlideShowMovie/back.png"));
			backBouton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		try {
			Image img = ImageIO.read(new File("SlideShowMovie/next2.png"));
			nextBouton2.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		try {
			Image img = ImageIO.read(new File("SlideShowMovie/back2.png"));
			backBouton2.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}


		filmLabel.setFont(police);
		filmLabel.setForeground(Color.DARK_GRAY);
		vcinLabel.setFont(police);
		vcinLabel.setForeground(Color.DARK_GRAY);
		cinLabel.setFont(police2);
		cinLabel.setForeground(Color.DARK_GRAY);



		contentPane.add(cinLabel);
		contentPane.add(filmLabel);
		contentPane.add(vcinLabel);
		contentPane.add(menu);
		contentPane.add(imageLabel);
		contentPane.add(imageLabel2);
		contentPane.add(imageLabel3);
		contentPane.add(imageLabel4);
		contentPane.add(cinemaLabel);
		contentPane.add(backBouton);
		contentPane.add(nextBouton);
		contentPane.add(backBouton2);
		contentPane.add(nextBouton2);
		contentPane.add(searchBouton);
		contentPane.add(searchArea);
		add(contentPane);
		setResizable(false);
		setSize(1024, 760);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}



	/**
	 * @param i RESIZE THE SIZE OF THE LABEL.
	 * @param imageLabel 
	 */
	public void SetImageSize(JLabel label, String imagepath){
		ImageIcon icon = new ImageIcon(imagepath);
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newImc = new ImageIcon(newImg);
		label.setIcon(newImc);
	}


	JLabel getlistLabel(int key){
		return listLabel[key];
	}

	/**
	 * @param backButtonListener Controller Listener
	 */
	public void addBackButtonListener(BackButtonListener backButtonListener) {
		// TODO Auto-generated method stub
		backBouton.addActionListener(backButtonListener);

	}

	/**
	 * @param nextButtonListener Controller Listener
	 */
	public void addNextButtonListener(swing.SlideProjectController.NextButtonListener nextButtonListener) {
		// TODO Auto-generated method stub
		nextBouton.addActionListener(nextButtonListener);
	}
	/**
	 * @param timerListener Controller Listener
	 */
	public void addTimerListener(TimerListener timerListener) {
		// TODO Auto-generated method stub	
		tm = new Timer(5000,timerListener);
		tm.start();
	}	

}



