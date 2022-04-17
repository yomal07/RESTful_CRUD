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
	
	
	@PUT
	@Path("/")
	//to specify the input type as JSON
	@Consumes(MediaType.APPLICATION_JSON)
	//produce a status message as an output
	@Produces(MediaType.TEXT_PLAIN)
	public String updateItem(String itemData) 
	{ 
		//convert the input string to JSON format
		JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject();
		
		//Read the values from the JSON object
		String itemID = itemObject.get("itemID").getAsString(); 
		String itemCode = itemObject.get("itemCode").getAsString(); 
		String itemName = itemObject.get("itemName").getAsString(); 
		String itemPrice = itemObject.get("itemPrice").getAsString(); 
		String itemDesc = itemObject.get("itemDesc").getAsString();
		
		String output = itemObj.updateItem(itemID, itemCode, itemName, itemPrice, itemDesc);
		return output;
	} 
	
	@DELETE
	@Path("/")
	//to specify the input type as XML
	@Consumes(MediaType.APPLICATION_XML)
	//to produce a status message as an output
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem(String itemData) 
	{ 
		//convert the input to XML document
		Document doc = Jsoup.parse(itemData, "", Parser.xmlParser());
		
		//read the values from the XML document
		String itemID = doc.select("itemID").text();
		
		String output = itemObj.deleteItem(itemID); 
		return output;

	}

	
}
