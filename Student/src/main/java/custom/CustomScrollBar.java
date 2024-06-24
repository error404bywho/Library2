package custom;

import javax.swing.*;
import java.awt.*;
public class CustomScrollBar extends JScrollBar {

    public CustomScrollBar() {
        setOpaque(false);
        setUI(new CustomScrollBarUI());
    }
}