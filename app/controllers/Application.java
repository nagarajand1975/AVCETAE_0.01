package controllers;

import java.util.ArrayList;

/*
import com.avce.tae.analyze.Analyzer;
import com.avce.tae.analyze.AnalyzerFactory;
import com.avce.tae.data.NameAnalyzeData;
import com.avce.tae.data.NameData;
import com.avce.tae.util.LanguageAnalyzer;
*/
import models.InputForm;
import play.*;
import play.mvc.*;
import play.data.*;
import views.html.*;
import scala.collection.JavaConverters; 
import static play.data.Form.*;
import play.data.validation.Constraints.*;
import views.html.*;

public class Application extends Controller {

	final static Form<InputForm> inputForm=Form.form(InputForm.class);
	
    public static Result index() {
    	return ok(index.render(form(InputForm.class)));
    }

    public static Result submit() {
    	
    Form<InputForm> form = form(InputForm.class).bindFromRequest();
    /*    if(form.hasErrors()) {
            return badRequest(index.render(form));
        } else {
        	
            InputForm inputdata = form.get();
            StanfordNLPAnalysis analysis=new StanfordNLPAnalysis();
        	//POLData data=analysis.getPOLData("Raja is living in NewYork. Nagarajan is living in California.Bill Gates is CEO of Microsoft");
            POLData data=analysis.getPOLData(inputdata.userinput);
            ArrayList<String> Persons=data.getPersonList();
            ArrayList<String> Locations=data.getLocationList();
            ArrayList<String> Organizations=data.getOrganisationList();
            return ok(test.render(Persons,Locations,Organizations));
      */
    	
    /*
    	
    	String inputSentence = "Kosgi Santosh sent an email to Stanford University at 7:30 AM. He got $70 on this get a reply. Stanford University is located in California. It is a great university, founded in 1891, having 70 percent of students.";
		LanguageAnalyzer langAnalyzer = new LanguageAnalyzer();
		
		NameAnalyzeData nameAnaData = null;
		Analyzer stanfordAnalyzer = AnalyzerFactory.getAnalyzer("STANFORD_NLP");
		System.out.println("Analyzer Name :: " + stanfordAnalyzer.getAnalyzerName());
		nameAnaData = stanfordAnalyzer.getNameData(inputSentence);
		
		ArrayList<NameData> namedata= nameAnaData.getNameDataList();
		
		*/
    
    InputForm inputdata = form.get();
    ArrayList<String> Persons = new ArrayList <String> ();
    ArrayList<String> Locations = new ArrayList <String> ();
    ArrayList<String> Organizations = new ArrayList <String> ();
		
    Persons.add("Naga");Persons.add("Winston");Persons.add("Suresh");
    Locations.add("Delhi");Locations.add("Chennai");Locations.add("Nagercoil");
    Organizations.add("AVCE");Organizations.add("CTS");Organizations.add("TCS");
		
    return ok(output.render(Persons,Locations,Organizations,inputdata.userinput));
    
	//			return ok(output.render(namedata.get(0).personList,namedata.get(0).locationList,namedata.get(0).organisationList));
    	
    	
        }

    
}
