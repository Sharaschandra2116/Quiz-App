package Level;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Medium implements ActionListener{
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