package buttontest;

import java.awt.BorderLayout;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This demo shows how to use ChangeEvent to detect button presses
 * and releases.
 */
public class SimpleApp extends JFrame {

	public static void main(String[] args) {
	  SimpleApp app = new SimpleApp();
    app.setVisible(true);
  }

  public SimpleApp() {
    final JButton button = new JButton("press me");
    button.addChangeListener(new ChangeListener() {
      boolean pressed = false;
      public void stateChanged(ChangeEvent e) {
        ButtonModel m = ((JButton) e.getSource()).getModel();
        if (m.isArmed() && m.isPressed()) {
          pressed = true;
          System.out.println("button has been pressed");
        }
        if (! m.isArmed() && ! m.isPressed() && pressed) {
          pressed = false;
          System.out.println("button has been released");
        }
      }
    });
    getContentPane().add(button, BorderLayout.CENTER);
    getContentPane().add(new JButton("no effect"), BorderLayout.EAST);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
	}
}
