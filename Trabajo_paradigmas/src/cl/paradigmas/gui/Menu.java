package cl.paradigmas.gui;

import javax.swing.*;

public class Menu extends JFrame{
    private JMenuBar menu;
    private JMenu menu1;
    private JMenuItem mi1,mi2;
    public Menu() {
        this.menu = new JMenuBar();
        this.menu1 = new JMenu("Menu");
        this.mi1 = new JMenuItem("Nuevo");
        this.mi2 = new JMenuItem("Cerrar");
        menu.setBorder(BorderFactory.createEtchedBorder());
        setJMenuBar(menu);
        menu.add(menu1);
        menu1.add(mi1);
        menu1.add(mi2);
    }
    
    public JMenuBar Menu(){
    	return menu;
    }
    
    public JMenu MenuUno(){
    	return menu1;
    }
    
    public JMenuItem mi1(){
    	return mi1;
    }
    
    public JMenuItem mi2(){
    	return mi2;
    }
}
