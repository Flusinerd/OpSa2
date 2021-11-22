package factory;

public class CsvCreator extends Creator {

	@Override
	public Writer factoryMethod() {
		// TODO Auto-generated method stub
		return new CSVWriter();
	}
}
