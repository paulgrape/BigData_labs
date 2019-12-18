import javax.xml.bind.annotation.*;

@XmlRootElement(name = "passport")
@XmlAccessorType(XmlAccessType.FIELD)
public class Passport
{
    public String number;
    public String series;

    Passport() {}

    Passport(String number, String series) {
        this.number = number;
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }
}