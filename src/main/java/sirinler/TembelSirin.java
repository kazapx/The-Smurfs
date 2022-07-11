
package sirinler;

import java.awt.Image;
import javax.swing.ImageIcon;


public class TembelSirin extends Oyuncu{
private Image player;
ClassLoader loader;

    public TembelSirin(int ID, String type, String name, int x, int y) {
        super(ID, type, name, x, y);
        setID(1);
        setName("Tembel Sirin");
        setType("oyuncu");
	setX(6);
	setY(5);
        loader = Oyun.class.getClassLoader();
         ImageIcon img=new ImageIcon(loader.getResource("test/Tembelsirin.jpg"));
	player=img.getImage();
    }
    
	
	public Image getPlayer(){return player;}
	
	
	public int getTileX(){return getX();}
	public int getTileY(){return getY();}


	public void move(int dx,int dy){
                setX(getX()+dx);
		setY(getY()+dy);
	}  
}
