package controllers;

import java.util.ArrayList;

import com.avce.tae.analyze.LanguageAnalyzer;
import com.avce.tae.analyze.AnalyzerFactory;
import com.avce.tae.data.NameAnalyzeData; 
import com.avce.tae.data.NameData;
import com.google.gson.Gson;

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
    InputForm inputdata = form.get();
    LanguageAnalyzer analyzer=new LanguageAnalyzer();
    String jsonstring = analyzer.getAnalyzedData(inputdata.userinput);

    Gson gson = new Gson();
    NameAnalyzeData analyzedData = gson.fromJson(jsonstring,  NameAnalyzeData.class);
    
    ArrayList<NameData> Persons = new ArrayList <NameData> ();
    ArrayList<String> Locations = new ArrayList <String> ();
    ArrayList<String> Organizations = new ArrayList <String> ();
    ArrayList<String> dates = new ArrayList <String> ();
    ArrayList<String> money = new ArrayList <String> ();
    ArrayList<String> percent = new ArrayList <String> ();
    ArrayList<String> time = new ArrayList <String> ();
    
	Persons=analyzedData.getNameDataList();
	
	return ok(output.render(Persons,analyzedData.getInputSentence()));
	
  }
    
    
}
