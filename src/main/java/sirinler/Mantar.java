
package sirinler;

import java.awt.Image;
import javax.swing.ImageIcon;


public class Mantar extends Obje{
private Image mantar;
ClassLoader loader;
    public Mantar(int ID, String type, String name, int x, int y) {
        super(ID, type, name, x, y);
        loader = Oyun.class.getClassLoader();
         ImageIcon img=new ImageIcon(loader.getResource("test/Mantar.png"));
	mantar=img.getImage();
        setAppear_time(20);
        setExist_time(7);
    }
    public Image getMantar(){return mantar;}
    public int getTileX(){return getX();}
    public int getTileY(){return getY();}
    
 
        
    
}
