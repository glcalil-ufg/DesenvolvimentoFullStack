package br.ufg.inf.fsspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.ufg.inf.fsspring.entities.Hospedagem;
import br.ufg.inf.fsspring.entities.Hospede;
import br.ufg.inf.fsspring.entities.Hotel;
import br.ufg.inf.fsspring.entities.Quarto;
import br.ufg.inf.fsspring.enums.CategoriaQuarto;
import br.ufg.inf.fsspring.repositories.HotelRepository;
import br.ufg.inf.fsspring.repositories.QuartoRepository;
import br.ufg.inf.fsspring.repositories.HospedeRepository;
import br.ufg.inf.fsspring.repositories.HospedagemRepository;
import br.ufg.inf.fsspring.repositories.RegraRepository;
import br.ufg.inf.fsspring.repositories.UsuarioRepository;
import br.ufg.inf.fsspring.entities.Regra;
import br.ufg.inf.fsspring.entities.Usuario;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
@Profile("dev")
public class Config  implements CommandLineRunner{

	@Autowired
	private HotelRepository hoteRepository;
	
	@Autowired
	private QuartoRepository quartoRepository;

	@Autowired
	private HospedeRepository hospedeRepository;

	@Autowired
	private HospedagemRepository hospedagemRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private RegraRepository regraRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		/*
		 * INSERIR NO MEU BANCO DE DADOS INFORMAÇÕES INICIAIS...
		 * */

		 String[] tipoH = new String[]{"Hotel","Pousada","Resort","Hostel","Pensao"};
		 String[] nomeH = new String[]{"da rainha","do norte","the shiren","da ilha","da tia do guarda chuva"};
		 String[] localH = new String[]{"KingsLand","Winterfel","Terra Média","Ilha Nublar","Raccon City"};

		 for(int i = 0; i<50;i++){
			 String nome = tipoH[new Random().nextInt(5)]+" "+nomeH[new Random().nextInt(5)];
			 String local = localH[new Random().nextInt(5)];
			 Integer estrelas = new Random().nextInt(5)+1;
			 Hotel novoH = new Hotel(null,nome,local,estrelas);
			 hoteRepository.save(novoH);
		 }
		
		Hotel h1 = new Hotel(null, "Calderão Furado", "Beco Diagonal", 3);
		Hotel h2 = new Hotel(null, "Bates Hotel", "White Pine Bay", 2);
		Hotel h3 = new Hotel(null, "Hotel Overlook", "Colorado", 4);
		Hotel h4 = new Hotel(null, "Continental Hotel", "New York City", 5);
		
		h1 = hoteRepository.save(h1);
		h2 = hoteRepository.save(h2);
		h3 = hoteRepository.save(h3);
		h4 = hoteRepository.save(h4);
		
		Quarto q1 = new Quarto(null, h1, CategoriaQuarto.APARTAMENTO, 4, 1010, 200.0); 
		Quarto q2 = new Quarto(null, h2, CategoriaQuarto.SIMPLES, 1, 7, 100.0);
		Quarto q3 = new Quarto(null, h3, CategoriaQuarto.PADRAO, 2, 306, 150.0);
		Quarto q4 = new Quarto(null, h4, CategoriaQuarto.LUXO, 3, 1313, 500.0);
        
        q1 = quartoRepository.save(q1);
        q2 = quartoRepository.save(q2);
        q3 = quartoRepository.save(q3);
        q4 = quartoRepository.save(q4);

		Hospede p1 = new Hospede(null,"Hommer Simpson", 123456, null);
		Hospede p2 = new Hospede(null,"Harry Potter", 153624, null);
		Hospede p3 = new Hospede(null,"John Snow", 1362475, null);
		Hospede p4 = new Hospede(null,"Dracula BlaBlaBla", 150219, null);

		p1 = hospedeRepository.save(p1);
		p2 = hospedeRepository.save(p2);
		p3 = hospedeRepository.save(p3);
		p4 = hospedeRepository.save(p4);

		Hospedagem hp1 = new Hospedagem(null, q1.getIdQuarto(), p1.getIdHospede(),null, null);
		Hospedagem hp2 = new Hospedagem(null, q2.getIdQuarto(), p2.getIdHospede(),null, null);
		Hospedagem hp3 = new Hospedagem(null, q3.getIdQuarto(), p3.getIdHospede(),null, null);
		Hospedagem hp4 = new Hospedagem(null, q4.getIdQuarto(), p4.getIdHospede(),null, null);

		hp1 = hospedagemRepository.save(hp1);
		hp3 = hospedagemRepository.save(hp2);
		hp2 = hospedagemRepository.save(hp3);
		hp4 = hospedagemRepository.save(hp4);


		Regra r1 = regraRepository.save(new Regra("ADMIN"));
		Regra r2 = regraRepository.save(new Regra("USER"));
		Regra r3 = regraRepository.save(new Regra("GUEST"));

		List<Regra> regras = new ArrayList<Regra>();

		regras.add(r1);
		regras.add(r2);


		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		Usuario usu1 = usuarioRepository.save(new Usuario("luiz", "Luiz Martins", encoder.encode("4321"), regras));

		regras = new ArrayList<Regra>();

		regras.add(r2);
		regras.add(r3);

		Usuario usu2 = usuarioRepository.save(new Usuario("jose", "Jose Silva", encoder.encode("asdf"), regras));


	}

}