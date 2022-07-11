
package sirinler;
import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.ImageIcon;



public class Map {

	private Scanner m;
        private Scanner d;
	private String Map[]=new String[11];
        private ArrayList<String> Dusmanlar = new ArrayList<String>();
        private ArrayList<String> Dusmanlardegistimi = new ArrayList<String>();
        ArrayList<String> Dusmanisim = new ArrayList<String>();
	 ArrayList<Character> Dusmankapi = new ArrayList<Character>();
	private Image grass,wall,finish,redfloor;
	ClassLoader loader;
	public Map(){
		loader = Oyun.class.getClassLoader();
		ImageIcon img=new ImageIcon(loader.getResource("test/grass.jpg"));
		grass=img.getImage();
		
		img=new ImageIcon(loader.getResource("test/wall.jpg"));
		wall=img.getImage();
		
		img=new ImageIcon(loader.getResource("test/grassk.jpg"));
		redfloor=img.getImage();
		
		openFile();
		readFile();
		closeFile();
               
	}
	
	public String getMap(int x,int y){
		String index=Map[y].substring(x,x+1);
		return index;
	}
	
        
        
	public Image getGrass(){return grass;}
	public Image getWall(){return wall;}
        public Image getRedfloor(){return redfloor;}
	
	
	
	public void openFile(){
	String m1 = loader.getResource("test/harita.txt").getPath();
        String d1 = loader.getResource("test/harita.txt").getPath();
            try {
		m=new Scanner(new File(m1));
                d=new Scanner(new File(d1));
	} catch (FileNotFoundException e) {
	}

	}
	
public void readFile(){
		 
             // alfabedeki tum karakterlerin scanner tarafindan okunmamasini sagliyoruz. Boylelikle sadece mapi cekmis oluyoruz
             int i = 0; 
          m.useDelimiter("\\n");
String pattern = "[a-zA-Z:,\\n]*";  
			while(m.hasNext()){
			m.skip(pattern); 
				Map[i]= m.next(); 
                               i++;
		}
                        
              //Mapi yukarida Map[] dizisine aldik fakat 1 ve 0 lar arasindaki tab boslugu kaldigindan o tablari siliyoruz.          
                        for (int j = 0; j < 11; j++) {
                                String strNew =  Map[j].replace("\t", "");
                                Map[j] = strNew;
                           
        }

                    
          /////////////////////////////////////////              
            int ii = 0;            
                        d.useDelimiter("[0-9\\s]");                   
while(d.hasNext()){			
    Dusmanlar.add(d.next()); 
                             if("".equals(Dusmanlar.get(ii))){
                                break;}ii++;
 }
Dusmanlar.remove(ii);

   
    for (int j = 0; j < Dusmanlar.size(); j++) {
        
       
       
       if(Dusmanlar.get(j).charAt(9) == 'G'){
        Dusmanisim.add("Gargamel");
       Dusmankapi.add(Dusmanlar.get(j).charAt(23));
       
       }
       else{
        Dusmanisim.add("Azman"); 
       Dusmankapi.add(Dusmanlar.get(j).charAt(20));
        
       }
       
    }
    
    
    
    
}
public void closeFile(){
	m.close();
        d.close();
    }
}

