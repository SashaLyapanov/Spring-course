package org.example.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Actor")
public class Actor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @ManyToMany
    @JoinTable(
            name = "actor_movie",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> movies;


    public Actor() {}

    public Actor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setId(int id) {this.id = id;}
    public int getId() {return id;}

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}

    public void setAge(int age) {this.age = age;}
    public int getAge() {return age;}

    public void setMovies(List<Movie> movieList) {this.movies = movieList;}
    public List<Movie> getMovies() {return movies;}

    public String toString() {
        return "Actor: " + name + ", age: " + age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return id == actor.id && age == actor.age && Objects.equals(name, actor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
