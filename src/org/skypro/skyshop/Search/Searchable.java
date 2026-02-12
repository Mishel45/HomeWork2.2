package org.skypro.skyshop.Search;

public interface Searchable {
    String getName();

    String getSearchTerm();

    String getContentType();

    default String getStringRepresentation() {
        return getName() + " - " + getContentType();
    }
}
