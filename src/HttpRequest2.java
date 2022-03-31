import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest2 {

    public static void main(String[] args) {
        HttpRequest2();
    }

    public static void HttpRequest2() {
        try {
            URL url = new URL("https://app.sellerchamp.com/api/deliverr/v1/shipmentrequests?status=OPEN");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("Token", "22df46125332d3034b22e83987247b68");
            con.setRequestProperty("Cookie", "ahoy_visit=46191f69-c58d-4f71-8434-52b9de794fe8; ahoy_visitor=ff7fd6f8-18cf-4c27-b1b2-114a7e5ea53b; ahoy_visit=46191f69-c58d-4f71-8434-52b9de794fe8");

            int status = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            System.out.println(status);
            System.out.println(content);

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
