package UI.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.FocusManager;
import javax.swing.JTextField;

import controller.ControllerGUI;
import persistance.PropertiesTitle;

public class JTextFieldApellido extends JTextField{
	
	/**
	 * @author Duban
	 */
	private static final long serialVersionUID = 1L;
	private ControllerGUI controllerGUI;
	private PropertiesTitle propertiesTitle;
	private String marcaAgua = "";
	
	public JTextFieldApellido(PropertiesTitle propertiesTitle, ControllerGUI controllerGUI) {
		this.propertiesTitle = propertiesTitle;
		this.controllerGUI = controllerGUI;
	}

	/**
	 * pinta un graphic en el TextField, para que genere una marca de agua
	 */
	@Override
	protected void paintComponent(java.awt.Graphics g) {
		marcaAgua = propertiesTitle.getProperty(Constans.LAST_NAME);
		super.paintComponent(g);
		if (getText().isEmpty() && !(FocusManager.getCurrentKeyboardFocusManager().getFocusOwner() == this)) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setColor(Color.decode("#E9E5E4"));
			g2.setFont(new Font("Arial", 1, 15));
			g2.drawString(propertiesTitle.getProperty(Constans.LAST_NAME), 10, this.getHeight()/2 +5); // figure out x, y from font'sFontMetrics and size ofcomponent.
			g2.dispose();
		}
	}
	public void refresh(){
		propertiesTitle = controllerGUI.getPropertiesTitle();
		marcaAgua = propertiesTitle.getProperty(Constans.LAST_NAME);
	}
}