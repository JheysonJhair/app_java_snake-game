package com.jhairdev.utils;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Jhair
 */
public class Panel extends JPanel{
    public Panel(Color color, int x, int y,int width,int height) {
        setBounds(x, y, width, height);
        setBackground(color);
        setVisible(true);
    }
}