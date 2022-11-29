import javax.swing.JOptionPane;

//The MainFrame where it has the Number, the buffer and the file output
public class MainFrame extends javax.swing.JFrame {
    int numm;
    int buff;
    String file;
    public MainFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    //The Components of the frame, the output file, the N button, the buffer size, Start buttom and thee labels
    public void initComponents() {

        outputFile = new javax.swing.JTextField();
        n = new javax.swing.JTextField();
        bufferSize = new javax.swing.JTextField();
        startButtom = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102)); //The Color background

        outputFile.setText("Output File"); //the output file
        outputFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputFileActionPerformed(evt);
            }
        });

        //The Text N where the Bar of N label and the size of array is entered
        n.setText("N");
        n.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nActionPerformed(evt);
            }
        });

        //The Text Buffer Size where the Bar of BufferSize label and the size of it is entered
        bufferSize.setText("Buffer Size");
        bufferSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bufferSizeActionPerformed(evt);
            }
        });

        //The Start Button of Start producing numbers
        startButtom.setText("Start Producer");
        startButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtomActionPerformed(evt);
            }
        });

        //The Labels font,color, and text of N, Buffer Size and Outpu File
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("N");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Buffer Size");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Output File");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(startButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(n)
                                                        .addComponent(bufferSize)
                                                        .addComponent(outputFile, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                218, Short.MAX_VALUE))
                                                .addGap(70, 70, 70)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel3))))
                                .addContainerGap(96, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(n, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(bufferSize, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(outputFile, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47,
                                        Short.MAX_VALUE)
                                .addComponent(startButtom)
                                .addGap(39, 39, 39)));

        pack();
    }// </editor-fold>

    //The Buffer Action
    private void bufferSizeActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        //get the buff  

    }

    //The StartButton Action of the producer where we read the inputs and pass it to the GUI
    private void startButtomActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Producer.reSet();
        SecondFrame secondFrame = new SecondFrame();
        if(!(n.getText().isEmpty() && bufferSize.getText().isEmpty() && outputFile.getText().isEmpty())&&(n.getText().matches("[0-9]+")&&bufferSize.getText().matches("[0-9]+") && outputFile.getText().contains(".txt"))){
        secondFrame.setVisible(true);
        int numm= Integer.parseInt(n.getText());
        int buff= Integer.parseInt(bufferSize.getText());
        String file= outputFile.getText();
        Producer obj = new Producer(numm, buff,file);
        Consumer objj = new Consumer(obj);
        obj.start();
        objj.start();
        
    }else{
            JOptionPane.showMessageDialog(null, "Please enter the values");
        }
    }
    

    //Output file event action
    private void outputFileActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    //N Event action
    private void nActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        
    }

    //The Main Function
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JTextField bufferSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField n;
    private javax.swing.JTextField outputFile;
    private javax.swing.JButton startButtom;
    // End of variables declaration
}
