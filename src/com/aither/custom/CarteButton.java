package com.aither.custom;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.aither.model.Carte;

public class CarteButton extends JButton implements ActionListener {
	public static final int ETAT_DOS = 0;
	public static final int ETAT_FACE = 1;
	public Carte carte;

	public int etat,flag=0;

	public CarteButton(Carte carte){
		super();
		this.carte = carte;
		this.etat = 0;
		setIcon(carte.imageDos);
		setPreferredSize( new Dimension(carte.imageDos.getIconWidth(), carte.imageDos.getIconHeight())); 
		super.addActionListener(this);
	}

	public void showDos(){
		etat = ETAT_DOS;
		setIcon(carte.imageDos);
		setDisabledIcon(carte.imageDos);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(etat == ETAT_DOS){	
			etat = ETAT_FACE;
			setIcon(carte.imageFace);
			setDisabledIcon(carte.imageFace);
		}else{
			etat = ETAT_DOS;
			setIcon(carte.imageDos);
			setDisabledIcon(carte.imageDos);
			flag=0;
		}
	}


}
