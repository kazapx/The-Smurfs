
package sirinler;
import javax.swing.Timer;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
//Math.random()

public class Oyun extends JPanel implements ActionListener{

    JButton start;
    JButton exit;
    JButton gozluklu;
    JButton tembel;
    boolean begin = false;
    int ID;
    private Map m;
    private GozlukluSirin gs;
    private TembelSirin ts;
    private Mantar mantar;
    private Azman azman1;
    private Azman azman2;
    private Gargamel Gargamel1;
    private Gargamel Gargamel2;
    private Altin altin1;
    private Altin altin2;
    private Altin altin3;
    private Altin altin4;
    private Altin altin5;
    private Puan puan;
    private boolean Mantar_ye = false;
    private boolean Altin_ye0 = false;
    private boolean Altin_ye1 = false;
    private boolean Altin_ye2 = false;
    private boolean Altin_ye3 = false;
    private boolean Altin_ye4 = false;
    private boolean random = true;
    private boolean randoma = true;
    private boolean randoma_bayrak = false;
    private boolean suredoldu = false;
    private boolean mantardisappear = false;
    private boolean altindisappear = false;
    private boolean daha_yeme;
    private boolean daha_yeme_altin1;
    private boolean daha_yeme_altin2;
    private boolean daha_yeme_altin3;
    private boolean daha_yeme_altin4;
    private boolean daha_yeme_altin5;

    private int key;
    private int sure_mantar = 7;
    private int sure_altin = 5;
    private int kac_altin_yedi = 0;
    private int kac_mantar_yedi = 0;
    private int[] altinX;
    private int[] altinY;
    private int azmansayisi = 0;
    private int gargamelsayisi = 0;
    private char[] azmankapi = new char[2];
    private char[] gargamelkapi = new char[2];
     private boolean lose = false;
     private boolean win = false;
      ClassLoader loader;
    public Oyun() { 
  loader = Oyun.class.getClassLoader();
     // setLayout(null);
     altinX = new int[5];
     altinY = new int[5];
      puan = new Puan(0, "skor", "skor", -1, -1);
        start = new JButton("Start");
        exit = new JButton("Exit");
       start.setSize(200,200);
       start.setVisible(true);
        add(start);
        exit.setSize(200,200);
       exit.setVisible(true);
        add(exit);
        start.addActionListener(this);
        exit.addActionListener(this);
        exit.setLocation(200,0);
        gozluklu = new JButton("Gozluklu sirin");
        tembel = new JButton("Tembel sirin");
       gozluklu.setSize(200,200);
       gozluklu.setVisible(false);
        add(gozluklu);
        tembel.setSize(200,200);
       tembel.setVisible(false);
        add(tembel);
        gozluklu.setLocation(200,0);
        tembel.addActionListener(this);
       gozluklu.addActionListener(this);
     gs=new GozlukluSirin(45, "goz", "asas", -1, -1); // 5 6
      ts=new TembelSirin(45, "goz", "asas", -1, -1);
      mantar = new Mantar(3,"goz", "asas", 4, 5);
      altin1 = new Altin(3,"goz", "asas", 4, 5);
      altin2 = new Altin(3,"goz", "asas", 4, 5);
      altin3 = new Altin(3,"goz", "asas", 4, 5);
      altin4 = new Altin(3,"goz", "asas", 4, 5);
      altin5 = new Altin(3,"goz", "asas", 4, 5);
        m=new Map();
       addKeyListener(new Al());
       setFocusable(true);
       
      
       azman1 = new Azman(45, "goz", "asas", 0, 0);
       azman2 = new Azman(45, "goz", "asas", 0, 0);
      Gargamel1 = new Gargamel(45, "goz", "asas", 0, 0);
       Gargamel2 = new Gargamel(45, "goz", "asas", 0, 0);

     	
    }

    
    
    @Override
    public void actionPerformed(ActionEvent arg0) { 
       if(arg0.getActionCommand().equals("Exit")){
           System.exit(0);}
      
      if(arg0.getActionCommand().equals("Start"))
      { start.setVisible(false); exit.setVisible(false); gozluklu.setVisible(true);  tembel.setVisible(true);
      repaint();
      }
      if(arg0.getActionCommand().equals("Gozluklu sirin"))
       { ID = 2; gozluklu.setVisible(false);tembel.setVisible(false);
       gs.setX(6);
       gs.setY(5);
       begin = true;
       repaint();
       }
     if(arg0.getActionCommand().equals("Tembel sirin"))
      {    ID = 1; tembel.setVisible(false);gozluklu.setVisible(false);
      ts.setX(6);
      ts.setY(5);
        begin = true;
        repaint();
              } 
    
     
        
          
     if(begin)
     {
         
    mantardisappear_clock();
         Timer timer = new Timer( mantar.getAppear_time()*1000, e -> {
    random = true;
    mantardisappear_clock();
      sure_mantar = mantar.getExist_time();
   
  } );
  timer.setRepeats( true );
      timer.start();
      ///////////////////////////////////////////////////////////////////////////////////////////
      
      altindisappear_clock();
        Timer timerr = new Timer( altin1.getAppear_time()*1000, e -> {
   randoma = true;
   
    altindisappear_clock();
  
    sure_altin = altin1.getExist_time();
  } );
  timerr.setRepeats( true );
      timerr.start();
      
      
       Timer timer3 = new Timer( 1000, e -> {
  sure_altin--;
  sure_mantar--;
   
  } );
  timer3.setRepeats( true );
      timer3.start();
      
      
     
             
          try{
              for (int i = 0; i < 4; i++) {
               if("Azman".equals(m.Dusmanisim.get(i)))
     { if(azmansayisi==1){
       if(m.Dusmankapi.get(i) == 'A'){ azman2.setX(3); azman2.setY(0);azmankapi[1] = 'A';}azmansayisi++;
        if(m.Dusmankapi.get(i) == 'B'){ azman2.setX(10); azman2.setY(0);azmankapi[1] = 'B';}
        if(m.Dusmankapi.get(i) == 'C'){ azman2.setX(0); azman2.setY(5);azmankapi[1] = 'C';} 
        if(m.Dusmankapi.get(i) == 'D'){ azman2.setX(3); azman2.setY(10);azmankapi[1] = 'D';} 
     }
         
         if(azmansayisi==0){
       if(m.Dusmankapi.get(i) == 'A'){ azman1.setX(3); azman1.setY(0);azmankapi[0] = 'A';}azmansayisi++;
        if(m.Dusmankapi.get(i) == 'B'){ azman1.setX(10); azman1.setY(0);azmankapi[0] = 'B';}
        if(m.Dusmankapi.get(i) == 'C'){ azman1.setX(0); azman1.setY(5);azmankapi[0] = 'C';} 
        if(m.Dusmankapi.get(i) == 'D'){ azman1.setX(3); azman1.setY(10);azmankapi[0] = 'D';} 
     }
     
     }
      if("Gargamel".equals(m.Dusmanisim.get(i)))
     {  
         if(gargamelsayisi==1){
        if(m.Dusmankapi.get(i) == 'A'){ Gargamel2.setX(3); Gargamel2.setY(0);gargamelkapi[1] = 'A';}gargamelsayisi++;
        if(m.Dusmankapi.get(i) == 'B'){ Gargamel2.setX(10); Gargamel2.setY(0);gargamelkapi[1] = 'B';}
        if(m.Dusmankapi.get(i) == 'C'){ Gargamel2.setX(0); Gargamel2.setY(5);gargamelkapi[1] = 'C';} 
        if(m.Dusmankapi.get(i) == 'D'){ Gargamel2.setX(3); Gargamel2.setY(10);gargamelkapi[1] = 'D';}
     }
         
         if(gargamelsayisi==0){
        if(m.Dusmankapi.get(i) == 'A'){ Gargamel1.setX(3); Gargamel1.setY(0);gargamelkapi[0] = 'A';}gargamelsayisi++;
        if(m.Dusmankapi.get(i) == 'B'){ Gargamel1.setX(10); Gargamel1.setY(0);gargamelkapi[0] = 'B';}
        if(m.Dusmankapi.get(i) == 'C'){ Gargamel1.setX(0); Gargamel1.setY(5);gargamelkapi[0] = 'C';} 
        if(m.Dusmankapi.get(i) == 'D'){ Gargamel1.setX(3); Gargamel1.setY(10);gargamelkapi[0] = 'D';}
     }  
        
     }         
              }
       }
     catch(Exception e){}
    
        repaint();
     }
     
    repaint();
    }

    
    
    
    
   public void paint(Graphics g)
    {
        repaint();
      super.paint(g);
 if(lose)
 { g.clearRect(0,0,1000,690);
  Font trb2 = new Font("TimesRoman",UNDEFINED_CONDITION, 60);
      g.setFont(trb2);
      g.drawString("KAYBETTİN", this.getWidth()/3, this.getHeight()/3);
 
 }
 if(win)
 { g.clearRect(0,0,1000,690);
  Font trb2 = new Font("TimesRoman",UNDEFINED_CONDITION, 60);
      g.setFont(trb2);
      g.drawString("KAZANDIN", this.getWidth()/3, this.getHeight()/3);
      Font trb23 = new Font("TimesRoman",UNDEFINED_CONDITION, 30);
      g.setFont(trb23);
      g.drawString("Puan:"+puan.getSkor(), this.getWidth()/2-80, this.getHeight()/2);
 
 }
   if(begin){ 
     
    for(int y=0;y<11;y++){
			for(int x=0;x<13;x++){
				if(m.getMap(x, y).equals("1")){g.drawImage(m.getGrass(),x*60,y*60,null);}
				if(m.getMap(x, y).equals("0")){g.drawImage(m.getWall(),x*60,y*60,null);}	
		}
			}
     
    ImageIcon finish = new ImageIcon(loader.getResource("test/finish.png"));
       Image finishh = finish.getImage();
     g.drawImage(finishh,13*60,7*60,null);
     
       
  
  
  if(ID == 1)
  {
      if(azmansayisi == 1)
      {
        if((ts.getTileX() == azman1.getX())  &&  (ts.getTileY() == azman1.getY()))
        {
        if(azmankapi[0] == 'A'){ azman1.setX(3); azman1.setY(0);}
        if(azmankapi[0] == 'B'){ azman1.setX(10); azman1.setY(0);}
        if(azmankapi[0] == 'C'){ azman1.setX(0); azman1.setY(5);} 
        if(azmankapi[0] == 'D'){ azman1.setX(3); azman1.setY(10);}puan.setSkor(puan.getSkor()-5);
        
        }
      }
      if(azmansayisi == 2)
      {
      if((ts.getTileX() == azman1.getX())  &&  (ts.getTileY() == azman1.getY()))
        {
        if(azmankapi[0] == 'A'){ azman1.setX(3); azman1.setY(0);}
        if(azmankapi[0] == 'B'){ azman1.setX(10); azman1.setY(0);}
        if(azmankapi[0] == 'C'){ azman1.setX(0); azman1.setY(5);} 
        if(azmankapi[0] == 'D'){ azman1.setX(3); azman1.setY(10);}puan.setSkor(puan.getSkor()-5);
        
        }
      if((ts.getTileX() == azman2.getX())  &&  (ts.getTileY() == azman2.getY()))
        {
        if(azmankapi[1] == 'A'){ azman2.setX(3); azman2.setY(0);}
        if(azmankapi[1] == 'B'){ azman2.setX(10);azman2.setY(0);}
        if(azmankapi[1] == 'C'){ azman2.setX(0); azman2.setY(5);} 
        if(azmankapi[1] == 'D'){ azman2.setX(3); azman2.setY(10);}puan.setSkor(puan.getSkor()-5);
        
        }
      
      }
      
      if(gargamelsayisi == 1)
      {
        if((ts.getTileX() == Gargamel1.getX())  &&  (ts.getTileY() == Gargamel1.getY()))
        {
        if(gargamelkapi[0] == 'A'){ Gargamel1.setX(3); Gargamel1.setY(0);}
        if(gargamelkapi[0] == 'B'){ Gargamel1.setX(10); Gargamel1.setY(0);}
        if(gargamelkapi[0] == 'C'){ Gargamel1.setX(0); Gargamel1.setY(5);} 
        if(gargamelkapi[0] == 'D'){ Gargamel1.setX(3); Gargamel1.setY(10);}puan.setSkor(puan.getSkor()-15);
        
        }
      }
      if(gargamelsayisi == 2)
      {
      if((ts.getTileX() == Gargamel1.getX())  &&  (ts.getTileY() == Gargamel1.getY()))
        {
        if(gargamelkapi[0] == 'A'){ Gargamel1.setX(3); Gargamel1.setY(0);}
        if(gargamelkapi[0] == 'B'){ Gargamel1.setX(10); Gargamel1.setY(0);}
        if(gargamelkapi[0] == 'C'){ Gargamel1.setX(0); Gargamel1.setY(5);} 
        if(gargamelkapi[0] == 'D'){ Gargamel1.setX(3); Gargamel1.setY(10);}puan.setSkor(puan.getSkor()-15);
        
        }
      if((ts.getTileX() == Gargamel2.getX())  &&  (ts.getTileY() == Gargamel2.getY()))
        {
        if(gargamelkapi[1] == 'A'){ Gargamel2.setX(3); Gargamel2.setY(0);}
        if(gargamelkapi[1] == 'B'){ Gargamel2.setX(10); Gargamel2.setY(0);}
        if(gargamelkapi[1] == 'C'){ Gargamel2.setX(0); Gargamel2.setY(5);} 
        if(gargamelkapi[1] == 'D'){ Gargamel2.setX(3); Gargamel2.setY(10);}puan.setSkor(puan.getSkor()-15);
        
        }
      
      }
      
      
  }
  if(ID == 2)
  {
  if(azmansayisi == 1)
      {
        if((gs.getTileX() == azman1.getX())  &&  (gs.getTileY() == azman1.getY()))
        {
        if(azmankapi[0] == 'A'){ azman1.setX(3); azman1.setY(0);}
        if(azmankapi[0] == 'B'){ azman1.setX(10); azman1.setY(0);}
        if(azmankapi[0] == 'C'){ azman1.setX(0); azman1.setY(5);} 
        if(azmankapi[0] == 'D'){ azman1.setX(3); azman1.setY(10);}puan.setSkor(puan.getSkor()-5);
        
        }
      }
      if(azmansayisi == 2)
      {
      if((gs.getTileX() == azman1.getX())  &&  (gs.getTileY() == azman1.getY()))
        {
        if(azmankapi[0] == 'A'){ azman1.setX(3); azman1.setY(0);}
        if(azmankapi[0] == 'B'){ azman1.setX(10); azman1.setY(0);}
        if(azmankapi[0] == 'C'){ azman1.setX(0); azman1.setY(5);} 
        if(azmankapi[0] == 'D'){ azman1.setX(3); azman1.setY(10);}puan.setSkor(puan.getSkor()-5);
        
        }
      if((gs.getTileX() == azman2.getX())  &&  (gs.getTileY() == azman2.getY()))
        {
        if(azmankapi[1] == 'A'){ azman2.setX(3); azman2.setY(0);}
        if(azmankapi[1] == 'B'){ azman2.setX(10);azman2.setY(0);}
        if(azmankapi[1] == 'C'){ azman2.setX(0); azman2.setY(5);} 
        if(azmankapi[1] == 'D'){ azman2.setX(3); azman2.setY(10);}puan.setSkor(puan.getSkor()-5);
        
        }
      
      }
      
      if(gargamelsayisi == 1)
      {
        if((gs.getTileX() == Gargamel1.getX())  &&  (gs.getTileY() == Gargamel1.getY()))
        {
        if(gargamelkapi[0] == 'A'){ Gargamel1.setX(3); Gargamel1.setY(0);}
        if(gargamelkapi[0] == 'B'){ Gargamel1.setX(10); Gargamel1.setY(0);}
        if(gargamelkapi[0] == 'C'){ Gargamel1.setX(0); Gargamel1.setY(5);} 
        if(gargamelkapi[0] == 'D'){ Gargamel1.setX(3); Gargamel1.setY(10);}puan.setSkor(puan.getSkor()-15);
        
        }
      }
      if(gargamelsayisi == 2)
      {
      if((gs.getTileX() == Gargamel1.getX())  &&  (gs.getTileY() == Gargamel1.getY()))
        {
        if(gargamelkapi[0] == 'A'){ Gargamel1.setX(3); Gargamel1.setY(0);}
        if(gargamelkapi[0] == 'B'){ Gargamel1.setX(10); Gargamel1.setY(0);}
        if(gargamelkapi[0] == 'C'){ Gargamel1.setX(0); Gargamel1.setY(5);} 
        if(gargamelkapi[0] == 'D'){ Gargamel1.setX(3); Gargamel1.setY(10);}puan.setSkor(puan.getSkor()-15);
        
        }
      if((gs.getTileX() == Gargamel2.getX())  &&  (gs.getTileY() == Gargamel2.getY()))
        {
        if(gargamelkapi[1] == 'A'){ Gargamel2.setX(3); Gargamel2.setY(0);}
        if(gargamelkapi[1] == 'B'){ Gargamel2.setX(10); Gargamel2.setY(0);}
        if(gargamelkapi[1] == 'C'){ Gargamel2.setX(0); Gargamel2.setY(5);} 
        if(gargamelkapi[1] == 'D'){ Gargamel2.setX(3); Gargamel2.setY(10);}puan.setSkor(puan.getSkor()-15);
        
        }
      
      }
      
  
  }
  
  if(puan.getSkor()<= 0)
  {
      begin = false;
      lose = true;
  }
  
     if(azmansayisi == 1){
       for (int i = 1; i < azman1.uzaklikk; i++) {
            g.drawImage(m.getRedfloor(),azman1.getkordinatx(azman1.yol.get(i))*60,azman1.getkordinaty(azman1.yol.get(i))*60,null);
         }}
         if(azmansayisi == 2){
       for (int i = 1; i < azman1.uzaklikk; i++) {
            g.drawImage(m.getRedfloor(),azman1.getkordinatx(azman1.yol.get(i))*60,azman1.getkordinaty(azman1.yol.get(i))*60,null);
      
         }
         for (int i = 1; i < azman2.uzaklikk; i++) {
              g.drawImage(m.getRedfloor(),azman2.getkordinatx(azman2.yol.get(i))*60,azman2.getkordinaty(azman2.yol.get(i))*60,null);
         }}
    
         
       if(gargamelsayisi == 1){
       for (int i = 2; i < Gargamel1.uzaklikk; i++) {
            g.drawImage(m.getRedfloor(),Gargamel1.getkordinatx(Gargamel1.yol.get(i))*60,Gargamel1.getkordinaty(Gargamel1.yol.get(i))*60,null);
         }}
         if(gargamelsayisi == 2){
       for (int i = 2; i < Gargamel1.uzaklikk; i++) {
            g.drawImage(m.getRedfloor(),Gargamel1.getkordinatx(Gargamel1.yol.get(i))*60,Gargamel1.getkordinaty(Gargamel1.yol.get(i))*60,null);
      
         }
         for (int i = 2; i < Gargamel2.uzaklikk; i++) {
              g.drawImage(m.getRedfloor(),Gargamel2.getkordinatx(Gargamel2.yol.get(i))*60,Gargamel2.getkordinaty(Gargamel2.yol.get(i))*60,null);
         }}
         
  if(azmansayisi == 1){
     g.drawImage(azman1.getAzman(),azman1.getTileX()*60,azman1.getTileY()*60,null);}
  if(azmansayisi == 2){
     g.drawImage(azman1.getAzman(),azman1.getTileX()*60,azman1.getTileY()*60,null);
  g.drawImage(azman2.getAzman(),azman2.getTileX()*60,azman2.getTileY()*60,null);
  }
  if(gargamelsayisi == 1){
     g.drawImage(Gargamel1.getAzman(),Gargamel1.getTileX()*60,Gargamel1.getTileY()*60,null);}
  if(gargamelsayisi == 2){
     g.drawImage(Gargamel1.getAzman(),Gargamel1.getTileX()*60,Gargamel1.getTileY()*60,null);
  g.drawImage(Gargamel2.getAzman(),Gargamel2.getTileX()*60,Gargamel2.getTileY()*60,null);
  }
         
     
      while(random)
    {int x = (int) ((Math.random() * 100)%11+1);
     int y = (int) ((Math.random() * 100)%9+1);
    if(m.getMap(x, y).equals("1"))
    {    mantar.setX(x);
         mantar.setY(y);
    random = false;
    Mantar_ye = false;
    daha_yeme = true;
    break;
    }      
    }
      
      
     while(randoma)
    {  for (int i = 0; i < 5; i++) {
     int x = (int) ((Math.random() * 100)%11+1);
     int y = (int) ((Math.random() * 100)%9+1);
       
     altinX[i] = x;
     altinY[i] = y;
     if(m.getMap(x, y).equals("0") || (mantar.getTileX() == x && mantar.getTileY() == y))
    {   i--;
    }
         
    } 
        for (int i = 0; i < 5; i++) {
            for (int j = i+1; j < 5; j++) {
                if(altinX[i]==altinX[j] && altinY[i]==altinY[j]){
                    randoma_bayrak = true;
                    break;
                    }
            }
            
        }
        if(randoma_bayrak == true){randoma = true; randoma_bayrak = false;}
        else{
        altin1.setX(altinX[0]); altin1.setY(altinY[0]);
        altin2.setX(altinX[1]); altin2.setY(altinY[1]);
        altin3.setX(altinX[2]); altin3.setY(altinY[2]);
        altin4.setX(altinX[3]); altin4.setY(altinY[3]);
        altin5.setX(altinX[4]); altin5.setY(altinY[4]);
        
    randoma = false; 
    Altin_ye0 = false;
    Altin_ye1 = false;
    Altin_ye2 = false;
    Altin_ye3 = false;
    Altin_ye4 = false;
    daha_yeme_altin1 = true;
    daha_yeme_altin2 = true;
    daha_yeme_altin3 = true;
    daha_yeme_altin4 = true;
    daha_yeme_altin5 = true;
        }
    } 
    
      if( Mantar_ye == false )//mantari ciz
    {g.drawImage(mantar.getMantar(),mantar.getTileX()*60,mantar.getTileY()*60,null);
    }
      
    
       if(Altin_ye0 == false){
            g.drawImage(altin1.getAltin(),altinX[0]*60,altinY[0]*60,null);
       }
       if(Altin_ye1 == false){
            g.drawImage(altin2.getAltin(),altinX[1]*60,altinY[1]*60,null);
       }
       if(Altin_ye2 == false){
            g.drawImage(altin3.getAltin(),altinX[2]*60,altinY[2]*60,null);
       }
       if(Altin_ye3 == false){
            g.drawImage(altin4.getAltin(),altinX[3]*60,altinY[3]*60,null);
       }
       if(Altin_ye4 == false){
            g.drawImage(altin5.getAltin(),altinX[4]*60,altinY[4]*60,null);
       }


    
    if(ID==2){
        
  if(key == 1){
   if(  (gs.getTileX() == mantar.getTileX())  &&  (gs.getTileY()+1 == mantar.getTileY()) && daha_yeme){
    Mantar_ye = true;kac_mantar_yedi++;
   puan.setSkor(puan.getSkor()+50);
     daha_yeme = false;

  }
   if(  (gs.getTileX() == altinX[0])  &&  (gs.getTileY()+1 == altinY[0])  && daha_yeme_altin1){
     Altin_ye0 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin1 = false;
  }
    if(  (gs.getTileX() == altinX[1])  &&  (gs.getTileY()+1 ==altinY[1])  && daha_yeme_altin2){
     Altin_ye1 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin2 = false;
  }
     if(  (gs.getTileX() == altinX[2])  &&  (gs.getTileY()+1 == altinY[2])  && daha_yeme_altin3){
     Altin_ye2 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin3 = false;
  }
      if(  (gs.getTileX() ==altinX[3])  &&  (gs.getTileY()+1 == altinY[3])  && daha_yeme_altin4){
   Altin_ye3 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin4 = false;
  }
       if(  (gs.getTileX() == altinX[4])  &&  (gs.getTileY()+1 ==altinY[4])  && daha_yeme_altin5){
    Altin_ye4 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin5 = false;
  }
  }
  
  
  
  
  
  
  if(key == 2){
  if(  (gs.getTileX()+1 == mantar.getTileX())  &&  (gs.getTileY() == mantar.getTileY())  && daha_yeme){
    Mantar_ye = true;kac_mantar_yedi++;
   puan.setSkor(puan.getSkor()+50);
  daha_yeme = false;
  }
  if(  (gs.getTileX()+1 == altinX[0])  &&  (gs.getTileY() == altinY[0])  && daha_yeme_altin1){
     Altin_ye0 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin1 = false;
  }
    if(  (gs.getTileX()+1 == altinX[1])  &&  (gs.getTileY() ==altinY[1])  && daha_yeme_altin2){
     Altin_ye1 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin2 = false;
  }
     if(  (gs.getTileX()+1 == altinX[2])  &&  (gs.getTileY() == altinY[2])  && daha_yeme_altin3){
     Altin_ye2 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin3 = false;
  }
      if(  (gs.getTileX()+1 ==altinX[3])  &&  (gs.getTileY() == altinY[3])  && daha_yeme_altin4){
    Altin_ye3 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin4 = false;
  }
       if(  (gs.getTileX()+1 == altinX[4])  &&  (gs.getTileY() ==altinY[4])  && daha_yeme_altin5){
    Altin_ye4 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin5 = false;
  }
  }
  
  
  
  
  
  
  if(key == 3){
  if(  (gs.getTileX() == mantar.getTileX())  &&  (gs.getTileY()-1 == mantar.getTileY())  && daha_yeme){
    Mantar_ye = true;kac_mantar_yedi++;
   puan.setSkor(puan.getSkor()+50);
  daha_yeme = false;
  }
  if(  (gs.getTileX() == altinX[0])  &&  (gs.getTileY()-1 == altinY[0])  && daha_yeme_altin1){
     Altin_ye0 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin1 = false;
  }
    if(  (gs.getTileX() == altinX[1])  &&  (gs.getTileY()-1 ==altinY[1])  && daha_yeme_altin2){
     Altin_ye1 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin2 = false;
  }
     if(  (gs.getTileX() == altinX[2])  &&  (gs.getTileY()-1 == altinY[2])  && daha_yeme_altin3){
     Altin_ye2 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin3 = false;
  }
      if(  (gs.getTileX() ==altinX[3])  &&  (gs.getTileY()-1 == altinY[3])  && daha_yeme_altin4){
    Altin_ye3 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin4 = false;
  }
       if(  (gs.getTileX() == altinX[4])  &&  (gs.getTileY()-1 ==altinY[4])  && daha_yeme_altin5){
   Altin_ye4 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin5 = false;
  }
  }
  
  
  
  
  
  
  
  if(key == 4){
  if(  (gs.getTileX()-1 == mantar.getTileX())  &&  (gs.getTileY() == mantar.getTileY())  && daha_yeme){
    Mantar_ye = true;kac_mantar_yedi++;
   puan.setSkor(puan.getSkor()+50);
   daha_yeme = false;
  }
   if(  (gs.getTileX()-1 == altinX[0])  &&  (gs.getTileY() == altinY[0])  && daha_yeme_altin1){
     Altin_ye0 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin1 = false;
  }
    if(  (gs.getTileX()-1 == altinX[1])  &&  (gs.getTileY() ==altinY[1])  && daha_yeme_altin2){
     Altin_ye1 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin2 = false;
  }
     if(  (gs.getTileX()-1 == altinX[2])  &&  (gs.getTileY() == altinY[2])  && daha_yeme_altin3){
     Altin_ye2 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin3 = false;
  }
      if(  (gs.getTileX()-1 ==altinX[3])  &&  (gs.getTileY() == altinY[3])  && daha_yeme_altin4){
     Altin_ye3 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin4 = false;
  }
       if(  (gs.getTileX()-1 == altinX[4])  &&  (gs.getTileY() ==altinY[4])  && daha_yeme_altin5){
    Altin_ye4 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin5 = false;
  }
  }
        
        
        
  
        
  g.drawImage(gs.getPlayer(),gs.getTileX()*60,gs.getTileY()*60,null);
  if(  (gs.getTileX() == mantar.getTileX())  &&  (gs.getTileY() == mantar.getTileY())  && daha_yeme ){
   g.drawImage(gs.getPlayer(),gs.getTileX()*60,gs.getTileY()*60,null); 
    Mantar_ye = true;kac_mantar_yedi++;
   puan.setSkor(puan.getSkor()+50);
  daha_yeme = false;
  }
  //////////////////////////////////////////////////////////////////
  if(  (gs.getTileX() == altinX[0])  &&  (gs.getTileY() == altinY[0])  && daha_yeme_altin1 ){
   g.drawImage(gs.getPlayer(),gs.getTileX()*60,gs.getTileY()*60,null); 
    Altin_ye0 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin1 = false;}
  
  if(  (gs.getTileX() == altinX[1])  &&  (gs.getTileY() == altinY[1])  && daha_yeme_altin2 ){
   g.drawImage(gs.getPlayer(),gs.getTileX()*60,gs.getTileY()*60,null); 
    Altin_ye1 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin2 = false;}
  
  if(  (gs.getTileX() == altinX[2])  &&  (gs.getTileY() == altinY[2])  && daha_yeme_altin3 ){
   g.drawImage(gs.getPlayer(),gs.getTileX()*60,gs.getTileY()*60,null); 
    Altin_ye2 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin3 = false;}
  
  if(  (gs.getTileX() == altinX[3])  &&  (gs.getTileY() == altinY[3])  && daha_yeme_altin4 ){
   g.drawImage(gs.getPlayer(),gs.getTileX()*60,gs.getTileY()*60,null); 
    Altin_ye3 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin4 = false;}
  
  if(  (gs.getTileX() == altinX[4])  &&  (gs.getTileY() == altinY[4])  && daha_yeme_altin5 ){
   g.drawImage(gs.getPlayer(),gs.getTileX()*60,gs.getTileY()*60,null); 
    Altin_ye4 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin5 = false;}
  
  
  if(  (gs.getTileX() == 12)  &&  (gs.getTileY() == 7)){
   begin = false;
   win = true;
   }
    }
    if(ID==1){
  g.drawImage(ts.getPlayer(),ts.getTileX()*60,ts.getTileY()*60,null); 
   if(  (ts.getTileX() == mantar.getTileX())  &&  (ts.getTileY() == mantar.getTileY()) && daha_yeme ){
   g.drawImage(ts.getPlayer(),ts.getTileX()*60,ts.getTileY()*60,null); 
    Mantar_ye = true;kac_mantar_yedi++;
   puan.setSkor(puan.getSkor()+50);
   daha_yeme = false;}
   //////////////////////////////////////////////////////
   else if(  (ts.getTileX() == altinX[0])  &&  (ts.getTileY() == altinY[0])  && daha_yeme_altin1 ){
   g.drawImage(ts.getPlayer(),ts.getTileX()*60,ts.getTileY()*60,null); 
    Altin_ye0 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin1 = false;}
  
 else if(  (ts.getTileX() == altinX[1])  &&  (ts.getTileY() == altinY[1])  && daha_yeme_altin2 ){
   g.drawImage(ts.getPlayer(),ts.getTileX()*60,ts.getTileY()*60,null); 
    Altin_ye1 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin2 = false;}
  
 else if(  (ts.getTileX() == altinX[2])  &&  (ts.getTileY() == altinY[2])  && daha_yeme_altin3 ){
   g.drawImage(ts.getPlayer(),ts.getTileX()*60,ts.getTileY()*60,null); 
    Altin_ye2 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin3 = false;}
  
 else if(  (ts.getTileX() == altinX[3])  &&  (ts.getTileY() == altinY[3])  && daha_yeme_altin4 ){
   g.drawImage(ts.getPlayer(),ts.getTileX()*60,ts.getTileY()*60,null); 
    Altin_ye3 = true;kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin4 = false;}
  
 else if(  (ts.getTileX() == altinX[4])  &&  (ts.getTileY() == altinY[4])  && daha_yeme_altin5 ){
   g.drawImage(ts.getPlayer(),ts.getTileX()*60,ts.getTileY()*60,null); 
    Altin_ye4 = true; kac_altin_yedi++;
   puan.setSkor(puan.getSkor()+5);
  daha_yeme_altin5 = false;}
  
   if(  (ts.getTileX() == 12)  &&  (ts.getTileY() == 7)){
   begin = false;
   win = true;
   }
  
    }
      
   
  if(mantardisappear){
  Mantar_ye = true;
  mantardisappear = false;
  }
  
  if(altindisappear){
  Altin_ye0 = true;
  Altin_ye1 = true;
  Altin_ye2 = true;
  Altin_ye3 = true;
  Altin_ye4 = true;
  altindisappear = false;
  }
  
   //   g.clearRect(13*60,1*60,3*60,2*60);
      ImageIcon skor = new ImageIcon(loader.getResource("test/puan.png"));
       Image skorr = skor.getImage();
      g.drawImage(skorr, 13*60-30, 1*60, null);
      Font trb = new Font("TimesRoman", Font.BOLD, 30);
      g.setFont(trb);
      g.drawString("Puan: "+puan.PuaniGoster(),13*60-20 , 2*60);
      Font trb2 = new Font("TimesRoman",UNDEFINED_CONDITION, 20);
      g.setFont(trb2);
      g.drawString("Altin: "+sure_altin+" saniye",13*60-20 , 3*60);
      g.drawString("Mantar: "+sure_mantar+" saniye",13*60-20 , (int) ((3.3)*60));
      g.drawString("-------------------------", 13*60-20, (int) ((3.4)*60+10));
      ImageIcon kacaltinyedi = new ImageIcon(loader.getResource("test/Altink.png"));
   Image kacaltinyedii = kacaltinyedi.getImage();
      g.drawImage(kacaltinyedii , 13*60-20, (int) ((3.5)*60), null);
    g.drawString("x"+kac_altin_yedi, 13*60, (int) ((3.8)*60));
ImageIcon kacmantaryedi = new ImageIcon(loader.getResource("test/Mantark.png"));
   Image kacmantaryedii = kacmantaryedi.getImage();
      g.drawImage(kacmantaryedii , 14*60, (int) ((3.5)*60), null);
      g.drawString("x"+kac_mantar_yedi, 14*60+20, (int) ((3.8)*60));
    }  
    }

   
   
   public class Al extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			int keycode=e.getKeyCode();
                        if(ID==2){
			if(keycode==KeyEvent.VK_UP){
				if(!m.getMap(gs.getTileX(), gs.getTileY()-1).equals("0")) {
				if(!m.getMap(gs.getTileX(), gs.getTileY()-2).equals("0")){key = 1;
                                gs.move(0,-2);
                                
                                    if(azmansayisi == 1)
     { azman1.EnKisaYol(azman1.getTileX(), azman1.getTileY(),gs.getTileX(), gs.getTileY());}
     if(azmansayisi == 2){
     azman1.EnKisaYol(azman1.getTileX(), azman1.getTileY(),gs.getTileX(), gs.getTileY());
     azman2.EnKisaYol(azman2.getTileX(), azman2.getTileY(),gs.getTileX(), gs.getTileY());}
     
     if(gargamelsayisi == 1)
     { Gargamel1.EnKisaYol(Gargamel1.getTileX(), Gargamel1.getTileY(),gs.getTileX(), gs.getTileY());}
     if(gargamelsayisi == 2){
     Gargamel1.EnKisaYol(Gargamel1.getTileX(), Gargamel1.getTileY(),gs.getTileX(), gs.getTileY());
     Gargamel2.EnKisaYol(Gargamel2.getTileX(), Gargamel2.getTileY(),gs.getTileX(), gs.getTileY());}
     
                                
                                 if(azmansayisi == 1){azman1.setX(azman1.getkordinatx(azman1.yol.get(1))); azman1.setY(azman1.getkordinaty(azman1.yol.get(1)));}
                         if(azmansayisi == 2){azman1.setX(azman1.getkordinatx(azman1.yol.get(1))); azman1.setY(azman1.getkordinaty(azman1.yol.get(1)));
                         azman2.setX(azman2.getkordinatx(azman2.yol.get(1))); azman2.setY(azman2.getkordinaty(azman2.yol.get(1)));}
                        
               
                         if(gargamelsayisi == 1){Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(1))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(1)));
                try{Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(2))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(2)));}catch(Exception x){}       }
                         if(gargamelsayisi == 2){Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(1))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(1)));
                try{Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(2))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(2)));}catch(Exception x){}
                         Gargamel2.setX(Gargamel2.getkordinatx(Gargamel2.yol.get(1))); Gargamel2.setY(Gargamel2.getkordinaty(Gargamel2.yol.get(1)));
                try{Gargamel2.setX(Gargamel2.getkordinatx(Gargamel2.yol.get(2))); Gargamel2.setY(Gargamel2.getkordinaty(Gargamel2.yol.get(2)));}catch(Exception x){}}
                    
                                }}}
			
			if(keycode==KeyEvent.VK_LEFT){
				if(!m.getMap(gs.getTileX()-1, gs.getTileY()).equals("0")) {
				if(!m.getMap(gs.getTileX()-2, gs.getTileY()).equals("0")){key = 2;
                                gs.move(-2,0);
                                
                                    if(azmansayisi == 1)
     { azman1.EnKisaYol(azman1.getTileX(), azman1.getTileY(),gs.getTileX(), gs.getTileY());}
     if(azmansayisi == 2){
     azman1.EnKisaYol(azman1.getTileX(), azman1.getTileY(),gs.getTileX(), gs.getTileY());
     azman2.EnKisaYol(azman2.getTileX(), azman2.getTileY(),gs.getTileX(), gs.getTileY());}
                                
      
     if(gargamelsayisi == 1)
     { Gargamel1.EnKisaYol(Gargamel1.getTileX(), Gargamel1.getTileY(),gs.getTileX(), gs.getTileY());}
     if(gargamelsayisi == 2){
     Gargamel1.EnKisaYol(Gargamel1.getTileX(), Gargamel1.getTileY(),gs.getTileX(), gs.getTileY());
     Gargamel2.EnKisaYol(Gargamel2.getTileX(), Gargamel2.getTileY(),gs.getTileX(), gs.getTileY());}
                                 if(azmansayisi == 1){azman1.setX(azman1.getkordinatx(azman1.yol.get(1))); azman1.setY(azman1.getkordinaty(azman1.yol.get(1)));}
                         if(azmansayisi == 2){azman1.setX(azman1.getkordinatx(azman1.yol.get(1))); azman1.setY(azman1.getkordinaty(azman1.yol.get(1)));
                         azman2.setX(azman2.getkordinatx(azman2.yol.get(1))); azman2.setY(azman2.getkordinaty(azman2.yol.get(1)));}
                                if(gargamelsayisi == 1){Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(1))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(1)));
                try{Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(2))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(2)));}catch(Exception x){}       }
                         if(gargamelsayisi == 2){Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(1))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(1)));
                try{Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(2))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(2)));}catch(Exception x){}
                         Gargamel2.setX(Gargamel2.getkordinatx(Gargamel2.yol.get(1))); Gargamel2.setY(Gargamel2.getkordinaty(Gargamel2.yol.get(1)));
                try{Gargamel2.setX(Gargamel2.getkordinatx(Gargamel2.yol.get(2))); Gargamel2.setY(Gargamel2.getkordinaty(Gargamel2.yol.get(2)));}catch(Exception x){}}
                                }}}
			
			if(keycode==KeyEvent.VK_DOWN){
				if(!m.getMap(gs.getTileX(), gs.getTileY()+1).equals("0")){
				if(!m.getMap(gs.getTileX(), gs.getTileY()+2).equals("0")){key = 3;
                                gs.move(0,2);
                                
                                    if(azmansayisi == 1)
     { azman1.EnKisaYol(azman1.getTileX(), azman1.getTileY(),gs.getTileX(), gs.getTileY());}
     if(azmansayisi == 2){
     azman1.EnKisaYol(azman1.getTileX(), azman1.getTileY(),gs.getTileX(), gs.getTileY());
     azman2.EnKisaYol(azman2.getTileX(), azman2.getTileY(),gs.getTileX(), gs.getTileY());}
            
      
     if(gargamelsayisi == 1)
     { Gargamel1.EnKisaYol(Gargamel1.getTileX(), Gargamel1.getTileY(),gs.getTileX(), gs.getTileY());}
     if(gargamelsayisi == 2){
     Gargamel1.EnKisaYol(Gargamel1.getTileX(), Gargamel1.getTileY(),gs.getTileX(), gs.getTileY());
     Gargamel2.EnKisaYol(Gargamel2.getTileX(), Gargamel2.getTileY(),gs.getTileX(), gs.getTileY());}
                                 if(azmansayisi == 1){azman1.setX(azman1.getkordinatx(azman1.yol.get(1))); azman1.setY(azman1.getkordinaty(azman1.yol.get(1)));}
                         if(azmansayisi == 2){azman1.setX(azman1.getkordinatx(azman1.yol.get(1))); azman1.setY(azman1.getkordinaty(azman1.yol.get(1)));
                         azman2.setX(azman2.getkordinatx(azman2.yol.get(1))); azman2.setY(azman2.getkordinaty(azman2.yol.get(1)));}
                                if(gargamelsayisi == 1){Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(1))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(1)));
                try{Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(2))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(2)));}catch(Exception x){}       }
                         if(gargamelsayisi == 2){Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(1))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(1)));
                try{Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(2))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(2)));}catch(Exception x){}
                         Gargamel2.setX(Gargamel2.getkordinatx(Gargamel2.yol.get(1))); Gargamel2.setY(Gargamel2.getkordinaty(Gargamel2.yol.get(1)));
                try{Gargamel2.setX(Gargamel2.getkordinatx(Gargamel2.yol.get(2))); Gargamel2.setY(Gargamel2.getkordinaty(Gargamel2.yol.get(2)));}catch(Exception x){}}
                                }}}
			
			if(keycode==KeyEvent.VK_RIGHT){
				if(!m.getMap(gs.getTileX()+1, gs.getTileY()).equals("0")) {
				if(!m.getMap(gs.getTileX()+2, gs.getTileY()).equals("0")){key = 4;
                                gs.move(2,0);
                                
                                    if(azmansayisi == 1)
     { azman1.EnKisaYol(azman1.getTileX(), azman1.getTileY(),gs.getTileX(), gs.getTileY());}
     if(azmansayisi == 2){
     azman1.EnKisaYol(azman1.getTileX(), azman1.getTileY(),gs.getTileX(), gs.getTileY());
     azman2.EnKisaYol(azman2.getTileX(), azman2.getTileY(),gs.getTileX(), gs.getTileY());}
               
      
     if(gargamelsayisi == 1)
     { Gargamel1.EnKisaYol(Gargamel1.getTileX(), Gargamel1.getTileY(),gs.getTileX(), gs.getTileY());}
     if(gargamelsayisi == 2){
     Gargamel1.EnKisaYol(Gargamel1.getTileX(), Gargamel1.getTileY(),gs.getTileX(), gs.getTileY());
     Gargamel2.EnKisaYol(Gargamel2.getTileX(), Gargamel2.getTileY(),gs.getTileX(), gs.getTileY());}
                                 if(azmansayisi == 1){azman1.setX(azman1.getkordinatx(azman1.yol.get(1))); azman1.setY(azman1.getkordinaty(azman1.yol.get(1)));}
                         if(azmansayisi == 2){azman1.setX(azman1.getkordinatx(azman1.yol.get(1))); azman1.setY(azman1.getkordinaty(azman1.yol.get(1)));
                         azman2.setX(azman2.getkordinatx(azman2.yol.get(1))); azman2.setY(azman2.getkordinaty(azman2.yol.get(1)));}
                                if(gargamelsayisi == 1){Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(1))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(1)));
                try{Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(2))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(2)));}catch(Exception x){}       }
                         if(gargamelsayisi == 2){Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(1))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(1)));
                try{Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(2))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(2)));}catch(Exception x){}
                         Gargamel2.setX(Gargamel2.getkordinatx(Gargamel2.yol.get(1))); Gargamel2.setY(Gargamel2.getkordinaty(Gargamel2.yol.get(1)));
                try{Gargamel2.setX(Gargamel2.getkordinatx(Gargamel2.yol.get(2))); Gargamel2.setY(Gargamel2.getkordinaty(Gargamel2.yol.get(2)));}catch(Exception x){}}
                                }}}
			}
                        
                        
      /////////////////////////////////////////////
                        
                        
                if(ID==1){
                         if(keycode==KeyEvent.VK_UP){
				if(!m.getMap(ts.getTileX(), ts.getTileY()-1).equals("0")) {
				ts.move(0,-1);
                                
                                if(azmansayisi == 1)
     { azman1.EnKisaYol(azman1.getTileX(), azman1.getTileY(),ts.getTileX(), ts.getTileY());}
     if(azmansayisi == 2){
     azman1.EnKisaYol(azman1.getTileX(), azman1.getTileY(),ts.getTileX(), ts.getTileY());
     azman2.EnKisaYol(azman2.getTileX(), azman2.getTileY(),ts.getTileX(), ts.getTileY());}
                                
      
     if(gargamelsayisi == 1)
     { Gargamel1.EnKisaYol(Gargamel1.getTileX(), Gargamel1.getTileY(),ts.getTileX(), ts.getTileY());}
     if(gargamelsayisi == 2){
     Gargamel1.EnKisaYol(Gargamel1.getTileX(), Gargamel1.getTileY(),ts.getTileX(), ts.getTileY());
     Gargamel2.EnKisaYol(Gargamel2.getTileX(), Gargamel2.getTileY(),ts.getTileX(), ts.getTileY());}
     
                                if(azmansayisi == 1){azman1.setX(azman1.getkordinatx(azman1.yol.get(1))); azman1.setY(azman1.getkordinaty(azman1.yol.get(1)));}
                         if(azmansayisi == 2){azman1.setX(azman1.getkordinatx(azman1.yol.get(1))); azman1.setY(azman1.getkordinaty(azman1.yol.get(1)));
                         azman2.setX(azman2.getkordinatx(azman2.yol.get(1))); azman2.setY(azman2.getkordinaty(azman2.yol.get(1)));}
                                
                                if(gargamelsayisi == 1){Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(1))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(1)));
                try{Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(2))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(2)));}catch(Exception x){}       }
                         if(gargamelsayisi == 2){Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(1))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(1)));
                try{Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(2))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(2)));}catch(Exception x){}
                         Gargamel2.setX(Gargamel2.getkordinatx(Gargamel2.yol.get(1))); Gargamel2.setY(Gargamel2.getkordinaty(Gargamel2.yol.get(1)));
                try{Gargamel2.setX(Gargamel2.getkordinatx(Gargamel2.yol.get(2))); Gargamel2.setY(Gargamel2.getkordinaty(Gargamel2.yol.get(2)));}catch(Exception x){}}
                                } }
			
			if(keycode==KeyEvent.VK_LEFT){
				if(!m.getMap(ts.getTileX()-1, ts.getTileY()).equals("0")) {
				ts.move(-1,0);
                                
                                if(azmansayisi == 1)
     { azman1.EnKisaYol(azman1.getTileX(), azman1.getTileY(),ts.getTileX(), ts.getTileY());}
     if(azmansayisi == 2){
     azman1.EnKisaYol(azman1.getTileX(), azman1.getTileY(),ts.getTileX(), ts.getTileY());
     azman2.EnKisaYol(azman2.getTileX(), azman2.getTileY(),ts.getTileX(), ts.getTileY());}
     
      if(gargamelsayisi == 1)
     { Gargamel1.EnKisaYol(Gargamel1.getTileX(), Gargamel1.getTileY(),ts.getTileX(), ts.getTileY());}
     if(gargamelsayisi == 2){
     Gargamel1.EnKisaYol(Gargamel1.getTileX(), Gargamel1.getTileY(),ts.getTileX(), ts.getTileY());
     Gargamel2.EnKisaYol(Gargamel2.getTileX(), Gargamel2.getTileY(),ts.getTileX(), ts.getTileY());}
                                
                                 if(azmansayisi == 1){azman1.setX(azman1.getkordinatx(azman1.yol.get(1))); azman1.setY(azman1.getkordinaty(azman1.yol.get(1)));}
                         if(azmansayisi == 2){azman1.setX(azman1.getkordinatx(azman1.yol.get(1))); azman1.setY(azman1.getkordinaty(azman1.yol.get(1)));
                         azman2.setX(azman2.getkordinatx(azman2.yol.get(1))); azman2.setY(azman2.getkordinaty(azman2.yol.get(1)));}
                                
                                if(gargamelsayisi == 1){Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(1))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(1)));
                try{Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(2))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(2)));}catch(Exception x){}       }
                         if(gargamelsayisi == 2){Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(1))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(1)));
                try{Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(2))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(2)));}catch(Exception x){}
                         Gargamel2.setX(Gargamel2.getkordinatx(Gargamel2.yol.get(1))); Gargamel2.setY(Gargamel2.getkordinaty(Gargamel2.yol.get(1)));
                try{Gargamel2.setX(Gargamel2.getkordinatx(Gargamel2.yol.get(2))); Gargamel2.setY(Gargamel2.getkordinaty(Gargamel2.yol.get(2)));}catch(Exception x){}}
                                }}
			
			if(keycode==KeyEvent.VK_DOWN){
				if(!m.getMap(ts.getTileX(), ts.getTileY()+1).equals("0")){
				ts.move(0,1);
                                
                                if(azmansayisi == 1)
     { azman1.EnKisaYol(azman1.getTileX(), azman1.getTileY(),ts.getTileX(), ts.getTileY());}
     if(azmansayisi == 2){
     azman1.EnKisaYol(azman1.getTileX(), azman1.getTileY(),ts.getTileX(), ts.getTileY());
     azman2.EnKisaYol(azman2.getTileX(), azman2.getTileY(),ts.getTileX(), ts.getTileY());}
     
      if(gargamelsayisi == 1)
     { Gargamel1.EnKisaYol(Gargamel1.getTileX(), Gargamel1.getTileY(),ts.getTileX(), ts.getTileY());}
     if(gargamelsayisi == 2){
     Gargamel1.EnKisaYol(Gargamel1.getTileX(), Gargamel1.getTileY(),ts.getTileX(), ts.getTileY());
     Gargamel2.EnKisaYol(Gargamel2.getTileX(), Gargamel2.getTileY(),ts.getTileX(), ts.getTileY());}
                                
                                 if(azmansayisi == 1){azman1.setX(azman1.getkordinatx(azman1.yol.get(1))); azman1.setY(azman1.getkordinaty(azman1.yol.get(1)));}
                         if(azmansayisi == 2){azman1.setX(azman1.getkordinatx(azman1.yol.get(1))); azman1.setY(azman1.getkordinaty(azman1.yol.get(1)));
                         azman2.setX(azman2.getkordinatx(azman2.yol.get(1))); azman2.setY(azman2.getkordinaty(azman2.yol.get(1)));}
                         
                                if(gargamelsayisi == 1){Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(1))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(1)));
                try{Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(2))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(2)));}catch(Exception x){}       }
                         if(gargamelsayisi == 2){Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(1))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(1)));
                try{Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(2))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(2)));}catch(Exception x){}
                         Gargamel2.setX(Gargamel2.getkordinatx(Gargamel2.yol.get(1))); Gargamel2.setY(Gargamel2.getkordinaty(Gargamel2.yol.get(1)));
                try{Gargamel2.setX(Gargamel2.getkordinatx(Gargamel2.yol.get(2))); Gargamel2.setY(Gargamel2.getkordinaty(Gargamel2.yol.get(2)));}catch(Exception x){}}
                                }}
			
			if(keycode==KeyEvent.VK_RIGHT){
				if(!m.getMap(ts.getTileX()+1, ts.getTileY()).equals("0")) {
				ts.move(1,0);
                                
                                if(azmansayisi == 1)
     { azman1.EnKisaYol(azman1.getTileX(), azman1.getTileY(),ts.getTileX(), ts.getTileY());}
     if(azmansayisi == 2){
     azman1.EnKisaYol(azman1.getTileX(), azman1.getTileY(),ts.getTileX(), ts.getTileY());
     azman2.EnKisaYol(azman2.getTileX(), azman2.getTileY(),ts.getTileX(), ts.getTileY());}
     
      if(gargamelsayisi == 1)
     { Gargamel1.EnKisaYol(Gargamel1.getTileX(), Gargamel1.getTileY(),ts.getTileX(), ts.getTileY());}
     if(gargamelsayisi == 2){
     Gargamel1.EnKisaYol(Gargamel1.getTileX(), Gargamel1.getTileY(),ts.getTileX(), ts.getTileY());
     Gargamel2.EnKisaYol(Gargamel2.getTileX(), Gargamel2.getTileY(),ts.getTileX(), ts.getTileY());}
                                
                                
                                 if(azmansayisi == 1){azman1.setX(azman1.getkordinatx(azman1.yol.get(1))); azman1.setY(azman1.getkordinaty(azman1.yol.get(1)));}
                         if(azmansayisi == 2){azman1.setX(azman1.getkordinatx(azman1.yol.get(1))); azman1.setY(azman1.getkordinaty(azman1.yol.get(1)));
                         azman2.setX(azman2.getkordinatx(azman2.yol.get(1))); azman2.setY(azman2.getkordinaty(azman2.yol.get(1)));}
                         
                                if(gargamelsayisi == 1){Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(1))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(1)));
                try{Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(2))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(2)));}catch(Exception x){}       }
                         if(gargamelsayisi == 2){Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(1))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(1)));
                try{Gargamel1.setX(Gargamel1.getkordinatx(Gargamel1.yol.get(2))); Gargamel1.setY(Gargamel1.getkordinaty(Gargamel1.yol.get(2)));}catch(Exception x){}
                         Gargamel2.setX(Gargamel2.getkordinatx(Gargamel2.yol.get(1))); Gargamel2.setY(Gargamel2.getkordinaty(Gargamel2.yol.get(1)));
                try{Gargamel2.setX(Gargamel2.getkordinatx(Gargamel2.yol.get(2))); Gargamel2.setY(Gargamel2.getkordinaty(Gargamel2.yol.get(2)));}catch(Exception x){}}
                                }}
                        }
                }
                        
            
		
		public void keyReleased(KeyEvent e){}
		public void keyTyped(KeyEvent e){}

		}
   
   private void mantardisappear_clock(){
   
    Timer timerr = new Timer( mantar.getExist_time()*1000, e -> {
             mantardisappear = true;
             daha_yeme = false;
             sure_mantar =  mantar.getAppear_time()-mantar.getExist_time();
              
  } );
    
  timerr.setRepeats( false );
      timerr.start();
   
   }
   
   private void altindisappear_clock(){
   
    Timer timerr = new Timer( altin1.getExist_time()*1000, e -> {
            altindisappear = true;
              daha_yeme_altin1 = false;
              daha_yeme_altin2 = false;
              daha_yeme_altin3 = false;
              daha_yeme_altin4 = false;
              daha_yeme_altin5 = false;
              sure_altin = altin1.getAppear_time()-altin1.getExist_time();
  } );
    
  timerr.setRepeats( false );
      timerr.start();
   
   }
   
  
   
   

    
}
