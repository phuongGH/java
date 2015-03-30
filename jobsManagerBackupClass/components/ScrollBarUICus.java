/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.metal.MetalScrollBarUI;

/**
 *
 * @author BB
 */
/*
public class ScrollBarUICus extends BasicScrollBarUI {

    private Image imageThumb, imageTrack;

    public ScrollBarUICus() {
        try {
            imageThumb = ImageIO.read(new File("src/images/thumb.png"));
            imageTrack = ImageIO.read(new File("src/images/track.png"));
        } catch (IOException e) {
        }
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        g.translate(trackBounds.x, trackBounds.y);
        ((Graphics2D) g).drawImage(imageTrack, AffineTransform.getScaleInstance(1, (double) trackBounds.height / imageTrack.getHeight(null)), null);
        g.translate(-trackBounds.x, -trackBounds.y);
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        g.translate(thumbBounds.x, thumbBounds.y);
        g.setColor(Color.red);
        g.drawRect(0, 0, thumbBounds.width - 2, thumbBounds.height - 1);
        AffineTransform transform = AffineTransform.getScaleInstance((double) thumbBounds.width / imageThumb.getWidth(null), (double) thumbBounds.height / imageThumb.getHeight(null));
        ((Graphics2D) g).drawImage(imageThumb, transform, null);
        g.translate(-thumbBounds.x, -thumbBounds.y);
    }
}
*/
public class ScrollBarUICus extends MetalScrollBarUI{
    
     private Image imageThumb, imageTrack;
        private JButton b = new JButton() {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(0, 0);
            }

        };

        public ScrollBarUICus() {
            imageThumb = FauxImage.create(32, 32, Color.blue.darker());
            imageTrack = FauxImage.create(32, 32, Color.lightGray);
        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
            g.setColor(Color.blue);
            ((Graphics2D) g).drawImage(imageThumb,
                r.x, r.y, r.width, r.height, null);
        }

        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
            ((Graphics2D) g).drawImage(imageTrack,
                r.x, r.y, r.width, r.height, null);
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return b;
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return b;
        }
        private static class FauxImage {

        static public Image create(int w, int h, Color c) {
            BufferedImage bi = new BufferedImage(
                w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = bi.createGraphics();
            g2d.setPaint(c);
            g2d.fillRect(0, 0, w, h);
            g2d.dispose();
            return bi;
        }
    }
    
}