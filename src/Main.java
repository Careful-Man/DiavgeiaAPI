import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;



public class Main {

	public static void main(String[] args) throws SAXException, ParserConfigurationException {
		//το scanner χρειάζεται σε πολλά σημεία οπότε υπάρχει σε μέθοδο που το επιστέφει
		Scanner user_input = ApiManage.getScanner();
		String menuSelection = "";
		
		String city;
		String searchType;
		String hospital = "";
		
		
		
		
		
		//api αντικείμενα
		//απο: Χρήστος Καραθανάσης
		ApiManage xrhstos1 = new ApiManage("https://diavgeia.gov.gr/opendata/search.xml?org=23290");
		ApiManage xrhstos2 = new ApiManage("https://diavgeia.gov.gr/opendata/search.xml?org=23290&signer%3A100047904&from_date=2019-09-1");
		
		//απο: Μάγδα Μπότου
		ApiManage magda3 = new ApiManage("https://diavgeia.gov.gr/opendata/search.xml?org=99221872&org=99221999&org=99221567&org=99221998&uid=B.1.3");
		//το 2ο αντικείμενο σχηματίζεται μεσα στα if's της επιλογής 4
		
		//απο: Ιωάννα Τζιουβάκα
		ApiManage ioanna5 = new ApiManage("https://diavgeia.gov.gr/opendata/search.xml?category=276");
		ApiManage ioanna6 = new ApiManage("https://diavgeia.gov.gr/opendata/search.xml?org=100010899&uid=86003");
		
		//απο: Θωμαή Χελιδώνη
		ApiManage thomai7 = new ApiManage("https://diavgeia.gov.gr/opendata/search.xml?org=100054501");
		ApiManage thomai8 = new ApiManage("https://diavgeia.gov.gr/opendata/search.xml?org=100054501&uid=39&from_date=2019-10-01");
		
		//απο: Θωμάς Ψαλτικίδης
		ApiManage thomas9 = new ApiManage("https://diavgeia.gov.gr/opendata/search.xml?org=99206920");
		ApiManage thomas10 = new ApiManage("https://diavgeia.gov.gr/opendata/search.xml?org=99206920&status=published&signer=100002325&from_date=2019-01-01");
		
		
		
		
		
		//Το μενού τρέχει μέχρι να δώσουμε 0.
		while(!menuSelection.equals("0")) {
			
			//Εμφανίζουμε το μενού. 
			Print.printInitialMessages();
			
			
			//Παίρνουμε την τιμή από τον χρήστη
			menuSelection = user_input.next();
			
			
			//Έλεγχος επιλογής χρήστη
			if(menuSelection.equals("1")) {//επιλογή 1
				xrhstos1.RunOption();
				
			}else if(menuSelection.equals("2")) {//επιλογή 2
				xrhstos2.RunOption();
				
			}else if(menuSelection.equals("3")) {//επιλογή 3
				magda3.RunOption();
				
			}else if(menuSelection.equals("4")) {//επιλογή 4
				//εμφάνιση πόλεων
				Print.selectCity();
			    city = user_input.next();
			    
			    if(city.equals("1")) {
			    	//εμφάνιση νοσοκομείων Θεσ/νίκης
				    Print.thessHospitals();
				    hospital = user_input.next();
				    
				    
			    }else if(city.equals("2")){
			    	//εμφάνιση νοσοκομείων Αθήνας
			        Print.athensHospitals();
				    hospital = user_input.next(); 
				    
			    }
			    //εμφάνιση τύπου πράξεων
				Print.typosPraksis();
				searchType = user_input.next();
			 
				if(city.equals("1")){
					if(hospital.equals("1") && searchType.equals("1")){
						ApiManage Magda2 = new ApiManage("https://diavgeia.gov.gr/opendata/search.xml?org=99222000&uid=B.1.3");
						Magda2.RunOption();     
					}
					if(hospital.equals("2") && searchType.equals("1")){
						ApiManage Magda2 = new ApiManage("https://diavgeia.gov.gr/opendata/search.xml?org=99221567&uid=B.1.3");
						Magda2.RunOption();
					}
					if(hospital.equals("3") && searchType.equals("1")){
						ApiManage Magda2 = new ApiManage("https://diavgeia.gov.gr/opendata/search.xml?org=99221998&uid=B.1.3");
						Magda2.RunOption();
					}
					if(hospital.equals("1") && searchType.equals("2")){
						ApiManage Magda2 = new ApiManage("https://diavgeia.gov.gr/opendata/search.xml?org=99222000&uid=B.2.1");
						Magda2.RunOption();
					}
					if(hospital.equals("2") && searchType.equals("2")){
						ApiManage Magda2 = new ApiManage("https://diavgeia.gov.gr/opendata/search.xml?org=99221567&uid=B.2.1");
						Magda2.RunOption();
					}
					if(hospital.equals("3") && searchType.equals("3")){
						ApiManage Magda2 = new ApiManage("https://diavgeia.gov.gr/opendata/search.xml?org=99221998&uid=B.2.1");
						Magda2.RunOption();
					}
				}else{
    	
					if(hospital.equals("1") && searchType.equals("1")){
						ApiManage Magda2 = new ApiManage("https://diavgeia.gov.gr/opendata/search.xml?org=99221996&uid=B.1.3");
						Magda2.RunOption();
					}
					if(hospital.equals("2") && searchType.equals("1")){
						ApiManage Magda2 = new ApiManage("https://diavgeia.gov.gr/opendata/search.xml?org=99221890&uid=B.1.3");
						Magda2.RunOption();
					}
					if(hospital.equals("3") && searchType.equals("1")){
						ApiManage Magda2 = new ApiManage("https://diavgeia.gov.gr/opendata/search.xml?org=99221927&uid=B.1.3");
						Magda2.RunOption();
					}
					if(hospital.equals("1") && searchType.equals("2")){
			            ApiManage Magda2 = new ApiManage("https://diavgeia.gov.gr/opendata/search.xml?org=99221996&uid=B.2.1");
			            Magda2.RunOption();
					}
					if(hospital.equals("2") && searchType.equals("2")){
						ApiManage Magda2 = new ApiManage("https://diavgeia.gov.gr/opendata/search.xml?org=99221890&uid=B.2.1");
						Magda2.RunOption();
					}
					if(hospital.equals("3") && searchType.equals("2")){
						ApiManage Magda2 = new ApiManage("https://diavgeia.gov.gr/opendata/search.xml?org=99221927&uid=B.2.1");
						Magda2.RunOption();
					}
				}    
        
			
			    
			}else if(menuSelection.equals("5")) {//επιλογή 5
				ioanna5.RunOption();
				
			}else if(menuSelection.equals("6")) {//επιλογή 6
				ioanna6.RunOption();
				
			}else if(menuSelection.equals("7")) {//επιλογή 7
				thomai7.RunOption();
				
			}else if(menuSelection.equals("8")) {//επιλογή 8
				thomai8.RunOption();
				
			}else if(menuSelection.equals("9")) {//επιλογή 9
				thomas9.RunOption();
				
			}else if(menuSelection.equals("10")) {//επιλογή 10
				thomas10.RunOption();
				
			}
		}		 
	}
}
	
