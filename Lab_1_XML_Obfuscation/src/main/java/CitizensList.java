import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "citizens")
@XmlRootElement
public class CitizensList
{

    @XmlElement(name = "citizen")
    public List<Citizen> citizens;

    public CitizensList(List<Citizen> citizens) {
        this.citizens = citizens;
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public List<Citizen> obfuscateCitizens(List<Citizen> citizens) {
        for (Citizen citizen : citizens) {
            citizen.setFirst_name(ObfuscateDeobfuscateTool.obfuscate(citizen.getFirst_name()));
            citizen.setSecond_name(ObfuscateDeobfuscateTool.obfuscate(citizen.getSecond_name()));
            citizen.setFathers_name(ObfuscateDeobfuscateTool.obfuscate(citizen.getFathers_name()));
            citizen.setPassport(new Passport(ObfuscateDeobfuscateTool.obfuscate(citizen.getPassport().getSeries()), ObfuscateDeobfuscateTool.obfuscate(citizen.getPassport().getNumber())));
        }
        return citizens;
    }

    public List<Citizen> deobfuscateCitizens(List<Citizen> citizens) {
        for (Citizen citizen : citizens) {
            citizen.setFirst_name(ObfuscateDeobfuscateTool.deobfuscate(citizen.getFirst_name()));
            citizen.setSecond_name(ObfuscateDeobfuscateTool.deobfuscate(citizen.getSecond_name()));
            citizen.setFathers_name(ObfuscateDeobfuscateTool.deobfuscate(citizen.getFathers_name()));
            citizen.setPassport(new Passport(ObfuscateDeobfuscateTool.deobfuscate(citizen.getPassport().getSeries()), ObfuscateDeobfuscateTool.deobfuscate(citizen.getPassport().getNumber())));
        }
        return citizens;
    }

    CitizensList() {}
}