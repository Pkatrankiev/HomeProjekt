package db;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import javax.swing.JButton;

public class WriteFile {

	public static void WriteCinemaTheaterFile(JButton[][] btnSeat,
			CinemaTheater theaterProjection) {

		CreatSeatMasive(btnSeat, theaterProjection);

		String[] textLines = CreatTextMasive();

		saveCinemaTheaterFile(textLines);
		
		String[] textLinesCustomer = CreatTextMasiveCutomer();
		
		saveCustomerFile(textLinesCustomer);
		

	}

	private static String CreatFirstLine() {
		StringBuilder textAll = new StringBuilder();

		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM");

		for (int i = 0; i < 7; i++) {

			textAll.append(sdf.format(CinemaTheater.getListdateWeek().get(i))
					+ " ^ ");
		}
		String firstLine = textAll.toString();
		return firstLine;
	}

	private static void CreatSeatMasive(JButton[][] btnSeat,
			CinemaTheater theaterProjection) {

		for (int i = 0; i < CinemaTheater.getListCinemaTheater().size(); i++) {

			if (CinemaTheater.getListCinemaTheater().get(i)
					.equals(theaterProjection)) {

				int ll = CinemaTheater.getListCinemaTheater().get(i).getLines();
				int cc = CinemaTheater.getListCinemaTheater().get(i)
						.getColumns();

				int[][] mind = new int[ll][cc];

				for (int j = 0; j < ll; j++) {
					for (int k = 0; k < cc; k++) {

						if (btnSeat[j][k].getText().equals("0")
								|| btnSeat[j][k].getText().equals("1")) {

							mind[j][k] = 1;

						} else {

							mind[j][k] = -1;
						}
					}
				}

				CinemaTheater.getListCinemaTheater().get(i).setSeat(mind);
				break;
			}

		}
	}

	private static String[] CreatTextMasive() {

		// textAll = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM");
		SimpleDateFormat stf = new SimpleDateFormat("HH:mm");
		int countCinemaTheatetr = CinemaTheater.getListCinemaTheater().size();
		String[] textLines = new String[countCinemaTheatetr];

		for (int i = 0; i < countCinemaTheatetr; i++) {
			StringBuilder textAll = new StringBuilder("");
			textAll.append(String.valueOf(CinemaTheater.getListCinemaTheater()
					.get(i).getIndeksMovie())
					+ " ^ ");
			textAll.append(CinemaTheater.getListCinemaTheater().get(i)
					.getName()
					+ " ^ ");
			textAll.append(CinemaTheater.getListCinemaTheater().get(i)
					.getAdres()
					+ " ^ ");
			textAll.append(sdf.format(CinemaTheater.getListCinemaTheater()
					.get(i).getDate())
					+ " ^ ");
			textAll.append(stf.format(CinemaTheater.getListCinemaTheater()
					.get(i).getTime())
					+ " ^ ");
			textAll.append(String.valueOf(CinemaTheater.getListCinemaTheater()
					.get(i).getPrice())
					+ " ^ ");
			int lines = CinemaTheater.getListCinemaTheater().get(i).getLines();
			textAll.append(String.valueOf(lines) + " ^ ");
			int ccolums = CinemaTheater.getListCinemaTheater().get(i)
					.getColumns();
			textAll.append(String.valueOf(ccolums) + " ^ ");

			for (int j = 0; j < lines; j++) {
				for (int k = 0; k < ccolums; k++) {

					textAll.append(String.valueOf(CinemaTheater
							.getListCinemaTheater().get(i).getSeat()[j][k])
							+ " ^ ");
				}
			}
			// System.out.println(i+" "+textAll.toString());
			textLines[i] = textAll.toString();
		}
		return textLines;
	}

	static void saveCinemaTheaterFile(String[] textLines) {

		PrintStream fileWriter = null;
		try {
			fileWriter = new PrintStream("saloni2.txt");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		fileWriter.println(CreatFirstLine());

		for (int i = 0; i < textLines.length; i++) {
			fileWriter.println(textLines[i]);

		}

		fileWriter.close();
	}

	private static String[] CreatTextMasiveCutomer() {

		
		int countCustomer = Customer.getListCustomer().size();
		String[] textLines = new String[countCustomer];

		for (int i = 0; i < countCustomer; i++) {
			StringBuilder textAll = new StringBuilder("");
			
			textAll.append((Customer.getListCustomer().get(i).getName())
					+ " ^ ");
			textAll.append(Customer.getListCustomer().get(i).getFamily()
					+ " ^ ");
			textAll.append(Customer.getListCustomer().get(i).getAdress()
					+ " ^ ");
			textAll.append(Customer.getListCustomer().get(i).getNameTheater()
					+ " ^ ");
			textAll.append(Customer.getListCustomer().get(i).getAdressTheater()
					+ " ^ ");
			textAll.append(Customer.getListCustomer().get(i).getNameMovie()
					+ " ^ ");
			textAll.append(Customer.getListCustomer().get(i).getDate()
					+ " ^ ");
			textAll.append(Customer.getListCustomer().get(i).getTime()
					+ " ^ ");
			textAll.append(Customer.getListCustomer().get(i).getPrice()
					+ " ^ ");
			int numberTiket = Customer.getListCustomer().get(i).getNumberTickets();
			textAll.append(String.valueOf(numberTiket) + " ^ ");
			
			for (int j = 0; j < numberTiket; j++) {
				

					textAll.append(Customer.getListCustomer().get(i).getThiket()[j]
							+ " ^ ");
				
			}
			
			textLines[i] = textAll.toString();
		}
		return textLines;
	}	

	static void saveCustomerFile(String[] textLinesCustomer) {

		PrintStream fileWriter = null;
		try {
			fileWriter = new PrintStream("Customer.txt");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		
		for (int i = 0; i < textLinesCustomer.length; i++) {
			fileWriter.println(textLinesCustomer[i]);

		}

		fileWriter.close();
	}
}
