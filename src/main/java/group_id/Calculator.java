package group_id;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */


public class Calculator extends javax.swing.JFrame {

    /**
     * Creates new form Calculator
     */
    
    float num1 = 0, num2 = 0;
    String opr = "";
    int oprClickCount = 0;
    boolean isOprClick = false;
    boolean isEqualClick = false;
    
    public Calculator(){
        initComponents();
        addAction();
    }
    
    // Action on user click
    public ActionListener createAction(JButton button) {
        
        ActionListener acLis = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isOperator(button)){ // Button is not an operator
                    
                    if(isOprClick){ // If user clicks an operator
                        num1 = Float.valueOf(outputField.getText());
                        outputField.setText("");
                    }
                    
                    if(!outputField.getText().contains(".") && !button.getText().equals("Delete")) { 
                        // If text does not contain "." and the button is not Delete
                    
                        if(outputField.getText().equals("0") && !button.getText().equals(".")){
                            // Clear Output_Field if text is 0 and button pressed is not "."
                            outputField.setText(button.getText());
                            isOprClick = false;
                        }
                        else {
                        outputField.setText(outputField.getText()+button.getText());
                        isOprClick = false;
                        }
                    }
                    else if(!button.getText().equals(".") && !button.getText().equals("Delete")){
                        outputField.setText(outputField.getText()+button.getText());
                        isOprClick = false;
                    }
                }
                else {
                    
                    if(oprClickCount == 0) { // If operator is clicked the first time
                        oprClickCount++;
                        // Convert outputField into a float assigned to num1
                        num1 = Float.valueOf(outputField.getText());
                        opr = button.getText();
                        isOprClick = true;
                    }
                    else {
                        if(!button.getText().equals("=")) { // If the operator is not "="
                        
                            if(!isEqualClick) {
                            
                                num2 = Float.valueOf(outputField.getText());
                                outputField.setText(Float.toString(calc(opr, num1, num2)));
                                opr = button.getText();
                                num2 = Float.valueOf(outputField.getText());
                                isOprClick = true;
                                isEqualClick = false;
                            }
                            else {
                                isEqualClick = false;
                                opr = button.getText();
                            }
                        }
                        else {
                            num2 = Float.valueOf(outputField.getText());
                            outputField.setText(Float.toString(calc(opr, num1, num2)));
                            num1 = Float.valueOf(outputField.getText());
                            isOprClick = true;
                            isEqualClick = true;
                        }
                    }
                }
            }
        };
      return acLis;
    }
    
    // Calculate two numbers and return result
    public float calc(String op, float n1, float n2) {
        
        float result = 0;
        
        switch(op) {
            
            case "+":
                   result = n1 + n2;
                   break;
            case "-":
                   result = n1 - n2;
                   break;
            case "*":
                   result = n1 * n2;
                   break;
            case "/":
                   if(n2 != 0){
                       result = n1 / n2;
                   }
                   break;
            default:
                   break;
        }
        
        return result;
    }
    
    // Determine if button press is an operator
    public boolean isOperator(JButton button) {
        
        String buttonText = button.getText();
        
        if(buttonText.equals("+") || buttonText.equals("-") ||
           buttonText.equals("*") || buttonText.equals("/") ||
           buttonText.equals("=")) {
            return true;
        }
        else {
            return false;
        }
    }
    
    // Add action to all buttons
    public void addAction(){
        
        Component[] components = calculatorPanel.getComponents();
        
        for(Component component : components){
            
            if(component instanceof JButton){
                
                JButton button = (JButton) component;
                button.addActionListener(createAction(button));
                
            }
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        calculatorPanel = new javax.swing.JPanel();
        outputField = new javax.swing.JTextField();
        multiplyButton = new javax.swing.JButton();
        divideButton = new javax.swing.JButton();
        equalButton = new javax.swing.JButton();
        subtractButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        button0 = new javax.swing.JButton();
        button1 = new javax.swing.JButton();
        button2 = new javax.swing.JButton();
        button3 = new javax.swing.JButton();
        button4 = new javax.swing.JButton();
        button5 = new javax.swing.JButton();
        button6 = new javax.swing.JButton();
        button7 = new javax.swing.JButton();
        button8 = new javax.swing.JButton();
        button9 = new javax.swing.JButton();
        decimalButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        calculatorPanel.setBackground(new java.awt.Color(231, 231, 231));

        outputField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        outputField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        outputField.setText("0");
        outputField.setEditable(false);

        multiplyButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        multiplyButton.setText("*");

        divideButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        divideButton.setText("/");

        equalButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        equalButton.setText("=");

        subtractButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        subtractButton.setText("-");

        addButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addButton.setText("+");

        button0.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        button0.setText("0");

        button1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        button1.setText("1");

        button2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        button2.setText("2");

        button3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        button3.setText("3");

        button4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        button4.setText("4");

        button5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        button5.setText("5");

        button6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        button6.setText("6");

        button7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        button7.setText("7");

        button8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        button8.setText("8");

        button9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        button9.setText("9");

        decimalButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        decimalButton.setText(".");

        deleteButton.setBackground(new java.awt.Color(240, 40, 40));
        deleteButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        clearButton.setBackground(new java.awt.Color(72, 72, 255));
        clearButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout calculatorPanelLayout = new javax.swing.GroupLayout(calculatorPanel);
        calculatorPanel.setLayout(calculatorPanelLayout);
        calculatorPanelLayout.setHorizontalGroup(
            calculatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calculatorPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(calculatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(outputField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(calculatorPanelLayout.createSequentialGroup()
                        .addGroup(calculatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(calculatorPanelLayout.createSequentialGroup()
                                .addGroup(calculatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(button7, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                    .addComponent(button4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(calculatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(calculatorPanelLayout.createSequentialGroup()
                                        .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(button6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(calculatorPanelLayout.createSequentialGroup()
                                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(calculatorPanelLayout.createSequentialGroup()
                                        .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(button9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(calculatorPanelLayout.createSequentialGroup()
                                        .addComponent(button0, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(decimalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(calculatorPanelLayout.createSequentialGroup()
                                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(calculatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subtractButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(multiplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(divideButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(equalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        calculatorPanelLayout.setVerticalGroup(
            calculatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calculatorPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(outputField, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(calculatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(calculatorPanelLayout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(calculatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(subtractButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(calculatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(multiplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(calculatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(calculatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(divideButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(calculatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button0, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(equalButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(decimalButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(calculatorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(calculatorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        
        // Reset on Clear
        num1 = 0;
        num2 = 0;
        opr = "";
        oprClickCount = 0;
        isOprClick = false;
        isEqualClick = false;
        
        outputField.setText("0");
        
    }//GEN-LAST:event_clearButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        
        if(outputField.getText().length() > 0){ 
            String txt = outputField.getText();
            txt = txt.substring(0, txt.length() - 1);
            if(txt.length() == 0){
                outputField.setText("0"); // Reset outputField
            }
            else{
                outputField.setText(txt); // Backspace
            }
        }
        else{ // Clear if pressed after operand

            num1 = 0;
            num2 = 0;
            opr = "";
            oprClickCount = 0;
            isOprClick = false;
            isEqualClick = false;

            outputField.setText("0");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton button0;
    private javax.swing.JButton button1;
    private javax.swing.JButton button2;
    private javax.swing.JButton button3;
    private javax.swing.JButton button4;
    private javax.swing.JButton button5;
    private javax.swing.JButton button6;
    private javax.swing.JButton button7;
    private javax.swing.JButton button8;
    private javax.swing.JButton button9;
    private javax.swing.JPanel calculatorPanel;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton decimalButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton divideButton;
    private javax.swing.JButton equalButton;
    private javax.swing.JButton multiplyButton;
    private javax.swing.JTextField outputField;
    private javax.swing.JButton subtractButton;
    // End of variables declaration//GEN-END:variables
}
