import java.util.*;

public class DVD {	
	private List movies=new ArrayList();	
	public DVD(){}
	public List getMovies() {
		return movies;
	}
	public void setMovies(List movies) {
		this.movies = movies;
	}	
	public String toString(){
		String movies="";
		Movie movie = null;
		for(Object object:getMovies()){
			movie = (Movie)object;
			movies += movie.getName()+", ";
			movies +=movie.getDirectors()+", ";
			movies += movie.getRuntime()+", ";
			movies += movie.getReleased()+", ";
			movies += movie.getReleased()+", ";
			movies += movie.getCast()+", ";
		}
		return movies; 
		
	}	
 }