package front_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveDialog extends JDialog implements ActionListener {
    private JTextField fileName;
    private JButton validate;
    private JButton cancel;

    private JLabel nomLabel = new JLabel("          File name :");
    private JLabel typeLabel = new JLabel("Type :");
    private JComboBox type;
    private String name[];

    public SaveDialog(JFrame ownerWindow) {
        super(ownerWindow, true);

        this.setTitle("Save");
        JPanel mainPanel = new JPanel();
        this.setContentPane(mainPanel);
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();

        validate = new JButton("Ok");
        cancel = new JButton("Cancel");
        fileName = new JTextField(20);
        type = new JComboBox();
        type.addItem("svg");

        constr.gridy = 0;
        constr.gridx = 0;
        constr.insets.top = 10;
        mainPanel.add(nomLabel, constr);

        constr.gridy = 1;
        constr.gridx = 0;
        constr.insets.top = 0;
        constr.anchor = GridBagConstraints.EAST;
        mainPanel.add(typeLabel, constr);

        constr.gridy = 0;
        constr.gridx = 1;
        constr.insets.top = 10;
        constr.fill = GridBagConstraints.BOTH;
        constr.anchor = GridBagConstraints.CENTER;
        mainPanel.add(fileName, constr);

        constr.gridy = 1;
        constr.gridx = 1;
        constr.insets.top = 0;
        mainPanel.add(type, constr);

        constr.gridy = 2;
        constr.gridx = 0;
        constr.insets.top = 10;
        constr.insets.bottom = 10;
        constr.fill = GridBagConstraints.NONE;
        constr.anchor = GridBagConstraints.EAST;
        mainPanel.add(validate, constr);

        constr.gridy = 2;
        constr.gridx = 1;
        constr.anchor = GridBagConstraints.CENTER;
        mainPanel.add(cancel, constr);

        validate.addActionListener(this);
        cancel.addActionListener(this);
        this.pack();
    }

    public String[] showDialog() {
        this.setVisible(true);
        return name;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == validate) {
            name = new String[2];
            name[0] = fileName.getText();
            name[1] = type.getSelectedIndex() + "";
            this.setVisible(false);
        }
        if (e.getSource() == cancel) {
            name = null;
            this.setVisible(false);
        }
    }
}
