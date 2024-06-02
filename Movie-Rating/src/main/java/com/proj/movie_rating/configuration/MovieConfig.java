package com.proj.movie_rating.configuration;

import com.proj.movie_rating.model.Movie;
import com.proj.movie_rating.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class MovieConfig {

    @Order(1)
    @Bean("movieBean")
    CommandLineRunner commandLineRunner(MovieRepository repository) {
        return args -> {

            Movie oppenheimer = new Movie(
                    "Oppenheimer",
                    2023,
                    4.1f,
                    "Biography",
                    "Christopher Nolan",
                    "A dramatization of the life story of J. Robert Oppenheimer, the physicist who had a large hand in the development of the atomic bomb, thus helping end World War 2. We see his life from university days all the way to post-WW2, where his fame saw him embroiled in political machinations",
                    "784328-oppenheimer-0-1000-0-1500-crop.jpg"
            );

            Movie barbie = new Movie(
                    "Barbie: Dreamland Adventure",
                    2024,
                    3.2f,
                    "Animation",
                    "Jennifer Lee",
                    "Follow Barbie on her magical journey through Dreamland as she encounters new friends and overcomes challenges to save the kingdom from an evil sorceress.",
                    "277064-barbie-0-1000-0-1500-crop.jpg"
            );

            Movie superMarioBros = new Movie(
                    "Super Mario: Mushroom Kingdom Heroes",
                    2023,
                    4.2f,
                    "Adventure",
                    "Brad Bird",
                    "Join Mario and his friends as they embark on a thrilling adventure to rescue Princess Peach from the clutches of Bowser and save the Mushroom Kingdom from chaos.",
                    "432302-the-super-mario-bros-movie-0-1000-0-1500-crop.jpg"
            );


            Movie laLaLand = new Movie(
                    "La La Land",
                    2016,
                    4.0f,
                    "Musical",
                    "Damien Chazelle",
                    "A romantic musical drama following the love story of a jazz musician and an aspiring actress in Los Angeles.",
                    "240344-la-la-land-0-1000-0-1500-crop.jpg"
            );

            Movie theNun = new Movie(
                    "The Nun",
                    2018,
                    3.5f,
                    "Horror",
                    "Corin Hardy",
                    "A horror film in the Conjuring Universe, exploring the origin of the demonic nun Valak.",
                    "371842-the-nun-0-1000-0-1500-crop.jpg"
            );

            Movie inglouriousBasterds = new Movie(
                    "Inglourious Basterds",
                    2009,
                    4.3f,
                    "War",
                    "Quentin Tarantino",
                    "Set in Nazi-occupied France, this film follows a group of Jewish-American soldiers known as the 'Basterds' who plan to assassinate Nazi leaders.",
                    "41352-inglourious-basterds-0-1000-0-1500-crop.jpg"
            );

            Movie parasite = new Movie(
                    "Parasite",
                    2019,
                    4.6f,
                    "Thriller",
                    "Bong Joon-ho",
                    "A darkly comedic thriller about a poor family who infiltrates a wealthy household, leading to unexpected consequences.",
                    "426406-parasite-0-1000-0-1500-crop.jpg"
            );

            Movie fantasticMrFox = new Movie(
                    "Fantastic Mr. Fox",
                    2009,
                    4.2f,
                    "Animation",
                    "Wes Anderson",
                    "An animated adaptation of Roald Dahl's novel about a cunning fox who outwits three mean farmers.",
                    "46344-fantastic-mr-fox-0-1000-0-1500-crop.jpg"
            );

            Movie everythingEverywhereAllAtOnce = new Movie(
                    "Everything Everywhere All at Once",
                    2022,
                    4.5f,
                    "Sci-Fi",
                    "Daniel Kwan, Daniel Scheinert",
                    "A mind-bending sci-fi film following a woman who discovers she can access alternate realities, leading to an epic adventure.",
                    "474474-everything-everywhere-all-at-once-0-1000-0-1500-crop.jpg"
            );

            Movie cityLights = new Movie(
                    "City Lights",
                    1931,
                    4.5f,
                    "Comedy",
                    "Charlie Chaplin",
                    "A classic silent romantic comedy-drama film directed by and starring Charlie Chaplin.",
                    "51251-city-lights-0-1000-0-1500-crop.jpg"
            );

            Movie goodfellas = new Movie(
                    "Goodfellas",
                    1990,
                    4.7f,
                    "Crime",
                    "Martin Scorsese",
                    "A crime film based on the true story of Henry Hill and his life in the mob.",
                    "51383-goodfellas-0-1000-0-1500-crop.jpg"
            );

            Movie pulpFiction = new Movie(
                    "Pulp Fiction",
                    1994,
                    4.8f,
                    "Crime",
                    "Quentin Tarantino",
                    "A nonlinear crime film intertwining multiple storylines involving mobsters, boxers, and hitmen.",
                    "51444-pulp-fiction-0-1000-0-1500-crop.jpg"
            );

            Movie oldboy = new Movie(
                    "Oldboy",
                    2003,
                    4.4f,
                    "Mystery",
                    "Park Chan-wook",
                    "A South Korean neo-noir action thriller about a man who seeks revenge after being mysteriously imprisoned for 15 years.",
                    "51454-oldboy-0-1000-0-1500-crop.jpg"
            );

            Movie fightClub = new Movie(
                    "Fight Club",
                    1999,
                    4.6f,
                    "Drama",
                    "David Fincher",
                    "A cult classic film about an insomniac office worker who forms an underground fight club.",
                    "51568-fight-club-0-1000-0-1500-crop.jpg"
            );

            Movie spiritedAway = new Movie(
                    "Spirited Away",
                    2001,
                    4.8f,
                    "Animation",
                    "Hayao Miyazaki",
                    "An animated fantasy film about a young girl who enters a mysterious world ruled by spirits and witches.",
                    "51921-spirited-away-0-1000-0-1500-crop.jpg"
            );

            Movie backToTheFuture = new Movie(
                    "Back to the Future",
                    1985,
                    4.7f,
                    "Adventure",
                    "Robert Zemeckis",
                    "A science fiction adventure comedy about a teenager who accidentally travels back in time with the help of a DeLorean time machine.",
                    "51945-back-to-the-future-0-1000-0-1500-crop.jpg"
            );

            Movie perfectDays = new Movie(
                    "Perfect Days",
                    2023,
                    4.0f,
                    "Thriller",
                    "Fabien Constant",
                    "A thriller film about a woman whose romantic getaway with her boyfriend turns into a nightmare.",
                    "879229-perfect-days-0-1000-0-1500-crop.jpg"
            );

            Movie whiplash = new Movie(
                    "Whiplash",
                    2014,
                    4.5f,
                    "Drama",
                    "Damien Chazelle",
                    "A drama film about a young drummer's pursuit of perfection under an abusive instructor at a prestigious music academy.",
                    "whiplash.jpg"
            );

            Movie lionKing = new Movie(
                    "The Lion King",
                    1994,
                    4.7f,
                    "Animation",
                    "Roger Allers, Rob Minkoff",
                    "An animated musical film about a young lion prince's journey to reclaim his rightful throne after the murder of his father.",
                    "lion king.jpg"
            );

            Movie shawshankRedemption = new Movie(
                    "The Shawshank Redemption",
                    1994,
                    4.9f,
                    "Drama",
                    "Frank Darabont",
                    "A drama film based on a Stephen King novella, following the experiences of a banker who is wrongly convicted of murder.",
                    "ssr.jpg"
            );

            repository.saveAll(List.of(
                    laLaLand,
                    theNun,
                    inglouriousBasterds,
                    parasite,
                    fantasticMrFox,
                    everythingEverywhereAllAtOnce,
                    cityLights,
                    goodfellas,
                    pulpFiction,
                    oldboy,
                    fightClub,
                    spiritedAway,
                    backToTheFuture,
                    perfectDays,
                    whiplash,
                    lionKing,
                    shawshankRedemption,
                    oppenheimer,
                    superMarioBros,
                    barbie
            ));


        };
    }
}
