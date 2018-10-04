package Test.webAPI;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import javax.imageio.ImageIO;

import cineGOv02.common.entity.Film;
import cineGOv02.common.hibernate.MySQLDataSource;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.Credits;
import info.movito.themoviedbapi.model.Genre;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import info.movito.themoviedbapi.model.people.PersonCast;
import info.movito.themoviedbapi.model.people.PersonCrew;

import org.hibernate.SessionFactory;
import org.hibernate.Session;

/**
 * TODO commenter les responsabilités classe
 * @author Hugo
 *
 */
public class TestAPIbernate {

    /** TODO commenter le Champ */
    private static SessionFactory factory;
    /** TODO commenter le Champ */
    private static Session session;
    // Verrou pour gérer l'interblocage des thread

    /** URL de base pour la récupératiuon des posters de film */
    private static String baseUrlTmdb = "http://image.tmdb.org/t/p/";  
    /** Paramètre de résolution pour les poster */
    private static String sizeImage = "w500";
    /** API KEY */
    private static String apiKey = "4412ceac8d03393da24ea311a5e5cc69";
    /** Création de l'objet de l'objet d'appel de l'API tmdb */
    private static TmdbApi tmdbApi = new TmdbApi(apiKey);
    /** Initialisation de la récupération de film */
    private static TmdbMovies tmdbMovies = tmdbApi.getMovies();
    /** Objet Film à insérer en bd */
    private static Film film;
    /** Id du film */
    private static int idMovie;
    /** Film */
    private static MovieDb movie;
    /**Crédits */
    private static Credits credits;
    /** Equipe technique */
    private static ArrayList<PersonCrew> crewList;
    /** Casting */
    private static ArrayList<PersonCast> castList;
    /** Genres du film */
    private static ArrayList<Genre> genresList;
    /** TODO commenter le Champ */
    private static String titre;
    /** Synospis */
    private static String overview;
    /***/
    private static String genre;
    /** Date de sortie */
    private static String releaseDate;
    /** Durée */
    private static int runTime;
    /** Note */
    private static double rate;
    /***/
    private static String realisateur;
    /***/
    private static String casting = null;
    /***/
    private static java.sql.Date dateSortie = null;
    /** Poster au format Blob*/
    private static Blob blob = null;
    /** Pages de résultat */
    private static MovieResultsPage nowMoviesPage = tmdbMovies.getNowPlayingMovies("en", null);
    /** Liste de movie */
    private static ArrayList<MovieDb>nowMoviesList = new ArrayList<MovieDb>(nowMoviesPage.getResults());
    /** Liste de film */
    private static ArrayList<Film> filmList = new ArrayList<Film>();
    /** Tableau de couleur */
    private static String[] couleurs = {"#51574a","#447c69","#74c493","#8e8c6c",
            "#e4bf80","#e9d78d","#e2965c","#f1956f","#e16451","#c94952","#be5068",
            "#a34973","#65387d","#4e2472","#9162b6","#e278a2","#7c9fb0","#99bf87"};
    
    /** TODO commenter le Champ */
    private static java.sql.Date dateAjout = new java.sql.Date(Calendar.getInstance().getTime().getTime());

    /**
     * TODO commenter le role de la Méthode
     * @param args
     */
    public static void main(String[] args) {
        Thread t2 = new Thread() {
            public void run() {
                factory = MySQLDataSource.getInstance().getFactory();
                session = factory.openSession();
                session.getTransaction().begin();
                ArrayList<Film> filmBD = new ArrayList<Film>(session.createQuery("FROM Film").list());

                //Récupère les 20 premiers films à l'affiche
                for(int i=0; i < nowMoviesList.size(); i++){
                    idMovie = nowMoviesList.get(i).getId();
                    boolean estPresent = false;
                    if(filmBD.size()> 0){
                        for (Film  cdFilmBD : filmBD) {
                            if(cdFilmBD.getIdTMDB() == idMovie){
                                estPresent = true;
                            }
                        }
                    }
                    if(!estPresent){
                        movie = tmdbMovies.getMovie(idMovie, "en");
                        credits = tmdbMovies.getCredits(idMovie);
                        crewList = new ArrayList<PersonCrew>(credits.getCrew());
                        castList = new ArrayList<PersonCast>(credits.getCast());
                        genresList = new ArrayList<Genre>(movie.getGenres());
                        String posterPath = movie.getPosterPath();
                        titre = movie.getTitle();
                        overview = movie.getOverview();
                        if(genresList.size() > 0){
                            genre = genresList.get(0).getName();
                        }
                        genre = getGenre(genre);
                        
                        System.out.println(movie.getReleaseDate());
                        releaseDate = movie.getReleaseDate();
                        
                        runTime = movie.getRuntime() == 0 ? 120 : movie.getRuntime();
                        rate = movie.getVoteAverage();
                        realisateur = crewList.size() > 0 ? crewList.get(0).getName() : null;

                        //Obtient les 4 premiers acteurs du casting. 
                        for(int j= 0 ; j < castList.size() && j < 3; j++){
                            casting += castList.get(j).getName() + ", ";
                        }
                        if (casting.substring(0, 4).equals("null")){
                            casting = casting.substring(4, casting.length());
                        }
                        // Obtient la date
                        String[] datetoken = releaseDate.split("-");
                        String releaseDate2 = datetoken[2] + "/" + datetoken[1] + "/" + datetoken[0];
                        DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");

                        try {
                            dateSortie = new java.sql.Date(sourceFormat.parse(releaseDate2).getTime());
                        } catch (ParseException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        //Obtention de l'image à partir de l'URL et convertion en type java.SQL.blob
                        URL imageURL;
                        BufferedImage originalImage;
                        ByteArrayOutputStream baos=new ByteArrayOutputStream();
                        byte[] imageInByte;

                        try {
                            imageURL = new URL(baseUrlTmdb + sizeImage + posterPath);
                            originalImage = ImageIO.read(imageURL);
                            ImageIO.write(originalImage, "jpg", baos );
                            baos.flush();
                            imageInByte = baos.toByteArray();
                            blob = new javax.sql.rowset.serial.SerialBlob(imageInByte);
                            //Persist - in this case to a file
                            FileOutputStream fos = new FileOutputStream("outputmageName.jpg");
                            baos.writeTo(fos);
                            fos.close();
                        } catch (IOException | SQLException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        Random random = new Random();
                        int index = random.nextInt(couleurs.length-1);
                        
                        film = new Film(idMovie,titre, runTime, genre, realisateur, dateSortie, dateAjout, casting,  overview, rate, blob, couleurs[index]);
                        filmList.add(film);
                    }
                }
                for (Film ceFilm : filmList) {
                    session.save(ceFilm);
                }
                session.getTransaction().commit();
                session.close();
            }

            private String getGenre(String genre) {
                switch(genre){
                case "Action":
                    return "Action";
                case "Animation":
                    return "Animation";
                case "Adventure":
                    return "Aventure";
                case "Comedy":
                    return "Comédie";
                case "Crime":
                	return "Crime";
                case "Thriller":
                    return "Thriller";
                case "Doocumentary":
                    return "Documentaire";
                case "Drama":
                    return "Drame";
                case "Fantasy":
                    return "Fantastique";
                case "Horror":
                    return "Action";
                case "Science Fiction":
                    return "Science Fiction";
                case "Romance":
                    return "Romance";
                    default:
                        return "Autre";
                }
            }
        };
        t2.start();
    }
}