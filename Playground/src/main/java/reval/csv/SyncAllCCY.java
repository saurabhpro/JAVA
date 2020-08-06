package reval.csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import static reval.csv.ResourceUtil.getResourceFile;

public class SyncAllCCY {

    static class Currency{
        public  final String client;
        public final String ccy;

        Currency(String client, String ccy) {
            this.client = client;
            this.ccy = ccy;
        }

        @Override
        public String toString() {
            return "Currency{" +
                    "client='" + client + '\'' +
                    ", ccy='" + ccy + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Currency currency = (Currency) o;
            return Objects.equals(client, currency.client) &&
                    Objects.equals(ccy, currency.ccy);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, ccy);
        }
    }

    public static void main(String[] args) {
        Path pathAll = getResourceFile("currencyAll.csv");

        try {
            Map<String, List<Currency>> map = new TreeMap<>();
            Files.lines(pathAll).forEach(line -> mapToItem(line, map));

            System.out.println(map);

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void mapToItem(String line, Map<String, List<Currency>> mapRisk) {
        //It's a BOM, which technically is not needed for utf-8 but M$ (notepad?) had the idea to put it there anyway to indicate encoding
        //Use encoding='utf-8-sig' when opening (that will just ignore it for you). See also https://docs.python.org/2/library/codecs.html#encodings-and-unicode

        String[] p = line.replace("\uFEFF", "").replace("\"", "").split(",");// a CSV has comma separated lines

        mapRisk.put(p[0], List.of(new Currency(p[1], p[2])));
    }

}
