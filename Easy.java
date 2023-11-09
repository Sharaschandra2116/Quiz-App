package Level;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Easy implements ActionListener{
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