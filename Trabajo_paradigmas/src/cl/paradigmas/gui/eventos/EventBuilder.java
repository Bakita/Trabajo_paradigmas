package cl.paradigmas.gui.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import cl.paradigmas.gui.Dibujable;
import cl.paradigmas.gui.Ventana;
import cl.paradigmas.modelo.Circulo;
import cl.paradigmas.modelo.Cuadrado;
import cl.paradigmas.modelo.Linea;

final public class EventBuilder{
	private static Linea linea = null;
	public EventBuilder(){}

	public static ActionListener Cierra(final Ventana ventana){
		ActionListener limpiar = new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        ventana.setVisible (false);
		        ventana.dispose();
		    }
		};
		return limpiar;
	}
	
	public static MouseAdapter dibujarCirculo(final Ventana ventana){
		MouseAdapter dibujarCirculo = new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				if(ventana != null && ventana.getToolbar().getBtn("Circulo").isSelected()){
					Dibujable cir = new Circulo(e.getPoint(),30);
					ventana.getCanvas().addDibujable(cir);
					ventana.getCanvas().repaint();
				}
			}
		};
		return dibujarCirculo;
	}
	
	public static MouseAdapter dibujarCuadrado(final Ventana ventana){
		MouseAdapter dibujarCuadrado = new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				if(ventana != null && ventana.getToolbar().getBtn("Cuadrado").isSelected()){
					Dibujable cua = new Cuadrado(e.getPoint(),30);
					ventana.getCanvas().addDibujable(cua);
					ventana.getCanvas().repaint();
				}
			}
		};
		return dibujarCuadrado;
	}

	public static ActionListener limpiar(final Ventana ventana){
		ActionListener limpiar = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.getCanvas().limpiar();
				ventana.getCanvas().repaint();
			}	
		};
		return limpiar;
	}	


	public static MouseAdapter dibujarLinea(final Ventana ventana){
		MouseAdapter dibujarLinea = new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				if(ventana != null && ventana.getCanvas().isDibujandoTmp() != true && ventana.getToolbar().getBtn("Linea").isSelected()){
					ventana.getCanvas().setDibujandoTmp(true);
					linea = new Linea(e.getPoint(), e.getPoint());
					ventana.getCanvas().addDibujable(linea);
					ventana.getCanvas().repaint();
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				if(ventana != null && linea != null 
						&& ventana.getToolbar().getBtn("Linea").isSelected() 
						&& ventana.getCanvas().isDibujandoTmp() != false){
					linea.setFin(e.getPoint());
					ventana.getCanvas().setDibujandoTmp(false);
					linea = null;
					ventana.getCanvas().repaint();
				}
			}

		};
		return dibujarLinea;
	}
	
	public static MouseAdapter mostrarTrazado(final Ventana ventana){
		MouseAdapter mostrarTrazado = new MouseAdapter(){
			@Override
			public void mouseDragged(MouseEvent e) {
				super.mouseDragged(e);
				if(ventana.getCanvas().isDibujandoTmp() && 
						ventana.getToolbar().getBtn("Linea").isSelected()
							&& ventana.getCanvas().isDibujandoTmp() != false){
					linea.setFin(e.getPoint());
					ventana.getCanvas().repaint();
				}
			}
		};
		
		return mostrarTrazado;
		
	}
	
}
