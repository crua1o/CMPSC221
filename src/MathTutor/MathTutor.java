// Author: Colin Rualo
//E-mail: cvr5614@psu.edu
//Course: CMPSC 221
//Assignment: Programming Assignment 5
//Due date: 4/11/2022
//File: MathTutor.java
//Purpose: Java GUI application that helps a student learn to add,
// subtract, or multiply two numbers in the range 1 to 100
//Compiler/IDE:  intelliJ IDEA 2021.3.1
//Operating system: MacOS
// References: Savitch, 6th Edition: Chapter 17
// https://stackoverflow.com/questions/28735798/how-do-i-get-input-from-a-jtextfield-then-store-it-in-a-variable
// https://www.delftstack.com/howto/java/java-random-number-between-1-and-10/
//



package MathTutor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MathTutor extends JFrame implements ActionListener {


    public static final int WIDTH = 500;
    public static final int HEIGHT = 150;

    JButton newProblem;
    JButton quitTutor;
    JButton check; // Check Answer
    JTextField prompt;
    JLabel answerLabel;
    JLabel question = new JLabel();
    int operand1, operand2, answer, count = 0;
    Character operation;

    /**
     * No-argument constructor
     */
    public MathTutor(Color theColor, int rows, int columns) {
        super();
        setSize(WIDTH, HEIGHT);
        setTitle("Math Tutor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(theColor);
        setLayout(new GridLayout(rows, columns));


        JPanel answerPanel = new JPanel();
        answerPanel.setLayout(new BorderLayout());
        answerPanel.setBackground(Color.yellow);

        question.setBackground(Color.PINK);
        generateProblem();
        question.setText("How much is " + operand1 + operation + operand2 + "?");

        prompt = new JTextField(); // input prompt text box
        prompt.setSize(5, 2);
        answerPanel.add(prompt, BorderLayout.CENTER);
        answerLabel = new JLabel("Please enter your answer.");
        answerPanel.add(answerLabel, BorderLayout.CENTER);
        // register event handler for jtextfield
        prompt.addActionListener(this);

        JPanel buttonpanel = new JPanel();
        buttonpanel.setBackground(Color.cyan);
        buttonpanel.setLayout(new FlowLayout());

        check = new JButton("Check Answer");
        check.setBackground(Color.lightGray);
        check.addActionListener(this);
        buttonpanel.add(check);

        newProblem = new JButton("New Problem");
        newProblem.setBackground(Color.lightGray);
        newProblem.addActionListener(this);
        buttonpanel.add(newProblem);


        quitTutor = new JButton("Quit Tutor");
        quitTutor.addActionListener(this);
        buttonpanel.add(quitTutor);

        question.setBackground(Color.CYAN);

        add(question);
        add(answerPanel, BorderLayout.NORTH);
        add(prompt);
        add(buttonpanel, BorderLayout.SOUTH);



    }

    /** This method generates a math problem.
     */
    public void generateProblem()
    {
        // random num gen 1-3 inclusive to decide which math operation (+,-,*)
        Random r = new Random();
        int low = 1;
        int high = 5;
        int high2 = 100;
        operand1 = r.nextInt(high2-low) + low;
        operand2 = r.nextInt(high2-low) + low;
        int rand = r.nextInt(high-low) + low;
        // random num gen 1-100 inclusive to generate operands
        if(rand == 1){ // addition
            answer = operand1 + operand2;
            operation = '+';
        }
        else if(rand == 2){ // subtraction
            answer = operand1 - operand2;
            //answer = operand2 - operand1;
            operation = '-';
        }
        else if(rand == 3){ // multiplication
            answer = operand1 * operand2;
            operation = '*';
        }
        question.setText("How much is " + operand1 + operation + operand2 + "?");
    }

    /** This method checks a student's answer.
     */
    public void checkAnswer()
    {
        int userAnswer = Integer.parseInt(prompt.getText());
        count++;
        //System.out.println(operand1 + "," + operand2+ "," + answer+ "," + userAnswer);
        if (answer == userAnswer)
            answerLabel.setText("Correct! It took you " + count + " attempt(s).");
        else answerLabel.setText("Try again.");

    }



    /** This method registers button listeners.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonString = e.getActionCommand();

        switch (buttonString) {
            case "Quit Tutor" -> System.exit(0);
            case "New Problem" ->{
                generateProblem();
                question.setText("How much is " + operand1 + operation + operand2 + "?");
                prompt.setText(""); // clears JTextField
                count = 0;
            }
            case "Check Answer" -> {
                if(prompt.getText() == null){answerLabel.setText("Please enter a number.");}
                checkAnswer();
            }
        }
    }
}


