package com.example.inventoryservice;

import com.example.inventoryservice.inventory.Inventory;
import com.example.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("iphone_13");
			inventory.setQuantity(10);

			Inventory inventory_pro = new Inventory();
			inventory_pro.setSkuCode("iphone_13_pro");
			inventory_pro.setQuantity(500);

			Inventory inventory_pro_max = new Inventory();
			inventory_pro_max.setSkuCode("iphone_13_pro_max");
			inventory_pro_max.setQuantity(500);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory_pro);
			inventoryRepository.save(inventory_pro_max);
		};
	}

}
