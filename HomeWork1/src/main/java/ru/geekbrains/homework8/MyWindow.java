package ru.geekbrains.homework8;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MyWindow extends JFrame {
    static double arg1;
    static double result;
    static String operType;
    static NumberFormat nf = new DecimalFormat("#.######");
    static Font btnFont = new Font("Calibri",Font.BOLD, 60);
    public MyWindow(){
        setTitle("My Calculator");
        setBounds(100,100, 1600,800);

        JPanel panel1 = new JPanel(new GridLayout(1,2));
        JPanel operBtnPanel = new JPanel(new GridLayout(3,2));
        JPanel numbersPanel = new JPanel(new GridLayout(4,3));
        JPanel inputFieldPanel = new JPanel(new GridLayout(1,2));
        JPanel resultFieldPanel = new JPanel();

        //setSize(500, 500);
        //setLocation(650, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Поле для ввода
        JTextField inputField = new JTextField(2);
        inputField.setColumns(30);
        Font textFieldFont = new Font("Calibri",Font.BOLD, 60);
        inputField.setFont(textFieldFont);
        inputField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // ignore event
                }
            }
        });
        //Создаю поле с результатом
        JLabel resultField = new JLabel();
        Font resultFieldFont = new Font("Calibri",Font.ITALIC, 50);
        resultField.setFont(resultFieldFont);
        resultFieldPanel.add(resultField);


        // создаю кнопки - цифры
        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton(""+i);
            Font btnFont = new Font("Calibri",Font.BOLD, 60);
            btn.setFont(btnFont);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("btn" + btn.getText());
                    inputField.setText(inputField.getText() + btn.getText());
                }
            });
            numbersPanel.add(btn);
        }
        JButton dotBtn = new JButton(".");
        Font btnFont = new Font("Calibri",Font.BOLD, 60);
        dotBtn.setFont(btnFont);
        dotBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("btn" + dotBtn.getText());
                inputField.setText(inputField.getText() + dotBtn.getText());
            }
        });
        numbersPanel.add(dotBtn);

        //создаю кнопки-операции
        for ( int i = 0; i < 5; i++) {
            JButton btn = new JButton();
            if(i == 0 ){
                btn.setText("+");
            }
            if(i == 1 ){
                btn.setText("-");
            }
            if(i == 2 ){
                btn.setText("x");
            }
            if(i == 3 ){
                btn.setText("/");
            }
            if(i == 4 ){
                btn.setText("\u221A");
            }

            btn.setFont(btnFont);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("btn" + btn.getText());
                    if(inputField.getText().equals("") && btn.getText().equals("-")){
                        inputField.setText("-");
                    }
                    if (arg1 != 0) {
                        if (operType.equals("+")) {
                            arg1 = arg1 + Double.valueOf(inputField.getText());
                            result = arg1;
                        }
                        if (operType.equals("-")) {
                            arg1 = arg1 - Double.valueOf(inputField.getText());
                            result = arg1;
                        }
                        if (operType.equals("x")) {
                            arg1 = arg1 * Double.valueOf(inputField.getText());
                            result = arg1;
                        }
                        if (operType.equals("/")) {
                            if(inputField.getText().equals("0")){
                                resultField.setText("На 0 делить нельзя");
                            }
                            else {
                                arg1 = arg1 / Double.valueOf(inputField.getText());
                                result = arg1;
                            }
                        }

                    }


                    if (!inputField.getText().equals("")) {
                        if(btn.getText().equals("\u221A")){
                            result = Math.sqrt(Double.valueOf(inputField.getText()));
                            resultField.setText(nf.format(result));
                            inputField.setText("");
                            result = 0;
                        }
                        else {
                            arg1 = Double.valueOf(inputField.getText());
                            resultField.setText("" + nf.format(arg1) + btn.getText());
                            inputField.setText("");
                            operType = btn.getText();
                        }
                    }


                }
            });
            operBtnPanel.add(btn);
        }
        //создаю кнопку-результат
        JButton equalBtn = new JButton("=");
        //Font btnFont = new Font("Calibri",Font.BOLD, 60);
        equalBtn.setFont(btnFont);
        equalBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(operType.equals("+")){
                    resultField.setText(resultField.getText()+nf.format(Double.valueOf(inputField.getText()))+"=" + nf.format(arg1 + Double.valueOf(inputField.getText())));
                }
                if(operType.equals("-")){
                    resultField.setText(resultField.getText()+nf.format(Double.valueOf(inputField.getText()))+"=" + nf.format(arg1 - Double.valueOf(inputField.getText())));
                }
                if(operType.equals("x")){
                    resultField.setText(resultField.getText()+nf.format(Double.valueOf(inputField.getText()))+"=" + nf.format(arg1 * Double.valueOf(inputField.getText())));
                }
                if(operType.equals("/")){
                    if(inputField.getText().equals("0")){
                        resultField.setText("На 0 делить нельзя");
                    }
                    else {
                        resultField.setText(resultField.getText() + nf.format(Double.valueOf(inputField.getText())) + "=" + nf.format(arg1 / Double.valueOf(inputField.getText())));
                    }
                }
                if(operType.equals("\u221A")){
                    resultField.setText(resultField.getText()+nf.format(Double.valueOf(inputField.getText()))+"=" + nf.format(arg1+Double.valueOf(inputField.getText())));
                }



                inputField.setText("");
                result = 0;
            }
        });
        //Создаю кнопку "стереть"
        JButton eraseBtn = new JButton("C");
        eraseBtn.setFont(btnFont);
        eraseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!inputField.getText().equals("")) {
                    inputField.setText(inputField.getText().substring(0, inputField.getText().length() - 1));
                }
            }
        });
        numbersPanel.add(eraseBtn);
        operBtnPanel.add(equalBtn);
        /*
        JTextField textField = new JTextField(10);
        panel1.add(textField);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Your message: " + textField.getText());
            }
        });
        panel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("MousePos: " + e.getX() + " " + e.getY());
            }
        });

        JTextArea textArea = new JTextArea("sdefe");
        panel1.add(textArea);
        JScrollPane scrollPane = new JScrollPane();
        panel1.add(scrollPane);
        JMenuBar menuBar = new JMenuBar();
        panel1.add(menuBar);
        JTable table = new JTable();
        panel1.add(table);
        JRadioButton radioBtn = new JRadioButton();
        panel1.add(radioBtn);
        JCheckBox checkBox = new JCheckBox();
        panel1.add(checkBox);
        */



        inputFieldPanel.add(inputField);
        inputFieldPanel.add(resultFieldPanel);
        panel1.add(numbersPanel);
        panel1.add(operBtnPanel);
        add(panel1);
        add(inputFieldPanel, BorderLayout.NORTH);
        setVisible(true);
    }
}
