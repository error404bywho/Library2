package Override;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class CustomTableModel extends DefaultTableModel {

	
	 @Override
	    public boolean isCellEditable(int row, int column) {
	        return false; // Đặt trả về false để làm cho ô không thể chỉnh sửa
	    }
	
	
	public CustomTableModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomTableModel(int rowCount, int columnCount) {
		super(rowCount, columnCount);
		// TODO Auto-generated constructor stub
	}

	public CustomTableModel(Object[] columnNames, int rowCount) {
		super(columnNames, rowCount);
		// TODO Auto-generated constructor stub
	}

	public CustomTableModel(Object[][] data, Object[] columnNames) {
		super(data, columnNames);
		// TODO Auto-generated constructor stub
	}

	public CustomTableModel(Vector<?> columnNames, int rowCount) {
		super(columnNames, rowCount);
		// TODO Auto-generated constructor stub
	}

	public CustomTableModel(Vector<? extends Vector> data, Vector<?> columnNames) {
		super(data, columnNames);
		// TODO Auto-generated constructor stub
	}

	
	
}
