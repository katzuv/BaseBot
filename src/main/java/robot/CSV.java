package robot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CSV {
    private PrintWriter pw;
    private StringBuilder sb;
    private int count_args = 0;

    public CSV(String filename, String... parameters) throws FileNotFoundException {
        pw = new PrintWriter(new File(filename));
        sb = new StringBuilder();

        //Add collumn names to all rows
        for (String name : parameters) {
            sb.append(name);
            sb.append(',');
            count_args++;
        }
        sb.append('\n');
        pw.write(sb.toString());
        sb.setLength(0);


    }

    public void update(double... arguments) {
        if (arguments.length == count_args) {
            for (double arguement : arguments) {
                sb.append(arguement);
                sb.append(',');
            }
            sb.append('\n');

            pw.write(sb.toString());
            sb.setLength(0);
        } else
            throw new StackOverflowError("Amount of arguments not matching defined columns. " + arguments.length + " arguments were given, " + count_args + "were defined.");
    }

    public void close() {
        pw.close();
    }


}

