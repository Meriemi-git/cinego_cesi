/*
 * TestJFormatedTxtField.java                                24 févr. 2016
 * IUT Info1 2013-2014 Groupe 3
 */
package cineGOv02.admin.view;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.text.NumberFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * TODO commenter les responsabilités classe
 * @author hustariz
 *
 */
public class TestJFormatedTxtField extends JPanel{
	/** TODO commenter le Champ */
	private JTextField textField;
	/**
	 * TODO commenter le role du Constructeur
	 */
	private char Period = '.';
	/**
	 * TODO commenter le role du Constructeur
	 */
	public TestJFormatedTxtField() {
		
		JLabel lblTestJformattedtxtfield = new JLabel("Test JFormattedTxtField");
		lblTestJformattedtxtfield.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JFormattedTextField formattedTextField = new JFormattedTextField(NumberFormat.getNumberInstance());
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent event) {
				char c = event.getKeyChar();
				if(!(Character.isDigit(c) 
						|| c==KeyEvent.VK_DELETE 
						|| c==KeyEvent.VK_PERIOD)){
					getToolkit().beep();
					event.consume();
				}
			}
		});
		textField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(141)
							.addComponent(lblTestJformattedtxtfield))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(83)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textField, Alignment.LEADING)
								.addComponent(formattedTextField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))))
					.addContainerGap(141, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(lblTestJformattedtxtfield)
					.addGap(70)
					.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(150, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	/**
	 * TODO commenter le role de la Méthode
	 * @param args
	 */
	public static void main(String[] args) {
		TestJFormatedTxtField bla = new TestJFormatedTxtField();
		JFrame frame = new JFrame();
        frame.setMinimumSize(new Dimension(265,250));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setContentPane(bla);
        frame.setTitle("Initialisation");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
