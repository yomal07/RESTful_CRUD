package com;

//import the model class
import model.Item;

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 

@Path("/Items")
public class ItemService {
	
	//creating an object from the item class
	Item itemObj = new Item();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String raedItems()
	{
		return itemObj.readItems();
	}
	
}
