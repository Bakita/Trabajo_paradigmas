package cl.paradigmas.modelo;

import java.awt.Graphics;
import java.awt.Point;

import cl.paradigmas.gui.Dibujable;

public class Cuadrado implements Dibujable{
	private Point posicion;
	private int medida;
	
	public Cuadrado(Point pos, int medida){
		this.posicion = pos;
		this.medida = medida;
	}
	
	public Point getPosicion() {
		return posicion;
	}

	public void setPosicion(Point posicion) {
		this.posicion = posicion;
	}
	
	public int getMedida(){
		return medida;
	}
	
	public void setMedida(int medida){
		this.medida = medida;
	}
	
	@Override
	public void dibujar(Graphics g) {
		g.drawRect(posicion.x, posicion.y, medida, medida);
	}
	

}
