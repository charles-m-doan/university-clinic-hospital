package uch.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import uch.models.Identity;

public class TextTable {

	public static final String NEWLINE = System.getProperty("line.separator");

	private static final int COLUMN_PADDING = 1;

	private static final String VERT_SEP = "|";
	private static final String HOR_SEP = "-";

	private ArrayList<Identity> tableElements;
	private ArrayList<String> columnLabels;
	private ArrayList<Integer> columnWidths;

	private String formattedColumnLabels;
	private String horrizontalBorder;
	private String tableHeader;

	public TextTable(ArrayList<Identity> tableElements) throws Exception
		{
		this.tableElements = tableElements;
		if (!tableElements.isEmpty())
			{
			validateElements(tableElements);
			this.columnLabels = tableElements.get(0).getColumnLabels();
			this.columnWidths = determineColumnWidths();
			this.formattedColumnLabels = generateTableRow(columnWidths, columnLabels);
			this.horrizontalBorder = createHorrizontalBorder();
			this.tableHeader = generateTableHeader();
			}
		else
			{
			this.columnLabels = null;
			this.columnWidths = null;
			this.formattedColumnLabels = null;
			this.horrizontalBorder = null;
			this.tableHeader = null;
			}
		}

	private void validateElements(ArrayList<Identity> tableElements) throws Exception
		{
		// All elements must have same number of column labels, and number of row values must equal number of column labels
		int labelCount = tableElements.get(0).getColumnLabels().size();
		int rowValueCount = tableElements.get(0).getData().size();
		if (labelCount != rowValueCount)
			{
			throw new Exception("The number of row values must equal the number of column labels for all elements.");
			}
		for (Identity element : tableElements)
			{
			if (element.getData().size() != labelCount)
				{
				throw new Exception("All elements must have the same number of row values.");
				}
			}
		}

	private ArrayList<Integer> determineColumnWidths()
		{
		ArrayList<Integer> columnWidths = new ArrayList<Integer>();
		if (tableElements.size() > 0)
			{
			for (String label : columnLabels)
				{
				columnWidths.add(new Integer(label.length()));
				}
			for (Identity element : tableElements)
				{
				ArrayList<String> rowDataValues = element.getData();
				for (int i = 0; i < columnWidths.size(); i++)
					{
					int currentWidth = columnWidths.get(i).intValue();
					int potentialWidth = rowDataValues.get(i).length();
					if (potentialWidth > currentWidth)
						{
						columnWidths.set(i, new Integer(potentialWidth));
						}
					}
				}
			}
		return columnWidths;
		}

	private String createHorrizontalBorder()
		{
		int length = formattedColumnLabels.length();
		StringBuilder borderBuilder = new StringBuilder();
		for (int i = 0; i < length; i++)
			{
			borderBuilder.append(HOR_SEP);
			}
		return borderBuilder.toString();
		}

	public static String generateTableRow(ArrayList<Integer> columnWidths, ArrayList<String> rowValues)
		{
		StringBuilder formatStringBuilder = new StringBuilder();
		ArrayList<String> valuesToFormat = new ArrayList<String>();

		valuesToFormat.add(VERT_SEP); // Add first separator
		formatStringBuilder.append("%-2s"); // Append format string for first separator

		Iterator<String> rowValuesIterator = rowValues.iterator();
		int columnIndex = 0;
		while (rowValuesIterator.hasNext())
			{
			valuesToFormat.add(rowValuesIterator.next()); // Add next row value
			int columnWidth = columnWidths.get(columnIndex).intValue() + COLUMN_PADDING; // get column width for row value
			String rowValueFormat = "%-" + columnWidth + "s"; // create format string for row value based on column width
			formatStringBuilder.append(rowValueFormat); // append format string to overall format string builder
			if (rowValuesIterator.hasNext())
				{
				valuesToFormat.add(VERT_SEP); // Add next separator
				formatStringBuilder.append("%-2s"); // Append format string for next separator
				}
			columnIndex++;
			}

		valuesToFormat.add(VERT_SEP); // Add final separator
		formatStringBuilder.append("%1s"); // Append format string for final separator

		String formattedRow = String.format(formatStringBuilder.toString(), valuesToFormat.toArray());
		return formattedRow;
		}

	private String generateTableHeader()
		{
		StringBuilder headerBuilder = new StringBuilder();
		headerBuilder.append(horrizontalBorder);
		headerBuilder.append(NEWLINE);
		headerBuilder.append(formattedColumnLabels);
		headerBuilder.append(NEWLINE);
		headerBuilder.append(horrizontalBorder);
		return headerBuilder.toString();
		}

	public String toString()
		{
		if (tableElements.isEmpty())
			{
			return "No entries to list." + NEWLINE;
			}
		Collections.sort(tableElements);
		StringBuilder tableBuilder = new StringBuilder();
		tableBuilder.append(tableHeader);
		tableBuilder.append(NEWLINE);

		Iterator<Identity> elementsIterator = tableElements.iterator();
		while (elementsIterator.hasNext())
			{
			Identity element = elementsIterator.next();
			String formattedRow = generateTableRow(columnWidths, element.getData());
			tableBuilder.append(formattedRow);
			tableBuilder.append(NEWLINE);
			}

		tableBuilder.append(horrizontalBorder);

		return tableBuilder.toString();
		}
}
