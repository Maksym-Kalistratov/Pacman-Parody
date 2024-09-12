package Other;



import javax.swing.*;
import java.awt.*;

import java.util.List;


public class RecordsPanel extends JPanel {
    private JList<String> recordsList;

    public RecordsPanel() {
        setPreferredSize(new Dimension(450, 400));
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());

        loadRecords();

        recordsList.setBackground(Color.BLACK);
        recordsList.setForeground(Color.YELLOW);

        JScrollPane scroll = new JScrollPane(recordsList,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        add(scroll, BorderLayout.CENTER);


    }

    private void loadRecords() {
        List<Record> data = MyList.getData();
        String[] records = new String[data.size()];
        int rows = 1;
        int index = 0;
        for (Record record : data) {
            records[index] = rows + record.toString();
            index += 1;
            rows += 1;
        }

        recordsList = new JList<>(records);
    }
}
