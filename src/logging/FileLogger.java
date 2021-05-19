package logging;

import main.java.logging.ILog;
import main.java.logging.TimeUnit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger implements ILog {

	private PrintWriter printer;

	public FileLogger(String fullPath) {

		try {
			BufferedWriter logFile = new BufferedWriter(new FileWriter(
					fullPath, false));
			printer = new PrintWriter(logFile);

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	@Override
	public void write(String string) {
		printer.println(string);
	}

	@Override
	public void write(long value) {
		printer.println(value);
	}

	@Override
	public void write(Object... values) {
		StringBuilder s = new StringBuilder();
		for (Object o : values)
			s.append(o.toString()).append(" ");
		printer.println(s);
	}

	@Override
	public void writeTime(long value, TimeUnit unit) {
		printer.println(TimeUnit.toTimeUnit(value, unit));
	}

	@Override
	public void writeTime(String string, long value, TimeUnit unit) {
		printer.println(string + " " + TimeUnit.toTimeUnit(value, unit));
	}

	@Override
	public void close() {
		if (printer != null)
			printer.close();
	}
}
