/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package prueba_hackerman.newpackage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author canod
 */
public class Medio extends javax.swing.JFrame {

    Random random = new Random();
    Timer time;
    int Secreto = (int) random.nextInt(900) + 100;
    int Oportunidades = 10;
    int arr[] = new int[3];
    int arrA[] = new int[arr.length];

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Medio.class.getName());

    /**
     * Creates new form NewJFrame
     */
    public Medio() {
        initComponents();
        this.setLocationRelativeTo(null);
        Audio.iniciarMusicaFondo("/Sonidos/musicaMedio.wav");
        
        NumSecreto();

        time = new Timer(1000, new ActionListener() {
            int Contador = 60;

            public void actionPerformed(ActionEvent e) {
                Contador--;
                SalidaContador.setText(Contador + " ");
                
                if(Contador <= 10 && Contador > 0){
                    Audio.reproducirEfecto("/Sonidos/beep.wav"); 
                    SalidaContador.setForeground(java.awt.Color.RED);
                }
                
                if (Contador == 0) {
                    time.stop();
                    Audio.detenerMusicaFondo();
                    Audio.reproducirEfecto("/Sonidos/perder.wav");
                    Ejecutar1.setEnabled(false);
                    Perdiste perdiste = new Perdiste();
                    perdiste.setVisible(true);

                }
            }
        });
        SalidaContador.setEditable(false);
        SalidaOportunidades1.setEditable(false);
        SalidaPistas.setEditable(false);
        TPRestante.setEditable(false);

        SalidaContador.setHorizontalAlignment(JTextField.CENTER);
        SalidaOportunidades1.setHorizontalAlignment(JTextField.CENTER);
        SalidaPistas.setHorizontalAlignment(JTextField.CENTER);
        TPRestante.setHorizontalAlignment(JTextField.CENTER);
    }

    private void NumSecreto() {
        System.out.println(Secreto);
        arr[2] = Secreto % 10;
        arr[1] = (Secreto / 10) % 10;
        arr[0] = Secreto / 100;
        ImprimeArr(arr);
    }

    public static void ImprimeArr(int arr[]) {
        for (int i = 0; i < 3; i++) {
            System.out.print(arr[i]);
        }
    }

    public void ArregloA(int A) {
        arrA[2] = A % 10;
        arrA[1] = (A / 10) % 10;
        arrA[0] = A / 100;
    }

    public void Med() {
        try {
            System.out.println(Secreto);
            int A = Integer.parseInt(EntradaNumeros.getText());
            
            if(A<100 || A>999){
                SalidaPistas.setText("FORMATO INVALIDO: REQUIERE PUERTO DE 3 DIGITOS (100-999)");
                Audio.reproducirEfecto("/Sonidos/errores.wav");
                return;
            }
            
            ArregloA(A);
            
            Oportunidades--;
            SalidaOportunidades1.setText("INTENTOS RESTANTES: " + Oportunidades);
            int Correcto = 0;
            time.start();    

            if (A == Secreto) {
                SalidaPistas.setText("|ACCESO AUTORIZADO SISTEMA VULNERADO|");
                time.stop();
                Audio.detenerMusicaFondo();
                Audio.reproducirEfecto("/Sonidos/Ganar.wav");
                Ejecutar1.setEnabled(false);
                Ganaste ganaste = new Ganaste();
                ganaste.setVisible(true);

            } else {
                boolean Check[] = new boolean[arr.length];

                for (int k = 0; k < arr.length; k++) {
                    for (int j = 0; j < arrA.length; j++) {
                        if (arr[k] == arrA[j] && !Check[j]) {
                            Correcto++;
                            Check[j] = true;
                            break;
                        }
                    }

                }
                switch (Correcto) {
                    case 0:
                        SalidaPistas.setText("Error 404: NINGUN DATO COINCIDE ");
                        break;
                    case 1:
                        SalidaPistas.setText("RASTREO DE RED: SE HA LOCALIZADO 1 PUERTO VALIDO");
                        break;
                    case 2:
                        SalidaPistas.setText("ALERTA: 2 PUERTOS VALIDOS");
                        break;
                    case 3:
                        SalidaPistas.setText("ANOMALIA: LOS 3 PUERTOS SON VALIDOS PERO LA SECUENCIA ES INVALIDA");
                        break;
                }
                Correcto = 0;
                if (Oportunidades <= 0) {
                    time.stop();
                    Audio.detenerMusicaFondo();
                    Audio.reproducirEfecto("/Sonidos/perder.wav");
                    SalidaPistas.setText("SISTEMA BLOQUEADO");
                    SalidaOportunidades1.setText("|RASTREADO|");
                    SalidaPistas.setForeground(Color.red);
                    SalidaOportunidades1.setForeground(Color.red);
                    Ejecutar1.setEnabled(false);
                    Perdiste perdiste = new Perdiste();
                    perdiste.setVisible(true);
                }

            }
        } catch (Exception e) {
            Audio.reproducirEfecto("/Sonidos/perder.wav");
            SalidaPistas.setText("ERROR CRITICO: INGRESA SOLO NUMEROS");
            EntradaNumeros.setText("");
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

        jPanel1 = new javax.swing.JPanel();
        Back = new javax.swing.JButton();
        Ejecutar1 = new javax.swing.JButton();
        SalidaContador = new javax.swing.JTextField();
        TPRestante = new javax.swing.JTextField();
        SalidaPistas = new javax.swing.JTextField();
        EntradaNumeros = new javax.swing.JTextField();
        SalidaOportunidades1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Back.setBackground(new java.awt.Color(100, 60, 0));
        Back.setFont(new java.awt.Font("VT323", 2, 36)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 170, 0));
        Back.setText("R E G R E S A R");
        Back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Back.addActionListener(this::BackActionPerformed);
        jPanel1.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 560, 320, -1));

        Ejecutar1.setBackground(new java.awt.Color(100, 60, 0));
        Ejecutar1.setForeground(new java.awt.Color(255, 170, 0));
        Ejecutar1.setText("EJECUTAR");
        Ejecutar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Ejecutar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Ejecutar1.addActionListener(this::Ejecutar1ActionPerformed);
        jPanel1.add(Ejecutar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(838, 300, 140, -1));

        SalidaContador.setBackground(new java.awt.Color(0, 0, 0));
        SalidaContador.setFont(new java.awt.Font("VT323", 0, 48)); // NOI18N
        SalidaContador.setForeground(new java.awt.Color(255, 170, 0));
        SalidaContador.setBorder(null);
        SalidaContador.addActionListener(this::SalidaContadorActionPerformed);
        jPanel1.add(SalidaContador, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 220, 100, 30));

        TPRestante.setBackground(new java.awt.Color(0, 0, 0));
        TPRestante.setFont(new java.awt.Font("VT323", 0, 36)); // NOI18N
        TPRestante.setForeground(new java.awt.Color(255, 170, 0));
        TPRestante.setText("TIEMPO RESTANTE ");
        TPRestante.setBorder(null);
        TPRestante.addActionListener(this::TPRestanteActionPerformed);
        jPanel1.add(TPRestante, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 220, 30));

        SalidaPistas.setBackground(new java.awt.Color(0, 0, 0));
        SalidaPistas.setFont(new java.awt.Font("VT323", 0, 36)); // NOI18N
        SalidaPistas.setForeground(new java.awt.Color(255, 170, 0));
        SalidaPistas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 110, 0)));
        SalidaPistas.addActionListener(this::SalidaPistasActionPerformed);
        jPanel1.add(SalidaPistas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 820, 40));

        EntradaNumeros.setBackground(new java.awt.Color(0, 0, 0));
        EntradaNumeros.setFont(new java.awt.Font("VT323", 0, 48)); // NOI18N
        EntradaNumeros.setForeground(new java.awt.Color(255, 170, 0));
        EntradaNumeros.setBorder(null);
        EntradaNumeros.addActionListener(this::EntradaNumerosActionPerformed);
        jPanel1.add(EntradaNumeros, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 760, 40));

        SalidaOportunidades1.setBackground(new java.awt.Color(0, 0, 0));
        SalidaOportunidades1.setFont(new java.awt.Font("VT323", 0, 36)); // NOI18N
        SalidaOportunidades1.setForeground(new java.awt.Color(255, 170, 0));
        SalidaOportunidades1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 110, 0)));
        jPanel1.add(SalidaOportunidades1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 412, 820, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenn/modo_medio.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EntradaNumerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntradaNumerosActionPerformed
        Ejecutar1.doClick();
    }//GEN-LAST:event_EntradaNumerosActionPerformed

    private void TPRestanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TPRestanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TPRestanteActionPerformed

    private void SalidaContadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalidaContadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SalidaContadorActionPerformed

    private void SalidaPistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalidaPistasActionPerformed

    }//GEN-LAST:event_SalidaPistasActionPerformed

    private void Ejecutar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ejecutar1ActionPerformed
        Audio.reproducirEfecto("/Sonidos/Boton.wav");
        Med();
    }//GEN-LAST:event_Ejecutar1ActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        time.stop();
        Audio.detenerMusicaFondo();
        Audio.reproducirEfecto("/Sonidos/Boton.wav");
        Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Medio().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Ejecutar1;
    private javax.swing.JTextField EntradaNumeros;
    private javax.swing.JTextField SalidaContador;
    private javax.swing.JTextField SalidaOportunidades1;
    private javax.swing.JTextField SalidaPistas;
    private javax.swing.JTextField TPRestante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
