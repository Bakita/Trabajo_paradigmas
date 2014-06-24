package trabajo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Builder implements MouseListener, MouseMotionListener {
	
	Botones uno = new Botones();

	@Override
	public void mouseDragged(MouseEvent b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent b) {
		if(b.getSource().equals(uno.getInicio())){
		    System.out.println("ENTRO");
		}
		else System.out.println("ERROR");
	}

	@Override
	public void mouseEntered(MouseEvent b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent b) {
		// TODO Auto-generated method stub
		
	}
	

}
