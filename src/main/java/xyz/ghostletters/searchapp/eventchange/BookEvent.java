package xyz.ghostletters.searchapp.eventchange;

import xyz.ghostletters.webapp.entity.Book;

public class BookEvent {

    private Book after;
    private Long ts_ms;

    public Book getAfter() {
        return after;
    }

    public Long getTs_ms() {
        return ts_ms;
    }
}
