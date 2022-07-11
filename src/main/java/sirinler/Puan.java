
package sirinler;

public class Puan extends Oyuncu{

    public Puan(int ID, String type, String name, int x, int y) {
        super(ID, type, name, x, y);
        setSkor(20);
    }

    @Override
    public void setSkor(int skor) {
        super.setSkor(skor); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSkor() {
        return super.getSkor(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    @Override
    public int PuaniGoster() {

        return super.PuaniGoster(); //To change body of generated methods, choose Tools | Templates.
    }

  


   
   
}
