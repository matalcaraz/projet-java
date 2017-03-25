package com.aither.ui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JFrame;

import com.aither.custom.CarteButton;
import com.aither.model.Carte;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class Test {

	private JFrame frame;
	private CarteButton currentCarte,carte2;
	int coups=0,points=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1745, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][][]", "[][][]"));
		
		textField = new JTextField();
		frame.getContentPane().add(textField, "cell 11 0,growx,aligny top");
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		frame.getContentPane().add(textField_1, "cell 11 1,growx,aligny top");
		textField_1.setColumns(10);

		ArrayList <Carte> liste =new ArrayList<Carte>();
		ArrayList<Carte> deck =new ArrayList<Carte>();
		int x=0,y=0;

		String couleur = "co";

		remplissage(couleur,liste);
		shuffleArray(liste);
		deck.addAll(liste);
		shuffleArray(liste);
		deck.addAll(liste);
		
		creationbouton (y, x, deck, frame);


	}



	static void shuffleArray(ArrayList<Carte> Liste)
	{
		// If running on Java 6 or older, use `new Random()` on RHS here
		Random rnd = ThreadLocalRandom.current();
		for (int i = Liste.size()- 1; i > 0; i--)
		{
			int index = rnd.nextInt(i + 1);
			// Simple swap
			Carte a = Liste.get(index);
			Liste.set(index, Liste.get(i));
			Liste.set(i, a);
		}
	}

	void remplissage (String couleur,ArrayList<Carte> liste)
	{
		String carteS;
		switch ( couleur )
		{
		case "co": 
			for(int i=1;i<9;i++){

				carteS = "/"+i+couleur+".gif";
				Carte carte = new Carte(carteS, "/dos.jpg");
				liste.add(carte);

			}
			couleur="ca";	

		case "ca": 
			for(int i=1;i<9;i++){

				carteS = "/"+i+couleur+".gif";
				Carte carte = new Carte(carteS, "/dos.jpg");
				liste.add(carte);
			}
			couleur="t";

		case "t": 
			for(int i=1;i<9;i++){

				carteS = "/"+i+couleur+".gif";
				Carte carte = new Carte(carteS, "/dos.jpg");
				liste.add(carte);
			}
			couleur="p";

		case "p": 
			for(int i=1;i<9;i++){

				carteS = "/"+i+couleur+".gif";
				Carte carte = new Carte(carteS, "/dos.jpg");
				liste.add(carte);
			}
			couleur="Null";
			break;
		default :

		}
	}


	void creationbouton (int y, int x,ArrayList<Carte> liste,JFrame frame)
	{
		CarteButton btnNewButton;
		for (Carte carte : liste) {
			if(x<9)
			{
				btnNewButton = new CarteButton(carte);
				frame.getContentPane().add(btnNewButton, "cell "+x+" "+y+", shrink 0");
				x=x+1;
			}
			else
			{
				btnNewButton = new CarteButton(carte);
				frame.getContentPane().add(btnNewButton, "cell "+x+" "+y+", shrink 0");
				x=0;
				y=y+1;
			}
			btnNewButton.addActionListener(action);
		}
		
	}
	
	private ActionListener action = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e)
		{
			CarteButton cartebtn = (CarteButton)e.getSource();
			cartebtn.setEnabled(false);
			if(currentCarte == null){
				currentCarte = cartebtn ;
				coups=coups+1;
				System.out.println("coups= "+ coups);
				textField.setText("coups :"+coups);
			}else if(carte2==null)
			{
				carte2=cartebtn;
				if(currentCarte.carte.nomImageFace.equals(carte2.carte.nomImageFace)){
					currentCarte.setVisible(false);
					cartebtn.setVisible(false);
					currentCarte=null;
					carte2=null;
					points=points+1;
					System.out.println("points: "+ points);
					textField_1.setText("points :"+points);
				}
			}else 
			{
				carte2.setEnabled(true);
				currentCarte.setEnabled(true);
					carte2.showDos();
					currentCarte.showDos();
					carte2=null;
					coups=coups+1;
					currentCarte=cartebtn;
					System.out.println("coups= "+ coups);
					textField.setText("coups :"+coups);
			}
		}
		
	};
	private JTextField textField;
	private JTextField textField_1;
}

