package buttontest;

import java.awt.EventQueue;

import javax.swing.ButtonModel;
import javax.swing.JButton;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.TestHelper;
import junit.extensions.jfcunit.finder.AbstractButtonFinder;

public class SimpleTest extends JFCTestCase {

  SimpleApp app;
  
  protected void setUp() throws Exception {
    super.setUp();
    setHelper(new JFCTestHelper());

    app = new SimpleApp();
    app.setVisible(true);
}

  protected void tearDown() throws Exception {
    Thread.sleep(1000);

    app.dispose();
    app = null;

    TestHelper.cleanUp(this);
    super.tearDown();
  }

  public void testPress() throws Exception {
    final ButtonModel m = getButton().getModel();
    EventQueue.invokeAndWait(new Runnable() {
      public void run() {
        m.setArmed(true);
        m.setPressed(true);
      }
    });
    Thread.sleep(5000);
    EventQueue.invokeAndWait(new Runnable() {
      public void run() {
        m.setPressed(false);
        m.setArmed(false);
      }
    });
  }

  protected JButton getButton() {
    AbstractButtonFinder finder = new AbstractButtonFinder("press me");
    return (JButton) finder.find(app, 0);
  }
}
