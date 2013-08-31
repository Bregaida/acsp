

describe("Testes do common-utils", function() {
    it("singular de aeronaves", function() {
        expect(getSingular("/acsp/aeronaves")).toBe("/acsp/aeronave");
    });

    it("singular de alunos", function(){
        expect(getSingular("/acsp/alunos")).toBe("/acsp/aluno");
    });

    it("singular de atendentes", function(){
        expect(getSingular("/acsp/atendentes")).toBe("/acsp/atendente");
    });

    it("singular de agendamentos", function(){
        expect(getSingular("/acsp/agendamentos")).toBe("/acsp/agendamento");
    });

    it("singular de aulas", function(){
        expect(getSingular("/acsp/aulas")).toBe("/acsp/aula");
    });

    it("singular de instrutores", function(){
        expect(getSingular("/acsp/instrutores")).toBe("/acsp/instrutor");
    });

    it("singular de pessoas", function(){
        expect(getSingular("/acsp/pessoas")).toBe("/acsp/pessoa");
    });

    it("singular de socios", function(){
        expect(getSingular("/acsp/socios")).toBe("/acsp/socio");
    });
});

