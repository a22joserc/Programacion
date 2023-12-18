package gestionpodcast;

public class Consultas {
	
	public final static String SELECT_ALL_PODCASTS = "SELECT * FROM Podcast";
	public final static String SELECT_ALL_GENEROS = "SELECT * FROM Generos";
	public final static String SELECT_AUTOR_FROM_ID = "SELECT * FROM Autor WHERE idAutor=?";
	public final static String SELECT_DNI_APELLIDOS_NOMBRE_AUTOR = "SELECT dni, apellidos, nombre FROM Autor WHERE idAutor=?";
	public final static String SELECT_GENEROS_PODCAST = "select g.idGeneros, g.nombre from Generos g, gen_pod gp, Podcast pd where pd.idPodcast=gp.idPodcat and gp.idGenero=g.idGeneros and pd.idPodcast=?";
	public final static String INSERT_INTO_PODCAST = "INSERT INTO Podcast VALUES(?,?,?,?,?,?,?,?)";
	public final static String INSERT_INTO_GEN_POD = "INSERT INTO gen_pod VALUES(?,?)";
	public final static String INSERT_INTO_GENEROS = "INSERT INTO Generos VALUES(?,?)";
	public final static String SELECT_NUM_IDGENEROS = "SELECT count(*) FROM Generos WHERE idGeneros=?"; 
	public final static String DELETE_GEN_POD = "delete from gen_pod where idPodcat=? and idGenero=?";
	public final static String UPDATE_GEN_POD = "update gen_pod set idGenero=? where idPodcat=? and idGenero=?";
	public final static String DELETE_GEN_POD_IDPODCAST = "DELETE FROM gen_pod WHERE idPodcat=?";
	public final static String DELETE_PODCAST_IDPODCAST = "DELETE FROM Podcast WHERE idPodcast=?";
	public final static String SELECT_NUM_IDPODCAST = "SELECT count(*) FROM Podcast WHERE idPodcast=?";
	public final static String SELECT_NUM_IDAUTOR = "SELECT count(*) FROM Autor WHERE idAutor=?";
	public final static String SELECT_NUM_GENEROS_ID = "SELECT count(idGeneros) FROM Generos WHERE idGeneros=?";;
	public final static String SELECT_NOMBRE_GENERO = "SELECT nombre FROM Generos WHERE idGeneros=?";

}
