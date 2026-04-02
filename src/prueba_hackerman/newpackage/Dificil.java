/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package prueba_hackerman.newpackage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import static prueba_hackerman.newpackage.Medio.ImprimeArr;

/**
 *
 * @author canod
 */
public class Dificil extends javax.swing.JFrame {
    Random random = new Random();
    Timer time;
    int Secreto = (int) random.nextInt(9000) + 1000;
    int Oportunidades = 13;
    int arr[] = new int[4];
    int arrA[] = new int[arr.length];
    ArrayList<Integer> OrdenPistas = new ArrayList<>();
    int Btn = 3;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Dificil.class.getName());

    public Dificil() {
        NumSecret();
        this.setLocationRelativeTo(null);
        initComponents();
        this.setLocationRelativeTo(null);
        
        Audio.iniciarMusicaFondo("/Sonidos/Musica_Dificil.wav");

        time = new Timer(1000, new ActionListener() {
            int Contador = 90;

            public void actionPerformed(ActionEvent e) {
                Contador--;
                STimer.setText(Contador + " ");
                if(Contador<=10 && Contador >0){
                    Audio.reproducirEfecto("/Sonidos/Beep.wav");
                }
                if (Contador == 0) {
                    time.stop();
                    Audio.detenerMusicaFondo();
                    Audio.reproducirEfecto("/Sonidos/Perder.wav");
                    Ejecutar1.setEnabled(false);
                    Perdiste perdiste = new Perdiste();
                    perdiste.setVisible(true);

                }
            }
        });
        STimer.setEditable(false);
        SOportunidades.setEditable(false);
        SPistas.setEditable(false);
        Tiempo.setEditable(false);

        STimer.setHorizontalAlignment(JTextField.CENTER);
        SOportunidades.setHorizontalAlignment(JTextField.CENTER);
        SPistas.setHorizontalAlignment(JTextField.CENTER);
        Tiempo.setHorizontalAlignment(JTextField.CENTER);
        BTN();
    }

    public void BTN() {
        Regresar2.setOpaque(false);
        Regresar2.setContentAreaFilled(false);
        Regresar2.setBorderPainted(false);
        Regresar2.setFocusPainted(false);

        Ejecutar1.setOpaque(false);
        Ejecutar1.setContentAreaFilled(false);
        Ejecutar1.setBorderPainted(false);
        Ejecutar1.setFocusPainted(false);

        BtnPista.setOpaque(false);
        BtnPista.setContentAreaFilled(false);
        BtnPista.setBorderPainted(false);
        BtnPista.setFocusPainted(false);
    }

    public void NumSecret() {
        System.out.println(Secreto);
        arr[3] = Secreto % 10;
        arr[2] = (Secreto / 10) % 10;
        arr[1] = (Secreto / 100) % 10;
        arr[0] = Secreto / 1000;

        OrdenPistas.clear();
        OrdenPistas.add(1);
        OrdenPistas.add(2);
        OrdenPistas.add(3);

        Collections.shuffle(OrdenPistas);
    }

    public void Imprimir() {
        for (int i = 0; i < arrA.length; i++) {
            System.out.print(arrA[i]);
        }
    }

    public void ArregloA(int A) {
        arrA[3] = A % 10;
        arrA[2] = (A / 10) % 10;
        arrA[1] = (A / 100) % 10;
        arrA[0] = A / 1000;
    }

    public void Dif() {
        try {
            int A = Integer.parseInt(ENumeros.getText());

            if (A < 1000 || A > 9999) {
                Audio.reproducirEfecto("/Sonidos/errores.wav");
                SPistas.setText("FORMATO INVALIDO: REQUIERE PUERTO DE 4 DIGITOS (1000-9999)");
                return;
            }

            ArregloA(A);
            time.start();
            Oportunidades--;
            SOportunidades.setText("INTENTOS RESTANTES: " + Oportunidades);
            int Correcto = 0;

            if (A == Secreto) {
                Audio.detenerMusicaFondo();
                Audio.reproducirEfecto("/Sonidos/Ganar.wav");
                SPistas.setText("|ACCESO AUTORIZADO SISTEMA VULNERADO|");
                time.stop();
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
                        SPistas.setText("Error 404: NINGUN DATO COINCIDE ");
                        break;
                    case 1:
                        SPistas.setText("RASTREO DE RED: SE HA LOCALIZADO 1 PUERTO VALIDO");
                        break;
                    case 2:
                        SPistas.setText("ALERTA: 2 PUERTOS VALIDOS");
                        break;
                    case 3:
                        SPistas.setText("ALERTA: 3 PUERTOS SON VALIDOS ");
                        break;
                    case 4:
                        SPistas.setText("LOS 4 PUERTOS SON VALIDOS PERO LA SECUENCIA ES INVALIDA");
                        break;
                }
                Correcto = 0;
                if (Oportunidades <= 0) {
                    time.stop();
                    Audio.detenerMusicaFondo();
                    Audio.reproducirEfecto("/Sonidos/Perder.wav");
                    SPistas.setText("SISTEMA BLOQUEADO");
                    SOportunidades.setText("|RASTREADO|");
                    SPistas.setForeground(Color.red);
                    SOportunidades.setForeground(Color.red);
                    Ejecutar1.setEnabled(false);
                    Perdiste perdiste = new Perdiste();
                    perdiste.setVisible(true);
                }

            }

        } catch (Exception e) {
            Audio.reproducirEfecto("/Sonidos/errores.wav");
            SPistas.setText("ERROR CRITICO: INGRESA SOLO NUMEROS");
            ENumeros.setText("");
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

        Regresar2 = new javax.swing.JButton();
        STimer = new javax.swing.JTextField();
        ENumeros = new javax.swing.JTextField();
        SPistas = new javax.swing.JTextField();
        Tiempo = new javax.swing.JTextField();
        Ejecutar1 = new javax.swing.JButton();
        BtnPista = new javax.swing.JButton();
        SOportunidades = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Regresar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Regresar2.addActionListener(this::Regresar2ActionPerformed);
        getContentPane().add(Regresar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 500, 230, 50));

        STimer.setBackground(new java.awt.Color(30, 0, 0));
        STimer.setFont(new java.awt.Font("VT323", 0, 36)); // NOI18N
        STimer.setForeground(new java.awt.Color(255, 30, 30));
        STimer.setBorder(null);
        getContentPane().add(STimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 221, 180, 30));

        ENumeros.setBackground(new java.awt.Color(30, 0, 0));
        ENumeros.setFont(new java.awt.Font("VT323", 0, 36)); // NOI18N
        ENumeros.setForeground(new java.awt.Color(255, 30, 30));
        ENumeros.setBorder(null);
        ENumeros.addActionListener(this::ENumerosActionPerformed);
        getContentPane().add(ENumeros, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 600, 40));

        SPistas.setBackground(new java.awt.Color(30, 0, 0));
        SPistas.setFont(new java.awt.Font("VT323", 0, 36)); // NOI18N
        SPistas.setForeground(new java.awt.Color(255, 30, 30));
        SPistas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 30, 30)));
        getContentPane().add(SPistas, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 810, 40));

        Tiempo.setBackground(new java.awt.Color(30, 0, 0));
        Tiempo.setFont(new java.awt.Font("VT323", 0, 36)); // NOI18N
        Tiempo.setForeground(new java.awt.Color(255, 30, 30));
        Tiempo.setText("EL TIEMPO RESTANTE ES:");
        Tiempo.setBorder(null);
        getContentPane().add(Tiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 320, 30));

        Ejecutar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Ejecutar1.addActionListener(this::Ejecutar1ActionPerformed);
        getContentPane().add(Ejecutar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 280, 170, 60));

        BtnPista.addActionListener(this::BtnPistaActionPerformed);
        getContentPane().add(BtnPista, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 410, 320, 50));

        SOportunidades.setBackground(new java.awt.Color(30, 0, 0));
        SOportunidades.setFont(new java.awt.Font("VT323", 0, 36)); // NOI18N
        SOportunidades.setForeground(new java.awt.Color(255, 30, 30));
        SOportunidades.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 30, 30)));
        getContentPane().add(SOportunidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 480, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenn/modo_dificil (1).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Regresar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Regresar2ActionPerformed
        Audio.detenerMusicaFondo();
        Audio.reproducirEfecto("/Sonidos/Boton.wav");
        Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Regresar2ActionPerformed

    private void Ejecutar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ejecutar1ActionPerformed
        Audio.reproducirEfecto("/Sonidos/Boton.wav");
        Dif();
    }//GEN-LAST:event_Ejecutar1ActionPerformed

    private void ENumerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ENumerosActionPerformed
        Ejecutar1.doClick();
    }//GEN-LAST:event_ENumerosActionPerformed

    private void BtnPistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPistaActionPerformed
        Audio.reproducirEfecto("/Sonidos/Pistass.wav");
        if (Oportunidades <= 1) {
            SPistas.setText("ERROR: SE REQUIEREN MINIMO 2 INTENTOS");
            return;
        }
        if (Btn <= 0) {
            BtnPista.setEnabled(false);
            JOptionPane.showMessageDialog(null, "SIN PISTAS DISPONIBLES");
            return;
        }
        Btn--;
        Oportunidades--;
        SOportunidades.setText("INTENTOS RESTANTES: " + Oportunidades);

        int Actual = OrdenPistas.remove(0);
        switch (Actual) {
            case 1://suma
                int Suma = arr[0] + arr[1] + arr[2] + arr[3];
                JOptionPane.showMessageDialog(null, "LA SUMA DE TODOS LOS DIGITOS ES: " + Suma);
                break;
            case 2://         
                try {

                    int Busca = Integer.parseInt(JOptionPane.showInputDialog(null, "IGRESA UN NUMERO A BUSCAR"));
                    boolean Bandera = false;
                    for (int i = 0; i < arr.length; i++) {
                        if (Busca == arr[i]) {
                            Bandera = true;
                            break;
                        }
                    }
                    if (Bandera) {
                        JOptionPane.showMessageDialog(null, "> [ESCÁNER]: VULNERABILIDAD.: " + Busca + " SÍ EXISTE.");
                    } else {
                        JOptionPane.showMessageDialog(null, "> [ESCÁNER]: VULNERABILIDAD.: " + Busca + " NO EXISTE.", "ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "ESCÁNER CANCELADO O FORMATO INVÁLIDO", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 3:
                if (arr[0] > arr[3]) {
                    JOptionPane.showMessageDialog(null, "EL PRIMER DIGITO ES MAYOR AL ULTIMO");
                } else if (arr[0] == arr[3]) {
                    JOptionPane.showMessageDialog(null, "EL PRIMER DIGITITO Y EL ULTIMO SON IGUALES");
                } else {
                    JOptionPane.showMessageDialog(null, "EL ULTIMO DIGITO ES MAYOR AL PRIMERO");
                }
                break;
        }
    }//GEN-LAST:event_BtnPistaActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new Dificil().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnPista;
    private javax.swing.JTextField ENumeros;
    private javax.swing.JButton Ejecutar1;
    private javax.swing.JButton Regresar2;
    private javax.swing.JTextField SOportunidades;
    private javax.swing.JTextField SPistas;
    private javax.swing.JTextField STimer;
    private javax.swing.JTextField Tiempo;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
