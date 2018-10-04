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

/**
 * @author Hugo
 *
 */
public class OldSlideProject extends JFrame{

	JPanel contentPane= new JPanel();
	JPanel northPan = new JPanel();
	JPanel rightPan = new JPanel();   
	JPanel leftPan = new JPanel();   
	JPanel sudPan = new JPanel();   
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

	JLabel cinemaLabel = new JLabel();
	JTextArea searchArea = new JTextArea("Recherchez...");
	Font police = new Font("Tahoma", Font.BOLD, 24);
	Font police2 = new Font("Tahoma", Font.BOLD, 40);
	Font police3 = new Font("Tahoma", Font.BOLD, 16);
	Timer tm;
	int v = 0;
	int w = 0;
	int x = 1;
	int y = 2;
	int z = 3;
	String[] choices = { "Accueil",
			"Mon compte",
			"Mes réservations",
			"Deconnection",
	};
	JComboBox<String> menu = new JComboBox<String>(choices);

	String[] listFilm = {
			"SlideShowMovie/avenger.jpg",//1
			"SlideShowMovie/diversion.jpg",//2
			"SlideShowMovie/harrypotter.jpg",//3
			"SlideShowMovie/avatar.jpg",//0
			"SlideShowMovie/persia.jpg",//4
			"SlideShowMovie/sherlockholms.jpg",//5
			"SlideShowMovie/taxi.jpg",//6
			"SlideShowMovie/wonderwoman.jpg"//7
			/*"E:/SlideShow/avenger.jpg",
    		"E:/SlideShow/diversion.jpg",
    		"E:/SlideShow/harrypotter.jpg",
    		"E:/SlideShow/avatar.jpg",
    		"E:/SlideShow/persia.jpg",
    		"E:/SlideShow/sherlockholms.jpg",
    		"E:/SlideShow/taxi.jpg"*/
	};

	String[] listCinema = {
			"SlideShowMovie/UGC.png",
			"SlideShowMovie/Gaumont1.png",
			"SlideShowMovie/Gaumont2.png",
			/*"E:/SlideShow/UGC.png",
    		"E:/SlideShow/Gaumont1.png",
    		"E:/SlideShow/Gaumont2.png",*/

	};

	/**
	 *  TO DO COMMENTEZ LE ROLE DU CONSTRUCTEUR
	 */
	public OldSlideProject(){
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
		//Call The Function SetImageSize
		SetImageSize(0, imageLabel);
		SetImageSize(1, imageLabel2);
		SetImageSize(2, imageLabel3);
		SetImageSize(3, imageLabel4);
		SetCinemaSize(0);

		//set a timer
		tm = new Timer(3000,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {


				w += 1;
				if(w >= listFilm.length )
					w = 0; 
				SetImageSize(w, imageLabel);

				x += 1;
				if(x >= listFilm.length )
					x = 0; 
				SetImageSize(x, imageLabel2);

				y += 1;
				if(y >= listFilm.length )
					y = 0; 
				SetImageSize(y, imageLabel3);

				z += 1;
				if(z >= listFilm.length )
					z = 0; 
				SetImageSize(z, imageLabel4);


			}
		});
		backBouton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					SetImageSize(w, imageLabel);
					w -= 1;
					if(w < 0)
						w = listFilm.length-1;
					if(w > listFilm.length)
						w = 0;

					SetImageSize(x, imageLabel2);
					x -= 1;
					if(x < 0 )
						x = (listFilm.length)-1;
					if(x > listFilm.length)
						x = 1;

					SetImageSize(y, imageLabel3);
					y -= 1;
					if(y < 0 )
						y = (listFilm.length)-1;
					if(y > listFilm.length)
						y = 2;

					SetImageSize(z, imageLabel4);              	
					z -= 1;
					if(z < 0 )
						z = (listFilm.length)-1;
					if(z > listFilm.length)
						z = 3;
				} catch (ArrayIndexOutOfBoundsException a)
				{
					a.printStackTrace();
				}



			}
		});
		nextBouton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				w += 1;
				if(w >= listFilm.length )
					w = 0; 
				SetImageSize(w, imageLabel);

				x += 1;
				if(x >= listFilm.length )
					x = 0; 
				SetImageSize(x, imageLabel2);

				y += 1;
				if(y >= listFilm.length )
					y = 0; 
				SetImageSize(y, imageLabel3);

				z += 1;
				if(z >= listFilm.length )
					z = 0; 
				SetImageSize(z, imageLabel4);
			}
		});
		backBouton2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				v -= 1;
				if(v < 0)
					v = listCinema.length-1;
				if(v > listCinema.length)
					v = 0;
				SetCinemaSize(v);

			}
		});
		nextBouton2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SetCinemaSize(v);
				v += 1;
				if(v >= listCinema.length)
					v = 0;
				if(v < 0)
					v = listCinema.length;
			}
		});
		tm.start();

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
	 * @param i TO DO COMMENTER
	 * @param imageLabel 
	 */
	public void SetImageSize(int i, JLabel imageLabel){
		ImageIcon icon = new ImageIcon(listFilm[i]);
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newImc = new ImageIcon(newImg);
		imageLabel.setIcon(newImc);
	}

	/**
	 * @param i TO DO COMMENTER
	 */
	public void SetCinemaSize(int i){
		ImageIcon icon = new ImageIcon(listCinema[i]);
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(cinemaLabel.getWidth(), cinemaLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newImc = new ImageIcon(newImg);
		cinemaLabel.setIcon(newImc);
	}



	/**
	 * @param args TO DO COMMENTER
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new OldSlideProject();

	}

}

