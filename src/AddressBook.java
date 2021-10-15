import javax.swing.*;

/**
 * Author: Ngo Huu Gia Bao
 * ID: 101163137
 */
public class AddressBook extends DefaultListModel {
    private DefaultListModel<BuddyInfo> listModel;
    private JList<BuddyInfo> myBuddies;

    public AddressBook() {
        listModel = new DefaultListModel<>();
        myBuddies = new JList<>(listModel);
    }


    /**
     * Add method for aBuddy ArrayList
     * Assume that there is a duplication
     * @param aBuddy
     */
    public void addBuddy(BuddyInfo aBuddy) {
        if(aBuddy != null) {
            listModel.addElement(aBuddy);
        }
    }

    /**
     * Remove method for aBuddy ArrayList
     //* @param aBuddy
     */
    public void removeBuddy(int index) {
        listModel.remove(index);
    }


    public JList<BuddyInfo> getMyBuddies() {
        return myBuddies;
    }

    public DefaultListModel<BuddyInfo> getListModel() {
        return listModel;
    }
}

