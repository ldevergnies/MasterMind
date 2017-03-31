package game;

import game.Main;
import game.Pion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreDefaite extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton encore = new JButton("Try again !!!");
	private JPanel container = new JPanel();

	public FenetreDefaite(Pion[] solution) {
		this.setTitle("LOOSER");
		this.setSize(190, 130);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		this.setLayout(null);
		this.container.setLayout(null);
		this.container.setBounds(0, 0, 160, 100);
		int i = 0;
		while (i < 4) {
			solution[i].setLocation(i * 40 + 10, 10);
			this.container.add(solution[i]);
			++i;
		}
		this.encore.setBounds(10, 50, 150, 30);
		this.encore.addActionListener(this);
		this.container.add(this.encore);
		this.setContentPane(this.container);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		Main.main(null);
		this.dispose();
	}
}
