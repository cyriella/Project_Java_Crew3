package View.Jeu;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import Controller.Controlleur.Jeu.GestionFinJeu;
import Main.BoulderDash;
import Controller.Controlleur.Jeu.GestionClavierJeu;

import Contract.Variables;

/**
 * Panel du jeu, englobe les vues du jeu
 * 
 * @see AireInfoJeu, AirePlateauJeu
 * @author Yiserot
 */
@SuppressWarnings("serial")
public class PanelJeu extends JPanel implements Observer {

	/**
	 * Terrain du jeu
	 */
	private AirePlateauJeu aireJeu;

	/**
	 * Zone d'information du jeu
	 */
	private AireInfoJeu aireInfo;

	/**
	 * Gestionnaire des interactions clavier
	 */
	private GestionClavierJeu listen;

	/**
	 * Initialisation du panel
	 */
	public PanelJeu() {
		setBackground(Variables.COULEUR);
		aireJeu = new AirePlateauJeu(BoulderDash.getJeu().getNiveau());
		add(aireJeu);
		aireInfo = new AireInfoJeu();
		add(aireInfo);

		listen = new GestionClavierJeu(BoulderDash.getJeu().getNiveau());
		addKeyListener(listen);
		BoulderDash.getJeu().addObserver(this);
	}

	/**
	 * Mise à jour de la vue
	 */
	@Override
	public void update(Observable o, Object arg) {
		aireJeu.repaint();
		aireInfo.majinfos();
		if (BoulderDash.getJeu().isFini()) {
			GestionFinJeu.finJeu();
		}
	}
}
