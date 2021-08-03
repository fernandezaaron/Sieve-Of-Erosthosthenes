import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class frame extends JFrame {

    JButton get, clear;
    JButton[] blocks = new JButton[10001];
    JTextField inputtextfield;
    JLabel inputlabel;
    JPanel container, panel;
    JScrollPane scroll;
    int value;
    int[] num = new int[10001];



    public frame (){
        super("Sieve of Erostosthenes");
        setSize(1280,720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        container = new JPanel();
        container.setLayout(new GridBagLayout());
        container.setBackground(Color.ORANGE);

        panel = new JPanel();
        scroll = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.setLayout(new GridLayout(10,10));
        panel.setBackground(Color.BLACK);


        clear = new JButton(new AbstractAction("Clear") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == clear){
                    value = Integer.valueOf(inputtextfield.getText());
                    for(int i=1; i<=value;i++){
                        panel.remove(blocks[i]);
                    }
                    add(scroll, BorderLayout.CENTER);
                    setVisible(true);
                    scroll.setVisible(false);
                    scroll.setVisible(true);
                    get.setEnabled(true);
                    inputtextfield.setEditable(true);
                    System.out.println("asdf");
                    inputtextfield.setText("");

                }

            }
        });

        get = new JButton(new AbstractAction("Input") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == get) {

                    value = Integer.valueOf(inputtextfield.getText());
                    System.out.println("i got " + value);

                    panel.setLayout(new GridLayout(5, 8));


                        for (int i = 1; i <= value; i++) { //initializer(creates blocks)
                            blocks[i] = new JButton();
                            blocks[i].setText(String.valueOf(i));
                            num[i] = Integer.parseInt(blocks[i].getText());
                            num[i]=i;
                            panel.add(blocks[i]);
                            blocks[i].setEnabled(false);

                        }
                        add(scroll, BorderLayout.CENTER);
                        setVisible(true);

                        for(int i=2; i<=value; i++){
                            if(!Boolean.valueOf(String.valueOf(num[i]))){
                                for(int j=i; j<=value; j+=i)
                                    blocks[i].setBackground(Color.GREEN);

                            }
                        }

                        for (int i =2; i<=value; i++){ //iterates through the value
                            System.out.println(Boolean.valueOf(String.valueOf(num[i])));
                            System.out.println(String.valueOf(num[i]));
                            if(num[i] != 0) { //checks if the value of num[i] is not yet null or not yet zero
                                for (int j = i * i; j <= value; j += i) { //loop to get multiples/ non prime numbers
                                    num[j] = 0; //basically this block eliminates the non-prime numbers
                                    blocks[j].setBackground(Color.yellow);
                                }
                            }
                        }
                        get.setEnabled(false);
                        inputtextfield.setEditable(false);

                }


                }

        });

        inputtextfield = new JTextField(10);

        inputlabel = new JLabel("Input: ");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);

        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;

        gbc.gridx = 0;
        gbc.gridy = 0;
        container.add(inputlabel, gbc);


        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridx = 1;
        gbc.gridy = 0;
        container.add(inputtextfield, gbc);

        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;

        gbc.gridx=1;
        gbc.gridy=1;
        gbc.fill = GridBagConstraints.BOTH;
        container.add(get, gbc);

        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        container.add(clear,gbc);


        add(scroll,BorderLayout.CENTER);
        add(container, BorderLayout.PAGE_START);
        setVisible(true);

    }
}
