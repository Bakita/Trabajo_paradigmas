package trabajoDef.paradigmas.gui;

import java.awt.Graphics;

public interface Dibujable {
	
	abstract public void dibujar(Graphics g);
	public boolean estaDentro(int x, int y);
	public int getY();
	public int getX();
	public void setPosicion(int x, int y);

}
