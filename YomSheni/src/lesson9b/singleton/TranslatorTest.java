package lesson9b.singleton;

public class TranslatorTest {

	public static void main(String[] args) {
		System.out.println(Translator1.INSTANCE.translateToEnglish("פרה"));
		System.out.println(Translator2.INSTANCE.translateToEnglish("פרה"));
	}

}
