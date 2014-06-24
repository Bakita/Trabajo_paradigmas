package trabajoDef.paradigmas.figuras;

import java.awt.Graphics;
import java.awt.Point;

import trabajoDef.paradigmas.gui.Dibujable;

public class Circulo implements Dibujable{
	
	private Point posicion;
	private int radius;
	
	public Circulo(Point posicion, int radius){
		this.posicion = posicion;
		this.radius = radius;
	}

	public Point getPosicion() {
		return posicion;
	}

	public void setPosicion(Point posicion) {
		this.posicion = posicion;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void dibujar(Graphics g) {
		g.drawOval(posicion.x - radius, posicion.y - radius, 2 * radius, 2 * radius);
	}

	@Override
    public boolean estaDentro(int x, int y)
    {
        if (
                Math.sqrt(
                        ((posicion.x - x) * (posicion.x - x)) +
                        ((posicion.y - y) * (posicion.y - y))) < radius)
            {
        	return true;
            }
        return false;
    }

	@Override
	public int getY() {
		return posicion.x;
	}

	@Override
	public int getX() {
		return posicion.y;
	}

	@Override
	public void setPosicion(int x, int y) {
		posicion.x = x;
		posicion.y = y;
	}
	
}
