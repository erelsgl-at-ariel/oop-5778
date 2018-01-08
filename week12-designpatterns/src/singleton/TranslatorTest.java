package singleton;

public class TranslatorTest {

	public static void main(String[] args) {
		//new Translator1();
		//Translator1.INSTANCE = null;
		
		System.out.println(Translator1.INSTANCE.translateToEnglish("פרה"));
		System.out.println(Translator2.INSTANCE.translateToEnglish("פרה"));
		System.out.println(Translator3.getInstance().translateToEnglish("פרה"));
	}

}
