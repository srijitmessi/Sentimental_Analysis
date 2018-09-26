/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentiment_analysis;

/**
 *
 * @author MSN
 */
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

class GridsCanvas extends Canvas {
  int width, height;

  int rows;

  int cols;

  GridsCanvas(int w, int h, int r, int c) {
    setSize(width = w, height = h);
    rows = r;
    cols = c;
  }

  public void paint(Graphics g) {
    int i;
    width = getSize().width;
    height = getSize().height;
g.setColor(Color.WHITE);
    // draw the rows
    int rowHt = height / (rows);
    for (i = 0; i < rows; i++)
      g.drawLine(0, i * rowHt, width, i * rowHt);

    // draw the columns
    int rowWid = width / (cols);
    for (i = 0; i < cols; i++)
      g.drawLine(i * rowWid, 0, i * rowWid, height);
  }
}

/** This is the demo class. */

public class Grids extends Frame {
  /*
   * Construct a GfxDemo2 given its title, width and height. Uses a
   * GridBagLayout to make the Canvas resize properly.
   */
  Grids(String title, int w, int h, int rows, int cols) throws IOException {
    setTitle(title);
    GridsCanvas xyz = new GridsCanvas(w, h, rows, cols);
    add(xyz);
xyz.setBackground(Color.BLACK);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        setVisible(false);
        dispose();
        
      }
    });

BufferedImage img=ImageIO.read(new File("C:\\Users\\MSN\\Documents\\NetBeansProjects\\Sentiment_analysis\\src\\main\\java\\sentiment_analysis\\1200x-1.jpg"));
        ImageIcon icon=new ImageIcon(img);
        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(640,480);
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        
    pack();
  }

  
  
  
    public static void main(String[] args) throws IOException {
    new Grids("PIXEL", 640, 480, 20, 30).setVisible(true);
    
  }
}