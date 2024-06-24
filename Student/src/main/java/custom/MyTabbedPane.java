package custom;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JTabbedPane;

public class MyTabbedPane extends JTabbedPane{
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawRoundRect(getX()-12, getY()-11, getWidth()-4, getHeight()-22, 6, 6);
    }
	
	
	
}
