package cl.paradigmas.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Ventana extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public final static int NINGUNO=0;
	public final static int CIRCULO=1;
	public final static int LINEA=2;
	
	private Canvas canvas;
	private ParadigmasToolBar toolbar;
	private int seleccionado;
	private Menu nort;
	
	public Ventana(){
		this.nort = new Menu();
		this.canvas = new Canvas();
		this.toolbar = new ParadigmasToolBar();
		this.setSize(new Dimension(800,600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(toolbar);
		this.add(canvas, BorderLayout.CENTER);
		this.setSeleccionado(NINGUNO);
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public ParadigmasToolBar getToolbar() {
		return toolbar;
	}

	public void setToolbar(ParadigmasToolBar toolbar) {
		this.toolbar = toolbar;
	}

	public int getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(int seleccionado) {
		this.seleccionado = seleccionado;
	}
	
	public Menu getMenu(){
		return nort;
	}
	

}
