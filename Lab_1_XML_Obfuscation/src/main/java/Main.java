import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.File;

@XmlSeeAlso({CitizensList.class})
public class Main {
    public static void main(String[] args) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(CitizensList.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        CitizensList citizens = (CitizensList) jaxbUnmarshaller.unmarshal( new File("./src/main/resources/Citizens.xml") );
        citizens.citizens = citizens.obfuscateCitizens(citizens.citizens);
        jaxbMarshaller.marshal(citizens, new File("./src/main/resources/ObfuscatedCitizens.xml"));

        CitizensList obfuscatedCitizens = (CitizensList) jaxbUnmarshaller.unmarshal( new File("./src/main/resources/ObfuscatedCitizens.xml") );
        citizens.citizens = citizens.deobfuscateCitizens(obfuscatedCitizens.citizens);
        jaxbMarshaller.marshal(citizens, new File("./src/main/resources/DeobfuscatedCitizens.xml"));

    }
}
