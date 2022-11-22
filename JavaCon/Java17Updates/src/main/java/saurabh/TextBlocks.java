package saurabh;

public class TextBlocks {
    public static void main(String[] args) {
        final String html = """
                <html>
                    <body>
                        <p>Hello, world</p>
                    </body>
                </html>
                """;

        System.out.println(html);

        final var formatted = "%s is not same as %s".formatted("❤️", "🫦");
        System.out.println(formatted);
    }
}
