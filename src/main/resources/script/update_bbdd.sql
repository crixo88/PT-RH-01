-- Insertar países
INSERT INTO pais (id, nombre) VALUES (1, 'España');
INSERT INTO pais (id, nombre) VALUES (2, 'Inglaterra');
INSERT INTO pais (id, nombre) VALUES (3, 'Italia');
INSERT INTO pais (id, nombre) VALUES (4, 'Alemania');
INSERT INTO pais (id, nombre) VALUES (5, 'Francia');
INSERT INTO pais (id, nombre) VALUES (6, 'Portugal');
INSERT INTO pais (id, nombre) VALUES (7, 'Países Bajos');
INSERT INTO pais (id, nombre) VALUES (8, 'Escocia');
INSERT INTO pais (id, nombre) VALUES (9, 'Turquía');
INSERT INTO pais (id, nombre) VALUES (10, 'Rusia');

-- Insertar ligas
INSERT INTO liga (id, nombre, pais_id) VALUES (1, 'La Liga', 1);
INSERT INTO liga (id, nombre, pais_id) VALUES (2, 'Premier League', 2);
INSERT INTO liga (id, nombre, pais_id) VALUES (3, 'Serie A', 3);
INSERT INTO liga (id, nombre, pais_id) VALUES (4, 'Bundesliga', 4);
INSERT INTO liga (id, nombre, pais_id) VALUES (5, 'Ligue 1', 5);
INSERT INTO liga (id, nombre, pais_id) VALUES (6, 'Primeira Liga', 6);
INSERT INTO liga (id, nombre, pais_id) VALUES (7, 'Eredivisie', 7);
INSERT INTO liga (id, nombre, pais_id) VALUES (8, 'Scottish Premiership', 8);
INSERT INTO liga (id, nombre, pais_id) VALUES (9, 'Süper Lig', 9);
INSERT INTO liga (id, nombre, pais_id) VALUES (10, 'Premier League Rusa', 10);

-- Insertar equipos
INSERT INTO equipo (id, nombre, liga_id) VALUES (1, 'Real Madrid', 1);
INSERT INTO equipo (id, nombre, liga_id) VALUES (2, 'FC Barcelona', 1);
INSERT INTO equipo (id, nombre, liga_id) VALUES (3, 'Manchester United', 2);
INSERT INTO equipo (id, nombre, liga_id) VALUES (4, 'Liverpool FC', 2);
INSERT INTO equipo (id, nombre, liga_id) VALUES (5, 'Juventus FC', 3);
INSERT INTO equipo (id, nombre, liga_id) VALUES (6, 'AC Milan', 3);
INSERT INTO equipo (id, nombre, liga_id) VALUES (7, 'Bayern Munich', 4);
INSERT INTO equipo (id, nombre, liga_id) VALUES (8, 'Borussia Dortmund', 4);
INSERT INTO equipo (id, nombre, liga_id) VALUES (9, 'Paris Saint-Germain', 5);
INSERT INTO equipo (id, nombre, liga_id) VALUES (10, 'Olympique de Marseille', 5);
INSERT INTO equipo (id, nombre, liga_id) VALUES (11, 'FC Porto', 6);
INSERT INTO equipo (id, nombre, liga_id) VALUES (12, 'Sporting CP', 6);
INSERT INTO equipo (id, nombre, liga_id) VALUES (13, 'Ajax Amsterdam', 7);
INSERT INTO equipo (id, nombre, liga_id) VALUES (14, 'Feyenoord', 7);
INSERT INTO equipo (id, nombre, liga_id) VALUES (15, 'Celtic FC', 8);
INSERT INTO equipo (id, nombre, liga_id) VALUES (16, 'Rangers FC', 8);
INSERT INTO equipo (id, nombre, liga_id) VALUES (17, 'Galatasaray SK', 9);
INSERT INTO equipo (id, nombre, liga_id) VALUES (18, 'Fenerbahçe SK', 9);
INSERT INTO equipo (id, nombre, liga_id) VALUES (19, 'FC Zenit Saint Petersburg', 10);
INSERT INTO equipo (id, nombre, liga_id) VALUES (20, 'Spartak Moscow', 10);
INSERT INTO equipo (id, nombre, liga_id) VALUES (21, 'SL Benfica', 6);
INSERT INTO equipo (id, nombre, liga_id) VALUES (22, 'Besiktas JK', 9);
INSERT INTO equipo (id, nombre, liga_id) VALUES (23, 'SSC Napoli', 3);
INSERT INTO equipo (id, nombre, liga_id) VALUES (24, 'Atlético Madrid', 1);
