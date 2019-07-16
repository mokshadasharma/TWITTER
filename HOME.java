package twitter;

import java.awt.Color;
import java.awt.Dimension;
import twitter4j.Twitter;
import twitter4j.User;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.E;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.util.Timer;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import twitter4j.DirectMessage;

import twitter4j.GeoLocation;
import twitter4j.IDs;
import twitter4j.Relationship;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.TwitterException;
import twitter4j.api.DirectMessagesResources;

public class HOME extends javax.swing.JFrame {

    Twitter twitter;
    BufferedImage b;
    File f;
    ArrayList<LocationAdapter> alLocation = new ArrayList<>();
    User user;
    User searchUser;
    String name;

    public HOME(Twitter twitter) {
        initComponents();
        this.twitter = twitter;
        Thread t3 = new Thread(new FetchProfile());
        t3.start();
        setSize(700, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

    class FetchProfile implements Runnable {

        @Override
        public void run() {

            try {
                user = twitter.verifyCredentials();

                lbsn.setText(user.getScreenName());
                lbun.setText(user.getName());
                lbfo.setText("Foll : " + user.getFollowersCount());
                lbfr.setText("Frnds: " + user.getFriendsCount());
                lbdt.setText("Date : " + user.getCreatedAt().toString());
                String url = user.getProfileImageURL();
                System.out.println(url);
                b = ImageIO.read(new URL(url));
                BufferedImage resizedPicture = resize(b, lbpr.getWidth(), lbpr.getHeight());
                lbpr.setIcon(new ImageIcon(resizedPicture));
                generateTask();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbap = new javax.swing.JLabel();
        lbpr = new javax.swing.JLabel();
        lbun = new javax.swing.JLabel();
        lbsn = new javax.swing.JLabel();
        lbfr = new javax.swing.JLabel();
        lbfo = new javax.swing.JLabel();
        lbdt = new javax.swing.JLabel();
        btup = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jp2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        mainpanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        lbap.setText("                AGAM_AS");
        jPanel1.add(lbap);
        lbap.setBounds(10, 10, 160, 30);

        lbpr.setText("profile");
        jPanel1.add(lbpr);
        lbpr.setBounds(850, 0, 160, 100);

        lbun.setText("jLabel3");
        jPanel1.add(lbun);
        lbun.setBounds(370, 0, 114, 14);

        lbsn.setText("jLabel4");
        jPanel1.add(lbsn);
        lbsn.setBounds(370, 20, 150, 14);

        lbfr.setBackground(new java.awt.Color(204, 204, 204));
        lbfr.setText("FRIENDS");
        jPanel1.add(lbfr);
        lbfr.setBounds(104, 60, 110, 20);

        lbfo.setBackground(new java.awt.Color(255, 51, 51));
        lbfo.setText("FOLLOWERS");
        jPanel1.add(lbfo);
        lbfo.setBounds(360, 60, 110, 20);

        lbdt.setBackground(new java.awt.Color(204, 204, 204));
        lbdt.setText("DATE");
        jPanel1.add(lbdt);
        lbdt.setBounds(660, 60, 130, 20);

        btup.setText("UPLOAD");
        btup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btupActionPerformed(evt);
            }
        });
        jPanel1.add(btup);
        btup.setBounds(853, 100, 110, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1020, 130);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(255, 153, 51));

        jLabel1.setText("POST A TWEET");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel2.add(jPanel4);
        jPanel4.setBounds(10, 10, 180, 30);

        jp2.setBackground(new java.awt.Color(51, 51, 255));
        jp2.setLayout(null);

        jLabel2.setText("PROFILE");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jp2.add(jLabel2);
        jLabel2.setBounds(10, 11, 160, 14);

        jPanel2.add(jp2);
        jp2.setBounds(10, 45, 180, 40);

        jPanel6.setBackground(new java.awt.Color(0, 255, 51));

        jLabel3.setText("HOME");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jPanel2.add(jPanel6);
        jPanel6.setBounds(10, 92, 180, 40);

        jPanel7.setBackground(new java.awt.Color(0, 153, 255));

        jLabel4.setText("      SEARCH");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel7);
        jPanel7.setBounds(10, 138, 180, 40);

        jPanel8.setBackground(new java.awt.Color(255, 102, 102));
        jPanel8.setLayout(null);

        jLabel5.setText("SCHEDULE");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel5);
        jLabel5.setBounds(10, 11, 147, 14);

        jPanel2.add(jPanel8);
        jPanel8.setBounds(10, 183, 180, 40);

        jPanel9.setBackground(new java.awt.Color(102, 255, 255));
        jPanel9.setLayout(null);

        jLabel6.setText("DM");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel6);
        jLabel6.setBounds(10, 10, 150, 20);

        jPanel2.add(jPanel9);
        jPanel9.setBounds(10, 230, 180, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 140, 200, 500);

        mainpanel.setBackground(new java.awt.Color(204, 255, 0));
        mainpanel.setLayout(null);
        getContentPane().add(mainpanel);
        mainpanel.setBounds(210, 140, 800, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        Tweet tt = new Tweet();
        mainpanel.removeAll();

        tt.jTextArea1.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                int max = 256;
                int c = tt.jTextArea1.getText().length();
                int count = 256 - c;
                tt.lbtext.setText(count + " remmaining");
                if (count < 0) {
                    tt.btpo.setEnabled(false);
                } else {
                    tt.btpo.setEnabled(true);
                }
            }

        });
        tt.btpo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tt.jTextArea1.getText().equals("")) {
                    JOptionPane.showMessageDialog(HOME.this, "empty tweet!!!!");
                } else {
                    Thread t4 = new Thread(new tweetjob(tt.jTextArea1.getText()));
                    t4.start();
                    JOptionPane.showMessageDialog(HOME.this, "!!successfully updated");
                }
            }
        });
        BufferedImage resizedPic = resize(b, tt.lbpr.getWidth(), tt.lbpr.getHeight());
        tt.lbpr.setIcon(new ImageIcon(resizedPic));

        tt.jta1.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                int max = 256;
                int c = tt.jta1.getText().length();
                int count = 256 - c;
                tt.lbcon.setText(count + " remmaining");
                if (count < 0) {
                    tt.btpo1.setEnabled(false);
                } else {
                    tt.btpo1.setEnabled(true);
                }
            }

        });
        tt.btbr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser jfc = new JFileChooser();
                int a = jfc.showOpenDialog(HOME.this);
                if (a == JFileChooser.APPROVE_OPTION) {
                    try {
                        f = jfc.getSelectedFile();
                        tt.jtf2.setText(f.getPath());
                        BufferedImage bimg = ImageIO.read(f);
                        BufferedImage resize = resize(bimg, tt.lbsa.getWidth(), tt.lbsa.getHeight());
                        tt.lbsa.setIcon(new ImageIcon(resize));
                        tt.lbsa.repaint();
                    } catch (IOException ex) {
                        Logger.getLogger(HOME.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
        tt.btpo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tt.jta1.getText().equals("")) {
                    JOptionPane.showMessageDialog(HOME.this, "empty tweet!!!!");
                } else {
                    StatusUpdate statusUpdate = new StatusUpdate(tt.jta1.getText());
                    if (f != null) {
                        statusUpdate.setMedia(f);

                    }
                    Thread t4 = new Thread(new postphoto(statusUpdate));
                    t4.start();

                }
            }
        });
        tt.setSize(mainpanel.getWidth(), mainpanel.getHeight());
        tt.lbpr1.setIcon(new ImageIcon(resizedPic));

        GeoLocation g = new GeoLocation(31.6340, 74.8723);
        LocationAdapter l = new LocationAdapter("AMRITSAR", g);
        alLocation.add(l);

        g = new GeoLocation(31.3260, 75.5762);
        l = new LocationAdapter("JALANDHAR", g);
        alLocation.add(l);

        g = new GeoLocation(30.9010, 75.8573);
        l = new LocationAdapter("LUDHIANA", g);
        alLocation.add(l);
        g = new GeoLocation(28.7041, 77.1025);
        l = new LocationAdapter("DELHI", g);
        alLocation.add(l);
        g = new GeoLocation(19.0760, 72.8777);
        l = new LocationAdapter("MUMBAI", g);
        alLocation.add(l);
        for (int i = 0; i < alLocation.size(); i++) {
            LocationAdapter obj = alLocation.get(i);
            tt.jcb.addItem(obj.name);
        }

        tt.btpo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tt.jta2.getText().equals("")) {
                    JOptionPane.showMessageDialog(HOME.this, "empty tweet!!!!");
                } else {
                    int index = tt.jcb.getSelectedIndex();
                    GeoLocation g = alLocation.get(index).geolocation;
                    StatusUpdate statusUpdate = new StatusUpdate(tt.jta2.getText());
                    statusUpdate.setLocation(g);
                    Thread t5 = new Thread(new postphoto(statusUpdate));
                    t5.start();

                }
            }

        });

        resizedPic = resize(b, tt.lbpr2.getWidth(), tt.lbpr2.getHeight());
        tt.lbpr2.setIcon(new ImageIcon(resizedPic));

        mainpanel.add(tt);
        mainpanel.repaint();

    }//GEN-LAST:event_jLabel1MouseClicked

    private void btupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btupActionPerformed
        JFileChooser jfc = new JFileChooser();
        int a = jfc.showOpenDialog(HOME.this);
        if (a == JFileChooser.APPROVE_OPTION) {
            try {
                f = jfc.getSelectedFile();

                twitter.updateProfileImage(f);
                JOptionPane.showMessageDialog(HOME.this, "UPDATED SUCCESSFULLY");
            } catch (Exception ex) {
                Logger.getLogger(HOME.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_btupActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        mainpanel.removeAll();
        mainpanel.repaint();
        ProfilePanel pp = new ProfilePanel();
        //pp.setSize(mainpanel.getWidth() - 20, mainpanel.getHeight() - 20);
        pp.setBounds(0, 0, mainpanel.getWidth(), mainpanel.getHeight());
        try {
            IDs ids = twitter.getFollowersIDs(-1);
            long followersid[] = ids.getIDs();
            pp.p1.setPreferredSize(new Dimension(300, 120 * followersid.length));
            int y = 10;
            for (int i = 0; i < followersid.length; i++) {
                User u = twitter.showUser(followersid[i]);
                String url = u.getProfileImageURL();
                String name = u.getScreenName();
                SingleUserProfile sup = new SingleUserProfile();
                sup.setBounds(10, y, 300, 100);
                y = y + 120;
                BufferedImage b1 = ImageIO.read(new URL(url));
                BufferedImage resized = resize(b1, sup.lbpic.getWidth(), sup.lbpic.getHeight());
                sup.lbpic.setIcon(new ImageIcon(resized));
                sup.lbname.setText("@" + name);
                pp.p1.add(sup);
                System.out.println("run successfully" + name);
            }
            pp.p1.repaint();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            IDs ids = twitter.getFriendsIDs(-1);
            long friendsid[] = ids.getIDs();
            pp.p2.setPreferredSize(new Dimension(300, 120 * friendsid.length));
            int y = 10;
            for (int i = 0; i < friendsid.length; i++) {
                User u = twitter.showUser(friendsid[i]);
                String url = u.getProfileImageURL();
                String name = u.getScreenName();
                SingleUserProfile sup = new SingleUserProfile();
                sup.setBounds(10, y, 300, 100);
                y = y + 120;
                BufferedImage b1 = ImageIO.read(new URL(url));
                BufferedImage resized = resize(b1, sup.lbpic.getWidth(), sup.lbpic.getHeight());
                sup.lbpic.setIcon(new ImageIcon(resized));
                sup.lbname.setText("@" + name);
                pp.p2.add(sup);
                System.out.println("run successfully" + name);
            }
            pp.p2.repaint();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        mainpanel.add(pp);
        setSize(getSize().width - 1, getSize().height - 1);
        setSize(getSize().width, getSize().height);


    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        Thread t5 = new Thread(new Search());
        t5.start();


    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        Thread t6 = new Thread(new Home());
        t6.start();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        Thread t7 = new Thread(new Schedule());
        t7.start();

    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        Thread t = new Thread(new DM());
        t.start();
    }//GEN-LAST:event_jLabel6MouseClicked
    class DM implements Runnable {

        @Override
        public void run() {
            mainpanel.removeAll();
            DMPanel dmp = new DMPanel();
            dmp.setSize(mainpanel.getWidth(), mainpanel.getHeight());
            DirectMessagesResources dmr = twitter.directMessages();
            HashSet<Long> hset = new HashSet<Long>();

            try {
                ResponseList<DirectMessage> reList = dmr.getDirectMessages();
                for (DirectMessage d : reList) {
                    hset.add(d.getSenderId());
                }
                ResponseList<DirectMessage> sentList = dmr.getSentDirectMessages();
                for (DirectMessage d : sentList) {
                    hset.add(d.getRecipientId());
                }
                dmp.pa1.setPreferredSize(new Dimension(dmp.pa1.getWidth(), hset.size() * 94));
                int y = 10;
                for (long l : hset) {
                    User dmuser = twitter.showUser(l);
                    SingleDMPanel sdmp = new SingleDMPanel();
                    sdmp.setBounds(10, y, 408, 94);
                    y = y + 94;
                    sdmp.lb1.setText(dmuser.getName());
                    String url = dmuser.getProfileImageURL();
                    BufferedImage img = ImageIO.read(new URL(url));
                    BufferedImage resized = resize(img, sdmp.lbpr.getWidth(), sdmp.lbpr.getHeight());
                    sdmp.lbpr.setIcon(new ImageIcon(resized));
                    System.out.println("generated");
                    sdmp.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            System.out.println("clicked");
                            new DirectMessageUserFrame(twitter, l).setVisible(true);
                        }

                    });
                    dmp.pa1.add(sdmp);
                    dmp.pa1.repaint();

                }
                mainpanel.add(dmp);
                mainpanel.repaint();
                setSize(getWidth()+1,getHeight()+1);
            } catch (Exception ex) {
                Logger.getLogger(HOME.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    class Schedule implements Runnable {

        @Override
        public void run() {
            try {
                mainpanel.removeAll();
                ScheduleTweetPanel stp = new ScheduleTweetPanel();
                stp.setSize(mainpanel.getWidth(), mainpanel.getHeight());
                BufferedImage resized = resize(b, stp.lbpr.getWidth(), stp.lbpr.getHeight());
                stp.lbpr.setIcon(new ImageIcon(resized));

                mainpanel.add(stp);
                stp.btsch.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String text = stp.jTextArea1.getText().trim();
                        if (!text.equals("")) {
                            Calendar c = Calendar.getInstance();
                            int hr = (Integer.parseInt((String) stp.cbhr.getSelectedItem()));
                            int min = (Integer.parseInt((String) stp.cbmin.getSelectedItem()));
                            c.set(Calendar.HOUR_OF_DAY, hr);
                            c.set(Calendar.MINUTE, min);
                            Calendar presentTime = Calendar.getInstance();
                            if (presentTime.compareTo(c) < 0) {
                                try {
                                    ResultSet resultSet = jdbc_add.executeQuery("Select * from schedule");
                                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                    String date = df.format(c.getTime());
                                    String id = String.valueOf(user.getId());
                                    resultSet.moveToInsertRow();
                                    resultSet.updateString("Text", text);
                                    resultSet.updateString("Time", date);
                                    resultSet.updateString("SenderID", id);
                                    System.out.println(text);
                                    System.out.println(date);
                                    System.out.println(id);
                                    resultSet.insertRow();
                                    generateTask();
                                    JOptionPane.showMessageDialog(rootPane, "Scheduled data inserted in database");

                                } catch (SQLException ex) {
                                    Logger.getLogger(HOME.class.getName()).log(Level.SEVERE, null, ex);
                                }

                            }
                        }
                    }
                });

                mainpanel.repaint();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    class Home implements Runnable {

        @Override
        public void run() {
            try {
                mainpanel.removeAll();
                HomeTweetPanel htp = new HomeTweetPanel();
                htp.setSize(mainpanel.getWidth(), mainpanel.getHeight());
                mainpanel.add(htp);

                twitter.getHomeTimeline();
                String name = htp.getName();
                searchUser = twitter.showUser(name);
                ResponseList<Status> list = twitter.getUserTimeline(name);
                String url = searchUser.getProfileImageURL();
                BufferedImage img = ImageIO.read(new URL(url));
                SingleUseTweet sut[] = new SingleUseTweet[list.size()];
                int y = 10;
                htp.setPreferredSize(new Dimension(htp.getWidth(), 150 * list.size()));
                for (int i = 0; i < list.size(); i++) {
                    sut[i] = new SingleUseTweet();
                    sut[i].setBounds(10, y, 302, 64);
                    y = y + 140;
                    Status st = list.get(i);
                    sut[i].lb2.setText(st.getText());
                    BufferedImage resized = resize(img, sut[i].lb1.getWidth(), sut[i].lb1.getHeight());
                    sut[i].lb1.setIcon(new ImageIcon(resized));
                    htp.add(sut[i]);
                }
                htp.repaint();

            } catch (Exception ex) {
                Logger.getLogger(HOME.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    class Search implements Runnable {

        @Override
        public void run() {
            mainpanel.removeAll();

            SingleSerchPanel ssp = new SingleSerchPanel();
            ssp.setSize(mainpanel.getWidth(), mainpanel.getHeight());
            mainpanel.add(ssp);
            ssp.btsc2.setEnabled(false);
            ssp.btsc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        name = ssp.tfsc.getText();
                        searchUser = twitter.showUser(name);

                        ResponseList<Status> list = twitter.getUserTimeline(name);
                        String url = searchUser.getProfileImageURL();
                        BufferedImage img = ImageIO.read(new URL(url));
                        SingleUseTweet sut[] = new SingleUseTweet[list.size()];
                        int y = 10;
                        ssp.pasc.setPreferredSize(new Dimension(ssp.pasc.getWidth(), 150 * list.size()));
                        for (int i = 0; i < list.size(); i++) {
                            sut[i] = new SingleUseTweet();
                            sut[i].setBounds(10, y, 382, 128);
                            y = y + 140;
                            Status st = list.get(i);
                            int c = st.getFavoriteCount();
                            sut[i].lbfav.setText(c + "");
                            int d = st.getRetweetCount();
                            sut[i].lbtw.setText(d + "");
                            boolean isfav = st.isFavorited();
                            int j = i;

                            if (isfav) {
                                sut[i].btfav.setText("unfav");
                            } else {
                                sut[i].btfav.setText("fav");
                            }
                            sut[i].btfav.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    try {
                                        if (isfav) {
                                            JOptionPane.showMessageDialog(HOME.this, "do u wan to");
                                            twitter.destroyFavorite(st.getId());
                                            sut[j].btfav.setText("Favourite");
                                            JOptionPane.showMessageDialog(HOME.this, "destroied");
                                        } else {
                                            JOptionPane.showMessageDialog(HOME.this, "do u wan to");
                                            twitter.createFavorite(st.getId());
                                            sut[j].btfav.setText("Unfavourite");
                                            JOptionPane.showMessageDialog(HOME.this, "created");
                                        }
                                        new Thread(new Search()).start();

                                    } catch (TwitterException ex) {
                                        Logger.getLogger(HOME.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }

                            });

                            sut[i].lb2.setText(st.getText());
                            BufferedImage resized = resize(img, sut[i].lb1.getWidth(), sut[i].lb1.getHeight());
                            sut[i].lb1.setIcon(new ImageIcon(resized));
                            sut[i].addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    String t = JOptionPane.showInputDialog("COMMENT");
                                    if (!t.equals("")) {
                                        StatusUpdate su = new StatusUpdate(" @" + searchUser.getScreenName() + " " + t);
                                        su.inReplyToStatusId(list.get(j).getId());
                                        try {
                                            twitter.updateStatus(su);
                                            JOptionPane.showMessageDialog(HOME.this, "success");
                                        } catch (TwitterException ex) {
                                            Logger.getLogger(HOME.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                    }
                                }

                            }
                            );
                            ssp.pasc.add(sut[i]);
                            ssp.pasc.repaint();

                        }

                        System.out.println(name);
                        System.out.println(list.size());
                        Relationship relation = twitter.showFriendship(user.getId(), searchUser.getId());
                        ssp.btsc2.setEnabled(true);
                        boolean result = relation.isSourceFollowingTarget();
                        if (result) {
                            ssp.btsc2.setText("unFollow");
                        } else {
                            ssp.btsc2.setText("Follow");
                        }
                        ssp.btsc2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    if (result == true) {
                                        twitter.destroyFriendship(searchUser.getId());
                                        JOptionPane.showMessageDialog(HOME.this, "succesfully unfollowed");
                                        ssp.btsc2.setText("follow");
                                    } else {
                                        twitter.createFriendship(searchUser.getId());
                                        JOptionPane.showMessageDialog(HOME.this, "succesfully followed");
                                        ssp.btsc2.setText("unfollow");
                                    }
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }
                        });
                        ssp.btdm.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String msg = JOptionPane.showInputDialog("enter message");
                                if (msg != null) {
                                    try {
                                        twitter.sendDirectMessage(searchUser.getId(), msg);
                                        JOptionPane.showMessageDialog(HOME.this, "send");
                                    } catch (TwitterException ex) {
                                        Logger.getLogger(HOME.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                        });
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            });
            mainpanel.repaint();

        }

    }

    class tweetjob implements Runnable {

        String text;

        public tweetjob(String text) {
            this.text = text;
        }

        @Override
        public void run() {
            try {
                StatusUpdate su = new StatusUpdate(text);
                twitter.updateStatus(su);
                JOptionPane.showMessageDialog(HOME.this, "posted");
            } catch (TwitterException ex) {
                ex.printStackTrace();
            }
        }

    }

    class postphoto implements Runnable {

        StatusUpdate statusUpdate;

        public postphoto(StatusUpdate statusUpdate) {
            this.statusUpdate = statusUpdate;
        }

        @Override
        public void run() {
            try {
                twitter.updateStatus(statusUpdate);
                JOptionPane.showMessageDialog(HOME.this, "posted");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(HOME.this, "fialed");
                ex.printStackTrace();
            }
        }

    }

    void generateTask() {
        Calendar c = Calendar.getInstance();
        ResultSet resultSet = jdbc_add.executeQuery("Select * from Schedule where SenderID ='" + user.getId() + "' ");
        try {
            while (resultSet.next()) {

                String date = resultSet.getString("Time");
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date scheduledate = df.parse(date);
                if (scheduledate.after(c.getTime())) {
                    String text = resultSet.getString("Text");
                    StatusUpdate st = new StatusUpdate(text);
                    Timer t = new Timer();
                    System.out.println("scheduled");
                    t.schedule(new TweetTask(st), scheduledate);

                }
            }
        } catch (Exception ex) {
            Logger.getLogger(HOME.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    class TweetTask extends TimerTask {

        StatusUpdate s;

        TweetTask(StatusUpdate s) {
            this.s = s;
        }

        @Override
        public void run() {
            try {
                twitter.updateStatus(s);
                JOptionPane.showMessageDialog(rootPane, "successfully");

            } catch (Exception e) {
            }
        }

    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new HOME().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    public javax.swing.JPanel jPanel8;
    public javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jp2;
    private javax.swing.JLabel lbap;
    private javax.swing.JLabel lbdt;
    private javax.swing.JLabel lbfo;
    private javax.swing.JLabel lbfr;
    private javax.swing.JLabel lbpr;
    private javax.swing.JLabel lbsn;
    private javax.swing.JLabel lbun;
    private javax.swing.JPanel mainpanel;
    // End of variables declaration//GEN-END:variables
}
