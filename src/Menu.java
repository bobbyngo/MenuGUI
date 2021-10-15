import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    private AddressBook addressBook;

    private JMenuBar menuBar;
    private JMenu addressBookMenu;
    private JMenu buddyInfoMenu;
    private JMenuItem item;
    private JPanel headerPanel;
    private JPanel mainPanel;

    public Menu() {
        super("Menu");

        addressBook = new AddressBook();

        //Panel
        headerPanel = new JPanel(new FlowLayout());
        mainPanel = new JPanel(new BorderLayout());


        menuBar = new JMenuBar();
        addressBookMenu = new JMenu("AddressBook");
        buddyInfoMenu = new JMenu("BuddyInfo");

        //New MenuItem
        item = new JMenuItem("New");
        addressBookMenu.add(item);


        item = new JMenuItem("Add Buddy");
        item.addActionListener(this);
        addressBookMenu.add(item);


        //Remove MenuItem
        item = new JMenuItem("Remove Buddy");
        item.addActionListener(this);
        //item.addActionListener(this);
        addressBookMenu.add(item);


        menuBar.add(addressBookMenu);
        menuBar.add(buddyInfoMenu);

       mainPanel.add(addressBook.getMyBuddies());


        headerPanel.add(menuBar);
        headerPanel.setBackground(new Color(166, 223, 242));
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        this.add(mainPanel);
        this.setSize(200, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    private void addBuddy() {
        JTextField nameField = new JTextField(5);
        JTextField addressField = new JTextField(5);
        JTextField ageField = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Name:"));
        myPanel.add(nameField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Address:"));
        myPanel.add(addressField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Age:"));
        myPanel.add(ageField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter The Inputs", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION
                && !nameField.getText().equals(null)
                && !addressField.getText().equals(null)
                && !ageField.getText().equals(null)) {
            System.out.println("name value: " + nameField.getText());
            System.out.println("address value: " + addressField.getText());
            System.out.println("age value: " + ageField.getText());
            BuddyInfo buddy = new BuddyInfo(nameField.getText(), addressField.getText(), ageField.getText());
            addressBook.addBuddy(buddy);
        }
    }

    private void removeBuddy() {
        final int selectedValuesList = addressBook.getMyBuddies().getSelectedIndex();
        addressBook.removeBuddy(selectedValuesList);

        mainPanel.validate();
        mainPanel.repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Add Buddy")) {
            addBuddy();
        }
        else if (e.getActionCommand().equals("Remove Buddy")) {
            removeBuddy();
        }
        
    }

    public static void main(String[] args) {
        new Menu();
    }
}
