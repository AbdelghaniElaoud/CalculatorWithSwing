import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[12];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton,negButton,sqrButton,powButton,logButton;
    JPanel panel;

    Font myFont = new Font("Times New Roman", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public Calculator() {
        Image icon = Toolkit.getDefaultToolkit().getImage("src/calculator.png");

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("D");
        clrButton = new JButton("C");
        negButton = new JButton("(-)");
        sqrButton = new JButton("sqr");
        powButton = new JButton("x^2");
        logButton = new JButton("ln");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = sqrButton;
        functionButtons[10] = powButton;
        functionButtons[11] = logButton;


        for (int i = 0 ; i < 12 ;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setFont(myFont);
        }

        for (int i = 0 ; i < 10 ;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setFont(myFont);
        }

        delButton.setBounds(10, 430, 50, 50);
        clrButton.setBounds(65, 430, 50, 50);
        negButton.setBounds(125, 430, 60, 50);
        sqrButton.setBounds(190, 430, 70, 50);
        powButton.setBounds(260, 430, 80, 50);
        logButton.setBounds(340, 430, 60, 50);

        frame.add(delButton);
        frame.add(clrButton);
        frame.add(negButton);
        frame.add(sqrButton);
        frame.add(powButton);
        frame.add(logButton);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));


        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);


        frame.setIconImage(icon);
        frame.add(panel);
        frame.add(textField);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i<10; i++){
            if (e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
                break;
            }
        }

        if (e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if (e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (e.getSource() == equButton){
            if (num1 == 0 && num2 ==0){

                textField.setText(textField.getText());
                result = 0;
                return;
            }

            num2 = Double.parseDouble(textField.getText());
            switch (operator){
                case '+':
                    result = num1+num2;
                    break;
                case '-':
                    result = num1-num2;
                    break;
                case '*':
                    result = num1*num2;
                    break;
                case '/':
                    result = num1/num2;
                    break;
            }
            textField.setText("");
            textField.setText(String.valueOf(result));
        }

        if (e.getSource() == clrButton){
            num1 = 0;
            num2 = 0;
            result = 0;
            textField.setText("");
            operator = 0;
        }

        if (e.getSource() == delButton){
            textField.setText(textField.getText().substring(0,textField.getText().length()-1));
        }

        if (e.getSource() == negButton){
            textField.setText("-"+textField.getText());
        }

        if (e.getSource() == sqrButton){
            textField.setText(String.valueOf(Math.sqrt(Double.parseDouble(textField.getText()))));
        }

        if (e.getSource() == powButton){
            textField.setText(String.valueOf(Math.pow(Double.parseDouble(textField.getText()),2)));
        }

        if (e.getSource() == logButton){
            textField.setText(String.valueOf(Math.log(Double.parseDouble(textField.getText()))/Math.log(2)));
        }

    }
}
