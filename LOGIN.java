package twitter;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class LOGIN extends javax.swing.JFrame {

    ArrayList<user> userlist = new ArrayList<>();
    Twitter twitter = TwitterFactory.getSingleton();
    

    public LOGIN() {
        initComponents();
        setTitle("twitter");
        setSize(700, 500);
        setVisible(true);
        twitter.setOAuthConsumer("DUJrzlrT3HhGnO15zh8bJorf2", "g4E0ZmyeMs2PTp5VekCwmC0lmcm8hGRJdwhtfoF2ikveMv8AxX");
        jPanel1.setBackground(Color.BLUE);
        Thread t2 = new Thread(new fetchaccounts());
        t2.start();
        setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("twitter");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(157, 11, 67, 14);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(null);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(39, 59, 390, 326);

        jButton1.setText("add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(440, 60, 90, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Thread t = new Thread(new Job());
        t.start();

    }//GEN-LAST:event_jButton1ActionPerformed

    class Job implements Runnable {

        @Override
        public void run() {

            try {
                RequestToken requestToken = twitter.getOAuthRequestToken();
                String url = requestToken.getAuthorizationURL();
                System.out.println(url);

                Desktop.getDesktop().browse(new URI(url));
                // AccessToken accesstoken= twitter.getOAuthAccessToken(requestToken,dialog.pin);
                dialog dialog = new dialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.jButton1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String pin = dialog.jTextField1.getText();
                        if (pin.equals("")) {
                            JOptionPane.showMessageDialog(rootPane, "fill fields");
                        } else {

                            dialog.dispose();
                            try {
                                AccessToken accesstoken = twitter.getOAuthAccessToken(requestToken, pin);
                                System.out.println(accesstoken.getToken());
                                System.out.println(accesstoken.getTokenSecret());
                                System.out.println(accesstoken.getUserId());
                                ResultSet resultSet = jdbc_add.executeQuery("select * from user where userid='" + accesstoken.getUserId() + "'");
                                if (resultSet.next()) {
                                    JOptionPane.showMessageDialog(LOGIN.this, "!!!already present!!!");
                                }
                                else {
                                    resultSet.moveToInsertRow();
                                    resultSet.updateString("username", accesstoken.getScreenName());
                                    resultSet.updateString("accesstoken", accesstoken.getToken());
                                    resultSet.updateString("accesstokensecret", accesstoken.getTokenSecret());
                                    resultSet.updateString("userid", accesstoken.getUserId() + "");
                                    resultSet.insertRow();
                                    Thread t2 = new Thread(new fetchaccounts());
                                    t2.start();
                                }
                                //accesstoken.getToken();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }

                    }
                });
                dialog.setVisible(true);

            } catch (Exception ex) {
                System.out.println("Exception Class" + ex.getClass() + "Exception Message " + ex.getMessage());
            }
        }

    }

    class user {

        int id;
        String userid, username, accessToken, accessTokensecret;
        //constructor

        public user(int id, String userid, String username, String accessToken, String accessTokenSercert) {
            this.id = id;
            this.userid = userid;
            this.username = username;
            this.accessToken = accessToken;
            this.accessTokensecret = accessTokenSercert;

        }
    }

    public class fetchaccounts implements Runnable {

        @Override
        public void run() {
            try {
                userlist.clear();
                jPanel1.removeAll();
                jPanel1.repaint();
                ResultSet resultSet = jdbc_add.executeQuery("select * from user");
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String userid = resultSet.getString("userid");
                    String username = resultSet.getString("username");
                    String accesstoken = resultSet.getString("accessToken");
                    String accessTkenSecret = resultSet.getString("accessTokenSecret");
                    user obj = new user(id, userid, username, accesstoken, accessTkenSecret);

                    userlist.add(obj);

                    for (int i = 0; i < userlist.size(); i++) {
                        singleloginpanel slp = new singleloginpanel();
                        slp.setBounds(10, 10 + i * 70, 337, 70);
                        user user = userlist.get(i);
                        slp.bt.setText("@" + user.username);
                        jPanel1.add(slp);
                        slp.bt.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                twitter.setOAuthAccessToken(new AccessToken(user.accessToken, user.accessTokensecret));
                                new HOME(twitter).setVisible(true);
                            }
                        });
                        slp.jLabel1.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                try {
                                    String screenName=obj.username;
                                    ResultSet rs=jdbc_add.executeQuery("select * from user where username='"+screenName+"'");
                                    if(rs.next())
                                    {
                                        rs.deleteRow();
                                        new Thread(new fetchaccounts()).start();
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(LOGIN.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                
                        });
                        jPanel1.repaint();
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(LOGIN.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(userlist.size());

        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LOGIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
