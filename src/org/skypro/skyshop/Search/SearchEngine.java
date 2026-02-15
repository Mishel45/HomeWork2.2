package org.skypro.skyshop.Search;

import org.skypro.skyshop.exceptions.BestResultNotFoundException;
import java.util.*;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchables = new HashSet<>();

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Set<Searchable> search(String query) {
        return searchables.stream()
                .filter(s -> s.getSearchTerm().contains(query))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
    }

    public static void printSearchResults(Collection<Searchable> results) {
        if (results == null || results.isEmpty()) {
            System.out.println("Ничего не найдено");
        } else {
            for (Searchable item : results) {
                System.out.println(item.getStringRepresentation());
            }
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
