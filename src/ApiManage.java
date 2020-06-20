import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ApiManage {
	
	
	private String uri;
	private String uriWithPage;
	
	
	
	
	//αυτα τα 2 πεδια πρεπει ΠΑΝΤΑ να εχουν αυτες τιμες
	public final String getText = "subject";
	public final String getNumberOfResults = "total";
	
	
	public ApiManage(String someUri) {
		this.uri = someUri;
		this.uriWithPage = someUri + "&page=";
	}
	
	
	public void RunOption() {
		try {
			//Δημιουργούμε τα κατάλληλα αντικείμενα για να διαχειριστούμε την απάντηση από το API
			Document apiReturnedDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new URL(this.uri).openStream());
				
			NodeList apiReturnedDocSelectedElementList = apiReturnedDoc.getElementsByTagName(getNumberOfResults);
			Node theNumberOfResults = apiReturnedDocSelectedElementList.item(0);
			
			
			//Αριθμός αποτελεσμάτων 
		 	Print.numberOfResults(theNumberOfResults);
		 	
	 	    
		 	//Υπολογισμός σελίδων (τυπωση μηνυμάτων και return τον αριθμό των σελίδων) 
	 	    int numberOfPages = Print.calculatePages(theNumberOfResults);
	 	    
	 	    
	 	    int printedResults = 1;
	 	    String pageShow = "";
	 	    
	 	   
	 	    for(int j=0; j<numberOfPages; j++){
	 	    	
	 	    	//Ζητάμε από τον χρήστη να δώσει 1 για να πάρει τα επόμενα 100 αποτελέσματα 
 	    		Print.moreResults();
				//Παίρνουμε την τιμή από τον χρήστη		  
				pageShow = getScanner().next();
				
				
				if(pageShow.equals("1")) {
					//Δημιουργούμε τα κατάλληλα αντικείμενα για να διαχειριστούμε την απάντηση από το API 
					//Χρησιμοποιούμε την μεταβλητή page για να πάρουμε την σελίδα που θέλουμε	
					Document apiReturnedDocPage = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new URL(
					this.uriWithPage + j).openStream());
	 	    	
					//Επιλέγουμε το XML tag που μας ενδιαφέρει. Δημιουργούμε μια λίστα από Nodes. 
					//Κάθε Node έχει και το περιεχόμενο του tag για κάθε απόφαση. 
					NodeList apiReturnedDocPageList = apiReturnedDocPage.getElementsByTagName(getText);
					
					//Παίρνουμε ένα-ένα τα Nodes και προβάλουμε το περιεχόμενο τους.
					printedResults = Print.printResults(apiReturnedDocPageList, printedResults);
					 
					
				}else if(pageShow.equals("0")) {
					break;
				}
			}
	 	    

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//σημείο αναφοράς για εισαγωγή τιμών απο το πληκτρολόγιο.
	public static Scanner getScanner() {
		return new Scanner(System.in);
	}
	
	
	

}
