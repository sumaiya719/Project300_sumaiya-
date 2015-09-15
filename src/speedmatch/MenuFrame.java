/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package speedmatch;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Dell
 */
public class MenuFrame extends JPanel{
    boolean ansImage;
      PanelClass P;
	JButton button1, button2;
        static String s;
        JLabel l, time;
        boolean k;
	Thread thread;
    @SuppressWarnings("CallToThreadStartDuringObjectConstruction")
	MenuFrame() {
                s="Score: ";
		this.setLayout(null);
		P = new PanelClass(this);
		this.add(P);
		//P.setBackground(Color.GREEN);
                l=new JLabel(s+P.n);
                time=new JLabel("Time: "+0);
                thread=new Thread(new TimeCount());
                thread.start();
                l.setBounds(200, 25, 140, 20);
                time.setBounds(700, 25, 140, 20);
                add(time);
                add(l);
		P.setBounds(300, 50, 400, 350);
		thread=new Thread(P.run);
		thread.start();
		button1 = new JButton("Not a match");
		button2 = new JButton("Match");
		add(button1);
		button1.setBounds(230, 450, 170, 50);
                button1.setBackground(new Color(255,0,0));
		add(button2);
		button2.setBounds(610, 450, 170, 50);
                button2.setBackground(new Color(34,139,34));
		MEventHandler left, right;
		left = new MEventHandler(new Color(110, 245, 129));
		right = new MEventHandler(new Color(156, 210, 120));
		button1.addActionListener(left);
		button2.addActionListener(right);
		MyKey m;
		m=new MyKey(Color.red);
		button1.addKeyListener(m);
		button2.addKeyListener(m);
        }
      class MEventHandler implements ActionListener{
            Color r;
            @Override
            public void actionPerformed(ActionEvent e)
            {
               
                thread=new Thread(P.run);
		thread.start();
                
                validate();
            }

            MEventHandler (Color c){
                r=c;
            }
        }
       class MyKey implements KeyListener{
           public Color c;
           public Color d;
           MyKey(Color k){
               c=k;
               d=new Color(0, 0, 0);
           }
        
           @Override
        public void keyTyped(KeyEvent e) {
            
        }

        
           @Override
        public void keyPressed(KeyEvent e) {
            
            JLabel l=new JLabel();
            l.setText(KeyEvent.getKeyText(e.getKeyCode()));
            if(KeyEvent.getKeyText(e.getKeyCode()).equals("Left"))
            {
                ansImage=false;
                if(ansImage==P.isImage)
                    P.n++;
                l.setText(s+P.n);
                validate();
                thread=new Thread(P.run);
		thread.start();
            }
            else
            {
                ansImage=true;
                if(ansImage==P.isImage)
                    P.n++;
                l.setText(s+P.n);
                validate();
                 thread=new Thread(P.run);
		thread.start();
            }
            validate();
        }

      
           @Override
        public void keyReleased(KeyEvent e) {
          
        }
    }
       
       class TimeCount implements Runnable{
        int time;

        public TimeCount() {
            time=0;
        }
        
        @Override
        @SuppressWarnings("SleepWhileInLoop")
        public void run() {
            while(time<61){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MenuFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            time+=1;
            MenuFrame.this.time.setText("Time: "+time);
            validate();
            }
        }
        
    }
}
       
       

   
