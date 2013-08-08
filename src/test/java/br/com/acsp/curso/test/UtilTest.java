/**
 * 
 */
package br.com.acsp.curso.test;

import br.com.acsp.curso.domain.clazz.Aeronave;
import br.com.acsp.curso.domain.clazz.Aluno;
import br.com.acsp.curso.domain.clazz.Atendente;
import br.com.acsp.curso.domain.clazz.Instrutor;
import br.com.acsp.curso.domain.clazz.Socio;
import br.com.acsp.curso.domain.enumerator.Escolaridade;

/**
 * @author eduardobregaida
 * 
 */
public class UtilTest {

	public static Aluno populaAluno() {
		Aluno aluno = new Aluno();
		aluno.setAlistamentoMilitar(123L);
		aluno.setCht(184L);
		aluno.setCma(12L);
		aluno.setCodigoANAC(1777L);
		aluno.setCpf(34915298876L);
		aluno.setEscolaridade(Escolaridade.SUPERIOR);
		aluno.setNome("Eduardo");
		aluno.setNomePista("Maverick");
		aluno.setRg(222222222L);
		aluno.setTituloEleitor(1244323L);
		aluno.setAtivo(true);
		return aluno;
	}

	public static Instrutor populaInstrutor() {
		Instrutor instrutor = new Instrutor();
		instrutor.setAlistamentoMilitar(123L);
		instrutor.setCht(184L);
		instrutor.setCma(12L);
		instrutor.setCodigoANAC(1777L);
		instrutor.setCpf(34915298876L);
		instrutor.setEscolaridade(Escolaridade.SUPERIOR);
		instrutor.setId(1L);
		instrutor.setNome("Manfred");
		instrutor.setNomePista("Red Baron");
		instrutor.setRg(222222222L);
		instrutor.setTituloEleitor(1244323L);
		instrutor.setAtivo(true);
		return instrutor;
	}

	public static Atendente populaAtendente() {
		Atendente atendente = new Atendente();
		atendente.setAlistamentoMilitar(123L);
		atendente.setCpf(34915298876L);
		atendente.setEscolaridade(Escolaridade.SUPERIOR);
		atendente.setId(1L);
		atendente.setNome("Manfred");
		atendente.setRg(222222222L);
		atendente.setTituloEleitor(1244323L);
		atendente.setAtivo(true);
		return atendente;
	}

	public static Socio populaSocio() {
		Socio socio = new Socio();
		socio.setAlistamentoMilitar(123L);
		socio.setCht(184L);
		socio.setCma(12L);
		socio.setCodigoANAC(1777L);
		socio.setCpf(34915298876L);
		socio.setEscolaridade(Escolaridade.SUPERIOR);
		socio.setId(1L);
		socio.setNome("Airton");
		socio.setNomePista("Airton");
		socio.setRg(222222222L);
		socio.setTituloEleitor(1244323L);
		socio.setAtivo(true);
		return socio;
	}

	public static Aeronave populaAeronave() {
		Aeronave aeronave = new Aeronave();
		aeronave.setApoliceSeguro("12443");
		aeronave.setCertificadoMatricula("PT-NXS");
		aeronave.setCheckList(true);
		aeronave.setDentel("123");
		aeronave.setDiarioBordo(true);
		aeronave.setFiam("1233");
		aeronave.setId(2L);
		aeronave.setManualVoo(true);
		aeronave.setMarca("Embraer");
		aeronave.setModelo("Tupi");
		aeronave.setNsca3_5(true);
		aeronave.setNsca3_7(true);
		aeronave.setFichaPesoBalanceamento(true);
		aeronave.setAtivo(true);
		aeronave.setMotivoInatividade("");
		return aeronave;
	}
}
