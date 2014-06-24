package trabajo;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Paneles {
	
	protected JPanel panel;


	public Paneles(){

		this.panel = new JPanel();
		panel.setBorder(BorderFactory.createEtchedBorder());
	}
	public Paneles(int x){

		this.panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.setBorder(BorderFactory.createEtchedBorder());
	}


}