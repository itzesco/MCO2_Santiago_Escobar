import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendingView extends JFrame {
    private JPanel cardPanel;
    private CardLayout cardLayout;
    //private VendingMachineController regularController; 

    public VendingView() {
        setTitle("Vending Machine");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // Create and add the "Welcome" panel
        JPanel welcomePanel = createWelcomePanel();
        cardPanel.add(welcomePanel, "Welcome");

        // Create and add the "Regular Vending Machine" panel
        JPanel regularVendingMachinePanel = regularVMOptions();
        cardPanel.add(regularVendingMachinePanel, "Regular Vending Machine");

        // Create and add the "Special Vending Machine" panel
        JPanel specialVendingMachinePanel = specialVMOptions();
        cardPanel.add(specialVendingMachinePanel, "Special Vending Machine");

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(cardPanel, BorderLayout.CENTER);

        // Create an instance of RegularVendingMachine and RegularVendingMachineController
        //RegularVendingMachine regularVendingMachine = createRegularVendingMachine();
        //regularController = new RegularVendingMachineController(this, regularVendingMachine);
    }

    /* Method to create an instance of RegularVendingMachine and initialize its data
    private RegularVendingMachine createRegularVendingMachine() {
        // Create the RegularVendingMachine instance and initialize its data (slot and item details)
        // For demonstration purposes, let's assume you have a method to initialize the data.
        RegularVendingMachine regularVendingMachine = new RegularVendingMachine();
        regularVendingMachine.initializeSlots(); // You need to implement this method in RegularVendingMachine class

        return regularVendingMachine;
    }*/ 

    public JPanel createWelcomePanel() {
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
        welcomePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomePanel.setBackground(new Color(255, 204, 204)); // Pastel pink background color

        welcomePanel.add(Box.createRigidArea(new Dimension(0, 100)));
        JLabel welcomeLabel = new JLabel("WELCOME");
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 65)); // Setting font and size
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomePanel.add(welcomeLabel);

        JLabel subLabel = new JLabel("to sandWHICH? Vending MOCHIne");
        subLabel.setFont(new Font("Carmen Sans", Font.BOLD, 20)); // Setting font and size
        subLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomePanel.add(subLabel);
        welcomePanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Add the horizontal line before the button
        JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(300, 5)); 
        separator.setAlignmentX(Component.CENTER_ALIGNMENT);
        separator.setForeground(Color.BLACK); 
        welcomePanel.add(separator);
        welcomePanel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        // Button to regular vending machine
        JButton regularButton = new JButton("Regular Vending Machine");
        regularButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        regularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardPanel.add(regularVMOptions(), "Regular Vending Machine Options");
                cardLayout.show(cardPanel, "Regular Vending Machine Options");
            }
        });
        welcomePanel.add(regularButton);
        welcomePanel.add(Box.createRigidArea(new Dimension(0, 7)));

        // Button to special vending machine
        JButton specialButton = new JButton("Special Vending Machine");
        specialButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        specialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardPanel.add(specialVMOptions(), "Special Vending Machine Options");
                cardLayout.show(cardPanel, "Special Vending Machine Options");
            }
        });
        welcomePanel.add(specialButton);
        welcomePanel.add(Box.createRigidArea(new Dimension(0, 7)));

        // Button to exit the application
        JButton exitButton = new JButton("Exit");
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        welcomePanel.add(exitButton);

        return welcomePanel;
    }

    public JPanel regularVMOptions() {
        JPanel regularVMOptions = new JPanel();
        
        regularVMOptions.setLayout(new BoxLayout(regularVMOptions, BoxLayout.Y_AXIS));
        regularVMOptions.setAlignmentX(Component.CENTER_ALIGNMENT);
        regularVMOptions.setBackground(new Color(213, 255, 255));
        regularVMOptions.add(Box.createRigidArea(new Dimension(0, 100)));
    
        JLabel titleLabel = new JLabel("Choose a feature to");
        titleLabel.setFont(new Font("Carmen Sans", Font.BOLD, 30)); 
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        regularVMOptions.add(titleLabel);

        JLabel subLabel = new JLabel("TEST");
        subLabel.setFont(new Font("Times New Roman", Font.BOLD, 60)); 
        subLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        regularVMOptions.add(subLabel);
        regularVMOptions.add(Box.createRigidArea(new Dimension(0, 20)));

        JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(300, 5)); 
        separator.setAlignmentX(Component.CENTER_ALIGNMENT);
        separator.setForeground(Color.BLACK); 
        regularVMOptions.add(separator);
        regularVMOptions.add(Box.createRigidArea(new Dimension(0, 20)));

    
        JButton testButton = new JButton("Purchase an Item");
        testButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel purchasePanel = purchasePanel();
                cardPanel.add(purchasePanel, "Purchase an Item");
                cardLayout.show(cardPanel, "Purchase an Item");
            }
        });
        regularVMOptions.add(testButton);
        regularVMOptions.add(Box.createRigidArea(new Dimension(0, 7)));
    
        JButton maintenanceButton = new JButton("Maintenance");
        maintenanceButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        maintenanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel maintenancePanel = maintenancePanel();
                cardPanel.add(maintenancePanel, "Maintenance");
                cardLayout.show(cardPanel, "Maintenance");
            }
        });
        regularVMOptions.add(maintenanceButton);
        regularVMOptions.add(Box.createRigidArea(new Dimension(0, 7)));
    
        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Welcome");
            }
        });
        regularVMOptions.add(backButton);
    
        return regularVMOptions;
    }

    private ImageIcon resizeImageIcon(ImageIcon originalIcon, int width, int height) {
        Image image = originalIcon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    public JPanel purchasePanel() {
        JPanel purchasePanel = new JPanel();
        purchasePanel.setLayout(new BoxLayout(purchasePanel, BoxLayout.Y_AXIS));
        purchasePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        purchasePanel.setBackground(new Color(255, 241, 220));
        purchasePanel.add(Box.createRigidArea(new Dimension(0, 20)));
    
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
    
        JLabel titleLabel = new JLabel("Mochi Ice Cream Vending Machine");
        titleLabel.setFont(new Font("Candy Beans", Font.BOLD, 30));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerPanel.setBackground(new Color(255, 241, 220));
        headerPanel.add(titleLabel);
    
        purchasePanel.add(headerPanel);
    
        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new GridLayout(2, 4, 15, 15)); 
    
        Dimension panelSize = new Dimension(3 * 72, 4 * 72);
    
        String[] imagePaths = {
            "Vanilla.png", 
            "Chocolate.png", 
            "Strawberry.png", 
            "Mango.png", 
            "CookiesnCream.png", 
            "Coffee.png", 
            "MintChoco.png",
            "Matcha.png",
        };

        for (int i = 1; i <= 8; i++) {
            JPanel outerPanel = new JPanel();
            String hexColorCode1 = "#D5B690"; 
            Color color1 = Color.decode(hexColorCode1);
            outerPanel.setBorder(BorderFactory.createLineBorder(color1, 4));
            outerPanel.setPreferredSize(panelSize);
            outerPanel.setLayout(new BorderLayout());
    
            JPanel innerPanel = new JPanel();
            String hexColorCode2 = "#FFFFCC"; 
            Color color2 = Color.decode(hexColorCode2);
            innerPanel.setBackground(color2);
            innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS)); 
            innerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

            JLabel itemLabel = new JLabel("SLOT " + i);
            itemLabel.setFont(new Font("Carmen Sans", Font.PLAIN, 13));
            itemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel itemName = new JLabel("Mochi Ice Cream " + i);
            itemName.setFont(new Font("Times New Roman", Font.BOLD, 15));
            itemName.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel itemCalories = new JLabel("Calories: " + i);
            itemCalories.setFont(new Font("Carmen Sans", Font.PLAIN, 12));
            itemCalories.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel itemPrice = new JLabel("Price: " + i);
            itemPrice.setFont(new Font("Carmen Sans", Font.PLAIN, 12));
            itemPrice.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel itemStock = new JLabel("Stock: " + i);
            itemStock.setFont(new Font("Carmen Sans", Font.PLAIN, 12));
            itemStock.setAlignmentX(Component.CENTER_ALIGNMENT);

            String imagePath = imagePaths[i - 1]; // Array indices start from 0, but items start from 1
            ImageIcon originalIcon = new ImageIcon(imagePath);
            int desiredWidth = 100; 
            int desiredHeight = 100; 
            ImageIcon resizedIcon = resizeImageIcon(originalIcon, desiredWidth, desiredHeight);
            JLabel imageLabel = new JLabel(resizedIcon);
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JButton purchaseButton = new JButton("Purchase");
            purchaseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            purchaseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String slotNumber = JOptionPane.showInputDialog(purchasePanel, "Enter amount of money:", "Purchase Item", JOptionPane.PLAIN_MESSAGE);
                    // logic ng purchase system
                    
                }
            });

            innerPanel.add(itemLabel); 
            innerPanel.add(itemName);
            innerPanel.add(itemCalories);
            innerPanel.add(itemPrice);
            innerPanel.add(itemStock);
            innerPanel.add(imageLabel);
            innerPanel.add(purchaseButton);
    
            outerPanel.add(innerPanel, BorderLayout.CENTER); 
            
            itemsPanel.setBackground(new Color(255, 241, 220));
            itemsPanel.add(outerPanel);
        }
    
        purchasePanel.add(itemsPanel);
    
        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Regular Vending Machine"); 
            }
        });
        
        int borderPadding = 20; 
        itemsPanel.setBorder(new EmptyBorder(borderPadding, borderPadding, borderPadding, borderPadding));

        purchasePanel.add(backButton);
        purchasePanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing between items and the back button

        return purchasePanel;
    }
    
    private JPanel maintenancePanel() {
        JPanel maintenancePanel = new JPanel();
        maintenancePanel.setLayout(new BoxLayout(maintenancePanel, BoxLayout.Y_AXIS));
        maintenancePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        maintenancePanel.setBackground(new Color(213, 255, 255));

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        maintenancePanel.add(Box.createRigidArea(new Dimension(0, 70)));
        JLabel maintenanceLabel = new JLabel("MAINTENANCE");
        maintenanceLabel.setFont(new Font("Times New Roman", Font.BOLD, 50)); 
        maintenanceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        maintenancePanel.add(maintenanceLabel);
        maintenancePanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(300, 5)); 
        separator.setAlignmentX(Component.CENTER_ALIGNMENT);
        separator.setForeground(Color.BLACK);
        maintenancePanel.add(separator);
        maintenancePanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Adding the maintenance options
        JButton restockItemsButton = new JButton("Restock Item");
        restockItemsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        restockItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel restockItemsPanel = restockItemsPanel();
                cardPanel.add(restockItemsPanel, "Restock Items");
                cardLayout.show(cardPanel, "Restock Items");
            }
        });
        maintenancePanel.add(restockItemsButton);
        maintenancePanel.add(Box.createRigidArea(new Dimension(0, 7)));
    
        JButton changeItemPriceButton = new JButton("Change Item Price");
        changeItemPriceButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        changeItemPriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel changePricePanel = changePricePanel();
                cardPanel.add(changePricePanel, "Change Item Price");
                cardLayout.show(cardPanel, "Change Item Price");
            }
        });
        maintenancePanel.add(changeItemPriceButton);
        maintenancePanel.add(Box.createRigidArea(new Dimension(0, 7)));
    
        JButton collectMoneyButton = new JButton("Collect Money");
        collectMoneyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        collectMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel collectMoneyPanel = collectMoneyPanel();
                cardPanel.add(collectMoneyPanel, "Collect Money");
                cardLayout.show(cardPanel, "Collect Money");
            }
        });
        maintenancePanel.add(collectMoneyButton);
        maintenancePanel.add(Box.createRigidArea(new Dimension(0, 7)));

        JButton replenishButton = new JButton("Replenish Denomination");
        replenishButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        replenishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel replenishPanel = replenishPanel();
                cardPanel.add(replenishPanel, "Replenish Denomination");
                cardLayout.show(cardPanel, "Replenish Denomination");
            }
        });
        maintenancePanel.add(replenishButton);
        maintenancePanel.add(Box.createRigidArea(new Dimension(0, 7)));

        JButton printButton = new JButton("Print History Transaction");
        printButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel printPanel = printPanel();
                cardPanel.add(printPanel, "Print History Transaction");
                cardLayout.show(cardPanel, "Print History Transaction");
            }
        });
        maintenancePanel.add(printButton);
        maintenancePanel.add(Box.createRigidArea(new Dimension(0, 7)));
    
        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Regular Vending Machine");
            }
        });
        maintenancePanel.add(backButton);
        return maintenancePanel;
    }

    private JPanel restockItemsPanel() {
        JPanel restockItemsPanel = new JPanel();
        restockItemsPanel.setLayout(new BoxLayout(restockItemsPanel, BoxLayout.Y_AXIS));
        restockItemsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        restockItemsPanel.setBackground(new Color(255, 241, 220));
        restockItemsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
    
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
    
        JLabel titleLabel = new JLabel("Restock Item");
        titleLabel.setFont(new Font("Candy Beans", Font.BOLD, 30));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerPanel.setBackground(new Color(255, 241, 220));
        headerPanel.add(titleLabel);
    
        restockItemsPanel.add(headerPanel);
    
        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new GridLayout(2, 4, 15, 15));
        Dimension panelSize = new Dimension(3 * 72, 4 * 72);
    
        String[] imagePaths = {
            "Vanilla.png",
            "Chocolate.png",
            "Strawberry.png",
            "Mango.png",
            "CookiesnCream.png",
            "Coffee.png",
            "MintChoco.png",
            "Matcha.png",
        };
    
        for (int i = 1; i <= 8; i++) {
            JPanel outerPanel = new JPanel();
            String hexColorCode1 = "#D5B690"; 
            Color color1 = Color.decode(hexColorCode1);
            outerPanel.setBorder(BorderFactory.createLineBorder(color1, 4)); 
            outerPanel.setPreferredSize(panelSize);
            outerPanel.setLayout(new BorderLayout());
    
            JPanel innerPanel = new JPanel();
            String hexColorCode2 = "#FFFFCC";
            Color color2 = Color.decode(hexColorCode2);
            innerPanel.setBackground(color2);
            innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
            innerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    
            JLabel itemLabel = new JLabel("SLOT " + i);
            itemLabel.setFont(new Font("Carmen Sans", Font.PLAIN, 13));
            itemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    
            JLabel itemName = new JLabel("Mochi Ice Cream " + i);
            itemName.setFont(new Font("Times New Roman", Font.BOLD, 15));
            itemName.setAlignmentX(Component.CENTER_ALIGNMENT);
    
            JLabel itemCalories = new JLabel("Calories: " + i);
            itemCalories.setFont(new Font("Carmen Sans", Font.PLAIN, 12));
            itemCalories.setAlignmentX(Component.CENTER_ALIGNMENT);
    
            JLabel itemPrice = new JLabel("Price: " + i);
            itemPrice.setFont(new Font("Carmen Sans", Font.PLAIN, 12));
            itemPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
    
            JLabel itemStock = new JLabel("Stock: " + i);
            itemStock.setFont(new Font("Carmen Sans", Font.PLAIN, 12));
            itemStock.setAlignmentX(Component.CENTER_ALIGNMENT);
    
            String imagePath = imagePaths[i - 1]; 
            ImageIcon originalIcon = new ImageIcon(imagePath);
            int desiredWidth = 100;
            int desiredHeight = 100;
            ImageIcon resizedIcon = resizeImageIcon(originalIcon, desiredWidth, desiredHeight);
            JLabel imageLabel = new JLabel(resizedIcon);
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    
            JButton restockButton = new JButton("Restock");
            restockButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            restockButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String slotNumber = JOptionPane.showInputDialog(restockItemsPanel, "Enter how many item to restock:", "Restock Items", JOptionPane.PLAIN_MESSAGE);
                    // logic ng restock
                    
                }
            });
    
            innerPanel.add(itemLabel);
            innerPanel.add(itemName);
            innerPanel.add(itemCalories);
            innerPanel.add(itemPrice);
            innerPanel.add(itemStock);
            innerPanel.add(imageLabel);
            innerPanel.add(restockButton);
    
            outerPanel.add(innerPanel, BorderLayout.CENTER);
    
            itemsPanel.setBackground(new Color(255, 241, 220));
            itemsPanel.add(outerPanel);
        }
    
        restockItemsPanel.add(itemsPanel);
    
        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Maintenance");
            }
    
        });
    
        int borderPadding = 20;
        itemsPanel.setBorder(new EmptyBorder(borderPadding, borderPadding, borderPadding, borderPadding));
    
        restockItemsPanel.add(backButton);
        restockItemsPanel.add(Box.createRigidArea(new Dimension(0, 20))); 
    
        return restockItemsPanel;
    }

    private JPanel changePricePanel() {
        JPanel changePricePanel = new JPanel();
        changePricePanel.setLayout(new BoxLayout(changePricePanel, BoxLayout.Y_AXIS));
        changePricePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        changePricePanel.setBackground(new Color(255, 241, 220));
        changePricePanel.add(Box.createRigidArea(new Dimension(0, 20)));
    
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
    
        JLabel titleLabel = new JLabel("Change Item Price");
        titleLabel.setFont(new Font("Candy Beans", Font.BOLD, 30));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerPanel.setBackground(new Color(255, 241, 220));
        headerPanel.add(titleLabel);
    
        changePricePanel.add(headerPanel);
    
        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new GridLayout(2, 4, 15, 15));
        Dimension panelSize = new Dimension(3 * 72, 4 * 72);
    
        String[] imagePaths = {
            "Vanilla.png",
            "Chocolate.png",
            "Strawberry.png",
            "Mango.png",
            "CookiesnCream.png",
            "Coffee.png",
            "MintChoco.png",
            "Matcha.png",
        };
    
        for (int i = 1; i <= 8; i++) {
            JPanel outerPanel = new JPanel();
            String hexColorCode1 = "#D5B690"; 
            Color color1 = Color.decode(hexColorCode1);
            outerPanel.setBorder(BorderFactory.createLineBorder(color1, 4)); 
            outerPanel.setPreferredSize(panelSize);
            outerPanel.setLayout(new BorderLayout());
    
            JPanel innerPanel = new JPanel();
            String hexColorCode2 = "#FFFFCC";
            Color color2 = Color.decode(hexColorCode2);
            innerPanel.setBackground(color2);
            innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
            innerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    
            JLabel itemLabel = new JLabel("SLOT " + i);
            itemLabel.setFont(new Font("Carmen Sans", Font.PLAIN, 13));
            itemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    
            JLabel itemName = new JLabel("Mochi Ice Cream " + i);
            itemName.setFont(new Font("Times New Roman", Font.BOLD, 15));
            itemName.setAlignmentX(Component.CENTER_ALIGNMENT);
    
            JLabel itemCalories = new JLabel("Calories: " + i);
            itemCalories.setFont(new Font("Carmen Sans", Font.PLAIN, 12));
            itemCalories.setAlignmentX(Component.CENTER_ALIGNMENT);
    
            JLabel itemPrice = new JLabel("Price: " + i);
            itemPrice.setFont(new Font("Carmen Sans", Font.PLAIN, 12));
            itemPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
    
            JLabel itemStock = new JLabel("Stock: " + i);
            itemStock.setFont(new Font("Carmen Sans", Font.PLAIN, 12));
            itemStock.setAlignmentX(Component.CENTER_ALIGNMENT);
    
            String imagePath = imagePaths[i - 1]; 
            ImageIcon originalIcon = new ImageIcon(imagePath);
            int desiredWidth = 100;
            int desiredHeight = 100;
            ImageIcon resizedIcon = resizeImageIcon(originalIcon, desiredWidth, desiredHeight);
            JLabel imageLabel = new JLabel(resizedIcon);
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    
            JButton restockButton = new JButton("Change");
            restockButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            restockButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String slotNumber = JOptionPane.showInputDialog(changePricePanel, "Enter new price:", "Change Price", JOptionPane.PLAIN_MESSAGE);
                    // logic ng change price
                    
                }
            });
    
            innerPanel.add(itemLabel);
            innerPanel.add(itemName);
            innerPanel.add(itemCalories);
            innerPanel.add(itemPrice);
            innerPanel.add(itemStock);
            innerPanel.add(imageLabel);
            innerPanel.add(restockButton);
    
            outerPanel.add(innerPanel, BorderLayout.CENTER);
    
            itemsPanel.setBackground(new Color(255, 241, 220));
            itemsPanel.add(outerPanel);
        }
    
        changePricePanel.add(itemsPanel);
    
        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Maintenance");
            }
    
        });
    
        int borderPadding = 20;
        itemsPanel.setBorder(new EmptyBorder(borderPadding, borderPadding, borderPadding, borderPadding));
    
        changePricePanel.add(backButton);
        changePricePanel.add(Box.createRigidArea(new Dimension(0, 20))); 
    
        return changePricePanel;
    }

    public JPanel collectMoneyPanel() {
        JPanel collectMoneyPanel = new JPanel();
        collectMoneyPanel.setLayout(new BoxLayout(collectMoneyPanel, BoxLayout.Y_AXIS));
        collectMoneyPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        collectMoneyPanel.setBackground(new Color(255, 241, 220));
        collectMoneyPanel.add(Box.createRigidArea(new Dimension(0, 100)));
    
        JLabel titleLabel = new JLabel("Total collected money from the");
        titleLabel.setFont(new Font("Carmen Sans", Font.BOLD, 20)); 
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        collectMoneyPanel.add(titleLabel);

        JLabel subLabel = new JLabel("REGULAR VENDING MACHINE");
        subLabel.setFont(new Font("Times New Roman", Font.BOLD, 40)); 
        subLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        collectMoneyPanel.add(subLabel);
        collectMoneyPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(300, 5)); 
        separator.setAlignmentX(Component.CENTER_ALIGNMENT);
        separator.setForeground(Color.BLACK); 
        collectMoneyPanel.add(separator);
        collectMoneyPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel moneyLabel = new JLabel("Amount: PHP 0");// to be changed
        moneyLabel.setFont(new Font("Candy Beans", Font.BOLD, 30));
        moneyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        collectMoneyPanel.add(moneyLabel);
        collectMoneyPanel.add(Box.createRigidArea(new Dimension(0, 20))); 

        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Maintenance");
            }
    
        });

        collectMoneyPanel.add(backButton);
        collectMoneyPanel.add(Box.createRigidArea(new Dimension(0, 20))); 
    
        return collectMoneyPanel;
    }
    
    private JPanel replenishPanel() {
        JPanel replenishPanel = new JPanel();
        replenishPanel.setLayout(new BoxLayout(replenishPanel, BoxLayout.Y_AXIS));
        replenishPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        replenishPanel.setBackground(new Color(255, 241, 220));
        replenishPanel.add(Box.createRigidArea(new Dimension(0, 20)));
    
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
    
        JLabel titleLabel = new JLabel("Replenish Denomination");
        titleLabel.setFont(new Font("Candy Beans", Font.BOLD, 30));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerPanel.setBackground(new Color(255, 241, 220));
        headerPanel.add(titleLabel);
        replenishPanel.add(headerPanel);

        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new GridLayout(2, 4, 15, 15)); 
    
        Dimension panelSize = new Dimension(4 * 72, 3 * 72);

        String[] itemNames = {
            "Php One",
            "Php Five",
            "Php Ten",
            "Php Twenty",
            "Php Fifty",
            "Php One Hundred",
            "Php Two Hundred",
            "Php Five Hundred",
            "Php One Thousand"
        };

        String[] imagePaths = {
            "1.png", 
            "5.png", 
            "10.png", 
            "20.png", 
            "50.png", 
            "100.png", 
            "200.png",
            "500.png",
            "1000.png",
        };

        for (int i = 1; i <= 9; i++) {
            JPanel outerPanel = new JPanel();
            String hexColorCode1 = "#D5B690"; 
            Color color1 = Color.decode(hexColorCode1);
            outerPanel.setBorder(BorderFactory.createLineBorder(color1, 4)); 
            outerPanel.setPreferredSize(panelSize);
            outerPanel.setLayout(new BorderLayout());
    
            JPanel innerPanel = new JPanel();
            String hexColorCode2 = "#FFFFCC"; 
            Color color2 = Color.decode(hexColorCode2);
            innerPanel.setBackground(color2);
            innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS)); 
            innerPanel.add(Box.createRigidArea(new Dimension(0, 40)));

            JLabel itemNameLabel = new JLabel(itemNames[i - 1]);
            itemNameLabel.setFont(new Font("Carmen Sans", Font.BOLD, 12));
            itemNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            String imagePath = imagePaths[i - 1]; // Array indices start from 0, but items start from 1
            ImageIcon originalIcon = new ImageIcon(imagePath);
            int desiredWidth = 130; 
            int desiredHeight = 80; 
            ImageIcon resizedIcon = resizeImageIcon(originalIcon, desiredWidth, desiredHeight);
            JLabel imageLabel = new JLabel(resizedIcon);
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel itemStock = new JLabel("Quantity: " + i);
            itemStock.setFont(new Font("Carmen Sans", Font.PLAIN, 12));
            itemStock.setAlignmentX(Component.CENTER_ALIGNMENT);

            JButton replenishButton = new JButton("Replenish");
            replenishButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            replenishButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String slotMoney = JOptionPane.showInputDialog(replenishPanel, "Enter new quantity of the money:", "Replenish Money", JOptionPane.PLAIN_MESSAGE);
                    // logic ng money
                    
                }
            });

            innerPanel.add(itemNameLabel);
            innerPanel.add(imageLabel);
            innerPanel.add(itemStock);
            innerPanel.add(replenishButton);
    
            outerPanel.add(innerPanel, BorderLayout.CENTER); 
            
            itemsPanel.setBackground(new Color(255, 241, 220));
            itemsPanel.add(outerPanel);
        }
    
        replenishPanel.add(itemsPanel);
    
        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Maintenance"); 
            }
        });
        
        int borderPadding = 20; 
        itemsPanel.setBorder(new EmptyBorder(borderPadding, borderPadding, borderPadding, borderPadding));

        replenishPanel.add(backButton);
        replenishPanel.add(Box.createRigidArea(new Dimension(0, 20))); 

        return replenishPanel;
    }

    public JPanel printPanel() {
        JPanel printPanel = new JPanel();
        printPanel.setLayout(new BoxLayout(printPanel, BoxLayout.Y_AXIS));
        printPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        printPanel.setBackground(new Color(255, 241, 220));
        printPanel.add(Box.createRigidArea(new Dimension(0, 100)));
    
        JLabel titleLabel = new JLabel("Transaction History Summary");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBackground(new Color(255, 241, 220));
        printPanel.add(titleLabel);
        printPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(300, 5)); 
        separator.setAlignmentX(Component.CENTER_ALIGNMENT);
        separator.setForeground(Color.BLACK); 
        printPanel.add(separator);
        printPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        

        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Maintenance");
            }
        });
    
        printPanel.add(backButton);
        printPanel.add(Box.createRigidArea(new Dimension(0, 20))); 
    
        return printPanel;
    }
    
    public JPanel specialVMOptions() {
        JPanel specialVMOptions = new JPanel();
        specialVMOptions.setLayout(new BoxLayout(specialVMOptions, BoxLayout.Y_AXIS));
        specialVMOptions.setAlignmentX(Component.CENTER_ALIGNMENT);
        specialVMOptions.setBackground(new Color(213, 255, 255));
        specialVMOptions.add(Box.createRigidArea(new Dimension(0, 100)));
    
        JLabel titleLabel = new JLabel("Choose a feature to");
        titleLabel.setFont(new Font("Carmen Sans", Font.BOLD, 30)); 
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        specialVMOptions.add(titleLabel);

        JLabel subLabel = new JLabel("TEST");
        subLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
        subLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        specialVMOptions.add(subLabel);
        specialVMOptions.add(Box.createRigidArea(new Dimension(0, 20)));

        JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(300, 5)); 
        separator.setAlignmentX(Component.CENTER_ALIGNMENT);
        separator.setForeground(Color.BLACK); 
        specialVMOptions.add(separator);
        specialVMOptions.add(Box.createRigidArea(new Dimension(0, 20)));

        JButton testButton = new JButton("Purchase an Item");
        testButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel testRegularVendingMachinePanel = customPurchasePanel();
                cardPanel.add(testRegularVendingMachinePanel, "Test Special Vending Machine");
                cardLayout.show(cardPanel, "Test Special Vending Machine");
            }
        });
        specialVMOptions.add(testButton);
        specialVMOptions.add(Box.createRigidArea(new Dimension(0, 7)));
    
        JButton maintenanceButton = new JButton("Maintenance");
        maintenanceButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        maintenanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel maintenancePanel = specialMaintenancePanel();
                cardPanel.add(maintenancePanel, "Maintenance");
                cardLayout.show(cardPanel, "Maintenance");
            }
        });
        specialVMOptions.add(maintenanceButton);
        specialVMOptions.add(Box.createRigidArea(new Dimension(0, 7)));
    
        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Welcome");
            }
        });
        specialVMOptions.add(backButton);
    
        return specialVMOptions;
    }


    public JPanel customPurchasePanel() {
        JPanel customPurchasePanel = new JPanel();
        customPurchasePanel.setLayout(new BoxLayout(customPurchasePanel, BoxLayout.Y_AXIS));
        customPurchasePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        customPurchasePanel.setBackground(new Color(255, 241, 220));

        // Left side panel containing items and add-ons
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel.setBackground(new Color(255, 241, 220));
    
        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new GridLayout(2, 4, 15, 15)); 
    
        Dimension panelSize = new Dimension(2 * 60, 2 * 55);

        for (int i = 1; i <= 8; i++) {
            JPanel outerPanel = new JPanel();
            String hexColorCode1 = "#D5B690"; 
            Color color1 = Color.decode(hexColorCode1);
            outerPanel.setBorder(BorderFactory.createLineBorder(color1, 4)); 
            outerPanel.setPreferredSize(panelSize);
            outerPanel.setLayout(new BorderLayout());
    
            JPanel innerPanel = new JPanel();
            String hexColorCode2 = "#FFFFCC"; 
            Color color2 = Color.decode(hexColorCode2);
            innerPanel.setBackground(color2);
            innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS)); 
            innerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

            JLabel itemLabel = new JLabel("SLOT " + i);
            itemLabel.setFont(new Font("Carmen Sans", Font.PLAIN, 11));
            itemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel itemName = new JLabel("Sandwich " + i);
            itemName.setFont(new Font("Times New Roman", Font.BOLD, 13));
            itemName.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel itemCalories = new JLabel("Calories: " + i);
            itemCalories.setFont(new Font("Carmen Sans", Font.PLAIN, 10));
            itemCalories.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel itemPrice = new JLabel("Price: " + i);
            itemPrice.setFont(new Font("Carmen Sans", Font.PLAIN, 10));
            itemPrice.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel itemStock = new JLabel("Stock: " + i);
            itemStock.setFont(new Font("Carmen Sans", Font.PLAIN, 10));
            itemStock.setAlignmentX(Component.CENTER_ALIGNMENT);

            JButton purchaseButton = new JButton("Add");
            purchaseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            purchaseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String slotNumber = JOptionPane.showInputDialog(customPurchasePanel, "Enter amount of money:", "Add Item", JOptionPane.PLAIN_MESSAGE);
                    // logic ng purchase system
                    
                }
            });

            innerPanel.add(itemLabel); 
            innerPanel.add(itemName);
            innerPanel.add(itemCalories);
            innerPanel.add(itemPrice);
            innerPanel.add(itemStock);
            innerPanel.add(purchaseButton);
    
            outerPanel.add(innerPanel, BorderLayout.CENTER); 
            
            itemsPanel.setBackground(new Color(255, 241, 220));
            itemsPanel.add(outerPanel);
        }
    
        leftPanel.add(itemsPanel);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 20)));


        JLabel subLabel = new JLabel("Choose your add ons:");
        subLabel.setFont(new Font("Candy Beans", Font.BOLD, 25));
        subLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        subLabel.setBackground(new Color(255, 241, 220));    
        leftPanel.add(subLabel);

        Dimension panel1Size = new Dimension(2 * 40, 2 * 50);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel addOnPanel = new JPanel();
        addOnPanel.setLayout(new GridLayout(2, 3, 15, 15)); 
    
        for (int i = 1; i <= 7; i++) {
            JPanel outerPanel = new JPanel();
            String hexColorCode1 = "#D5B690"; 
            Color color1 = Color.decode(hexColorCode1);
            outerPanel.setBorder(BorderFactory.createLineBorder(color1, 4)); 
            outerPanel.setPreferredSize(panel1Size);
            outerPanel.setLayout(new BorderLayout());
    
            JPanel innerPanel = new JPanel();
            String hexColorCode2 = "#FFFFE3"; 
            Color color2 = Color.decode(hexColorCode2);
            innerPanel.setBackground(color2);
            innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS)); 
            innerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

            JLabel itemLabel = new JLabel("SLOT " + i);
            itemLabel.setFont(new Font("Carmen Sans", Font.PLAIN, 10));
            itemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel itemName = new JLabel("Add On " + i);
            itemName.setFont(new Font("Times New Roman", Font.BOLD, 12));
            itemName.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel itemCalories = new JLabel("Calories: " + i);
            itemCalories.setFont(new Font("Carmen Sans", Font.PLAIN, 9));
            itemCalories.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel itemPrice = new JLabel("Price: " + i);
            itemPrice.setFont(new Font("Carmen Sans", Font.PLAIN, 9));
            itemPrice.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel itemStock = new JLabel("Stock: " + i);
            itemStock.setFont(new Font("Carmen Sans", Font.PLAIN, 9));
            itemStock.setAlignmentX(Component.CENTER_ALIGNMENT);

            JButton purchaseButton = new JButton("Add");
            purchaseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            purchaseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String slotNumber = JOptionPane.showInputDialog(customPurchasePanel, "Enter amount of money:", "Add Item", JOptionPane.PLAIN_MESSAGE);
                    // logic ng purchase system
                    
                }
            });

            innerPanel.add(itemLabel); 
            innerPanel.add(itemName);
            innerPanel.add(itemCalories);
            innerPanel.add(itemPrice);
            innerPanel.add(itemStock);
            innerPanel.add(purchaseButton);
    
            outerPanel.add(innerPanel, BorderLayout.CENTER); 
            
            addOnPanel.setBackground(new Color(255, 241, 220));
            addOnPanel.add(outerPanel);
        }
    
        leftPanel.add(addOnPanel);

        // Right side panel containing the header panel
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        rightPanel.setBackground(new Color(255, 241, 220));

        rightPanel.add(Box.createRigidArea(new Dimension(0, 40))); 
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
    
        JLabel titleLabel = new JLabel("Sandwich");
        titleLabel.setFont(new Font("Candy Beans", Font.BOLD, 35));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerPanel.setBackground(new Color(255, 241, 220));
        headerPanel.add(titleLabel);
        rightPanel.add(headerPanel);

        JLabel titleSubLabel = new JLabel("Vending Machine");
        titleSubLabel.setFont(new Font("Candy Beans", Font.BOLD, 35));
        titleSubLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleSubLabel.setBackground(new Color(255, 241, 220));
        rightPanel.add(titleSubLabel);

        ImageIcon imageIcon = new ImageIcon("Sandwich.png"); 
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH); 
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledImageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        rightPanel.add(imageLabel);

        JLabel label = new JLabel("Create your Customized Sandwich!");
        label.setFont(new Font("Carmen Sans", Font.BOLD, 13));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        rightPanel.add(label);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation(1.0 / 4.0); 
        
        splitPane.setEnabled(false);
        splitPane.setDividerSize(0);
        
        customPurchasePanel.add(splitPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Special Vending Machine"); 
            }
        });
        
        int borderPadding = 10; 
        leftPanel.setBorder(new EmptyBorder(borderPadding, borderPadding, borderPadding, borderPadding));
        
        rightPanel.add(Box.createRigidArea(new Dimension(0, 20)));        
        rightPanel.add(backButton);
        customPurchasePanel.add(Box.createRigidArea(new Dimension(0, 20))); 

        return customPurchasePanel;
    }

    private JPanel specialMaintenancePanel() {
        JPanel specialMaintenancePanel = new JPanel();
        specialMaintenancePanel.setLayout(new BoxLayout(specialMaintenancePanel, BoxLayout.Y_AXIS));
        specialMaintenancePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        specialMaintenancePanel.setBackground(new Color(213, 255, 255));

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        specialMaintenancePanel.add(Box.createRigidArea(new Dimension(0, 70)));
        JLabel maintenanceLabel = new JLabel("MAINTENANCE");
        maintenanceLabel.setFont(new Font("Times New Roman", Font.BOLD, 50)); 
        maintenanceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        specialMaintenancePanel.add(maintenanceLabel);
        specialMaintenancePanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(300, 5)); 
        separator.setAlignmentX(Component.CENTER_ALIGNMENT);
        separator.setForeground(Color.BLACK); 
        specialMaintenancePanel.add(separator);
        specialMaintenancePanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Adding the maintenance options
        JButton restockItemsButton = new JButton("Restock Item");
        restockItemsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        restockItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel restockItemsPanel = restockOptions();
                cardPanel.add(restockItemsPanel, "Restock Items");
                cardLayout.show(cardPanel, "Restock Items");
            }
        });
        specialMaintenancePanel.add(restockItemsButton);
        specialMaintenancePanel.add(Box.createRigidArea(new Dimension(0, 7)));
    
        JButton collectMoneyButton = new JButton("Collect Money");
        collectMoneyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        collectMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel specialCollectMoneyPanel = specialCollectMoneyPanel();
                cardPanel.add(specialCollectMoneyPanel, "Collect Money");
                cardLayout.show(cardPanel, "Collect Money");
            }
        });
        specialMaintenancePanel.add(collectMoneyButton);
        specialMaintenancePanel.add(Box.createRigidArea(new Dimension(0, 7)));

        JButton replenishButton = new JButton("Replenish Denomination");
        replenishButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        replenishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel replenishPanel = replenishPanel();
                cardPanel.add(replenishPanel, "Replenish Denomination");
                cardLayout.show(cardPanel, "Replenish Denomination");
            }
        });
        specialMaintenancePanel.add(replenishButton);
        specialMaintenancePanel.add(Box.createRigidArea(new Dimension(0, 7)));

        JButton printButton = new JButton("Print History Transaction");
        printButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel printPanel = printPanel();
                cardPanel.add(printPanel, "Print History Transaction");
                cardLayout.show(cardPanel, "Print History Transaction");
            }
        });
        specialMaintenancePanel.add(printButton);
        specialMaintenancePanel.add(Box.createRigidArea(new Dimension(0, 7)));
    
        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Special Vending Machine");
            }
        });
        specialMaintenancePanel.add(backButton);
        return specialMaintenancePanel;
    }


    private JPanel restockOptions() {
        JPanel restockOptions = new JPanel();
        restockOptions.setLayout(new BoxLayout(restockOptions, BoxLayout.Y_AXIS));
        restockOptions.setAlignmentX(Component.CENTER_ALIGNMENT);
        restockOptions.setBackground(new Color(213, 255, 255));

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        restockOptions.add(Box.createRigidArea(new Dimension(0, 70)));
        JLabel maintenanceLabel = new JLabel("Which do you like to restock?");
        maintenanceLabel.setFont(new Font("Times New Roman", Font.BOLD, 30)); 
        maintenanceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        restockOptions.add(maintenanceLabel);
        restockOptions.add(Box.createRigidArea(new Dimension(0, 10)));

        JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(300, 5)); 
        separator.setAlignmentX(Component.CENTER_ALIGNMENT);
        separator.setForeground(Color.BLACK); 
        restockOptions.add(separator);
        restockOptions.add(Box.createRigidArea(new Dimension(0, 10)));

        JButton productButton = new JButton("Sandwich Products");
        productButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel printPanel = restockProductPanel();
                cardPanel.add(printPanel, "Sandwich Products");
                cardLayout.show(cardPanel, "Sandwich Products");
            }
        });
        restockOptions.add(productButton);
        restockOptions.add(Box.createRigidArea(new Dimension(0, 7)));

        JButton addOnButton = new JButton("Add On Products");
        addOnButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel printPanel = restockAddOnPanel();
                cardPanel.add(printPanel, "Add On Products");
                cardLayout.show(cardPanel, "Add On Products");
            }
        });
        restockOptions.add(addOnButton);
        restockOptions.add(Box.createRigidArea(new Dimension(0, 7)));
    
        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Maintenance");
            }
        });
        restockOptions.add(backButton);

        return restockOptions;
    }

    private JPanel restockProductPanel() {
        JPanel restockProductPanel = new JPanel();
        restockProductPanel.setLayout(new BoxLayout(restockProductPanel, BoxLayout.Y_AXIS));
        restockProductPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        restockProductPanel.setBackground(new Color(255, 241, 220));
        restockProductPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        JLabel subLabel = new JLabel("Restock Sandwich Products:");
        subLabel.setFont(new Font("Candy Beans", Font.BOLD, 30));
        subLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        subLabel.setBackground(new Color(255, 241, 220));    
        restockProductPanel.add(subLabel);

        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new GridLayout(2, 4, 15, 15)); 
    
        Dimension panelSize = new Dimension(2 * 40, 2 * 50);

        for (int i = 1; i <= 8; i++) {
            JPanel outerPanel = new JPanel();
            String hexColorCode1 = "#D5B690"; 
            Color color1 = Color.decode(hexColorCode1);
            outerPanel.setBorder(BorderFactory.createLineBorder(color1, 4)); 
            outerPanel.setPreferredSize(panelSize);
            outerPanel.setLayout(new BorderLayout());
    
            JPanel innerPanel = new JPanel();
            String hexColorCode2 = "#FFFFCC"; 
            Color color2 = Color.decode(hexColorCode2);
            innerPanel.setBackground(color2);
            innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS)); 
            innerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

            JLabel itemLabel = new JLabel("SLOT " + i);
            itemLabel.setFont(new Font("Carmen Sans", Font.PLAIN, 15));
            itemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel itemName = new JLabel("Sandwich " + i);
            itemName.setFont(new Font("Times New Roman", Font.BOLD, 17));
            itemName.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel itemCalories = new JLabel("Calories: " + i);
            itemCalories.setFont(new Font("Carmen Sans", Font.PLAIN, 14));
            itemCalories.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel itemPrice = new JLabel("Price: " + i);
            itemPrice.setFont(new Font("Carmen Sans", Font.PLAIN, 14));
            itemPrice.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel itemStock = new JLabel("Stock: " + i);
            itemStock.setFont(new Font("Carmen Sans", Font.PLAIN, 14));
            itemStock.setAlignmentX(Component.CENTER_ALIGNMENT);

            JButton restockButton = new JButton("Restock");
            restockButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            restockButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String slotNumber = JOptionPane.showInputDialog(restockProductPanel, "Enter how many to restock:", "Restock Item", JOptionPane.PLAIN_MESSAGE);
                    // logic ng restock
                    
                }
            });

            innerPanel.add(itemLabel); 
            innerPanel.add(itemName);
            innerPanel.add(itemCalories);
            innerPanel.add(itemPrice);
            innerPanel.add(itemStock);
            innerPanel.add(restockButton);
    
            outerPanel.add(innerPanel, BorderLayout.CENTER); 
            
            itemsPanel.setBackground(new Color(255, 241, 220));
            itemsPanel.add(outerPanel);
        }
        int borderPadding = 20; 
        itemsPanel.setBorder(new EmptyBorder(borderPadding, borderPadding, borderPadding, borderPadding));

        restockProductPanel.add(itemsPanel);
        restockProductPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Restock Items"); // Use "Restock Items" as the card name
            }
        });
        restockProductPanel.add(backButton);
        restockProductPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        return restockProductPanel;
    }

    private JPanel restockAddOnPanel() {
        JPanel restockAddOnPanel = new JPanel();
        restockAddOnPanel.setLayout(new BoxLayout(restockAddOnPanel, BoxLayout.Y_AXIS));
        restockAddOnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        restockAddOnPanel.setBackground(new Color(255, 241, 220));
        restockAddOnPanel.add(Box.createRigidArea(new Dimension(0, 30)));
    
        JLabel subLabel = new JLabel("Restock Add ons:");
        subLabel.setFont(new Font("Candy Beans", Font.BOLD, 30));
        subLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        subLabel.setBackground(new Color(255, 241, 220));    
        restockAddOnPanel.add(subLabel);

        Dimension panel1Size = new Dimension(2 * 40, 2 * 50);
        restockAddOnPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel addOnPanel = new JPanel();
        addOnPanel.setLayout(new GridLayout(2, 3, 15, 15)); 
    
        for (int i = 1; i <= 7; i++) {
            JPanel outerPanel = new JPanel();
            String hexColorCode1 = "#D5B690"; 
            Color color1 = Color.decode(hexColorCode1);
            outerPanel.setBorder(BorderFactory.createLineBorder(color1, 4)); // 4-pixel black border
            outerPanel.setPreferredSize(panel1Size);
            outerPanel.setLayout(new BorderLayout());
    
            JPanel innerPanel = new JPanel();
            String hexColorCode2 = "#FFFFE3"; 
            Color color2 = Color.decode(hexColorCode2);
            innerPanel.setBackground(color2);
            innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS)); 
            innerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

            JLabel itemLabel = new JLabel("SLOT " + i);
            itemLabel.setFont(new Font("Carmen Sans", Font.PLAIN, 15));
            itemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel itemName = new JLabel("Add On " + i);
            itemName.setFont(new Font("Times New Roman", Font.BOLD, 17));
            itemName.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel itemCalories = new JLabel("Calories: " + i);
            itemCalories.setFont(new Font("Carmen Sans", Font.PLAIN, 14));
            itemCalories.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel itemPrice = new JLabel("Price: " + i);
            itemPrice.setFont(new Font("Carmen Sans", Font.PLAIN, 14));
            itemPrice.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel itemStock = new JLabel("Stock: " + i);
            itemStock.setFont(new Font("Carmen Sans", Font.PLAIN, 14));
            itemStock.setAlignmentX(Component.CENTER_ALIGNMENT);

            JButton restockButton = new JButton("Restock");
            restockButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            restockButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String slotNumber = JOptionPane.showInputDialog(restockAddOnPanel, "Enter how many to restock:", "Restock Item", JOptionPane.PLAIN_MESSAGE);
                    // logic ng restock
                    
                }
            });

            innerPanel.add(itemLabel); 
            innerPanel.add(itemName);
            innerPanel.add(itemCalories);
            innerPanel.add(itemPrice);
            innerPanel.add(itemStock);
            innerPanel.add(restockButton);
    
            outerPanel.add(innerPanel, BorderLayout.CENTER); 
            
            addOnPanel.setBackground(new Color(255, 241, 220));
            addOnPanel.add(outerPanel);
        }
        int borderPadding = 20; 
        addOnPanel.setBorder(new EmptyBorder(borderPadding, borderPadding, borderPadding, borderPadding));

        restockAddOnPanel.add(addOnPanel);
        restockAddOnPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Restock Items"); 
            }
        });
        restockAddOnPanel.add(backButton);
        restockAddOnPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        return restockAddOnPanel;
    }

    private JPanel specialCollectMoneyPanel() {
        JPanel specialCollectMoneyPanel = new JPanel();
        specialCollectMoneyPanel.setLayout(new BoxLayout(specialCollectMoneyPanel, BoxLayout.Y_AXIS));
        specialCollectMoneyPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        specialCollectMoneyPanel.setBackground(new Color(255, 241, 220));
        specialCollectMoneyPanel.add(Box.createRigidArea(new Dimension(0, 100)));
    
        JLabel titleLabel = new JLabel("Total collected money from the");
        titleLabel.setFont(new Font("Carmen Sans", Font.BOLD, 20)); 
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        specialCollectMoneyPanel.add(titleLabel);

        JLabel subLabel = new JLabel("SPECIAL VENDING MACHINE");
        subLabel.setFont(new Font("Times New Roman", Font.BOLD, 40)); 
        subLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        specialCollectMoneyPanel.add(subLabel);
        specialCollectMoneyPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(300, 5));
        separator.setAlignmentX(Component.CENTER_ALIGNMENT);
        separator.setForeground(Color.BLACK);
        specialCollectMoneyPanel.add(separator);
        specialCollectMoneyPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel moneyLabel = new JLabel("Amount: PHP 0");// to be changed
        moneyLabel.setFont(new Font("Candy Beans", Font.BOLD, 30));
        moneyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        specialCollectMoneyPanel.add(moneyLabel);
        specialCollectMoneyPanel.add(Box.createRigidArea(new Dimension(0, 20))); 

        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Maintenance");
            }
    
        });

        specialCollectMoneyPanel.add(backButton);
        specialCollectMoneyPanel.add(Box.createRigidArea(new Dimension(0, 20))); 
    
        return specialCollectMoneyPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VendingView gui = new VendingView();
                gui.setVisible(true);
                gui.setResizable(false);
            }
        });
    }
}
