package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;

public class Bouton extends JButton {
	private static final long serialVersionUID = 1L;
	private Color couleur = Color.GRAY;

	public Bouton() {
		this.setEnabled(false);
	}

	public void paintComponent(Graphics graph) {
		Graphics2D g2 = (Graphics2D) graph;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(this.couleur);
		g2.drawOval(0, 0, 10, 10);
		g2.fillOval(0, 0, 10, 10);
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
		this.repaint();
	}
}
