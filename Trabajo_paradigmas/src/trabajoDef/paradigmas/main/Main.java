package trabajoDef.paradigmas.main;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

import trabajoDef.paradigmas.gui.Iconos;
import trabajoDef.paradigmas.gui.Ventana;
import trabajoDef.paradigmas.gui.eventos.*;


public class Main {
	
	public static void main(String[] args) {
		Ventana ventana = new Ventana();
		Iconos img = new Iconos();
		JPanel norte = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel sur = new JPanel();

		ventana.setTitle("Proyecto Paradigmas de Programacion");
		ventana.getToolbar().addBtn("Circulo", new JToggleButton(img.agregaN));
		ventana.getToolbar().addBtn("Cuadrado", new JToggleButton(img.agregaS));
		ventana.getToolbar().addBtn("Linea", new JToggleButton(img.flecha));
		ventana.getToolbar().addBtn("Mover", new JToggleButton(img.inicio));
		ventana.getToolbar().addBtn("Borra", new JToggleButton(img.borra));
		norte.add(ventana.getMenu().getMenu());
		sur.add(ventana.getToolbar());
		ventana.add(sur,BorderLayout.SOUTH);
		ventana.add(norte,BorderLayout.NORTH);
		ventana.getCanvas().addMouseListener(EventBuilder.dibujarCirculo(ventana));
		ventana.getCanvas().addMouseListener(EventBuilder.borraSeleccion(ventana));
		ventana.getCanvas().addMouseListener(EventBuilder.dibujarCuadrado(ventana));
		ventana.getCanvas().addMouseListener(EventBuilder.presionoFigura(ventana));
		ventana.getCanvas().addMouseListener(EventBuilder.soltoFigura(ventana));
		ventana.getCanvas().addMouseMotionListener(EventBuilder.moverFigura(ventana));
		ventana.getMenu().getmi1().addActionListener(EventBuilder.limpiar(ventana));
		ventana.getMenu().getmi3().addActionListener(EventBuilder.Cierra(ventana));
		ventana.getCanvas().addMouseListener(EventBuilder.dibujarLinea(ventana));
		ventana.getCanvas().addMouseMotionListener(EventBuilder.mostrarTrazado(ventana));
		ventana.setVisible(true);
	}

}
