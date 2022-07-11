
package sirinler;

import java.awt.Image;


public abstract class Karakter {
    
        private int ID;
        private String type; 
	private String name;
	private int x,y;

    public Karakter(int ID, String type, String name, int x, int y) {
        this.ID = ID;
        this.type = type;
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public Karakter(){
	 this.ID=-1;
	 this.name="unknown";
	 this.type="unknown";
	 this.x=-1;
	 this.y=-1;
	}
   

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
        
        
    
    
    
}
