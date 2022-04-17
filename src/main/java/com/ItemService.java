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
	
	@POST
	@Path("/")
	//to specify the input type as form data
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	//produce a status message as an output
	@Produces(MediaType.TEXT_PLAIN)
	//specifying the form elements as parameters
	public String insertItem(@FormParam("itemCode") String itemCode,@FormParam("itemName") String itemName,
			                 @FormParam("itemPrice") String itemPrice, @FormParam("itemDesc") String itemDesc) 
	{ 
		String output = itemObj.insertItem(itemCode, itemName, itemPrice, itemDesc);
		return output;

	}


	
}
