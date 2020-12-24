package com.sl.ms.sprint1.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ItemsCommandLineRunner implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(ItemsCommandLineRunner.class);
	
	@Autowired
	private ItemsRepository repo;

	@Override
	public void run(String... args) throws Exception {
		
//		repo.save(new Items("Item1",120 ,10));
//		repo.save(new Items("Item2",50 ,80));
//		repo.save(new Items("Item3",11 ,100));
//		repo.save(new Items("Item4",25 ,300));
//		repo.save(new Items("Item5",33 ,20));
//		repo.save(new Items("Item6",20 ,0));
//		repo.save(new Items("Item7",12 ,1));
//	 
//		for (Items items: repo.findByitemsDate('01-12-2020')) {
//			log.info(items.toString());
//		}
		
		
		
	}

}
