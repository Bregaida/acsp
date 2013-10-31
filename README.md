Projeto Open Source para o ACSP
===============================

Requisitos do Programa:
* Banco de Dados oficial

Módulos CRUD:
-------------
Perfil - regras
* (Aluno e Sócio - Agendam horas de vôo e consultam apenas suas horas marcadas, podendo cancelar até 1 dia antes)
* (Intrutores - Visualizam seu cadastro, consultam horas de vôo no qual eles foram marcados)
* (Atendentes - Cadastram Alunos, Instrutores e outros Atendentes, aprovam ou reprovam horas marcadas, cancelam horas agendadas, ativam ou desativam aeronaves, instrutores, sócios e alunos, atualizam quantidades de horas de instrução dos instrutores)
	

Agenda Regras para Agendar Horas de Vôo:
----------------------------------------
- [x] Aluno só pode agendar horas de vôo do dia atual até no max 15 dias, ou seja do dia 01/07 até dia 14/07, do dia 15/07 até o dia 30, etc
  - [x] Horarios normais de agendamento 07:00, 09:00, 11:00, 13:00, 15:00, 17:00 (07:00 matutino especial, status pendente, 17:00 Noturno, status pendente)
- [ ] Aluno poderá agendar no máximo 3 horas de vôo em um dia, podendo ser horas seguidas (ex: 09:00 até 12:00) ou não (ex: 08:00 até 09:00 / 12:00 - 14:00)
  - [ ] Deverá haver a opção 360 milhas, se o aluno marcar, poderá ser agendado mais de 3 horas, porém ficará com status de pendente até o atendente aprovar
- [x] PARCIAL Os alunos só poderão agendar se a aeronave está disponível, caso contrário a aeronave não será nem listada na combo

- [ ] Combo opicional, deverá exibir um combo para o aluno marcar o tipo de instrução que ele irá receber (Manobras Altas, TGL, Navegação, INVA)
- [ ] Opcional agendar com um instrutor, porém se o instrutor estiver agendado com alguém naquela hora ele não poderá ser agendado para o mesmo horário com mais ninguém
- [ ] Baseado no tipo de instrução, é carregada a lista de instrutores habilitados para aquela aula, naquele horário e por aquela aeronave
  - [ ] Caso ele marque um instrutor, o status ficará pendente e será enviado um aviso para o atendente aprovar
  - [ ] Aluno seleciona aula e carrega a lista de instrutores para aquela aula:

Regras aula e instrutor
-----------------------
- [ ] 200 horas de voo de instrução, instrutor habilitado para aulas de manobras altas e TGLs
- [ ] 300 horas de voo de instrução, instrutor habilitado para aulas de Navegação
- [ ] 400 horas de voo de instrução, instrutor habilitado para aulas de INVA
- [ ] Aluno poderá desmarcar sua hora de vôo com no máximo um dia (24 hrs) de antecedência
  - [ ] Caso ele não cancele e falte, a punição é não poder agendar por 7 dias, ou seja, se ele tiver aulas agendadas deverão ser canceladas e o motivo ficará escrito (Falta na hora agendada)
  - [ ] O Atendente deverá sempre marcar a presença do aluno na agenda
- [ ] Perfil de aluno somente vê dias e horas disponiveis, ou seja, se a hora ou dia estiverem cheios ele não poderá agendar.
- [ ] Perfil de aluno somente verá suas horas de vôo, apenas atendentes e instrutores poderão visualizar todos os alunos nos dias e horas.

Atendentes
---------
- [ ] Poderão agendar horas para os alunos ou desmarcar horas para os mesmos
- [ ] Cadastrarão alunos no sistema
- [ ] Poderão alterar os dados do Aluno nos campos não obrigatórios
- [ ] Poderão alterar disponibilidade das Aeronaves (obrigatório neste caso comentar o motivo: Manutenção, perda do equipamento, documentação)
- [ ] Atualiza quantidade de horas de instrução de um determinado instrutor
  - [ ] Marcam a presença do aluno na aula (aparecerá para ele um check de presença nas horas do dia dos alunos que marcaram hora)

Instrutores
-----------
- [ ] Poderão apenas visualizar horas agendadas com eles quando houver
- [ ] Poderão visualizar quantas horas de vôo de instrução ele possui

Administrador do Sistema
------------------------
- [ ] Poderá visualizar tudo
- [ ] Poderá inativar alunos, sócios e disponibilidade de Aeronaves

Outros:
------
- [ ] Select status pendente (Filtro)
- [ ] Envia email (para instrutor e atendente)
- [ ] Grid pendentes aprovação tela principal (atendentes veem status pendente quando logan na tela principal)


**Este software é grátis e não deverá ser cobrado daqueles que o utilizarem, os créditos dos fontes devem ser mantidos.**