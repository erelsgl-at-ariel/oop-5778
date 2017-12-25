package lesson10;

import static spark.Spark.*;

public class Hello {
    public static void main(String[] args) {
        port(8080);
        get("/hello", (req, res) -> "Hello World");
    }
}
