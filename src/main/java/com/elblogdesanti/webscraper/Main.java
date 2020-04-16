package com.elblogdesanti.webscraper;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.opencsv.CSVWriter;

public class Main {

	public static void main(String[] args) throws URISyntaxException, IOException {

		String csv = "writtenAll.csv";
		CSVWriter writer = new CSVWriter(new FileWriter(csv, true));

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.apple.com/ipad/");

		WebElement pro = driver.findElement(By.xpath("//p[@data-pricing-id=\"ipad-pro\"]"));
		WebElement air = driver.findElement(By.xpath("//p[@data-pricing-id=\"ipad-air\"]"));
		WebElement ipad = driver.findElement(By.xpath("//p[@data-pricing-id=\"ipad-10-2\"]"));
		WebElement mini = driver.findElement(By.xpath("//p[@data-pricing-id=\"ipad-mini\"]"));

		List<String[]> priceList = new ArrayList<String[]>();
		priceList.add(new String[] { "Model", "Price" });
		priceList.add(new String[] { "iPad Pro", pro.getText() });
		priceList.add(new String[] { "iPad Air", air.getText() });
		priceList.add(new String[] { "iPad", ipad.getText() });
		priceList.add(new String[] { "iPad Mini", mini.getText() });

		writer.writeAll(priceList);
		writer.close();
		driver.quit();
	}
}
