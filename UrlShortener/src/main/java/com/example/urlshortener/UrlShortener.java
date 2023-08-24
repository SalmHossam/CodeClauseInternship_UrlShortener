package com.example.urlshortener;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import javax.swing.*;

public class UrlShortener {

    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JLabel jLabel;
    private JTextField logURLField;
    private JTextField shortURLField;
    private JButton button;
    private String LongURL;
    private String ShortURL;
    public UrlShortener(){
        frame=new JFrame("Shorten URL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1024,150));
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);

        panel=new JPanel();
        label=new JLabel("Enter Long URL to Shorten it :");
        logURLField=new JTextField(25);
        button=new JButton("Shorten");
        button.addActionListener(new GeneratedButtonActionListener());
        jLabel= new JLabel("Shorter URL:");
        shortURLField = new JTextField(25);
        GridLayout Layout=new GridLayout(2,1);
        Layout.setVgap(5);
        Layout.setHgap(5);
        panel.setLayout(Layout);

        panel.add(label);
        panel.add(logURLField);
        panel.add(button);
        panel.add(jLabel);
        panel.add(shortURLField);
        frame.add(panel);
        frame.setVisible(true);

    }


    private class GeneratedButtonActionListener implements ActionListener {
        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
          LongURL=logURLField.getText();
          try{
              URL url = new URL("http://tinyurl.com/api-create.php?url=" + LongURL);
              HttpURLConnection connection = (HttpURLConnection) url.openConnection();
              connection.setRequestMethod("GET");

              BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
              ShortURL = in.readLine();
              in.close();
              shortURLField.setText(ShortURL);
              shortURLField.setEditable(false);


          } catch (IOException ex) {
              ex.printStackTrace();
          }
        }
    }
}