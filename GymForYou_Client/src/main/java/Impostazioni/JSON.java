package Impostazioni;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSON {

    private JSONObject object;
    private JSONParser parser;
    private Date today;
    private Calendar calendar;
    private int format;

    public JSON() {
        parser = new JSONParser();
        
    }

    public String ScriviJson(Map elementi) {
        setObject(new JSONObject());
        if (!elementi.isEmpty()) {
            Iterator it = elementi.entrySet().iterator(); //cerca su internet
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next(); //chiave - valore 
                String key = (String) pair.getKey();
                String value = (String) pair.getValue();
                getObject().put(key, value);
                it.remove();
            }

        }
        return getObject().toJSONString();
    }

    /**
     *
     * @param is
     * @return
     */
    public Map LeggiJson(InputStream is) {
        Map dati = new HashMap();
        try {
            Object parse = getParser().parse(new InputStreamReader(is));
            JSONObject jsonObject = (JSONObject) parse; //casting implicito

            Iterator iterator = jsonObject.keySet().iterator();
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                String value = (String) jsonObject.get(key);
                dati.put(key, value);
            }

        } catch (IOException ex) {
            System.out.println("ERRORE I/O" + ex);
        } catch (ParseException ex) {
            System.out.println("IMPOSSIBILE PARSARE IL FILE I/O" + ex);
        }

        return dati;
    }

    /**
     * @return the object
     */
    public JSONObject getObject() {
        return object;
    }
    
    public String getDate() {
        today = calendar.getTime();
        DateFormat dateFormat = DateFormat.getDateInstance(format, Locale.ITALY);
        return dateFormat.format(today);
    }

    /**
     * @param object the object to set
     */
    public void setObject(JSONObject object) {
        this.object = object;
    }

    /**
     * @return the parser
     */
    public JSONParser getParser() {
        return parser;
    }

    /**
     * @param parser the parser to set
     */
    public void setParser(JSONParser parser) {
        this.parser = parser;
    }

}

