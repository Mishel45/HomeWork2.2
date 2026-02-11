package org.skypro.skyshop.Search;

import org.skypro.skyshop.exceptions.BestResultNotFoundException;

public class SearchEngine {
    private final Searchable[] searchables;
    private int count = 0;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public void add(Searchable searchable) {
        if (count < searchables.length) {
            searchables[count] = searchable;
            count++;
        } else {
            System.out.println("Поисковый массив заполнен");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultsCount = 0;
        for (Searchable item : searchables) {
            if (item == null) break;
            if (item.getSearchTerm().contains(query)) {
                results[resultsCount] = item;
                resultsCount++;
            }
            if (resultsCount == 5) break;
        }
        return results;
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
