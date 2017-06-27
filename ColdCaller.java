import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Random;

public class ColdCaller extends JFrame implements ActionListener {
   public static int list_length = 40;

   private JButton button;
   private String[] names;

   public ColdCaller() {
      setSize(200,150);
      button = new JButton("Next Student");
      button.setAlignmentX(Component.CENTER_ALIGNMENT);
      button.addActionListener(this);
      add(button);
      this.setLocationRelativeTo(null);
      setVisible(true);
   }

   public static void main(String[] args) {
      String[] names = new String[list_length];
      int i = 0;
      try {
         File namelist = new File("namelist.txt");
         Scanner input = new Scanner(namelist);
         while (input.hasNext()) {
            names[i] = input.nextLine();
            i++;
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      for (String s : names) {
         System.out.println(s);
      }
      ColdCaller cc = new ColdCaller();
      cc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      cc.names = names;
   }

   public void actionPerformed(ActionEvent e) {
      Random random = new Random();
      int index = random.nextInt(list_length);
      String name = names[index];
      JOptionPane.showMessageDialog(((JButton) e.getSource()), name);
   }
}