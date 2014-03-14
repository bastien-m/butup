package org.mercier.jeu.presentation.graphique;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.xml.parsers.ParserConfigurationException;

import org.mercier.jeu.DAO.LecturePropXML;
import org.mercier.jeu.exception.ButupException;
import org.mercier.jeu.metier.Jeu;
import org.xml.sax.SAXException;

import com.apple.eawt.Application;

@SuppressWarnings("restriction")
public class Interface extends JFrame{

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 600;
	private static final int HEIGHT = 400;
	
	private LecturePropXML lectureXML;
	private PanelPlateau plateau;
	
	
	public Interface(Jeu jeu) throws ParserConfigurationException, SAXException, IOException{
		super("Button Up Game");
		setSize(new Dimension(WIDTH, HEIGHT));
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		creationIcon();
		lectureXML = new LecturePropXML("resources/config.xml");
		
		setJMenuBar(new BarMenu(lectureXML));
		add(new PanelJoueurs(), BorderLayout.EAST);
		plateau = new PanelPlateau(jeu);
		add(plateau);
		plateau.constructionPiles(jeu.getPlateau());
		plateau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				System.out.println(plateau.clickSurPile(e.getX(), e.getY()));
				try {
					plateau.gestionClick(e.getX(), e.getY());
				} catch (ButupException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e){
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
					System.exit(0);
				}
			}
		});
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	private void creationIcon(){
		String os = System.getProperty("os.name");
		if(os.contains("Mac")){
			Application app = Application.getApplication();
			Image image = Toolkit.getDefaultToolkit().getImage("resources/icon.png");
			app.setDockIconImage(image);
		}
		else{
			setIconImage(new ImageIcon("resources/icon.png").getImage());
		}
	}
	
	
}
