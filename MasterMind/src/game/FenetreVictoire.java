package game;

import game.Main;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreVictoire extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton encore = new JButton("Encore une fois !");

	public FenetreVictoire() {
		class Panneau extends JPanel {
			private static final long serialVersionUID = 1L;

			Panneau() {
			}

			public void paintComponent(Graphics graph) {
				Graphics2D g2 = (Graphics2D) graph;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.drawString("C'est qui le winner ? C'est toi !", 60, 15);
			}
		}
		this.setTitle("YOU WIN");
		this.setSize(300, 100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		Box ligne = Box.createHorizontalBox();
		ligne.add(Box.createGlue());
		ligne.add(this.encore);
		ligne.add(Box.createGlue());
		Box box = Box.createVerticalBox();
		box.add(Box.createVerticalStrut(20));
		box.add(ligne);
		this.encore.addActionListener(this);
		this.setContentPane(new Panneau());
		this.getContentPane().add(box);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		Main.main(null);
		this.dispose();
	}

}
