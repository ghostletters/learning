package xyz.ghostletters.webapp.entity.helper;

import io.quarkus.runtime.StartupEvent;
import xyz.ghostletters.webapp.entity.Author;
import xyz.ghostletters.webapp.entity.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class DataSeeder {

    @Inject
    EntityManager entityManager;

    public void onStart(@Observes StartupEvent startupEvent) {
        Book dark_tower = new Book("Dark Tower", 400);
        Book it = new Book("It", 366);
        entityManager.persist(dark_tower);
        entityManager.persist(it);

        Author steven_king = new Author("Steven King", List.of(dark_tower, it));
        entityManager.persist(steven_king);
    }
}
