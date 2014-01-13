'use strict';

var app = angular.module("app", ['ngRoute', 'restangular', 'ui.bootstrap', 'ui.calendar']);

app.config(function ($routeProvider, RestangularProvider) {
    RestangularProvider.setBaseUrl('/acsp/');
});

app.controller('AgendamentosController', function ($scope, $http, $modal, Restangular) {
    var date = new Date();
    var d = date.getDate();
    var m = date.getMonth();
    var y = date.getFullYear();

    /* event source that pulls from google.com */
    $scope.eventSource = {
        url: "/acsp/agenda"
    };
    /* event source that contains custom events on the scope */
    $scope.events = [];

    /* event source that calls a function on every view switch */
    $scope.eventsF = [];

    $scope.calEventsExt = {
        color: '#f00',
        textColor: 'yellow',
        events: []
    };

    $scope.eventClick = function (event, jsEvent, view) {
        $scope.$apply(function () {
            console.log('Event Clicked ' + event.id + " [" + event.title + "]");
            $scope.load(event.id);
        });
    }

    /* alert on eventClick */
    $scope.alertDayOnClick = function (date, allDay, jsEvent, view) {
        $scope.$apply(function () {
            console.log('Day Clicked ' + date);
        });
        $scope.newAgendamento(date);
    };
    /* alert on Drop */
    $scope.alertOnDrop = function (event, dayDelta, minuteDelta, allDay, revertFunc, jsEvent, ui, view) {
        $scope.$apply(function () {
            console.log('Event Droped to make dayDelta ' + dayDelta);
        });
    };
    /* alert on Resize */
    $scope.alertOnResize = function (event, dayDelta, minuteDelta, revertFunc, jsEvent, ui, view) {
        $scope.$apply(function () {
            console.log('Event Resized to make dayDelta ' + minuteDelta);
        });
    };
    /* add and removes an event source of choice */
    $scope.addRemoveEventSource = function (sources, source) {
        var canAdd = 0;
        angular.forEach(sources, function (value, key) {
            if (sources[key] === source) {
                sources.splice(key, 1);
                canAdd = 1;
            }
        });
        if (canAdd === 0) {
            sources.push(source);
        }
    };
    /* add custom event*/
    $scope.addEvent = function () {
        $scope.events.push({
            title: 'Open Sesame',
            start: new Date(y, m, 28),
            end: new Date(y, m, 29),
            className: ['openSesame']
        });
    };
    /* remove event */
    $scope.remove = function (index) {
        $scope.events.splice(index, 1);
    };
    /* Change View */
    $scope.changeView = function (view, calendar) {
        calendar.fullCalendar('changeView', view);
    };
    /* Change View */
    $scope.renderCalender = function (calendar) {
        calendar.fullCalendar('render');
    };

    //$scope.calAgendamentos.fullCalendar
    $scope.eventSources = [$scope.events, $scope.eventSource, $scope.eventsF];

    $scope.uiConfig = {
        calendar: {
            defaultView: 'agendaDay',
            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'month,agendaWeek,agendaDay'
            },
            allDaySlot: false,
            allDayText: 'dia-todo',
            buttonText: {
                prev: '&lsaquo;', // <
                next: '&rsaquo;', // >
                prevYear: '&laquo;',  // <<
                nextYear: '&raquo;',  // >>
                today: 'hoje',
                month: 'mês',
                week: 'semana',
                day: 'dia'
            },
            editable: false,
            columnFormat: {
                month: 'ddd',    // Mon
                week: 'ddd d/M', // Mon 9/7
                day: 'dddd d/M'  // Monday 9/7
            },

            agenda: 'HH:mm{ - HH:mm}',
            timeFormat: 'HH:mm',
            axisFormat: 'HH:mm',

            height: 450,
            minTime: 0,
            maxTime: 22,

            monthNames: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho',
                'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
            monthNamesShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],

            dayNames: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado'],
            dayNamesShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab'],

            dayClick: $scope.alertDayOnClick,
            eventDrop: $scope.alertOnDrop,
            eventResize: $scope.alertOnResize,
            eventClick: $scope.eventClick
        }
    };

    $scope.newAgendamento = function (dateRef) {
        $scope.agendamento = {};
        $scope.agendamento.dataReserva = dateRef.toString('d/M/yyyy');
        $scope.agendamento.horario = {};
        $scope.agendamento.horario.horarioAgenda = dateRef.toString('HH:mm');
        var modalInstance = $modal.open({
            templateUrl: 'myModalContent.html',
            controller: ModalInstanceCtrl,
            resolve: {
                agendamento: function () {
                    return $scope.agendamento;
                },
                save: function () {
                    return $scope.save;
                }
            }
        });

        modalInstance.result.then(function (entity) {
            $scope.list();
        }, function () {
            $scope.agendamento = null;
        });
    };

    $scope.formataCPF = function (v) {
        v = v.replace(/\D/g, "");
        v = v.replace(/(\d{3})(\d)/, "$1.$2");
        v = v.replace(/(\d{3})(\d)/, "$1.$2");
        v = v.replace(/(\d{3})(\d{1,2})$/, "$1-$2");
        return v
    }

    $scope.aeronaveSelecionada = function (aeronaveId) {
        return ($scope.agendamento != undefined && $scope.agendamento.aeronave != undefined && aeronaveId === $scope.agendamento.aeronave.id);
    }

    $scope.aulaSelecionada = function (aulaId) {
        return ($scope.agendamento != undefined && $scope.agendamento.aula != undefined && aulaId === $scope.agendamento.aula.id);
    }

    $scope.instrutorSelecionado = function (instrutorId) {
        return ($scope.agendamento != undefined && $scope.agendamento.instrutor != undefined && instrutorId === $scope.agendamento.instrutor.id);
    }

    $scope.generateAlunoLabel = function (item) {
        return item.nome + " - " + item.nomePista + " [" + $scope.formataCPF(item.cpf) + "]";
    }

    $scope.generateAeronaveLabel = function (item) {
        return item.marca + " - " + item.modelo + " [" + item.certificadoMatricula + "]";
    }

    $scope.getAlunos = function (val) {
        return $http.get('/acsp/alunos', {
            params: {
                q: val
            }
        }).then(function (resp) {
                angular.forEach(resp.data, function (item) {
                    item.label = $scope.generateAlunoLabel(item);
                });
                return resp.data;
            });
    };

    $scope.loadAeronaves = function () {
        $http.get('/acsp/aeronaves').then(function (resp) {
            angular.forEach(resp.data, function (item) {
                item.label = $scope.generateAeronaveLabel(item);
            });
            $scope.aeronaves = resp.data;
        });
    };

    $scope.loadAulas = function () {
        $http.get('/acsp/aulas').success(function (data) {
            $scope.aulas = data;
        });
    };

    $scope.loadHorariosDisponiveis = function () {
        $http.get('/acsp/horarios').success(function (data) {
            $scope.horarios = data;
        });
    }

    $scope.loadInstrutores = function () {
        $http.get('/acsp/instrutores').success(function (data) {
            $scope.instrutores = data;
        });
    }

    $scope.loadHorarios = function () {
        $http.get('/acsp/horarios').success(function (data) {
            $scope.horarios = data;
        });
    }

    $scope.estaSelecionado = function (idEntidade, idOpcao) {
        return (idEntidade === idOpcao);
    };

    $scope.load = function (id) {

        Restangular.one('agendamento', id).get().then(function (entity) {
            $scope.agendamento = entity;
            $scope.agendamento.aluno.label = $scope.generateAlunoLabel($scope.agendamento.aluno);
            //$scope.agendamento.aeronave.label = $scope.generateAeronaveLabel($scope.agendamento.aeronave);

            var modalInstance = $modal.open({
                templateUrl: 'myModalContent.html',
                controller: ModalInstanceCtrl,
                resolve: {
                    agendamento: function () {
                        return $scope.agendamento;
                    },
                    aeronaves: function () {
                        return $scope.aeronaves;
                    }
                }
            });

            modalInstance.result.then(function (entity) {//When the modal closes with SAVE

            }, function () {//on dismiss
                $scope.agendamento = null;
            });
        });
    };

    var ModalInstanceCtrl = function ($scope, $modalInstance, agendamento) {

        $scope.agendamento = agendamento;

        $scope.saveAndClose = function (anEntity) {
            $scope.validation = null;
            $scope.agendamento = anEntity;
            Restangular.all('agendamento').post("agenda", anEntity).then(function () {
                $modalInstance.close(anEntity);
            }, function (error) {
                $scope.validation = error.data;
            });
        };

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };
});

app.controller('GenericController', function ($scope, $http, $modal, Restangular) {

    $scope.entityType = null;  //type will be aeronave, for example
    $scope.entitiesType = null; //type will be aeronaves, for example

    $scope.setEntitiesType = function (entitiesType) {
        $scope.entitiesType = entitiesType;
    }

    $scope.setEntityType = function (entityType) {
        $scope.entityType = entityType;
    }

    $scope.list = function () {
        $http.get('/acsp/' + $scope.entitiesType).success(function (data) {
            $scope.entities = data;
        });
    }

    $scope.loadEducationLevels = function () {
        $http.get('/acsp/escolaridades').success(function (data) {
            $scope.educationLevels = data;
        });
    }

    $scope.disable = function (id) {
        Restangular.one($scope.entityType, id).remove();
    }

    //TODO: create directive
    $scope.style = function (stat) {
        if (stat) {
            return "fa fa-check-circle-o fa-lg";
        }
        {
            return "fa fa-circle-o fa-lg";
        }
    };

    $scope.newEntity = function () {
        $scope.entity = null;
        var modalInstance = $modal.open({
            templateUrl: 'myModalContent.html',
            controller: ModalInstanceCtrl,
            resolve: {
                entity: function () {
                    return $scope.entity;
                },
                save: function () {
                    return $scope.save;
                },
                entityType: function () {
                    return $scope.entityType;
                }
            }
        });

        modalInstance.result.then(function (entity) {
            $scope.list();
        }, function () {
            $scope.entity = null;
        });
    };

    $scope.load = function (id) {

        Restangular.one($scope.entityType, id).get().then(function (entity) {
            $scope.entity = entity;

            var modalInstance = $modal.open({
                templateUrl: 'myModalContent.html',
                controller: ModalInstanceCtrl,
                resolve: {
                    entity: function () {
                        return entity;
                    },
                    entityType: function () {
                        return $scope.entityType;
                    }
                }
            });

            modalInstance.result.then(function (entity) {//When the modal closes with SAVE
                $scope.list();
            }, function () {//on dismiss
                $scope.entity = null;
            });
        });
    };

    var ModalInstanceCtrl = function ($scope, $modalInstance, entity, entityType) {

        $scope.entity = entity;

        $scope.saveAndClose = function (anEntity) {
            $scope.validation = null;
            $scope.entity = anEntity;
            Restangular.all(entityType).post(entityType, anEntity).then(function () {
                $modalInstance.close(anEntity);
            }, function (error) {
                $scope.validation = error.data;
            });
        };

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };

});

//Tem um controller a parte por causa do select.
// O select eh ligado usando entidades, então é um pouco mais complexo... por enquanto está bom assim.
app.controller('AulasController', function ($scope, $http, $modal, Restangular) {

    $scope.disable = function (id) {
        Restangular.one("aula", id).remove();
    };

    $scope.list = function () {
        $http.get('/acsp/aulas').success(function (data) {
            $scope.aulas = data;
            for (var i = 0; i < $scope.aulas.length; i++) {
                var aula = $scope.aulas[i];
                aula.planes = "";
                for (var p = 0; p < aula.aeronaves.length; p++) {
                    aula.planes = aula.planes + aula.aeronaves[p].certificadoMatricula + ", ";
                }
            }
        });
    }

    $scope.loadAeronaves = function () {
        $http.get('/acsp/aeronaves').success(function (data) {
            $scope.aeronaves = data;
            for (var i = 0; i < $scope.aeronaves.length; i++) {
                var plane = $scope.aeronaves[i];
                $scope.aeronaves[i].displayName = plane.certificadoMatricula + " - " + plane.marca + " " + plane.modelo;
            }
        });
    }

    $scope.load = function (id) {

        Restangular.one("aula", id).get().then(function (entity) {
            $scope.aula = entity;

            var modalInstance = $modal.open({
                templateUrl: 'myModalContent.html',
                controller: ModalInstanceCtrl,
                resolve: {
                    aula: function () {
                        return $scope.aula;
                    },
                    aeronaves: function () {
                        return $scope.aeronaves;
                    }
                }
            });

            modalInstance.result.then(function (entity) {//When the modal closes with SAVE
                $scope.list();
            }, function () {//on dismiss
                $scope.entity = null;
            });
        });
    };

    $scope.estaSelecionado = function (id) {
        for (var i = 0; i < $scope.aula.aeronaves.length; i++) {
            var aeronaveDaAula = $scope.aula.aeronaves[i];
            if (aeronaveDaAula.id == id) {
                return true;
            }
        }
        return false;
    };

    $scope.newEntity = function () {
        $scope.entity = null;
        var modalInstance = $modal.open({
            templateUrl: 'myModalContent.html',
            controller: ModalInstanceCtrl,
            resolve: {
                aula: function () {
                    return $scope.aula;
                },
                aeronaves: function () {
                    return $scope.aeronaves;
                }
            }
        });

        modalInstance.result.then(function (entity) {
            $scope.list();
        }, function () {
            $scope.entity = null;
        });
    };

    var ModalInstanceCtrl = function ($scope, $modalInstance, aula, aeronaves) {

        $scope.aula = aula;

        $scope.saveAndClose = function (anEntity) {
            $scope.validation = null;
            Restangular.all("aula").post("aula", anEntity).then(function () {
                $modalInstance.close(anEntity);
            }, function (error) {
                $scope.validation = error.data;
            });
        };

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };
});
