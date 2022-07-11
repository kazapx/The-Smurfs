
package sirinler;

import java.awt.Image;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.ImageIcon;


public class Gargamel extends Dusman{
private Image azman;
private int kose_sayisi = 78;  //harita txt de 78 tane 1 var.
ArrayList<Integer> yol;
int uzaklikk;
ClassLoader loader;
  ArrayList<ArrayList<Integer>> graf = new ArrayList<ArrayList<Integer>>(kose_sayisi);
    public Gargamel(int ID, String type, String name, int x, int y) {
        super(ID, type, name, x, y);
        setID(1);
        setName("Gargamel");
        setType("Dusman");
	setX(3);
	setY(0);
        loader = Oyun.class.getClassLoader();
         ImageIcon img=new ImageIcon(loader.getResource("test/Gargamel.png"));
	azman=img.getImage();
       yol = new ArrayList<Integer>();
       
    }

  
    public void EnKisaYol(int Dx, int Dy, int Ox, int Oy) {
   
        int DusmanKose = getkose_no(Dx,Dy);
        int OyuncuKose = getkose_no(Ox,Oy);
        // bitişiklik listesi
       
        
         for (int i = 0; i < kose_sayisi+1; i++) {
            graf.add(new ArrayList<Integer>());
        }
         
         addEdge(graf);
         
         ShortestDistance(graf, DusmanKose, OyuncuKose, kose_sayisi);
         
         
    }

   

   public Image getAzman(){return azman;}
	
	
	public int getTileX(){return getX();}
	public int getTileY(){return getY();}


	public void move(int dx,int dy){
                setX(getX()+dx);
		setY(getY()+dy);
	}
        
         
           public void addEdge(ArrayList<ArrayList<Integer>> graf)
    {
        Map m = new Map();
   
              for(int y=0;y<11;y++){
			for(int x=0;x<13;x++){
                            if(m.getMap(x, y).equals("1")){
                                if(x==12 && y==10)
                                    continue;
                                 if(x==12){
                                 if(m.getMap(x, y+1).equals("1")){
                                graf.get(getkose_no(x,y)).add(getkose_no(x,y+1));
                                graf.get(getkose_no(x,y+1)).add(getkose_no(x,y));
                                }
                                continue;
                                } 
                                if(y==10){
                                 if(m.getMap(x+1, y).equals("1")){
                                graf.get(getkose_no(x,y)).add(getkose_no(x+1,y));
                                graf.get(getkose_no(x+1,y)).add(getkose_no(x,y));
                              }
                              continue;
                                }

				
                                if(m.getMap(x+1, y).equals("1")){
                                graf.get(getkose_no(x,y)).add(getkose_no(x+1,y));
                                graf.get(getkose_no(x+1,y)).add(getkose_no(x,y));
                              }
                                if(m.getMap(x, y+1).equals("1")){
                                graf.get(getkose_no(x,y)).add(getkose_no(x,y+1));
                                graf.get(getkose_no(x,y+1)).add(getkose_no(x,y));
                              }
                               
                                
                                              
                                }		
		}
			}
        
    }
           
           public int getkose_no(int xx, int yy) {
   
             Map m = new Map();
            int no = 0;
              for(int y=0;y<11;y++){
			for(int x=0;x<13;x++){
				if(m.getMap(x, y).equals("1")){
                                    if(xx == x && yy == y){
                                    return no;
                                    }
                                    no++;
                                        }
					
		}
			}
        return 0;
             

    }
public int getkordinatx(int no) {
   
             Map m = new Map();
        int a = -1;
              for(int y=0;y<11;y++){
			for(int x=0;x<13;x++){
				if(m.getMap(x, y).equals("1")){
                                    a++;
                                    if(a==no){
                                        return x;}
                                        }
					
		}
			}
        return 0;
    }
public int getkordinaty(int no) {
   
             Map m = new Map();
        int a = -1;
              for(int y=0;y<11;y++){
			for(int x=0;x<13;x++){
				if(m.getMap(x, y).equals("1")){
                                    a++;
                                    if(a==no){
                                        return y;}
                                        }
					
		}
			}
        return 0;
    }
    private void ShortestDistance(ArrayList<ArrayList<Integer>> graf, int DusmanKose, int OyuncuKose, int kose_sayisi) {
        
        int ata[] = new int[kose_sayisi];
        int uzaklik[] = new int[kose_sayisi];
        
      if (BFS(graf, DusmanKose, OyuncuKose, kose_sayisi, ata, uzaklik) == false) {
           // System.out.println("Given source and destination are not connected");
            return;
        }
      
     
        LinkedList<Integer> path = new LinkedList<Integer>();
        int crawl = OyuncuKose;
        path.add(crawl);
        while (ata[crawl] != -1) {
            path.add(ata[crawl]);
            crawl = ata[crawl];
        }
 
       
      //  System.out.println("Shortest path length is: " + uzaklik[OyuncuKose]);
        uzaklikk = uzaklik[OyuncuKose];
         yol.clear();
        
        // Print path
      //  System.out.println("Path is ::");
        for (int i = path.size() - 1; i >= 0; i--) {
       //     System.out.print(path.get(i) + " ");
            yol.add(path.get(i));
        }
        
        
    }
           
      private boolean BFS(ArrayList<ArrayList<Integer>> adj, int src,
                                  int dest, int v, int pred[], int dist[])
    {
    
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
   
        boolean gittimi[] = new boolean[v];
 
     
        for (int i = 0; i < v; i++) {
            gittimi[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }
 
      
        gittimi[src] = true;
        dist[src] = 0;
        queue.add(src);
 
        
        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int i = 0; i < adj.get(u).size(); i++) {
                if (gittimi[adj.get(u).get(i)] == false) {
                    gittimi[adj.get(u).get(i)] = true;
                    dist[adj.get(u).get(i)] = dist[u] + 1;
                    pred[adj.get(u).get(i)] = u;
                    queue.add(adj.get(u).get(i));
 
                    // stopping condition (when we find
                    // our destination)
                    if (adj.get(u).get(i) == dest)
                        return true;
                }
            }
        }
        return false;
    }     
}
