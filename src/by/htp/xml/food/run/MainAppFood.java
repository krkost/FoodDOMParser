package by.htp.xml.food.run;

import by.htp.xml.food.entity.*;
import by.htp.xml.food.parser.FoodDOMParser;

import java.util.ArrayList;
import java.util.List;

public class MainAppFood {

	public static void main(String[] args) {

		List<Food> menu = new ArrayList<Food>();
		FoodDOMParser foodParser = new FoodDOMParser();
		menu = foodParser.FoodDomParser("resources/menu.xml");

		for (Food f : menu) {
			System.out.println(f);
		}

	}
}
