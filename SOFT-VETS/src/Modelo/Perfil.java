package Modelo;

import javax.swing.*;
import java.awt.*;

public class Perfil extends JButton{
    
    public Perfil(){
        setContentAreaFilled(false);
        setFocusPainted(false);
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenlogo/iconito.png"));
        int width = icon.getIconWidth();
        int height = icon.getIconHeight();
        setPreferredSize(new Dimension(width, height));
        setIcon(icon);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       
        if (getModel().isPressed()) {
            g2.setColor(getBackground().darker());
        } else {
            g2.setColor(getBackground());
        }
        g2.fillOval(0, 0, getWidth(), getHeight());

        g2.setColor(getForeground());
        g2.drawOval(0, 0, getWidth() - 1, getHeight() - 1);

        super.paintComponent(g);
    }
    @Override
    public boolean contains(int x, int y) {
        int radius = Math.min(getWidth(), getHeight()) / 2;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        return Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2) <= Math.pow(radius, 2);
    }
}
