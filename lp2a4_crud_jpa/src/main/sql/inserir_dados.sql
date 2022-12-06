insert into disciplina (codigo, nome) values ('LP2A4', 'Linguagem de Programação 2');

insert into aluno (matricula, nome, endereco, data_ingresso) values ('SP98765', 'Dolores Duran', 'Rua Billy Blanco, 1, Rio de Janeiro, RJ', '2021-07-01');
insert into aluno (matricula, nome, endereco, data_ingresso) values ('SP10001', 'Catulo da Paixão Cearense', 'Rua Luar do Sertão, 1, São Paulo, SP', '2022-01-01');

insert into disciplinas_semestre(matricula, codigo) values ( 'SP98765', 'LP2A4');
insert into disciplinas_semestre(matricula, codigo) values ( 'SP10001', 'LP2A4');