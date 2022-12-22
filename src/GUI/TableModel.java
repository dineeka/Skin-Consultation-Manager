package GUI;

import w1867122.Doctor;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModel extends AbstractTableModel {
    private List<Doctor> doctorList;
    private final String[] columnNames = {"Name", "Surname", "Date of Birth", "Mobile Number", "Medical License Number", "Specialisation"};

    public TableModel(List<Doctor> list){
        this.doctorList = list;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public int getRowCount() {
        return doctorList.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Doctor doctor = doctorList.get(rowIndex);
        switch (columnIndex){
            case 0:
                return doctor.getName();
            case 1:
                return doctor.getSurname();
            case 2:
                return doctor.getDateOfBirth();
            case 3:
                return doctor.getMobileNumber();
            case 4:
                return doctor.getMedLicenceNumber();
            case 5:
                return doctor.getSpecialisation();
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Integer.class;
            case 4:
                return Integer.class;
            case 5:
                return String.class;
        }
        return null;
    }
}
