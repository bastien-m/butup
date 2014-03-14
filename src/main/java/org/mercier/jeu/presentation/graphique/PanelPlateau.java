package org.mercier.jeu.presentation.graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.mercier.jeu.exception.ButupException;
import org.mercier.jeu.metier.GestionClickPlateau;
import org.mercier.jeu.metier.Jeu;
import org.mercier.jeu.modele.Pile;
import org.mercier.jeu.modele.Pile.Bouton;

public class PanelPlateau extends JPanel {

	private static final long serialVersionUID = -3204659653199233231L;
	private Image background;
	private LinkedList<Pile> piles;
	
	private final int y;
	private int x = 30;
	private final int width = 25;
	private final int height = 8;
	
	private ArrayList<Point> positions;
	
	private GestionClickPlateau gestionClick;
	
	public PanelPlateau(Jeu jeu) throws IOException{
		super(new BorderLayout());
		setPreferredSize(new Dimension(300,300));
		y = 200;
		background = ImageIO.read(new File("resources/background.jpg"));
		positions = new ArrayList<>();
		gestionClick = new GestionClickPlateau(width, height, jeu);
	}
	
	public void constructionPiles(LinkedList<Pile> piles){
		this.piles = piles;
		repaint();
	}
	
	public void gestionClick(int x,int y) throws ButupException{
		gestionClick.setPositions(positions);
		gestionClick.traitement(x, y);
		this.repaint();
	}
	
	boolean clickSurPile(int x, int y){
		for(Point p : positions){
			if(x >= p.x && x <= (p.x + width)){
				if(y >= p.y && y <= (p.y + height)){
					return true;
				}
			}
		}
		
		return false;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		g.drawImage(background, 0, 0, this.getWidth() ,  this.getHeight() ,null);
		
		int yLocal, xLocal = x;
		//dessin des piles
		for(Pile p : piles){
			xLocal+=(width+10);
			yLocal = y;
			positions.add(new Point(xLocal, yLocal));
			for(Bouton b : p){
				if(b == Bouton.ROUGE){
					g.setColor(Color.RED);					
				}
				else if(b == Bouton.NOIRE){
					g.setColor(Color.BLACK);
				}
				else{
					g.setColor(Color.WHITE);
				}
				g.fillRect(xLocal, yLocal, width, height);
				yLocal-=height;
			}
		}
	}
	
}
