import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;

class Airlines {
    String passenger_name, source, destination;
    int passenger_id;

    Airlines(String p_name, int p_id, String src, String dest) {
        passenger_name = p_name;
        passenger_id = p_id;
        source = src;
        destination = dest;
    }

    // for displaying using ArrayList
    public String toString() {
        return "Name: " + passenger_name + "  Id: " + passenger_id + "  Boarding at: " + source + "  Destination: " + destination;
    }
}

// for sorting the ArrayList
class PassengerNameComparator implements Comparator<Airlines> {
    public int compare(Airlines obj1, Airlines obj2) {
        return obj1.passenger_name.compareTo(obj2.passenger_name);
    }
}

// for exception handling of passengers
class PassengerNotFoundException extends Exception {
    PassengerNotFoundException(String str) {
        super(str);
    }
}

class AirlinesManagement {
    boolean found;
    ArrayList<Airlines> al = new ArrayList<>();

    void add_passenger(Airlines obj) {
        al.add(obj);
    }

    void search_passenger(int p_id) throws PassengerNotFoundException {
        found = al.stream().anyMatch(passenger -> passenger.passenger_id == p_id);
        if (!found) {
            throw new PassengerNotFoundException("Passenger not found in database!!!!");
        }
    }

    String display() {
        StringBuilder p_data = new StringBuilder();
        al.sort(new PassengerNameComparator());
        for (var obj : al) {
            p_data.append(obj).append("\n");
        }
        return p_data.toString();
    }
}

public class AirlinesGUI extends JFrame {
    JButton add_p, search_p, display_p, back, submit, search;
    JLabel title, p_name, p_id, src, dest, p_search, searchr;
    JTextField p_namet, p_idt, srct, destt, p_searcht;
    JTextArea passengerdata;
    AirlinesManagement am = new AirlinesManagement();

    AirlinesGUI() {
        super("Jack & Jill Airlines");
        setSize(1200, 600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Heading
        title = new JLabel("REZENZO AIRLINES");
        title.setFont(new Font("Impact", Font.BOLD, 50));
        title.setBounds(350, 50, 400, 70);

        //Buttons below header
        add_p = new JButton("Add passenger");
        add_p.setBounds(70, 150, 200, 30);

        search_p = new JButton("Search passenger");
        search_p.setBounds(430, 150, 200, 30);

        display_p = new JButton("Display Passenger");
        display_p.setBounds(800, 150, 200, 30);

        //Leftside Elements
        p_name = new JLabel("Passenger name ");
        p_name.setBounds(50, 200, 150, 30);

        p_namet = new JTextField("");
        p_namet.setBounds(150, 200, 150, 30);

        p_id = new JLabel("Passenger id ");
        p_id.setBounds(50, 250, 150, 30);

        p_idt = new JTextField("");
        p_idt.setBounds(150, 250, 150, 30);

        src = new JLabel("Boarding");
        src.setBounds(50, 300, 150, 30);

        srct = new JTextField("");
        srct.setBounds(150, 300, 150, 30);

        dest = new JLabel("Destination");
        dest.setBounds(50, 350, 150, 30);

        destt = new JTextField("");
        destt.setBounds(150, 350, 150, 30);

        //
        p_search = new JLabel("Passenger id ");
        p_search.setBounds(400, 200, 150, 30);

        p_searcht = new JTextField("");
        p_searcht.setBounds(500, 200, 150, 30);

        search = new JButton("Search");
        search.setBounds(460, 250, 150, 30);

        searchr = new JLabel("");
        searchr.setBounds(480, 280, 150, 30);

        passengerdata = new JTextArea();
        passengerdata.setBounds(750, 200, 300, 200);
        
        //Button in Footer      
        submit = new JButton("Submit");
        submit.setBounds(100, 400, 150, 30);

        back = new JButton("Go back");
        back.setBounds(1000, 450, 100, 30);

        addComponents();
        addListeners();

        setVisible(true);
    }

    private void addComponents() {
        add(title);
        add(add_p);
        add(search_p);
        add(display_p);
        add(back);
        add(p_name);
        add(p_namet);
        add(p_id);
        add(p_idt);
        add(p_search);
        add(p_searcht);
        add(src);
        add(srct);
        add(dest);
        add(destt);
        add(submit);
        add(search);
        add(searchr);
        add(passengerdata);
    }

    private void addListeners() {
        add_p.addActionListener(ae -> {
            toggleInputFields(true);
            search_p.setVisible(false);
            display_p.setVisible(false);
        });

        search_p.addActionListener(ae -> {
            p_search.setVisible(true);
            p_searcht.setVisible(true);
            search.setVisible(true);
            add_p.setVisible(false);
            display_p.setVisible(false);
        });

        search.addActionListener(ae -> {
            try {
                am.search_passenger(Integer.parseInt(p_searcht.getText()));
                searchr.setText("Passenger found");
            } catch (PassengerNotFoundException error) {
                searchr.setText("Passenger not found");
                System.out.println("Exception occurred:\n" + error);
            }
            searchr.setVisible(true);
        });

        display_p.addActionListener(ae -> {
            add_p.setVisible(false);
            search_p.setVisible(false);
            passengerdata.setText(am.display());
            passengerdata.setVisible(true);
        });

        back.addActionListener(ae -> toggleInputFields(false));

        submit.addActionListener(ae -> {
            Airlines passenger = new Airlines(p_namet.getText(), Integer.parseInt(p_idt.getText()), srct.getText(), destt.getText());
            am.add_passenger(passenger);
            clearInputFields();
        });
    }

    private void toggleInputFields(boolean visibility) {
        p_name.setVisible(visibility);
        p_namet.setVisible(visibility);
        p_id.setVisible(visibility);
        p_idt.setVisible(visibility);
        src.setVisible(visibility);
        srct.setVisible(visibility);
        dest.setVisible(visibility);
        destt.setVisible(visibility);
        submit.setVisible(visibility);
    }

    private void clearInputFields() {
        p_namet.setText("");
        p_idt.setText("");
        srct.setText("");
        destt.setText("");
    }

    public static void main(String[] args) {
        new AirlinesGUI();
    }
}
