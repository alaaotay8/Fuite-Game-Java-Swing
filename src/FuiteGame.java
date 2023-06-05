import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.*;

public class FuiteGame extends JFrame implements ActionListener, KeyListener {

    private final int SWIDTH = 900;
    private final int SHEIGHT = 700;
    private JButton btnStart, btnExit, btnRestart;
    private JButton btnLeft, btnRight, btnUp, btnDown;
    private GamePanel gameP = new GamePanel();
    private JLabel nameLabel,welc;

    public FuiteGame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Fuite Game (v1.0) ");
        setSize(SWIDTH, SHEIGHT);
        setLayout(null);
        addKeyListener(this); // add key listener to the JFrame
        setFocusable(true); // set focusable to true to allow key events
    }

    public void init() {
        gameP.setBounds(25, 25, 600, 630);
        add(gameP);
        

        JLabel welc = new JLabel("WELCOME :");
        welc.setBounds(725, 100, 100, 25);
        add(welc);

        btnStart = new JButton("START");
        btnStart.setBounds(650, 150, 100, 25);
        btnStart.addActionListener(this);
        add(btnStart);

        btnRestart = new JButton("RESTART");
        btnRestart.setBounds(762, 150, 100, 25);
        btnRestart.addActionListener(this);
        add(btnRestart);

        btnLeft = new JButton("LEFT");
        btnLeft.setBounds(650, 325 , 100, 25);
        btnLeft.addActionListener(this);
        add(btnLeft);

        btnRight = new JButton("RIGHT");
        btnRight.setBounds(750, 325 , 100, 25);
        btnRight.addActionListener(this);
        add(btnRight);

        btnUp = new JButton("UP");
        btnUp.setBounds(700, 300 , 100, 25);
        btnUp.addActionListener(this);
        add(btnUp);

        btnDown = new JButton("DOWN");
        btnDown.setBounds(700, 350, 100, 25);
        btnDown.addActionListener(this);
        add(btnDown);

        JLabel labName = new JLabel("Tip: Use keyboard arrow keys");
        labName.setBounds(660, 400, 200, 25);
        add(labName);

        btnExit = new JButton("EXIT");
        btnExit.setBounds(650, 500, 200, 25);
        btnExit.addActionListener(this);
        add(btnExit);
        
        nameLabel = new JLabel("By Alaa Otay (CPI2)");
        nameLabel.setBounds(760, 620, 200, 25);
        nameLabel.setForeground(Color.BLACK); 
        nameLabel.setBackground(Color.WHITE); 
        nameLabel.setOpaque(true);
        add(nameLabel);


        setVisible(true);
        File soundFile = new File("src/game.wav").getAbsoluteFile();
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
            Clip myClip = AudioSystem.getClip();
            myClip.open(ais);
            myClip.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnExit) {
            System.exit(0);
        } else if (e.getSource() == btnStart) {
            gameP.startTimer();
        } else if (e.getSource() == btnRestart) {
            gameP.reset();
        } else if (e.getSource() == btnLeft) {
            gameP.moveLeft();
        } else if (e.getSource() == btnUp) {
            gameP.moveUp();
        } else if (e.getSource() == btnRight) {
            gameP.moveRight();
        } else if (e.getSource() == btnDown) {
            gameP.moveDown();
        }
    }

    // implementation of KeyListener methods
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            gameP.moveLeft();
        } else if (keyCode == KeyEvent.VK_RIGHT) {
        	gameP.moveRight();
        } else if (keyCode == KeyEvent.VK_UP) {
        	gameP.moveUp();
        } else if (keyCode == KeyEvent.VK_DOWN) {
        	gameP.moveDown();
        	}
    }
    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        FuiteGame game = new FuiteGame();
        game.init();
    }
}