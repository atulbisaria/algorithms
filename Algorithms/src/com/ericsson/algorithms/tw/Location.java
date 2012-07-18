package com.ericsson.algorithms.tw;

import java.util.HashMap;
import java.util.Map;

public class Location implements Comparable<Location> {

	private static Map<RowColumn, Location> locations = new HashMap<RowColumn, Location>();

	private RowColumn rowColumn;

	private Cell cell;

	private Location(RowColumn rowColumn) {
		this.rowColumn = rowColumn;
		this.cell = new Cell(State.DEAD);

		locations.put(this.rowColumn, this);
	}

	/**
	 * Returns a singleton instance of Location for a particular row and column
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	public static Location getLocation(int row, int column) {
		RowColumn rowColumn = new RowColumn(row, column);
		Location location = locations.get(rowColumn);
		if (location == null)
			location = new Location(rowColumn);
		return location;
	}

	public int getRow() {
		return rowColumn.getRow();
	}

	public int getColumn() {
		return rowColumn.getColumn();
	}

	public Cell getCell() {
		return cell;
	}

	public void setCell(Cell cell) {
		this.cell = cell;
	}

	@Override
	public int compareTo(Location o) {
		if (getRow() == o.getRow() && getColumn() == o.getColumn()) {
			return 0;
		} else if (getRow() >= o.getRow() && getColumn() >= o.getColumn()) {
			return 1;
		}

		return -1;
	}

	/**
	 * Inner class for holding row and column information
	 */
	private static class RowColumn {

		private int row;
		private int column;

		public RowColumn(int row, int column) {
			this.row = row;
			this.column = column;
		}

		public int getRow() {
			return row;
		}

		public int getColumn() {
			return column;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + column;
			result = prime * result + row;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			RowColumn other = (RowColumn) obj;
			if (column != other.column)
				return false;
			if (row != other.row)
				return false;
			return true;
		}
	}
}
