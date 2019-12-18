import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "citizen")
@XmlAccessorType(XmlAccessType.FIELD)
public class Citizen
{
    public String first_name;
    public String second_name;
    public String fathers_name;
    public Passport passport;

    public Citizen(String first_name, String second_name, String fathers_name, Passport passport) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.fathers_name = fathers_name;
        this.passport = passport;
    }

    Citizen() {}

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getFathers_name() {
        return fathers_name;
    }

    public void setFathers_name(String fathers_name) {
        this.fathers_name = fathers_name;
    }


    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}