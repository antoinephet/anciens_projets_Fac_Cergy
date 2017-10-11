package service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path(value="/banque")
public class BanqueService {
	@GET
	@Path(value="/message")
	@Produces(MediaType.TEXT_PLAIN)
	
	public String test() {
		
		return "Test";
		
	}
	
	
	@GET
	@Path(value="/conversion/{montant}")
	@Produces(MediaType.APPLICATION_JSON)
	public double conversuin(@PathParam(value="montant")double mt) {
		
		return mt*11;
		
	}
	
	@GET
	@Path(value="/liste")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> list() {
		
		List<String> res=new ArrayList<String>();
		res.add("Mr Dupont");
		res.add("Miss Nottingham");
		res.add("Mr Courtois");
		return res;
	
	}
	
	@GET
	@Path(value="/comptes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Compte> getComptes() {
		
		List<Compte> cptes=new ArrayList<Compte>();
		cptes.add(new Compte(1,5000));
		cptes.add(new Compte(2,3000));
		return cptes;
		
		
	
	}


}
