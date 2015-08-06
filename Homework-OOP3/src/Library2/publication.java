package Library2;

import java.util.ArrayList;

public class publication {

	public boolean employed;
	public String title;

	public publication(String title, boolean employed) {

		this.employed = employed;
		this.title = title;

	}

	public boolean isEmployed() {
		return employed;
	}

	public void setEmployed(boolean employed) {
		this.employed = employed;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void Book() {
		this.setEmployed(true);
	}

	public void Return() {
		this.setEmployed(false);
	}

	public static void getDetails(publication pub) {
		String Employed;
		if (pub.isEmployed()) {
			Employed = "Zaeta";
		} else
			Employed = "Svoboden";
		if (pub instanceof Book) {
			System.out
					.printf("Knigata \" %s\" s awtor %s e %s",
							((Book) pub).getTitle(), ((Book) pub).getAuthor(),
							Employed);
		} else
			System.out.printf("Vestnikat \" %s\" s data na isdawane %s e %s",
					((newspaper) pub).getTitle(),
					((newspaper) pub).getDateOfIssue(), Employed);

	}

	public static void opisFreePublic() {
		for (publication pub : Library.allPublication) {

			if (!pub.isEmployed()) {
				if (pub instanceof Book) {
					System.out.printf("%nImeto na knigata \" %s\" s awtor %s.",
							((Book) pub).getTitle(), ((Book) pub).getAuthor());
				} else
					System.out
							.printf("%nImeto na westnika \" %s\" s data na isdawane %s.",
									((newspaper) pub).getTitle(),
									((newspaper) pub).getDateOfIssue());

			}
		}
	}
}
