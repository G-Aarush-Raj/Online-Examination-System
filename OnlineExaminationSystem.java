import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnlineExaminationSystem extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton updateProfileButton;
    private JButton changePasswordButton;
    private JButton startExamButton;
    private JLabel timerLabel;
    private Timer timer;
    private int remainingTime = 60;

    public OnlineExaminationSystem() {
        setTitle("Online Examination System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        updateProfileButton = new JButton("Update Profile");
        changePasswordButton = new JButton("Change Password");
        startExamButton = new JButton("Start Exam");
        timerLabel = new JLabel("Timer: " + remainingTime + " seconds");

        loginButton.addActionListener(new ActionListener() {            
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(OnlineExaminationSystem.this, "Login Successful!");
                enableExamFeatures();
            }
        });

        updateProfileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(OnlineExaminationSystem.this, "Profile Updated!");
            }
        });

        changePasswordButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(OnlineExaminationSystem.this, "Password Changed!");
            }
        });

        startExamButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startExam();
            }
        });

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(updateProfileButton);
        panel.add(changePasswordButton);
        panel.add(startExamButton);
        panel.add(timerLabel);
        add(panel);
        setVisible(true);
    }

    private void enableExamFeatures() {
        updateProfileButton.setEnabled(true);
        changePasswordButton.setEnabled(true);
        startExamButton.setEnabled(true);
    }

    private void startExam() {
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remainingTime--;
                if (remainingTime <= 0) {
                    timer.stop();
                    JOptionPane.showMessageDialog(OnlineExaminationSystem.this, "Time's up! Exam submitted.");
                    resetExamFeatures();
                } else {
                    timerLabel.setText("Timer: " + remainingTime + " seconds");
                }
            }
        });

        timer.start();
        JOptionPane.showMessageDialog(OnlineExaminationSystem.this, "Exam Started!");
    }

    private void resetExamFeatures() {
        timerLabel.setText("Timer: 0 seconds");
        remainingTime = 60;
        timer = null;
        startExamButton.setEnabled(true);
    }

    public static void main(String[] args) {
        new OnlineExaminationSystem();
    }
}
