package project1;

import java.io.File;
import java.net.URL;

import org.eclipse.rdf4j.OpenRDFException;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.http.HTTPRepository;
import org.eclipse.rdf4j.rio.RDFFormat;

public class RdfStarter {

	public static void main(String args[]) {
		String sesameServer = "http://localhost:8080/rdf4j-server";
		String repositoryID = "rdf-triple-store";

		Repository repo = new HTTPRepository(sesameServer, repositoryID);
		repo.init();
		
		File file = new File("/Users/radhikabhavsar/rdfworkbench/project1/newrdf.rdf");
		String baseURI = "http://localhost:8080/rdf4j-server/repositories/rdf-triple-store";

		try {
		   RepositoryConnection con = repo.getConnection();
		   try {
			   System.out.println("started.");
		      con.add(file, baseURI, RDFFormat.NTRIPLES);
		   }
		   finally {
			   System.out.println("finished.");
		      con.close();
		   }
		}
		catch (OpenRDFException e) {
		   System.out.println(e);
		}
		catch (java.io.IOException e) {
			System.out.println(e);
		}
	}
}
