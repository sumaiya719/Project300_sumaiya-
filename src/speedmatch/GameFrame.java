/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package speedmatch;

import javax.swing.JFrame;

/**
 *
 * @author Rashid
 */
public class GameFrame extends JFrame{
    GameFrame(){
        super("Speed Match");
        this.setSize(1016, 600 + 39);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new MenuFrame());
    }
    
}
