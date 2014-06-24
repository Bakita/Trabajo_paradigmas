package trabajoDef.paradigmas.gui.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;

import trabajoDef.paradigmas.gui.Dibujable;
import trabajoDef.paradigmas.gui.Ventana;
import trabajoDef.paradigmas.figuras.Circulo;
import trabajoDef.paradigmas.figuras.Cuadrado;
import trabajoDef.paradigmas.figuras.Linea;

final public class EventBuilder{
	private static Dibujable figuraArrastrandose = null;
	private static Linea linea = null;
	private static int condicion = 0;
	
	public EventBuilder(){}

	public static ActionListener Cierra(final Ventana ventana){
		ActionListener accion = new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        ventana.setVisible (false);
		        ventana.dispose();
		    }
		};
		return accion;
	}
	
	public static MouseAdapter dibujarCirculo(final Ventana ventana){
		MouseAdapter dibujarCirculo = new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				if(ventana != null && ventana.getToolbar().getBtn("Circulo").isSelected()){
					Dibujable cir = new Circulo(e.getPoint(),16);
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

	public static MouseAdapter presionoFigura(final Ventana ventana){
		MouseAdapter clickFigura = new MouseAdapter(){
			public void mousePressed(MouseEvent e){
		        for (Dibujable figura : ventana.getCanvas().getArray()){
		            if (ventana.getToolbar().getBtn("Mover").isSelected() && figura.estaDentro(e.getX(), e.getY()))
		                condicion = 1;
		        }
			}
		};
		return clickFigura;
	}
	
	public static MouseAdapter soltoFigura(final Ventana ventana){
		MouseAdapter clickFigura = new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				if (ventana.getToolbar().getBtn("Mover").isSelected())
		                condicion = 0;
			}
		};
		return clickFigura;
	}
	
	public static MouseAdapter borraSeleccion(final Ventana ventana){
		MouseAdapter ultimo = new MouseAdapter(){
			int i = 0;
			@Override
			public void mouseClicked(MouseEvent e){
				if (ventana.getToolbar().getBtn("Borra").isSelected()){
			        for (Dibujable figura : ventana.getCanvas().getArray()){
			            if (figura.estaDentro(e.getX(), e.getY())){
			            	JOptionPane.showMessageDialog(null,"Pronto !!!"); 
			            	break;
			            }
			        }
				}
			}
			
		};
		return ultimo;
	}
	
	public static MouseMotionListener moverFigura(final Ventana ventana){
		MouseAdapter moverFigura = new MouseAdapter(){
		    private Dibujable dameFigura(MouseEvent e){
		        for (Dibujable figura : ventana.getCanvas().getArray()){
		            if (figura.estaDentro(e.getX(), e.getY())){
		                return figura;
		            }
		        }
		        return null;
		    }
		    @Override
		    public void mouseDragged(MouseEvent e){
		    	if (ventana.getToolbar().getBtn("Mover").isSelected() && condicion == 1){
	                if (figuraArrastrandose == null){ 
	                    figuraArrastrandose = dameFigura(e);
	                }
	                else{
	                    figuraArrastrandose.setPosicion(e.getX(),e.getY());
	                    ventana.getCanvas().repaint();
	                }  
		    	}
	        }
		    @Override
		    public void mouseMoved(MouseEvent e){
		        figuraArrastrandose = null;
		    }
		};
		return moverFigura;
	}
	
	

}
