package cl.paradigmas.main;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

import cl.paradigmas.gui.Iconos;
import cl.paradigmas.gui.Ventana;
import cl.paradigmas.gui.eventos.*;


public class Main {
	
	public static void main(String[] args) {
		final Ventana ventana = new Ventana();
		final Iconos img = new Iconos();
		final JPanel norte = new JPanel(new FlowLayout(FlowLayout.LEFT));
		final JPanel sur = new JPanel();
		

		ventana.setTitle("Proyecto Paradigmas de Programacion");
		ventana.getToolbar().addBtn("Circulo", new JToggleButton(img.agregaN));
		ventana.getToolbar().addBtn("Cuadrado", new JToggleButton(img.agregaS));
		ventana.getToolbar().addBtn("Linea", new JToggleButton(img.flecha));
		norte.add(ventana.getMenu().Menu());
		sur.add(ventana.getToolbar());
		ventana.add(sur,BorderLayout.SOUTH);
		ventana.add(norte,BorderLayout.NORTH);
		ventana.getCanvas().addMouseListener(EventBuilder.dibujarCirculo(ventana));
		ventana.getCanvas().addMouseListener(EventBuilder.dibujarCuadrado(ventana));
		ventana.getToolbar().getBtnLimpiar().addActionListener(EventBuilder.limpiar(ventana));
		ventana.getMenu().mi1().addActionListener(EventBuilder.limpiar(ventana));
		ventana.getMenu().mi2().addActionListener(EventBuilder.Cierra(ventana));
		ventana.getCanvas().addMouseListener(EventBuilder.dibujarLinea(ventana));
		ventana.getCanvas().addMouseMotionListener(EventBuilder.mostrarTrazado(ventana));
		ventana.setVisible(true);
	}

}
