package SixLesson.Chapter_4_Task_3;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class MotoShopUI extends JWindow {

    Shop shop;

    public MotoShopUI() {
        shop = new Shop();
        shop.addGoods();
        JPanel panel = (JPanel) getContentPane();
        ImageIcon image = new ImageIcon("MotoIcon.jpg");
        panel.add(new JLabel(image), BorderLayout.CENTER);
        setSize(image.getIconWidth(), image.getIconHeight());
        setLocationRelativeTo(null);
        setVisible(true);

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(false);
    }

    public void motoShopPanel() {
        JFrame frame = new JFrame("***MOTO SHOP***");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());

        Panel panelBuy = new Panel();
        panelBuy.setLayout(new GridBagLayout());

        JPanel panelTable = new JPanel();
        panelTable.setLayout(new GridBagLayout());


        ShopTableModel shopTableModel = new ShopTableModel();
        JTable jTable = new JTable(shopTableModel);
        JScrollPane jTableScroll = new JScrollPane(jTable);
        jTableScroll.setPreferredSize(new Dimension(584, 374));


        JTextField articleTextField = new JTextField(10);
        JTextField quantityTextField = new JTextField(25);
        JTextField nameTextField = new JTextField(25);
        JTextField telephoneNumberTextField = new JTextField(25);
        JTextField addressTextField = new JTextField(25);


        JButton showMotorcycleByBrandsButton = new JButton("SHOW MOTORCYCLE QUANTITY");

        JButton showCatalogButton = new JButton("SHOW CATALOG");
        showCatalogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shop.showCatalogOfGoods();
            }
        });

        JButton buyMotorcycleButton = new JButton("BUY");
        buyMotorcycleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(quantityTextField.getText());
                shop.byMotorcycle(articleTextField.getText(), quantity, nameTextField.getText(), telephoneNumberTextField.getText(), addressTextField.getText(), "05;29");
                shop.transactionsDuringTheDay("05;29");
                shopTableModel.addDate(shop.transactionsDuringTheDay("05;29"));
                jTable.updateUI();
                panelTable.setVisible(true);
                panelBuy.setVisible(false);
                frame.pack();
            }
        });

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
        JLabel enterTelephoneNumberLable = new JLabel("Enter your telephone number:");
        enterTelephoneNumberLable.setForeground(Color.BLACK);
        JLabel enterAddressLable = new JLabel("Enter your address:");
        enterAddressLable.setForeground(Color.BLACK);


        MotorcycleBrand[] motorcycleBrands;
        motorcycleBrands = MotorcycleBrand.values();

        JComboBox box = new JComboBox(motorcycleBrands);

        showMotorcycleByBrandsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shop.quantityAndPriceOfGoods((MotorcycleBrand) box.getSelectedItem());
            }
        });

        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("File");
        JMenuItem menuItem = new JMenuItem("Buy motorcycle");
        jMenu.add(menuItem);
        jMenuBar.add(jMenu);

        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTable.setVisible(false);
                panelBuy.setVisible(true);
                frame.pack();
            }
        });

        panelBuy.add(showCatalogButton, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panelBuy.add(showMotorcycleByBrandsLable, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panelBuy.add(box, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panelBuy.add(showMotorcycleByBrandsButton, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panelBuy.add(label, new GridBagConstraints(0, 3, 3, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 100, 10, 10), 0, 0));

        panelBuy.add(enterArticleLable, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panelBuy.add(articleTextField, new GridBagConstraints(1, 4, 2, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panelBuy.add(enterQuantityLable, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panelBuy.add(quantityTextField, new GridBagConstraints(1, 5, 2, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panelBuy.add(enterNameLable, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panelBuy.add(nameTextField, new GridBagConstraints(1, 6, 2, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panelBuy.add(enterTelephoneNumberLable, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panelBuy.add(telephoneNumberTextField, new GridBagConstraints(1, 8, 2, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panelBuy.add(enterAddressLable, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panelBuy.add(addressTextField, new GridBagConstraints(1, 9, 2, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panelBuy.add(buyMotorcycleButton, new GridBagConstraints(0, 10, 3, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        panelTable.add(jTableScroll, new GridBagConstraints(0, 3, 3, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));


        panelBuy.setVisible(false);
        frame.setJMenuBar(jMenuBar);
        frame.setResizable(false);
        frame.add(panelBuy);
        frame.add(panelTable);
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
