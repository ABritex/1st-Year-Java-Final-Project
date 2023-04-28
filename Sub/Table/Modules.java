package Sub.Table;

import javax.swing.table.AbstractTableModel;

public class Modules extends AbstractTableModel {
    public Object[][] data = {
            { "Java", " ", " ", " ", " ", " " },
            { "ELECTIVE", " ", " ", " ", " ", " " },
            { "HCI", " ", " ", " ", " ", " " },
            { "CSSM", " ", " ", " ", " ", " " },
            { "RPH", " ", " ", " ", " ", " " },
            { "P.E", " ", " ", " ", " ", " " },
            { "PC", " ", " ", " ", " ", " " },
            { "CWTS", " ", " ", " ", " ", " " },
            { "MATH", " ", " ", " ", " ", " " },
            { "FIL", " ", " ", " ", " ", " " },

    };

    private String[] columnNames = { "Subjects", "Module 1", "Module 2", "Module 3", "Module 4", "Module 5" };

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
}
