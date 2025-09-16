public class HelloWorld {
    public static void main(String[] args) {
      HelloWorldHelper helper = new HelloWorldHelper ();
      
      System.out.println(helper.useEnglish());
      System.out.println(helper.useGerman());
      System.out.println(helper.useJapanese());
      System.out.println(helper.useSpanish());
    }
}