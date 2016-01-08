package FiveLesson.Chapter_4_Task_2;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class MotoShopUI {

    public MotoShopUI() {

    }

    public void motoShopPanel() {
        JFrame frame = new JFrame("***MOTO SHOP***");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        Panel panel = new Panel();
        panel.setLayout(new GridBagLayout());

        JButton showMotorcycleByBrandsButton = new JButton("SHOW MOTORCYCLE QUANTITY");
        JButton showCatalogButton = new JButton("SHOW CATALOG");
        JButton buyMotorcycleButton = new JButton("BUY");

        JLabel label = new JLabel("In order to buy the selected motorcycle complete the following form:");
        label.setForeground(Color.BLACK);
        JLabel showMotorcycleByBrandsLable = new JLabel("Choose the motorcycle brand:");
        showMotorcycleByBrandsLable.setForeground(Color.BLACK);
        JLabel enterArticleLable = new JLabel("Enter the motorcycle article:");
        enterArticleLable.setForeground(Color.BLACK);
        JLabel enterQuantityLable = new JLabel("Enter the motorcycle quantity:");
        enterQuantityLable.setForeground(Color.BLACK);
        JLabel enterNameLable = new JLabel("Enter your name:");
        enterNameLable.setForeground(Color.BLACK);
        JLabel enterSurnameLable = new JLabel("Enter your surname:");
        enterSurnameLable.setForeground(Color.BLACK);
        JLabel enterTelephoneNumberLable = new JLabel("Enter your telephone number:");
        enterTelephoneNumberLable.setForeground(Color.BLACK);
        JLabel enterAddressLable = new JLabel("Enter your address:");
        enterAddressLable.setForeground(Color.BLACK);


        MotorcycleBrand[] motorcycleBrands;
        motorcycleBrands = MotorcycleBrand.values();

        JComboBox box = new JComboBox(motorcycleBrands);


        JTextField articleTextField = new JTextField(10);
        JTextField quantityTextField = new JTextField(25);
        JTextField nameTextField = new JTextField(25);
        JTextField surnameTextField = new JTextField(25);
        JTextField telephoneNumberTextField = new JTextField(25);
        JTextField addressTextField = new JTextField(25);

        panel.add(showCatalogButton, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panel.add(showMotorcycleByBrandsLable, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panel.add(box, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panel.add(showMotorcycleByBrandsButton, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panel.add(label, new GridBagConstraints(0, 3, 3, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 100, 10, 10), 0, 0));

        panel.add(enterArticleLable, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panel.add(articleTextField, new GridBagConstraints(1, 4, 2, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panel.add(enterQuantityLable, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panel.add(quantityTextField, new GridBagConstraints(1, 5, 2, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panel.add(enterNameLable, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panel.add(nameTextField, new GridBagConstraints(1, 6, 2, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panel.add(enterSurnameLable, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panel.add(surnameTextField, new GridBagConstraints(1, 7, 2, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panel.add(enterTelephoneNumberLable, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panel.add(telephoneNumberTextField, new GridBagConstraints(1, 8, 2, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panel.add(enterAddressLable, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panel.add(addressTextField, new GridBagConstraints(1, 9, 2, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panel.add(buyMotorcycleButton, new GridBagConstraints(0, 10, 3, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        frame.setResizable(false);
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
    }


    public class Panel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            final String IMAGE_NAME = "MOTO.jpg";
            Image background = null;
            try {
                background = ImageIO.read(new File(IMAGE_NAME));
            } catch (IOException e) {
                e.printStackTrace();
            }

            g.drawImage(background, 0, 0, new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });
        }
    }
}
