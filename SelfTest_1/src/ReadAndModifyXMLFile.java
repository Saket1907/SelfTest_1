import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadAndModifyXMLFile {

	public static void main(String argv[]) {

		try {
			String filepath = "C:\\Users\\saku.isaket\\Desktop\\TestXML.xml";
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);

			Node staff = doc.getElementsByTagName("ns5:createFulfillmentOrderRequest").item(0);

			// loop the staff child node
			NodeList list = staff.getChildNodes();
			// String
			// str="partyNameString,cityName,cityName,uspsPostalCd,uspsPostalCdExtension";

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				/*
				 * partyNameString, cityName, uspsPostalCd,
				 * uspsPostalCdExtention
				 */
				if ("partyNameString".equals(node.getNodeName())) {
					node.setTextContent("RealTimeConstants.RESTRICTED");
				}

				if ("cityName".equals(node.getNodeName())) {
					node.setTextContent("RealTimeConstants.RESTRICTED");
				}
				if ("uspsPostalCd".equals(node.getNodeName())) {
					node.setTextContent("RealTimeConstants.RESTRICTED_ZIP_CODE");
				}
				if ("uspsPostalCdExtension".equals(node.getNodeName())) {
					node.setTextContent("RealTimeConstants.RESTRICTED_ZIP_EXTENTION");
				}
				/* formattedPostalLines */
				if ("formattedPostalAddressLines".equals(node.getNodeName())) {
					NodeList list1 = doc.getElementsByTagName(node.getNodeName()).item(0).getChildNodes();
					for (int j = 0; j < list1.getLength(); j++) {
						Node node1 = list1.item(j);
						if ("postalAddressLine1".equals(node1.getNodeName())) {
							node1.setTextContent("RealTimeConstants.RESTRICTED");
						}
						if ("postalAddressLine2".equals(node1.getNodeName())) {
							node1.setTextContent("RealTimeConstants.RESTRICTED");
						}
						if ("postalAddressLine3".equals(node1.getNodeName())) {
							node1.setTextContent("RealTimeConstants.RESTRICTED");
						}
					}
				}
				/* contactPhoneNumber */
				if ("ns5:contactPhoneNumber".equals(node.getNodeName())) {
					NodeList list1 = doc.getElementsByTagName(node.getNodeName()).item(0).getChildNodes();
					for (int j = 0; j < list1.getLength(); j++) {
						Node node1 = list1.item(j);
						if ("telecomNumber".equals(node1.getNodeName())) {
							NodeList list2 = doc.getElementsByTagName(node1.getNodeName()).item(0).getChildNodes();
							for (int k = 0; k < list2.getLength(); k++) {
								Node node2 = list2.item(k);
								if ("npaNumber".equals(node2.getNodeName())) {
									node2.setTextContent("RealTimeConstants.RESTRICTED_NPA");
								}
								if ("nxxNumber".equals(node2.getNodeName())) {
									node2.setTextContent("RealTimeConstants.RESTRICTED_NXX");
								}
								if ("phoneLineNumber".equals(node2.getNodeName())) {
									node2.setTextContent("RealTimeConstants.RESTRICTED_PHONE_LINE");
								}
							}
						}
					}
				}
				/* emailAddress */
				if ("ns5:emailAddress".equals(node.getNodeName())) {
					NodeList list1 = doc.getElementsByTagName(node.getNodeName()).item(0).getChildNodes();
					for (int j = 0; j < list1.getLength(); j++) {
						Node node1 = list1.item(j);
						if ("emailAddressString".equals(node1.getNodeName())) {
							node1.setTextContent("RealTimeConstants.RESTRICTED");
						}
					}
				}

				/* orderItemPhoneNumber */
				if ("ns5:orderItem".equals(node.getNodeName())) {
					NodeList list1 = doc.getElementsByTagName(node.getNodeName()).item(0).getChildNodes();
					for (int j = 0; j < list1.getLength(); j++) {
						Node node1 = list1.item(j);
						if ("ns5:subOrderItem".equals(node1.getNodeName())) {
							NodeList list2 = doc.getElementsByTagName(node1.getNodeName()).item(0).getChildNodes();
							for (int k = 0; k < list2.getLength(); k++) {
								Node node2 = list2.item(k);
								if ("mobileDirectoryNumber".equals(node2.getNodeName())) {
									NodeList list3 = doc.getElementsByTagName(node2.getNodeName()).item(0)
											.getChildNodes();
									for (int l = 0; l < list3.getLength(); l++) {
										Node node3 = list3.item(l);
										if ("npaNumber".equals(node3.getNodeName())) {
											node3.setTextContent("RealTimeConstants.RESTRICTED_NPA");
										}
										if ("nxxNumber".equals(node3.getNodeName())) {
											node3.setTextContent("RealTimeConstants.RESTRICTED_NXX");
										}
										if ("phoneLineNumber".equals(node3.getNodeName())) {
											node3.setTextContent("RealTimeConstants.RESTRICTED_PHONE_LINE");
										}
									}
								}
							}
						}
					}
				}
			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filepath));
			transformer.transform(source, result);

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}
	}
}
