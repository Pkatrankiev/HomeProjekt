package db;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

	public static void readCinemaTheaterFile() {
		List<CinemaTheater> ListTheater = new ArrayList<>();
		int[] lineMasive = new int[200];
		int indeksMovie = 0;
		int cont = -1, y = 0;
		int CinemaColums = 0;
		int CinemaLines = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM");
		SimpleDateFormat stf = new SimpleDateFormat("HH:mm");
		List<Date> ListdateWeek = new ArrayList<>();
		Date dateMovie = null;
		Date timeMovie = null;
		float price = 0;
		boolean flDate = true;
		int countDate = 0;

		String LinkCinemaImage = null;
		String CinemaName = null;
		String CinemaAdress = null;
		File f = new File("saloni2.txt");
		if (f != null) {
			Scanner sc = null;
			try {

				sc = new Scanner(f);
				while (sc.hasNextLine()) {
					String textLine = sc.nextLine();

					StringBuilder text = new StringBuilder();
					cont = 1;
					y = 0;

					for (int i = 0; i < textLine.length(); i++) {
						if ('^' != textLine.charAt(i)) {
							text.append(textLine.charAt(i));
						} else {
							if (flDate) {
								String str = text.toString();
								str = str.trim();
								dateMovie = sdf.parse(str);
								CinemaTheater.getListdateWeek().add(dateMovie);
								countDate++;
								if (countDate == 7) {
									flDate = false;
								}
							} else {
								if (cont < 9) {
									switch (cont) {
									case 1: {
										String str = text.toString();
										str = str.trim();
										indeksMovie = Integer.parseInt(str);
									}
										break;
									case 2: {
										CinemaName = text.toString();
										CinemaName = CinemaName.trim();

									}
										break;
									case 3: {

										CinemaAdress = text.toString();
										CinemaAdress = CinemaAdress.trim();

									}
										break;
									case 4: {
										String str = text.toString();
										str = str.trim();
										dateMovie = sdf.parse(str);
									}
										break;
									case 5: {
										String str = text.toString();
										str = str.trim();
										timeMovie = stf.parse(str);
									}
										break;
									case 6: {
										String str = text.toString();
										str = str.trim();
										price = Float.parseFloat(str);
									}
										break;
									case 7: {
										String str = text.toString();
										str = str.trim();
										CinemaLines = Integer.parseInt(str);
									}
										break;
									case 8: {
										String str = text.toString();
										str = str.trim();
										CinemaColums = Integer.parseInt(str);
									}
										break;
									default:
										break;
									}

								} else {
									String str = text.toString();
									str = str.trim();
									lineMasive[y] = Integer.parseInt(str);
									y++;
								}
							}
							cont++;
							text.delete(0, text.length());

						}
					}

					int[][] massive = new int[CinemaLines][CinemaColums];
					int k = 0;
					for (int j = 0; j < CinemaLines; j++) {
						for (int j2 = 0; j2 < CinemaColums; j2++) {

							massive[j][j2] = lineMasive[k];
							k++;

						}

					}

					CinemaTheater CnmTat = new CinemaTheater(indeksMovie,
							CinemaName, CinemaAdress, dateMovie, timeMovie,
							price, CinemaLines, CinemaColums, massive);

					CinemaTheater.getListCinemaTheater().add(CnmTat);

				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

				sc.close();
			}

		} else {
			System.out.println("No such file");
		}
//		for (int i = 0; i < ListdateWeek.size(); i++) {
//			String date = sdf.format(ListdateWeek.get(i));
//			System.out.println(date);
//
//		}
	}

	public static void readMovieFile() {

		// ArrayList<Movie> ListMovie = new ArrayList<>();

		int cont = -1;

		int indeksMovie = 0;
		String linkPosterMovie = null;
		String bgNameMovie = null;
		String origNameMovie = null;
		int movieTime = 0;
		String genre = null;
		String language = null;
		String country = null;

		File f = new File("Movie.txt");
		if (f != null) {
			Scanner sc = null;
			try {

				sc = new Scanner(f);
				while (sc.hasNextLine()) {
					String textLine = sc.nextLine();
					StringBuilder text = new StringBuilder();
					cont = 1;
					for (int i = 0; i < textLine.length(); i++) {
						if ('^' != textLine.charAt(i)) {
							text.append(textLine.charAt(i));
						} else {
							switch (cont) {
							case 1: {
								String str = text.toString();
								str = str.trim();
								indeksMovie = Integer.parseInt(str);
							}
								break;
							case 2: {
								linkPosterMovie = text.toString();
								linkPosterMovie = linkPosterMovie.trim();

							}
								break;
							case 3: {

								bgNameMovie = text.toString();
								bgNameMovie = bgNameMovie.trim();

							}
								break;
							case 4: {
								origNameMovie = text.toString();
								origNameMovie = origNameMovie.trim();

							}
								break;
							case 5: {
								String str = text.toString();
								str = str.trim();
								movieTime = Integer.parseInt(str);
							}
								break;
							case 6: {
								genre = text.toString();
								genre = genre.trim();

							}
								break;
							case 7: {
								language = text.toString();
								language = language.trim();

							}
								break;
							case 8: {
								country = text.toString();
								country = country.trim();

							}
								break;
							default:
								break;
							}

							cont++;
							text.delete(0, text.length());

						}
					}
					Movie curentMovie = new Movie(indeksMovie, linkPosterMovie,
							bgNameMovie, origNameMovie, movieTime, genre,
							language, country);

					Movie.getListMovie().add(curentMovie);

				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();

			} finally {

				sc.close();
			}

		} else {
			System.out.println("No such file");
		}

	}

}