package com.spaceagencies.server.game;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.spaceagencies.client.ClientConfig;
import com.spaceagencies.common.game.Game;

public class GameSerializer {

    private Document mDocument;

    public void save(MetaGame game) {
        
        // Create saves directory
        File savesCacheDir = new File(ClientConfig.getSaveDirectoryPath("/"));
        if(!savesCacheDir.exists()) {
            savesCacheDir.mkdirs();
        }
        
        String saveFilePath = ClientConfig.getSaveDirectoryPath("previous_game.sa");
        
        File file;
        FileOutputStream fop = null;
        try {
        
        DocumentBuilderFactory documentBuilderFactory =DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder =documentBuilderFactory.newDocumentBuilder();

        mDocument = documentBuilder.newDocument();
        
        Element rootElement = mDocument.createElement("space-agencies");
        mDocument.appendChild(rootElement);
        
        
        // save global nextId
        // save both time
        // save real date
        
        serializeGame(game.getGame(), rootElement);

        
        file = new File(saveFilePath);
        
        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }
        
        fop = new FileOutputStream(file);

        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(mDocument);

        StreamResult result =  new StreamResult(new StringWriter());

      //t.setParameter(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
        transformer.transform(source, result);
        
        // get the content in bytes
        String xmlString = result.getWriter().toString();
        System.out.println(xmlString);
        byte[] contentInBytes = xmlString.getBytes();

        fop.write(contentInBytes);
        fop.flush();
        fop.close();

        System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }

    private void serializeGame(Game game, Element parentElement) {
        Element worldElement = mDocument.createElement("game");
        parentElement.appendChild(worldElement);
       
    }

}
