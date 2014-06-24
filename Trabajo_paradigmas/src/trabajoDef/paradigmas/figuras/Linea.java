package trabajoDef.paradigmas.figuras;

import java.awt.Graphics;
import java.awt.Point;

import trabajoDef.paradigmas.gui.Dibujable;

public class Linea implements Dibujable{

	private Point inicio;
	private Point fin;
	
	public Linea(Point inicio, Point fin) {
		this.inicio = inicio;
		this.fin = fin;
	}
	
	@Override
	public void dibujar(Graphics g) {
		g.drawLine(inicio.x, inicio.y, fin.x, fin.y);
		
	}
	public Point getInicio() {
		return inicio;
	}
	public void setInicio(Point inicio) {
		this.inicio = inicio;
	}
	public Point getFin() {
		return fin;
	}
	public void setFin(Point fin) {
		this.fin = fin;
	}

	@Override
	public boolean estaDentro(int x, int y) {
		return false;
	}

	@Override
	public int getY() {
		return 0;
	}

	@Override
	public int getX() {
		return 0;
	}

	@Override
	public void setPosicion(int x, int y) {
		
	}
	
	

}
