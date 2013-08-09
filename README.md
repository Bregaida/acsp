Projeto Open Source para o ACSP

Requisitos do Programa:

    Maven                          - OK
    Hibernate/JPA                  - OK
    Banco de Dados será PostgreSQL - OK
	Gerar as querys                - OK
	Gerar o Banco via Hibernate    - OK
    @autowired (remover new)
	Adicionar Spring
    Implementar segurança
	Criar Protótipos de Tela

Módulos CRUD:

    Cadastro de Aluno - Ok
    Cadastro de Instrutor - OK
    Cadastro de Atendente - OK
    Cadastro de Aeronave - OK
    Cadastro de Sócios - OK
    Pessoa (Classe Abstrata) - OK
	Agenda

    Agenda Regras para Agendar Horas de Vôo:
        Aluno só pode agendar horas de vôo do dia atual até no max 15 dias, ou seja do dia 01/07 até dia 14/07, do dia 15/07 até o dia 30, etc
        Os alunos só poderão agendar se a aeronave está disponível, caso contrário a aeronave não será nem listada na combo
        Se o aluno faltar na aula terá um alerta para um atendente e o aluno não poderá voar na próxima aula (ainda preciso ver se é essa a penalidade)
        Deverá exibir um combo para o aluno marcar o tipo de instrução que ele irá receber (Manobras Altas, TGL, Navegação, INVA)
        Opcional agendar com um instrutor, porém se o instrutor estiver agendado com alguém naquela hora ele não poderá ser agendado para o mesmo horário com mais ninguém
            Baseado no tipo de instrução, é carregada a lista de instrutores habilitados para aquela aula
            Caso ele marque um instrutor, o status ficará pendente e será enviado um aviso para o instrutor ou atendente aprovar
            Instrutor ficará indisponível neste caso para os demais alunos
            Deverá ser validado se o instrutor está capacitado de dar a aula, isto é, se suas horas de voo como instrutor atendem aquela aula.
                Regras
                    200 horas de voo de instrução, instrutor habilitado para aulas de manobras altas e TGLs
                    300 horas de voo de instrução, instrutor habilitado para aulas de Navegação
                    400 horas de voo de instrução, instrutor habilitado para aulas de INVA
        Aluno poderá desmarcar sua hora de vôo com no máximo um dia (24 hrs) de antecedência
        Aluno poderá agendar no máximo 3 horas de vôo em um dia, podendo ser horas seguidas (ex: 09:00 até 12:00) ou não (ex: 08:00 até 09:00 / 12:00 - 14:00)
            Deverá haver a opção 360 milhas, se o aluno marcar, poderá ser agendado mais de 3 horas, porém ficará com status de pendente até o atendente aprovar
        Dados na tela (Nome do Aluno (campo inalterável), combo com as Aeronaves, Dia/mês (máximo 15 dias do dia atual), Quantidade de horas (máximo 3 horas), checkbox 360 milhas, Combo com nomes dos instrutores disponíveis naquela hora, checkbox de comparecimento do aluno (apenas atendente visualiza))
        Perfil de aluno somente vê dias e horas disponiveis, ou seja, se a hora ou dia estiverem cheios ele não poderá agendar.
        Perfil de aluno somente verá suas horas de vôo, apenas atendentes e instrutores poderão visualizar todos os alunos nos dias e horas.
        Horário das 07:00 até 20:00 sendo que:
            ficará com status pendente e apenas atendentes e instrutores aprovarão
            Horas menores que 08:00 será alertado que as horas devem ser acordadas antes com instrutor e neste caso o campo instrutor será obrigatório
            Horas maiores que 16:00 será alertado que as horas devem ser acordadas antes com instrutor e neste caso o campo instrutor será obrigatório

    Filtros da Agenda para pesquisa:
        Por dia/mês
        Por nome
        Por nome de Pista
        Por Aeronave
        Por dia/mês + aeronave
        Nome + Aeronave
        Por número de Sócio
        Instrutor (apenas instrutores e atendentes poderão visualizar)
        Instrutor + aeronave (Apenas instrutores e atendentes)
        Aeronaves disponíveis no dia/mês (apenas instrutores e atendentes)
        360 milhas OBS: Alunos só verão seus registros, Atendentes e Instrutores verão todos os alunos agendados nos filtros de dia/mês
        Carregará na Tela: Dia/Mês, Nome de Pista, Aeronave, horário agendado (a ordem de exibição é sempre pela hora da menor até a maior), Instrutor, comparecimento, quantidade de horas agendadas para o período

    Atendentes
        Poderão agendar horas para os alunos ou desmarcar horas para os mesmos
        Cadastrarão alunos no sistema
        Poderão alterar os dados do Aluno nos campos não obrigatórios
        Poderão alterar disponibilidade das Aeronaves (obrigatório neste caso comentar o motivo: Manutenção, perda do equipamento, documentação)
        Atualiza quantidade de horas de instrução de um determinado instrutor

    Instrutores
        Poderão apenas visualizar horas agendadas com eles quando houver
        Poderão visualizar aeronaves disponíveis nos dias/mês
        Poderão visualizar quantas horas de vôo de instrução ele possui

    Administrador do Sistema
        Poderá visualizar tudo
        Poderá inativar alunos, sócios e disponibilidade de Aeronaves
