package GUI.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionListener;

import GUI.model.Workout;;

public class WorkoutHistoryPage extends JPanel implements WorkoutHistoryPageInterface {

        String ascii = """

                        ██╗  ██╗██╗███████╗████████╗ ██████╗ ██████╗ ██╗   ██╗
                        ██║  ██║██║██╔════╝╚══██╔══╝██╔═══██╗██╔══██╗╚██╗ ██╔╝
                        ███████║██║███████╗   ██║   ██║   ██║██████╔╝ ╚████╔╝
                        ██╔══██║██║╚════██║   ██║   ██║   ██║██╔══██╗  ╚██╔╝
                        ██║  ██║██║███████║   ██║   ╚██████╔╝██║  ██║   ██║
                        ╚═╝  ╚═╝╚═╝╚══════╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝   ╚═╝

                        """;

        private final JLabel historyArt;
        private final JList<Workout> previousWorkouts;
        private final JTextArea displayWorkout;
        private final JButton back;

        private final JPanel topBar;
        private final JPanel bottomPanel;
        private final JScrollPane scrollPane;
        private final JScrollPane scrollPane2;

        private List<Workout> workoutsForController;
        private final DefaultListModel<Workout> listModel;

        public WorkoutHistoryPage() {
                setBackground(Utilities.backgroundColour);
                setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

                add(Box.createRigidArea(Utilities.buttonGap));

                topBar = new JPanel();
                topBar.setBackground(this.getBackground());
                topBar.setLayout(new BoxLayout(topBar, BoxLayout.X_AXIS));

                back = new JButton("Back");
                topBar.add(Box.createHorizontalGlue());
                topBar.add(back);
                topBar.add(Box.createHorizontalStrut(20));
                topBar.setMaximumSize(Utilities.topBarGap(topBar));

                add(topBar);

                historyArt = new JLabel(Utilities.toHtmlFormat(ascii));
                historyArt.setAlignmentX(CENTER_ALIGNMENT);
                historyArt.setHorizontalAlignment(SwingConstants.CENTER);
                add(historyArt);

                add(Box.createRigidArea(Utilities.buttonGap));

                bottomPanel = new JPanel();
                bottomPanel.setBackground(this.getBackground());

                bottomPanel.setLayout(new GridLayout(1, 2, 10, 0));

                listModel = new DefaultListModel<>();
                previousWorkouts = new JList<>(listModel);
                previousWorkouts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                previousWorkouts.setAlignmentX(LEFT_ALIGNMENT);

                scrollPane = new JScrollPane(previousWorkouts);
                scrollPane.setPreferredSize(new Dimension(250, 150));
                bottomPanel.add(scrollPane);

                displayWorkout = new JTextArea();
                displayWorkout.setAlignmentX(RIGHT_ALIGNMENT);
                displayWorkout.setEditable(false);
                displayWorkout.setLineWrap(true);
                displayWorkout.setWrapStyleWord(true);

                scrollPane2 = new JScrollPane(displayWorkout);
                scrollPane.setPreferredSize(new Dimension(250, 150));

                bottomPanel.add(scrollPane2);

                bottomPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
                add(bottomPanel);

        }

        @Override
        public void populateWorkouts(List<Workout> workouts) {
                listModel.clear();
                workoutsForController = workouts;
                for (Workout w : workouts) {
                        listModel.addElement(w);
                }
        }

        @Override
        public void previousWorkoutsListener(ListSelectionListener e) {
                previousWorkouts.addListSelectionListener(e);
        }

        @Override
        public void addBackListener(ActionListener e) {
                back.addActionListener(e);
        }

        @Override
        public void updateDisplay(String s) {
                displayWorkout.setText(s);
        }

        @Override
        public Workout getWorkoutAtIndex(int i) {
                return workoutsForController.get(i);
        }
}
