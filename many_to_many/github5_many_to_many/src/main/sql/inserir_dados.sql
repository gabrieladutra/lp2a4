insert into disciplina (codigo, nome) values ('DCATV', 'Defesa contra as Artes das Trevas');

insert into aluno (matricula, nome, endereco, data_ingresso) values ('SP98765', 'Harry Potter', 'Hogwarts, 1, Londres, UK', '2021-07-01');
insert into aluno (matricula, nome, endereco, data_ingresso) values ('SP10001', 'Hermione Granger', 'King Lion Street, 1, Londres, UK', '2022-01-01');
insert into aluno (matricula, nome, endereco, data_ingresso) values ('SP10002', 'Ronald Weasley', 'Suprise Avenue, 1, Scotland, UK', '2022-01-01');

insert into disciplinas_semestre(matricula, codigo) values ( 'SP98765', 'DCATV');
insert into disciplinas_semestre(matricula, codigo) values ( 'SP10001', 'DCATV');
insert into disciplinas_semestre(matricula, codigo) values ( 'SP10002', 'DCATV');