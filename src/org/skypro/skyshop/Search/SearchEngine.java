package org.skypro.skyshop.Search;

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
}
