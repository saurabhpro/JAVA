package myeditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.*;


/**
 * Created by Saurabh on 8/8/2015.
 */
public class MyEditor implements ActionListener {
    /**
     * Invoked when an action occurs.
     *
     * @param e
     */


    JFrame jFrame;
    JLabel jLabel;
    JTextField jTextField;
    JTextArea jTextArea1, jTextArea2;

    JButton jButtonCompile, jButtonRun;
    JScrollPane jsbar1, jsbar2;

    Runtime r;

    String str = "";
    String fName = "";
    String result = "Nothing to Show Yet";

    MyEditor() {
        jFrame = new JFrame("My Editor 2.0");
        jFrame.setLayout(null);

        jLabel = new JLabel("Enter The File Name");
        jLabel.setBounds(50, 20, 130, 25);

        jTextField = new JTextField();
        jTextField.setBounds(180, 20, 230, 25);

        jTextArea1 = new JTextArea(50, 50);
        jTextArea1.setFont(new Font("Courier", Font.PLAIN, 15));
        jTextArea2 = new JTextArea(50, 50);
        jTextArea2.setFont(new Font("Courier", Font.PLAIN, 15));

        jTextArea1.addFocusListener(new MyFocusListener(this));
        jsbar1 = new JScrollPane(jTextArea1);
        jsbar2 = new JScrollPane(jTextArea2);
        jsbar1.setBounds(50, 60, 500, 150);
        jsbar2.setBounds(50, 270, 500, 150);

        jFrame.add(jsbar1);
        jFrame.add(jsbar2);


        jButtonCompile = new JButton("Compile");
        jButtonRun = new JButton("Run");
        jButtonCompile.setBounds(50, 230, 80, 25); //x y width height
        jButtonRun.setBounds(250, 230, 80, 25);


        jFrame.add(jLabel);
        jFrame.add(jTextField);

        r = Runtime.getRuntime();

        jFrame.add(jButtonCompile);
        jFrame.add(jButtonRun);
        jButtonCompile.addActionListener(this);
        jButtonRun.addActionListener(this);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(550, 550);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new MyEditor();
        System.out.println("Hey");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButtonCompile) {
            str = "";
            if (!jTextField.getText().equals("")) {

                try {
                    fName = jTextField.getText().trim() + ".java";
                    FileWriter fileWriter = null;

                    fileWriter = new FileWriter(fName);
                    String s1 = jTextArea1.getText();

                    PrintWriter printWriter = new PrintWriter(fileWriter);
                    printWriter.println(s1);
                    printWriter.flush();

                    java.lang.Process error;
                    if (isWindows()) {
                        error = r.exec("C:\\Program Files\\Java\\jdk1.8.0_51\\bin\\javac.exe -d . " + fName);

                        BufferedReader err = new BufferedReader(new InputStreamReader(error.getErrorStream()));

                        while (true) {
                            String temp = err.readLine();
                            if (temp != null) {
                                result += temp;
                                result += "\n";
                            } else
                                break;
                        }

                        if (result.equals("")) {
                            jTextArea2.setText("Compilation Successful " + fName);
                            err.close();
                        } else
                            jTextArea2.setText(result);
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } else
                jTextArea2.setText("Please Enter the java Program Name");
        } else if (e.getSource() == jButtonRun) {
            int start = 0;


            try {
                String fn = jTextField.getText().trim();
                Process p;
                if (isWindows()) {
                    p = r.exec("C:\\Program Files\\Java\\jdk1.8.0_51\\bin\\java " + fn);

                    BufferedReader output = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    BufferedReader error = new BufferedReader(new InputStreamReader(p.getErrorStream()));

                    while (true) {
                        String temp = output.readLine();
                        if (temp != null) {
                            result += temp;
                            result += "\n";
                        } else
                            break;
                    }
                    if (result.equals("")) {
                        while (true) {
                            String temp = error.readLine();
                            if (temp != null) {
                                result += temp;
                                result += "\n";
                            } else
                                break;
                        }
                    }
                    output.close();
                    error.close();

                } else {
                    result = "please run on windows machine for now";
                }
                jTextArea2.setText(result);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }//method must be implemented

    public static final String OS = System.getProperty("os.name").toLowerCase();

    public static boolean isWindows() {
        return (OS.contains("win"));
    }

    public static boolean isMac() {

        return (OS.contains("mac"));

    }

    public static boolean isUnix() {

        return (OS.contains("nix") || OS.contains("nux") || OS.indexOf("aix") > 0);

    }
}

class MyFocusListener extends FocusAdapter {
    MyEditor me;

    MyFocusListener(MyEditor me) {
        this.me = me;
    }

    public void focusGained(FocusEvent fe) {
        String str = me.jTextField.getText().trim();

        me.jTextArea1.setText("public class " + str + "\n" + "{\n\t" + "public static void main(String ...args)\n\t{\t" + "\n\n\t}" + "\n}");
    }

}


