package tn.cynapsys.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scraping/info")
public class Scraper {

	
	
	
	
	@RequestMapping(value = "/all/{tt}", method = RequestMethod.GET)
	public List<String> getResult(@PathVariable String tt) throws IOException {
		 
		
		URL url = new URL("http://www.aeroport-tunis-carthage.com/horaires-departs-aeroport-tunis-carthage.php");
		Document doc = Jsoup.parse(url, 10000);

		//Element table = doc.select("table[class=table table-striped]").first();

		ArrayList<String> downServers= new ArrayList<>();;
		Element table = doc.select("table[class=table table-striped]").get(0); //select the first table.
		Elements rows = table.select("tr");
		Elements Jour = doc.select("a[href]");
		String jourPrecedant="";
		System.out.println(tt);
		if(tt.equals("taw")){
			downServers = new ArrayList<>();
			System.out.println("enter1");
		for (int i = 0; i < rows.size(); i++) { //first row is the col names so skip it.
		    Element row = rows.get(i);
		    Elements cols = row.select("td");
		    for (int j = 0; j < cols.size(); j++) 
		    downServers.add(cols.get(j).text());
		    
		    
		}
		
		} if(tt.equals("emes"))
		{		System.out.println("enter2");
		for (int i = 0; i < Jour.size(); i++) { //first row is the col names so skip it.
		    Element row = Jour.get(i);
		    if(row.text().equals("Jour précédent"))
		    	jourPrecedant=row.attr("abs:href");   
		}
		
		System.out.println(jourPrecedant);
		URL url2 = new URL(jourPrecedant);
		Document doc2 = Jsoup.parse(url2, 3000);
		Element table2 = doc2.select("table[class=table table-striped]").get(0); //select the first table.
		Elements rows2 = table2.select("tr");
		downServers = new ArrayList<>();
		for (int i = 0; i < rows2.size(); i++) { //first row is the col names so skip it.
		    Element row = rows2.get(i);
		    Elements cols = row.select("td");
		    for (int j = 0; j < cols.size(); j++) 
		    downServers.add(cols.get(j).text());
		    
		    
		}
		
		}
	
		
		return downServers;

	}

}
