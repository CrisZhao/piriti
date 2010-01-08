package name.pehl.gwt.piriti.client.converter;

import com.google.gwt.i18n.client.NumberFormat;

/**
 * Converter for double objects. Uses {@code Double.valueOf(value)} if no format
 * is specified and {@link NumberFormat#parse(String)} otherwise.
 * 
 * @author $Author$
 * @version $Revision$
 */
public class DoubleConverter extends AbstractConverter<Double>
{
    /**
     * Converts the specified value to double.
     * 
     * @param value
     *            The string to be converted
     * @param format
     *            Must be a valid number format or {@code null}
     * @return {@code null} if the value is {@code null}, empty or in the wrong
     *         format, otherwise the converted double
     * @see name.pehl.gwt.piriti.client.converter.Converter#convert(java.lang.String,
     *      java.lang.String)
     */
    @Override
    public Double convert(String value, String format)
    {
        if (isValid(value))
        {
            try
            {
                if (format == null)
                {
                    return Double.valueOf(value);
                }
                else
                {
                    return parseDouble(value, format);
                }
            }
            catch (NumberFormatException e)
            {
                return null;
            }
        }
        return null;
    }


    /**
     * Parsing happens in an extra method so it can be overwritten in unit
     * tests.
     * 
     * @param value
     * @param format
     * @return
     */
    protected Double parseDouble(String value, String format)
    {
        NumberFormat numberFormat = NumberFormat.getFormat(format);
        return numberFormat.parse(value);
    }
}