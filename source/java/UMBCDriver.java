public class UMBCDriver{
  public static void main(String[] args)
  {
    UMBCer bryan = new UMBCer("Bryan","Wilkinson");

    System.out.println(bryan);

    bryan.setBirthday(10,2,1987);
    System.out.println(bryan.getBirthday());
  }
}
