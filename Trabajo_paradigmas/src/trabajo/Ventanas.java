package trabajo;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import trabajoDef.paradigmas.gui.Menu;

public class Ventanas extends JFrame {
	
	public final static int CIRCULO=1;
	private int seleccionado;
	private JFrame vent;
	private Paneles norte;
	private Paneles sur;
	private Paneles centro;
	private Menu uno;
	private Tool barS; 
	private Botones all; 
	private Builder listener;
	
	public Ventanas(){
		
		this.vent = new JFrame();
		this.norte = new Paneles(1);
		this.sur = new Paneles();
		this.centro = new Paneles();
		this.uno = new Menu();
		this.barS = new Tool();
		this.all = new Botones();
		this.listener = new Builder();
		all.getAgregaE().addMouseListener(listener);
		all.getAgregaN().addMouseListener(listener);
		all.getAgregaS().addMouseListener(listener);
		all.getBorra().addMouseListener(listener);
		all.getFlecha().addMouseListener(listener);
		all.getInicio().addMouseListener(listener);
		norte.panel.add(uno.getMenu());
		sur.panel.add(all.getInicio());
		sur.panel.add(all.getFlecha());
		sur.panel.add(all.getBorra());
		sur.panel.add(all.getAgregaE());
		sur.panel.add(all.getAgregaN());
		sur.panel.add(all.getAgregaS());
		sur.panel.add(barS.barra);
		vent.setLayout(new BorderLayout());
		vent.add(norte.panel,BorderLayout.NORTH);
		vent.add(centro.panel,BorderLayout.CENTER);
		vent.add(sur.panel,BorderLayout.SOUTH);
		vent.setSize(800,600);
		vent.setTitle("Trabajo Paradigmas");
		vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vent.setVisible(true);
	}

}
