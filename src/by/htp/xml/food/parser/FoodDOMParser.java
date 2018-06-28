package by.htp.xml.food.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.htp.xml.food.entity.Food;

public class FoodDOMParser {

	public List<Food> FoodDomParser(String path) {

		List<Food> menu = new ArrayList<Food>();
		Food food = null;

		File inputFile = new File(path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("food");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				food = new Food();
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					food.setId(Integer.parseInt(eElement.getAttribute("id")));
					food.setName(getSingleChild(eElement, "name").getTextContent().trim());
					food.setPrice(Double.parseDouble(getSingleChild(eElement, "price").getTextContent().trim()));
					food.setDescription(getSingleChild(eElement, "description").getTextContent().trim());
					food.setCalories(Double.parseDouble(getSingleChild(eElement, "calories").getTextContent().trim()));
					menu.add(food);
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		return menu;

	}

	private static Element getSingleChild(Element element, String childName) {
		NodeList nlist = element.getElementsByTagName(childName);
		Element child = (Element) nlist.item(0);
		return child;
	}

}
