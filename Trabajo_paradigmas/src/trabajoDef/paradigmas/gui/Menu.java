package trabajoDef.paradigmas.gui;

import javax.swing.*;

public class Menu extends JFrame{
	private JMenuBar menu;
    private JMenu menu1;
    private JMenuItem mi1,mi3;
    public Menu() {
        this.menu = new JMenuBar();
        this.menu1 = new JMenu("Menu");
        this.mi1 = new JMenuItem("Nuevo");
        this.mi3 = new JMenuItem("Cerrar");
        menu.setBorder(BorderFactory.createEtchedBorder());
        setJMenuBar(menu);
        menu.add(menu1);
        menu1.add(mi1);
        menu1.add(mi3);
    }
    
    public JMenuBar getMenu(){
    	return menu;
    }
    
    public JMenu getMenuUno(){
    	return menu1;
    }
    
    public JMenuItem getmi1(){
    	return mi1;
    }
    
    public JMenuItem getmi3(){
    	return mi3;
    }
}
