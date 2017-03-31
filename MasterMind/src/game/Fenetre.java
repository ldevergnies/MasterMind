package game;

import game.Bouton;
import game.FenetreDefaite;
import game.FenetreVictoire;
import game.Pion;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Bouton[] verif = new Bouton[40];
	private Pion[] ligne = new Pion[40];
	private Pion[] ligneSolution = new Pion[4];
	private JButton valide = new JButton("Valider");
	private JPanel container = new JPanel();
	private int compteur = 0;

	public Fenetre() {
		this.setTitle("MasterMind");
		this.setSize(250, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		this.setLayout(null);
		this.container.setLayout(null);
		this.container.setBounds(10, 10, 200, 490);
		int i = 0;
		while (i < 40) {
			this.verif[i] = new Bouton();
			this.ligne[i] = new Pion();
			this.verif[i].setBorderPainted(false);
			this.ligne[i].setBorderPainted(false);
			if (i % 2 == 0) {
				this.verif[i].setBounds(10, i * 10, 10, 10);
			} else {
				this.verif[i].setBounds(30, (i - 1) * 10, 10, 10);
			}
			switch (i % 4) {
			case 0: {
				this.ligne[i].setBounds(50, i * 10, 30, 30);
				break;
			}
			case 1: {
				this.ligne[i].setBounds(90, (i - 1) * 10, 30, 30);
				break;
			}
			case 2: {
				this.ligne[i].setBounds(130, (i - 2) * 10, 30, 30);
				break;
			}
			case 3: {
				this.ligne[i].setBounds(170, (i - 3) * 10, 30, 30);
			}
			}
			if (4 <= i) {
				this.ligne[i].setEnabled(false);
			}
			this.container.add(this.verif[i]);
			this.container.add(this.ligne[i]);
			++i;
		}
		i = 0;
		while (i < 4) {
			this.ligneSolution[i] = new Pion();
			this.ligneSolution[i].setEnabled(false);
			this.ligneSolution[i].setBounds(i * 40 + 50, 410, 30, 30);
			this.ligneSolution[i].setCouleur(this.colorGenerate());
			this.ligneSolution[i].setBorderPainted(false);
			++i;
		}
		this.valide.setBounds(50, 410, 150, 30);
		this.valide.addActionListener(this);
		this.container.add(this.valide);
		this.add(this.container);
		this.setVisible(true);
	}

	@SuppressWarnings("unused")
	public void actionPerformed(ActionEvent arg0) {
		boolean check = true;
		int rouge = 0;
		int blanc = 0;
		ArrayList<Integer> estVerifie = new ArrayList<Integer>();
		ArrayList<Integer> estVerifieSolution = new ArrayList<Integer>();
		int i = 0;
		while (i < 4) {
			if (this.ligne[this.compteur * 4 + i].getCouleur().equals(Color.GRAY)) {
				check = false;
			}
			++i;
		}
		if (check) {
			i = 0;
			while (i < 4) {
				if (this.ligneSolution[i].getCouleur().equals(this.ligne[this.compteur * 4 + i].getCouleur())) {
					++rouge;
					estVerifie.add(i);
					estVerifieSolution.add(i);
				}
				++i;
			}
			i = 0;
			while (i < 4) {
				int j = 0;
				while (j < 4) {
					if (!estVerifie.contains(i) && !estVerifieSolution.contains(j) && this.ligneSolution[j].getCouleur()
							.equals(this.ligne[this.compteur * 4 + i].getCouleur())) {
						++blanc;
						estVerifie.add(i);
						estVerifieSolution.add(j);
					}
					++j;
				}
				++i;
			}
			if (rouge > 0) {
				i = 0;
				while (i < rouge) {
					this.verif[this.compteur * 4 + i].setCouleur(Color.RED);
					++i;
				}
			}
			if (blanc > 0) {
				i = 0;
				while (i < blanc) {
					this.verif[this.compteur * 4 + i + rouge].setCouleur(Color.WHITE);
					++i;
				}
			}
			if (rouge == 4) {
				FenetreVictoire victoire = new FenetreVictoire();
				this.dispose();
			}
			if (this.compteur == 9) {
				FenetreDefaite defaite = new FenetreDefaite(this.ligneSolution);
				this.dispose();
			}
			i = 0;
			while (i < 4) {
				this.ligne[this.compteur * 4 + i].setEnabled(false);
				if (this.compteur < 9) {
					this.ligne[this.compteur * 4 + i + 4].setEnabled(true);
				}
				++i;
			}
			++this.compteur;
		}
	}

	public Color colorGenerate() {
		Color couleur;
		Random random = new Random();
		int alea = random.nextInt(6);
		switch (alea) {
		case 1: {
			couleur = Color.BLUE;
			break;
		}
		case 2: {
			couleur = Color.GREEN;
			break;
		}
		case 3: {
			couleur = Color.MAGENTA;
			break;
		}
		case 4: {
			couleur = Color.ORANGE;
			break;
		}
		case 5: {
			couleur = Color.RED;
			break;
		}
		default: {
			couleur = Color.YELLOW;
		}
		}
		return couleur;
	}
}
