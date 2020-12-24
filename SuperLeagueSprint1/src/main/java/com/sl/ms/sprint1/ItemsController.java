package com.sl.ms.sprint1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sl.ms.sprint1.jpa.Items;
import com.sl.ms.sprint1.jpa.ItemsRepository;

@RestController
public class ItemsController {

	@Autowired
	ItemsRepository repo;
	
	
	/*
	 * To set the default date format across the boot application
	 */
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(
	            dateFormat, false));
	}
	
	private static final Logger log = LoggerFactory.getLogger(ItemsController.class);
	
	
	/*
	 * To display the items for the day
	 */
	
	@GetMapping("/items")
	public List<Items> getItems(){
		
		List<Items> items = (List<Items>) repo.findAll();
		System.out.println("Printing all the items " + items);
		return items;
		
	}
	
	/*
	 * To display the items stock 
	 */
	
	@GetMapping("/items/stock")
	public Object[] getItemsStock(){
		
		Object[] items = repo.findAllStock();
		return items;
	}
	
	/*
	 * To display the items based on item Id
	 */
	
	@GetMapping("/items/{Id}")
	public Optional<Items> getItemsById(@PathVariable("Id") Long Id){
		
		Optional<Items> items = repo.findById(Id);
		return items;
	}
	
	/*
	 * To display the top 5 items demand for the month
	 */
	
	@GetMapping("/items/demand")
	public Iterable<Items> getItemsByDemand(Sort Quantity){
		
		Iterable<Items> items = repo.findAll(Sort.by("Quantity"));
		return items;
	}
	
	
	/*
	 * To display the items based on date 
	 */
	
	@GetMapping("/items/dateSort")
	public Iterable<Items> getItemsSortedByDate(Sort itemsDate){
		
		Iterable<Items> items = repo.findAll(Sort.by("itemsDate"));
		return items;
	}	
	

	/*
	 * To display the items quantity summary for the current date 
	 */
	
	@GetMapping("/items/summaryDay")
	public int getItemsCountday(){
		
		int items = repo.findByQuantity();
		return items;
	}
	
	/*
	 * To display the items quantity summary for the current month
	 */
	
	@GetMapping("/items/summaryMonth")
	public int getItemsCountMonth(){
		
		int items = repo.findByQuantity();
		return items;
	}
	
	
//	@SuppressWarnings("unchecked")
//	@GetMapping("items/getItemsByDate1/{itemsDate}")
//	public  List<Items> getItemsById1(@PathVariable("itemsDate") Date itemsDate){
//	
//	    Date itemsByDate = (Date) repo.findByitemsDate(itemsDate);
//		return (List<Items>) itemsByDate;
//	}
//	
//	@GetMapping("items/getItemsByDate/{itemsDate}")
//	List<Items> getItemsByDate(@RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date dateTime) {
//	    return repo.findByitemsDate(dateTime);	    
//	   
//	}
	
	
}
