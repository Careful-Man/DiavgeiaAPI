import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Print {
	
	
	//εκτύπωση αρχικών μηνυμάτων
	public static void printInitialMessages() {
		
		System.out.println("######--- Menu Επιλογών ---######\n");
		
		//απο: Χρήστος Καραθανάσης
		System.out.println("######--- 1: Αποφάσεις της γενικής γραμματείας του πρωθυπουργού. ---######");
		System.out.println("######--- 2: Υπογεγραμένα έγγραφα της γενικής γραμματείας απο τον πρωθυπουργό απο την 1/9/2019 μέχρι σήμερα. ---######\n");
		
		//απο: Μάγδα Μπότου
		System.out.println("######--- 3: Πράξεις τύπου ανάκληση υποχρέωσης για συγκεκριμένα νοσοκομεία της Θεσσαλονίκης. ---######");
		System.out.println("######--- 4: Πράξεις επιλογής του χρήση για νοσοκομεία σε Αθήνα ή Θεσσαλονίκη. ---######\n");
		
		//απο: Ιωάννα Τζιουβάκα
		System.out.println("######--- 5: Πράξεις στην κατηγορία \"Υγεία\". ---######");
		System.out.println("######--- 6: Δωρεές και επιχορηγήσεις του υπουργείου Υγείας και κοινωνικών ασφαλίσεων. ---######\n");
		
		//απο: Θωμαή Χελιδώνη
		System.out.println("######--- 7: Πράξεις του υπουργείου παιδείας και θρησκευμάτων. ---######");
		System.out.println("######--- 8: Εγκύκλιοι του υπουργείου παιδείας και θρησκευμάτων από την 1/10/2019 μέχρι σήμερα. ---######\n");
		
		//απο: Θωμάς Ψαλτικίδης
		System.out.println("######--- 9: Πράξεις του πανεπιστημίου Πατρών. ---######");
		System.out.println("######--- 10: Δημοσιευμένες πράξεις από την 1/1/2019 μέχρι σήμερα του πανεπιστημίου Πατρών, υπογεγραμένες από την πρύτανη. ---######\n");
		
		System.out.println("######--- 0: Έξοδος ---###### ");
		System.out.println("######--- Δώστε απο το πληκτρολόγιο επιλογή και πιέστε Enter...");
		
	}
	
	
	
	//αφου επιστραφεί document, ερώτηση για εμφάνιση επόμενης σελίδας.
	public static void moreResults() {
		System.out.println("######--- 1: Εμφάνιση επόμενης σελίδας ---######");
		System.out.println("######--- 0: Tερματισμός επιλογής ---######");
	}
	
	
	
	//εκτύπωση αριθμού αποτελεσμάτων.
	public static void numberOfResults(Node total) {
		System.out.println("--- Όλα τα αποτελέσματα: ");
 	   	System.out.println(total.getTextContent());
 	   	System.out.println("-------------------------------------");
		
	}
	
	
	
	//υπολογισμός αριθμού σελίδων. 100 αποτελέσματα ανα σελίδα.
	public static int calculatePages(Node theNumberOfResults) {
		System.out.println("Αριθμός Σελίδων: " + (int) Math.ceil(Double.parseDouble(theNumberOfResults.getTextContent())/100));
		return (int) Math.ceil(Double.parseDouble(theNumberOfResults.getTextContent())/100);
	}
	
	
	
	//εκτύπωση σελίδας
	public static int printResults(NodeList apiReturnedDocPageList, int printedResults) {
		for(int n =0 ; n < apiReturnedDocPageList.getLength(); n++) {
 	     	Node result = apiReturnedDocPageList.item(n);
 	       	System.out.println("--- No: " + printedResults + " ");
 	      	System.out.println(result.getTextContent());
 	        System.out.println("-------------------------------------\n");
 	        printedResults++;
		}
		
		return printedResults;
	}
	
	
	
	
	
	//μέθοδοι για επιλογή 4
	public static void selectCity() {
		System.out.println("Επιλέξτε πόλη ");
	    System.out.println("--------------------------------------------");
	    System.out.println("Για Θεσσαλονίκη πιέστε 1");
	    System.out.println("Για Αθήνα πιέστε 2");
	}
	
	
	public static void thessHospitals() {
		System.out.println("Επιλέξτε νοσοκομείο");
	    System.out.println("---------------------------------------------");
	    System.out.println("Για το ΙΠΠΟΚΡΑΤΕΙΟ ΝΟΣΟΚΟΜΕΙΟ πιέστε 1 ");
	    System.out.println("Για το ΝΟΣΟΚΟΜΕΙΟ ΠΑΠΑΓΕΩΡΓΙΟΥ πιέστε 2");
	    System.out.println("Για το ΝΟΣΟΚΟΜΕΙΟ ΑΧΕΠΑ πιέστε 3");
	}
	
	
	public static void athensHospitals() {
		System.out.println("Επιλέξτε νοσοκομείο");
	    System.out.println("----------------------------------------------");
	    System.out.println("Για το ΓΕΝΙΚΟ ΝΟΣΟΚΟΜΕΙΟ ΑΤΤΙΚΗΣ πιέστε 1 ");
	    System.out.println("Για το ΓΕΝΙΚΟ ΝΟΣΟΚΟΜΕΙΟ ΑΘΗΝΩΝ Η 'ΕΛΠΙΣ' πιέστε 2");
	    System.out.println("Για το ΣΙΣΜΑΝΟΓΛΕΙΟ - ΑΜΑΛΙΑ ΦΛΕΜΙΓΚ πιέστε 3");
	}
	
	public static void typosPraksis() {
		System.out.println("Επιλέξτε τύπο πράξης ");
		System.out.println("----------------------------------------------");
		System.out.println("Για ΑΝΑΛΗΨΗ ΥΠΟΧΡΕΩΣΗΣ πιέστε 1 ");
		System.out.println("Για ΕΓΚΡΙΣΗ ΔΑΠΑΝΗΣ  πιέστε 2");
	}
	
	
	
}
