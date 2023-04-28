package Sub.Table;

import javax.swing.table.AbstractTableModel;

public class OnlineTask extends AbstractTableModel {
    public Object[][] data = {
            { "Java", false, false, false },
            { "ELECTIVE", false, false, false },
            { "HCI", false, false, false },
            { "CSSM", false, false, false },
            { "RPH", false, false, false },
            { "P.E", false, false, false },
            { "PC", false, false, false },
            { "CWTS", false, false, false },
            { "MATH", false, false, false },
            { "FIL", false, false, false, false, false, false },

    };

    private String[] columnNames = { "Subjects", "Act", "Quizes", "Exam" };

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

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return String.class;
        } else {
            return Boolean.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
