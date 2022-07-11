
package sirinler;

public class Obje extends Karakter{
    
    private int exist_time;
    private int appear_time;
    
    public Obje(int ID, String type, String name, int x, int y) {
        super(ID, type, name, x, y);
        setType("obje");
        
        
    }

    public int getExist_time() {
        return exist_time;
    }

    public void setExist_time(int exist_time) {
        this.exist_time = exist_time;
    }

    public int getAppear_time() {
        return appear_time;
    }

    public void setAppear_time(int appear_time) {
        this.appear_time = appear_time;
    }

    
    
}
