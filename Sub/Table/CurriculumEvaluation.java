package Sub.Table;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class CurriculumEvaluation extends AbstractTableModel {
    public Object[][] data = {
            { "1st-1Sem", "", " ", " ", " " },
            { "CC1103", "Computer Programming 1 (Java)", 3, 96, " " },
            { "CC1102", "Computer Programming ", 3, 95, " " },
            { "IE1101", "IT Elective 1", 3, 83, " " },
            { "PL1101", "Web System and technology 1", 3, 88, " " },
            { "CC1101", "Introduction to Computing", 3, 85, " " },
            { "PE1101", "Physical Education 1", 2, 90, " " },
            { "GE1102", "Understanding the Self", 3, 84, " " },
            { "NS1101", "NSTP 1 (ROTC/CWTS)", 3, 89, " " },
            { "GE1101", "Mathematics in the Modern World", 3, 80, " " },
            { "GE1103", "Filipino 1: Kontekstualisadong Komunikasyon sa Filipino", 3, 84, " " },
            { "1st-2Sem", "", " ", " ", " " },
            { "CC1204", "Computer Programming 2 (Java)", 3, " ", " " },
            { "IE1202", "IT Elective 2", 3, " ", " " },
            { "PC1202", "Introdution to Human Computer Interacion", 3, " ", " " },
            { "CC1205", "Computer System Service & Maintenance", 3, " ", " " },
            { "GE1204", "Reading in Philippine History", 3, " ", " " },
            { "PE1102", "Physical Education 2", 2, " ", " " },
            { "GE1205", "Purposive Communication", 3, " ", " " },
            { "NS1202", "NSTP 2 (ROTC/CWTS)", 3, " ", " " },
            { "PC1201", "Discrete Mathemathics", 3, " ", " " },
            { "GE1206", "Filipino 2: Sosyedad at LIteratura", 3, " ", " " },

    };

    private String[] columnNames = { "Code", "Subjects", "Units", "Grades", "Remarks" };

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

    public JTable getColumnModel() {
        return null;
    }
}
