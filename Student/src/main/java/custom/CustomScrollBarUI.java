package custom;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.*;


public class CustomScrollBarUI extends BasicScrollBarUI {
	 private static final int SCROLL_BAR_ALPHA_ROLLOVER = 150;
     private static final int SCROLL_BAR_ALPHA = 100;
     private static final int THUMB_BORDER_SIZE = 2;
     private static final int THUMB_SIZE = 8;

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
    	// Paint the track with the specified color
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(235, 238, 244)); // Light grey color
        g2.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
   
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        int alpha = isThumbRollover() ? SCROLL_BAR_ALPHA_ROLLOVER : SCROLL_BAR_ALPHA;
        int orientation = scrollbar.getOrientation();
        int x = thumbBounds.x + THUMB_BORDER_SIZE;
        int y = thumbBounds.y + THUMB_BORDER_SIZE;

        int width = orientation == JScrollBar.VERTICAL ?
                THUMB_SIZE : thumbBounds.width - (THUMB_BORDER_SIZE * 2);
        int height = orientation == JScrollBar.VERTICAL ?
                thumbBounds.height - (THUMB_BORDER_SIZE * 2) : THUMB_SIZE;

        Graphics2D graphics2D = (Graphics2D) g.create();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setColor(new Color( 104,109,118, alpha));
        graphics2D.fillRoundRect(x, y, width, height, THUMB_SIZE, THUMB_SIZE);
        graphics2D.dispose();
    }
    @Override
    protected JButton createDecreaseButton(int orientation) {
        return new InvisibleButton(); // Creates a dummy "invisible" button for the decrease button.
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return new InvisibleButton(); // Creates a dummy "invisible" button for the increase button.
    }
    private static class InvisibleButton extends JButton {
        private InvisibleButton() {
            setPreferredSize(new Dimension(0, 0)); // Sets preferred size to zero.
            setMinimumSize(new Dimension(0, 0)); // Sets minimum size to zero.
            setMaximumSize(new Dimension(0, 0)); // Sets maximum size to zero.
            setFocusable(false); // Makes button non-focusable.
            setBorder(BorderFactory.createEmptyBorder()); // Removes the border.
        }
    }
}
