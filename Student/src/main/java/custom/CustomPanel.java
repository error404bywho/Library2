package custom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class CustomPanel extends JPanel {
	Graphics2D graphics;
	@Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       Dimension arcs = new Dimension(30,30);
       int width = getWidth();
       int height = getHeight();
       graphics = (Graphics2D) g;
       graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


       //Draws the rounded opaque panel with borders.
       graphics.setColor(new Color(255,255,255));
       graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
       graphics.setColor(new Color(235,238,244));
       graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
    }
    public void setBorderPanel(Color color) {
    	 graphics.setColor(color);
    }
    	
 }
//    
