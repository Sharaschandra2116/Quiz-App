package Level;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Difficult implements ActionListener{
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