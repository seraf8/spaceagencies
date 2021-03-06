package com.spaceagencies.common.game;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({CardFeature.class, FeatureMoreActions.class})
public class Card {
    public enum Type {
        RESSOURCES(1 << 0), TECHNOLOGIES(1 << 1), MISSIONS(1 << 2);
        private final long flag;

        Type(long flag) {
            this.flag = flag;
        }

        public long getFlag() {
            return flag;
        }
    }
    
    @XmlElement
    protected String title;
    
    @XmlElement
    protected String shortDescription;
    @XmlElement
    protected String longDescription;
    @XmlElement
    protected String filename;
    @XmlElement
    protected String featureDescription;
    @XmlAttribute
    protected int type;
    @XmlAttribute
    protected int cost;
    
    @XmlElement
    protected int victoryPoints;

    @XmlAnyElement
    protected List<CardFeature> feature = new ArrayList<CardFeature>();
    
    
    public Card() {
        super();
    }
    public Card(String title,
                String shortDescription,
                String longDescription,
                String filename,
                String action,
                int type,
                int cost,
                int victoryPoints) {
        super();
        this.title = title;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.filename = filename;
        this.featureDescription = action;
        this.type = type;
        this.cost = cost;
        this.victoryPoints = victoryPoints;
    }

    public final int getVictoryPoints() {
        return victoryPoints;
    }

    public final String getTitle() {
        return title;
    }

    public final String getShortDescription() {
        return shortDescription;
    }

    public final String getLongDescription() {
        return longDescription;
    }

    public final String getFilename() {
        return filename;
    }

    public final String getAction() {
        return featureDescription;
    }

    public final int getType() {
        return type;
    }

    public final int getCost() {
        return cost;
    }
    
    @SuppressWarnings("unchecked")
    static public <T> T unmarshal( Class<T> docClass, InputStream inputStream )
        throws JAXBException {
        String packageName = docClass.getPackage().getName();
        JAXBContext jc = JAXBContext.newInstance( packageName );
        Unmarshaller u = jc.createUnmarshaller();
        return (T) u.unmarshal(inputStream);
    }

    public static void main(String[] args) throws Exception {
        try {
            {
                JAXBContext context = JAXBContext.newInstance(Card.class);
                Marshaller m = context.createMarshaller();
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                Card c = new Card("title", "shortDescription", "longdescription", "filename", "action", 2, 12, 0);
                c.feature.add(new FeatureMoreActions(12));
                c.feature.add(new FeatureMoreActions(13));
                File f = new File("card.xml");
                m.marshal(c, f);
            }
            {
                File f = new File("card.xml");
                Card card = unmarshal(Card.class, new FileInputStream(f));
                System.out.println(card);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
    
    public static Card getTestCard1() {
        Card c = new Card("title1", "shortDescription", "longdescription1", "filename1", "action1", 2, 12, 0);
        c.feature.add(new FeatureMoreActions(12));
        c.feature.add(new FeatureMoreActions(13));
        return c;
    }
    
    public static Card getTestCard2() {
        Card c = new Card("title2", "shortDescription2", "longdescription2", "filename2", "action2", 0, 3, 2);
        c.feature.add(new FeatureMoreActions(12));
        c.feature.add(new FeatureMoreActions(13));
        return c;
    }
    
}
