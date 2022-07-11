
package sirinler;



public abstract class Oyuncu extends Karakter{
    private int skor;

    public Oyuncu(int ID, String type, String name, int x, int y) {
        super(ID, type, name, x, y);
     
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }

    
    
    
    public int PuaniGoster(){
        
        
        return skor;
    }
}
