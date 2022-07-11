
package sirinler;

import java.awt.Image;
import javax.swing.ImageIcon;


public class Altin extends Obje{
private Image altin;
 ClassLoader loader;
    public Altin(int ID, String type, String name, int x, int y) {
        super(ID, type, name, x, y);    
        loader = Oyun.class.getClassLoader();
         ImageIcon img=new ImageIcon(loader.getResource("test/Altin.png"));
	altin=img.getImage();
        setAppear_time(10);
        setExist_time(5);
        
    }
    public Image getAltin(){return altin;}
    public int getTileX(){return getX();}
    public int getTileY(){return getY();}
    
 
        
    
}
