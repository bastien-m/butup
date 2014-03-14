package org.mercier.jeu.presentation.console;


public class InstanceConsole {
	
	public static void main(String [] args){
		InterfaceConsole console = new InterfaceConsole();
		System.out.println(console.afficheSituationInitiale());
		console.jouer();
	}
}
