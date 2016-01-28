package SixLesson.Chapter_4_Task_3;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ShopTableModel extends AbstractTableModel {

    private int columnCount = 5;
    private ArrayList<String[]> dataArrayList;

    public ShopTableModel() {
        dataArrayList = new ArrayList<String[]>();
        for (int i = 0; i < dataArrayList.size(); i++) {
            dataArrayList.add(new String[getColumnCount()]);
        }
    }


    @Override
    public int getRowCount() {
        return dataArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] rows = dataArrayList.get(rowIndex);
        return rows[columnIndex];
    }

    public void addDate(String[] row) {
        String[] rowTable = new String[getColumnCount()];
        rowTable = row;
        dataArrayList.add(rowTable);
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "№";
            case 1:
                return "Name";
            case 2:
                return "Brand";
            case 3:
                return "Price";
            case 4:
                return "Quantity";
        }
        return "";
    }
}
