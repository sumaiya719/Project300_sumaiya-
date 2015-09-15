/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package speedmatch;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Dell
 */

public class PanelClass extends JPanel{
    MenuFrame parent;
    boolean f,isImage;
    Image images[];
    int i,n, time;
    Random r;
    Runnable run;
    PanelClass(MenuFrame p){
        parent =p;
        f=true;
        images=new Image[20];
        r=new Random();
        run=new MyAnimation();
        i=0;
        n=time=0;
        try{
            images[0]= ImageIO.read(new File("src\\image\\1.jpg"));
            images[1]= ImageIO.read(new File("src\\image\\2.jpg"));
            images[2]= ImageIO.read(new File("src\\image\\3.jpg"));
            images[3]= ImageIO.read(new File("src\\image\\4.jpg"));
            images[4]= ImageIO.read(new File("src\\image\\5.jpg"));
            images[5]= ImageIO.read(new File("src\\image\\6.jpg"));
            images[6]= ImageIO.read(new File("src\\image\\7.jpg"));
            images[7]= ImageIO.read(new File("src\\image\\8.jpg"));
            images[8]= ImageIO.read(new File("src\\image\\9.jpg"));          
            images[9]=ImageIO.read(new File("src\\image\\white.jpg"));
           
        }catch(Exception e){
            System.out.println(e);
        }
        addMouseListener(new ml());
    }
    class ml implements MouseListener{
        

       
        @Override
        public void mouseClicked(MouseEvent me) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            f=false;
        }

        @Override
        public void mousePressed(MouseEvent me) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        
        @Override
        public void mouseReleased(MouseEvent me) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

      
        @Override
        public void mouseEntered(MouseEvent me) {
          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

       
        @Override
        public void mouseExited(MouseEvent me) {
          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(images[i], 0, 0, getWidth(), getHeight(), this);
    }
    class MyAnimation implements Runnable{
        int j;
        @Override
        public void run() {
            try{
                i=r.nextInt(19); 
                repaint();
                Thread.sleep(800);
                j=r.nextInt(19);
                if(j==i)
                    isImage=true;
                else 
                    isImage=false;
                i=19;
                 repaint();
                 Thread.sleep(200);
                i=j;  
              repaint();
              parent.validate();
            }catch(Exception e){
                
            }
        }
        
    }
    
}
