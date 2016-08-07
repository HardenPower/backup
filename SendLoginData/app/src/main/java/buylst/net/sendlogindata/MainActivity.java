package buylst.net.sendlogindata;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static class HttpUtility {

        /**
         * Represents an HTTP connection
         */
        private static HttpURLConnection httpConn;

        /**
         * Makes an HTTP request using GET method to the specified URL.
         *
         * @param requestURL
         *            the URL of the remote server
         * @return An HttpURLConnection object
         * @throws IOException
         *             thrown if any I/O error occurred
         */
        public static HttpURLConnection sendGetRequest(String requestURL)
                throws IOException {
            URL url = new URL(requestURL);
            httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setUseCaches(false);

            httpConn.setDoInput(true); // true if we want to read server's response
            httpConn.setDoOutput(false); // false indicates this is a GET request

            return httpConn;
        }

        /**
         * Makes an HTTP request using POST method to the specified URL.
         *
         * @param requestURL
         *            the URL of the remote server
         * @param params
         *            A map containing POST data in form of key-value pairs
         * @return An HttpURLConnection object
         * @throws IOException
         *             thrown if any I/O error occurred
         */
        public static HttpURLConnection sendPostRequest(String requestURL,
                                                 Map<String, String> params) throws IOException {
            URL url = new URL(requestURL);
            httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setUseCaches(false);

            httpConn.setDoInput(true); // true indicates the server returns response

            StringBuffer requestParams = new StringBuffer();

            if (params != null && params.size() > 0) {

                httpConn.setDoOutput(true); // true indicates POST request

                // creates the params string, encode them using URLEncoder
                Iterator<String> paramIterator = params.keySet().iterator();
                while (paramIterator.hasNext()) {
                    String key = paramIterator.next();
                    String value = params.get(key);
                    requestParams.append(URLEncoder.encode(key, "UTF-8"));
                    requestParams.append("=").append(
                            URLEncoder.encode(value, "UTF-8"));
                    requestParams.append("&");
                }

                // sends POST data
                OutputStreamWriter writer = new OutputStreamWriter(
                        httpConn.getOutputStream());
                writer.write(requestParams.toString());
                writer.flush();
            }

            return httpConn;
        }

        /**
         * Returns only one line from the server's response. This method should be
         * used if the server returns only a single line of String.
         *
         * @return a String of the server's response
         * @throws IOException
         *             thrown if any I/O error occurred
         */
        public static String readSingleLineRespone() throws IOException {
            InputStream inputStream = null;
            if (httpConn != null) {
                inputStream = httpConn.getInputStream();
            } else {
                throw new IOException("Connection is not established.");
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    inputStream));

            String response = reader.readLine();
            reader.close();

            return response;
        }

        /**
         * Returns an array of lines from the server's response. This method should
         * be used if the server returns multiple lines of String.
         *
         * @return an array of Strings of the server's response
         * @throws IOException
         *             thrown if any I/O error occurred
         */
        public static String[] readMultipleLinesRespone() throws IOException {
            InputStream inputStream = null;
            if (httpConn != null) {
                inputStream = httpConn.getInputStream();
            } else {
                throw new IOException("Connection is not established.");
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    inputStream));
            List<String> response = new ArrayList<String>();

            String line = "";
            while ((line = reader.readLine()) != null) {
                response.add(line);
            }
            reader.close();

            return (String[]) response.toArray(new String[0]);
        }

        /**
         * Closes the connection if opened
         */
        public void disconnect() {
            if (httpConn != null) {
                httpConn.disconnect();
            }
        }
    }




    }

