
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


public class GUI extends JFrame {
    Container c = getContentPane(); 
    JPanel cover = new JPanel();
    ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
    Icon icon;
    JTextArea statusArea;
    Random rand = new Random();
    JTextArea stat,hp;
    Font largeFont = new Font("Lucida Handwriting",Font.BOLD,50); // Font
    Font NormalFont = new Font("Lucida Handwriting",Font.BOLD,27);
    Font SmallFont = new Font("Lucida Handwriting",Font.BOLD,20);
  
    
    public GUI (){
        
        super("Pokemon"); 
        pokemons.add(new Pikachu());
        pokemons.add(new Bulbasaur());
        pokemons.add(new Squirtle());
        
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(1700,800);
        cover.setLayout(new BorderLayout());
        setVisible(true);
    }
    
    public void mainWindow(){
        
        JLabel label = new JLabel();
        Icon pic =  new ImageIcon(getClass().getResource("download.png"));
        label.setIcon(pic);
        
        JButton sButton = new JButton("START"); //Create Start and Quit button.
        JButton qButton = new JButton("QUIT"); 
        
        sButton.setBackground(Color.black); //set Background and Foreground color for Start button.
        sButton.setForeground(Color.white); 
        
        qButton.setBackground(Color.black); //set Background and Foreground color for Quit button.
        qButton.setForeground(Color.white); 
        
        JPanel panel = new JPanel();        //set panel for Start and Quit Button.
        panel.setLayout(new FlowLayout());
        panel.add(sButton);
        panel.add(qButton);
        
        cover.add(label,BorderLayout.CENTER); //set position in panel for Start and Quit Button.
        cover.add(panel,BorderLayout.SOUTH);
        
        c.add(cover);
        
        sButton.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e) { 
                cover.remove(label); // remove label
                cover.remove(panel); // remove panel 
                chooseWindow();		 // call chooseWindow 
            }
        });
        
         
          qButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();     //remove screen
                
            }
        });
        pack();
        setVisible(true);
   
    }
    
    
    public void chooseWindow(){
        
        JLabel label = new JLabel("Choose your Partner",JLabel.CENTER);
        JPanel top   = new JPanel();
        top.add(label);
        label.setFont(largeFont);
        label.setForeground(Color.black);

        
        Icon poke1 =  new ImageIcon(getClass().getResource("pokemon01.jpg"));     //add Picture for choose button.
        Icon poke11 =  new ImageIcon(getClass().getResource("pokemon02.jpg"));
        Icon poke2 =  new ImageIcon(getClass().getResource("Bulbasaur.jpg"));
        Icon poke22 =  new ImageIcon(getClass().getResource("Bulbasaur01.jpg"));
        Icon poke3 =  new ImageIcon(getClass().getResource("squirtle01.jpg"));
        Icon poke33 =  new ImageIcon(getClass().getResource("squirtle02.jpg"));
        
        JButton p1Button = new JButton(poke1); // Button for choose you pokemon.
        p1Button.setIcon(poke1);
        p1Button.setRolloverIcon(poke11);
        JButton p2Button = new JButton(poke2);
        p2Button.setIcon(poke2);
        p2Button.setRolloverIcon(poke22);
        JButton p3Button = new JButton(poke3);
        p3Button.setIcon(poke3);
        p3Button.setRolloverIcon(poke33);
        
        JPanel panel1 = new JPanel(); // set position for choose pokemon button.
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel bigpanel = new JPanel();
        bigpanel.setLayout(new FlowLayout());
        
        panel1.add(p1Button); // add button in panel.
        panel2.add(p2Button);
        panel3.add(p3Button);
        bigpanel.add(panel1); //then add all panel in a single panel.
        bigpanel.add(panel2);
        bigpanel.add(panel3);
        
        label.setBorder(new TitledBorder("New Game"));
        
        p1Button.addActionListener(new ActionListener() { //pikachu
            @Override
            public void actionPerformed(ActionEvent e) {	//remove and get to pikachu's profile.
                cover.remove(label);    
                cover.remove(bigpanel);
                pokeProfile(0);
                
            }
        });
        
         p2Button.addActionListener(new ActionListener() { //Bulbasaur
            @Override
            public void actionPerformed(ActionEvent e) {
                cover.remove(label);						
                cover.remove(bigpanel);
                pokeProfile(1);								//get to bulbasaur's profile.
                
            }
        });
         
          p3Button.addActionListener(new ActionListener() { //Squirtle
            @Override
            public void actionPerformed(ActionEvent e) {
                cover.remove(label);
                cover.remove(bigpanel);
                pokeProfile(2);								//get to squirtle's profile.
            }
        });
        
        cover.add(label,BorderLayout.NORTH);
        cover.add(bigpanel,BorderLayout.WEST);
        c.add(cover);
        
        setVisible(true);
        pack();
        
        
    }
       
    public void pokeProfile(int i){
        
            JLabel label = new JLabel("Please Enter your Pokemon name.",JLabel.CENTER);
            label.setFont(largeFont);
            label.setForeground(Color.BLUE);
            
            JLabel imglabel = new JLabel("",JLabel.CENTER);
            Icon poke =  new ImageIcon(getClass().getResource("Pika.png"));
            Icon poke1 =  new ImageIcon(getClass().getResource("Bulbasaur02-1.png"));
            Icon poke2 =  new ImageIcon(getClass().getResource("squritle03-1.png"));
            
            if(i==0)imglabel.setIcon(poke);
            if(i==1) imglabel.setIcon(poke1);
            if(i==2) imglabel.setIcon(poke2);
            
            JLabel name = new JLabel("NAME : ");
            JTextField insert = new JTextField(20);
            insert.setFont(NormalFont);
            name.setFont(NormalFont);
            
            JButton sButton = new JButton("Get Start!!!");
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());
            sButton.setFont(NormalFont);
            sButton.setBackground(Color.green);
            
            panel.add(name);
            panel.add(insert);
            panel.add(sButton);
            
            sButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                cover.remove(label);
                cover.remove(imglabel);
                cover.remove(panel);
                if(i==0){
                    pokemons.get(0).setName(insert.getText());
                    gameWindow(0,poke);
                }
                if(i==1){
                    pokemons.get(1).setName(insert.getText());
                    gameWindow(1,poke1);
                }
                if(i==2){
                    pokemons.get(2).setName(insert.getText());
                    gameWindow(2,poke2);
                }
                
            
        
            }
        });
            
            cover.add(label,BorderLayout.NORTH);
            cover.add(imglabel,BorderLayout.CENTER);
            cover.add(panel,BorderLayout.SOUTH);
            c.add(cover);
            
            setVisible(true);
           
    }
    
    public void gameWindow(int i,Icon icon){
        
        this.icon = icon;
        
        JButton eButton = new JButton("EAT");
        JButton exButton = new JButton("EXERCISE");
        JButton fButton = new JButton("FIGHT!!");
        JPanel btpanel = new JPanel();
        btpanel.setLayout(new FlowLayout());
        
        eButton.setFont(NormalFont);
        eButton.setBackground(Color.green);
        eButton.setForeground(Color.white);
        
        exButton.setFont(NormalFont);
        exButton.setBackground(Color.green);
        exButton.setForeground(Color.white);
        
        fButton.setFont(NormalFont);
        fButton.setBackground(Color.red);
        fButton.setForeground(Color.white);
        
        btpanel.add(eButton);
        btpanel.add(exButton);
        btpanel.add(fButton);
        btpanel.setBorder(new TitledBorder("Choose your option!!!"));
        btpanel.setFont(NormalFont);
        
        
        statusArea = new JTextArea(5,17);
        statusArea.setFont(NormalFont);
        statusArea.setBackground(Color.DARK_GRAY);
        statusArea.setForeground(Color.white);
        
        JLabel nickname = new JLabel("NICKNAME: ");
        nickname.setFont(NormalFont);
                
        JLabel img = new JLabel();
        img.setIcon(icon);
        
        JTextArea name = new JTextArea(1,15);
        name.setEditable(false);
        name.setFont(NormalFont);
        JPanel panel = new JPanel();
        
        panel.add(nickname);
        panel.add(name);
        
        JPanel txpanel = new JPanel();
        txpanel.setLayout(new BoxLayout(txpanel,BoxLayout.Y_AXIS));
        txpanel.add(img);
        txpanel.add(panel);
        
        JPanel cover2 = new JPanel();
        cover2.setLayout(new FlowLayout());
        
      
         statusArea.setText(print(pokemons,i));
         name.setText(pokemons.get(i).getName());
       
         eButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                Eat(i);
            }
        });
         
         exButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                Exercise(i);
            }
        });
         
         
         fButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                cover.remove(btpanel);
                cover.remove(cover2);
            
                fightWindow(i,icon);
            }
        });
         
        cover2.add(statusArea);
        cover2.add(txpanel);
        cover.add(btpanel,BorderLayout.NORTH);
        cover.add(cover2,BorderLayout.CENTER);
        c.add(cover);
        
        pack();
        setVisible(true);
        
     
    }
    
    
    public void fightWindow(int i,Icon icon){
        
        JLabel label = new JLabel("",JLabel.CENTER);
        label.setFont(largeFont);
        label.setForeground(Color.RED);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        
        stat = new JTextArea(1,20);
        hp = new JTextArea(1,8);
        
        stat.setBackground(Color.LIGHT_GRAY);
        stat.setForeground(Color.black);
        stat.setFont(NormalFont);
        stat.setEditable(false);
        
        hp.setBackground(Color.red);
        hp.setForeground(Color.white);
        hp.setEditable(false);
        hp.setFont(NormalFont);
        
        Icon Mpoke =  new ImageIcon(getClass().getResource("Mpoke.png"));
        JLabel Mpoke1=new JLabel(Mpoke);
        
        Icon vs =  new ImageIcon(getClass().getResource("vs.png"));
        JLabel vs1 = new JLabel(vs);
        
        JLabel img = new JLabel();
        img.setIcon(icon);
        
        JButton atkButton = new JButton("ATTACK");
        JButton backButton = new JButton("BACK");
        
        atkButton.setFont(NormalFont);
        backButton.setFont(NormalFont);
        
        panel1.add(img);
        panel1.add(vs1);
        panel1.add(Mpoke1);
        
        panel2.add(hp);
        panel2.add(stat);
        panel2.add(atkButton);
        panel2.add(backButton);
        
        
         atkButton.addActionListener(new ActionListener() { //atk
            @Override
            public void actionPerformed(ActionEvent e) {
                Attack (i);
                if(pokemons.get(i).health == 0){
                  cover.remove(label);  
                  cover.remove(panel1);
                  cover.remove(panel2);
                  deadWindow();
                }
            }
        });
         
         backButton.addActionListener(new ActionListener() { //back
            @Override
            public void actionPerformed(ActionEvent e) {
                cover.remove(panel1);
                cover.remove(panel2);
                gameWindow(i,icon);
               
            }
        });
         
        cover.add(label,BorderLayout.NORTH);
        cover.add(panel1,BorderLayout.CENTER);
        cover.add(panel2,BorderLayout.SOUTH);
        c.add(cover);
        pack();
        setVisible(true);   
    }
    
    public void Attack (int index){
        int random = rand.nextInt(2);
        
        if(random == 0){
            pokemons.get(index).setExp(rand.nextInt(10));
            stat.setText("YOU WIN !!");
            hp.setText("Health : "+pokemons.get(index).getHealth());           
        } 
        if(random == 1){
            stat.setText("YOU LOSE !! Your Pokemon is injured. ");
            pokemons.get(index).reducedHealth(rand.nextInt(30));
            hp.setText("Health : "+pokemons.get(index).getHealth());
   
        }
    }
    
    public void Exercise(int index){
        pokemons.get(index).setExp(rand.nextInt(3));
        pokemons.get(index).reducedWeight(rand.nextInt(10));
        statusArea.setText(print(pokemons,index));
    }
    
    public void Eat(int index){
        Foods berry = new Foods(1);
        pokemons.get(index).eat(berry);
        statusArea.setText(print(pokemons,index));
        
    }
   
    public String print(ArrayList<Pokemon> pokemons,int index){    
        String hp = " ======== Pokemon ======== \n"+"  Health: "+pokemons.get(index).getHealth()+"/"+pokemons.get(index).maxHealth;
        String weight = "\n  Weight: "+pokemons.get(index).getWeight()+"/100.0"; 
        String exp = "\n  Exp: "+pokemons.get(index).getExp()+"/999"; 
        return hp+weight+exp;
    }
    
    public void deadWindow(){
        Font large = new Font("TimesRoman",Font.BOLD,50);
        Font btlarge = new Font("TimesRoman",Font.BOLD,20);
        JLabel text = new JLabel(" Your Pokemon dies ",JLabel.CENTER);
        text.setFont(large);
        text.setForeground(Color.RED);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel group = new JPanel();
        
        JButton bt = new JButton("Back to Main Menu");
        JButton exit = new JButton("Quit");
        
        bt.setFont(btlarge);
        exit.setFont(btlarge);
        
        panel1.add(bt);
        panel2.add(exit);
        
        group.add(panel1);
        group.add(panel2);
        
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              cover.remove(text);
              cover.remove(group);
              chooseWindow();
            }
        });
        
        exit.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        		 dispose();
        		
        	}
        	
        });
        
        
        cover.add(text,BorderLayout.CENTER);
        cover.add(group,BorderLayout.SOUTH);
        
        c.add(cover);
        
        
        setVisible(true);
    }
    
    
}
        
        