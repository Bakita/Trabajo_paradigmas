package trabajoDef.paradigmas.figuras;

import java.awt.Graphics;
import java.awt.Point;

import trabajoDef.paradigmas.gui.Dibujable;

public class Cuadrado implements Dibujable{
	private Point posicion;
	private int altoRectangulo;
	private int anchoRectangulo;
	
	public Cuadrado(Point pos, int medida){
		this.posicion = pos;
		this.altoRectangulo = medida;
		this.anchoRectangulo = medida;
	}
	
	public Point getPosicion() {
		return posicion;
	}
	
	@Override
	public int getX(){
		return posicion.x;
	}
	
	@Override
	public int getY(){
		return posicion.y;
	}
	
	@Override
	public void setPosicion(int x, int y) {
		posicion.x = x;
		posicion.y = y;
	}
	
	public int getAncho(){
		return anchoRectangulo;
	}
	
	public int getAlto(){
		return altoRectangulo;
	}
	
	public void setMedida(int medida){
		this.anchoRectangulo = medida;
		this.altoRectangulo = medida;
	}
	
	
	@Override
	public void dibujar(Graphics g) {
		g.drawRect(posicion.x-altoRectangulo/2, posicion.y-anchoRectangulo/2, altoRectangulo,anchoRectangulo);
	}

	@Override
    public boolean estaDentro(int x, int y)
    {
        if (x<=posicion.x + anchoRectangulo/2 && y<=posicion.y + altoRectangulo/2
        	&& x>=posicion.x - anchoRectangulo/2 && y>=posicion.y - altoRectangulo/2	
        		)
        {
            return true;
        }

        return false;
    }
	

}
