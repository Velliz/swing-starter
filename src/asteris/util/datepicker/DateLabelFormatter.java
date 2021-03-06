package asteris.util.datepicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JFormattedTextField.AbstractFormatter;

public class DateLabelFormatter extends AbstractFormatter {

    private String datePattern = "dd MMM yyyy";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern, new Locale("en", "US"));
    private Date predefinedDate = null;

    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            if (predefinedDate != null) return dateFormatter.format(predefinedDate);
            else return dateFormatter.format(cal.getTime());
        }

        return "";
    }

    public DateLabelFormatter() {
    }

    public DateLabelFormatter(Date date) {
        predefinedDate = date;
    }

}
