package reval.csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import static reval.csv.ResourceUtil.getResourceFile;

public class CompareCurrencyPairs {

    private static class CurrencyPair implements Comparable {
        private final String curr1;
        private final String curr2;

        private final double spotRate;

        public CurrencyPair(String curr1, String curr2, double spotRate) {
            this.curr1 = curr1;
            this.curr2 = curr2;
            this.spotRate = spotRate;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CurrencyPair that = (CurrencyPair) o;
            return Double.compare(that.spotRate, spotRate) == 0 &&
                    Objects.equals(curr1, that.curr1) &&
                    Objects.equals(curr2, that.curr2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(curr1, curr2, spotRate);
        }

        @Override
        public String toString() {
            return "CurrencyPair{" +
                    "curr1='" + curr1 + '\'' +
                    ", curr2='" + curr2 + '\'' +
                    ", spotRate=" + spotRate +
                    '}';
        }

        @Override
        public int compareTo(Object o) {
            CurrencyPair c = (CurrencyPair) o;
            if (c.curr1.equals(this.curr1) && c.curr2.equals(this.curr2) && Double.compare(c.spotRate, this.spotRate) == 0)
                return 0;
            else return Double.compare(c.spotRate, this.spotRate);
        }
    }

    public static void main(String[] args) {
        Path pathRisk = getResourceFile("currency_pairs_merged.csv");

        Path pathCnp = getResourceFile("currencyratecnp.csv");

        try {
            Map<String, Double> mapRisk = new TreeMap<>();
            Files.lines(pathRisk).forEach(line -> mapToItem(line, mapRisk));

            Map<String, Double> mapCnp = new TreeMap<>();
            Files.lines(pathCnp).forEach(line -> mapToItem(line, mapCnp));

            System.out.println("Count of risk data : " + mapRisk.size() + "\n");
            System.out.println("Count of cnp data : " + mapCnp.size() + "\n");


            for (Map.Entry<String, Double> entry : mapCnp.entrySet()) {
                if (mapRisk.containsKey(entry.getKey())) {
                    if (!mapRisk.get(entry.getKey()).equals(entry.getValue())) {
                        // System.out.println("Expected : "+ mapRisk.get(entry.getKey())+" Found: "+ entry);
                    }
                }
            }

            long count = mapCnp.entrySet().stream()
                    .filter(stringDoubleEntry -> mapRisk.containsKey(stringDoubleEntry.getKey()))
                    .filter(stringDoubleEntry -> mapRisk.get(stringDoubleEntry.getKey()).equals(stringDoubleEntry.getValue()))
                    .count();

            System.out.println();
            // System.out.println("total same : "+count);


            count = mapCnp.entrySet().stream()
                    .filter(stringDoubleEntry -> !mapRisk.containsKey(stringDoubleEntry.getKey()))
                    //.peek(System.out::println)
                    //.filter(stringDoubleEntry -> mapRisk.get(stringDoubleEntry.getKey()).equals(stringDoubleEntry.getValue()))
                    .count();
            // System.out.println("\n\ntotal not found : "+count);

            Set<String> excludeFromPreviousRun = Set.of("AUD/BND", "AUD/BRO", "AUD/PHO", "BDT/CHF", "BND/CAD", "BND/CHF", "BRO/BRL", "EUR/BND", "EUR/BRO", "EUR/PHO", "GBP/BND", "GBP/BRO", "GBP/PHO", "GHS/BYR", "IDR/JPY", "JPY/BND", "JPY/PHO", "KRW/JPY", "PHO/CAD", "PHO/CHF", "USD/BND", "USD/BRO");
            count = mapCnp.entrySet().stream()
                    .filter(stringDoubleEntry -> mapRisk.containsKey(stringDoubleEntry.getKey()))
                    .filter(stringDoubleEntry -> !mapRisk.get(stringDoubleEntry.getKey()).equals(stringDoubleEntry.getValue()))
                    .filter(stringDoubleEntry -> !excludeFromPreviousRun.contains(stringDoubleEntry.getKey()))
                    .peek(entry -> System.out.println(entry.getKey() + " Expected : " + mapRisk.get(entry.getKey()) + " Found: " + entry.getValue()))
                    .count();

            System.out.println("\nrate difference found : " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void mapToItem(String line, Map<String, Double> mapRisk) {
        //It's a BOM, which technically is not needed for utf-8 but M$ (notepad?) had the idea to put it there anyway to indicate encoding
        //Use encoding='utf-8-sig' when opening (that will just ignore it for you). See also https://docs.python.org/2/library/codecs.html#encodings-and-unicode

        String[] p = line.replace("\uFEFF", "").replace("\"", "").split(",");// a CSV has comma separated lines
        mapRisk.put(p[3], Double.parseDouble(p[2]));


    }
}
