import java.awt.EventQueue;
import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Formatter;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Author: Madhav Mathur
 * Description: Automated Student Council Election system
 * 				Entries will be stored in a "result.txt" file 
 * 				in the same directory as this class.
 * Date: 18/10/15
 */

public class Main {
	static Formatter results;
	
	private static void openFile(String[] s) {
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("result.txt", true)))) {
		    for(int i = 0; i < s.length - 1; i++) {
		    	out.print(s[i] + " ");
		    }
		    out.println(s[s.length - 1]);
		}catch (IOException e) {
		    System.err.println(e);
		}
	}
	
    private static void displayOptions() {
        String[] hbCandidates = {"Sumer", "Shivam", "Parth"};
        String[] hgCandidates = {"Priyanka", "Sunalika", "Vandana"};
        String[] heCandidates = {"Hardik", "Aditi", "Soumil"};
        String[] hsbCandidates = {"Harshul", "Pranav", "Parth"};
        String[] hsgCandidates = {"Mallika", "Arunima"};
        String[] hcCandidates = {"Shrey", "Sunalika", "Arush", "Kairavi"};
        
        JComboBox headBoy = new JComboBox(hbCandidates);
        JComboBox headGirl = new JComboBox(hgCandidates);
        JComboBox headEvents = new JComboBox(heCandidates);
        JComboBox headSportsBoy = new JComboBox(hsbCandidates);
        JComboBox headSportsGirl = new JComboBox(hsgCandidates);
        JComboBox houseCaptain = new JComboBox(hcCandidates);
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Head Boy:"));
        panel.add(headBoy);
        panel.add(new JLabel("Head Girl:"));
        panel.add(headGirl);
        panel.add(new JLabel("Head of Events:"));
        panel.add(headEvents);
        panel.add(new JLabel("Head of Sports (Boy):"));
        panel.add(headSportsBoy);
        panel.add(new JLabel("Head of Sports (Girl):"));
        panel.add(headSportsGirl);
        panel.add(new JLabel("Vasundhara House Captain:"));
        panel.add(houseCaptain);
        int result = JOptionPane.showConfirmDialog(null, panel, "Student Council Elections 2016",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
        	String[] input = new String[6];
        	input[0] = (String) headBoy.getSelectedItem();
        	input[1] = (String) headGirl.getSelectedItem();
        	input[2] = (String) headEvents.getSelectedItem();
        	input[3] = (String) headSportsBoy.getSelectedItem();
        	input[4] = (String) headSportsGirl.getSelectedItem();
        	input[5] = (String) houseCaptain.getSelectedItem();
            openFile(input);
        } else {
            System.out.println("Cancelled");
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                displayOptions();
            }
        });
    }
}
