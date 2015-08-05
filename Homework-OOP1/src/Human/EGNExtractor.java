package Human;

public class EGNExtractor {

		static long egn;

		public EGNExtractor(long egn) {
			this.egn = egn;
		}

	
		public static long getEgn() {
			return egn;
		}

		public static void setEgn(long egn) {
			EGNExtractor.egn = egn;
		}

		public String EGNextrakt(long egn) {
			String gender;
			if (((egn % 100) / 10) % 2 == 0) {
				gender = "Male";
			} else
				gender = "Female";
			return gender;
		}

	}


