package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;

public class Valide extends JButton {
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics graph) {
		Graphics2D g2 = (Graphics2D) graph;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.BLACK);
		g2.drawRect(0, 0, 90, 20);
		g2.drawString("Valider", 5, 5);
	}
}
