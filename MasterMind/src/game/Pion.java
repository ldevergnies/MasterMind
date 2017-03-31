package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Pion extends JButton implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Color couleur = Color.GRAY;
	private int click = 0;

	public Pion() {
		this.addActionListener(this);
	}

	public void paintComponent(Graphics graph) {
		Graphics2D g2 = (Graphics2D) graph;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(this.couleur);
		g2.fillOval(0, 0, 30, 30);
	}

	public Color getCouleur() {
		return this.couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
		this.repaint();
	}

	public void actionPerformed(ActionEvent arg0) {
		++this.click;
		switch (this.click % 6) {
		case 1: {
			this.couleur = Color.BLUE;
			break;
		}
		case 2: {
			this.couleur = Color.GREEN;
			break;
		}
		case 3: {
			this.couleur = Color.MAGENTA;
			break;
		}
		case 4: {
			this.couleur = Color.ORANGE;
			break;
		}
		case 5: {
			this.couleur = Color.RED;
			break;
		}
		default: {
			this.couleur = Color.YELLOW;
		}
		}
	}
}
