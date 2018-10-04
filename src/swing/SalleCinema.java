
package swing;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import javax.swing.*;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class SalleCinema extends JFrame
{
	/** TODO commenter le Champ */
	private static final String INITIAL_TEXT = "Nothing Pressed";
	/** TODO commenter le Champ */
	private static final String ADDED_TEXT = " was Pressed";
	/** TODO commenter le Champ */
	private JLabel positionLabel;
	/** TODO commenter le Champ */
	private JButton resetButton;
	/** TODO commenter le Champ */
	private static int rangee = 0;
	/** TODO commenter le Champ */
	private static int sieges = 0;

	/**
	 * TODO commenter le role de la Méthode
	 * @param pgridSize
	 * @return dfgdf
	 */
	public static int setrangee(int pgridSize)
	{
		return rangee = pgridSize;
	}

	/**
	 * TODO commenter le role de la Méthode
	 * @param psieges
	 * @return dfgdfg
	 */
	public static int setsieges(int psieges)
	{
		return sieges = psieges;
	}

	/**
	 * TODO commenter le role du Constructeur
	 */
	public SalleCinema()
	{
		super("Salle cin�ma");
	}

	/**
	 * TODO commenter le role de la Méthode
	 */
	private void createAndDisplayGUI()
	{       
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel contentPane = new JPanel();
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
		contentPane.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));    
		JPanel labelPanel = new JPanel();
		positionLabel = new JLabel(INITIAL_TEXT, JLabel.CENTER);
		JPanel buttonLeftPanel = new JPanel();
		resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				positionLabel.setText(INITIAL_TEXT);
			}
		});
		labelPanel.add(positionLabel);
		buttonLeftPanel.add(resetButton);
		leftPanel.add(labelPanel);
		leftPanel.add(buttonLeftPanel);

		contentPane.add(leftPanel);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(rangee, sieges, 10, 10));
		for (int i = 0; i < rangee; i++)
		{
			for (int j = 0; j < sieges; j++)
			{
				JButton button = new JButton("(" + i + ", " + j + ")");
				button.setActionCommand("(" + i + ", " + j + ")");
				button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent ae)
					{
						JButton but = (JButton) ae.getSource();
						positionLabel.setText(
								but.getActionCommand() + ADDED_TEXT);                           
					}
				});
				buttonPanel.add(button);
			}
		}
		contentPane.add(buttonPanel);

		setContentPane(contentPane);
		pack();
		setLocationByPlatform(true);
		setVisible(true);
	}

	/**
	 * TODO commenter le role de la Méthode
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.print("Combien de rang�es de si�ges voulez-vous? : ");
		Scanner sc = new Scanner(System.in);
		setrangee(sc.nextInt());
		System.out.print("Combien de si�ges voulez-vous par rang�es? : ");
		setsieges(sc.nextInt());
		if (args.length > 0)
		{
			rangee = Integer.parseInt(args[0]);
			sieges = Integer.parseInt(args[0]);
		}
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new SalleCinema().createAndDisplayGUI();
			}
		});
	}
}