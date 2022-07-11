
package sirinler;

import javax.swing.JFrame;


public class Window {

    public Window() {
        
		JFrame f =new JFrame();
		f.setTitle("Sirinler");
		f.add(new Oyun());
		//f.setSize(780,690);
                f.setSize(1000,690);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              
                
    }
    
    
             public static void main(String[] args) {
        
 new Window();
  
	}
    
}
