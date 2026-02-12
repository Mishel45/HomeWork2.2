package org.skypro.skyshop.Search;

import org.skypro.skyshop.exceptions.BestResultNotFoundException;
import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searchables = new ArrayList<>();




    public void add(Searchable searchable) {
       searchables.add(searchable);
    }

    public List<Searchable> search(String query) {
        List <Searchable> results = new ArrayList<>();

        for (Searchable element : searchables) {
            if (element != null && element.getSearchTerm().contains(query)) {
                results.add(element);
            }
        }
        return results;
    }
    public void printSearchables() {

        if (searchables.isEmpty()) {
            System.out.println("Поиск не дал результатов");
            return;
        }
        for (Searchable searchable : searchables) {
            System.out.println(searchable);


        }

    }



    public Searchable findBestMatch(String search) throws BestResultNotFoundException {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : searchables) {
            if (item == null) continue;
            String term = item.getSearchTerm();
            int currentCount = countMatches(term, search);
            if (currentCount > maxCount) {
                maxCount = currentCount;
                bestMatch = item;
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFoundException(search);
        }
        return bestMatch;
    }

    private int countMatches(String str, String substring) {
        if (substring == null || substring.isEmpty()) {
            return 0;
        }
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }
}
