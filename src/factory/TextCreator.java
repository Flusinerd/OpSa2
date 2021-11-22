package factory;

public class TextCreator extends Creator{
	@Override
	public TextWriter factoryMethod() {
		// TODO Auto-generated method stub
		return new TextWriter();
	}
	
}
