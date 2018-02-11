import java.util.Random;
import java.util.GregorianCalendar;

public class UMBCer{
    private String firstName;
    private String lastName;
    private String email;
    private String id;
    private GregorianCalendar birthday;

    private static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Random rnd = new Random();

    public UMBCer(String firstName, String lastName)
    {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = firstName + "." + lastName + "@umbc.edu";

        this.id = alphabet.charAt(rnd.nextInt(alphabet.length())) + "" +  alphabet.charAt(rnd.nextInt(alphabet.length())) +
                  String.valueOf(rnd.nextInt(9) + 1) + String.valueOf(rnd.nextInt(9) + 1)  +
                  String.valueOf(rnd.nextInt(9) + 1) + String.valueOf(rnd.nextInt(9) + 1);
    }

    public String getID(){
      return id;
    }

    public String toString(){
      return "UMBCer " + id + ": " + firstName + " " + lastName;
  }




    public void setBirthday(GregorianCalendar date){
        this.birthday = (GregorianCalendar)date.clone();
    }

    public void setBirthday(int month, int day, int year){
        this.birthday = new GregorianCalendar(year,month,day);
    }


    public GregorianCalendar getBirthday(){

     return  (GregorianCalendar)birthday.clone();
 }
}
