package Sub.Table;

import javax.swing.table.AbstractTableModel;

public class ClassAbs extends AbstractTableModel {
    public Object[][] data = {
            { "Computer Programming 2 (Java)", 0 },
            { "IT Elective 2", 0 },
            { "Introdution to Human Computer Interacion", 0 },
            { "Computer System Service & Maintenance", 0 },
            { "Reading in Philippine History", 0 },
            { "Physical Education 2", 0 },
            { "Purposive Communication", 0 },
            { "NSTP 2 (ROTC/CWTS)", 0 },
            { "Discrete Mathemathics", 0 },
            { "Filipino 2: Sosyedad at LIteratura", 0 },

    };

    private String[] columnNames = { "Subjects", "Total Absences" };

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
