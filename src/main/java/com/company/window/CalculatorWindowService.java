package com.company.window;

import com.company.calculator.Calculator;
import com.company.calculator.impl.CalculatorImpl;
import com.company.constant.Constant;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import static com.company.constant.Constant.CALCULATE;
import static com.company.constant.Constant.CLEAN;
import static com.company.constant.Constant.EXIT;
import static com.company.constant.Constant.INFO;
import static com.company.constant.Constant.INPUT;
import static com.company.constant.Constant.RESULT;
import static com.company.constant.Constant.ROMAN_CALCULATOR;

/**
 * Класс для предоставления графического интерфейса
 *
 * @see Calculator
 * @see CalculatorImpl
 * @see Constant
 */
public class CalculatorWindowService extends JFrame {

    private final JTextField inputTextField = new JTextField("");
    private final JTextField resultTextField = new JTextField("");
    private final Calculator calculator = new CalculatorImpl();

    private CalculatorWindowService(boolean isVisible) {
        super(ROMAN_CALCULATOR);
        super.setSize(300, 150);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);

        var container = super.getContentPane();
        container.setLayout(new GridLayout(3, 3, 2, 10));
        addToContainer(container);

        super.setVisible(isVisible);
    }

    public static void openCalculatorWindow() {
        new CalculatorWindowService(true);
    }

    private void addToContainer(Container container) {
        container.add(new JLabel(INPUT));
        container.add(inputTextField);
        container.add(cleanInputTextFieldButton());

        container.add(new JLabel(RESULT));
        container.add(resultTextField);
        container.add(cleanResultTextFieldButton());

        container.add(calculateButton());
        container.add(infoButton());
        container.add(exitButton());
    }

    private JButton cleanInputTextFieldButton() {
        var cleanInputTextFieldButton = new JButton(CLEAN);
        cleanInputTextFieldButton.addActionListener(this::cleanInputTextFieldButtonListener);
        return cleanInputTextFieldButton;
    }

    private void cleanInputTextFieldButtonListener(ActionEvent e) {
        inputTextField.setText("");
    }

    private JButton cleanResultTextFieldButton() {
        var cleanResultTextFieldButton = new JButton(CLEAN);
        cleanResultTextFieldButton.addActionListener(this::cleanResultTextFieldButtonListener);
        return cleanResultTextFieldButton;
    }

    private void cleanResultTextFieldButtonListener(ActionEvent e) {
        resultTextField.setText("");
    }

    private JButton calculateButton() {
        var calculateButton = new JButton(CALCULATE);
        calculateButton.addActionListener(this::calculateButtonListener);
        return calculateButton;
    }

    public void calculateButtonListener(ActionEvent e) {
        resultTextField.setText(calculator.calculate(inputTextField.getText()));
    }

    private JButton infoButton() {
        var infoButton = new JButton(INFO);
        infoButton.addActionListener(this::infoButtonListener);
        return infoButton;
    }

    private void infoButtonListener(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "INFO");
    }

    private JButton exitButton() {
        var exitButton = new JButton(EXIT);
        exitButton.addActionListener(this::exitButtonListener);
        return exitButton;
    }

    private void exitButtonListener(ActionEvent e) {
        System.exit(0);
    }
}
