package org.example;


import org.example.models.Actor;
import org.example.models.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        Configuration configuration = new Configuration().addAnnotatedClass(Actor.class).addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        //try with Resources (переданный ресурс в блок try будет автоматически закрыт, после окончания блока)
        try(sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            //Создание фильма и актеров и взаимное добавление
//            Movie movie = new Movie("Криминальное чтиво", 1994);
//            Actor actor1 = new Actor("Harvey Kyitel", 81);
//            Actor actor2 = new Actor("Samuel L. Jackson", 72);
//
//            movie.setActors(new ArrayList<>(List.of(actor1, actor2)));
//            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//
//            session.save(movie);
//            session.save(actor1);
//            session.save(actor2);

            //Добавление нового фильма существующему актеру.
//            Movie movie = new Movie("Reservoir Dogs", 1992);
//            Actor actor = session.get(Actor.class, 1);
//
//            movie.setActors(new ArrayList<>(Collections.singletonList(actor)));
//            actor.getMovies().add(movie);
//
//            session.save(movie);

            Actor actor = session.get(Actor.class, 2);
            System.out.println(actor.getMovies());
            Movie movieToRemove = actor.getMovies().get(0);
            actor.getMovies().remove(movieToRemove);
            movieToRemove.getActors().remove(actor);



            session.getTransaction().commit();
        }


    }
}
