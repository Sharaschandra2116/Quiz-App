package Level;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;
import java.sql.*;
public class Level{ 
    JFrame f_1=new JFrame("Level");
    JLabel l=new JLabel("!!!CHOOSE THE DIFFICULTY!!!");
    JButton d1=new JButton("Easy");
    JButton d2=new JButton("Medium");
    JButton d3=new JButton("Hard");
    JFrame f_2 = new JFrame();
    public static String name="";
    public static String email="";
    void Entry() throws SQLException {
        f_2.setTitle("Entry Form");
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter your username:");
        JTextField text = new JTextField(50);
        JLabel l2=new JLabel("Enter you Email: ");
        JTextField t2=new JTextField(50);
        JButton button = new JButton("Submit");
        panel.add(label);
        panel.add(text);
        panel.add(l2);
        panel.add(t2);
        panel.add(button);
        f_2.add(panel);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            name = text.getText();
            email = t2.getText();
            if (isValidEmail(email)) {
                JOptionPane.showMessageDialog(panel, "Welcome " + name+" !" , "Success", JOptionPane.INFORMATION_MESSAGE);
                f_2.setVisible(false);
                f_1.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(panel, "Invalid email address!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            }
        });
        f_2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f_2.setSize(1875, 1875);
        f_2.setVisible(true);
    }
    void Difficulty(){
        JPanel p=new JPanel();
        p.setBounds(100, 100, 750, 750);
        f_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f_1.setSize(750, 750);
        d1.setBounds(250,250,200,100);
        d1.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){ 
                buttons.ea=1;
                Easy easy= new Easy(); 
                        try {
                            
                            easy.Easy1();
                            easy.frame1.setVisible(true);
                            
                            f_1.setVisible(false);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                       
                    }  
                }); 
        d2.setBounds(250,350,200,100);
        d2.addActionListener(new ActionListener(){  
               public void actionPerformed(ActionEvent e){ 
                buttons.me=1;

                Medium m= new Medium();
                        try {
                            m.Medium1();
                            m.frame2.setVisible(true);
                            f_1.setVisible(false);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        
                    }  
                }); 
        d3.setBounds(250,450,200,100);
        d3.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                buttons.ha=1; 

                Difficult d= new Difficult();
                        try {
                            d.Difficult1();
                            d.frame3.setVisible(true);
                            f_1.setVisible(false);
                            
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }  
                        
                    }  
                }); 
        p.add(l);
        if(buttons.ea==0){
            p.add(d1);
        }
        if(buttons.me==0){
            p.add(d2);
        }
        if(buttons.ha==0){
            p.add(d3);
        }
        if(buttons.ea==1 && buttons.me==1 && buttons.ha==1){
            JOptionPane.showMessageDialog(p, "!!!Thanks for Attempting th Quiz!!!");
            p.setVisible(false);
            f_1.setVisible(false);
            
        }
        f_1.add(p);
    }
    public void previous(){
        Difficulty();
        f_1.setVisible(true);
    }
    public void exit(){
        f_1.setVisible(false);
    }
    private boolean isValidEmail(String email) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(emailPattern, email);
    }
    public static void main (String[] args) throws SQLException{
        Level level= new Level();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Level();
            }
        });
        level.Entry();
        level.Difficulty();
    }
}
class buttons{
    public static int ea=0;
    public static int me=0;
    public static int ha=0;

}
 class Easy implements ActionListener{
    static final String DB_URL="jdbc:mysql://localhost/quiz_project";
    static final String USER="root";
    static final String PASS="Chilli2116";    

     JFrame frame1 = new JFrame();
    String[] easyquestions = 	{
        "1.Which company created Java?",
        "2.Which year was Java created?",
        "3.What was Java originally called?",
        "4.Who is credited with creating Java?",
        "5.Which statement is true about Java?",
        "6.Which component is used to compile, debug and execute the java programs?",
        "7.Which one of the following is not a Java feature?",
        "8.Which of these cannot be used for a variable name in Java?",
        "9.What is the extension of java code files?",
        "10.Which of the following is not an OOPS concept in Java?"
    };
String[][] easyoptions = 	{
        {"Sun Microsystems","Starbucks","Microsoft","Alphabet"},
        {"1989","1996","1972","1492"},
        {"Apple","Latte","Oak","Koffing"},
        {"Steve Jobs","Bill Gates","James Gosling","Mark Zuckerburg"},
        {"Java is a sequence-dependent programming language"," Java is a code dependent programming language","Java is a platform-dependent programming language","Java is a platform-independent programming language"},
        {"JRE","JIT","JDK","JVM"},
        {"Object-oriented","Use of pointers","Portable","Dynamic and Extensible"},
        {"identifier & keyword","identifier","keyword","none of the mentioned"},
        {".js",".txt",".class",".java"},
        {"Polymorphism","Inheritance","Compilation","Encapsulation"}



    };
char[] easyanswers ={
        'A',
        'B',
        'C',
        'C',
        'D',
        'C',
        'B',
        'C',
        'D',
        'C'
    };
    char guess_1;
    char answer_1;
    int index_1;
    int correct_guesses_1=0;
    int total_questions_1=easyquestions.length;
    int result_1;
    int seconds_1=10;

    JButton button1 = new JButton("<Back");
    JTextField textField_1=new JTextField();
    JTextArea textArea_1=new JTextArea();
    JButton b1=new JButton();
    JButton b2=new JButton();
    JButton b3=new JButton();
    JButton b4=new JButton();

    JLabel answer11=new JLabel();
    JLabel answer21=new JLabel();
    JLabel answer31=new JLabel();
    JLabel answer41=new JLabel();

    JLabel time_label_1 = new JLabel();
    JLabel sec_1 = new JLabel();
    JTextField num_rgt_1=new JFormattedTextField();
    JTextField res_1=new JTextField();
    Timer timer_1 = new Timer(1000, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			seconds_1--;
			sec_1.setText(String.valueOf(seconds_1));
			if(seconds_1<=0) {
				display1();
			}
			}
		});
	
    public void  Easy1() throws SQLException
    {
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(1000, 1000);
        frame1.getContentPane();
        frame1.setLayout(null);
        frame1.setResizable(false);
        
        textField_1.setBounds(0,0,1000,50);
        textField_1.setFont(new Font("Arial",Font.BOLD,30));
        textField_1.setBorder(BorderFactory.createBevelBorder(1));
        textField_1.setEditable(false);
        
        textArea_1.setBounds(0,50,1000,75);
        textArea_1.setLineWrap(true);
        textArea_1.setWrapStyleWord(true);
        textArea_1.setFont(new Font("Arial",Font.BOLD,30)); 
        textArea_1.setBorder(BorderFactory.createBevelBorder(1));
        textArea_1.setEditable(false);

        b1.setBounds(0,150,100,50);
        b1.setFont(new Font("Arial",Font.BOLD,35));
        b1.setFocusable(false);
        b1.addActionListener(this);
        b1.setText("A");
        b2.setBounds(0,250,100,50);
        b2.setFont(new Font("Arial",Font.BOLD,35));
        b2.setFocusable(false);
        b2.addActionListener(this);
        b2.setText("B");

        b3.setBounds(0,350,100,50);
        b3.setFont(new Font("Arial",Font.BOLD,35));
        b3.setFocusable(false);
        b3.addActionListener(this);
        b3.setText("C");
        b4.setBounds(0,450,100,50);
        b4.setFont(new Font("Arial",Font.BOLD,35));
        b4.setFocusable(false);
        b4.addActionListener(this);
        b4.setText("D");
        answer11.setBounds(125,125,750,100);
        answer11.setFont(new Font("Arial",Font.BOLD,25));
        answer21.setBounds(125,225,750,100);
        answer21.setFont(new Font("Arial",Font.BOLD,25));
        answer31.setBounds(125,325,750,100);
        answer31.setFont(new Font("Arial",Font.BOLD,25));
        answer41.setBounds(125,425,750,100);
        answer41.setFont(new Font("Arial",Font.BOLD,25));
        sec_1.setBounds(650,650,50,25);
		sec_1.setFont(new Font("Arial",Font.BOLD,25));
		sec_1.setBorder(BorderFactory.createBevelBorder(1));
		sec_1.setOpaque(true);
		sec_1.setHorizontalAlignment(JTextField.CENTER);
		sec_1.setText(String.valueOf(seconds_1));
		time_label_1.setBounds(650,650,50,25);
		time_label_1.setFont(new Font("Arial",Font.PLAIN,16));
		time_label_1.setHorizontalAlignment(JTextField.CENTER);
		time_label_1.setText("timer");
        num_rgt_1.setBounds(250,250,200,100);
        num_rgt_1.setFont(new Font("Arial",Font.BOLD,25));
        num_rgt_1.setBorder(BorderFactory.createBevelBorder(1));
        num_rgt_1.setEditable(false);
        res_1.setBounds(250,350,200,100);
        res_1.setFont(new Font("Arial",Font.BOLD,25));
        res_1.setBorder(BorderFactory.createBevelBorder(1));
        res_1.setEditable(false);
        frame1.add(time_label_1);
        frame1.add(sec_1);
        frame1.add(answer11);
        frame1.add(answer21);
        frame1.add(answer31);
        frame1.add(answer41);
        frame1.add(b1);
        frame1.add(b2);
        frame1.add(b3);
        frame1.add(b4);
        frame1.add(textArea_1);
        frame1.add(textField_1);
        EasynxtQuestion();
    }
    public void EasynxtQuestion() throws SQLException{
        if(index_1>=total_questions_1){
            results_1();
        }
        else
        {
            textField_1.setText("Question: "+(index_1+1));
            textArea_1.setText(easyquestions[index_1]);
            answer11.setText(easyoptions[index_1][0]);
            answer21.setText(easyoptions[index_1][1]);
            answer31.setText(easyoptions[index_1][2]);
            answer41.setText(easyoptions[index_1][3]);
            timer_1.start();
        }
    }
    public void actionPerformed(ActionEvent e){
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        if(e.getSource()==b1){
            answer_1='A';
            if(answer_1==easyanswers[index_1]){
                correct_guesses_1++;
            }
        }
        if(e.getSource()==b2){
            answer_1='B';
            if(answer_1==easyanswers[index_1]){
                correct_guesses_1++;
            }
        }
        if(e.getSource()==b3){
            answer_1='C';
            if(answer_1==easyanswers[index_1]){
                correct_guesses_1++;
            }
        }
        if(e.getSource()==b4){
            answer_1='D';
            if(answer_1==easyanswers[index_1]){
                correct_guesses_1++;
            }
        }
        display1();
    }
    public void display1(){
        timer_1.stop();
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        if(easyanswers[index_1]!='A'){
            answer11.setForeground(new Color(255,0,0));
        }
        if(easyanswers[index_1]!='B'){
            answer21.setForeground(new Color(255,0,0));
        }
        if(easyanswers[index_1]!='C'){
            answer31.setForeground(new Color(255,0,0));
        }
        if(easyanswers[index_1]!='D'){
            answer41.setForeground(new Color(255,0,0));
        }   
        Timer pause1 = new Timer(2000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer11.setForeground(new Color(25,255,0));
				answer21.setForeground(new Color(25,255,0));
				answer31.setForeground(new Color(25,255,0));
				answer41.setForeground(new Color(25,255,0));
				answer_1 = ' ';
				seconds_1=10;
				sec_1.setText(String.valueOf(seconds_1));
				b1.setEnabled(true);
				b2.setEnabled(true);
				b3.setEnabled(true);
				b4.setEnabled(true);
				index_1++;
				try {
                    EasynxtQuestion();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
			}
		});
        pause1.setRepeats(false);
        pause1.start();
    }
    public void results_1() throws SQLException{
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        JFrame f21=new JFrame("Results");
        
        button1.setBounds(25,650,75,75);//back
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Level obj=new Level();
                obj.previous();
                f21.setVisible(false);
            }
        });
        JButton button2 = new JButton("Exit>");
        button2.setBounds(650,650,75,75);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Level obj=new Level();
                obj.exit();
                f21.setVisible(false);
            }
        });
        result_1=(int)((correct_guesses_1/(double)total_questions_1)*100);
        textField_1.setText("RESULTS!");
        textArea_1.setText("");
        answer11.setText("");
        answer21.setText("");
        answer31.setText("");
        answer41.setText("");
        num_rgt_1.setText("("+correct_guesses_1+"/"+total_questions_1+")");
        Connection conn =DriverManager.getConnection(DB_URL,USER,PASS);
        PreparedStatement stmt1=conn.prepareStatement("select * from quiz where name=? and email=?");
        stmt1.setString(1,Level.name);
        stmt1.setString(2,Level.email);
        ResultSet rs=stmt1.executeQuery();
        String name1="";
        String email1="";
        int hard_marks1=0;
        int med_marks1=0;
        if(rs.next()){
            name1=rs.getString("name");
            email1=rs.getString("email");
            med_marks1=rs.getInt("med_results");
            hard_marks1=rs.getInt("hard_results");
        if(Level.name.equals(name1) && Level.email.equals(email1)){
            PreparedStatement stmt=conn.prepareStatement("update quiz set easy_results=?,med_results=?,hard_results=? where name=? and email=?");
            stmt.setInt(1,result_1/10);
            stmt.setInt(2,med_marks1);
            stmt.setInt(3,hard_marks1);
            stmt.setString(4,Level.name);
            stmt.setString(5,Level.email);
            int rs2=stmt.executeUpdate();
            if(rs2>0){
                System.out.println("e inserted");
            }
            else{
                System.out.println("e not inserted");
            }
        }
    }
        else{
        PreparedStatement stmt=conn.prepareStatement("insert into quiz values(?,?,?,?,?)");
        stmt.setString(1,Level.name);
        stmt.setString(2,Level.email);
        stmt.setInt(3,result_1/10);     
        stmt.setInt(4,med_marks1);
        stmt.setInt(5,hard_marks1);
        int rs1=stmt.executeUpdate();
        if(rs1>0){
            System.out.println("n inserted");
        }
        else{
            System.out.println("n not inserted");
        }
        }
        res_1.setText(result_1+"%");     
        f21.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f21.setSize(750, 750);
        f21.getContentPane();
        f21.setLayout(null);
        f21.setResizable(false);
        f21.add(textField_1);
        f21.add(num_rgt_1);
        f21.add(res_1);
        f21.add(button1);
        f21.add(button2);
        f21.setVisible(true);
        frame1.setVisible(false);
    }
    }
 class Medium implements ActionListener{
    static final String DB_URL="jdbc:mysql://localhost/quiz_project";
    static final String USER="root";
    static final String PASS="Chilli2116";  
    String[] Mediumquestions = 	{
        "1.Number of primitive data types in Java are?",
        "2.Which of these keywords are used for the block to be examined for exceptions?",
        "3._ is used to find and fix bugs in the Java programs?",
        "4.What is the return type of the hashCode() method in the Object class?",
        "5.Which package contains the Random class?",
        "6.Which keyword is used for accessing the features of a package?",
        "7.In java, jar stands for___?",
        "8.How many threads can be executed at a time?",
        "9.If three threads trying to share a single object at the same time, which condition will arise in this scenario?",
        "10.What is meant by the classes and objects that dependents on each other?"
    };
String[][] Mediumoptions = 	{
        {"6","7","8","9"},
        {"check","throw","catch","try"},
        {"JVM","JRE","JDK","JDB"},
        {"Object","int","long","void"},
        {"java.util package","java.lang package","java.awt package","java.io package"},
        {"package","import","extends","export"},
        {"Java Archive Runner","Java Application Resource","Java Application Runner","None of the above"},
        {"Only one thread","Multiple threads","Two threads","none of the above"},
        {"Time-Lapse","Critical situation","Race condition","Recursion"},
        {"Tight Coupling","Cohesion","Loose Coupling","None of the above"}
    };
char[] Mediumanswers ={
        'C',
        'D',
        'D',
        'B',
        'A',
        'B',
        'D',
        'B',
        'C',
        'A'
    };
    char guess_2;
    char answer_2;
    int index_2;
    int correct_guesses_2=0;
    int total_questions_2=Mediumquestions.length;
    int result_2;
    int seconds_2=20;
    JButton button3 = new JButton("<Back");
    
    JFrame frame2 = new JFrame();
    
    JTextField textField_2=new JTextField();
    JTextArea textArea_2=new JTextArea();
    JButton a1=new JButton();
    JButton a2=new JButton();
    JButton a3=new JButton();
    JButton a4=new JButton();

    JLabel answer12=new JLabel();
    JLabel answer22=new JLabel();
    JLabel answer32=new JLabel();
    JLabel answer42=new JLabel();

    JLabel time_label_2 = new JLabel();
    JLabel sec_2 = new JLabel();

    JTextField num_rgt_2=new JFormattedTextField();
    JTextField res_2=new JTextField();

    Timer timer_2 = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds_2--;
			sec_2.setText(String.valueOf(seconds_2));
			if(seconds_2<=0) {
				display2();
			}
			}
		});
	
    public void Medium1() throws SQLException
    {
        

        
    
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(1000, 1000);
        frame2.getContentPane();
        frame2.setLayout(null);
        frame2.setResizable(false);

        textField_2.setBounds(0,0,1000,50);
        textField_2.setFont(new Font("Arial",Font.BOLD,30));
        textField_2.setBorder(BorderFactory.createBevelBorder(1));
        textField_2.setEditable(false);
        
        textArea_2.setBounds(0,50,1000,75);
        textArea_2.setLineWrap(true);
        textArea_2.setWrapStyleWord(true);
        textArea_2.setFont(new Font("Arial",Font.BOLD,30)); 
        textArea_2.setBorder(BorderFactory.createBevelBorder(1));
        textArea_2.setEditable(false);

        a1.setBounds(0,150,100,50);
        a1.setFont(new Font("Arial",Font.BOLD,35));
        a1.setFocusable(false);
        a1.addActionListener(this);
        a1.setText("A");

        a2.setBounds(0,250,100,50);
        a2.setFont(new Font("Arial",Font.BOLD,35));
        a2.setFocusable(false);
        a2.addActionListener(this);
        a2.setText("B");

        a3.setBounds(0,350,100,50);
        a3.setFont(new Font("Arial",Font.BOLD,35));
        a3.setFocusable(false);
        a3.addActionListener(this);
        a3.setText("C");


        a4.setBounds(0,450,100,50);
        a4.setFont(new Font("Arial",Font.BOLD,35));
        a4.setFocusable(false);
        a4.addActionListener(this);
        a4.setText("D");

        answer12.setBounds(125,125,750,100);
        answer12.setFont(new Font("Arial",Font.BOLD,25));

        answer22.setBounds(125,225,750,100);
        answer22.setFont(new Font("Arial",Font.BOLD,25));

        answer32.setBounds(125,325,750,100);
        answer32.setFont(new Font("Arial",Font.BOLD,25));

        answer42.setBounds(125,425,750,100);
        answer42.setFont(new Font("Arial",Font.BOLD,25));

        sec_2.setBounds(650,650,50,25);
		sec_2.setFont(new Font("Arial",Font.BOLD,25));
		sec_2.setBorder(BorderFactory.createBevelBorder(1));
		sec_2.setOpaque(true);
		sec_2.setHorizontalAlignment(JTextField.CENTER);
		sec_2.setText(String.valueOf(seconds_2));
		
		time_label_2.setBounds(650,650,50,25);
		time_label_2.setFont(new Font("Arial",Font.PLAIN,16));
		time_label_2.setHorizontalAlignment(JTextField.CENTER);
		time_label_2.setText("timer");


        num_rgt_2.setBounds(250,250,200,100);
        num_rgt_2.setFont(new Font("Arial",Font.BOLD,25));
        num_rgt_2.setBorder(BorderFactory.createBevelBorder(1));
        num_rgt_2.setEditable(false);

        res_2.setBounds(250,350,200,100);
        res_2.setFont(new Font("Arial",Font.BOLD,25));
        res_2.setBorder(BorderFactory.createBevelBorder(1));
        res_2.setEditable(false);

        frame2.add(time_label_2);
        frame2.add(sec_2);
        frame2.add(answer12);
        frame2.add(answer22);
        frame2.add(answer32);
        frame2.add(answer42);
        frame2.add(a1);
        frame2.add(a2);
        frame2.add(a3);
        frame2.add(a4);
        frame2.add(textArea_2);
        frame2.add(textField_2);
        MediumnxtQuestion();
    }
    public void MediumnxtQuestion() throws SQLException{
        if(index_2>=total_questions_2){
            results_2();
        }else{
            textField_2.setText("Question: "+(index_2+1));
            textArea_2.setText(Mediumquestions[index_2]);
            answer12.setText(Mediumoptions[index_2][0]);
            answer22.setText(Mediumoptions[index_2][1]);
            answer32.setText(Mediumoptions[index_2][2]);
            answer42.setText(Mediumoptions[index_2][3]);
            timer_2.start();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e){
        a1.setEnabled(false);
        a2.setEnabled(false);
        a3.setEnabled(false);
        a4.setEnabled(false);

        if(e.getSource()==a1){
            answer_2='A';
            if(answer_2==Mediumanswers[index_2]){
                correct_guesses_2++;
            }
        }
        if(e.getSource()==a2){
            answer_2='B';
            if(answer_2==Mediumanswers[index_2]){
                correct_guesses_2++;
            }
        }
        if(e.getSource()==a3){
            answer_2='C';
            if(answer_2==Mediumanswers[index_2]){
                correct_guesses_2++;
            }
        }
        if(e.getSource()==a4){
            answer_2='D';
            if(answer_2==Mediumanswers[index_2]){
                correct_guesses_2++;
            }
        }
        display2();
    }
    public void display2(){

        timer_2.stop();

        a1.setEnabled(false);
        a2.setEnabled(false);
        a3.setEnabled(false);
        a4.setEnabled(false);

        if(Mediumanswers[index_2]!='A'){
            answer12.setForeground(new Color(255,0,0));
        }
        if(Mediumanswers[index_2]!='B'){
            answer22.setForeground(new Color(255,0,0));
        }
        if(Mediumanswers[index_2]!='C'){
            answer32.setForeground(new Color(255,0,0));
        }
        if(Mediumanswers[index_2]!='D'){
            answer42.setForeground(new Color(255,0,0));
        }   
      
        Timer pause2 = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				answer12.setForeground(new Color(25,255,0));
				answer22.setForeground(new Color(25,255,0));
				answer32.setForeground(new Color(25,255,0));
				answer42.setForeground(new Color(25,255,0));
				
				answer_2 = ' ';
				seconds_2=20;
				sec_2.setText(String.valueOf(seconds_2));
				a1.setEnabled(true);
				a2.setEnabled(true);
				a3.setEnabled(true);
				a4.setEnabled(true);
				index_2++;
				try {
                    MediumnxtQuestion();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
			}
		});
        pause2.setRepeats(false);
        pause2.start();
        
    }
    public void results_2() throws SQLException{
        a1.setEnabled(false);
        a2.setEnabled(false);
        a3.setEnabled(false);
        a4.setEnabled(false);

        JFrame f22=new JFrame("Results");
        
        button3.setBounds(25,650,75,75);;
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Level obj=new Level();
                obj.previous();
                
                f22.setVisible(false);
            }
        });
        JButton button4 = new JButton("Exit>");
        button4.setBounds(650,650,75,75);;
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Level obj=new Level();
                obj.exit();
                
                f22.setVisible(false);
            }
        });

        result_2=(int)((correct_guesses_2/(double)total_questions_2)*100);
        
        textField_2.setText("RESULTS!");
        textArea_2.setText("");
        answer12.setText("");
        answer22.setText("");
        answer32.setText("");
        answer42.setText("");
        Connection conn =DriverManager.getConnection(DB_URL,USER,PASS);
        PreparedStatement stmt1=conn.prepareStatement("select * from quiz where name=? and email=?");
        stmt1.setString(1,Level.name);
        stmt1.setString(2,Level.email);
        ResultSet rs=stmt1.executeQuery();
        String name1="";
        String email1="";
        int easy_marks=0;
        int hard_marks=0;
        if(rs.next()){
            name1=rs.getString("name");
        email1=rs.getString("email");
        easy_marks=rs.getInt("easy_results");
        hard_marks=rs.getInt("hard_results");
        if(Level.name.equals(name1) && Level.email.equals(email1)){
            PreparedStatement stmt2=conn.prepareStatement("update quiz set easy_results=?,med_results=?,hard_results=? where name=? and email=?");
            stmt2.setInt(1,easy_marks);
            stmt2.setInt(2,result_2/10);
            stmt2.setInt(3,hard_marks);
            stmt2.setString(4,Level.name);
            stmt2.setString(5,Level.email);
            int rs1=stmt2.executeUpdate();
            if(rs1>0){
                System.out.println("e inserted");
            }
            else{
                System.out.println("e not inserted");
            }
        }
    }
    else{
        PreparedStatement stmt=conn.prepareStatement("insert into quiz values(?,?,?,?,?)");
        stmt.setString(1,Level.name);
        stmt.setString(2,Level.email);
        stmt.setDouble(3,easy_marks);
        stmt.setDouble(4,result_2);
        stmt.setDouble(5,hard_marks);
       int rs2= stmt.executeUpdate();
            if(rs2>0){
                System.out.println("n inserted");
            }
            else{
                System.out.println("n not inserted");
            }
        }
        num_rgt_2.setText("("+correct_guesses_2+"/"+total_questions_2+")");
        res_2.setText(result_2+"%");
        f22.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f22.setSize(750, 750);
        f22.getContentPane();
        f22.setLayout(null);
        f22.setResizable(false);
        f22.add(textField_2);
        f22.add(num_rgt_2);
        f22.add(res_2);
        f22.add(button3);
        f22.add(button4);
        f22.setVisible(true);
        frame2.setVisible(false);
    }
}
class Difficult implements ActionListener{
    static final String DB_URL="jdbc:mysql://localhost/quiz_project";
    static final String USER="root";
    static final String PASS="Chilli2116";  
    String[] Hardquestions = 	{
        "1.What makes the Java platform independent?",
        "2.Which of the following is the correct syntax to create a variable in Java?",
        "3.The break statement in Java is used to?",
        "4.What is garbage collection in java?",
        "5.'this' keyword in java is _?",
        "6.The 'super' keyword is used to _",
        "7.Which method is used to add a new line to file in Java?",
        "8.What is stringBuffer in java?",
        "9.Which of these is true for interfaces in java?",
        "10.Empty interface in Java is called?"
    };
String[][] Hardoptions = 	{
        {"Advanced programming language","It uses bytecode for execution","Class compilation","All of these"},
        {"var name;","int name;","var name int;","All of these"},
        {"Terminates from the loop immediately","Terminates from the program immediately","Skips the current iteration","All of these"},
        {"Method to manage memory in java","Create new garbage values","Delete all values","All of these"},
        {"Used to hold the reference of the current object","Holds object value","Used to create a new instance","All of these"},
        {"Access instance of the same class","Access instance of child class","Access instance of friend class","Access instance of the parent class"},
        {"file.addLine()","file.nextLine()","file.write()","file.line()"},
        {"Class to create a string array","Class to create a mutable string in java","Class to create a string from i/o buffer","All of these"},
        {"The keyword interface is used to create a method","All the methods of an interface are abstract","It does not contain constructorss","All of these"},
        {"Marker interface","Abstract class","Derived class","None of these"}



    };
char[] Hardanswers ={
        'B',
        'B',
        'A',
        'A',
        'A',
        'D',
        'C',
        'B',
        'D',
        'A'
    };
    char guess_3;
    char answer_3;
    int index_3;
    int correct_guesses_3=0;
    int total_questions_3=Hardquestions.length;
    int result_3;
    int seconds_3=30;
    JButton button5 = new JButton("<Back");
    JFrame frame3 = new JFrame();
    JTextField textField_3=new JTextField();
    JTextArea textArea_3=new JTextArea();
    JButton c1=new JButton();
    JButton c2=new JButton();
    JButton c3=new JButton();
    JButton c4=new JButton();
    JLabel answer13=new JLabel();
    JLabel answer23=new JLabel();
    JLabel answer33=new JLabel();
    JLabel answer43=new JLabel();
    JLabel time_label_3 = new JLabel();
    JLabel sec_3 = new JLabel();
    JTextField num_rgt_3=new JFormattedTextField();
    JTextField res_3=new JTextField();
    Timer timer_3 = new Timer(1000, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			seconds_3--;
			sec_3.setText(String.valueOf(seconds_3));
			if(seconds_3<=0) {
				display3();
			}
			}
		});
    public void Difficult1() throws SQLException
    {    
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setSize(1000, 1000);
        frame3.getContentPane();
        frame3.setLayout(null);
        frame3.setResizable(false);
        textField_3.setBounds(0,0,1000,50);
        textField_3.setFont(new Font("Arial",Font.BOLD,30));
        textField_3.setBorder(BorderFactory.createBevelBorder(1));
        textField_3.setEditable(false);
        textArea_3.setBounds(0,50,1000,75);
        textArea_3.setLineWrap(true);
        textArea_3.setWrapStyleWord(true);
        textArea_3.setFont(new Font("Arial",Font.BOLD,30)); 
        textArea_3.setBorder(BorderFactory.createBevelBorder(1));
        textArea_3.setEditable(false);
        c1.setBounds(0,150,100,50);
        c1.setFont(new Font("Arial",Font.BOLD,35));
        c1.setFocusable(false);
        c1.addActionListener(this);
        c1.setText("A");
        c2.setBounds(0,250,100,50);
        c2.setFont(new Font("Arial",Font.BOLD,35));
        c2.setFocusable(false);
        c2.addActionListener(this);
        c2.setText("B");
        c3.setBounds(0,350,100,50);
        c3.setFont(new Font("Arial",Font.BOLD,35));
        c3.setFocusable(false);
        c3.addActionListener(this);
        c3.setText("C");
        c4.setBounds(0,450,100,50);
        c4.setFont(new Font("Arial",Font.BOLD,35));
        c4.setFocusable(false);
        c4.addActionListener(this);
        c4.setText("D");
        answer13.setBounds(125,125,750,100);
        answer13.setFont(new Font("Arial",Font.BOLD,25));
        answer23.setBounds(125,225,750,100);
        answer23.setFont(new Font("Arial",Font.BOLD,25));
        answer33.setBounds(125,325,750,100);
        answer33.setFont(new Font("Arial",Font.BOLD,25));
        answer43.setBounds(125,425,750,100);
        answer43.setFont(new Font("Arial",Font.BOLD,25));
        sec_3.setBounds(650,650,50,25);
		sec_3.setFont(new Font("Arial",Font.BOLD,25));
		sec_3.setBorder(BorderFactory.createBevelBorder(1));
		sec_3.setOpaque(true);
		sec_3.setHorizontalAlignment(JTextField.CENTER);
		sec_3.setText(String.valueOf(seconds_3));
		time_label_3.setBounds(650,650,50,25);
		time_label_3.setFont(new Font("Arial",Font.PLAIN,16));
		time_label_3.setHorizontalAlignment(JTextField.CENTER);
		time_label_3.setText("timer");
        num_rgt_3.setBounds(250,250,200,100);
        num_rgt_3.setFont(new Font("Arial",Font.BOLD,25));
        num_rgt_3.setBorder(BorderFactory.createBevelBorder(1));
        num_rgt_3.setEditable(false);
        res_3.setBounds(250,350,200,100);
        res_3.setFont(new Font("Arial",Font.BOLD,25));
        res_3.setBorder(BorderFactory.createBevelBorder(1));
        res_3.setEditable(false);
        frame3.add(time_label_3);
        frame3.add(sec_3);
        frame3.add(answer13);
        frame3.add(answer23);
        frame3.add(answer33);
        frame3.add(answer43);
        frame3.add(c1);
        frame3.add(c2);
        frame3.add(c3);
        frame3.add(c4);
        frame3.add(textArea_3);
        frame3.add(textField_3);
        HardnxtQuestion();
    }
    public void HardnxtQuestion() throws SQLException{
        if(index_3>=total_questions_3){
            results_3();
        }else{
            textField_3.setText("Question: "+(index_3+1));
            textArea_3.setText(Hardquestions[index_3]);
            answer13.setText(Hardoptions[index_3][0]);
            answer23.setText(Hardoptions[index_3][1]);
            answer33.setText(Hardoptions[index_3][2]);
            answer43.setText(Hardoptions[index_3][3]);
            timer_3.start();
        }
    }
    public void actionPerformed(ActionEvent e){
        c1.setEnabled(false);
        c2.setEnabled(false);
        c3.setEnabled(false);
        c4.setEnabled(false);
        if(e.getSource()==c1){
            answer_3='A';
            if(answer_3==Hardanswers[index_3]){
                correct_guesses_3++;
            }
        }
        if(e.getSource()==c2){
            answer_3='B';
            if(answer_3==Hardanswers[index_3]){
                correct_guesses_3++;
            }
        }
        if(e.getSource()==c3){
            answer_3='C';
            if(answer_3==Hardanswers[index_3]){
                correct_guesses_3++;
            }
        }
        if(e.getSource()==c4){
            answer_3='D';
            if(answer_3==Hardanswers[index_3]){
                correct_guesses_3++;
            }
        }
        display3();
    }
    public void display3(){

        timer_3.stop();

        c1.setEnabled(false);
        c2.setEnabled(false);
        c3.setEnabled(false);
        c4.setEnabled(false);

        if(Hardanswers[index_3]!='A'){
            answer13.setForeground(new Color(255,0,0));
        }
        if(Hardanswers[index_3]!='B'){
            answer23.setForeground(new Color(255,0,0));
        }
        if(Hardanswers[index_3]!='C'){
            answer33.setForeground(new Color(255,0,0));
        }
        if(Hardanswers[index_3]!='D'){
            answer43.setForeground(new Color(255,0,0));
        }   
      
        Timer pause3 = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				answer13.setForeground(new Color(25,255,0));
				answer23.setForeground(new Color(25,255,0));
				answer33.setForeground(new Color(25,255,0));
				answer43.setForeground(new Color(25,255,0));
				
				answer_3 = ' ';
				seconds_3=30;
				sec_3.setText(String.valueOf(seconds_3));
				c1.setEnabled(true);
				c2.setEnabled(true);
				c3.setEnabled(true);
				c4.setEnabled(true);
				index_3++;
				try {
                    HardnxtQuestion();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
			}
		});
        pause3.setRepeats(false);
        pause3.start();
        
    }
    public void results_3() throws SQLException{
        c1.setEnabled(false);
        c2.setEnabled(false);
        c3.setEnabled(false);
        c4.setEnabled(false);

        JFrame f23=new JFrame("Results");
        
        button5.setBounds(25,650,75,75);
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Level obj=new Level();
                obj.previous();
                
                f23.setVisible(false);
            }
        });
        JButton button6 = new JButton("Exit>");
        button6.setBounds(650,650,75,75);
        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Level obj=new Level();
                obj.exit();
                
                f23.setVisible(false);
            }
        });

        result_3=(int)((correct_guesses_3/(double)total_questions_3)*100);
        
        textField_3.setText("RESULTS!");
        textArea_3.setText("");
        answer13.setText("");
        answer23.setText("");
        answer33.setText("");
        answer43.setText("");
        Connection conn =DriverManager.getConnection(DB_URL,USER,PASS);
        PreparedStatement stmt1=conn.prepareStatement("select * from quiz where name=? and email=?");
        stmt1.setString(1,Level.name);
        stmt1.setString(2,Level.email);
        ResultSet rs=stmt1.executeQuery();
        String name1="";
        String email1="";
        int easy_marks1=0;
        int med_marks1=0;
        if(rs.next()){
            name1=rs.getString("name");
            email1=rs.getString("email");
            easy_marks1=rs.getInt("easy_results");
            med_marks1=rs.getInt("med_results");
        if(Level.name.equals(name1) && Level.email.equals(email1)){
            PreparedStatement stmt=conn.prepareStatement("update quiz set easy_results=?,med_results=?,hard_results=? where name=? and email=?");
            stmt.setInt(1,easy_marks1);
            stmt.setInt(2,med_marks1);
            stmt.setInt(3,result_3/10);
            stmt.setString(4,Level.name);
            stmt.setString(5,Level.email);
            int rs1=stmt.executeUpdate();
            if(rs1>0){
                System.out.println("e inserted");
            }
            else{
                System.out.println("e not inserted");
            }
        }
    }
        else{
        PreparedStatement stmt3=conn.prepareStatement("insert into quiz values(?,?,?,?,?)");
        stmt3.setString(1,Level.name);
        stmt3.setString(2,Level.email);
        stmt3.setInt(3,easy_marks1);
        stmt3.setInt(4,med_marks1);
        stmt3.setInt(5,result_3/10);
        int rs2=stmt3.executeUpdate();
            if(rs2>0){
                System.out.println("n inserted");
            }
            else{
                System.out.println("n not inserted");
            }
        }
        num_rgt_3.setText("("+correct_guesses_3+"/"+total_questions_3+")");
        res_3.setText(result_3+"%");
        f23.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f23.setSize(750, 750);
        f23.getContentPane();
        f23.setLayout(null);
        f23.setResizable(false);
        f23.add(textField_3);
        f23.add(num_rgt_3);
        f23.add(res_3);
        f23.add(button5);
        f23.add(button6);
        f23.setVisible(true);
        frame3.setVisible(false);
}
}