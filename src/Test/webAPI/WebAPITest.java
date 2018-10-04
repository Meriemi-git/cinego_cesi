package Test.webAPI;
/*
 * WebAPITest.java                                20 nov. 2015
 * IUT Info1 2013-2014 Groupe 3
 */


import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 */
public class WebAPITest {

    /**
     * TODO commenter le role de la Méthode
     * @param args
     * @throws MalformedURLException 
     * @throws IOException 
     */
    public static void main(String[] args)throws MalformedURLException, IOException {
        String url = "http://www.omdbapi.com/?t=The+hobbit&y=&plot=short&r=json";
        String json = IOUtils.toString(new URL(url));
        // use the reader to read the json to a stream of tokens
        JsonReader reader = new JsonReader(new StringReader(json));
        // we call the handle object method to handle the full json object. This
        // implies that the first token in JsonToken.BEGIN_OBJECT, which is
        // always true.
        //handleObject(reader);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            System.out.println(name + " -> " +reader.nextString());
        }
        reader.endObject();

    }

    /**
     * TODO commenter le role de la Méthode
     * @param reader
     * @throws IOException 
     */
    private static void handleObject(JsonReader reader)throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            JsonToken token = reader.peek();
            if (token.equals(JsonToken.BEGIN_ARRAY))
                handleArray(reader);
            else if (token.equals(JsonToken.END_OBJECT)) {
                reader.endObject();
                return;
            } else
                handleNonArrayToken(reader, token);
        }

    }
    /**
     * Handle a json array. The first token would be JsonToken.BEGIN_ARRAY.
     * Arrays may contain objects or primitives.
     *
     * @param reader
     * @throws IOException
     */
    public static void handleArray(JsonReader reader) throws IOException
    {
        reader.beginArray();
        while (true) {
            JsonToken token = reader.peek();
            if (token.equals(JsonToken.END_ARRAY)) {
                reader.endArray();
                break;
            } else if (token.equals(JsonToken.BEGIN_OBJECT)) {
                handleObject(reader);
            } else if (token.equals(JsonToken.END_OBJECT)) {
                reader.endObject();
            } else
                handleNonArrayToken(reader, token);
        }
    }

    /**
     * Handle non array non object tokens
     *
     * @param reader
     * @param token
     * @throws IOException
     */
    public static void handleNonArrayToken(JsonReader reader, JsonToken token) throws IOException
    {
        if (token.equals(JsonToken.NAME))
            System.out.println(reader.nextName());
        else if (token.equals(JsonToken.STRING))
            System.out.println(reader.nextString());
        else if (token.equals(JsonToken.NUMBER))
            System.out.println(reader.nextDouble());
        else
            reader.skipValue();
    }
}
