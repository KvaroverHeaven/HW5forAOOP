package HW5forAOOP;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import static javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MCTFrame extends JFrame {

    private static final long serialVersionUID = -7259883849855380164L;

    public MCTFrame() {
        super("Archon");
        add(new MCTPanel(), BorderLayout.CENTER);
    }
}

class MCTPanel extends JPanel {

    private static final long serialVersionUID = 7965716575980985622L;
    private String startStr = "開始執行背景工作\n";
    private String endStr = "背景工作已完成\n";

    public MCTPanel() {
        super();
        setLayout(new GridBagLayout());
        var c = new GridBagConstraints();
        var jButton = new JButton("Job");

        var jTextArea = new JTextArea(10, 10);
        jTextArea.setEditable(false);
        jTextArea.setVisible(true);
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);

        var textScrollPane = new JScrollPane(jTextArea);
        textScrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);

        c.weightx = 0.1;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.PAGE_START;
        c.insets = new Insets(20, 20, 5, 20);
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 0;
        add(jButton, c);

        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.insets = new Insets(5, 20, 20, 20);
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        add(textScrollPane, c);

        jButton.addActionListener(e -> {
            if (!jButton.isEnabled()) {
                return;
            }

            jButton.setEnabled(false);

            new Thread(() -> {
                try {
                    jTextArea.append(startStr);
                    Thread.sleep(10000);

                    jTextArea.append(endStr);
                    jButton.setEnabled(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }).start();
        });

    }
}