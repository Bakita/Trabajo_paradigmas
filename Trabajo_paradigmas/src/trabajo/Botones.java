package trabajo;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

import trabajoDef.paradigmas.gui.Iconos;

public class Botones {
	private JButton inicio,flecha,borra,agregaS,agregaE,agregaN;
	private Iconos all;
	private ButtonGroup grupoBtn;
	
	public Botones(){
		this.all = new Iconos();
		this.inicio = new JButton(all.inicio);
		this.flecha = new JButton(all.flecha);
		this.borra = new JButton(all.borra);
		this.agregaE = new JButton(all.agregaE);
		this.agregaN = new JButton(all.agregaN);
		this.agregaS = new JButton(all.agregaS);
		this.grupoBtn = new ButtonGroup();
		grupoBtn.add(inicio);
		grupoBtn.add(flecha);
		grupoBtn.add(borra);
		grupoBtn.add(agregaE);
		grupoBtn.add(agregaN);
		grupoBtn.add(agregaS);
	}
	
	public JButton getInicio(){
		return inicio;
	}
	
	public JButton getFlecha(){
		return flecha;
	}
	
	public JButton getBorra(){
		return borra;
	}
	
	public JButton getAgregaE(){
		return agregaE;
	}
	
	public JButton getAgregaN(){
		return agregaN;
	}
	
	public JButton getAgregaS(){
		return agregaS;
	}
	

}
