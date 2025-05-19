

```java
import javax.swing.*;
import java.awt.*;

public class HelloWorld {
    public static void main(String[] args) {
        var frame = new JFrame("Simple Java App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var label = new JLabel("Hello World", SwingConstants.CENTER);
        frame.getContentPane().add(label, BorderLayout.CENTER);

        frame.setSize(200, 100);
        frame.setVisible(true);
    }
}
```