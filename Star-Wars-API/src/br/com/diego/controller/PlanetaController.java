package br.com.diego.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.eclipse.persistence.oxm.MediaType;

import br.com.diego.entity.Planeta;
import br.com.diego.http.PlanetaHttp;
import br.com.diego.repository.PlanetaRepository;

@Path("/service")
public class PlanetaController {
	
	private final PlanetaRepository repository = new PlanetaRepository();
	
	RestTemplate restTemplate = new RestTemplate();
	Planeta planeta = restTemplate.getForObject("https://swapi.com/", Planeta.class);
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/cadastrar")
	public Response cadastrar(PlanetaHttp planeta, @Context UriInfo uriInfo) {
		
		Planeta planeta_entity = new Planeta();
		
		try {
			planeta_entity.setNome(planeta.getNome());
			planeta_entity.setClima(planeta.getClima());
			planeta_entity.setTerreno(planeta.getTerreno());
			planeta_entity.setQuant_filmes(planeta.getQuant_filmes());
			
			repository.Salvar(planeta_entity);
			
			UriBuilder builder = uriInfo.getAbsolutePathBuilder();
			builder.path(Integer.toString(produto.getCodigo()));
			return Response.created(builder.build()).build();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			return "Erro ao cadastrar registro " + e.getMessage();
		}
	}
	
	@GET
	@Path("/todos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PlanetaHttp> TodosPlanetas(){
		
		List<PlanetaHttp> planetaHttp = new ArrayList<PlanetaHttp>();
		
		List<Planeta> listaPlanetas = repository.TodosPlanetas();
		
		for(Planeta planeta:listaPlanetas) {
			planetaHttp.add(new PlanetaHttp(planeta.getCod_planeta(),planeta.getNome(), planeta.getClima(), 
					planeta.getTerreno(), planeta.getQuant_filmes()));
		}
		
		return planetaHttp;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getplanetaCodigo/{codigo}")
	public PlanetaHttp TodosPlanetas(@PathParam("codigo") int id){
		
		try {
		Planeta planeta = repository.PlanetasId(id);
		
			return new PlanetaHttp(planeta.getId_planeta(), planeta.getNome(), planeta.getClima(), 
					planeta.getTerreno(), planeta.getQuant_filmes());
		
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getplanetapornome/{nome}")
	public PlanetaHttp planetasNome(@PathParam("nome") String nome){
		
		try {
		Planeta planeta = repository.PlanetasNome(nome);
		
			return new PlanetaHttp(planeta.getId_planeta(), planeta.getNome(), planeta.getClima(), 
					planeta.getTerreno(), planeta.getQuant_filmes());
		
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/excluir/{codigo}")
	public String excluir(@PathParam("codigo") Integer codigo) {
		try {
			
			repository.ExcluirPlaneta(codigo);
			
			return "Resgistro excluido com sucesso!";
			
		}catch (Exception e) {
			return "Erro ao excluir o resgistro " + e.getMessage();
		}
	}
	

}