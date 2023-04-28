package Sub.Table;

import javax.swing.table.AbstractTableModel;

public class EnrolledSub extends AbstractTableModel {
    public Object[][] data = {
            { "Computer Programming 2 (Java)", true },
            { "IT Elective 2", true },
            { "Introdution to Human Computer Interacion", true },
            { "Computer System Service & Maintenance", true },
            { "Reading in Philippine History", true },
            { "Physical Education 2", true },
            { "Purposive Communication", true },
            { "NSTP 2 (ROTC/CWTS)", true },
            { "Discrete Mathemathics", true },
            { "Filipino 2: Sosyedad at LIteratura", true },

    };

    private String[] columnNames = { "Subjects", "Enrolled" };

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
        return true; // make the table uneditable
    }
}
